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

<title>Create New Course</title>

</head>
<body>

    <jsp:include page="/components/admin/navbar.jsp"/>


    <div class=" w-full min-h-[70vh] flex justify-center items-center">
            <div class=" w-[60%] min-h-[35vh] bg-white shadow-lg p-10 rounded-md">
              <form action="/webproject/createcourse" method="post" class=" space-y-4">
                <div class=" space-y-3 flex flex-col">
                  <label
                    htmlFor=""
                    class=" text-lg font-semibold text-gray-500"
                  >
                    Course Code
                  </label>
                  <input
                    type="text"
                    name="courseCode"
                    id=""
                    placeholder="Enter Course Code"
                    class=" border border-[2px] border-green-500 w-[95%] pl-2 h-[5vh] rounded-md placeholder:italic placeholder:text-slate-400 outline-none focus:outline-none focus:border-green-600 focus:ring-1 focus:ring-green-500 "
                  />
                </div>
                <div class="space-y-3 flex flex-col">
                  <label htmlFor="" class="text-lg font-semibold text-gray-500">Course Name</label>
                  <input
                    type="text"
                    name="courseName"
                    id=""
                    placeholder="Enter Course Name"
                    class=" border border-[2px] border-green-500 w-[95%] pl-2 h-[5vh] rounded-md placeholder:italic placeholder:text-slate-400 outline-none focus:outline-none focus:border-green-600 focus:ring-1 focus:ring-green-500 "
                  />
                </div>
                <div class=" space-y-3 flex flex-col">
                  <label htmlFor="" class="text-lg font-semibold text-gray-500">Assign Teacher</label>
                  <select name="courseTeacher" class=" border border-[2px] border-green-500 w-[95%] pl-2 h-[5vh] rounded-md placeholder:italic placeholder:text-slate-400 outline-none focus:outline-none focus:border-green-600 focus:ring-1 focus:ring-green-500 ">
                    <option value="" disabled selected >
                      --Select Teacher---
                    </option>
                    <% for (User teacher : (List<User>) request.getAttribute("teacher")) { %>
                    <option value="<%=teacher.getId()%>"><%=teacher.getName()%></option>
                    <% } %>
                  </select>
                </div>
                <div class=" pl-[40%] pt-5">
                  <button
                    type="submit"
                    class="border outline-none rounded-md  w-[10rem] h-[3rem] bg-red-600 text-white text-xl font-medium hover:bg-[#333333]"
                  >
                    Create Course
                  </button>
                </div>
              </form>
            </div>
          </div>


</body>
</html>