<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="consumeVO" 
    type="net.cineplex.webmodel.stat.ConsumeVO"
    scope="session">
</jsp:useBean>
<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>

		<script type="text/javascript">
		        $(function () {
				          $('#consume_pie').highcharts({
				              chart: {
				                  plotBackgroundColor: null,
				                  plotBorderWidth: null,
				                  plotShadow: false
				              },
				              title: {
				                  text: ' '
				              },
				              tooltip: {
				                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
				              },
				              plotOptions: {
				                  pie: {
				                      allowPointSelect: true,
				                      cursor: 'pointer',
				                      dataLabels: {
				                          enabled: true,
				                          color: '#000000',
				                          connectorColor: '#000000',
				                          format: '<b>{point.name}</b>: {point.percentage:.1f} %'
				                      }
				                  }
				              },
				              series: [{
				                  type: 'pie',
				                  name: 'Browser share',
				                  data: [
				                      ['现金',   <jsp:getProperty name="consumeVO" property="cash" />],
				                      ['电子消费',    <jsp:getProperty name="consumeVO" property="online" />],
				                     
				                  ]
				              }]
				          });
		      });       
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">消费情况</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#consumption">消费</a></li>
	        
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="consumption">
	              	<div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
			              <ul class="am-avg-sm-1 am-avg-md-1 am-margin am-padding am-text-center admin-content-list " style="border:0px;">
			                  <li><label  class="am-text-success"><span class="am-icon-btn am-icon-rmb"></span><br/>消费总额<br/><jsp:getProperty name="consumeVO" property="total" /></a></li>
			                  
			              </ul>
		             </div>
		              
		             <hr/>
		
		             <div id="consume_pie" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto">
		             </div>
		             <br/>
		             <br/>
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
