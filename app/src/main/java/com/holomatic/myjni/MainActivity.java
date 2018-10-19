package com.holomatic.myjni;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements INaviInfoCallback {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("result-lib");
    }


    private MyView mMyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(resultFromJNI());
        mMyView=(MyView) findViewById(R.id.MyView);

        mMyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng p3 = new LatLng(40.0420100000,116.5149300000);//比目鱼创业园
                LatLng p4 = new LatLng(39.773801, 116.368984);//新三余公园(南5环)
                LatLng p5 = new LatLng(40.041986, 116.414496);//立水桥(北5环)
                LatLng p6 = new LatLng(40.0656070000,116.6134730000);//首都T3
                Poi start = new Poi("比目鱼创业园", p3, "");//起点

                //<editor-fold desc="途径点">
//                List<Poi> poiList = new ArrayList();
//                poiList.add(new Poi("首开广场", p1, ""));
//                poiList.add(new Poi("故宫博物院", p2, ""));
//                poiList.add(new Poi("北京站", p3, ""));
                //</editor-fold>

                Poi end = new Poi("首都T3", p6, "");//终点
                AmapNaviParams amapNaviParams = new AmapNaviParams(start, null, end, AmapNaviType.DRIVER, AmapPageType.NAVI);
                amapNaviParams.setUseInnerVoice(true);
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), amapNaviParams, MainActivity.this);
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String resultFromJNI();


    private void setAnimation(final View view){
        ValueAnimator mValueAnimation=ValueAnimator.ofFloat(26,200);
        mValueAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value=(Float) valueAnimator.getAnimatedValue();
                view.animate().rotation(value).start();
            }
        });
    }


    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onGetNavigationText(String s) {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onArriveDestination(boolean b) {

    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onStopSpeaking() {

    }

    @Override
    public void onReCalculateRoute(int i) {

    }

    @Override
    public void onExitPage(int i) {

    }

    @Override
    public void onStrategyChanged(int i) {

    }

    @Override
    public View getCustomNaviBottomView() {
        return null;
    }

    @Override
    public View getCustomNaviView() {
        return null;
    }

    @Override
    public void onArrivedWayPoint(int i) {

    }
}
