<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="UTF-8" language="java" %>
<%--防止从controller跳转之后的js资源报错--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //权限验证
    String userName =(String) session.getAttribute("userName");
    String password =(String) session.getAttribute("password");
    if (!"admin".equals(userName)||!"admin@kibo.com.cn".equals(password)){
        response.sendRedirect("login.jsp");
    }
%>

<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="en">
<head>
    <title>员工信息</title>
    <link href="layui/css/layui.css" type="text/css" rel="stylesheet"/>
    <style type="text/css">
        .layui-table-cell {
            height: auto;
            line-height: 28px;
        }
    </style>
    <script src="layui/layui.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        layui.use('table', function(){
            var table = layui.table;
            //var cardNum = getUrlParam('cardNum');
            table.render({
                elem: "#myTable",//一般都是写id选择器
                url: "${pageContext.request.contextPath}/ldap/queryGroup", //数据接口;请求地址
                toolbar:"#myToolbar",//id选择器的写法
                page: true,//开启分页
                limit:10,
                //limits:[10,80,100,900],
                title:"员工信息",
                //列
                cols: [[
                    {title: "姓名", field: "cn"},
                    {title:"工号",field:"uid"},
                    {title:"所属部门",field:"departmentNumber"},
                    {title:"邮箱",field:"mail"},
                    {title:"电话",field:"mobile"},
                    {title:"职位",field:"position"},
                    {title:"",templet:"#caoZuo"}
                ]],
                defaultToolbar:[],
                loading:false
            });

        });
        //搜索操作
        function doSearch() {
            window.location.href="${pageContext.request.contextPath}/ldap/updateAllPerson";
            alert(getUrlParam('addList'))
            //发送请求，并且接收数据
            layui.use('table', function() {
                var table = layui.table;
                table.reload('myTable', {
                });
            });

        }
        //添加弹出层
        function toOpenAddLayer(uid) {
            $("#jobNumber").val(uid)
            layui.use('layer', function(){
                layer.open({
                    title:"修改密码",
                    content:$("#insertForm"),
                    type:1,
                    maxmin:true
                })
            });
        }
        //获取url中的参数
        function getUrlParam(name) {
            // 取得url中?后面的字符
            var query = window.location.search.substring(1);
            // 把参数按&拆分成数组
            var param_arr = query.split("&");
            for (var i = 0; i < param_arr.length; i++) {
                var pair = param_arr[i].split("=");
                if (pair[0] == name) {
                    return pair[1];
                }
            }
            return (false);
        }
        // 添加方法
        //JavaScript代码区域
        layui.use(['element','upload'], function(){
            var element = layui.element;
            var $ = layui.jquery,upload = layui.upload;
            //普通图片上传
            var uploadInst = upload.render({
                // 文件上传的地址
                url: '${pageContext.request.contextPath}/ldap/updatePassword',
                data:{
                    // 参数携带格式 key-匿名函数
                    jobNumber:function(){
                        return $('#jobNumber').val();
                    },
                    newPassword:function () {
                        // 函数返回值 是通过选择器获取到的表单元素的值
                        return $('#newPassword').val();
                    }
                },
                // 不让文件上传组件自动上传
                auto:false
            });
        });
        //添加弹出层
        function doUpdate() {
            var jobNumber=document.getElementById("jobNumber").value;
            var newPassword=document.getElementById("newPassword").value;
            window.location.href="${pageContext.request.contextPath}/ldap/updatePassword?jobNumber="+jobNumber+"&newPassword="+newPassword;
        }
        function doHref() {
            window.location.href="admin.jsp";
        }
    </script>
    <script id="caoZuo" type="text/html">
        <button type="button" class="layui-btn layui-btn-radius layui-btn-normal" onclick="toOpenAddLayer('{{d.uid}}')">
                修改密码
        </button>
    </script>
</head>
<body>
    <div style="height: 38px;width: 200px;margin: 0 auto">
        <label class="layui-form-label" style="width: auto;margin: 0 auto">员工信息(LDAP)</label>
    </div>
<table id="myTable" lay-data="{id: 'myTable'}"></table>
    <div id="myToolbar" style="display: none">
        <div class="layui-input-inline" style="width: auto;">
            <button type="button" class="layui-btn layui-btn-normal" onclick="doSearch()">
            <i class="layui-icon"></i> 更新数据
            </button>
        </div>
        <div class="layui-input-inline" style="width: auto;">
            <button type="button" class="layui-btn layui-btn-normal" onclick="doHref()">
                <i class="layui-icon"></i> 跳转到钉钉数据
            </button>
        </div>
    </div>
    <form id="insertForm" style="display: none;width: 400px;height: 300px" class="layui-form">
        <div class="layui-form-item" style="height: 70px;margin-right: 100px;padding-top: 20px;text-align: center">
            <label class="layui-form-label" style="width: 50px">编号</label>
            <div class="layui-input-block" style="width: 200px">
                <input name="jobNumber" id="jobNumber" class="layui-input" readonly/>
            </div>
        </div>

        <div class="layui-form-item" style="height: 70px;margin-right: 100px;text-align: center">
            <label class="layui-form-label" style="width: 50px">新密码</label>
            <div class="layui-input-block" style="width: 200px">
                <input name="newPassword" id="newPassword" class="layui-input" placeholder="新密码" lay-verify="required|newPassword"/>
            </div>
        </div>
        <div class="layui-form-item" style="height: 70px;margin-right: 50px;text-align: center">
            <button lay-submit type="button" lay-filter="add" class="layui-btn" id="addSubmitBtn" style="display:block;margin:0 auto"  onclick="doUpdate()">修改</button>
        </div>
    </form>
</body>
</html>
