package com.example.serveriotcommunicationexcerise;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ConsumableFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    boolean threadEndFlag;
    SimpleDateFormat dateFormat;
    ConsumableController consumableController;
    View consumableView;
    UpdateViewTask1 updateViewTask1;

    public ConsumableFragment() {

        consumableController = new ConsumableController();
        // Required empty public constructor
    }
    final String ENOUGH = "여유";
    final String BELOW_DOWN = "부족";
    final String DANGER = "위험";
    final int FILTER_REPLACE_STANDARD1 = 30,FILTER_REPLACE_STANDARD2=10;
    final int ENGINE_OIL_REPLACE_STANDARD1 = 30,ENGINE_OIL_REPLACE_STANDARD2=10;
    final int BREAK_OIL_REPLACE_STANDARD1 = 30,BREAK_OIL_REPLACE_STANDARD2=10;
    final int GEAR_OIL_REPLACE_STANDARD1 = 30,GEAR_OIL_REPLACE_STANDARD2=10;
    final int COOLING_WATER_REPLACE_STANDARD1 = 30,COOLING_WATER_REPLACE_STANDARD2=10;


    TextView filterRemainView,filterReplacementDateView,filterReplacementView,filterReplacementAlarmView;
    TextView engineOilRemainView,engineOilReplacementDateView,engineOilReplacementView,engineOilReplacementAlarmView;
    TextView breakOilRemainView,breakOilReplacementDateView,breakOilReplacementView,breakOilReplacementAlarmView;
    TextView gearOilRemainView,gearOilReplacementDateView,gearOilReplacementView,gearOilReplacementAlarmView;
    TextView coolingWaterRemainView,coolingWaterReplacementDateView,coolingWaterReplacementView,coolingWaterReplacementAlarmView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        consumableView  = inflater.inflate(R.layout.fragment_comsumable, container, false);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        threadEndFlag = true;


        setViewControl();
        updateViewTask1 = new UpdateViewTask1();
        updateViewTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        return consumableView;
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
        if(!updateViewTask1.isCancelled()) updateViewTask1.cancel(true);
        super.onDestroyView();
    }

    void setViewControl(){
        filterRemainView = consumableView.findViewById(R.id.FilterRemainView);
        filterReplacementAlarmView = consumableView.findViewById(R.id.FilterReplacementAlarmView);
        filterReplacementDateView = consumableView.findViewById(R.id.FilterReplacementDateView);
        filterReplacementView = consumableView.findViewById(R.id.FilterReplacementView);

        engineOilRemainView = consumableView.findViewById(R.id.EngineOilRemainView);
        engineOilReplacementAlarmView = consumableView.findViewById(R.id.EngineOilReplacementAlarmView);
        engineOilReplacementDateView = consumableView.findViewById(R.id.EngineOilReplacementDateView);
        engineOilReplacementView = consumableView.findViewById(R.id.EngineOilReplacementView);

        breakOilRemainView = consumableView.findViewById(R.id.BreakOilRemainView);
        breakOilReplacementAlarmView = consumableView.findViewById(R.id.BreakOilReplacementAlarmView);
        breakOilReplacementDateView = consumableView.findViewById(R.id.BreakOilReplacementDateView);
        breakOilReplacementView = consumableView.findViewById(R.id.BreakOilReplacementView);

        gearOilRemainView = consumableView.findViewById(R.id.GearOilRemainView);
        gearOilReplacementAlarmView = consumableView.findViewById(R.id.GearOilReplacementAlarmView);
        gearOilReplacementDateView = consumableView.findViewById(R.id.GearOilReplacementDateView);
        gearOilReplacementView = consumableView.findViewById(R.id.GearOilReplacementView);

        coolingWaterRemainView = consumableView.findViewById(R.id.CoolingWaterRemainView);
        coolingWaterReplacementAlarmView = consumableView.findViewById(R.id.CoolingWaterReplacementAlarmView);
        coolingWaterReplacementDateView = consumableView.findViewById(R.id.CoolingWaterReplacementDateView);
        coolingWaterReplacementView = consumableView.findViewById(R.id.CoolingWaterReplacementView);

    }
    class UpdateViewTask1 extends AsyncTask<Void, Void, Void> {
        Date date;
        String remainTemp;

        @Override
        protected void onProgressUpdate(Void... values) {
            setViews();
//            setExampleRemainValue();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while(threadEndFlag){
                publishProgress();
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        void setExampleRemainValue(){
            consumableController.setCar_cool_water((Integer.parseInt(consumableController.getCar_cool_water())-1)+"");
            consumableController.setCar_eng_oil((Integer.parseInt(consumableController.getCar_eng_oil())-1)+"");
            consumableController.setCar_break_oil((Integer.parseInt(consumableController.getCar_break_oil())-1)+"");
            consumableController.setCar_accOil((Integer.parseInt(consumableController.getCar_accOil())-1)+"");
            consumableController.setCar_filter((Integer.parseInt(consumableController.getCar_filter())-1)+"");

        }
        public void setViews(){
            setRemainView(filterRemainView,consumableController.getCar_filter());
            setRemainView(engineOilRemainView,consumableController.getCar_eng_oil());
            setRemainView(breakOilRemainView,consumableController.getCar_break_oil());
            setRemainView(gearOilRemainView,consumableController.getCar_accOil());
            setRemainView(coolingWaterRemainView,consumableController.getCar_cool_water());
        }

        public void setRemainView(TextView textView,String value){
            if(textView!=null){
                remainTemp = textView.getText().toString();


                    date = new Date();
                    switch (textView.getId()){
                        case R.id.FilterRemainView:
                            if(Integer.parseInt(remainTemp)+5 < Integer.parseInt(value)) {
                                filterReplacementDateView.setText(dateFormat.format(date));
                            }
                            setReplaceOrderView(filterReplacementView,FILTER_REPLACE_STANDARD1,FILTER_REPLACE_STANDARD2,Integer.parseInt(value));
                            break;
                        case R.id.EngineOilRemainView:
                            if(Integer.parseInt(remainTemp)+5 < Integer.parseInt(value)) {
                                engineOilReplacementDateView.setText(dateFormat.format(date));
                            }
                            setReplaceOrderView(engineOilReplacementView,ENGINE_OIL_REPLACE_STANDARD1,ENGINE_OIL_REPLACE_STANDARD2,Integer.parseInt(value));
                            break;
                        case R.id.BreakOilRemainView:
                            if(Integer.parseInt(remainTemp)+5 < Integer.parseInt(value)) {
                                breakOilReplacementDateView.setText(dateFormat.format(date));
                            }
                            setReplaceOrderView(breakOilReplacementView,BREAK_OIL_REPLACE_STANDARD1,BREAK_OIL_REPLACE_STANDARD2,Integer.parseInt(value));
                            break;
                        case R.id.GearOilRemainView:
                            if(Integer.parseInt(remainTemp)+5 < Integer.parseInt(value)) {
                                gearOilReplacementDateView.setText(dateFormat.format(date));
                            }
                            setReplaceOrderView(gearOilReplacementView,GEAR_OIL_REPLACE_STANDARD1,GEAR_OIL_REPLACE_STANDARD2,Integer.parseInt(value));
                            break;
                        case R.id.CoolingWaterRemainView:
                            if(Integer.parseInt(remainTemp)+5 < Integer.parseInt(value)) {
                                coolingWaterReplacementDateView.setText(dateFormat.format(date));
                            }
                            setReplaceOrderView(coolingWaterReplacementView,COOLING_WATER_REPLACE_STANDARD1,COOLING_WATER_REPLACE_STANDARD2,Integer.parseInt(value));
                            break;

                }
                textView.setText(value);
            }
        }

        public void setReplaceOrderView(TextView textView, int standard1,int standard2,int val){
            if(val > standard1){
                textView.setText(ENOUGH);
                textView.setTextColor(Color.GREEN);
            } else if (val > standard2) {
                textView.setText(BELOW_DOWN);
                textView.setTextColor(Color.YELLOW);
            }
            else{
                textView.setText(DANGER);
                textView.setTextColor(Color.RED);
            }
        }
    }

}
