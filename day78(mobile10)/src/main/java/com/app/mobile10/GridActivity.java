package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_background);
        setTitle("그리드뷰 영화 포스터");
        //그리드 뷰에, 데이터들을 넣어보자.
        //그리드 뷰
        GridView gv=findViewById(R.id.gridView1);
        //데이터들
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gv.setAdapter(gridAdapter);
    }

    //기본 adapter는 arrayList, array의 데이터를 순서대로 넣어주는 기능만 있음.
    //데이터 하나하나의 배치모양을 내가 정해서 어댑팅 할 수 있음
    public class MyGridAdapter extends BaseAdapter{
        Context context; //액티비티를 값이 들어갈 객체!
        public MyGridAdapter(Context context1){
            context = context1;
        }

        int[] posterID = {
                R.drawable.mov01,
                R.drawable.mov02,
                R.drawable.mov03,
                R.drawable.mov04,
                R.drawable.mov05,
                R.drawable.mov06,
                R.drawable.mov07,
                R.drawable.mov08,
                R.drawable.mov09
        };

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            ImageView imageView = new ImageView(context);
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            Button button = new Button(context);
            return null;
        }
        //기본 어댑터의 기능들을 내가 임의로 재정의해서 사용 가능하다.
    }
}