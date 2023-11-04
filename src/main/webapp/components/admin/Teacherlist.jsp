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
<title>Teachers List</title>

</head>
<body>

    <jsp:include page="/components/admin/navbar.jsp"/>

    <div class=" w-full mt-[5rem]">
            <h1 class=" text-center text-3xl font-semibold  text-red-400">Teacher List</h1>
            <div class=" w-full min-h-[25vh] flex justify-center items-center pb-[4rem]">
              <table class=" w-[80%]  border">
                <tr class=" border bg-[#FFECEC] h-[5vh] text-xl font-semibold text-slate-700 ">
                  <th>Name</th>
                  <th>Email</th>
                  <th>Department</th>
                  <th>Action</th>
                </tr>

                 <% for (User user: (List<User>) request.getAttribute("teachers") ) { %>

                     <tr class=" border  text-center h-[6vh] text-lg font-medium shadow-md text-gray-600">
                          <td><%= user.getName()%></td>
                          <td><%= user.getEmail()%></td>
                          <td><%= user.getDept()%></td>
                          <td>
                           <i class="fa-regular fa-trash-can hover:text-red-500" onclick="handleClick('<%= user.getId()%>')"    ></i>
                          </td>
                      </tr>


                 <% } %>
              </table>
            </div>
          </div>

<script>
   function handleClick(param) {
     var xhr = new XMLHttpRequest();
     var url = "/webproject/teacherlist"; // replace with the URL of the server-side script that will handle the request
     var data = "param=" + encodeURIComponent(param); // encode the parameter value

     xhr.open("POST", url, true);
     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

     xhr.onreadystatechange = function() {
       if (xhr.readyState === 4 && xhr.status === 200) {
         // handle the response here
         console.log(xhr.responseText);
            location.reload();
       }
     };

     xhr.send(data);
   }
</script>

</body>
</html>