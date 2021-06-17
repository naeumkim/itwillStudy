package com.itwillbs.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	
	private Connection getConnection(){

		//Context 객체를 생성
		try {
			//Context 객체를 생성(프로젝트 정보를 가지고 있는 객체)
			Context initCTX = new InitialContext();
			//인터페이스에 객체를 넣은 것임(업캐스팅함) 
			
			//DB연동정보를 불러오기(context.xml)
			DataSource ds = 
			(DataSource) initCTX.lookup("java:comp/env/jdbc/mysqlDB");
			//java:comp/env/ 까지는 고정 
			//DataSource로 다운 캐스팅 함
			
			conn = ds.getConnection();
			System.out.println("드라이버 로드, 디비연결 성공!");
			System.out.println(conn);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return conn; 
	}//getConnection 끝
	
	
	//자원해제 코드  -- finally 구문에서 사용
	public void closeDB(){
			
		try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		
				}
		
		
		
	}//closeDB
	
	
	//idCheck(id);
	public int idCheck(String id){
		int result = 0;
		
		try {
			conn = getConnection();
			
			sql = "select * from itwill_member where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = 1; //회원이 있음 > 해당아이디 x
				
			}else{
				result = 0; //회원이 없음 > 해당아이디 사용 o
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//idCheck(id);
	
	
	
}
