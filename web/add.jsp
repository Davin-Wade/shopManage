<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/12 0012
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
    <style>
        table {
            /*border:2px solid darkgray;*/
            border-radius: 3px;
            box-shadow: 2px 2px 2px darkgray;
            background: -webkit-linear-gradient(top, #bfbfbf, #dbdbdb, #ededed);
        }

        .right {
            text-align: center;
        }

        .left {
            text-align: center;
        }

        .sub {
            text-align: center;
        }

        .fun {
            width: 20%;
            font-size: 18px;
        }
    </style>

    <script>
        function newFIle() {
            var windowURL = window.URL || window.webkitURL;
            var loadImg = windowURL.createObjectURL(document.getElementById("uploadImg").files[0]);
            document.getElementById("Imge").setAttribute("src", loadImg);
        }
    </script>
</head>
<body>

<form action="${pageContext.request.contextPath}/goodsServlet?opr=add" method="post" enctype="multipart/form-data">
    <script type="application/javascript" src="jsupload/upload.js"></script>
    <table border="1" align="center" width="90%" cellpadding="5" cellspacing="0">
        <tr>
            <td colspan="2" style="color: blue" align="center"><h1>增添商品</h1></td>
        </tr>
        <tr>
            <td class="left">商品名称</td>
            <td class="right">
                <input type="text" name="names"/>
            </td>
        </tr>
        <tr>
            <td class="left">商品照片</td>
            <td class="right">
                <input type="file" name="pic">
                <%--                <img src="" id="picImg" name="pic" alt="无法显示" width="100px" height="100px">--%>
                <%--                <input type="hidden" name="pic" id="pic">--%>
                <%--                <input type="button" value="上传" onclick="window.open('upload.jsp')">--%>
            </td>
        </tr>
        <tr>
            <td class="left">商品价格</td>
            <td class="right">
                <input type="text" name="price"/>
            </td>
        </tr>
        <tr>
            <td class="left">商品详情</td>
            <td class="right">
<%--                <input type="text" name="desc"/>--%>
                <textarea cols="20" rows="7" name="desc"></textarea>
            </td>
        </tr>
        <tr>
            <td class="left">商品库存</td>
            <td class="right">
                <input type="text" name="stock"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="sub">
                <input type="submit" value="添加" style="margin-left: 20px" class="fun">
                <input type="button" value="返回" onclick="history.back()" style="margin-left: 20px" class="fun">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
