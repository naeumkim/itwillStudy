package com.itwillbs.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	//Data Access Object :  DB데이터 처리 객체
	// > DB에 관련된 모든 동작을 수행하는 객체
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	
	private Connection getConnection(){
		//디비연결 필요정보(지역변수)
//		String DRIVER = "com.mysql.jdbc.Driver";
//		String DBURL = "jdbc:mysql://localhost:3306/jspdb";
//		String DBID = "root";
//		String DBPW = "1234";
//		
//		
//		//1,2단계
//		try {
//			Class.forName(DRIVER);
//			conn = DriverManager.getConnection(DBURL, DBID, DBPW);
//		
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
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
	
	
	
	
	
	// 글쓰기 동작 > 메서드 
	//외부파일에서 접근할 수 있도록 접근제어자 설정하기
	/*
	  public void insertBoard(BoardBean bb){
	 
		//필요한 것 :  글의 정보 > 변수로 BoardBean bb
		//1 드라이버 로드
		try { //시작 > try에서 시도하다가 문제가 생기면 catch로 간다.
			Class.forName(DRIVER);
			//2 디비 연결
			conn = DriverManager.getConnection(DBURL, DBID, DBPW);
			//3 sql작성(insert) & pstmt 객체 생성
			sql = "insert into itwill_board "
					+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//?
			pstmt.setInt(1,1);
			pstmt.setString(2,bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setInt(7, bb.getRe_ref());
			pstmt.setInt(8, bb.getRe_lev());
			pstmt.setInt(9, bb.getRe_seq());
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			
			//4 sql 실행
			pstmt.executeUpdate();
			
			System.out.println("sql 구문 실행완료 : 글쓰기 완료!" );
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace(); //에러를 출력한다 > 문제가 생기면 에러를 출력한다. 
		}//끝
 catch (SQLException e) {
			//드라이버 매니저를 실행할때 문제가 생기면 여기서 실행한다
	 	System.out.println("디비 연결 실패");
	 	e.printStackTrace();
		}
	}
	
		*/

	public void insertBoard(BoardBean bb){
		//필요한 것 :  글의 정보 > 변수로 BoardBean bb
		int num = 0;
		
		try { //시작 > try에서 시도하다가 문제가 생기면 catch로 간다.
			//1 드라이버 로드
			//2 디비 연결
			conn = getConnection();
			
			// 3 sql (글번호를 계산하는 구문) > (제일 마지막 번호를 가져오게 한다)
			sql = "select max(num) from itwill_board";
			//DB안에 글이 없을 경우, max(num) / num 구하는 코드를 비교해보면,
			// max(num)은 커서가 있고, num은 존재하지 않는다.
			// >즉 max(num)은 데이터가 있다고 판단한다.
			
			pstmt = conn.prepareStatement(sql);
			
			//4 sql 실행
			rs = pstmt.executeQuery();
			
			
			//5데이터 처리
			//max(num)과 같은 sql함수를 실행했을 경우, 커서 이동이 가능함 (데이터 여부 상관없음)
			// num 		- sql 컬럼의 경우 커서이동 불가능
			if(rs.next()){
				//num = rs.getInt("max(num)")+1;
				//숫자로 적으면 인덱스 번호임 1번이 max(num)이므로 위와 똑같은 코드다.
				num = rs.getInt(1)+1;
				
				//getInt(1) 속성에서 null값이면 0을 반환하므로, 
				//글이 없을때 (num = null)일때의 상황도 else로 따로 정하지 않아도 된다.
			}
				
				
			System.out.println("글 번호 :" + num);
			
			
			
			
			///////////////////////////////////////////////////////////////
			
			//3 sql작성(insert) & pstmt 객체 생성
			sql = "insert into itwill_board "
					+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			pstmt = conn.prepareStatement(sql);
			
			
			//?
			pstmt.setInt(1,num);
			pstmt.setString(2,bb.getName());
			pstmt.setString(3, bb.getPass());
			pstmt.setString(4, bb.getSubject());
			pstmt.setString(5, bb.getContent());
			pstmt.setInt(6, bb.getReadcount());
			pstmt.setInt(7, num); //re_ref에 글번호 num 저장
			pstmt.setInt(8, bb.getRe_lev());
			pstmt.setInt(9, bb.getRe_seq());
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			
			//4 sql 실행
			pstmt.executeUpdate();
			
			System.out.println("sql 구문 실행완료 : 글쓰기 완료!" );
		} catch (SQLException e) {
			//드라이버 매니저를 실행할때 문제가 생기면 여기서 실행한다
	 	System.out.println("디비 연결 실패");
	 	e.printStackTrace();
		}finally{
			//try, catch 끝에 사용하게 되는 동작 > 자원해제의 역할
			try {
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}//글쓰기 동작 끝 insertBoard

	//getBoardCount()
	//현재 DB에 들어있는 글의 개수 계산 후 리턴
	public int getBoardCount() {
		
		int cnt = 0;
		
		try {
			// 1,2 드라이버로드, 디비연결
			conn = getConnection();
			//3 sql 작성(select) & pstmt 객체 생성
			String sql = "select count(*) from itwill_board";
			
			pstmt = conn.prepareStatement(sql);
			
			//4 sql 실행
			rs = pstmt.executeQuery();
			
			//5 데이터 처리
			if(rs.next()){
				cnt = rs.getInt(1); //"count(*)"
				//cnt = rs.getInt("count(*)");
				
			}
			
			System.out.println("SQL 구문 실행완료");
			System.out.println("글 개수 :" + cnt + "개");
			
			
		} catch (Exception e) {
			System.out.println(" 게시판 글 개수_에러발생 ");
			e.printStackTrace();
		}finally{
			//자원해제 
			//오류가 나서 끝났거나, 정상적으로 try해서 끝났을 경우( 데이터가 있는 경우) 이므로 
			// rs,pstmt,conn != null 조건을 넣는다. >  반복방지를 위해 closeDB 메소드로 만들기
			
			closeDB();
		}
		
		
		return cnt;
	}
	//getBoardCount()
	
	//getBoardList()
	public ArrayList getBoardList(){
		//DB의 정보를 BoardBean객체에 담아 리턴하는 동작 > BoardBean을 Arraylist에 담기
		//DB데이터 1row 정보를 BoardBean에 저장 >  ArrayList 한칸에 저장
		
		
		//게시판의 글정보를 모두를 저장하는 가변길이 배열
		ArrayList boardListAll = new ArrayList();
		
		//게시판 글 1개의 정보를 저장하는 객체
		BoardBean bb = null;
		//BoardBean bb = new BoardBean();
		
		try {
			//1,2 드라이버 로드, 디비 연결
			conn = getConnection();
			//sql구문 & pstmt 객체
			sql = "select * from itwill_board";
			pstmt = conn.prepareStatement(sql);
			//4.sql 실행
			 rs = pstmt.executeQuery();
			//5.데이터처리
			 while(rs.next()){
				 //데이터 있을때 bb객체 생성
				 bb = new BoardBean();
				 
				 //DB정보  > Bean 저장 
				 bb.setContent(rs.getString("content"));
				 bb.setDate(rs.getDate("date"));
				 bb.setFile(rs.getString("file"));
				 bb.setIp(rs.getString("ip"));
				 bb.setName(rs.getString("name"));
				 bb.setNum(rs.getInt("num"));
				 bb.setPass(rs.getString("pass"));
				 bb.setRe_lev(rs.getInt("re_lev"));
				 bb.setRe_ref(rs.getInt("re_ref"));
				 bb.setRe_seq(rs.getInt("re_seq"));
				 bb.setReadcount(rs.getInt("readcount"));
				 bb.setSubject(rs.getString("subject"));
			 
				 //Bean > Arraylist 한칸에 저장
				 boardListAll.add(bb); // 업캐스팅됨
			 
			 }//While 끝
			 
			 System.out.println(" 게시판 모든 정보 저장완료 " );
			 System.out.println("총 글 개수 " + boardListAll.size() + "개" );
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
			
		}
		
		return boardListAll;
	}
	//getBoardList()
	
	//getBoardList(startRow,pageSize)
	public ArrayList getBoardList(int startRow, int pageSize){
		//DB의 정보를 BoardBean객체에 담아 리턴하는 동작 > BoardBean을 Arraylist에 담기
		//DB데이터 1row 정보를 BoardBean에 저장 >  ArrayList 한칸에 저장
		
		
		//게시판의 글정보를 원하는 만큼(페이지사이즈 만큼)저장하는 가변길이 배열
		ArrayList boardList = new ArrayList();
		
		//게시판 글 1개의 정보를 저장하는 객체
		BoardBean bb = null;
		//BoardBean bb = new BoardBean();
		
		try {
			//1,2 드라이버 로드, 디비 연결
			conn = getConnection();
			//3 sql구문 & pstmt 객체
			//최근글이 가장 위쪽에 있도록 정렬
			//글 정보를 정렬 - re_ref 값을 최신글 위쪽으로 정렬(내림차순)
			//			- re_seq 값을 사용(오름차순)
			//			- limit a,b를 이용해  값잘라오기 (a-시작지점,b-개수)
			//ex)1번 - 0번 인덱스 11번 - 10번 인덱스 >  limit a,b (a 시작행-1, b)
			
			
			sql = "select * from itwill_board order by re_ref desc, re_seq asc limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			
			//?
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			//4 sql 실행
			 rs = pstmt.executeQuery();
			//5.데이터처리
			 while(rs.next()){
				 //데이터 있을때 bb객체 생성
				 bb = new BoardBean();
				 
				 //DB정보  > Bean 저장 
				 bb.setContent(rs.getString("content"));
				 bb.setDate(rs.getDate("date"));
				 bb.setFile(rs.getString("file"));
				 bb.setIp(rs.getString("ip"));
				 bb.setName(rs.getString("name"));
				 bb.setNum(rs.getInt("num"));
				 bb.setPass(rs.getString("pass"));
				 bb.setRe_lev(rs.getInt("re_lev"));
				 bb.setRe_ref(rs.getInt("re_ref"));
				 bb.setRe_seq(rs.getInt("re_seq"));
				 bb.setReadcount(rs.getInt("readcount"));
				 bb.setSubject(rs.getString("subject"));
			 
				 //Bean > Arraylist 한칸에 저장
				 boardList.add(bb); // 업캐스팅됨
			 
			 }//While 끝
			 
			 System.out.println(" 게시판 모든 정보 저장완료 " );
			 System.out.println("총 글 개수 " + boardList.size() + "개" );
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
			
		}
		
		return boardList;
	}
	//getBoardList(startRow,pageSize)
	

	//bdao.updateReadcount(num);
	public void updateReadcount(int num) {
		
		
		try {
			//1,2 디비연결
			conn = getConnection(); //이 구문도 예외가 발생한다. 위에서 trycatch구문을 적어놓음
			
			//3 sql구문 작성 & pstmt객체
			sql = "update itwill_board set readcount=readcount+1 where num=? ";
			
			pstmt = conn.prepareStatement(sql);
			
			//?
			pstmt.setInt(1, num);		
			
			//4 sql 실행
			pstmt.executeUpdate();
			
			System.out.println("글 조회수 증가 완료!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDB();
		}
	}
	//bdao.updateReadcount(num);
	//getBoard(num)
	public BoardBean getBoard(int num){
		//내용 전체를 가져올 것이므로 보드빈 클래스 타입으로 설정함
		BoardBean bb = null;
		
		try {
			//1,2 디비 연결
			conn = getConnection();
			
			//3 sql 작성 & pstmt객체
			sql = "select * from itwill_board where num=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			//4 sql 실행
			rs = pstmt.executeQuery();
			//5 데이터처리(bean저장)
			if(rs.next()){ //데이터가 있을때 보드빈객체 생성
				bb = new BoardBean();
				//전역변수로 선언해줘야함
				 
				bb.setContent(rs.getString("content"));
				 bb.setDate(rs.getDate("date"));
				 bb.setFile(rs.getString("file"));
				 bb.setIp(rs.getString("ip"));
				 bb.setName(rs.getString("name"));
				 bb.setNum(rs.getInt("num"));
				 bb.setPass(rs.getString("pass"));
				 bb.setRe_lev(rs.getInt("re_lev"));
				 bb.setRe_ref(rs.getInt("re_ref"));
				 bb.setRe_seq(rs.getInt("re_seq"));
				 bb.setReadcount(rs.getInt("readcount"));
				 bb.setSubject(rs.getString("subject"));
			}
			
			System.out.println("글번호에 해당하는 글정보 저장완료");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		return bb;
	}
	//getBoard(num)
	
	//updateBoard(bb);
	public int updateBoard(BoardBean bb){
		int check = -1; //사용자 정의값, 그냥...지정한 것
		
		try {
			//1,2 디비연결
			conn = getConnection();
			//3 sql 작성(select-본인확인) & pstmt 객체
			sql = "select pass from itwill_board where num = ?";
			//										num이 pk임
			pstmt = conn.prepareStatement(sql);
			//?
			pstmt.setInt(1, bb.getNum());
			//4 sql 실행
			rs = pstmt.executeQuery();
			//5 데이터 처리
			if(rs.next()){	
				//글이 있음
				if(bb.getPass().equals(rs.getString("pass"))){
				//글 수정시 입력된 비밀번호 ,글 작성시 입력된 비밀번호(DB) 동일
					//3 sql (update - 글수정) & pstmt 객체
					sql = "update itwill_board set subject =?, content=? where num=?";
					pstmt = conn.prepareStatement(sql);	
					//?
					pstmt.setString(1, bb.getSubject());
					pstmt.setString(2, bb.getContent());
					pstmt.setInt(3,bb.getNum());
					
					//4 sql 실행
					
					check = pstmt.executeUpdate();
					//check는 정수타입 
					//pstmt.executeUpdate 로 바뀐 행이 몇개인지 반환해줌 항상 1이 리턴
 				}else{//글은 있지만 비밀번호가 잘못되었을때
					
					check = 0;
					
				}
			}else{
				//글이 없음
				check = -1;
			}
			
			System.out.println("글 수정 완료! " + check);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return check;
	}
	//updateBoard(bb);
	
	//deleteBoard(bb);
	public int deleteBoard(BoardBean bb){
		int check = -1; 
	
		try {
			//db연결
			conn = getConnection();
			//sql생성 & pstmt 객체 생성
			sql = "select pass from itwill_board where num =?";
			pstmt = conn.prepareStatement(sql);
			//?
			pstmt.setInt(1, bb.getNum());
			//sql 실행
			rs = pstmt.executeQuery();
			//데이터처리
				//sql 생성
				//sql 실행
			if(rs.next()){
				if(bb.getPass().equals(rs.getString("pass"))){
					//sql 생성 후 pstmt 생성
					sql = "delete from itwill_board where num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bb.getNum());
					
					check = pstmt.executeUpdate();
				}else{
					check = 0;
					
				}
				
			}else{//데이터 없을때
				check = -1;
			}
			
			System.out.println("글 삭제 완료" + check);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		
		return check;
	}
	//deleteBoard(bb);
	

	//reInsertBoard(bb)
	public void reInsertBoard(BoardBean bb){
		int num = 0;
		//1)답글 작성 번호(num) 계산 (일반글 번호와 동일)
		
		try {
			//12 디비연결
			conn = getConnection();
			//3 sql 구문 & pstmt
			sql = "select max(num) from itwill_board";
			pstmt = conn.prepareStatement(sql);
			//4 sql 실행
			rs = pstmt.executeQuery();
			//5 데이터처리
			if(rs.next()){
				//rs.getInt("max(num)"); 계산결과는 1개이기 때문에 1을 넣어도됨
				num = rs.getInt(1)+1;
				
			}
			
			System.out.println("답글 번호 계산 완료 :" + num);
			
			//2)답글 순서 재배치(정렬)
			//re_ref(같은그룹) 안에서 re_seq(순서)를 정렬
			//						기존의 순서값보다 큰 값이 있으면 순서를 1증가
			sql = "update itwill_board set re_seq = re_seq+1 "
					+ "where re_ref = ? and re_seq > ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bb.getRe_ref());
			pstmt.setInt(2, bb.getRe_seq());
			
			//sql 실행
			pstmt.executeUpdate();
			
			System.out.println("답글 정렬 완료");
			
			
			//3)답글 쓰기 
			
			sql = "insert into itwill_board(num,name,pass,subject,content,"
					+ "readcount,re_ref,re_lev,re_seq,date,ip,file) "
					+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2,bb.getName());
			pstmt.setString(3,bb.getPass());
			pstmt.setString(4,bb.getSubject());
			pstmt.setString(5,bb.getContent());
			pstmt.setInt(6,bb.getReadcount());
			pstmt.setInt(7, bb.getRe_ref()); //re_ref 원글의 그룹번호 사용
			pstmt.setInt(8, bb.getRe_lev()+1); //re_lev + 1 
			pstmt.setInt(9, bb.getRe_seq()+1); //re_seq + 1
			pstmt.setString(10, bb.getIp());
			pstmt.setString(11, bb.getFile());
			
			//sql 실행
			pstmt.executeUpdate();

			System.out.println("답글 정렬 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		
	}
	//reInsertBoard(bb)
	
	
	
}//DAO 끝



