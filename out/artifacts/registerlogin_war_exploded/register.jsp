<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<link rel="icon" href="images/search.gif" type="img/x-ico" />
<link href="css/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<body>

<div id="top"></div>
<div id="main">
    <img src="images/login.jpg" id="main_bg"/>
    <div id="login_block">
        <form action="/register"   method="post" id="loginForm">
            <table border="0">
                <tr><td colspan="3" align="center"> <font color="red">
                    ${error}
                </font>
                </td>


                </tr>
                <tr>
                    <td   colspan="1"class="title">昵称:</td>
                    <td class="input">
                        <input   required="required" type="text" name="name"  id="name" class="login_input"/>
                    </td>
                </tr>

                <tr>
                    <td colspan="1" class="title">账号:</td>
                    <td class="input">
                        <input type="text" oninput="if(value.length>11)value=value.slice(0,9)" required="required"  name="accountnumber" id="accountnumber" class="login_input"/>
                    </td>



                <%--						<td class="msg_cont">--%>
                    <%--							<%--%>
                    <%--								String  error=(String) request.getAttribute("error");--%>
                    <%--								if(error==null){--%>
                    <%--									error="请输入用户名和密码";--%>
                    <%--								}--%>
                    <%--							%>--%>
                    <%--							<span class="error"><%=error--%>
                    <%--							%></span>--%>
                    <%--						</td>--%>
                </tr>

                <tr>
                    <td colspan="1" class="title">密码:</td>
                    <td class="input">
                        <input pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$"  title="至少8个字符且同时包含字母和数字" required="required" type="password" name="password"  id="password" class="login_input"/>
                    </td>
                    <td colspan="2" >
                        至少8个字符且同时包含字母和数字
                    </td>

                </tr>


                <tr>
                    <td colspan="2">
                        <input required="required" class="btn" type="submit" value="注册"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div id="footer">
    <div class="foot_content">
        CopyRight &copy; 2020 www.jiazhijun.com 南京市有限公司
    </div>
    <div class="foot_content">
        版权所有 Library V1.1
    </div>
</div>
</body>
</html>