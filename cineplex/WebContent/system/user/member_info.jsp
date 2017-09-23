<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="r_feedback" uri="/WEB-INF/tlds/rechargeFeedback.tld" %>
<%@ taglib prefix="c_feedback" uri="/WEB-INF/tlds/cancelFeedback.tld" %>
<%@ taglib prefix="t_feedback" uri="/WEB-INF/tlds/transferFeedback.tld" %>
<jsp:useBean id="anchor" 
    type="net.cineplex.webmodel.Anchor"
    scope="session">
</jsp:useBean>
<jsp:useBean id="memberInfoVO" 
    type="net.cineplex.webmodel.MemberInfoVO"
    scope="session">
</jsp:useBean>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head >
  <meta http-equiv="Content-Type" content="text/html;  charset="UTF-8">
  <title>影院在线-会员</title>

  <%@ include file="import.jsp" %>
<script language="javascript">  
             
           function jump(panel){
            	 document.getElementById(panel).scrollIntoView();
             }
             //location.hash="#<jsp:getProperty name="anchor" property="panel" />";  
</script>
</head>

<body onload="jump('<jsp:getProperty name="anchor" property="panel" />');">
<%@ include file="../header.jsp" %>
<br/>
<div class="am-g">
  
  <div class="am-u-lg-10 am-u-md-10 am-u-sm-centered">
        <%@ include file="member_info_navi.jsp" %>
        <br/>
		<br/>
     <a name="info_panel" id="info_panel"></a>
     <div>
      <label class="am-text-xl">
        	会员信息
      </lable>
     </div>
 
      <div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
      
         <div>
             <div class="am-u-lg-3 am-u-md-3 am-u-sm-3">
              <label>注册时间: </label>
             </div>
             <div class="am-u-lg-9 am-u-md-9 am-u-sm-9">
              <label  style="font-size:100%"><jsp:getProperty name="memberInfoVO" property="registerTime" /></label>
             </div >
         </div>
         
         <div>
         <br/>

               <div class="am-u-lg-3 am-u-md-3 am-u-sm-3">
               <label>会员到期时间: </label>
               </div>
               <div class="am-u-lg-9 am-u-md-9 am-u-sm-9">
                <label  ><jsp:getProperty name="memberInfoVO" property="dueTime" /></label>
              </div >
          </div>
        
          <div>
          <br/>
               <div class="am-u-lg-3 am-u-md-3 am-u-sm-3">
                <label>会员等级: </label>
               </div>
               <div class="am-u-lg-9 am-u-md-9 am-u-sm-9">
                <label  ><jsp:getProperty name="memberInfoVO" property="level" /></label>
               </div >
          </div>
         
          <div>
          <br/>
              <div class="am-u-lg-3 am-u-md-3 am-u-sm-3">
              <label>余额: </label>
             </div>
              <div class="am-u-lg-9 am-u-md-9 am-u-sm-9">
              <label ><jsp:getProperty name="memberInfoVO" property="deposit" /> 元</label>
               </div >

          </div>
         
        
         <br/>

    </div>
   
    <br/>
    <hr/>

	<a name="recharge_panel" id="recharge_panel"></a>
    <div>
      <label class="am-text-xl">
        在线充值
      </lable>
     </div>

     <div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
        <r_feedback:show/>
        <form method="post" class="am-form" action="recharge">

          <label for="recharge_amount">充值金额:</label>
          <input class="modify_input" type="text" name="recharge_amount" id="recharge_amount" value="">
          

          <label  for="bank_password" >银行卡密码:</label>
          <input class="modify_input" type="password" name="bank_password" id="bank_password" value="">

          
          <br/>
          <div>
          <input type="submit" name="recharge" value="充 值" class="am-btn am-btn-primary am-btn-sm modify_button am-fr">
          </div>
        <br/>
        </form>
    </div>
    <br/>
    <hr/>



	  <a name="cancel_panel" id="cancel_panel"></a>
      <div>
      <label class="am-text-xl">
        注销会员
      </lable>
     </div>

     <div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
        <c_feedback:show/>
        <form method="post" class="am-form" action="cancelMemberShip">
		  
          <label  for="password" >密码: 【提示： 余额将退回所绑定银行账户。】</label>
          <input class="modify_input" type="password" name="password" id="password" value="">

          
          <br/>
          <div>
          <input type="submit" name="cancel" value="注 销" class="am-btn am-btn-primary am-btn-sm modify_button am-fr">
          </div>
        <br/>
        </form>
    </div>
    <br/>
    <hr/>

	<a name="transfer_panel" id="transfer_panel"></a>
     <div>
      <label class="am-text-xl">
        积分兑换
      </lable>
     </div>

     <div class="modify_panel am-u-lg-6 am-u-md-7 am-u-sm-centered am-g-collapse">
       <t_feedback:show/>
        <form method="post" class="am-form" action="transferIntegral">
          <div>
             <div class="am-u-lg-3 am-u-md-3 am-u-sm-3">
               <br/>
               <label>您当前积分: </label>
             </div>

             <div class="am-u-lg-2 am-u-md-2 am-u-sm-2">
               <label  style="font-size:300%"><jsp:getProperty name="memberInfoVO" property="score" /></label>
             </div >
             
             <div class="am-u-lg-7 am-u-md-7 am-u-sm-7">
               <br/>
               <label class="am-form-inline">分&nbsp;&nbsp;&nbsp;&nbsp;【积分兑换规则：10积分=1元 余额】</label>
             </div>
          </div>
          
          <div>
            &nbsp;
            <br/>
            
            
            <input type="submit" name="transfer" value="兑 换" class="am-btn am-btn-primary am-btn-sm modify_button am-fr">
          </div>
          <br/>
        </form>
    </div>
    <br/>
   


  </div>
  
  
  
   <br/>
   <br/>

  
<div class="footer">
    <p> 2014&nbsp;&nbsp;&nbsp;J2EE-Project&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cineplex System&nbsp;&nbsp;&nbsp;by&nbsp;&nbsp;&nbsp;121250084</p>
    <br/>
    </div>
</div>

</body>
</html>