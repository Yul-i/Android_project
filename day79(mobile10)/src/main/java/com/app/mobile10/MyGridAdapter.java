package com.app.mobile10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//기본 adapter는 arrayList, array의 데이터를 순서대로 넣어주는 기능만 있음.
//데이터 하나하나의 배치모양을 내가 정해서 어댑팅 할 수 있음
public class MyGridAdapter extends BaseAdapter {
    Context context; //액티비티를 값이 들어갈 객체!

    MyGridAdapter(Context context1){
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
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //gridView에 들어갈 하나하나의 layout을 만들어주는 메서드!
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       /* //gridView에 들어갈 이미지뷰 객체를 만들어주어야 한다.
        ImageView imageView = new ImageView(context);
        //크기....
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        //여백
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(posterID[i]);
        return imageView;*/

     /*   Button button = new Button(context);
        button.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        button.setPadding(5,5,5,5);
        button.setText("내가 반복"+i);
        return button;*/

        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        textView.setPadding(10, 10, 10, 10);
        textView.setText("반복됨"+i+"번");
        return textView;
    }
//기본 어탭터의 기능들을 내가 임의로 재정의해서 사용가능하다.


}