<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="quizList" 
    type="net.cineplex.webmodel.UserQuizList"
    scope="session">
</jsp:useBean>

<jsp:useBean id="movieQuiz" 
    class="net.cineplex.webmodel.UserQuizListByMovie"
    scope="page">
</jsp:useBean>
<jsp:useBean id="quiz" 
    class="net.cineplex.webmodel.UserQuizVO"
    scope="page">
</jsp:useBean>
<jsp:useBean id="choice" 
    class="net.cineplex.model.Choice"
    scope="page">
</jsp:useBean>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 
	<title>影院在线-活动</title>
	<%@ include file="import.jsp" %>
	<script type="text/javascript">
 		function back(){
 			var url="info?panel=qhistory_panel";
        	window.location.href = url;
 		}

      function choose(radio){
        ifChoose=false;
        var obj=document.getElementsByName(radio);
		var choice;
        for(var i=0;i<obj.length;i++){
            if(obj[i].checked){
                ifChoose=true;
                choice=obj[i].value;
            }
        }

        
        if(ifChoose){	
        	<%
        	String path = request.getContextPath(); 
        	String basePath = request.getScheme()+"://"+request.getServerName()+":"+
        	request.getServerPort()+path+"/"; 
        	//System.out.println(basePath);
        	%>
        	  
        	
         	$.ajax({ 
         		type : "POST", 
         		url : "<%=basePath %>chooseQuiz?choice="+choice , 
         		error:function(){
         			alert("提交失败！");
         		},
         			//function(XMLHttpRequest, textStatus, errorThrown) {
                   // alert(XMLHttpRequest.status);
                   // alert(XMLHttpRequest.readyState);
                   // alert(textStatus);
                //},
         		success : function() { 
         		
         			alert("提交成功！");
         		} 
         		}); 
         	
        }else{
       	    alert("请选择一项！");
        }
      }

    </script>
	
</head>
<body>
	<%@ include file="../header.jsp" %>
	<br/>
	<div class="am-g">
  		<div class="am-u-lg-8 am-u-md-8 am-u-sm-centered" >
  		
  			              <label style="font-size:150%"><strong>&nbsp; &nbsp;活 动</strong></label>  

              <button  name="choose"  class="am-btn am-btn-primary am-btn-xs am-fr" onclick="back();">&nbsp; &nbsp;返 回&nbsp; &nbsp;</button>
              <br/>
              <br/>
              <div class="am-panel-group" id="accordion">
              			<% if(quizList.getSize()==0){
              				out.print("<br/><br/>");
              				out.print("<br/>");
              				out.print("<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
              				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;暂无</label>");
              				out.print("<br/><br/>");
              				out.print("<br/><br/>");
              			
              			}
              					
              			%>
              			<% for(int i=0;i<quizList.getSize();i++){
              				pageContext.setAttribute("movieQuiz",quizList.getItem(i));
              				movieQuiz=quizList.getItem(i);
              				%>
                        <div class="am-panel am-panel-default">
                          
                        
                          <div class="am-panel-hd">
	                            <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#<jsp:getProperty name="movieQuiz" property="movie" />'}">
	                              	<jsp:getProperty name="movieQuiz" property="movie" />	
	                            </h4>
                          </div>
                          <div id="<jsp:getProperty name="movieQuiz" property="movie" />" class="am-panel-collapse am-collapse <% if(i==0){out.print("am-in"); }%>">
	                            <div class="am-panel-bd">
	                                   <% for(int j=0;j<movieQuiz.getSize();j++){
              									quiz=movieQuiz.getItem(j);
              							%>
	                                   <h3><% out.print(quiz.getQuiz().getQuestion()); %></h3>
	                                          <% for(int n=0;n<quiz.getChoiceNum();n++){ 
	                                          		choice=quiz.getItem(n);
	                                          		pageContext.setAttribute("choice",quiz.getItem(n));
	                                          %>
	                                          <label class="am-radio">
	                                            <input type="radio" name="<% out.print(quiz.getQuiz().getQid()); %>" value="<jsp:getProperty name="choice" property="cid" />" data-am-ucheck >
	                                            	<jsp:getProperty name="choice" property="answer" /> 
	                                          </label>
	                                         
	                                 		<%} %>
	                                    <button  name="choose"  class="am-btn am-btn-primary am-btn-xs am-fr" onclick="choose('<% out.print(quiz.getQuiz().getQid()); %>');">&nbsp; &nbsp;提 交&nbsp; &nbsp;</button>
	                                  
	                                    <br/>
	                                    <hr/>
	                                    <%} %>
	                                    
	                              
	
	                            </div>
                          </div>
                          
                          
                          
                        </div>
                        <%} %>
              </div>
  		
  		
  		
  		</div>
  		<br/><br/><br/><br/><br/><br/>
   		<%@ include file="../footer.jsp" %>
  	</div>
</body>
</html>