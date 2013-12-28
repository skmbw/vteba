<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>登录页</title>
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
   		obj.src="/authCode?d=" + new Date().getTime();;
    }
    $.ajax({
        type:"post",
        dataType:"json",
        url: '/restUser/json',
        //data: '[{"createDate":"2013-10-04 16:49:03","discount":0.8,"discountPrice":16,"itemId":1,"itemImagePath":"/images/1tfp1_kqyv64cdkfbhm6dwgfjeg5sckzsew_150x169.jpg","itemName":"早秋新款","itemPrice":20},{"createDate":"2013-10-04 16:49:07","discount":0.8,"discountPrice":16,"itemId":2,"itemImagePath":"/images/1tfp1_kqyukq2dkfbdowsugfjeg5sckzsew_150x169.jpg","itemName":"连衣裙","itemPrice":20},{"createDate":"2013-10-04 16:49:10","discount":0.8,"discountPrice":16,"itemId":3,"itemImagePath":"/images/1tfp1_kqyuusclkfbewvtwgfjeg5sckzsew_150x170.jpg","itemName":"牛仔裤","itemPrice":20},{"createDate":"2013-10-04 16:49:12","discount":0.8,"discountPrice":16,"itemId":4,"itemImagePath":"/images/1tfp1_kqyxqodekfbgos3wgfjeg5sckzsew_150x170.jpg","itemName":"衬衫","itemPrice":20},{"createDate":"2013-10-04 16:49:15","discount":0.8,"discountPrice":16,"itemId":5,"itemImagePath":"/images/1tfp1_kqyxsq2wkfbfqvsugfjeg5sckzsew_150x169.jpg","itemName":"红人款","itemPrice":20},{"createDate":"2013-10-04 16:49:17","discount":0.8,"discountPrice":16,"itemId":6,"itemImagePath":"/images/1tfp1_kqyumq3ikfbgurcugfjeg5sckzsew_150x170.jpg","itemName":"T恤","itemPrice":20}]',
        data: '{"createDate":"2013-10-04 16:49:03","discount":0.8,"discountPrice":16,"itemId":1,"itemImagePath":"/images/1tfp1_kqyv64cdkfbhm6dwgfjeg5sckzsew_150x169.jpg","itemName":"早秋新款","itemPrice":20}',
        contentType:'application/json;charset=UTF-8',
        success: function(msg){
        	var html = "";
            $.each(msg, function (index, item) {
            	html += '<li class="good">';
                html += '<a href="" class="imgbox" target="_blank" title="' + item.itemName +'">';
                html += '<img src="' + item.itemImagePath + '" alt="' + item.itemName +'">';
                html += '</a>';
                html += '<a href="" class="name" target="_blank" title="' + item.itemName +'">' + item.itemName +'</a>';
                html += '<div class="mask"></div>';
            	html += '</li>';
            });
        }
     });
    $(document).ready(function(){
    	$('#email').focus(function(){
    		var email = $('#email').val();
    		if ($.trim(email) == '邮箱 或 昵称') {
    			$('#email').val('');
    		}
    	});
    	$('#email').blur(function(){
    		var email = $('#email').val();
    		if ($.trim(email) == '' || $.trim(email) == '邮箱 或 昵称') {
    			$('#email').val('邮箱 或 昵称');
    			$('.err_name').css('visibility','visible');
    		} else {
    			$('.err_name').css('visibility','hidden');
    		}
    	});
    	
    	
    	$('#password').blur(function(){
    		var password = $('#password').val();
    		if ($.trim(password) == '') {
    			$('.err_pass').css('visibility','visible');
    		} else {
    			$('.err_pass').css('visibility','hidden');
    		}
    	});
    	
    	$('#authCode').blur(function(){
    		var authCode = $('#authCode').val();
    		if ($.trim(authCode) == '') {
    			$('#authcode_error').css('visibility','visible');
    		} else {
    			var auth = $.cookie('skmbw_vteba_auth_code_mn');
    			if (auth != undefined && auth.toLowerCase() != authCode) {
    				$('#authcode_error').css('visibility','visible');
    			} else {
    				$('#authcode_error').css('visibility','hidden');
    			}
    		}
    	});
    	
    	$('#loginBtn').click(function(){
    		var email = $('#email').val();
    		if ($.trim(email) == '' || $.trim(email) == '邮箱 或 昵称') {
    			$('#email').val('邮箱 或 昵称');
    			$('.err_name').css('visibility','visible');
    			return;
    		}
    		var password = $('#password').val();
    		if ($.trim(password) == '') {
    			$('.err_pass').css('visibility','visible');
    			return;
    		}
    		var authCode = $('#authCode').val();
    		if ($.trim(authCode) == '') {
    			$('#authcode_error').css('visibility','visible');
    			return;
    		} else {
    			var auth = $.cookie('skmbw_vteba_auth_code_mn');
    			if (auth != undefined && auth.toLowerCase() != authCode) {
    				$('#authcode_error').css('visibility','visible');
        			return;
    			}
    		}
    		var loginForm = $('#loginForm');
    		loginForm.submit();
    	});
    });
