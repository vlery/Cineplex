<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="passwordFeedback" uri="/WEB-INF/tlds/changePasswordFeedback.tld" %>
<%@ taglib prefix="infoFeedback" uri="/WEB-INF/tlds/changeInfoFeedback.tld" %>

<jsp:useBean id="anchor" 
    type="net.cineplex.webmodel.Anchor"
    scope="session">
</jsp:useBean>

<jsp:useBean id="crtUserInfo" 
    type="net.cineplex.webmodel.RegisterInfo"
    scope="session">
</jsp:useBean>
<jsp:useBean id="crtUser" 
    type="net.cineplex.model.Member"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movieHistoryList" 
    type="net.cineplex.webmodel.MovieHistoryList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="quizHistoryList" 
    type="net.cineplex.webmodel.QuizHistoryList"
    scope="session">
</jsp:useBean>

<jsp:useBean id="quizVO" 
    class="net.cineplex.webmodel.QuizVO"
    scope="page">
</jsp:useBean>

<jsp:useBean id="movieVO" 
   	class="net.cineplex.webmodel.MovieHistoryVO"
    scope="page">
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院在线-个人资料</title>
<%@ include file="import.jsp" %>

<script language="javascript">  
             
           function jump(panel){
            	 document.getElementById(panel).scrollIntoView();
             }
             //location.hash="#<jsp:getProperty name="anchor" property="panel" />";  
</script>

</head>

