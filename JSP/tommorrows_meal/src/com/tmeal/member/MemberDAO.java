package com.tmeal.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.websocket.Session;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	private Connection getConnection(){
	
		try {
		
		Context initCTX = new InitialContext();
				
		DataSource ds = 
		(DataSource) initCTX.lookup("java:comp/env/jdbc/mysqlDB");
			
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
	
	public void closeDB(){
		
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}//closeDB

	//login(mb)
	public void login(tmmemberbean mb){
		
		try {
			conn = getConnection();
			
			sql = "select pw from sm_member where id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb.getId());
		
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(mb.getPw().equals(rs.getString("pw"))){
					
				}
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	} 
	//login(mb)
	
	
}//MemberDAO
