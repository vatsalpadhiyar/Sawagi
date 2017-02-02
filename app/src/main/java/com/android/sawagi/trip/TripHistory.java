package com.android.sawagi.trip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.sawagi.R;
import com.android.sawagi.adapter.TripAdapter;

/**
 * Created by karan on 23/11/16.
 */

public class TripHistory extends Fragment {

    private ListView tripListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trip_history, container, false);

        //get Id of Declare variable
        tripListView = (ListView) view.findViewById(R.id.trip_ListView);

        //set Adapter
        tripListView.setAdapter(new TripAdapter(getActivity()));


        return view;
    }

}
