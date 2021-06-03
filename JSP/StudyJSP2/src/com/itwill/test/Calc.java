package com.itwill.test;

public class Calc {

	public int SUM(int kor,int eng,int math){
		
	return	kor + eng + math;
	}
	
	public int SUM(itwillBean ib){
		
		return	ib.getKor() + ib.getEng() + ib.getMath();
		}
	
	
	public void AVG(int kor,int eng,int math){
		System.out.println("평균 : " + ((kor+eng+math)/3.0));
	}

	public void AVG(itwillBean ib){
		System.out.println("평균 : " + (SUM(ib)/3.0));
	}
	
	
	
	
}
