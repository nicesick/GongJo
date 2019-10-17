package com.example.serveriotcommunicationexcerise;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class comsumableFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public comsumableFragment() {

        // Required empty public constructor
    }
    TextView filterRemainView,filterReplacementDateView,filterReplacementView,filterReplacementAlarmView;
    TextView engineOilRemainView,engineOilReplacementDateView,engineOilReplacementView,engineOilReplacementAlarmView;
    TextView breakOilRemainView,breakOilReplacementDateView,breakOilReplacementView,breakOilReplacementAlarmView;
    TextView gearOilRemainView,gearOilReplacementDateView,gearOilReplacementView,gearOilReplacementAlarmView;
    TextView coolingWaterRemainView,coolingWaterReplacementDateView,coolingWaterReplacementView,coolingWaterReplacementAlarmView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setViewControl();

        return inflater.inflate(R.layout.fragment_comsumable, container, false);
    }
    void setViewControl(){
        filterRemainView = getActivity().findViewById(R.id.FilterRemainView);
        filterReplacementAlarmView = getActivity().findViewById(R.id.FilterReplacementAlarmView);
        filterReplacementDateView = getActivity().findViewById(R.id.FilterReplacementDateView);
        filterReplacementView = getActivity().findViewById(R.id.FilterReplacementView);

        engineOilRemainView = getActivity().findViewById(R.id.EngineOilRemainView);
        engineOilReplacementAlarmView = getActivity().findViewById(R.id.EngineOilReplacementAlarmView);
        engineOilReplacementDateView = getActivity().findViewById(R.id.EngineOilReplacementDateView);
        engineOilReplacementView = getActivity().findViewById(R.id.EngineOilReplacementView);

        breakOilRemainView = getActivity().findViewById(R.id.BreakOilRemainView);
        breakOilReplacementAlarmView = getActivity().findViewById(R.id.BreakOilReplacementAlarmView);
        breakOilReplacementDateView = getActivity().findViewById(R.id.BreakOilReplacementDateView);
        breakOilReplacementView = getActivity().findViewById(R.id.BreakOilReplacementView);

        gearOilRemainView = getActivity().findViewById(R.id.GearOilRemainView);
        gearOilReplacementAlarmView = getActivity().findViewById(R.id.GearOilReplacementAlarmView);
        gearOilReplacementDateView = getActivity().findViewById(R.id.GearOilReplacementDateView);
        gearOilReplacementView = getActivity().findViewById(R.id.GearOilReplacementView);

        coolingWaterRemainView = getActivity().findViewById(R.id.CoolingWaterRemainView);
        coolingWaterReplacementAlarmView = getActivity().findViewById(R.id.CoolingWaterReplacementAlarmView);
        coolingWaterReplacementDateView = getActivity().findViewById(R.id.CoolingWaterReplacementDateView);
        coolingWaterReplacementView = getActivity().findViewById(R.id.CoolingWaterReplacementView);

    }


}