<body onload="jump('<jsp:getProperty name="anchor" property="panel" />');">
	<%@ include file="../header.jsp" %>
	<br/>
	<div class="am-g">
  			<div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
  				<%@ include file="info_navi.jsp" %>
  				<br/>
  				<br/>
  				<a name="password_panel" id="password_panel"></a>
  			  	<div  > 
      				<label class="am-text-xl">密码修改</lable>
    			</div>
	   			
	   			<div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
         			<form method="post" action="changePassword" class="am-form" data-am-validator>
           				<passwordFeedback:show />
           				<div class="am-form-group">
              				<label for="old_password">旧密码：</label>
              					<input  class="modify_input" type="password" id="old_password" name="old_password" minlength="0"
                     placeholder="" required/>
            			</div>
            			<div class="am-form-group">
              				<label for="new_password">密码：</label>
              				<input class="modify_input"  type="password" id="new_password" name="new_password" placeholder="" minlength="6" required/>
            			</div>	

            			<div class="am-form-group">
              				<label for="confirm_new_password">确认密码：</label>
			              	<input class="modify_input" type="password" id="confirm_new_password" name="confirm_new_password" placeholder="" data-equal-to="#new_password" required/>
			            </div>
			            <br/>
			            <div>
			                <input type="submit" name="modify_password" value="修 改" class="am-btn am-btn-primary am-btn-sm modify_button am-fr">
			            </div>
			            <br/>
			         </form>
			    </div>
    			<br/>
    			<hr/>

				<a name="info_panel" id="info_panel"></a>
			    <div >
			      <label class="am-text-xl">其他信息</lable>
			    </div>	
			    <div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
			      
			        <form method="post" action="changeOtherInfo" class="am-form" data-am-validator>
			            <infoFeedback:show />
			            <div class="am-form-group">
			              <label for="nickname">昵称:</label>
			              <input class="modify_input" type="text" name="nickname" id="nickname" value="<jsp:getProperty name="crtUser" property="nickName" />">
			            </div>
			
			            <div class="am-form-group">
			              <label  for="name" >真实姓名:</label>
			              <input class="modify_input " type="text" name="name" id="name" value="<jsp:getProperty name="crtUserInfo" property="name" />"  disabled>
			            </div>
			          
			            <div class="am-form-group">
			                <label  for="gender" >性别:</label>
			                <br/>
			           
			                <div class="am-u-sm-2 am-u-md-3 am-u-lg-3">
			                  <label class="am-radio">
			                    <input  type="radio" name="gender" value="男" data-am-ucheck required 
			                    <% if(crtUserInfo.checkGender("男")){
				           			  out.println("checked");	
				           			}
				           		%>
				           		> 男
			                  </label>
			                </div>
			                <div class="am-u-sm-10 am-u-md-9 am-u-lg-9">
			                  <label class="am-radio">
			                    <input type="radio" name="gender" value="女" data-am-ucheck
			                     <% if(crtUserInfo.checkGender("女")){
				           			  out.println("checked");	
				           			}
				           		%>
				           		> 女
			                  </label>
			                </div>
			            </div>
			
			
			            <div >
			              <label  for="birthday" >出生日期:</label>
			              <div class="am-input-group am-datepicker-date" data-am-datepicker="{format: 'yyyy-mm-dd', viewMode: 'years'}">
			                <input type="text" class="am-form-field" name="birthday" id="birthday" value="<jsp:getProperty name="crtUserInfo" property="birthday" />" readonly  >
			                <span class="am-input-group-btn am-datepicker-add-on">
			                   <button class="am-btn am-btn-default" type="button"><span class="am-icon-calendar"></span> </button>
			                </span>
			              </div>
			            </div>
			
			            <div class="am-form-group">
			                <label  for="mail" >邮箱:</label>
			                <input class="modify_input" type="email" name="mail" id="mail" value="<jsp:getProperty name="crtUserInfo" property="mail" />"  required>
			            </div>
			
			            <div class="am-form-group">
			               <label  for="tel" >电话:</label>
			               <input class="register_input" type="text" name="tel" id="tel" value="<jsp:getProperty name="crtUserInfo" property="tel" />">
			         	  </div>
			
			            <div class="am-form-group">
			                <label  for="bankID" >银行卡号:</label>
			                <input class="modify_input" type="text" name="bankID" id="bankID" value="<jsp:getProperty name="crtUserInfo" property="bankID" />"  >
			            </div>
			
			            
			            <br/>
			            <div>
			                <input type="submit" name="modify_password" value="修 改" class="am-btn am-btn-primary am-btn-sm modify_button am-fr">
			            </div>
			             <br/>
			        </form>
			    </div>
			    <br/>
			    <hr/>
			  
			  <a name="mhistory_panel" id="mhistory_panel"></a>
			    <div >
			      <label class="am-text-xl">观影历史</lable>
			    </div>
			    <div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
			         
			          <table class="am-table am-table-striped am-table-hover">
			              <thead>
			                  <tr>
			                      <th>&nbsp;&nbsp;日期</th>
			                      <th>影片</th>
			                  </tr>
			              </thead>
			              <tbody>
			              <%  int j=5;
			              	  if(movieHistoryList.getSize()<10){
			              		  j=movieHistoryList.getSize();
			              	  }
			              	  for(int i=0;i<j;i++){ 
			            	  pageContext.setAttribute("movieVO",movieHistoryList.getItem(i));
			              		%>
			                  <tr>
			                      <td>&nbsp;&nbsp;<jsp:getProperty name="movieVO" property="day" /></td>
			                      <td><jsp:getProperty name="movieVO" property="movie" /></td>
			                      
			                  </tr>
			              <%} %>
			                  
			              </tbody>
			          </table>
			      
			          <button  class="am-btn am-btn-primary am-btn-sm modify_button am-fr" ><a style="color:white;" href="system/user/movie_history.jsp" target="_blank">查看完整历史</a></button>
			
			          <br/>
			
			    </div>
			    <br/>
			    <hr/>
			
				<a name="qhistory_panel" id="qhistory_panel"></a>
			    <div >
			    	<label class="am-text-xl">参与活动</lable>
			    </div>
			    <div class="modify_panel am-u-lg-8 am-u-md-9 am-u-sm-centered am-g-collapse">
			         
			          <table class="am-table am-table-striped am-table-hover">
			              <thead>
			                  <tr>
			                      <th>&nbsp;&nbsp;影片</th>
			                      <th>问题</th>
			                      <th>获取积分</th>
			                  </tr>
			              </thead>
			              <tbody>
			                  <% int n=7;
			                  		if(quizHistoryList.getSize()<7){
			                  			n=quizHistoryList.getSize();
			                  		}
			                  
			                  for(int i=0;i<n;i++){
			                	  pageContext.setAttribute("quizVO",quizHistoryList.getItem(i));
			                	  quizVO=quizHistoryList.getItem(i);
			                	  %>
			                  
			                  <tr>
			                      <td>&nbsp;&nbsp;<jsp:getProperty name="quizVO" property="movie" /></td>
			                      <td><% if(quizVO.getQuestion().length()>10){
			                    	  		out.print(quizVO.getQuestion().substring(0,10)+"..."); 
			                      		}else{
			                      			out.print(quizVO.getQuestion());
			                      		}%>
			                      </td>
			                      <td><jsp:getProperty name="quizVO" property="result" /></td>
			                  </tr>
			                  <%} %>
			              </tbody>
			          </table>
			      
			          <button  class="am-btn am-btn-primary am-btn-sm modify_button am-fr" ><a style="color:white;"  href="doQuiz">参与新活动</a></button>
			          <label class="am-fr">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			          <button  class="am-btn am-btn-primary am-btn-sm modify_button am-fr" ><a style="color:white;"  href="system/user/quiz_history.jsp" target="_blank">查看参与历史</a></button>
		
			          <br/>
			
			   </div>
			   <br/>
			   <hr/>
		    </div>  
		    <br/>
		    <br/>
			
			  
		    <div class="footer">
			    <p> 2014&nbsp;&nbsp;&nbsp;J2EE-Project&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cineplex System&nbsp;&nbsp;&nbsp;by&nbsp;&nbsp;&nbsp;121250084</p>
			    <br/>
		   </div>
  					
	</div>
</body>
</html>