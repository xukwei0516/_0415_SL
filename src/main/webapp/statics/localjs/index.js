$("#loginBtn").click(function(){
	var user = new Object();
	user.loginCode = $.trim($("#logincode").val());
	user.password = $.trim($("#password").val());
	user.isStart = 1;
	
	if(user.loginCode == "" || user.loginCode == null){
		 $("#logincode").focus();
		 $("#formtip").css("color","red");
		 $("#formtip").html("对不起，登录账号不能为空。");
	}else if(user.password == "" || user.password == null){
		$("#password").focus();
		$("#formtip").css("color","red");
		$("#formtip").html("对不起，登录密码不能为空。");
	}else{
		$("#formtip").html("");

		$.ajax({
			url: '/login.html',
			type: 'POST',
			data:{"loginCode":user.loginCode,"password":user.password},
			dataType: 'text',
			timeout: 1000,
			cache:false,
			error: function(){
				$("#formtip").css("color","red");
				$("#formtip").html("服务器无响应！请重试。");
			},
			success: function(result){
                    if(result != "" && "success" == result){
                        window.location.href='/main.html';
                    }else if("failed" == result){
                        $("#formtip").css("color","red");
                        $("#formtip").html("用户名或密码错误!请重试。");
                        $("#logincode").val('');
                        $("#password").val('');
                    }
				}
			});
	}
});

