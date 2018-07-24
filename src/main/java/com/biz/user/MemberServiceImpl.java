package com.biz.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class MemberServiceImpl implements MemberService {
	//@Autowired
	private MemberDAO dao;
//	public MemberServiceImpl(MemberDAO dao) {
//		this.dao = dao;
//	}
	
	public void setMemberServiceImpl(MemberDAO dao) {
		this.dao = dao;
	}
	public MemberVO memberLogin(MemberVO vo){
		//MemberDAO dao = new MemberDAO();	
		return dao.memberLogin(vo);
	}
	public ArrayList memberList() {
		//MemberDAO dao = new MemberDAO();	
		return dao.memberList();
	}
}
