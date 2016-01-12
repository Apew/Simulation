<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数据仿真平台</title>
<#include "common-js.ftl"/>
<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
</head>
<body>
  <div>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
      <li><a tabindex="-1" href="#">Action</a></li>
      <li><a tabindex="-1" href="#">Another action</a></li>
      <li><a tabindex="-1" href="#">Something else here</a></li>
      <li class="divider"></li>
      <li><a tabindex="-1" href="#">Separated link</a></li>
    </ul>
  </div>
	<div class="container">

      <form class="form-signin" action="login.do" method="post">
        <h2 class="form-signin-heading">数据仿真平台登陆</h2>
        <input type="text" class="input-block-level" placeholder="用户名" name="name">
        <input type="password" class="input-block-level" placeholder="密码" name="pwd">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 记住密码
        </label>
        <button class="btn btn-large btn-primary" type="submit">登陆</button>
      </form>

    </div>
</body>
</html>