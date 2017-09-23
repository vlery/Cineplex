package net.cineplex.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MovieAddFeedback extends SimpleTagSupport{

	public void doTag(){
		try {
            PageContext pageContext = (PageContext)this.getJspContext();
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
            
            HttpSession session = request.getSession();
        
            String s="";
            if (null!=(session.getAttribute("movie_add_feedback") )) { 
            	s=(String) session.getAttribute("movie_add_feedback");
            	JspWriter out = getJspContext().getOut();
        		out.println(
        				"<div class=\"am-alert am-alert-warning am-animation-fade\" data-am-alert>"
        	              +"<button type=\"button\" class=\"am-close\">&times;</button>"
        	              +"<p class=\"am-text-xs\">"
        	              + s 
        	              + "</p></div>"
        				);
        		session.removeAttribute("movie_add_feedback");
            } 
             
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
}
