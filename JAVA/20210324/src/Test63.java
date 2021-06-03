import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;

import javax.print.attribute.standard.PrinterName;

// 클래스, 객체 생성, 생성자, 만들기 연습


class MyDate{
//MyDate라는 이름의 클래스 정의 

	//정수값을 저장할 year, month, day 변수 정의
	int year, month, day;
	
	//기본 생성자 정의
		//year 2014 저장
		//month 1 저장
		//day 1;
	MyDate() {
		year = 2014;
		month = 1;
		day = 1;
	}
	
	
	//년도 값을 n_year매개변수로 전달 받아
		//year = n_year 저장
		//month = 1 저장
		//day 1 저장
	MyDate(int n_year){
		year = n_year;
		month = 1;
		day= 1;
		
	}
	
	
	//생성자 정의
	//년도, 월값을 각각 n_year , n_month 매개변수로 전달 받아
		//year n_year 저장
		//month n_month 저장
		//day 1 저장
	MyDate(int n_year, int n_month){
		year = n_year;
		month =n_month;
		day = 1;
		
	}
		
	//생성자 정의
	//년도, 월, 일 값을 n_year, n_month, n_day 매개변수로 전달 받아
		//year n_year 저장
		//month n_month 저장
		//day n_day 저장
	MyDate(int n_year, int n_month, int n_day){
		year = n_year;
		month = n_month;
		day = n_day;
	}
	
	
	//메소드 정의
	//매개변수 n_year 로 전달 받은 값을 year변수에 저장시킬 메소드 정의
	void setyear(int n_year){
		year = n_year;
		
	}
	//매개변수 n_month 로 전달 받은 값을 month변수에 저장시킬 메소드 정의
	void setmonth(int n_month){
		month = n_month;
		
	}
	
	//매개변수 n_day 로 전달 받은 값을 day변수에 저장시킬 메소드 정의
	void setday(int n_day){
		day = n_day;
		
	}
	
	
	//year변수에 저장되어 있는 값을 반환할 목적의 getyear메소드 정의
	int getyear() {
		return year;		
	}
	
	//month변수에 저장되어 있는 값을 반환할 목적의 getmonth메소드 정의
	int getmonth() {
		return month;
	}
	
	//day변수에 저장되어 있는 값을 반환할 목적의 getday메소드 정의
	int getday() {
		return day;
	}
	
	
	//prn메소드 정의:  year -month -day  출력
	void prn() {
		System.out.println(year + " - " + month + " - " + day);
		
	}
		
	
}//MyDate class

public class Test63 {

	public static void main(String[] args) {
		//MyDate클래스를 이용해 객체 생성시 기본생성자 호출!
		
		MyDate m = new MyDate();
		//참조변수 이름 m
		
		
		//출력
		//2014
		//1
		//1
		System.out.println(m.year);		
		System.out.println(m.month);		
		System.out.println(m.day);		
		
		
		//set으로시작하는 메소드들 호출 해서 값 저장
		//2014
		//8
		//6
		m.setyear(2014);
		m.setmonth(8);
		m.setday(6);
		System.out.println(m.year);
		System.out.println(m.month);
		System.out.println(m.day);
		
		
		
		//get으로 시작하는 메소드들 호출 해서 출력
		//출력
		//2014
		//8
		//6
		m.year = 2014;
		System.out.println(m.getyear());
		m.month = 8;
		System.out.println(m.getmonth());
		m.day = 6;
		System.out.println(m.getday());
		
		
		System.out.println("---------------------------");
		//출력
		//2014-8-6
		//-----------------
		m.prn();
		
		
		//MyDate클래스를 이용해 객체 생성시 년도 값을 전달 받는 생성자 호출! 
		//호출시 전달할 값 2015
		//참조변수 m2
		MyDate m2 = new MyDate(2015);
		
		//출력
		//2015-1-1
		m2.prn();
		
		
		//MyDate클래스를 이용해 객체 생성시 년도,월 값을 전달 받는 생성자 호출!
		//호출시 전달할 값 2016, 5
		MyDate m3 = new MyDate(2016, 5);
		
		//출력
		//2016-5-1
		m3.prn();
		
		//MyDate클래스를 이용해 객체 생성시 년도,월,일 값을 전달 받는 생성자 호출!
		//호출시 전달할 값 2017, 7, 7
		MyDate m4 = new MyDate(2017, 7, 7);
		//출력
		//2017-7-7	/
		m4.prn();
				
	}

}
