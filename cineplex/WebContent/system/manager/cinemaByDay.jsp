<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dayVO" 
    type="net.cineplex.webmodel.stat.DayVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="movie" 
    class="net.cineplex.webmodel.stat.MovieUpperByDayVO"
    scope="page">
</jsp:useBean>

<jsp:useBean id="hall" 
    class="net.cineplex.webmodel.stat.HallUpperByDayVO"
    scope="page">
</jsp:useBean>

<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>

	  <script type="text/javascript">
		   $(function () {
				    $('#day_line').highcharts({
				        chart: {
				            zoomType: 'xy'
				        },
				        title: {
				            text: '<b>每日观影人数及上座率统计</b>'
				        },
				       
				        xAxis: [{
				            categories: [<jsp:getProperty name="dayVO" property="day" />]
				        }],
				        yAxis: [{ // Primary yAxis
				            labels: {
				                format: '{value}人',
				                style: {
				                    color: '#89A54E'
				                }
				            },
				            title: {
				                text: '观影人数',
				                style: {
				                    color: '#89A54E'
				                }
				            }
				        }, { // Secondary yAxis
				            title: {
				                text: '上座率',
				                style: {
				                    color: '#4572A7'
				                }
				            },
				            labels: {
				                format: '{value} %',
				                style: {
				                    color: '#4572A7'
				                }
				            },
				            opposite: true
				        }],
				        tooltip: {
				            shared: true
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'left',
				            x: 120,
				            verticalAlign: 'top',
				            y: 30,
				            floating: true,
				            backgroundColor: '#FFFFFF'
				        },
				        
				        
				        
				        series: [
				                 
			
				                 {
				            name: '上座率',
				            color: '#4572A7',
				            type: 'column',
				            yAxis: 1,
				            data: [<jsp:getProperty name="dayVO" property="totalUpper" />],
				            tooltip: {
				                valueSuffix: ' %'
				            }
				
				        }, {
				            name: '观影人数',
				            color: '#89A54E',
				            type: 'spline',
				            data: [<jsp:getProperty name="dayVO" property="people" />],
				            tooltip: {
				                valueSuffix: '人'
				            }
				        }]
				    });
		});
		
		   $(function () {
				    $('#movie_line').highcharts({
				        title: {
				            text: '<b>在线影片每日上座率统计</b>',
				            x: -20 //center
				        },
				        
				        xAxis: {
				            categories: [<jsp:getProperty name="dayVO" property="day" />]
				        },
				        yAxis: {
				            title: {
				                text: '上座率 (%)'
				            },
				            plotLines: [{
				                value: 0,
				                width: 1,
				                color: '#808080'
				            }]
				        },
				        tooltip: {
				            valueSuffix: '%'
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'right',
				            verticalAlign: 'middle',
				            borderWidth: 0
				        },
				        series: [
				                 
				                 <% for(int i=0;i<dayVO.getMovieSize()-1;i++ ){
				                	 pageContext.setAttribute("movie", dayVO.getMovieItem(i) );
				                	 
				                	 %>
				                 
				                 
				                 {
				            name: <jsp:getProperty name="movie" property="movieName" />,
				            data: [<jsp:getProperty name="movie" property="movieUpper" />]
				        },
				        
				        
				        <% }
				        	
				                 pageContext.setAttribute("movie", dayVO.getMovieItem(dayVO.getMovieSize()-1));
				        %>
				        
				         {
				        	 name: <jsp:getProperty name="movie" property="movieName" />,
					         data: [<jsp:getProperty name="movie" property="movieUpper" />]
				        }]
				    });
			});   
		   
		   
		   $(function () {
			    $('#hall_line').highcharts({
			        title: {
			            text: '<b>影厅上座率统计</b>',
			            x: -20 //center
			        },
			        
			        xAxis: {
			            categories: [<jsp:getProperty name="dayVO" property="day" />]
			        },
			        yAxis: {
			            title: {
			                text: '上座率 (%)'
			            },
			            plotLines: [{
			                value: 0,
			                width: 1,
			                color: '#808080'
			            }]
			        },
			        tooltip: {
			            valueSuffix: '%'
			        },
			        legend: {
			            layout: 'vertical',
			            align: 'right',
			            verticalAlign: 'middle',
			            borderWidth: 0
			        },
			        series: [
			                 
							<% for(int i=0;i<dayVO.getHallSize()-1;i++ ){
								 pageContext.setAttribute("hall", dayVO.getHallItem(i) );
								 
								 %>

			                 {
					            name: <jsp:getProperty name="hall" property="hallName" />,
					            data: [<jsp:getProperty name="hall" property="hallUpper" />]
			        	}, 
			        	<% }
							pageContext.setAttribute("hall", dayVO.getHallItem(dayVO.getHallSize()-1) );
							%>
			        
			        {
			        	name: <jsp:getProperty name="hall" property="hallName" />,
			            data: [<jsp:getProperty name="hall" property="hallUpper" />]
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">影院数据-按日统计</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#total_stat">每日观影人数</a></li>
	          <li class="am-active"><a href="#hall_stat">影厅上座率</a></li>
	          <li class="am-active"><a href="#movie_stat">影片上座率</a></li>
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="total_stat">
	              <br/>

	              <div id="day_line" style="min-width: 380px; max-width: 800px; height: 400px; margin: 0 auto"></div>
	              <br/>
	              <br/>
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="hall_stat">
	               <br/>

	              <div id="hall_line" style="min-width: 380px; max-width: 800px; height: 400px; margin: 0 auto"></div>
	              <br/>
	              <br/>
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="movie_stat">
	               <br/>

	              <div id="movie_line" style="min-width: 380px; max-width: 800px; height: 400px; margin: 0 auto"></div>
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
