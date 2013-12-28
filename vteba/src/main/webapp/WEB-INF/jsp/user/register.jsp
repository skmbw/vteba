<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>注册页</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<meta name="copyright" content="vteba.com">
<link rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/globe-v5-combo.css" media="all">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/module-captcha.css" media="all">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/page-loginreg.css" media="all">
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.cookie.js"></script>
<script type="text/javascript">
	function changeValidateCode(obj) {
		obj.src="/authCode?d=" + new Date().getTime();
	}
	
	var ok = '<img src="/img/ok_01.png" style="margin-top:2px;">';
	var errs = '<img src="/img/error1.png"><span style="color:#ff89a7; margin-left:8px; margin-top:0;">';
	var au = '<span style="padding-left: 21px;color:#ff89a7;background: url(/images/error1.png) no-repeat left center;">验证码错误</span>';
	
	$(document).ready(function(){
		$('#register_mail').focus(function(){
    		var email = $('#register_mail').val();
    		if ($.trim(email) == '') {
    			$('.err_email').css('visibility','visible');
    		}
    	});
    	$('#register_mail').blur(function(){
    		var email = $('#register_mail').val();
    		var b=/^([A-Za-z0-9])([\w\-\.])*@(vip\.)?([\w\-])+(\.)(com|com\.cn|net|cn|net\.cn|org|biz|info|gov|gov\.cn|edu|edu\.cn)$/;
    		if (email.length > 0 && b.test(email)) {
    			$('.err_email').html(ok);
    			$('#authResult').val('0');
    		} else if (email.length > 0 && !b.test(email)) {
    			$('.err_email').html(errs + '邮件地址格式错误</span>');
    			$('#authResult').val('1');
    		} else {
    			$('.err_email').html(errs + '请填写邮件地址</span>');
    			$('#authResult').val('1');
    		}
    		
    	});
    	
    	$('#register_ulike').focus(function(){
    		var nick = $('#register_ulike').val();
    		if ($.trim(nick) == '') {
    			$('.err_ulike').css('visibility','visible');
    		}
    	});
    	$('#register_ulike').blur(function(){
    		var nick = $('#register_ulike').val();
    		if ($.trim(nick) == '') {
    			$('.err_ulike').html(errs + '请填写昵称</span>');
    			$('#authResult').val('1');
    		} else if (nick.length > 0 && nick.length < 21) {
    			$('.err_ulike').html(ok);
    			$('#authResult').val('0');
    		} else if (nick.length >= 21) {
    			$('.err_ulike').html(errs + '昵称长度不能大于20个字符</span>');
    			$('#authResult').val('1');
    		}
    		
    	});
    	
    	$('#register_password').focus(function(){
    		var pass = $('#register_password').val();
    		if ($.trim(pass) == '') {
    			$('.err_password').css('visibility','visible');
    		}
    	});
    	$('#register_password').blur(function(){
    		var pass = $('#register_password').val();
    		if ($.trim(pass) == '' || pass.length < 6) {
    			$('.err_password').html(errs + '请填写密码，且长度不能小于6位</span>');
    			$('#authResult').val('1');
    		} else if (pass.length > 5 && pass.length < 21) {
    			$('.err_password').html(ok);
    			$('#authResult').val('0');
    		} else if (pass.length >= 21) {
    			$('.err_password').html(errs + '密码长度不能大于20个字符</span>');
    			$('#authResult').val('1');
    		}
    		
    	});
    	
    	$('#register_respassword').focus(function(){
    		var pass = $('#register_respassword').val();
    		if ($.trim(pass) == '') {
    			$('.err_rstpassword').css('visibility','visible');
    		}
    	});
    	$('#register_respassword').blur(function(){
    		var repass = $('#register_respassword').val();
    		if ($.trim(repass) == '' || repass.length < 6) {
    			$('.err_rstpassword').html(errs + '请填写密码，且长度不能小于6位</span>');
    			$('#authResult').val('1');
    		} else if (repass.length > 5 && repass.length < 21) {
    			var pass = $('#register_password').val();
    			if (pass == repass) {
    				$('.err_rstpassword').html(ok);
    				$('#authResult').val('0');
    			}
    		} else if (repass.length >= 21) {
    			$('.err_rstpassword').html(errs + '密码长度不能大于20个字符</span>');
    			$('#authResult').val('1');
    		}
    		
    	});
    	
    	$('#authCode').blur(function(){
    		var authCode = $('#authCode').val();
    		if ($.trim(authCode) == '') {
    			$('#authcode_error').css('visibility','visible');
    			$('#authResult').val('1');
    		} else {
    			var auth = $.cookie('skmbw_vteba_auth_code_mn');
    			if (auth != undefined && auth.toLowerCase() != authCode) {
    				$('#authcode_error').html(au);
    				$('#authcode_error').css('visibility','visible');
    				$('#authResult').val('1');
    			} else {
    				$('#authcode_error').html(ok);
    				$('#authResult').val('0');
    			}
    		}
    	});
    	
    	$('#registerBtn').click(function(){
    		var auth = $('#authResult').val();
    		if ($.trim(auth) == '1') {
    			return;
    		} else if ($.trim(auth) == '0'){
    			var regForm = $('#regForm');
    			regForm.submit();
    		}
    	});
	});

