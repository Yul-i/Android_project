package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class GridActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_background);
        setTitle("그리드뷰 영화 포스");
        //그리드 뷰에, 데이터들을 넣어보자.!
        //그리드 뷰
        GridView gv = findViewById(R.id.gridView1);

        //데이터들
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv.setAdapter(gridAdapter);
    }

    //기본 adapter는 arraylist, array의 데이터를 순서대로 넣어주는 기능만 있음.
    //데이터 하나 하나의 배치모양을 내가 정해서 어댑팅할 수 있음.
}