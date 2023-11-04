            <nav class=" shadow-xl bg-white w-[100%] h-[69.1879px] flex  items-center">
                <ul class=" w-[100%]">
                  <li class=" flex  items-center w-[100%]">
                    <div class="w-[40%]">
                      <a
                        href="/webproject/user"
                        class=" flex justify-center items-center space-x-2"
                      >
                        <img src="images/main_logo.svg" alt="" class=" h-10" />
                        <h1 class=" text-3xl font-bold text-red-500">Cursus</h1>
                      </a>
                    </div>
                    <div class=" w-[60%] flex justify-center items-center space-x-8 text-xl font-medium">

                      <p class="text-[#EF4444] text-2xl font-bold"><%= (String) session.getAttribute("name") %></p>
                      <a href="/webproject/"
                            class=' h-[3.5rem] w-[8rem] flex justify-center items-center rounded-full outline-none hover:bg-red-500 hover:text-white'
                      >
                      Logout
                     </a>
                    </div>
                  </li>
                </ul>
              </nav>