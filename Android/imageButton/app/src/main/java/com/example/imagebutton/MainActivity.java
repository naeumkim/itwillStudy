package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //이미지뷰 버튼을 클릭했을 때 호출되는 메소드로 버튼을 클릭하면 토스트 메세지를 출력하게 하자
    public void onClick(View view){
        Toast.makeText(
                getApplicationContext(),
                "버튼을 클릭했습니다.",
                Toast.LENGTH_SHORT

        ).show();


    }




}