<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="seat" uri="/WEB-INF/tlds/seatSelect.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影院在线-座位</title>
	<%@ include file="import.jsp" %>
  
     <script type="text/javascript">
 
      var seats = new Array();
      var seatName=new Array();
      Array.prototype.indexOf = function(val) {
           for (var i = 0; i < this.length; i++) {
               if (this[i] == val) return i;
            }
        	return -1;
      };
      Array.prototype.remove = function(val) {
            var index = this.indexOf(val);
            if (index > -1) {
                this.splice(index, 1);
            }
      };      
      function chooseSeats(seat){
            var s=new String( document.getElementById(seat).alt);
            
            if( s=="avail"){
                document.getElementById(seat).src="/cineplex/system/assets/i/seat_select.png";
				document.getElementById(seat).alt="select";
               	seats.push(seat);
                seatName.push(document.getElementById(seat).title);
             }
             if(s=="select"){
               	document.getElementById(seat).src="/cineplex/system/assets/i/seat_avail.png";
                document.getElementById(seat).alt="avail";
                seats.remove(seat);
                seatName.remove(document.getElementById(seat).title);
              }
        }
        function submit(){
            if(seats.length==0){
                alert("请选择座位！");
                return;
            }
            if(confirm("确定选择以下座位：\r"+seatName.join("\r"))){  
            	var url="/cineplex/seatSelect?seat="+seats.join("-");
            	window.location.href = url;
            }
        }
    </script>



</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<br/>
	<div class="am-g">
    <div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">

			  <div class="am-u-lg-5 am-u-md-6 am-u-sm-centered">
          			<label>已选&nbsp;&nbsp;</label> <img src="/cineplex/system/assets/i/seat_unavail_sm.png" alt="post" /><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
          			<label>未选&nbsp;&nbsp; </label><img src="/cineplex/system/assets/i/seat_avail_sm.png" alt="post" /><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
          			<label>当前选择&nbsp;&nbsp; </label><img src="/cineplex/system/assets/i/seat_select_sm.png" alt="post" />
      		  </div>
      		  <br/>
			  <div>
					<button class="am-btn am-btn-primary am-btn-sm am-fr"  name="select" id="select" onclick="submit();">&nbsp; &nbsp;确 定&nbsp; &nbsp;</button>
     		 </div>
     		 <br/>
     		 <div class="am-u-lg-4 am-u-md-5 am-u-sm-centered">
        			<img src="/cineplex/system/assets/i/screen.png" alt="screen" />
      		</div>
      		 <br/>
     		 <br/>
     		 <div class="am-u-lg-11 am-u-md-11 am-u-sm-centered">
      		 		<seat:select/>
			</div>
			
		<br/>
		<br/>
		</div>
		<%@ include file="../footer.jsp" %>
	
	</div>





</body>
</html>