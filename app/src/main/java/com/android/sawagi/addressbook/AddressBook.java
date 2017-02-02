package com.android.sawagi.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.sawagi.R;
import com.android.sawagi.adapter.AddressAdapter;

/**
 * Created by karan on 23/11/16.
 */

public class AddressBook extends Fragment implements View.OnClickListener {

    private ListView addressListView;
    private ImageView btnAdd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_book, container, false);

        //get Id of Declare variable
        addressListView = (ListView) view.findViewById(R.id.address_ListView);
        btnAdd = (ImageView) view.findViewById(R.id.address_btnAdd);

        //set Adapter
        addressListView.setAdapter(new AddressAdapter(getActivity()));

        //set Button OnClickListener
        btnAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.address_btnAdd:

                startActivity(new Intent(getActivity(), AddAddressScreen.class));

                break;
            default:
                break;
        }
    }
}
