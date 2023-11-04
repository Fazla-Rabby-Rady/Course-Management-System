 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
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

   <jsp:include page="/components/Navbar.jsp"/>

   <dir class=" w-full h-[80vh]">
           <div class=" flex flex-col justify-center items-center mt-[10vh] space-y-3">
             <h1 class=" text-3xl font-bold">Welcome to Back</h1>
             <h3 class=" text-lg font-medium text-gray-500">
               Log In Your Account!
             </h3>
           </div>
           <div class=" h-[70vh] flex justify-center items-center space-x-20">
             <div class="w-[30%] h-[50vh] p-5 pl-24">
               <form action="/webproject/login" method="post" class=" space-y-7">
                 <input
                   type="email"
                   placeholder="Email"
                   name="email"
                   id=""
                   class=" text-lg border border-[2px] border-green-500 w-[90%] pl-3 h-[6vh] rounded-md placeholder:italic placeholder:text-slate-400 outline-none focus:outline-none focus:border-green-600 focus:ring-1 focus:ring-green-500 "
                 />
                 <input
                   type="password"
                   placeholder="password"
                   name="password"
                   id=""
                   class=" text-lg border border-[2px] border-green-500 w-[90%] pl-2 h-[6vh] rounded-md placeholder:italic placeholder:text-slate-400 outline-none focus:outline-none focus:border-green-600 focus:ring-1 focus:ring-green-500 "
                 />
                 <div class=" pl-[30%] pt-5">
                   <button
                     type="submit"
                     class="border outline-none rounded-md  w-[10rem] h-[3rem] bg-red-600 text-white text-xl font-medium hover:bg-[#333333]"
                   >
                     Log in
                   </button>
                 </div>
               </form>
               <h5 class=" pt-12 text-center text-gray-500 text-lg">
                 Don't have an account ? <span></span>
                 <a
                   href="/webproject/signup"
                   class=" text-red-500 text-lg font-medium"
                 >
                   Sign Up
                 </a>
               </h5>
             </div>

             <div class=" w-[40%] h-[55vh] pl-36" >
               <img src="images/login.svg" alt="login" class=" w-[50%]" />
             </div>
           </div>
         </dir>

 </body>
 </html>





