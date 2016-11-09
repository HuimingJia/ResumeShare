package edu.brandeis.cs.jiahuiming.resumeshare.views.fragments;


import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import edu.brandeis.cs.jiahuiming.resumeshare.R;
import edu.brandeis.cs.jiahuiming.resumeshare.utils.LocationUtil;
import edu.brandeis.cs.jiahuiming.resumeshare.views.widgets.WaveView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private WaveView mWaveView;
    private Button mButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mFragment = inflater.inflate(R.layout.fragment_home, container, false);
        mWaveView = (WaveView)mFragment.findViewById(R.id.waveview);
        mWaveView.setDuration(5000);
        mWaveView.setStyle(Paint.Style.FILL);
        mWaveView.setColor(Color.RED);
        mWaveView.setInterpolator(new LinearOutSlowInInterpolator());
        mButton = (Button)mFragment.findViewById(R.id.button1);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    mWaveView.start();
                    Log.d("Wave,","start");


                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mWaveView.stop();
                    Log.d("Wave,","stop");
                    LocationUtil locUtil=new LocationUtil(getActivity());
                    // Put your own click event here
                }
                return false;
            }
        });
        return mFragment;
    }

}