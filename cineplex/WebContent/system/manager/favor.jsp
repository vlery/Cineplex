<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="favorVO" 
    type="net.cineplex.webmodel.stat.FavorVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="favorTypeVO" 
    type="net.cineplex.webmodel.stat.FavorTypeVO"
    scope="session">
</jsp:useBean>
<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>


		<script type="text/javascript">
		       
		     
		   $(function () {
				    $('#favor_line').highcharts({
				        chart: {
				            zoomType: 'xy'
				        },
				        title: {
				            text: '<b>影片观看人数与评分统计图</b>'
				        },
				        xAxis: [{
				            categories: [
									<jsp:getProperty name="favorVO" property="movieList" />
				                ]
				        
				        }],
				        yAxis: [{ // Primary yAxis
				            labels: {
				                format: '{value}人',
				                style: {
				                    color: '#89A54E'
				                }
				            },
				            title: {
				                text: '观看人数',
				                style: {
				                    color: '#89A54E'
				                }
				            }
				        }, { // Secondary yAxis
				            title: {
				                text: '评分',
				                style: {
				                    color: '#4572A7'
				                }
				            },
				            labels: {
				                format: '{value} 分',
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
				            y: 100,
				            floating: true,
				            backgroundColor: '#FFFFFF'
				        },
				        series: [{
				            name: '评分',
				            color: '#4572A7',
				            type: 'column',
				            yAxis: 1,
				            data: [<jsp:getProperty name="favorVO" property="scoreList" />],
				            tooltip: {
				                valueSuffix: ' 分'
				            }
				
				        }, {
				            name: '观看人数',
				            color: '#89A54E',
				            type: 'spline',
				            data: [<jsp:getProperty name="favorVO" property="peopleList" />],
				            tooltip: {
				                valueSuffix: '人'
				            }
				        }]
				    });
		});
		        
		   $(function () {
					    $('#type_pie').highcharts({
					        chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: null,
					            plotShadow: false
					        },
					        title: {
					            text: '<b>电影类型受欢迎程度统计图</b>'
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
					            name: '市场比',
					            data: [
					                   
					                   <% for(int i=0;i<favorTypeVO.getSize()-1;i++){
					                   	out.print("["+favorTypeVO.getTypeItem(i)+","+favorTypeVO.getCountItem(i)+"],");
					                   
					                   }
					                   %>
					               
					                
					                
					                
					                {
					                    name: '其他',
					                    y: <% out.print(favorTypeVO.getCountItem(favorTypeVO.getSize()-1));  %>,
					                    sliced: true,
					                    selected: true
					                },
					               
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">喜好分析</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#movie_stat">电影</a></li>
	          <li class="am-active"><a href="#type_stat">类型</a></li>

	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="movie_stat">
	               <br/>

	               <div id="favor_line" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
	               <br/>
	               <br/>
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="type_stat">
	              <br/>

	              <div id="type_pie" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
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