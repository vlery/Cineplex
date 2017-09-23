<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/amazeui.min.js"></script>
  
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
                document.getElementById(seat).src="assets/i/seat_select.png";
				document.getElementById(seat).alt="select";
               	seats.push(seat);
                seatName.push(document.getElementById(seat).title);
             }
             if(s=="select"){
               	document.getElementById(seat).src="assets/i/seat_avail.png";
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
            	var url="../seatSelect?seat="+seats.join("-");
            	window.location.href = url;
            }
        }
    </script>



</head>
<body>

<div>

        <button class="am-btn am-btn-primary am-btn-sm am-fr"  name="select" id="select" onclick="submit();">&nbsp; &nbsp;确 定&nbsp; &nbsp;</button>
      </div>
 <form  id="seat_form" name="seat_form" method="post">
	 <div>
          <label>第一排&nbsp;&nbsp; &nbsp;&nbsp; </label>  
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排1座"  id="1" style="cursor:pointer"  onclick="chooseSeats('1');"/>
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排2座" id="2" style="cursor:pointer" onclick="chooseSeats('2');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排3座" id="3" style="cursor:pointer" onclick="chooseSeats('3');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排4座" id="4" style="cursor:pointer" onclick="chooseSeats('4');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排5座" id="5" style="cursor:pointer" onclick="chooseSeats('5');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排6座" id="6" style="cursor:pointer" onclick="chooseSeats('6');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排7座" id="7" style="cursor:pointer" onclick="chooseSeats('7');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排8座" id="8" style="cursor:pointer" onclick="chooseSeats('8');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排9座" id="9" style="cursor:pointer" onclick="chooseSeats('9');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排10座" id="10" style="cursor:pointer" onclick="chooseSeats('10');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排11座" id="11" style="cursor:pointer" onclick="chooseSeats('11');"/> 
              <img src="assets/i/seat_avail.png" alt="avail"  title="1排12座" id="12" style="cursor:pointer" onclick="chooseSeats('12');"/>
        </div>


</form>


<form   method="post" action="../Test">


	<label for="movietype">类型：</label>
                    <div>
                      <select id="movietype" name="movietype" multiple data-am-selected>
                   
                        <option value="0" selected>爱情片</option>
                        <option value="1" selected>剧情片</option>
                        <option value="2">喜剧片</option>
                        <option value="3">家庭片</option>
                        <option value="4">伦理片</option>
                        <option value="5">文艺片</option>
                        <option value="6">音乐片</option>
                        <option value="7">歌舞片</option>
                        <option value="8">动漫片</option>
                        <option value="9">西部片</option>
                        
                        <option value="10">武侠片</option>
                        <option value="11">古装片</option>
                        <option value="12">动作片</option>
                        <option value="13">恐怖片</option>
                  
                        <option value="14">惊悚片</option>
                        <option value="15">冒险片</option>
                        <option value="16">犯罪片</option>
                        <option value="17">悬疑片</option>
                        <option value="18">记录片</option>
                        <option value="19">战争片</option>
                        <option value="20">历史片</option>
                        
                        <option value="21">传记片</option>
                        <option value="22">体育片</option>
                        <option value="23">科幻片</option>
                        <option value="24">魔幻片</option>
                        <option value="25">奇幻片</option>
                        
                      </select>
                    </div>
                    <input type="submit" name="提交">

</form>


</body>
</html>