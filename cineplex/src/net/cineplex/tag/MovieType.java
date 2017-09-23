package net.cineplex.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.cineplex.webmodel.MovieTypeVO;

public class MovieType extends SimpleTagSupport{

		public void doTag() throws IOException{
			String[] color={"","am-badge-primary","am-badge-secondary","am-badge-success","am-badge-warning","am-badge-danger"};
			PageContext pageContext = (PageContext)this.getJspContext();
	        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
	        
	        HttpSession session = request.getSession();
	        MovieTypeVO mtv=(MovieTypeVO) session.getAttribute("movieType");
			JspWriter out = getJspContext().getOut();
			
			out.println("<div>");
			int colorCount=0;
			out.println("<label class=\"am-text-xl\" >¿‡–Õ:  &nbsp;&nbsp;</label>");
			for(int i=0;i<mtv.getSize();i++){
				out.println("<span class=\"am-badge am-round type_tag "+color[colorCount]+"\">"+
							mtv.getItem(i)+
							"</span>");
				colorCount=(colorCount+1)%6;
			
			}
			out.println("</div>");
		}
}
