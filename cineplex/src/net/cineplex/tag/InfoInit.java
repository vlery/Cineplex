package net.cineplex.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.cineplex.action.bussiness.MemberService;
import net.cineplex.action.bussiness.MemberServiceBean;
import net.cineplex.model.Member;
import net.cineplex.webmodel.RegisterInfo;




public class InfoInit extends SimpleTagSupport {
	MemberService memberService=new MemberServiceBean();
	
	public void doTag(){
		PageContext pageContext = (PageContext)this.getJspContext();
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        
        HttpSession session = request.getSession();
    	Member member=(Member) session.getAttribute("crtUser");
        RegisterInfo   crtUserInfo=memberService.findRevisableInfo(member.getId());
       
        session.setAttribute("crtUserInfo",crtUserInfo );
		
		
	}
}
