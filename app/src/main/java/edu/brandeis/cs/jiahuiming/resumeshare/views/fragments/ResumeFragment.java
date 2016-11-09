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
import edu.brandeis.cs.jiahuiming.resumeshare.views.activities.HomeActivity;
import edu.brandeis.cs.jiahuiming.resumeshare.views.widgets.WaveView;

/**
 * Created by Horace on 16/11/9.
 */
public class ResumeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mFragment = inflater.inflate(R.layout.fragment_resume, container, false);
        String currentAccount=((HomeActivity)getActivity()).getResumeAccount();
        Toast.makeText(getActivity(),currentAccount,Toast.LENGTH_LONG).show();

        return mFragment;
    }
}
