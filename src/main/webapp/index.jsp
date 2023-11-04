<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/svg+xml" href="images/main_logo.svg" />
<script src="https://cdn.tailwindcss.com"></script>
<title>Cursus</title>

</head>
<body>



<jsp:include page="/components/Navbar.jsp"/>


<div class=" w-full h-[80vh] mt-[5rem]">
        <div class=" flex justify-center items-center space-x-5">
          <div class=" w-[40%] min-h-[40vh] pl-[10rem] space-y-8">
            <h1 class=" text-5xl font-bold text-red-600 ">
              Online Courses
            </h1>
            <p class=" text-xl font-medium text-justify text-gray-500">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum,
              deleniti odit accusantium soluta obcaecati molestiae iste laborum
              quo quas voluptatibus, velit debitis quam saepe facilis aperiam.
              Explicabo provident nulla et rem laudantium velit aliquid magnam
              recusandae? Reprehenderit architecto vitae, quibusdam delectus
              corporis totam ullam accusamus, aperiam molestiae iure dolore
              atque.
            </p>
            <div class=" pl-[30%] pt-5 ">
           <%-- <button
                type="submit"
                class="border outline-none rounded-md  w-[10rem] h-[3rem] bg-red-600 text-white text-xl font-medium hover:bg-[#333333]"
              >
                Sign Up
              </button> --%>
               <a
                    href="/webproject/signup"
                    class=" p-4 pl-7 pr-7  outline-none rounded-md  w-[10rem] h-[3rem] bg-red-600 text-white text-xl font-medium hover:bg-[#333333]"
                >
                    Sign Up
               </a>
            </div>
          </div>
          <div class=" w-[60%] ">
            <img src="images/home.png" alt="" class=" w-[75%] pl-[5rem]" />
          </div>
        </div>
      </div>

</body>
</html>