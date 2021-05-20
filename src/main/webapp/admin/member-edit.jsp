<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String name = (String) request.getAttribute("member-name");%>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" action="/myweb/admin/edit">
            <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">
                    <span class="x-red">*</span>用户
                </label>
                <div class="layui-input-inline">
                    <input  readonly="readonly" value= <%=name%> type="text" id="L_email" name="email" required="" lay-verify="email"
                            autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>当前修改的用户
                </div>
            </div>

            <div class="layui-form-item">
                <label for="L_sex" class="layui-form-label">
                    <span class="x-red">*</span>性别
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_sex" name="sex" required="" lay-verify="repass"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>男或女
                </div>
            </div>

            <div class="layui-form-item">
                <label for="L_age" class="layui-form-label">
                    <span class="x-red">*</span>年龄
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_age" name="age" required="" lay-verify="repass"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label for="L_phone" class="layui-form-label">
                    <span class="x-red">*</span>电话
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_phone" name="phone" required="" lay-verify="repass"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>11位数字
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_balance" class="layui-form-label">
                    <span class="x-red">*</span>余额
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="L_balance" name="balance" required="" lay-verify="repass"
                           autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                </label>
                <button  class="layui-btn" lay-filter="add" type="submit" onclick="javascript:window.close()">
                    修改
                </button>
            </div>
        </form>
    </div>

  </body>

</html>