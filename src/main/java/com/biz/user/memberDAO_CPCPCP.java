//package com.biz.user;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Repository;
//
//import com.biz.user.DBManager;
//import com.biz.user.MemberVO;
//
////@Repository
//public class memberDAO_CPCPCP {
//	
//	public ArrayList memberList() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		DBManager db = new DBManager();
//		ArrayList list = new ArrayList();
//		try {
//			conn = db.dbConn();
//			String sql = "select * from member order by seq";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			int seq = 0;
//			String mid = "", mpw = "", mname = "";
//			while(rs.next()) {
//				MemberVO vo = new MemberVO();
//				vo.setSeq(rs.getInt("seq"));
//				vo.setMid(rs.getString("mid"));
//				vo.setMpw(rs.getString("mpw"));
//				vo.setMname(rs.getString("mname"));
//				list.add(vo);
////				System.out.println(seq + "\t"+mid + "\t"+mpw+"\t"+mname);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {		
//			db.dbClose(rs,pstmt,conn);
//		}
//		return list;
//	}
//	
//	
//	public void memberInsert(MemberVO vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			String insSql = "insert into member values(member_seq2.nextval,?,?,?,'u',sysdate)";
//			pstmt = conn.prepareStatement(insSql);
//			//바인딩 : ?에 값을 채우는 작업
//			pstmt.setString(1, vo.getMid());
//			pstmt.setString(2, vo.getMpw());
//			pstmt.setString(3, vo.getMname());
//			int rows = pstmt.executeUpdate();
//			System.out.println(rows+"건 입력");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {		
//			db.dbClose(pstmt,conn);
//		}
//	}
//	
//	public void memberUpdate() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			String updSql = "update member set userid = ? where seq = 4";
//			pstmt = conn.prepareStatement(updSql);
//			pstmt.setString(1,"Hong");
//			pstmt.executeUpdate();	
//	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {		
//			db.dbClose(pstmt,conn);
//		}
//	}
//	
//	public void memberDelete() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			String delSql = "delete from member where seq=?";
//			pstmt = conn.prepareStatement(delSql);
//			pstmt.setInt(1,4);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {		
//			db.dbClose(pstmt,conn);
//		}
//	}
////	public MemberVO memberLogin(String mid, String mpw) {
////		Connection conn = null;
////		PreparedStatement pstmt = null;
////		ResultSet rs = null;
////		DBManager db = new DBManager();
////		MemberVO vo = new MemberVO();
////		try {
////			conn = db.dbConn();
////			String sql = "select mname,mgubun from member where mid=? and mpw=?";
////			pstmt = conn.prepareStatement(sql);
////			pstmt.setString(1, mid);
////			pstmt.setString(2, mpw);
////			rs = pstmt.executeQuery();
////			while(rs.next()) {
////				vo.setMname(rs.getString("mname"));
////				vo.setMgubun(rs.getString("mgubun"));
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {		
////			db.dbClose(rs,pstmt,conn);
////		}
////		return vo;
////	}
//	public MemberVO memberLogin(MemberVO vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		DBManager db = new DBManager();
//		try {
//			conn = db.dbConn();
//			String sql = "select mname,mgubun from member where mid=? and mpw=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getMid());
//			pstmt.setString(2, vo.getMpw());
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				vo.setMname(rs.getString("mname"));
//				vo.setMgubun(rs.getString("mgubun"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {		
//			db.dbClose(rs,pstmt,conn);
//		}
//		return vo;
//	}
//}
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs; 
//	
//	public UserVO getUser(UserVO vo) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "select mname from member where mid=? and mpw=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getMid());
//			pstmt.setString(2, vo.getMpw());
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				vo.setMname(rs.getString("mname"));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(rs, pstmt, conn);
//		}
//		return vo;
//	}

