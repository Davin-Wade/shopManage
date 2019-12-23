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
            height: 55%;
            margin: 120px auto;
            /*border: 1px solid;*/
            border-radius: 3px;
            background: -webkit-linear-gradient(top, #d3d3d3, #eaeaea, #D3D3D3);
            box-shadow: 3px 3px 4px #b9b9b9;
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

        #register {
            text-align: right;
            float: right;
            font-size: 18px;
            padding-top: 30px;
            padding-right: 10px;
        }

        .text {
            height: 28px;
        }

    </style>

</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <div class="box">
        <div class="title">欢迎来到商品信息中心</div>
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
            <a href="register.jsp" id="register">注册</a>

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
