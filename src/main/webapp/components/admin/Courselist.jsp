<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="cse.web.model.Course"%>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/svg+xml" href="images/main_logo.svg" />
<script src="https://cdn.tailwindcss.com"></script>

<title>Courses List</title>

</head>
<body>

    <jsp:include page="/components/admin/navbar.jsp"/>



         <div class=" w-[100%] min-h-[90vh]  pt-16 pl-[2rem] pr-[2rem] flex flex-wrap justify-center space-x-10 ">

         <% for (Course course : (List<Course>) request.getAttribute("courses")) { %>




                     <div class=" w-[25%] h-[35vh] shadow-lg rounded-xl hover:scale-110 ease-in duration-300">
                           <div class="">
                              <img src="images/logo1.jpg" alt="" class=' h-[20vh] w-[100%]' />
                           </div>
                            <div class=" p-4 space-y-3">
                              <h3 class=" text-xl font-semibold"><%= course.getCourseCode()%></h3>
                              <h5 class=" text-lg font-medium text-gray-500"><%= course.getCourseName()%></h5>
                              <h5 class=" text-lg font-medium text-gray-500">Teacher: <span><%= course.getCourseTeacher()%></span></h5>
                            </div>
                     </div>






         <% } %>

    </div>



</body>
</html>