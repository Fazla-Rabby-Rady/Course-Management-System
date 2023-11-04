<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/svg+xml" href="images/main_logo.svg" />
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>User JoinClass</title>

</head>
<body>

    <jsp:include page="/components/user/navbar.jsp"/>





     <div class="h-[20vh] flex justify-center items-center pt-[15rem] mb-[15rem]">
             <div class=" flex flex-col justify-center p-8  w-[40%] min-h-[25vh] shadow-2xl rounded-xl ">
             <form action="/webproject/joinclass" method="post">
               <div class=" space-y-7">
                 <h1 class=" text-2xl font-medium text-gray-600">Course Code</h1>
                 <p class=" text-lg font-normal text-gray-500">
                   Ask your teacher for the course code,then enter it here.
                 </p>

                     <input
                       type="text"
                       name="courseCode"
                       id=""
                       placeholder="Course Code"
                       class=" border border-[2px] border-green-500 w-[40%] pl-2 h-[5vh] rounded-md placeholder:italic placeholder:text-slate-400 outline-none focus:outline-none focus:border-green-600 focus:ring-1 focus:ring-green-500 "
                     />


               </div>

               <div class=" pl-[30%] pt-14">
                 <button
                   type="submit"
                   class="border outline-none rounded-md  w-[10rem] h-[3rem] bg-red-500 text-white text-xl font-medium hover:bg-[#333333]"
                 >
                   Join
                 </button>
               </div>
               </form>
             </div>
           </div>







</body>
</html>