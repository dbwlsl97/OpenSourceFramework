package com.biz.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.biz.user.MemberService;



//@Controller
public class LoginController extends MultiActionController{// implements Controller {
	//@Autowired
	private MemberService memberService;
//	public LoginController(MemberService svc) {
//		this.memberService = svc;
//	}
	
	public void setMemberService(MemberService mm) {
		this.memberService = mm;
	}
	
	public ModelAndView crow(HttpServletRequest request , HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Document url = Jsoup.connect("https://search.shopping.naver.com/search/category.nhn?cat_id=50001228").get();
		Elements tagVal = url.select("ul.goods_list");
		//String text= tagVal .select("a").html();
		System.out.println( "tagVal : " + tagVal );
//		
//		for(Element e : tagVal) {
//			String href = e.ElementTag("src");
//			System.out.println(href);
//		}
		//System.out.println( "text : " + text );
		
		//ArrayList list = memberService.memberList();
		mav.addObject("DATA",tagVal);
		mav.setViewName("charts");
		return mav;
	}
	
	public ModelAndView mlist(HttpServletRequest request , HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		ArrayList list = memberService.memberList();
		mav.addObject("LVL",list);
		mav.setViewName("tables");
		return  mav;
	}
	//@RequestMapping(value = "/slogout")
	public ModelAndView slogout(HttpServletRequest request , HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		session.setMaxInactiveInterval(0);
		ModelAndView mav = new ModelAndView();
//		ArrayList list = memberService.memberList();
////		model.addAttribute("LVL", list);
////		viewName = "admin_main";
//		mav.addObject("LVL",list);
		mav.setViewName("index");
		return  mav;
	}
	
	
	//@RequestMapping(value = "/slogin")
	public ModelAndView slogin(HttpServletRequest request, HttpServletResponse response) throws Exception{

		//1. 사용자 입력정보(id,pw) 추출 코드
		MemberVO vo = new MemberVO(); 
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		
		//2. 사용자 입력 정보 이용 UserVO 객체 조회
		//setter()로 UserService객체 못 받아올 경우 아래 주석풀고 실행
		//------------의존성 주입(DI)---------------//
		//MemberService memberService = new MemberServiceImpl();
		//---------------------------------------//
		vo = memberService.memberLogin(vo);
		
		//3. DB 연동 로직 구현(USERDAO 객체 사용)
//		String viewName="";
//		if(!vo.getMname().equals("")) {
//			HttpSession session = request.getSession();
//			session.setAttribute("SESS_ID", vo.getMid());
//			session.setAttribute("SESS_NAME", vo.getMname());
//			viewName = "member_main";
//		} else {
//			viewName = "member_login";
//		} 
		ModelAndView mav = new ModelAndView();
		if(vo.getMname()!= null) {
			HttpSession session = request.getSession(); //session 꺼내기
			session.setAttribute("SS_NAME",vo.getMname());
			session.setAttribute("SS_GUBUN",vo.getMgubun());
			session.setAttribute("SS_POINT", 10000);
			if(vo.getMgubun().equals("u")) {
				mav.addObject("username", vo.getMname());
				mav.setViewName("member_main");
//				model.addAttribute("username", vo.getMname());
//			viewName = "member_main";
			} else if(vo.getMgubun().equals("a")) {
//			ArrayList list = m.memberList();
				ArrayList list = memberService.memberList();
//			model.addAttribute("LVL", list);
//				viewName = "admin_main";
				mav.addObject("LVL",list);
				mav.setViewName("index");
			}
		}
		else {
//			viewName = "member_login";
			mav.setViewName("member_login");
		}
		return mav;
	}
}
