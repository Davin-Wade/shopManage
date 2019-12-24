<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/10 0010
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>

    <style>
        .box_out{
            width: 35%;
            height: 80%;
            border-radius: 3px;
            box-shadow:0px 0px 10px #cecece;
            margin: auto;
            margin-top: 60px;
            overflow: hidden;
        }


        .box_in{
            width:70%;
            height:90%;
            margin:auto;
        }


        .text_left{
            width: 80px;
            font-size: 20px;
            font-weight: bold;
            color: rgba(83, 83, 83, 0.56);
            padding-top: 5px;
            padding-left: 40px;
        }

        .text_right{
            padding-left: 65px;
            padding-top: 5px;
        }

        .texts{
            height:28px;
            padding-left: 5px;

        }

        .sub{
            font-size: 20px;
            color: black;
            height: 30px;
            width:200px;
        }

        #login a:hover{
            text-align: center;
            color: #fe9c4d;
        }

        #login a{
            color: grey;
        }
        .title{
            font-size: 30px;
        }


    </style>
</head>
<body style="background-color: #f3f2ef">

<div class="box_out" style="background-color: #ffff">
    <form action="${pageContext.request.contextPath}/registerServlet" method="post">
        <div class="title" align="center"><span id="login"><a href="login.jsp" style="text-decoration: none;">登录</a></span> ·
            <span id="register"><a href="register.jsp" style="text-decoration: none;color: #fe9c4d">注册</a></span></div>
        <table class="box_in" width="50%" align="center" >
            <tr>
                <td class="text_left">用户名</td>
                <td class="text_right">
                    <input type="text" name="username" id="username" placeholder="设置用户名" class="texts">
                </td>
            </tr>

            <tr>
                <td class="text_left">密&nbsp;&nbsp;&nbsp;码</td>
                <td class="text_right">
                    <input type="password" name="password" id="password" placeholder="设置密码" class="texts">
                </td>
            </tr>

            <tr>
                <td class="text_left" style="font-size: 18px;">密码验证</td>
                <td class="text_right">
                    <input type="password" name="password1" id="password1" placeholder="再次输入密码" class="texts">
                </td>
            </tr>

            <tr>
                <td class="text_left">性&nbsp;&nbsp;&nbsp;别</td>
                <td class="text_right">
                    男<input type="radio" name="sex" class="texts" value="男">
                    女<input type="radio" name="sex" class="texts" value="女">
                </td>
            </tr>

            <tr>
                <td class="text_left">爱&nbsp;&nbsp;&nbsp;好</td>
                <td class="text_right">
                    游戏<input type="checkbox" name="hobbys" value="游戏">
                    看书<input type="checkbox" name="hobbys" value="看书">
                    购物<input type="checkbox" name="hobbys" value="购物">
                    动漫<input type="checkbox" name="hobbys" value="动漫">
                </td>
            </tr>

            <tr>
                <td class="text_left">邮&nbsp;&nbsp;&nbsp;箱</td>
                <td class="text_right">
                    <input type="email" name="email" placeholder="可用于找回账号或密码" class="texts">
                </td>
            </tr>

            <tr>
                <td class="text_left">手&nbsp;&nbsp;&nbsp;机</td>
                <td class="text_right">
                    <input type="text" name="phone" class="texts" placeholder="请输入手机">
                </td>
            </tr>

            <tr>
                <td class="text_left">地&nbsp;&nbsp;&nbsp;址</td>
                <td class="text_right">
                    <input type="text" name="addrs" class="texts" placeholder="请输入地址">
                </td>
            </tr>

            <tr>
                <td colspan="2" class="go" align="center"><input type="submit" value="注册" class="sub"> </td>
            </tr>
        </table>
    </form>
</div>




</body>
</html>
