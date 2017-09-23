<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="feedback" uri="/WEB-INF/tlds/hallCreateFeedback.tld" %>
<jsp:useBean id="hallVO" 
    type="net.cineplex.webmodel.HallVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="row" 
    class="net.cineplex.webmodel.Row"
    scope="page">
</jsp:useBean>
<html>
<head>
  <meta charset="utf-8">
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
</head>
<body>


<%@ include file="header.jsp" %>
 
<div class="am-cf admin-main">
 	 <!-- sidebar start -->
 		<%@ include file="side_bar.jsp" %>
  	 <!-- sidebar end -->

 
  	 <!-- content start -->
   		<div class="admin-content">

			    <div class="am-cf am-padding">
			      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">影厅管理</strong> / <small>hall</small></div>
					      <br/>
					      <div class="am-tabs am-margin" data-am-tabs>
					        <ul class="am-tabs-nav am-nav am-nav-tabs">
					          <li class="am-active"><a href="#add">添加</a></li>
					        </ul>
					
					
						    <div class="am-tabs-bd">
						          <div class="am-tab-panel am-fade am-in am-active am-g" id="add">
						              <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
						              <feedback:show/>
						              <form  class="am-form" method="post" action="/cineplex/hallCreate">
						                  
						                    <label for="hname">影厅名 :</label>
						                    <input  type="text" id="hname" name="hname" value="<jsp:getProperty name="hallVO" property="name" />"required ></input> 
						                    <label for="row">排号:</label>
						                    <input  type="text" id="row" name="row"  ></input> 
						                    <label for="seat">座位数:</label>
						                    <input  type="text" id="seat" name="seat" ></input> 
						                    <br/>
						                    <div>
						                    <input type="submit" name="addRow" value="&nbsp; &nbsp;添 加&nbsp; &nbsp;" 
						                    		class="am-btn am-btn-primary am-btn-sm am-fr">
						                    </div>
						                    <br/>
						                    <hr/>
						                    <table class="am-table am-table-bordered am-table-radius am-table-striped" 
						                    		style="font-size:80%">
						                        
						                        <tr>
						                          <td>排号</td>
						                          <td>座位数</td>
						                        </tr>
						                        <%  if(hallVO.getRowNum()>0){
						                        
						                        for(int i=0;i<hallVO.getRowNum();i++){ 
						                        	row=hallVO.getItem(i); %>
						                        	<tr>
						                        		<td><% out.println(row.getIndex()); %> </td>
						                        		<td><% out.println(row.getSeats()); %></td>
						                        	<tr/>
						                        <% }} %>
						                    </table>
						                    
						                    <input type="submit" name="create" value="&nbsp; &nbsp;确 定&nbsp; &nbsp;" 
						                    		class="am-btn am-btn-primary am-btn-sm am-fr" >
						
						              </form>
						              </div>
						           </div>
						    </div>     
					
						</div>
					
			    </div>
		</div>
			
	<!-- content end -->

</div>


<%@ include file="footer.jsp" %>

</body>
</html>