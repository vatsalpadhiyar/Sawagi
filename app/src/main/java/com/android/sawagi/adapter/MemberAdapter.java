package com.android.sawagi.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.sawagi.R;
import com.android.sawagi.SplashScreen;
import com.android.sawagi.member.AddMemberScreen;

/**
 * Created by karan on 23/11/16.
 */

public class MemberAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    private Activity mActivity;
    private PopupWindow mDropdown = null;
    private int curPosition = 0;

    public MemberAdapter(Activity activity) {

        this.mActivity = activity;
        mInflater = (LayoutInflater) this.mActivity.getApplicationContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        final ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.member_list_item, null);

            holder = new ViewHolder();
            holder.profileImage = (ImageView) convertView.findViewById(R.id.member_list_profileImage);
            holder.imageMore = (ImageView) convertView.findViewById(R.id.member_list_imageMore);
            holder.txtName = (TextView) convertView.findViewById(R.id.member_list_txtName);
            holder.txtPosition = (TextView) convertView.findViewById(R.id.member_list_txtPosition);
            holder.btnMore = (LinearLayout) convertView.findViewById(R.id.member_list_btnMore);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Apply font to TextView
        holder.txtName.setTypeface(SplashScreen.Roboto_Regular);
        holder.txtPosition.setTypeface(SplashScreen.Roboto_Regular);

        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mDropdown != null) {
                    if (mDropdown.isShowing()) {
                        if (curPosition == position) {
                            mDropdown.dismiss();
                        } else {
                            mDropdown.dismiss();
                            showPopup(holder.imageMore);
                        }
                    } else {
                        showPopup(holder.imageMore);
                    }
                } else {
                    showPopup(holder.imageMore);
                }

                curPosition = position;
            }
        });

        return convertView;
    }

    public void showPopup(ImageView button) {

        try {

            mInflater = (LayoutInflater) mActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = mInflater.inflate(R.layout.more_popup_menu, null);

            LinearLayout btnSetAdmin = (LinearLayout) layout.findViewById(R.id.popup_layoutAdmin);
            LinearLayout btnEdit = (LinearLayout) layout.findViewById(R.id.popup_layoutEdit);
            LinearLayout btnRemove = (LinearLayout) layout.findViewById(R.id.popup_layoutRemove);
            TextView txtAdmin = (TextView) layout.findViewById(R.id.popup_txtAdmin);
            TextView txtEdit = (TextView) layout.findViewById(R.id.popup_txtEdit);
            TextView txtRemove = (TextView) layout.findViewById(R.id.popup_txtRemove);

            //set Typeface
            txtAdmin.setTypeface(SplashScreen.Roboto_Regular);
            txtEdit.setTypeface(SplashScreen.Roboto_Regular);
            txtRemove.setTypeface(SplashScreen.Roboto_Regular);

            layout.measure(View.MeasureSpec.UNSPECIFIED,
                    View.MeasureSpec.UNSPECIFIED);

            btnSetAdmin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(mActivity, AddMemberScreen.class);
                    in.putExtra("Type", "Edit Member");
                    mActivity.startActivity(in);
                }
            });

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mActivity);

                    // Setting Dialog Message
                    alertDialog.setMessage("Are you sure want to remove person from your member list?");

                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });

                    alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                }
            });

            mDropdown = new PopupWindow(layout, LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, false);
            //mDropdown.setAnimationStyle(R.style.AnimationPopup);
            mDropdown.showAsDropDown(button, 0, 10);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class ViewHolder {

        ImageView profileImage, imageMore;
        TextView txtName, txtPosition;
        LinearLayout btnMore;
    }

}
