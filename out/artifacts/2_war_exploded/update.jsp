<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>stu_update</title>
    <style>

        td, text {
            text-align: center;
        }

        table {
            border-radius: 3px;
            box-shadow: 2px 2px 2px darkgray;
            background: -webkit-linear-gradient(top, #bfbfbf, #dbdbdb, #ededed);
        }

        .fun {
            width: 20%;
            font-size: 18px;
        }

        .sub {
            align-content: center;
        }

        select {
            height: 25px;
        }
    </style>

</head>
<body>

<form action="${pageContext.request.contextPath}/goodsServlet?opr=update" method="post">
    <script type="application/javascript" src="jsupload/upload.js"></script>
<%--    <input type="hidden" value="update" name="opr">--%>
    <table border="1" align="center" width="90%" cellpadding="5" cellspacing="0">

        <tr>
            <td colspan="2" style="color: blue" align="center"><h1>修改商品商品</h1></td>
        </tr>
                <tr>
                    <td class="left">商品ID</td>
                    <td class="right" name="ids">
                            ${gd[0].id}
                        <input type="hidden" name="ids" value="${gd[0].id}">
                    </td>
                </tr>
                <tr>
                    <td class="left">商品名称</td>
                    <td class="right">
                        <input type="text" name="names" value="${gd[0].name}"/>
                    </td>
                </tr>
                <tr>
                    <td class="left">商品照片路径</td>
                    <td class="right">
                        <img src="${gd[0].pic}" id="picImg" name="pic" alt="无法显示" width="100px" height="100px">
                        <input type="hidden" name="pic" id="pic" value="${gd[0].pic}">
                        <input type="button" value="上传" onclick="window.open('upload.jsp')">
                    </td>
                </tr>
                <tr>
                    <td class="left">商品价格</td>
                    <td class="right">
                        <input type="text" name="price" value="${gd[0].price}"/>
                    </td>
                </tr>
                <tr>
                    <td class="left">商品详情</td>
                    <td class="right">
                        <input type="text" name="desc" value="${gd[0].desc}"/>
                    </td>
                </tr>
                <tr>
                    <td class="left">商品库存</td>
                    <td class="right">
                        <input type="text" name="stock" value="${gd[0].stock}"/>
                    </td>
                </tr>
        <tr>
            <td colspan="2" class="sub">
                <input type="submit" value="保存" style="margin-left: 20px" class="fun"
                       onclick="return confirm('确认修改吗？')">
                <input type="button" value="返回" onclick="history.back()" style="margin-left: 20px" class="fun">
            </td>
        </tr>
    </table>
</form>
<script>
    document.getElementById()
</script>

</body>
</html>
