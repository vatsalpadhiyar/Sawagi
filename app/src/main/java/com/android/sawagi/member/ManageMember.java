package com.android.sawagi.member;

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
import com.android.sawagi.adapter.MemberAdapter;

/**
 * Created by karan on 23/11/16.
 */

public class ManageMember extends Fragment implements View.OnClickListener {

    private ListView memberListView;
    private ImageView btnAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manage_member, container, false);

        //get Id of Declare variable
        memberListView = (ListView) view.findViewById(R.id.member_ListView);
        btnAdd = (ImageView) view.findViewById(R.id.member_btnAdd);

        //set Adapter
        memberListView.setAdapter(new MemberAdapter(getActivity()));

        //set Button OnClickListener
        btnAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.member_btnAdd:

                Intent in = new Intent(getActivity(), AddMemberScreen.class);
                in.putExtra("Type", "Add Member");
                startActivity(in);

                break;
            default:
                break;
        }
    }
}
