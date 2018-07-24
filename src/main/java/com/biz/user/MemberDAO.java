package com.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.user.DBManager;
import com.biz.user.MemberVO;

//@Repository
public class MemberDAO {
	private SqlSession session;
	public MemberDAO(SqlSession session) {
		this.session = session;
	}
	public MemberVO memberLogin(MemberVO vo) {
		return session.selectOne("memberNameSpace.login",vo);
	}
	
	public ArrayList memberList() {
		return (ArrayList)session.selectList("memberNameSpace.allMember");
	}
	
	
	public void memberInsert(MemberVO vo) {
		session.insert("memberNameSpace.commoninsert",vo);
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
	}
	
	public void memberUpdate() {
		session.update("memberNameSpace.memUpdate");
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
	}
	
	public void memberDelete() {
		session.delete("memberNameSpace.memDelete");
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
	}
//	public MemberVO memberLogin(String mid, String mpw) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		DBManager db = new DBManager();
//		MemberVO vo = new MemberVO();
//		try {
//			conn = db.dbConn();
//			String sql = "select mname,mgubun from member where mid=? and mpw=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mid);
//			pstmt.setString(2, mpw);
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

}
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

