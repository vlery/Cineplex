<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="movie" uri="/WEB-INF/tlds/movieType.tld" %>
<%@ taglib prefix="plan" uri="/WEB-INF/tlds/plan.tld" %>
<jsp:useBean id="movie" 
    type="net.cineplex.webmodel.MovieVO"
    scope="session">
</jsp:useBean>

<jsp:useBean id="planList" 
    type="net.cineplex.webmodel.PlanListVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="moviePlan" 
   	class="net.cineplex.webmodel.MoviePlanByDay"
    scope="page">
</jsp:useBean>
<jsp:useBean id="planItem" 
   	class="net.cineplex.webmodel.PlanVO"
    scope="page">
</jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 class="am-text-xxl"><b>电影名：<jsp:getProperty name="movie" property="name" /></b></h1>
      <div class="am-g">
		<div class="am-u-lg-3 am-u-md-2 am-u-sm-2">
               <img src="/cineplex/system/assets/i/<jsp:getProperty name="movie" property="mid" />.jpg" alt="movie<jsp:getProperty name="movie" property="mid" />" />
        </div>
        <div class="am-u-lg-6 am-u-md-7 am-u-sm-7">
             	<p><jsp:getProperty name="movie" property="introduction" />
                </p>
        </div>
        <div class="am-u-lg-3 am-u-md-3 am-u-sm-3">
          		<div> 
          			<label >电影时长:&nbsp;&nbsp;</label>
          			<label class="am-text-xxl"><jsp:getProperty name="movie" property="duration" /> </label>
          			<label>分钟</label>
          		</div>
                <hr/>
                <div>
                	<label >下线日期:&nbsp;&nbsp;</label>
                	<label class="am-text-xl"><jsp:getProperty name="movie" property="downline" /></label>
                </div>
        </div>
              
      </div>
      <br/>
    	<movie:type />
      <hr/>
      <div>
         <div>
         	<label class="am-text-lg" >选择日期:  </label>
         </div>
         <br/>
		 <div class="am-tabs" data-am-tabs>
				<ul class="am-tabs-nav am-nav am-nav-tabs">
                        <% for(int i=0;i<planList.getSize();i++ ){ %>
                        <li <%  if(i==0){
                        			out.print("class=\"am-active\"");
                        		}                        
                        	%>
                        ><a href="javascript: void(0)"><%  
                        	String[] sp= planList.getItemByTime(i).getDay().split("-");
                        		out.print(sp[1]);
                        		out.print("月");
                        		out.print(sp[2]);
                        		out.print("日");
                        		%></a></li>
                        <% }%>
                        
                </ul>
				
                <div class="am-tabs-bd">
                <% for(int i=0;i<planList.getSize();i++) {
                	pageContext.setAttribute("moviePlan",planList.getItemByTime(i) ); 
                	moviePlan=planList.getItemByTime(i);
                	%>
                	
                        <div class="am-tab-panel    
                        	<%  if(i==0){
                        			out.print(" am-active");
                        		}                        
                        	%>">
                              <table class="am-table am-table-striped am-table-hover">
                                    <thead>
                                        <tr>
                                            <th>放映时间</th>
                                            <th>放映厅</th>
                                            <th>票价（元）</th>
                                            <th>选座购票</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <% for(int j=0;j<moviePlan.getSize();j++){ 
                                    	  pageContext.setAttribute("planItem",moviePlan.getItem(j) );
                                    	  planItem=moviePlan.getItem(j);
                                       	%>
                                        <tr>
                                            <td><jsp:getProperty name="planItem" property="time" /></td>
                                            <td><jsp:getProperty name="planItem" property="hall" /></td>
                                            <td><jsp:getProperty name="planItem" property="price" /></td>
                                            <td> <button class="am-btn am-btn-success am-btn-sm" name="<jsp:getProperty name="planItem" property="pid" />" id="<jsp:getProperty name="planItem" property="pid" />" onclick="
                                            <% if(null!=session.getAttribute("crtUser")){
                                            				out.print("buyTicket("+planItem.getPid()+");");
                                            	}else{
                                            				out.print("alertLog();");	
                                            	}
                                            	%>
                                            ">购 票</button></td>
                                        </tr>
                                        <%} %>  
                                   </tbody>
                                </table>
                        </div>
                        
                    
               	
               	<%} %>
          		</div>
	  	 </div>
	  </div>
	  <br/>