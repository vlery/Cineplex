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
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
  <script type="text/javascript">
    
    </script>
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
								              			mail=unreadList.getItem(i);
								              			if(mail.getType()==1){
						                     %>
						                     
						                     	 <div class="am-panel am-panel-default">
						                        <div class="am-panel-hd">
						                          <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="mail" property="mailId" />'}">
						                             申请通过！
						                          </h4>
						                        </div>
						                        <div id="<jsp:getProperty name="mail" property="mailId" />" class="am-panel-collapse am-collapse">
						                          <div class="am-panel-bd">
						                                                  <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
						                                                        <label class="am-text-sm">
						                                                      		 <jsp:getProperty name="mail" property="content" />
						                                                        </label>
						                                                        <br/>
						                                          </div>
						                          </div>
						                        </div>
						                      </div>
						                     	
											<% }else{%>

      
							                      <div class="am-panel am-panel-default">
							                        <div class="am-panel-hd">
							                          <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="mail" property="mailId" />'}">修改意见！</h4>
							                        </div>
							                        <div id="<jsp:getProperty name="mail" property="mailId" />" class="am-panel-collapse am-collapse">
							                          <div class="am-panel-bd">
							                                       <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
							                                              
							                                                       
							                                                        <label class="am-text-sm">
								                                                         	<jsp:getProperty name="mail" property="content" />
							                                                        </label>
							
							                                                        <br/>
							                                                     
							
							
							
							                                          </div>
							                          </div>
							                        </div>
							                      </div>



											<%}} %>

						                      						               
						                    
						          </div>	
				              </div>
				          </div>
				          
				          
				          
				          
				          
				          <div class="am-tab-panel am-fade am-g" id="readed">
				                  <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				       						     <%  for(int i=0;i<readedList.getSize();i++) {
						                     
								                     	pageContext.setAttribute("mail", readedList.getItem(i));
								              			mail=readedList.getItem(i);
								              			if(mail.getType()==1){
						                     %>
						                     
						                     	 <div class="am-panel am-panel-default">
						                        <div class="am-panel-hd">
						                          <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="mail" property="mailId" />'}">
						                             申请通过！
						                          </h4>
						                        </div>
						                        <div id="<jsp:getProperty name="mail" property="mailId" />" class="am-panel-collapse am-collapse">
						                          <div class="am-panel-bd">
						                                                  <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
						                                                        <label class="am-text-sm">
						                                                      		 <jsp:getProperty name="mail" property="content" />
						                                                        </label>
						                                                        <br/>
						                                          </div>
						                          </div>
						                        </div>
						                      </div>
						                     	
											<% }else{%>

      
							                      <div class="am-panel am-panel-default">
							                        <div class="am-panel-hd">
							                          <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="mail" property="mailId" />'}">修改意见！</h4>
							                        </div>
							                        <div id="<jsp:getProperty name="mail" property="mailId" />" class="am-panel-collapse am-collapse">
							                          <div class="am-panel-bd">
							                                       <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
							                                              
							                                                       
							                                                        <label class="am-text-sm">
								                                                         	<jsp:getProperty name="mail" property="content" />
							                                                        </label>
							
							                                                        <br/>
							                                                     
							
							
							
							                                          </div>
							                          </div>
							                        </div>
							                      </div>



											<%} }%>
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