<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="monthVO" 
    type="net.cineplex.webmodel.stat.MonthVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movie" 
    class="net.cineplex.webmodel.stat.MovieWatchVO"
    scope="page">
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>

	<script type="text/javascript">
	        $(function () {
			            $('#man_pie').highcharts({
			                chart: {
			                    plotBackgroundColor: null,
			                    plotBorderWidth: null,
			                    plotShadow: false
			                },
			                title: {
			                    text: '<b>观影分布图</b>'
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
			                    name: '占总数比',
			                    data: [
			                           <% if(monthVO.getMovieWatchSize()>0){
			                           
				                           for(int i=0;i<monthVO.getMovieWatchSize()-1;i++){
				                        	   pageContext.setAttribute("movie", monthVO.getMovieWatchItem(i));
				                           %>
			                        	[<jsp:getProperty name="movie" property="movie" />,   <jsp:getProperty name="movie" property="count" />],
			                        <%   
				                           }	
				                           pageContext.setAttribute("movie", monthVO.getMovieWatchItem(monthVO.getMovieWatchSize()-1));
			                        %>
			                        {
			                            name: <jsp:getProperty name="movie" property="movie" />,
			                            y: <jsp:getProperty name="movie" property="count" />,
			                            sliced: true,
			                            selected: true
			                        }
			                        <%}%>
			                    ]
			                }]
			            });
	        });
	        $(function () {
			            $('#ticket_pie').highcharts({
			                chart: {
			                    plotBackgroundColor: null,
			                    plotBorderWidth: null,
			                    plotShadow: false
			                },
			                title: {
			                    text: '<b>购票类型分布</b>'
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
			                    name: '占总数比',
			                    data: [
			                      
			                        ['电子',       <jsp:getProperty name="monthVO" property="onlineTicket" />],
			                        {
			                            name: '现金',
			                            y: <jsp:getProperty name="monthVO" property="cashTicket" />,
			                            sliced: true,
			                            selected: true
			                        },
			                        
			                    ]
			                }]
			            });
	        });
	        $(function () {
			            $('#hall_bar').highcharts({
			                chart: {
			                    type: 'column',
			                    margin: [ 50, 50, 100, 80]
			                },
			                title: {
			                    text: '<b>影厅上座率统计图</b>'
			                },
			                xAxis: {
			                    categories: [
									<jsp:getProperty name="monthVO" property="hallName" />
			                    
			                    ],
			                    labels: {
			                        rotation: 0,
			                        align: 'right',
			                        style: {
			                            fontSize: '13px',
			                            fontFamily: 'Verdana, sans-serif'
			                        }
			                    }
			                },
			                yAxis: {
			                    min: 0,
			                    title: {
			                        text: '上座率'
			                    }
			                },
			                legend: {
			                    enabled: false
			                },
			                tooltip: {
			                    pointFormat: '本月上座率: <b>{point.y:.1f} %</b>',
			                },
			                series: [{
			                    name: 'Population',
			                    data: [<jsp:getProperty name="monthVO" property="hallUpper" />],
			                    dataLabels: {
			                        enabled: true,
			                        rotation: -90,
			                        color: '#FFFFFF',
			                        align: 'right',
			                        x: 4,
			                        y: 10,
			                        style: {
			                            fontSize: '13px',
			                            fontFamily: 'Verdana, sans-serif',
			                            textShadow: '0 0 3px black'
			                        }
			                    }
			                }]
			            });
	        });
	        $(function () {
		            $('#movie_bar').highcharts({
		                chart: {
		                    type: 'column',
		                    margin: [ 50, 50, 100, 80]
		                },
		                title: {
		                    text: '<b>影片上座率统计图</b>'
		                },
		                xAxis: {
		                    categories: [
							<jsp:getProperty name="monthVO" property="movieName" />
	
		                    
		                    ],
		                    labels: {
		                        rotation: -45,
		                        align: 'right',
		                        style: {
		                            fontSize: '13px',
		                            fontFamily: 'Verdana, sans-serif'
		                        }
		                    }
		                },
		                yAxis: {
		                    min: 0,
		                    title: {
		                        text: '上座率'
		                    }
		                },
		                legend: {
		                    enabled: false
		                },
		                tooltip: {
		                    pointFormat: '本月上座率: <b>{point.y:.1f} %</b>',
		                },
		                series: [{
		                    name: 'Population',
		                    data: [<jsp:getProperty name="monthVO" property="movieUpper" />],
		                    dataLabels: {
		                        enabled: true,
		                        rotation: -90,
		                        color: '#FFFFFF',
		                        align: 'right',
		                        x: 4,
		                        y: 10,
		                        style: {
		                            fontSize: '13px',
		                            fontFamily: 'Verdana, sans-serif',
		                            textShadow: '0 0 3px black'
		                        }
		                    }
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">影院数据-按月统计</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#total_stat">月观影总人数</a></li>
	          <li class="am-active"><a href="#buy_stat">购票类型</a></li>
	          <li class="am-active"><a href="#hall_stat">影厅上座率</a></li>
	          <li class="am-active"><a href="#movie_stat">影片上座率</a></li>
	        	
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="total_stat">
		              		 <div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
				              <ul class="am-avg-sm-1 am-avg-md-2 am-margin am-padding am-text-center admin-content-list " style="border:0px;">
				                  <li><label  class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>观影总数<br/><jsp:getProperty name="monthVO" property="totalPeopleWatch" /></a></li>
				                  <li><label  class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>会员观影<br/><jsp:getProperty name="monthVO" property="totalMemberWatch" /></a></li>
				              </ul>
				              </div>
				              
				              <hr/>
				
				              <div id="man_pie" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
				              <br/>
				              <br/>
	           </div>
	            <div class="am-tab-panel am-fade am-in am-active am-g" id="buy_stat">
	                     <div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
			              <ul class="am-avg-sm-1 am-avg-md-1 am-margin am-padding am-text-center admin-content-list " style="border:0px;">
		                  <li><label  class="am-text-success"><span class="am-icon-btn am-icon-file"></span><br/>购票总数<br/><jsp:getProperty name="monthVO" property="totalTicket" /></a></li>
		                 
			              </ul>
			              </div>
			              
			              <hr/>
			
			              <div id="ticket_pie" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
			              <br/>
			              <br/>
		              
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="hall_stat">
			               <br/>
		
			              <div id="hall_bar" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
			              <br/>
			              <br/>
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="movie_stat">
	              		   <br/>

			              <div id="movie_bar" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
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
