package com.jk.lazy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jk.lazy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment {


    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onLazyLoad() {
        Toast.makeText(getActivity(), "recommend", Toast.LENGTH_SHORT).show();
    }

}
