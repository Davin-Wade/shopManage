<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8 0008
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
    <style>
        .out_box {
            width: 30%;
            height: 40%;
            border-radius: 3px;
            /*border: 2px solid;*/
            margin: 100px auto;
            box-shadow: 3px 3px 4px #b9b9b9;
            background: -webkit-linear-gradient(top, #bfbfbf, #dbdbdb, #ededed);
        }


        .in_box {
            height: 40%;
            padding-top: 30px;
        }

        .sub {
            width: 30%;
            font-size: 18px;
        }

        h1 {
            padding-top: 10px;
            text-align: center;
            color: blue;
        }


        .left {
            padding-top: 10px;
            padding-left: 100px;
        }


    </style>

    <script>
window.opener
    </script>
</head>
<body>

<div class="out_box">
    <form action="upLoadServlet" method="post" enctype="multipart/form-data">
        <script type="application/javascript" src="jsupload/upload.js"></script>
        <p><h1>上传商品照片</h1></p>
        <div class="in_box">
            <div class="left"><input type="file" name="upload"><br/></div>
            <div class="left">
                <input type="submit" value="上传" class="sub">
                <input type="button" value="返回" class="sub" onclick="window.close();">
            </div>
        </div>
    </form>
</div>


</body>
</html>
