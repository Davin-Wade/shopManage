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
</head>
<style>
    .box {
        width: 25%;
        height: 55%;
        margin: 120px auto;
        border-radius: 3px;
        box-shadow: 0px 0px 10px #cecece;
    }

    .inbox {
        margin: 40px auto 0 50px;
    }

    .title {
        text-align: center;
        color: grey;
        font-size: 40px;
    }

    .u_left, .u_right {
        padding-top: 20px;
        padding-left: 15px;
        font-size: 18px;
    }

    .sub {
        padding-top: 20px;
        padding-left: 15px;
    }

    #sublong {
        font-size: 18px;
        width: 100px;
        height: 35px;
        border-radius: 5px;
        background-color: #e3e2dd;
        color: #b1b0ab;
    }

    #sublong:hover {
        background-color: #bcbbb6;
        color: #3c4bbc;
    }

    #register a:hover {
        text-align: center;
        font-size: 40px;
        color: #fe9c4d;
    }

    #register a {
        color: grey;
    }

    .text {
        height: 28px;
    }

    #checkCode {
        width: 100px;
    }

    #SUB {
        padding-left: 30px;
    }
</style>

<body style="background-color: #f3f2ef">
<div class="box" style="background-color: #ffffff">
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="title"><span id="login"><a href="login.jsp"
                                               style="text-decoration: none;color: #fe9c4d">登录</a></span> · <span
                id="register"><a href="register.jsp" style="text-decoration: none;">注册</a></span></div>
        <div class="inbox">
            <table>
                <tr>
                    <td class="u_left">用户名：</td>
                    <td class="u_right" colspan="2"><input type="text" class="text" name="username" id="username"
                                                           placeholder="请输入用户名"></td>
                </tr>
                <tr>
                    <td class="u_left">密&nbsp;&nbsp;&nbsp;码：</td>
                    <td class="u_right" colspan="2"><input type="password" class="text" name="password" id="password"
                                                           placeholder="请输入密码"></td>
                </tr>
                <tr>
                    <td class="u_left">验证码：</td>
                    <td class="u_right"><input type="text" class="text" name="checkCode" id="checkCode"
                                               placeholder="请输入验证码"></td>
                    <td style="padding-top: 15px"><img src="checkCodeServlet" id="Imge" height="40px"></td>
                </tr>
                <tr>
                    <td colspan="2" class="sub"><span style="font-size: 13px">免登陆</span><input type="radio"
                                                                                               id="freeLogin"
                                                                                               name="freeLogin"
                                                                                               value="yes"><span
                            id="SUB"><input type="submit" value="登录" id="sublong"></span></td>
                </tr>
            </table>

        </div>
    </form>
</div>


<script>
    window.onload = function () {
        var CodeImg = document.getElementById("Imge");
        CodeImg.onclick = function () {
            this.src = "checkCodeServlet?" + Math.random();
        }
    };

</script>




</body>
</html>
