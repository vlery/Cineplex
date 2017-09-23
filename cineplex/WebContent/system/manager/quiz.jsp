<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="quizVO" 
    type="net.cineplex.webmodel.stat.QuizVO"
    scope="session">
</jsp:useBean>
<html>
<head>
	  <meta charset="utf-8">
	 
	  <title>影院在线——经理</title>
	
	  <%@ include file="import.jsp" %>

	  <script type="text/javascript">
       
       $(function () {
		    $('#quiz_line').highcharts({
		        title: {
		            text: '<b>参与活动的情况统计</b>',
		            x: -20 //center
		        },
		        
		        xAxis: {
		            categories: [<% for(int i=0;i<quizVO.getSize()-1;i++){
		                         
		            					out.print("'"+quizVO.getMovieName(i) +"',");             
		            				}
		            				out.print("'"+quizVO.getMovieName(quizVO.getSize()-1) +"'");
		            			 %>
								]
		        				
		            },
		        yAxis: {
		            title: {
		                text: ' '
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            valueSuffix: '人'
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [{
		            name: '参与人数',
		            data: [<% for(int i=0;i<quizVO.getSize()-1;i++){
                        
    					out.print(quizVO.getChocieNum(i) +",");             
    				}
    				out.print(quizVO.getChocieNum(quizVO.getSize()-1) );
    			 %>]
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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">活动参与</strong> / <small>customer</small></div>
      <br/>
      <div class="am-tabs am-margin" data-am-tabs>
	        <ul class="am-tabs-nav am-nav am-nav-tabs">
	          <li class="am-active"><a href="#quiz">活动</a></li>
	        
	        </ul>

	        <div class="am-tabs-bd">
	           <div class="am-tab-panel am-fade am-in am-active am-g" id="quiz">
	              <br/>

	              <div id="quiz_line" style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>
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