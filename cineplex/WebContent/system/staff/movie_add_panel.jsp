<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="a_feedback" uri="/WEB-INF/tlds/movieAddFeedback.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
				<a_feedback:show/>
              <form  class="am-form" method="post" action="/cineplex/addMovie">
                  
                    <label for="mname">电影名 :</label>
                    <input  type="text" id="mname" name="mname" required></input> 
                    <label for="duration">时长（分钟）:</label>
                    <input  type="text" id="duration" name="duration" required></input> 
                    <label for="online">上线日期:</label>
                    <input type="text" class="am-form-field" placeholder="" id="online" name="online" data-am-datepicker readonly required/>
                    <label for="downline">下线日期:</label>
                    <input type="text" class="am-form-field" placeholder="" id="downline" name="downline" data-am-datepicker readonly required/>
                    
                    <label for="movietype">类型：</label>
                    <div>
                      <select id="movietype" name="movietype"  multiple data-am-selected>
                   
                        <option value="0" >爱情片</option>
                      
                        <option value="2">喜剧片</option>
                        <option value="5">文艺片</option>
                        <option value="6">音乐片</option>
                        <option value="7">歌舞片</option>
                        <option value="8">动漫片</option> 
                        <option value="10">武侠片</option>
                        <option value="12">动作片</option>
                        <option value="13">恐怖片</option>
                        <option value="18">记录片</option>
                        <option value="19">战争片</option>
                        <option value="20">历史片</option>
                        <option value="21">传记片</option>
                        <option value="24">魔幻片</option>
                       
                        
                      </select>
                    </div>
                    
                    
                    <label for="post">海报：</label>
                    <input type="file" id="post">
                    <hr/>
                    <label> 介绍:</label>
                    <textarea rows="20" id="introduction" name="introduction" required></textarea>

                    <br/>
                    <input type="submit" name="add" value="&nbsp; &nbsp;添 加&nbsp; &nbsp;" class="am-btn am-btn-primary am-btn-sm am-fr">
              </form>