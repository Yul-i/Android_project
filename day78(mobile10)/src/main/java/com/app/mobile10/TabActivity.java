package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //어디에 분리시켜놓은 layout파일을 넣을지 결정
        LinearLayout layout1 = findViewById(R.id.tabSong);
        LinearLayout layout2 = findViewById(R.id.tabArtist);
        LinearLayout layout3 = findViewById(R.id.tabAlbum);

        //분리 시켜놓은 xml파일들을 객체화 시키자!
        //inflation
        View songView = View.inflate(TabActivity.this, R.layout.song, null);
        View artistView = View.inflate(TabActivity.this, R.layout.artist, null);
        View albumView = View.inflate(TabActivity.this, R.layout.album, null);

        layout1.addView(songView);
        layout2.addView(artistView);
        layout3.addView(albumView);

        Button btnChange = songView.findViewById(R.id.btnChange);
        ImageView imageView = songView.findViewById(R.id.imageView1);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.muu);
            }
        });

        Button btnChange2 = artistView.findViewById(R.id.btnChange2);
        ImageView imageView2 = artistView.findViewById(R.id.imageView2);
        TextView text4 = artistView.findViewById(R.id.text4);

        btnChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageResource(R.drawable.wordcloud);
                text4.setText("텍스트가 바뀌었어용");
            }
        });

        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();//기초적인 tab 초기화!

        //각 탭마다의 설정을 넣음
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);//layout을 끼워넣음
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
}