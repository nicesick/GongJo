package com.example.serveriotcommunicationexcerise;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RealTimeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    RealTimeController realTimeController;
    TextView inFreshView,outFreshView,inTempView,outTempView,totalAirView,CO2View,dustView,ultraDustView,humidityView;
    View RealTimeRootView;

    boolean threadEndFlag;

    public RealTimeFragment() {
         realTimeController = new RealTimeController();
        // Required empty public constructor
    }


    private mapFragment.OnFragmentInteractionListener mListener;

    void setViewControl(){
         inFreshView = RealTimeRootView.findViewById(R.id.InFreshView);
         outFreshView = RealTimeRootView.findViewById(R.id.OutFreshView);
         inTempView  = RealTimeRootView.findViewById(R.id.InTemView);
         outTempView  = RealTimeRootView.findViewById(R.id.OutTemView);
         totalAirView = RealTimeRootView.findViewById(R.id.TotalAirView);
         CO2View = RealTimeRootView.findViewById(R.id.CO2View);
         dustView = RealTimeRootView.findViewById(R.id.FineDustView);
         ultraDustView = RealTimeRootView.findViewById(R.id.UltrafineDustView);
         humidityView = RealTimeRootView.findViewById(R.id.HumidityView);
    }

    class UpdateViewTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onProgressUpdate(Void... values) {
            setViews();
            Log.d("realTIme Thread",realTimeController.getInTpt()+"");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while(threadEndFlag){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress();
            }
            return null;
        }
        public void setViews(){
                setView(inFreshView,realTimeController.getInAir());
                setView(outFreshView,realTimeController.getOutAir());
                setView(inTempView,realTimeController.getInTpt());
                setView(outTempView,realTimeController.getOutTpt());
                setView(CO2View,realTimeController.getCO2());
                setView(dustView,realTimeController.getDust());
                setView(ultraDustView,realTimeController.getUltraDust());
                setView(humidityView,realTimeController.getHumidity());
            }
            public void setView(TextView textView,String string){
                if(textView!=null){
                    textView.setText(string);
                }
            }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RealTimeRootView = inflater.inflate(R.layout.fragment_real_time, container, false);
         setViewControl();
         totalAirView.setBackgroundResource(R.drawable.red);
        threadEndFlag = true;

        Log.d("realTIme Thread","ready");

        UpdateViewTask updateViewTask = new UpdateViewTask();
        updateViewTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        return RealTimeRootView;
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof mapFragment.OnFragmentInteractionListener) {
            mListener = (mapFragment.OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
