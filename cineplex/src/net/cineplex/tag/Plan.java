package net.cineplex.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Plan extends SimpleTagSupport{
	public void doTag() throws IOException{
		PageContext pageContext = (PageContext)this.getJspContext();
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        
        HttpSession session = request.getSession();
		JspWriter out = getJspContext().getOut();
		out.println("<div class=\"am-tabs\" data-am-tabs><ul class=\"am-tabs-nav am-nav am-nav-tabs\">"+
                    "<li class=\"am-active\"><a href=\"javascript: void(0)\">1月26日</a></li>"+
                    "<li><a href=\"javascript: void(0)\">1月27日</a></li><li><a href=\"javascript: void(0)\">1月28日</a></li>"+
                    "</ul><div class=\"am-tabs-bd\"><div class=\"am-tab-panel am-active\"><table class=\"am-table am-table-striped am-table-hover\">"+
                    "<thead><tr><th>放映时间</th><th>放映厅</th><th>票价（元）</th><th>选座购票</th></tr></thead><tbody><tr><td>23:20</td><td>2</td><td>30</td>"+
                    "<td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td></tr><tr><td>23:20</td>"+
                    "<td>2</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td>"+
                    "</tr><tr><td>23:20</td><td>2</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">"+
                    "购 票</button></td></tr><tr><td>23:20</td><td>2</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">"+
                    "购 票</button></td></tr><tr><td>23:20</td><td>2</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">"+
                    "购 票</button></td></tr></tbody></table></div><div class=\"am-tab-panel\"><table class=\"am-table am-table-striped am-table-hover\">"+
                    "<thead><tr><th>放映时间</th><th>放映厅</th><th>票价（元）</th><th>选座购票</th></tr></thead><tbody><tr><td>10:20</td><td>1</td>"+
                    "<td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td></tr><tr>"+
                    "<td>20:20</td><td>2</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td>"+
                    "</tr><tr><td>13:20</td><td>3</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td>"+
                    "</tr><tr><td>5:20</td><td>5</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td>"+
                    "</tr><tr><td>2:20</td><td>19</td><td>30</td><td> <button class=\"am-btn am-btn-success am-btn-sm\" name=\"#\" id=\"#\">购 票</button></td></tr>"+
                    "</tbody></table></div><div class=\"am-tab-panel\">暂无播放计划</div></div></div>");
	}
	
}
