<%--
  Created by IntelliJ IDEA.
  User: Sanuga
  Date: 10/15/2026
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SkillHub | Login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
   <div class="login-box">
       <div class="img-side">
           <img src="assests/login.svg" alt="login banner">
       </div>
       <div class="input-side">
           <form action="login" method="POST">
               <div class="username-div">
                    <div>

                    </div>
                   <div>
                       <label for="username">Username</label>
                       <input type="text" id="username" name="username" placeholder="Username">
                   </div>
               </div>
               <div class="password-div">
                   <div>

                   </div>
                   <div>
                       <label for="password">Password</label>
                       <input type="password" id="password" name="password" placeholder="Password">
                   </div>
               </div>
               <button type="submit">Login</button>
           </form>
       </div>
   </div>
</body>
</html>
