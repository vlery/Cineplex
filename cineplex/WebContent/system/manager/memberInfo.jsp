<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="memberInfoVO" 
    type="net.cineplex.webmodel.stat.MemberInfoVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="ageVO" 
    type="net.cineplex.webmodel.stat.AgeVO"
    scope="session">
</jsp:useBean>

<jsp:useBean id="genderVO" 
    type="net.cineplex.webmodel.stat.GenderVO"
    scope="session">
</jsp:useBean>

<jsp:useBean id="addressVO" 
    type="net.cineplex.webmodel.stat.AddressVO"
    scope="session">
</jsp:useBean>
<jsp:useBean id="cityVO" 
    class="net.cineplex.webmodel.stat.CityVO"
    scope="page">
</jsp:useBean>
<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>


	  <script type="text/javascript">
        $(function () {
        			
		            $('#age_pie').highcharts({
		                chart: {
		                    plotBackgroundColor: null,
		                    plotBorderWidth: null,
		                    plotShadow: false
		                },
		                title: {
		                    text: '<b>会员年龄分布图</b>'
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
		                    name: '占总人数比',
		                    data: [
		                        ['11~20岁', <jsp:getProperty name="ageVO" property="tenToTwenty" />],
		                        ['21~30岁',      <jsp:getProperty name="ageVO" property="twentyToThirty" />],
		                        {
		                            name: '31~40岁',
		                            y: <jsp:getProperty name="ageVO" property="thirtyToForty" />,
		                            sliced: true,
		                            selected: true
		                        },
		                        ['41~50岁',    <jsp:getProperty name="ageVO" property="fortyToFifty" />],
		                        ['51~60岁',     <jsp:getProperty name="ageVO" property="fiftyToSixty" />],
		                        ['61~70岁',   <jsp:getProperty name="ageVO" property="sixtyToSeventy" />],
		                        ['其他',  <jsp:getProperty name="ageVO" property="other" />]
		                    ]
		                }]
		            });
        });
        
        
        $(function () {
		            
		            var colors = Highcharts.getOptions().colors,
		                categories = ['男', '女'],
		                name=" ",
		                data = [{
		                        y: <jsp:getProperty name="genderVO" property="male" />,
		                        color: colors[0],
		                    }, {
		                        y: <jsp:getProperty name="genderVO" property="female" />,
		                        color: colors[3],
		                        
		                    }];
		
		            function setChart(name, categories, data, color) {
		          chart.xAxis[0].setCategories(categories, false);
		          chart.series[0].remove(false);
		          chart.addSeries({
		            name: name,
		            data: data,
		            color: color || 'white'
		          }, false);
		          chart.redraw();
		            }
		
		            var chart = $('#gender_bar').highcharts({
		                chart: {
		                    type: 'column'
		                },
		                title: {
		                    text: '<b>会员性别分布<b/>'
		                },
		                
		                xAxis: {
		                    categories: categories
		                },
		                yAxis: {
		                    title: {
		                        text: '人数'
		                    }
		                },
		                plotOptions: {
		                    column: {
		                        cursor: 'pointer',
		                       
		                        dataLabels: {
		                            enabled: true,
		                            color: colors[0],
		                            style: {
		                                fontWeight: 'bold'
		                            },
		                            formatter: function() {
		                                return this.y+'人';
		                            }
		                        }
		                    }
		                },
		                tooltip: {
		                    formatter: function() {
		                        var point = this.point,
		                           
		                        s = this.x +':占总人数的<b>'+ this.y*100/<jsp:getProperty name="genderVO" property="total" />+'%</b><br/>';
		                       
		                        return s;
		                    }
		                },
		                series: [{
		                    name: name,
		                    data: data,
		                    color: 'white'
		                }],
		                exporting: {
		                    enabled: false
		                }
		            })
		            .highcharts(); // return chart
         });    
        
        $(function () {
		            var chart;
		            
		            $(document).ready(function () {
		              
		              // Build the chart
		                $('#address_pie').highcharts({
		                    chart: {
		                        plotBackgroundColor: null,
		                        plotBorderWidth: null,
		                        plotShadow: true
		                    },
		                    title: {
		                        text: '<b>会员地区分布</b>'
		                    },
		                    tooltip: {
		                      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		                    },
		                    plotOptions: {
		                        pie: {
		                            allowPointSelect: true,
		                            cursor: 'pointer',
		                            dataLabels: {
		                                enabled: false
		                            },
		                            showInLegend: true
		                        }
		                    },
		                    series: [{
		                        type: 'pie',
		                        name: '分布比',
		                        data: [
		                               <%
											for(int i=0;i<addressVO.getSize();i++){
												pageContext.setAttribute("cityVO",addressVO.getItem(i));
											
		                               %>
		                            ['<jsp:getProperty name="cityVO" property="city" />',  <jsp:getProperty name="cityVO" property="percent" /> ],
		                          <% }%>
		                            {
		                                name: '其他',
		                                y: <jsp:getProperty name="addressVO" property="otherPercent" />,
		                                sliced: true,
		                                selected: true
		                            },
		                        ]
		                    }]
		                });
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人信息</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#age">年龄</a></li>
	          <li class="am-active"><a href="#gender">性别</a></li>
	          <li class="am-active"><a href="#address">居住地</a></li>
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="age">
	                <div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
		              <ul class="am-avg-sm-1 am-avg-md-2 am-margin am-padding am-text-center admin-content-list " style="border:0px;">
		                  <li><label  class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>注册用户<br/><jsp:getProperty name="memberInfoVO" property="registor" /></a></li>
		                  <li><label  class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>会员<br/><jsp:getProperty name="memberInfoVO" property="member" /></a></li>
		              </ul>
		            </div>
		              
		            <hr/>
		
		            <div id="age_pie" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto">
		            </div>
		            
		            <br/>
		            <br/>
	              
	              
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="gender">
	              <br/>

	              <div id="gender_bar" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
	              <br/>
	              <br/>
	              
	           </div>
			   <div class="am-tab-panel am-fade am-in am-active am-g" id="address">
	              <br/>
				  <div id="address_pie" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
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