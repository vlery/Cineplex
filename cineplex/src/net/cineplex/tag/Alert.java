package net.cineplex.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Alert  extends SimpleTagSupport{
	public void doTag() throws IOException{

		try {
            PageContext pageContext = (PageContext)this.getJspContext();
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
            
            HttpSession session = request.getSession();
        
            String s="";
            if (null!=(session.getAttribute("enter_alert") )) { 
            	s=(String) session.getAttribute("enter_alert");
            	JspWriter out = getJspContext().getOut();
        		out.println(
        				"<div class=\"am-alert am-alert-warning am-animation-fade\" data-am-alert>"
        	              +"<button type=\"button\" class=\"am-close\">&times;</button>"
        	              +"<p class=\"am-text-xs\">"
        	              + s 
        	              + "</p></div>"
        				);
        		session.removeAttribute("enter_alert");
            } 
            
            if (null!=(session.getAttribute("register_alert") )) { 
            	s=(String) session.getAttribute("register_alert");
            	JspWriter out = getJspContext().getOut();
        		out.println(
        				"<div class=\"am-alert am-alert-warning am-animation-fade\" data-am-alert>"
        	              +"<button type=\"button\" class=\"am-close\">&times;</button>"
        	              +"<p class=\"am-text-xs\">"
        	              + s 
        	              + "</p></div>"
        				);
        		session.removeAttribute("register_alert");
            } 
            
        } catch(Exception e) {
            e.printStackTrace();
        }
		
	}
}
