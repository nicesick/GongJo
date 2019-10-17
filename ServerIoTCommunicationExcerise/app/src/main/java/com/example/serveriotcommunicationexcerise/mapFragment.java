package com.example.serveriotcommunicationexcerise;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link mapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class mapFragment extends Fragment {
    TMapView tMapView;
    LinearLayout linearLayout;
    boolean threadEndFlag;
    private OnFragmentInteractionListener mListener;

    public mapFragment() {
        threadEndFlag = true;
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tMapView = new TMapView(getActivity());

        View mapView = inflater.inflate(R.layout.fragment_map, container, false);

        linearLayout = mapView.findViewById(R.id.mapLayout);
        tMapView.setSKTMapApiKey("8a7cffe8-176c-43ed-ba28-6b56639f9b6c");
        linearLayout.addView(tMapView);
        MapUpdateTask mapUpdateTask = new MapUpdateTask();
        mapUpdateTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        return mapView;
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
        super.onDestroyView();
    }

    class MapUpdateTask extends AsyncTask<Void,Void,Void> implements LocationListener{
        LocationManager locationManager;
//        GPSListener gpsListener;
        Location location;

        public MapUpdateTask() {
            locationManager = (LocationManager)getActivity().getSystemService(getContext().LOCATION_SERVICE);
//            gpsListener = new GPSListener();
            Log.d("GPS is ", String.valueOf(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)));
            Log.d("network is ", String.valueOf(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)));

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            if(getActivity() == null) return;
            int permission = PermissionChecker.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
            if(permission == PackageManager.PERMISSION_GRANTED){
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,gpsListener);
//
//                Log.d("loc","lat : " + gpsListener.getLat() + ", long : " + gpsListener.getLon());
//
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10,0,this);
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10,0,this);
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location==null){
                    Log.d("location","GPS is null");
                    location = locationManager.getLastKnownLocation(LocationManager.    NETWORK_PROVIDER);
                    if(location==null){
                        Log.d("location","network is null");
                    }
                    else {
                        Log.d("network loc is ", location.getLongitude()+"lac is "+location.getLatitude());
                        tMapView.setCenterPoint(location.getLongitude(),location.getLatitude(),true);
                    }
                }
                else{
                    Log.d("GPS loc is ", location.getLongitude()+"lac is "+location.getLatitude());
                    tMapView.setCenterPoint(location.getLongitude(),location.getLatitude(),true);
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
