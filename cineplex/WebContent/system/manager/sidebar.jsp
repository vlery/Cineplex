<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar" style="height:580px">
      <ul class="am-list admin-sidebar-list">
        
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#member_stat'}"><span class="am-icon-file"></span> 会员数据 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="member_stat">
            <li><a href="/cineplex/memberInfoStat" class="am-cf"><span class="am-icon-group"></span> 个人信息</a></li>
            <li><a href="/cineplex/consumeStat"><span class="am-icon-rmb"></span> &nbsp;消费情况</a></li>
            <li><a href="/cineplex/quizStat"><span class="am-icon-puzzle-piece"></span> 活动参与</a></li>
            <li><a href="/cineplex/memberShipStat"><span class="am-icon-credit-card"></span> 会员权限</a></li>
            <li><a href="/cineplex/favorStat"><span class="am-icon-heart"></span> 喜好分析</a></li>
          </ul>
        </li>


        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#cinema_stat'}"><span class="am-icon-file"></span> 影院数据 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="cinema_stat">
            <li><a href="/cineplex/dayStat" class="am-cf"><span class="am-icon-bar-chart"></span> 按日统计</a></li>
            <li><a href="/cineplex/monthStat"><span class="am-icon-pie-chart"></span> 按月统计</a></li>
          </ul>
        </li>
        <li><a href="/cineplex/exit"><span class="am-icon-sign-out"></span> 注销</a></li>
      </ul>
    </div>
  </div>