<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="readedList" 
    type="net.cineplex.webmodel.MailList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="unreadList" 
    type="net.cineplex.webmodel.MailList"
    scope="session">
</jsp:useBean>

<jsp:useBean id="mail" 
    class="net.cineplex.model.Mail"
    scope="page">
</jsp:useBean>


<html>
<head>
  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>
  
  <script type="text/javascript">
    
    </script>
</head>
<body>


<%@ include file="header.jsp" %>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  	<%@ include file="sidebar.jsp" %>
  <!-- sidebar end -->

 
 
  	 <!-- content start -->
   	<div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">邮件</strong> / <small>mail</small></div>
		      <br/>
		      
		      <div class="am-tabs am-margin" data-am-tabs>
				        <ul class="am-tabs-nav am-nav am-nav-tabs">
				          <li class="am-active"><a href="#unread">未读</a></li>
				          <li ><a href="#readed">已读</a></li>
				        </ul>
		        
				        <div class="am-tabs-bd">
				          <div class="am-tab-panel am-fade am-in am-active am-g" id="unread">
				              <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				         		 <div class="am-panel-group" id="accordion">
						                     <%  for(int i=0;i<unreadList.getSize();i++) {
						                     
								                     	pageContext.setAttribute("mail", unreadList.getItem(i));
								              			mail= unreadList.getItem(i);
						                     %>
						                     
						                     	<div class="am-panel am-panel-default">
						                        <div class="am-panel-hd">
						                          <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="mail" property="mailId" />'}">                         
						                            		新电影申请！                   
						                          </h4>
						                        </div>
						                        <div id="<jsp:getProperty name="mail" property="mailId" />" class="am-panel-collapse am-collapse am-in">
						                          <div class="am-panel-bd">
						                                       <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
						                      									<jsp:getProperty name="mail" property="content" />
						                                                        <br/>
						                                                        <br/>
						                                                        <% 	if(mail.getType()==0){%>
						                                                        <form method="post" class="am-form" action="replyMail?mail=<jsp:getProperty name="mail" property="mailId" />"  data-am-validator>
							                                                        <div>
							                                                          <button  name="success"  class="am-btn am-btn-primary am-btn-xs am-fr" >
							                                                              &nbsp; &nbsp;通 过&nbsp; &nbsp;
							                                                          </button>
							                                                         <label class="am-fr"> &nbsp;&nbsp;</label>
							                                                            <button  name="fail"  class="am-btn am-btn-primary am-btn-xs am-fr" >
							                                                              &nbsp; &nbsp;回 复&nbsp; &nbsp;
							                                                          </button>
							                                                          <div class="am-u-sm-9 am-u-md-9 am-u-lg-9">
							                                                            <input   style="font-size:75%" type="text" name="replyMsg" id="replyMsg" placeholder="请输入修改意见"  required/>
							                                                          </div>
							                                                        </div>
							
							                                                       <br/>
						                                                     
						                                                        </form>
																				<% }%>
						                                          				<br/>
													          </div>
						                          </div>
						                        </div>
						                      	</div>
						                      	<%
						                      		}
						                      	%>    
						          </div>	
				              </div>
				          </div>
				          
				          
				          
				          
				          
				          <div class="am-tab-panel am-fade am-g" id="readed">
				                  <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				                      	  <%  for(int i=0;i<readedList.getSize();i++) {
						                     
								                     	pageContext.setAttribute("mail", readedList.getItem(i));
						                     			mail=readedList.getItem(i);
						                    %>
				                               
				                                      	<div class="am-panel am-panel-default">
						                        <div class="am-panel-hd">
						                          <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="mail" property="mailId" />'}">                         
						                            		新电影申请！                   
						                          </h4>
						                        </div>
						                        <div id="<jsp:getProperty name="mail" property="mailId" />" class="am-panel-collapse am-collapse am-in">
						                          <div class="am-panel-bd">
						                                       <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
						                      									<jsp:getProperty name="mail" property="content" />
						                                                        <br/>
						                                                        <br/>
						                                                        <% 	if(mail.getType()==0){%>
						                                                        
						                                                        <form method="post" class="am-form" action="../../replyMail?mail=<jsp:getProperty name="mail" property="mailId" />"  data-am-validator>
							                                                        <div>
							                                                          <button  name="success"  class="am-btn am-btn-primary am-btn-xs am-fr" >
							                                                              &nbsp; &nbsp;通 过&nbsp; &nbsp;
							                                                          </button>
							                                                         <label class="am-fr"> &nbsp;&nbsp;</label>
							                                                            <button  name="fail"  class="am-btn am-btn-primary am-btn-xs am-fr" >
							                                                              &nbsp; &nbsp;回 复&nbsp; &nbsp;
							                                                          </button>
							                                                          <div class="am-u-sm-9 am-u-md-9 am-u-lg-9">
							                                                            <input   style="font-size:75%" type="text" name="replyMsg" id="replyMsg" placeholder="请输入修改意见" required />
							                                                          </div>
							                                                        </div>
							
							                                                       <br/>
						                                                     
						                                                        </form>
						                                                        <% }%>
			
						                                          				<br/>
													          </div>
						                          </div>
						                        </div>
						                      	</div>             
				                            <%} %>
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