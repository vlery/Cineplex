<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="movie" 
    type="net.cineplex.webmodel.MovieVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="type" 
    class="net.cineplex.webmodel.MovieType"
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

  <%@ include file="side_bar.jsp" %>


 
  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">电影管理</strong> / <small>movie</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
        <ul class="am-tabs-nav am-nav am-nav-tabs">
          <li><a href="#add">添加</a></li>
          <li class="am-active" ><a href="#modify">修改</a></li>
        </ul>

        <div class="am-tabs-bd">
          <div class="am-tab-panel am-fade" id="add">
              <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
                <form  class="am-form" method="post" action="/cineplex/addMovie">
                  
                    <label for="mname">电影名 :</label>
                    <input  type="text" id="mname" name="mname"></input> 
                    <label for="duration">时长（分钟）:</label>
                    <input  type="text" id="duration" name="duration"></input> 
                    <label for="online">上线日期:</label>
                    <input type="text" class="am-form-field" placeholder="" id="online" name="online" data-am-datepicker readonly/>
                    <label for="downline">下线日期:</label>
                    <input type="text" class="am-form-field" placeholder="" id="downline" name="downline" data-am-datepicker readonly/>
                    <label for="post">海报：</label>
                    <input type="file" id="post">
                    <hr/>
                    <label> 介绍:</label>
                    <textarea rows="20" id="introduction" name="introduction"></textarea>

                    <br/>
                    <input type="submit" name="add" value="&nbsp; &nbsp;添 加&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
              </form>
              </div>
           </div>
           
           
          <div class="am-tab-panel am-fade am-in am-active am-g" id="modify">
		          		  <div class="am-u-sm-centered am-u-md-8 am-u-lg-7">
			              <form  class="am-form" method="post" action="/cineplex/modifyMovie" >
			                  
			                    <label for="md_mname">电影名 :</label>
			                    <input  type="text" id="md_mname" name="md_mname" value="<jsp:getProperty name="movie" property="name" />"></input> 
			                    <label for="md_duration">时长（分钟）:</label>
			                    <input  type="text" id="md_duration" name="md_duration" value="<jsp:getProperty name="movie" property="duration" />"></input> 
			                    <label for="md_online">上线日期:</label>
			                    <input type="text" class="am-form-field" value="<jsp:getProperty name="movie" property="online" />" id="md_online" name="md_online" data-am-datepicker readonly/>
			                    <label for="md_downline">下线日期:</label>
			                    <input type="text" class="am-form-field" value="<jsp:getProperty name="movie" property="downline" />" id="md_downline" name="md_downline" data-am-datepicker readonly/>
			                            <label for="movietype">类型：</label>
                    <div>
                    	<% type=movie.getType();          			%>
                      <select id="movietype" name="movietype" multiple data-am-selected>
                   
                        <option value="0"  <% if(type.ifIn("0")){out.print("selected");} %>>爱情片</option>
                       
                        <option value="2"  <% if(type.ifIn("2")){out.print("selected");} %>>喜剧片</option>
                       
                        <option value="5"  <% if(type.ifIn("5")){out.print("selected");} %>>文艺片</option>
                        <option value="6"  <% if(type.ifIn("6")){out.print("selected");} %>>音乐片</option>
                        <option value="7"  <% if(type.ifIn("7")){out.print("selected");} %>>歌舞片</option>
                        <option value="8"  <% if(type.ifIn("8")){out.print("selected");} %>>动漫片</option>
                       
                        
                        <option value="10"  <% if(type.ifIn("10")){out.print("selected");} %>>武侠片</option>
                       
                        <option value="12"  <% if(type.ifIn("12")){out.print("selected");} %>>动作片</option>
                        <option value="13"  <% if(type.ifIn("13")){out.print("selected");} %>>恐怖片</option>
                  
                       
                       
                        <option value="18"  <% if(type.ifIn("18")){out.print("selected");} %>>记录片</option>
                        <option value="19"  <% if(type.ifIn("19")){out.print("selected");} %>>战争片</option>
                        <option value="20"  <% if(type.ifIn("20")){out.print("selected");} %>>历史片</option>
                        
                        <option value="21"  <% if(type.ifIn("21")){out.print("selected");} %>>传记片</option>
                        
                        <option value="24"  <% if(type.ifIn("24")){out.print("selected");} %>>魔幻片</option>
                     
                        
                      </select>
                    </div>
			                    
			                    
			                    
			                    <label for="md_post">海报：</label>
			                    <input type="file" id="md_post">
			                    <hr/>
			                    <label> 介绍:</label>
			                    <textarea rows="20" id="md_introduction" name="md_introduction"><jsp:getProperty name="movie" property="introduction" /></textarea>
			                    <br/>
			                    <input type="submit" name="modify" value="&nbsp; &nbsp;修 改&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
			                    <label class="am-fr">&nbsp;&nbsp;&nbsp;</label>
			                    <input type="submit" name="back" value="&nbsp; &nbsp;返 回&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr" >
			                    
			              </form>
			              </div>
			            
			 </div>

          

        </div>     

         
       
      </div>

    </div>
  </div>

</div>
<!-- content end -->


<%@ include file="footer.jsp" %>






</body>
</html>