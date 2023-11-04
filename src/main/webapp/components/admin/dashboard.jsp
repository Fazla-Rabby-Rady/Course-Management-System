 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@page import="cse.web.model.Course"%>
 <%@page import="cse.web.model.User"%>
 <%@page import="java.util.List" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="icon" type="image/svg+xml" href="images/main_logo.svg" />
 <script src="https://cdn.tailwindcss.com"></script>
 <title>Home</title>

 </head>
 <body>

    <jsp:include page="/components/admin/navbar.jsp"/>

    <div class="w-full min-h-[100vh]">

        <div class=" w-full min-h-[20vh] pt-[5rem] flex justify-center  space-x-10 pt-14">
             <div class="w-[25rem] h-[10rem] bg-white shadow-lg rounded-md p-5  flex items-center">
                  <div class=" w-[70%] space-y-5">
                       <h4 class="text-xl font-medium">Total Student</h4>
                       <h2 class="text-5xl font-medium"><%= request.getAttribute("totalStudent")%></h2>
                      </div>
                       <div class="w-[30%]">
                         <img src="images/knowledge.svg" alt="" class=" w-[80%]" />
                       </div>
                 </div>
                    <div class="w-[25rem] h-[10rem] bg-white shadow-lg rounded-md p-5 flex items-center">
                      <div class="w-[70%] space-y-5">
                        <h4 class="text-xl font-medium">Total Teacher</h4>
                        <h2 class="text-5xl font-medium"><%= request.getAttribute("totalTeacher")%></h2>
                      </div>
                      <div class="w-[30%]">
                        <img src="images/book.svg" alt="" class="w-[80%]" />
                      </div>
                    </div>
                    <div class="w-[25rem] h-[10rem] bg-white shadow-lg rounded-md p-5 flex items-center">
                      <div class="w-[70%] space-y-5">
                        <h4 class="text-xl font-medium">Total Courses</h4>
                        <h2 class="text-5xl font-medium"><%= request.getAttribute("totalCourse")%></h2>
                      </div>
                      <div class="w-[30%]">
                        <img src="images/tropy.svg" alt="" class="w-[80%]" />
                      </div>
                    </div>
                  </div>




                  <div class=" w-full h-[20vh] pt-[8rem]">
                        <nav class=" w-full">
                             <ul class="w-full flex justify-center items-center">
                                 <li class=" text-xl font-medium space-x-16">
                                     <a
                                       href="/webproject/studentlist"
                                       class="bg-red-500 text-white p-5 rounded-md hover:bg-[#333333] hover:text-white hover:ring-0"
                                     >
                                        Student List
                                     </a>
                                          <a
                                            href="/webproject/teacherlist"
                                            class="bg-red-500 text-white p-5 rounded-md hover:bg-[#333333] hover:text-white hover:ring-0"
                                          >
                                            Teacher List
                                          </a>
                                          <a
                                            href="/webproject/courselist"
                                            class="bg-red-500 text-white p-5 rounded-md hover:bg-[#333333] hover:text-white hover:ring-0"
                                          >
                                            Course List
                                          </a>
                                          <a
                                            href="/webproject/createcourse"
                                            class="bg-red-500 text-white p-5 rounded-md hover:bg-[#333333] hover:text-white hover:ring-0"
                                          >
                                            Create New Course
                                          </a>
                                        </li>
                                      </ul>
                                    </nav>
                                  </div>





            <div class=" w-full pt-[8rem]">
                    <h1 class="  text-3xl font-semibold pl-[47rem] text-red-400">New Courses</h1>
                    <div class=" w-full min-h-[25vh] flex justify-center items-center pt-3">
                      <table class=" w-[80%]  border">
                        <tr class=" border bg-[#FFECEC] h-[5vh] text-xl font-semibold text-slate-700 ">
                          <th>Course ID</th>
                          <th>Course Name</th>
                          <th>Assigned Teacher</th>
                        </tr>
                        <% int cnt=0; %>
                        <% for (Course course: (List<Course>) request.getAttribute("courses") ) { %>

                             <tr class=" border  text-center h-[6vh] text-lg font-medium shadow-md text-gray-600">
                                  <td><%= course.getCourseCode()%></td>
                                  <td><%= course.getCourseName()%></td>
                                  <td><%= course.getCourseTeacher()%></td>
                              </tr>

                            <% cnt++; if(cnt==2){ break;} %>
                        <% } %>

                      </table>
                    </div>
                  </div>

                  <div class=" w-full mt-[5rem]">
                    <h1 class="  text-3xl font-semibold pl-[47rem] text-red-400">New Students</h1>
                    <div class=" w-full min-h-[25vh] flex justify-center items-center pt-3 ">
                      <table class=" w-[80%]  border">
                        <tr class=" border bg-[#FFECEC] h-[5vh] text-xl font-semibold text-slate-700 ">
                          <th>Name</th>
                          <th>Registration No</th>
                          <th>Department</th>
                        </tr>
                        <% cnt=0; %>
                        <% for (User user: (List<User>) request.getAttribute("students") ) { %>

                             <tr class=" border  text-center h-[6vh] text-lg font-medium shadow-md text-gray-600">
                                  <td><%= user.getName()%></td>
                                  <td><%= user.getReg()%></td>
                                  <td><%= user.getDept()%></td>
                              </tr>

                            <% cnt++; if(cnt==2){ break;} %>
                        <% } %>
                      </table>
                    </div>
                  </div>

                  <div class=" w-full mt-[5rem] mb-[10rem]">
                    <h1 class="  text-3xl font-semibold pl-[47rem] text-red-400">New Teachers</h1>
                    <div class=" w-full min-h-[25vh] flex justify-center items-center pt-3">
                      <table class=" w-[80%]  border">
                        <tr class=" border bg-[#FFECEC] h-[5vh] text-xl font-semibold text-slate-700 ">
                          <th>Name</th>
                          <th>Email</th>
                          <th>Department</th>
                        </tr>
                        <% cnt=0; %>
                        <% for (User user: (List<User>) request.getAttribute("teachers") ) { %>

                             <tr class=" border  text-center h-[6vh] text-lg font-medium shadow-md text-gray-600">
                                  <td><%= user.getName()%></td>
                                  <td><%= user.getEmail()%></td>
                                  <td><%= user.getDept()%></td>
                              </tr>

                            <% cnt++; if(cnt==2){ break;} %>
                        <% } %>
                      </table>
                    </div>
                  </div>

    </div>

 </body>
 </html>





