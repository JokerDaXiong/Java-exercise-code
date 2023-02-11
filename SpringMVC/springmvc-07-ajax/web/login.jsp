<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用ajax登录验证</title>
    <!--    jquery-->
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        function n1(){
            $.ajax({
                url:"${pageContext.request.contextPath}/ajax3",
                data:{"name":$("#name").val()},
                success:function (data){
                    // console.log(data)
                    if(data.toString() === 'ok'){
                        $("#uinfo").css("color","green")
                    }else{
                        $("#uinfo").css("color","red")
                    }
                    $("#uinfo").html(data)
                }
            })
        }
        function n2(){
            $.ajax({
                url:"${pageContext.request.contextPath}/ajax3",
                data:{"pwd":$("#pwd").val()},
                success:function (data){
                    // console.log(data)
                    if(data.toString() === 'ok'){
                        $("#pinfo").css("color","green")
                    }else{
                        $("#pinfo").css("color","red")
                    }
                    $("#pinfo").html(data)
                }
            })
        }
    </script>
</head>
<body>
    <form action="" method="">
        账号：<input type="text" id="name" onblur="n1()"><span id="uinfo"></span><br>
        密码：<input type="password" id="pwd" onblur="n2()"><span id="pinfo"></span><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
