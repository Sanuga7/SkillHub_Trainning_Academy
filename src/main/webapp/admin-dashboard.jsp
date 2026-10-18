<%--
  Created by IntelliJ IDEA.
  User: Sanuga
  Date: 10/16/2026
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.skillhub.ee.model.User" %>
<%
    // Mandatory Security Check
    if (session == null || session.getAttribute("loggedUser") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    User loggedUser = (User) session.getAttribute("loggedUser");
    if (!"ADMIN".equals(loggedUser.getRole())) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard | SkillHub Training Academy</title>
    <link href="css/admin-dashboard.css" rel="stylesheet">
</head>
<body>
<!-- Top Navigation Bar -->
<nav class="navbar">
    <div class="nav-brand">SkillHub Admin Portal</div>
    <div class="nav-user">
        <span>Welcome, <%= loggedUser.getFname() %> <%= loggedUser.getLname() %></span>
        <a href="<%= request.getContextPath()%>/logout" class="btn-logout">Logout</a>
    </div>
</nav>

<!-- Main Layout -->
<div class="dashboard-container">

    <!-- Sidebar Navigation -->
    <aside class="sidebar">
        <div class="sidebar-header">Admin Actions</div>
        <ul class="sidebar-menu">
            <li><a href="#" class="active">Manage Courses</a></li>
            <li><a href="#">View Trainers</a></li>
            <li><a href="#">System Reports</a></li>
        </ul>
    </aside>

    <!-- Dashboard Content -->
    <main class="main-content">
        <div class="header-section">
            <h2>System Overview</h2>
            <p>Manage all academy training programs and resources.</p>
        </div>

        <!-- Statistics Row -->
        <div class="stats-grid">
            <div class="stat-card">
                <h3>3</h3>
                <p>Active Courses</p>
            </div>
            <div class="stat-card">
                <h3>3</h3>
                <p>Registered Trainers</p>
            </div>
            <div class="stat-card">
                <h3>6</h3>
                <p>Total Enrollments</p>
            </div>
        </div>

        <!-- Course Data Table -->
        <div class="table-container">
            <div class="table-header">
                <h3>Active Training Programmes</h3>
                <button class="btn-add">+ Add New Course</button>
            </div>
            <table>
                <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Title</th>
                    <th>Capacity</th>
                    <th>Assigned Trainer</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <!-- Data will be injected here via Servlet in Sprint 3 -->
                <tr>
                    <td colspan="5" class="empty-state">
                        Data will be loaded from in-memory ServletContext in Sprint 3...
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </main>
</div>
</body>
</html>
