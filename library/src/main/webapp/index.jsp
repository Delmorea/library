<%@ page import="personal.delmore.utils.GsonUtils" %>
<%@ page import="personal.delmore.entity.User" %>
<%@ page import="personal.delmore.utils.StringUtils" %>
<%@ page import="java.net.URL" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>bookSystem</title>
    <link rel="stylesheet" href="css/style.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<!-- partial:index.partial.html -->
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">登录</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">注册</label>
        <div class="login-form">
            <form action="/library/loginServlet" method="post" id="form">
                <!--登录-->
                <div class="sign-in-htm">
                    <div class="group">
                        <label for="user" class="label">用 户 名</label>
                        <input id="user" name="user" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">密 码</label>
                        <input id="pass" name="pass" type="password" class="input" data-type="password">
                    </div>
                    <div id="errorMsg" class="group">${errorMsg}</div>
                    <br>
                    <div class="group">
                        <input type="submit" class="button" value="提  交">
                    </div>
                    <div class="hr"></div>
                </div>
            </form>

            <form action="/library/registerServlet" method="post" id="form2">
                <!--注册-->
                <div class="sign-up-htm">
                    <div class="group">
                        <label for="user" class="label">用 户 名</label>
                        <input id="username" name="user" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">密 码</label>
                        <input id="password" name="pass" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">确 认 密 码</label>
                        <input id="psword" name="password" type="password" class="input" data-type="password">
                    </div>
                    <div id="errorMeg" class="group">${errorMeg}</div>
                    <br>
                    <div class="group">
                        <input type="submit" class="button" value="注 册">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- partial -->

</body>
</html>