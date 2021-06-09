package com.example.hello;


///필요한 클래스를 포함시키는 import 문장들
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


/*
 액티비티 : 사용자가 화면을 통하여 하나의 작업을 할 수 있도록 하는 컴포넌트
 ex) 전화를 거는 화면 , 사진을 촬영하는 화면, 이메일을 보내는 화면, 지도를 보여주는 화면 하나하나가
 모두 액티비티 화면이 된다.

 :하나의 앱은 여러개의 액티비티(화면)들을 가질 수 있다.
 사용자는 오직 하나의 액티비티와 상호작용을 한다.
 액티비티는 다른 액티비티화면으로 이동해서 갈 수 있다. (화면전화)

 */


/*
 MainActivity 클래스 정의
 1. AppCompatActivity 클래스는 Activity클래스의 자식클래스이다.
 2. AppCompatActivity로 부터 상속받은 MainActivity 클래스도 액티비티가 된다.
 3. 최상위 Activity클래스를 상속받아 MainActivity클래스를 정의해 놓아도 하나의 화면을 구성 할 수 있다.


 */

public class MainActivity extends AppCompatActivity {

    /*
        Oncreate
        1.안드로이드 시스템에 의하여 액티비티가 생성되는 순간에 딱 한번만 호출되는 콜백메소드이다.
        2. 한번만 수행되기 때문에 모든 초기화와 사용자 인터페이스 설정은 onCreate()메소드 안에서 이루어져야 한다.
        3. OnCreate 메소드의 매개변수인 Bundle SavedInstanceState는 앱이 이전에 실행되었던 상태를 전달하여 준다.
         설명 : 안드로이드에서는 일시 중단되었던 앱을 다시 실행시키면, 이전상태를 복원해야한다.
         이때 Bundle savedInstanceState에서 이전상태의 정보를 추출받아온다.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //부모클래스인 AppCompatActivity클래스의 onCreate() 메소드를 호출하는 문장임
        //1.부모클래스가 할일이 있다면 이때 실행됨
        //2. super는 상속관계에서 부모클래스를 나타내는 키워드임
        super.onCreate(savedInstanceState);

        /*
        setContentView() 메소드
         - activity_main.xml에 작성된 디자인을 현재 화면에 불러오기 위해 설정
         1. 액티비티 화면을 설정하는 메소드
         2.R.layout.activity.main   : 자바에서 도트연산자(.)는 클래스의 멤버를 참조할때 사용하는 연산자이다.
            따라서 R클래스안에 layout이라는 내부클래스가 있고, Layout내부 클래스 안에 activity.main.xml파일
            에 대한 16진수값을 나타낸다.

        = this.setContentView(R.layout.activity_main);
        */

        setContentView(R.layout.activity_main);
    }
}