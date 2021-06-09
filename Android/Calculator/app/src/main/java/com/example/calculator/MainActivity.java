package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //activity_main.xml의 EditText태그들(클래스)에 대한 객체를 생성하여 저장할 변수들 선언
    private EditText edit1,edit2,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //안드로이드 앱의 메인화면의 화면을 R클래스와 layout내부 클래스 안에 있는 activity_main 상수값을 이용하여 설정 할 수 있다.

        setContentView(R.layout.activity_main);
        //R클래스 내부에 id클래스 내부에 editText1상수값을 findViewByid() 메소드 호출시 매개변수로 전달하면
        //activity_main.xml파일의 <EditText>태그(클래스)에 대한 객체를 생성하여 반환 받을 수 있다.

        edit1 = (EditText)findViewById(R.id.editText1); //첫번째 EditText객체를 불러온다
        edit2 = (EditText)findViewById(R.id.editText2); //숫자1을 입력할 수 있는 EditText객체를 반환받는다
        result = (EditText)findViewById(R.id.editText3); //계산된 결과를 보여주는 객체를 반환

    }//onCreate

    //+버튼을 클릭했을때 호출되는 메소드
    public void add(View target){

        //숫자1을 입력할 수 있는 EditText위젯에 입력받은 숫자를 문자열로 반환해서 얻기
        String n1 = edit1.getText().toString();
        //숫자2를 입력할 수 있는 EditText위젯에 입력받은 숫자를 문자열로 변환해서 얻기
        String n2 = edit2.getText().toString();

        //입력한 숫자1과 2의 값을 + 연산한 정수값 얻기
        int  r = Integer.parseInt(n1) + Integer.parseInt(n2);

        //세번째 EditText위젯에 계산된 결과값 문자열로 설정
        result.setText("  " + r);

    }

    //-버튼을 클릭했을때 호출되는 메소드
    public void sub(View target){
        String n1 = edit1.getText().toString();
        String n2 = edit2.getText().toString();

        int r = Integer.parseInt(n1) - Integer.parseInt(n2);

        result.setText(" " + r);

    }


    //*버튼을 클릭했을때 호출되는 메소드
    public void mul(View target){
        String n1 = edit1.getText().toString();
        String n2 = edit2.getText().toString();

        int r = Integer.parseInt(n1) * Integer.parseInt(n2);

        result.setText(" " + r);

    }

    // /버튼을 클릭했을때 호출되는 메소드
    public void div(View target){
        String n1 = edit1.getText().toString();
        String n2 = edit2.getText().toString();

        int r = Integer.parseInt(n1) / Integer.parseInt(n2);

        result.setText(" " + r);

    }


}



