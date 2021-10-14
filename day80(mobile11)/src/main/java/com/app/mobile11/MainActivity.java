package com.app.mobile11;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect, btnDelete, btnUpdate;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);

        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        myDBHelper = new MyDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();//stream을 가져와라 쓸수있는 스트림!
                myDBHelper.onUpgrade(sqlDB, 1, 2);//1,2는 아무거나 써준거
                Log.d("sqlite3DDL", "DDL 호출");
                sqlDB.close();//Stream 닫아주기
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                String sql = "insert into groupTBL2 values ('"+name+"','"+number+"');";
                sqlDB.execSQL(sql);
                Log.d("sqlite3DML", "데이터 삽입 성공");

                sqlDB.close();
                Log.d("sqlite3DML", "데이터베이스 Closed");
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL2;", null);

                String strNames = "그룹이름" + "\r\n" + "------" + "\r\n";
                String strNumber = "인원" + "\r\n" + "------" + "\r\n";

                while(cursor.moveToNext()){
                    strNames += cursor.getString(0)+"\r\n";
                    strNumber += cursor.getString(1)+"\r\n";
                }

                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumber);

                cursor.close();
                sqlDB.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String sql = "delete from groupTBL2 where gName = '"+name+"'";
                sqlDB.execSQL(sql);
                Log.d("sqlite3DML", "데이터 삭제 성공");

                sqlDB.close();
                Log.d("sqlite3DML", "데이터베이스 Closed");
                edtName.setText("");
                edtNumber.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                String sql = "update groupTBL2 set gNumber = '"+number+"' where gName = '"+name+"'";
                sqlDB.execSQL(sql);
                Log.d("sqlite3DML", "데이터 수정 성공");

                sqlDB.close();
                Log.d("sqlite3DML", "데이터베이스 Closed");
            }
        });
    }
}