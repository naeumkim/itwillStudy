package com.itwill.test;

public class itwillBean {

	private String name;
	private String tel;
	private int kor;
	private int eng;
	private int math;
	
//	public itwillBean() {
		// 오버로딩된 생성자가 없을 경우에만,
//		// 컴파일러가 자동으로 생성 기본생성자를 생성한다.
//	}
//	
	
	//alt + shift + s  r 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	//-------set/get 메소드 만들었다.
	
	
	//alt + shift + s  v
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
	
	
	@Override
	public String toString() {
		return "itwillBean [name=" + name + ", tel=" 
	+ tel + ", kor=" + kor + ", eng=" + eng 
	+ ", math=" + math + "]";
	}
	
	//오버라이딩을 새로 했음 , 부모 레퍼런스의 오버라이딩 결과 x
	
	
	
	
	
	
	
	
	
}