</script>

</head>
	<body>
	<div id="content_body">
		<div class="reg_wrap">
<div class="fm960">
        <div class="logo">
           <a href="/" class="mogujie fl" title="微特吧">微特吧</a>
        </div>
    <div class="content">

<div id="register_box">
    <div id="register_left">
         <h1>新用户注册</h1>

        <div id="register_center">
            <div id="register_form">
                <form action="/user/doRegister" id="regForm" method="post">
                <input id="authResult" value="0" type="hidden">
                    <div class="ipt_mail">
                        <span>电子邮箱：</span><input id="register_mail" maxlength="36" name="email" class="text r3" type="text">
                    </div>
                    <div class="ipt_ulike">
                        <span>昵称：</span><input id="register_ulike" style="*margin-left:-1px;" maxlength="36" name="nickName" class="text r3" type="text">
                                            </div>
                    <div class="ipt_sex">
                        <span>性别：</span>
                        <div class="rdo">
                            <input name="gender" value="2" checked="checked" class="ck" type="radio">女<input style="margin-left:10px" name="gender" value="1" class="ck" type="radio">男
                        </div>
                                            </div>
                    <div class="ipt_password">
                        <span>密码：</span><input id="register_password" style="*margin-left:-1px;" maxlength="36" name="password" class="text r3" type="password">
                                            </div>
                    <div class="ipt_respassword">
                        <span>确认密码：</span><input id="register_respassword" maxlength="36" name="respassword" class="text r3" type="password">
                                            </div>
                                        <div style="overflow: hidden;margin-left: 34px;margin-top: 18px;line-height: 30px;">
                        <span>验证码：</span>
                        <div class="imgcheck_code_main clearfix">
    
    <input name="authCode" id="authCode" style="width:80px;" class="text r3" maxlength="4" type="text">
	    <div id="imgcheck_code_change" onclick="changeValidateCode($('#authImage')[0]);" style="float:none;vertical-align:middle;text-align:center;left:160px;cursor:pointer;"><span style="vertical-align:middle;text-align:center;color:#666;font-size:11px;margin-left:14px;margin-top:7px;">点击刷新</span></div> 
	    <img src="/authCode" style="vertical-align:middle;cursor:pointer;margin:5px;margin-left:9px;" onclick="changeValidateCode(this);" id="authImage" title="看不清？点击刷新" alt="微特吧"/>
</div>

                    </div>
                                        <div class="ipt_box">
                        <input class="box fl" name="register_agreement" checked="checked" type="checkbox"><span class="fl">我已看过并同意《<a href="https://www.vteba.com/user/agreement" target="_blank">微特吧网络服务使用协议</a>》</span>
                                            </div>
                    <div class="ipt_sub">
                        <input class="sub" id="registerBtn" value="" type="button">
                    </div>
             
                </form>
            </div>
            <div id="register_error">
                <div class="err_email">
                    请填写正确的常用邮箱，以便找回密码。比如：abc@vteba.com
                </div>
                <div class="err_ulike">
                    支持中文，不能以数字开头，最多20个字符，中文算两个字符。
                </div>
                <div class="err_password">
                    6-20个字母、数字或者符号
                </div>
                <div class="err_rstpassword">
                    这里要重复输入一下你的密码
                </div>
									<div id="authcode_error" class="err_check ipt_check"
										style="visibility:hidden; height: 30px;float:left;">
                <span style="padding-left: 21px;color:#ff89a7;background: url(/images/error1.png) no-repeat left center;">验证码错误</span>
            </div>
								</div>
        </div>
    </div>
    <div id="register_right">
        <div class="rst_login">
            <span>已经有帐号？请直接登录</span>
            <a href="/user/login"></a>
        </div>
        
    </div>
</div>
<div class="clear"></div>

</div>
<p class="copyright">©Copyright 2013-2013 微特吧 vteba.com (增值电信业务经营许可证：浙B2-20110349)</p>
</div>
</div>
	</div>
</body></html>