</script>

</head>
	<body>
	<div id="content_body">
		<div class="login_wrap">
    <div class="fm960">
         <div class="logo">
                	<a href="/" class="mogujie fl" title="微特吧">微特吧</a>
         </div>
         <div class="content">
<div class="lg_left">
         <h1>用户登录</h1>
    <div class="lg_form">
        <form id="loginForm" action="/user/doLogin" method="post">
      
                <div class="lg_name">
                                    <span>用户名：</span><input value="邮箱 或 昵称" name="userAccount" id="email" class="text r3" maxlength="32" type="text">
                            </div>
            <div class="err_name"><span>请输入登录名</span></div>
            <div class="clear"></div>
            <div class="lg_pass">
                <span>密码：</span><input value="" name="password" id="password" class="text r3" maxlength="32" type="password">
            </div>
            <div class="err_pass"><span>请输入密码</span></div>
            <div class="clear" id="appendimgcheck"></div>
                        	<div class="lg_chk shouldremove">
                    <span>验证码：</span>
<div id="login_imgcheck">
    <div class="imgcheck_code_main clearfix">
	    <input name="authCode" id="authCode" class="text r3" maxlength="4" type="text">
	    <div id="imgcheck_code_change" onclick="changeValidateCode($('#authImage')[0]);" style="float:none;vertical-align:middle;text-align:center;left:160px;cursor:pointer;"><span style="vertical-align:middle;text-align:center;color:#666;font-size:11px;">点击刷新</span></div> 
	    <img src="/authCode" style="vertical-align:middle;cursor:pointer;" onclick="changeValidateCode(this);" id="authImage" title="看不清？点击刷新" alt="微特吧"/>
	</div>
</div>
<div id="authcode_error" style="visibility:hidden;float:left;margin-left:12px;margin-left:14px\9;">
                <span style="padding-left: 21px;color:#ff89a7;background: url(/images/error1.png) no-repeat left center;">验证码错误</span>
            </div>
            	</div>
            	<div class="clear"></div>
            
            <div class="lg_remember">
                <label><input value="1" name="rememberMe" class="check" checked="checked" type="checkbox"><span>记住我（两周免登录）</span></label>
            </div>
            <div class="lg_login">
                <input id="loginBtn" class="sub" type="button"><a href="">忘记密码？</a>
            </div>
			
        </form>
        
    </div>
</div>
<div class="lg_right">
    <h2>注册</h2> <span style="margin-left:40px;">还没有账号？</span> <a style="margin-left:40px;" class="reg" href="/user/register"></a> </div> <input value="" id="isban" type="hidden">

</div>

    <p class="copyright">©Copyright 2010-2013 微特吧 vteba.com (增值电信业务经营许可证：浙B2-20110349)</p>
    
</div>
</div>
	</div>

</body></html>