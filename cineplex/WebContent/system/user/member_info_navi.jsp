<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
   	<div class="am-u-lg-11 am-u-md-11 am-u-sm-11">
           <ul class="am-nav am-nav-tabs">
                <li ><a href="/cineplex/main">首页</a></li>
                <li class="am-active" >
                      <a  href="#">
                                                    会员
                      </a>
                </li>

                <li class="am-dropdown" data-am-dropdown>
                      <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                            	 个人资料<span class="am-icon-caret-down"></span>
                      </a>
                      <ul class="am-dropdown-content">
                               <li><a href="/cineplex/info?panel=password_panel">修改资料</a></li>
                                <li><a href="/cineplex/info?panel=mhistory_panel">观影历史</a></li>
                                <li><a href="/cineplex/info?panel=qhistory_panel">参与活动</a><li>
                      </ul>
                </li>
                <li ><a href="#">帮助</a></li>
           </ul>
                  
     </div>
     <div class="am-u-lg-1 am-u-md-1 am-u-sm-1">
           <button class="am-btn am-btn-default am-btn-xs"  name="exit" id="exit" onclick="window.location.href='/cineplex/exit'">&nbsp; &nbsp;退 出&nbsp; &nbsp;</button>
     </div>
     <br/>
     
</div>