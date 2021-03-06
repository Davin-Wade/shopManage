<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/18 0018
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生表</title>
</head>

<style>
    .search {
        width: 100px;
    }

    .title {
        color: #975acd;
    }

    table {
        border-radius: 3px;
        box-shadow: 3px 3px 4px #b9b9b9;
        background: -webkit-linear-gradient(top, #bfbfbf, #dbdbdb, #ededed);
    }

    #checkSize {
        width: 15px;
        height: 15px;
    }

    #checkAll {
        width: 15px;
        height: 15px;
    }

    .page{
        outline:none;
        background-color: #dbdbdb;
        border-radius: 16px;
        border: 0;
        font-size: 16px;
        width: 80px;
    }

    .page:hover{
        background-color: #b9b9b9;
    }

    p{
        text-align: center;
        text-decoration: none;
    }

    .firLine{
        outline:none;
        background-color: #bfbfbf;
        border-radius: 16px;
        border: 0;
        font-size: 16px;
        width: 80px;
    }

    .firLine:hover{
        color: #605cf5;
    }



    #off{
        float: right;
        font-size: 25px;
        color: #78a0ac;
        background: -webkit-linear-gradient(top, #bfbfbf, #dbdbdb, #ededed);
        border-radius: 3px;
        box-shadow: 3px 3px 4px #b9b9b9;
        text-decoration:none;
    }
    #off:hover{
        color: #ff675c;
    }

    tr:hover{
        background-color: #b3b3b3;
    }

</style>

<script>
    /**
     *  实现全选
     */
    function checkAllSelect() {
        var checkAll = document.getElementById("checkAll");
        var checkAll2 = document.getElementsByName("checks");
        if (checkAll.checked) {
            for (var i = 0; i < checkAll2.length; i++) {
                checkAll2[i].checked = true;
            }
        } else {
            for (var i = 0; i < checkAll2.length; i++) {
                if (checkAll2[i].checked == true) {
                    checkAll2[i].checked = false;
                }
            }
        }
    }

    function remove() {
        document.getElementById("go").submit();
    }
</script>

<body>
<form action="${pageContext.request.contextPath}/goodsServlet" method="post" id="form">

    <table align="center" cellpadding="5px" cellspacing="0" width="90%">
        <h1 style="color: #3a35f3" align="center">商品信息中心</h1>
        <tr>
            <td>欢迎用户 ${noFreeUsername} 登录</td>
            <td>
                商品名称：<input type="text" name="nameSearch" class="search" >&nbsp;&nbsp;&nbsp;<input
                    type="submit" class="firLine" value="查询" style="outline: none"></a>
            </td>
            <td align="right">
                <a href="add.jsp"><input type="button" class="firLine" value="添加"></a>
                <a href="javascript:void(0);" onclick="remove()"><input type="button" class="firLine" onclick="confirm('确定删除吗')"
                                                                        value="批量删除"></a>
            </td>
            <td></td>
            <td></td>
            <td>
                <a href="loginOffServlet" id="off">
                    退出用户
                </a>
            </td>
        </tr>
    </table>
</form>
<form action="goodsServlet?opr=del" method="post" id="go">

    <table border="2px" align="center" cellpadding="3px" cellspacing="0" width="90%">
        <tr>
            <th><input type="checkbox" id="checkAll" name="checkall" onclick="checkAllSelect()"/></th>
            <th class="title" style="display: none">ID:</th>
            <th class="title">商品名称:</th>
            <th class="title">商品价格:</th>
            <th class="title">商品描述:</th>
            <th class="title">商品库存:</th>
            <th class="title">商品照片:</th>
            <th class="title">操作:</th>

        </tr>
        <c:if test="${list != null}">
            <c:forEach items="${list}" var="gd" varStatus="s">
                <tr>
                    <td align="center"><input type="checkbox" name="checks" value="${gd.id}" id="checkSize"></td>
                    <td name="ids" align="center" style="display: none">${s.count}</td>
                    <td name="names" align="center">${gd.name}</td>
                    <td name="price" align="center">${gd.price}</td>
                    <td name="desc" align="center">${gd.desc}</td>
                    <td name="stock" align="center">${gd.stock}</td>
                    <td name="pic" align="center"><img src="${gd.pic}" width="100px" height="100px"></td>
                    <td align="center"><a
                            href="${pageContext.request.contextPath}/goodsServlet?opr=del&checks=${gd.id}"><input
                            type="button" value="删除"></a>
                        <a href="${pageContext.request.contextPath}/goodsServlet?opr=getGoods&checks=${gd.id}"><input
                                type="button" value="编辑"></a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</form>
<form action="goodsServlet" method="post">
<p>
    <a href="goodsServlet?page=0" ><input type="button" class="page" value="首  页"></a>
    <a href="goodsServlet?nameSearch=${nameSearch}&page=${page.nowPage-1}" ><input type="button" class="page" value="上 一 页" ></a>
    第<input type="text" name="page" value="${page.nowPage+1}" style="width: 20px;text-align: center"> 页/共${page.totlePage}页
    <a href="goodsServlet?nameSearch=${nameSearch}&page=${page.nowPage+1}" ><input type="button" class="page" value="下 一 页" ></a>
    <a href="goodsServlet?page=${page.totlePage}" ><input type="button" class="page" value="尾  页" ></a>
</p>
</form>
</body>
</html>
