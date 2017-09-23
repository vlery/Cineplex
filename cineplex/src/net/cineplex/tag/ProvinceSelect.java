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
	String [] province={"","北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏",
						"浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","广西",
						"海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海","宁夏",
						"新疆","香港","澳门","台湾"};
	
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
