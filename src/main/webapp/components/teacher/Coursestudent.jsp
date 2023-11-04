<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="cse.web.model.User"%>
 <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/svg+xml" href="images/main_logo.svg" />
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Student List</title>

</head>
<body>

    <jsp:include page="/components/admin/navbar.jsp"/>

    <div class=" w-full mt-[5rem]">
        <h1 class=" text-center text-[2rem] font-semibold text-[#00A24C]">Student List</h1>
        <div class=" w-full min-h-[25vh] flex justify-center items-center pb-8">
          <table class=" w-[80%]  border">
            <tr class=" border bg-[#FFECEC] h-[5vh] text-xl font-semibold text-slate-700 ">
              <th>Name</th>
              <th>Registration No</th>
              <th>Department</th>

            </tr>


            <% for (User user: (List<User>) request.getAttribute("users") ) { %>

                 <tr class=" border  text-center h-[6vh] text-lg font-medium shadow-md text-gray-600">
                      <td><%= user.getName()%></td>
                      <td><%= user.getReg()%></td>
                      <td><%= user.getDept()%></td>
                  </tr>


            <% } %>
          </table>
        </div>
      </div>



</body>
</html>