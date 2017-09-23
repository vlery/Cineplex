package net.cineplex.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.cineplex.model.MemberInfo;
import net.cineplex.webmodel.RegisterInfo;

public class ProvinceSelect  extends SimpleTagSupport  {
	String [] province={"","����","���","�ӱ�","ɽ��","���ɹ�","����","����","������","�Ϻ�","����",
						"�㽭","����","����","����","ɽ��","����","����","����","�㶫","����",
						"����","����","�Ĵ�","����","����","����","����","����","�ຣ","����",
						"�½�","���","����","̨��"};
	
	public void doTag() {
		
		 PageContext pageContext = (PageContext)this.getJspContext();
         HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
      
         HttpSession session = request.getSession();
         RegisterInfo r_info=(RegisterInfo) session.getAttribute("registerInfo");
         String p_id="0";
         if(null!=r_info){
        	 p_id=r_info.getCity();
         }
         
		try {
            	JspWriter out = getJspContext().getOut();
            	
            	out.println("<select  name=\"province\" id=\"province\" value=\""+ p_id +"\"  onchange=\"ChangeSelect(this)\"  required />");
        		for(int i=0;i<province.length;i++){
        				out.println("<option value=\""
        						+ Integer.toString(i)
        						+"\">"
        						+province[i]
        						+"</option>"
        						);
        		}
        		out.println(" </select>  ");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
		
	}
}
