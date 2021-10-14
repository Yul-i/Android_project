package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class StarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        setTitle("STARBUCKS");

        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        //각 탭마다의 설정을 넣음
        TabHost.TabSpec tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈");
        tabSpecHome.setContent(R.id.tabHome);
        tabHost.addTab(tabSpecHome);
        TabHost.TabSpec tabSpecOrder = tabHost.newTabSpec("ORDER").setIndicator("주문");
        tabSpecOrder.setContent(R.id.tabOrder);
        tabHost.addTab(tabSpecOrder);
        TabHost.TabSpec tabSpecGift = tabHost.newTabSpec("GIFT").setIndicator("선물함");
        tabSpecGift.setContent(R.id.tabGift);
        tabHost.addTab(tabSpecGift);

        tabHost.setCurrentTab(0);
    }
}