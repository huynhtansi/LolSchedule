package com.htsi.lolschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleTextCursorWheelLayout wheelLayout = (SimpleTextCursorWheelLayout) findViewById(R.id.wheel);
        String[] res = new String[]{"AM", "PM", "AM", "PM", "AM", "PM", "AM", "PM"};
        List<MenuItemData> menuItemDatas = new ArrayList<MenuItemData>();
        for (int i = 0; i < res.length; i++) {
            menuItemDatas.add(new MenuItemData(res[i]));
        }
        SimpleTextAdapter simpleTextAdapter = new SimpleTextAdapter(this, R.layout.wheel_menu_item, menuItemDatas, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        wheelLayout.setAdapter(simpleTextAdapter);


        SimpleTextCursorWheelLayout wheelMinutes = (SimpleTextCursorWheelLayout) findViewById(R.id.wheelMinutes);
        List<MenuItemData> minutes = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            int temp = i%5;
            if (temp == 0)
                minutes.add(new MenuItemData(i<10?"0"+i:String.valueOf(i)));
        }
        SimpleTextAdapter minuteAdapter = new SimpleTextAdapter(this, R.layout.wheel_menu_item_minute, minutes, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        wheelMinutes.setAdapter(minuteAdapter);
    }
}
