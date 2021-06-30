<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    var ctx = '${pageContext.request.contextPath}';
</script>
<html>
<head>
    <title>测试方法</title>
</head>
<body>
<div class="demoTable" style="padding: 15px">
    搜索手机号：
    <div class="layui-inline">
        <input class="layui-input" id="find" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload" id="queryRole" >搜索</button>
</div>

<div class="demoTable" style="padding: 15px">
    搜索头像：
    <div class="layui-inline" style="width: 50px;height:50px;">
        <img style="width: 50px;height:50px;" src="${pageContext.request.contextPath}/api/minio/getImage?idCard='320124196812123048'" id="image"/>
    </div>
    <button class="layui-btn" data-type="reload" id="" >搜索</button>
</div>

<table class="layui-hide" id="Users" lay-filter="test"></table>

<script type="text/javascript">
    <%--$(function () {--%>
    <%--    debugger;--%>
    <%--    $.ajax({--%>
    <%--        url : '${pageContext.request.contextPath}/api/minio/getImage',--%>
    <%--        dataType: 'json',--%>
    <%--        responseType:"arraybuffer",--%>
    <%--        data: {--%>
    <%--            idCard: '320124196812123048'--%>
    <%--        },--%>
    <%--        type: "POST",--%>
    <%--        success: function(data){--%>
    <%--            $("#image").attr("src", "data:image/png;base64," + Base64.encodeBase64(data));--%>
    <%--            console.info(data);--%>
    <%--            window.location.href=data.resultUrl;--%>
    <%--            console.log(data);--%>
    <%--            console.log(11111);--%>
    <%--        }--%>
    <%--    });--%>
    <%--})--%>
</script>

</body>
</html>