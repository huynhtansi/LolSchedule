package com.htsi.lolschedule;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by htsi.
 * Since: 2/24/17 on 3:56 PM
 * Project: LolSchedule
 */

public class SimpleTextAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private List<MenuItemData> mMenuItemDatas;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public static final int INDEX_SPEC = 9;
    private int mGravity;
    private int mResLayout;

    public SimpleTextAdapter(Context context, int resLayout, List<MenuItemData> menuItemDatas) {
        this(context, resLayout, menuItemDatas, Gravity.CENTER);
    }

    public SimpleTextAdapter(Context context, int resLayout, List<MenuItemData> menuItemDatas, int gravity) {
        mContext = context;
        mResLayout = resLayout;
        mLayoutInflater = LayoutInflater.from(context);
        mMenuItemDatas = menuItemDatas;
        mGravity = gravity;
    }

    @Override
    public int getCount() {
        return mMenuItemDatas == null ? 0 : mMenuItemDatas.size();
    }

    @Override
    public View getView(View parent, int position) {
        MenuItemData item = getItem(position);
        View root = mLayoutInflater.inflate(mResLayout, null, false);
        TextView textView = (TextView) root.findViewById(R.id.wheel_menu_item_tv);
        textView.setVisibility(View.VISIBLE);
        //textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setText(item.mTitle);
        if (textView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) textView.getLayoutParams()).gravity = mGravity;
        }
        if (position == INDEX_SPEC) {
            textView.setTextColor(ActivityCompat.getColor(mContext, R.color.colorAccent));

        }
        return root;
    }

    @Override
    public MenuItemData getItem(int position) {
        return mMenuItemDatas.get(position);
    }

}
