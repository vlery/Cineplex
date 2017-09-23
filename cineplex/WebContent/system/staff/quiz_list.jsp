<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="a_feedback" uri="/WEB-INF/tlds/quizCreateFeedback.tld" %>
<%@ taglib prefix="d_feedback" uri="/WEB-INF/tlds/quizDeleteFeedback.tld" %>
<jsp:useBean id="movieModList" 
    type="net.cineplex.webmodel.MovieModifiableList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movie" 
	class="net.cineplex.model.Movie"
	scope="page">
</jsp:useBean>
<jsp:useBean id="selectList" 
    type="net.cineplex.webmodel.SelectList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="quiz" 
    type="net.cineplex.model.Quiz"
    scope="session">
</jsp:useBean>

<jsp:useBean id="quizList" 
    type="net.cineplex.webmodel.QuizList"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movieQuiz" 
	class="net.cineplex.webmodel.MovieQuiz"
	scope="page">
</jsp:useBean>
<jsp:useBean id="quizItem" 
	class="net.cineplex.model.Quiz"
	scope="page">
</jsp:useBean>


<html>
<head>
  <meta charset="utf-8">
  <title>影院在线——服务员</title>
  <%@ include file="import.jsp" %>
  
  <script type="text/javascript">
      function deleteQuiz(index){
    	  
    	  var url="/cineplex/quizDelete?quiz="+index;
    	  window.location.href = url;
        }
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
      <div class="am-fl am-cf">
      		<strong class="am-text-primary am-text-lg">制定活动</strong> / <small>quiz</small>
      </div>
		      <br/>
		      
		      <div class="am-tabs am-margin" data-am-tabs>
				        <ul class="am-tabs-nav am-nav am-nav-tabs">
				          <li><a href="#add">添加</a></li>
				          <li class="am-active" ><a href="#modify">修改</a></li>
				        </ul>
		        
				        <div class="am-tabs-bd">
				          <div class="am-tab-panel am-fade" id="add">
				              <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
				              		<a_feedback:show/>
				              		<form  class="am-form" method="post" action="/cineplex/quizCreate">
					                    <label for="movie">电影:</label>
					                   
					                    <select name="movie" id="movie"  required>
					                     <option value=""></option>
						                      <% for(int i=0;i<movieModList.getSize();i++){ 
					                    	  pageContext.setAttribute("movie",movieModList.getItem(i)); 
					                    	  	movie=movieModList.getItem(i); %>
					                      		<option value="<jsp:getProperty name="movie" property="mid" />"
					                      			<% if(quiz.getMid().equals(movie.getMid())){
					                      					out.print("selected");
					                      			}
					                      			%>
					                      		>
					                      		<jsp:getProperty name="movie" property="name" />
					                      		</option>
					                      <% } %>
					                    </select>
					                    <br/>
					                    <label for="question" required>题目:</label>
					                    <input  type="text" id="question" name="question" value="<jsp:getProperty name="quiz" property="question" />"></input> 
					                    <br/>
					
					                    <label for="select">选项:</label>
					                    <input  type="text" id="select" name="select"></input> 
					                    <br/>
					                    
					                    <div>
					                    <input type="submit" name="add" value="&nbsp; &nbsp;添 加&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
					                    </div>
					                    
					                    <br/>
					                    <br/>
					                    <hr/>
					                    <table class="am-table am-table-striped am-table-hover" style="font-size:80%">
					                        <tr>
					                          <td><b>选项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
					                          <td></td>
					                        </tr>
					                         <% for(int n=0;n<selectList.getSize();n++){  %>
					                         
					                         <tr>
					                          <td><% out.print(selectList.getItem(n)); %></td>
					                          <td><button class="am-btn am-btn-success am-btn-sm" 
					                          			name="<% out.print(n); %>" id="<% out.print(n); %>"
					                          			onclick="delectSelect(<% out.print(n); %>);" >删除</button></td>
					                        </tr>
					                        
					                    	<% } %>
					                 
					
					                    </table>
					                    
					                    <input type="submit" name="create" value="&nbsp; &nbsp;确 定&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
					              </form>
				              	
				              </div>
				          </div>
				          
				          
				          <div class="am-tab-panel am-fade am-in am-active am-g" id="modify">
				                <div class="am-u-sm-centered am-u-md-11 am-u-lg-10">
				                   <d_feedback:show/>
			                       <div class="am-panel-group" id="accordion">
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
				
				                              	<div id="<jsp:getProperty name="movieQuiz" property="movie" />" class="am-panel-collapse am-collapse ">
				                                	<div class="am-panel-bd">
				                                        <table class="am-table am-table-striped am-table-hover" style="font-size:80%">
				                                            <tr>
				                                              <td><b>题目&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
				                                              <td></td>
				                                            </tr>
				                                             <% for(int j=0;j<movieQuiz.getQuestionNum();j++){  
				                                             	pageContext.setAttribute("quizItem",movieQuiz.getQuestion(j));
			                            						quizItem=movieQuiz.getQuestion(j);
			                            					 %>
				                                             <tr>
					                                              <td><jsp:getProperty name="quizItem" property="question" /></td>
					                                              <td><button class="am-btn am-btn-success am-btn-sm" 
					                                              				name="<% out.print(quizItem.getQid() ); %>" 
					                                              					id="<% out.print(quizItem.getQid() ); %>"
					                                              					 onclick="deleteQuiz(<% out.print(quizItem.getQid() ); %>)">删除
					                                              		</button>
					                                              </td>
				                                             </tr>
				                                             <% } %>
				                                        </table>
				                                	</div>
				                              	</div>
				                            
				                            </div>
			                            <% } %>
			                            
			                        </div>

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