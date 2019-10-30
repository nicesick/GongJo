package com.example.serveriotcommunicationexcerise;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {
    TMapView tMapView;
    LinearLayout linearLayout;
    boolean threadEndFlag;
    private OnFragmentInteractionListener mListener;
    MapUpdateTask mapUpdateTask;
    TMapPoint tMapPoint;
    TMapMarkerItem tMapMarkerItem;
    View mapView;
    LocationResgist locationResgist;
    public MapFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mapView = inflater.inflate(R.layout.fragment_map, container, false);
        tMapSetting();
        threadEndFlag = true;
        linearLayout = mapView.findViewById(R.id.mapLayout);
        linearLayout.addView(tMapView);

        locationResgist = new LocationResgist();

        mapUpdateTask = new MapUpdateTask();
        mapUpdateTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        return mapView;
    }
    void tMapSetting(){
        tMapView = new TMapView(getActivity());
        tMapView.setSKTMapApiKey("8a7cffe8-176c-43ed-ba28-6b56639f9b6c");
        tMapMarkerItem = new TMapMarkerItem();
        tMapMarkerItem.setName("현재 위치");
        tMapMarkerItem.setVisible(TMapMarkerItem.VISIBLE);
        tMapPoint = tMapView.getCenterPoint();
        tMapMarkerItem.setTMapPoint(tMapPoint);
        tMapView.setZoomLevel(16);
        tMapView.addMarkerItem("center",tMapMarkerItem);
    }
    /**
     * Called when the view previously created by {@link #onCreateView} has
     * been detached from the fragment.  The next time the fragment needs
     * to be displayed, a new view will be created.  This is called
     * after {@link #onStop()} and before {@link #onDestroy()}.  It is called
     * <em>regardless</em> of whether {@link #onCreateView} returned a
     * non-null view.  Internally it is called after the view's state has
     * been saved but before it has been removed from its parent.
     */
    @Override
    public void onDestroyView() {
        threadEndFlag = false;
        if(!mapUpdateTask.isCancelled()) mapUpdateTask.cancel(true);
        super.onDestroyView();
    }

    class MapUpdateTask extends AsyncTask<Void,Void,Void> implements LocationListener{
        final double LAT_RANGER = 0.00001;
        final double LON_RANGER = 0.00001;

        LocationManager locationManager;
//        GPSListener gpsListener;
        ArrayList<com.example.serveriotcommunicationexcerise.Location> dangerList;
        public MapUpdateTask() {
            locationManager = (LocationManager)getActivity().getSystemService(getContext().LOCATION_SERVICE);
//            gpsListener = new GPSListener();
            Log.d("GPS is ", String.valueOf(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)));
            Log.d("network is ", String.valueOf(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)));
            dangerList = locationResgist.getLocationsList();
        }
        boolean isInDangerArea(ArrayList<com.example.serveriotcommunicationexcerise.Location> locationList, double lat, double lon){
            for(com.example.serveriotcommunicationexcerise.Location location:locationList){
                if(Math.abs(location.getLat() - lat) < LAT_RANGER && Math.abs(location.getLon()-lon) < LON_RANGER ) return true;
            }
            return false;
        }
        void setCenterView(Location location){
            tMapView.setCenterPoint(location.getLongitude(),location.getLatitude(),false);
            tMapPoint = tMapView.getCenterPoint();
            tMapMarkerItem = new TMapMarkerItem();
            tMapMarkerItem.setTMapPoint(tMapPoint);
            tMapMarkerItem.setVisible(TMapMarkerItem.VISIBLE);
            tMapView.addMarkerItem("center",tMapMarkerItem);
            tMapView.setCenterPoint(location.getLongitude(),location.getLatitude()-0.001,false);
            Log.d("LOCATION","update");
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            int permission = PermissionChecker.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
            dangerList = locationResgist.getLocationsList();
            if(permission == PackageManager.PERMISSION_GRANTED){
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,gpsListener);
//
//                Log.d("loc","lat : " + gpsListener.getLat() + ", long : " + gpsListener.getLon());
//
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10,0,this);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10,0,this);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location==null){
                    Log.d("location","GPS is null");
                    location = locationManager.getLastKnownLocation(LocationManager.    NETWORK_PROVIDER);
                    if(location==null){
                        Log.d("location","network is null");
                    }
                    else {
                        Log.d("network loc is ", location.getLongitude()+"lac is "+location.getLatitude());
                        setCenterView(location);
                        if(isInDangerArea(dangerList,location.getLatitude(),location.getLongitude())){

                        }
                    }
                }
                else{
                    Log.d("GPS loc is ", location.getLongitude()+"lac is "+location.getLatitude());
                    setCenterView(location);
                }
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while(threadEndFlag){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress();
            }
            return null;
        }

        @Override
        public void onLocationChanged(Location location) {

        }

        /**
         * @param s
         * @param i
         * @param bundle
         * @deprecated
         */
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }
//    class GPSListener implements LocationListener{
//        double lat,lon;
//
//        public double getLat() {
//            return lat;
//        }
//
//        public double getLon() {
//            return lon;
//        }
//
//        @Override
//        public void onLocationChanged(Location location) {
//            lat = location.getLatitude();
//            lon = location.getLongitude();
//        }
//
//        @Override
//        public void onStatusChanged(String s, int i, Bundle bundle) {
//
//        }
//
//        @Override
//        public void onProviderEnabled(String s) {
//
//        }
//
//        @Override
//        public void onProviderDisabled(String s) {
//
//        }
//    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
