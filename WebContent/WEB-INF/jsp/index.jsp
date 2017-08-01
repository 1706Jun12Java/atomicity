<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link rel="stylesheet" href="../css/normalize.css"/>
    <link rel="stylesheet" href="../css/mystyle.css"/>
  </head>
  <body>
  <img id="logoImg2" src="../img/atomicitylogo.png" alt="atomicity logo">
  <div class="login-page">
  <div class="form">
    <form action ="login" method="post" class="login-form">
      <input type="text" placeholder="username"/>
      <input type="password" placeholder="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="register.html">Create an account</a></p>
    </form>
  </div>
</div>
  </body>
</html>