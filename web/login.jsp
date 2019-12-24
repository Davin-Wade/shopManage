<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/9 0009
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>

    <style>
        .box {
            width: 35%;
            height:55%;
            margin: 120px auto;
            border-radius:3px;
            box-shadow:0px 0px 10px #cecece;
        }

        .inbox {
            margin: 60px auto 0px 140px;
        }

        .title {
            text-align: center;
            color: grey;
            font-size: 40px;
        }

        .u_left, .u_right {
            padding-top: 10px;
            font-size: 18px;
        }

        .sub {
            padding-top: 20px;
        }

        #sublong {
            font-size: 18px;
            width: 100px;
            height: 35px;
        }

        #register a:hover{
            text-align: center;
            font-size: 40px;
            color: #fe9c4d;
        }

        #register a{
            color: grey;
        }

        .text{
            height: 28px;
        }

    </style>

</head>
<body style="background-color: #f3f2ef">
<div class="box" style="background-color: #ffffff">
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="title"><span id="login"><a href="login.jsp" style="text-decoration: none;color: #fe9c4d">登录</a></span> · <span id="register"><a href="register.jsp" style="text-decoration: none;">注册</a></span></div>
        <div class="inbox">
            <table>
                <tr>
                    <td class="u_left">用户名：</td>
                    <td class="u_right"><input type="text" class="text" name="username" id="username" placeholder="请输入用户名"></td>
                </tr>
                <tr>
                    <td class="u_left">密&nbsp;&nbsp;&nbsp;码：</td>
                    <td class="u_right"><input type="password" class="text" name="password" id="password" placeholder="请输入密码"></td>
                </tr>
                <tr>
                    <td class="u_left">验证码：</td>
                    <td class="u_right"><input type="text" class="text" name="checkCode" id="checkCode" placeholder="请输入验证码">
                        <img src="checkCodeServlet" id="Img" height="40px" ></td>
                </tr>
                <tr>
                    <td colspan="2" class="sub" >免登陆<input type="radio" name="freeLogin" value="yes">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录"  id="sublong"></td>
                </tr>
            </table>

        </div>
    </div>
</form>


<script>
    window.onload = function () {
        var CodeImg = document.getElementById("Img");
        CodeImg.onclick = function () {
            this.src = "checkCodeServlet";
        }

    };

</script>



</body>
</html>
