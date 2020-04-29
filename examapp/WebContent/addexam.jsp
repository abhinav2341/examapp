<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>test page dash</title>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Map"%>
  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
  
 

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="./Admin_page.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">EXAM app</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="Scheduleexam">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Schedule exam</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Exam
      </div>
      
      <li class="nav-item">
        <a class="nav-link" href="viewexam">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>View Scheduled exams</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="./addsection.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Add sections</span></a>
      </li>
      

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Question paper</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Question:</h6>
            <a class="collapse-item" href="Addquestion1">ADD</a>
            <a class="collapse-item" href="Viewquestions">View</a>
          </div>
        </div>
      </li>      
    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form  id="addExamForm" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            
            
            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">SCHEDULE EXAM</h1>
          <%-- <div id="result" class="mb-4" style="color: red;">
          	<%
			if(request.getAttribute("result") !=null) {
				String Message=(String) request.getAttribute("result");
				out.println(Message);
			}
			%>
          </div> --%>

          <!-- Content Row -->
          <div class="row">

            <div class="col-xl-8 col-lg-7">

              <!-- Area Chart -->
              <div class="card shadow mb-4">
                <div class="card-header py-3" style="background:#4e73df;color:white"></div>
                <div class="card-body">
              <form  action="Addexam" class="form-horizontal addExamForm">
              <fieldset>
                <!-- Form Name -->
                
                <div class="form-group">
                  <label class="col-md-4 control-label" for="exam ">exam name</label>  
                  <div class="col-md-10">
                  <input id="exam" name="exam" type="text" placeholder="add exam" class="form-control form-control-lg input-md" required>
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-md-4 control-label" for="datetime">Start Date</label>  
                  <div class="col-md-6">                    
                  <input type="date"  name="startDate" min="<%= request.getAttribute("currentDate") %>" class="form-control form-control-lg" id="datetime" style="width: 100%;"  name="appt"  required>  
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-4 control-label" for="duration ">Duration</label>
                  <div class="col-md-10">
                  <input id="duration" name="duration" type="number" min="1" placeholder="add time in minutes" class="form-control form-control-lg input-md" required>
                  </div>
                </div>
                
	            <div class="form-group">
	                  <label class="col-md-4 control-label" for="selectdifficulty">Difficulty</label>
	                  <div class="col-md-10">
	                    <select id="selectdifficulty" name="selectdifficulty" class="form-control form-control-lg">
	                      <option value="0" selected="true">Select difficulty</option>
	                      <option value="1">Basic</option>
	                      <option value="2">Intermediate</option>
	                      <option value="3">Advance</option>
	                    </select>
	                  </div>
	             </div>
                <div class="form-group">
                  <!-- <label class="col-md-4 control-label" for="section ">Number of section</label>
                  <div class="col-md-10">
                  <input id="section" name="section" type="number" min=1 class="form-control form-control-lg input-md" required>
                  </div>
                  <p class="col-md-4" id="err" style="color:red"></p>
                </div> -->
                <div id="extdiv">
                <div class="section_div">
	                <div class="form-group">
	                  <label class="col-md-4 control-label" for="selectsection1">Section</label>
	                  <div class="col-md-10">
	                    <select id="selectsection1" name="selectsection1" class="form-control form-control-lg">
	                      	 <option value="0" selected="true">Select section</option>
		                      <%
						 Map<Integer, List<String>> userMap1 = request.getAttribute("SectionList") != null ? (Map<Integer, List<String>>)request.getAttribute("SectionList") : null;
						%> 
						<%  if(userMap1 != null) {
						  	 for(Map.Entry<Integer, List<String>> entry : userMap1.entrySet()) {
						  		int i=1;
						  		 for(String data : entry.getValue()) {
							 %>
							 
							 <option id="<%=i %>" value="<%= entry.getKey()%>"> <%=data%> </option>
						<% i++;}
						 }
						} %>
						
		                      
	                      <!-- <option value="0" selected="true">Select section</option>
	                      <option value="1">java</option>
	                      <option value="2">OS</option> -->
	                    </select>
	                  </div>
	                </div>
	                <div class="form-group">
	                  <label class="col-md-4 control-label" for="Question_per_section1">No. of Question</label>
	                  <div class="col-md-10">
	                    <input id="Question_per_section" name="Question_per_section1" type="number" min="1" class="form-control form-control-lg input-md" required>
	                  </div>
	                </div>
               </div>
               </div>
                <div class="form-group">
                  <div class="col-md-4"></div>
                  <div class="col-md-4">
                    <button class="btn-sm btn-primary addsection" type="button">Add section</button>
                    <input id="remove_section1" class="btn-sm btn-primary removesection" type="button" value="remove section">
                  </div>
                  <div id="msg" class="col-md-4"></div>
                 </div>
                
                <!-- Textarea -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="description">description</label>
                  <div class="col-md-10">                     
                    <textarea class="form-control form-control-lg " id="description" placeholder="add notes /instruction for candidates" name="description"></textarea>
                  </div>
                </div>
                <!-- code to select candidates -->
                <div class="form-group">
                	<label class="col-md-4 control-label" for="description">Select Candidates</label>
					<div class="col-md-12  table-responsive">
						<table class="table table-bordered">
					<!--     table to select candidate
					 -->
					 <thead>
					 	<tr>
						 <th>Candidate firstName</th>
						 <th>Candidate lastName</th>
						 <th>Mobile No.</th>
						 <th>Email</th>
						 <th>Select candidates</th>
						  </tr>	
					 </thead>
					
					<tfoot>
					 	<tr>
						 <th>Candidate firstName</th>
						 <th>Candidate lastName</th>
						 <th>Mobile No.</th>
						 <th>Email</th>
						 <th>Select candidates</th>
						  </tr>	
					 </tfoot>				  
					 <%
					 Map<Integer, List<String>> userMap = request.getAttribute("userMap") != null ? (Map<Integer, List<String>>)request.getAttribute("userMap") : null;
					 
					 if(userMap != null) {
					 for(Map.Entry<Integer, List<String>> entry : userMap.entrySet()) {
					 %>
					 
					 <tr>
					 <% 
					 for(String data : entry.getValue()) {
					 %>	
					 
					 <td>
					 <%=data%>
					 </td>
					 
					 <%	}
					 %>
					       
					      <td> <input type="checkbox" name="candidate_id" value="<%=entry.getKey()%>" /></td>
					       
					         
					         </tr>	
					       
					 <%	}
					 %>
					 
					 <%} 
					 else {
					 %> 
					 <tr><td colspan="8">No record found....</td></tr>	
					
					<%  
					}          
					  %>
					</table>
					
					</div>      
				</div>             
				
				<!-- code ends -->
                
                <div class="form-group">
                  <div class="col-md-4">&nbsp;</div>
                  <div class="col-md-4">
                    <button class="btn-lg btn-primary" id="submit" type="submit" value="submit">submit</button>
                    <button type="reset" class="btn-lg btn-primary" value="reset">reset</button> 
                  </div>
                </div>
              </fieldset>
            </form>


                  <!-- <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
                  </div> -
                  <hr>
                  Styling for the area chart can be found in the <code>/js/demo/chart-area-demo.js</code> file. -->
                </div>
              </div>


            </div>

            <!-- Donut Chart -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3" style="background:#4e73df;color:white">
                  <h6 class="m-0 font-weight-bold">Upcoming Exams</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <ul>
                    <li>OS</li>
                    <li>DSA</li>
                    <li>DISCRETE MATH</li>
                    <li>java</li>
                  </ul>
                  
                  
                </div>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="./">Logout</a>
        </div>
        
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb-admin-2.min.js"></script>
   <script type="text/javascript">
  	$(function(){
  		var count=1;//div counter
		$(".addsection").click(function()
		{	
			var value=[]; 
  		  	var text=[];
  		  	console.log("count:"+count);
  		  	
			$("#selectsection1 option").each(function()
					
					{
					    // Add $(this).val() to your list
					    console.log("val:-"+$(this).val());
					    value.push($(this).val());
					    text.push($(this).text());
					});
			console.log("value:"+value);
			console.log("text:"+text);
			var section2="<option value='0' selected='true'>Select section</option>";
			var newsection="",section1="",section3="";
			count=count+1;
  			$("#extdiv").append("<div class=\"newsection_div"+count+"\"></div>"); //appending new div for further addition
			section1="<div class='form-group'><label class='col-md-4 control-label' for='selectsection"+count+"'>Section</label><div class='col-md-10'><select id='selectsection"+count+"' name='selectsection"+count+"' class='form-control form-control-lg' required>";
			var length=value.length;
			for(var j=1;j<length;j++){
				console.log("VALUE:"+value[j]+"TEXT:"+text[j]);
				section2=section2+"<option value='"+value[j]+"'>"+text[j]+"</option>";
			}
			section3="</select></div></div><div class='form-group'><label class='col-md-4 control-label' for='Question_per_section"+count+"'>No. of Question</label><div class='col-md-10'><input id='Question_per_section"+count+"' name='Question_per_section"+count+"' type='number' min='1' class='form-control form-control-lg input-md' required></div></div>";
			newsection=section1+section2+section3;
			section1="";
			section2="";
			section3="";
			console.log(newsection);
				$(".newsection_div"+count).html(newsection); //adding html to div
			});
			$("#remove_section1").click(function()
				{	
					$(".newsection_div"+count).remove();
					count=count-1;
	  			});
			$(".addExamForm").submit(function(event){
				//event.preventDefault();
				var valid=true;
				console.log("submit prevented");
				console.log("Count"+count);
				var sections = [];
				for (var k = 0; k < count; k++) {
					//console.log('#selectsection'+k+' option:selected');	
					var sec_1=$('#selectsection'+(k+1)+' option:selected').text();
					sections.push(sec_1);
				}
				console.log(sections);
				console.log("before loop valid: "+valid);
				for (var k = 0; k < (sections.length-1); k++) {
					for (var i = k+1 ; i < sections.length; i++) {
						if(sections[k]===sections[i])
							{
								valid=false;
							}
						/* else
							{
								console.log("section ok");
								valid=true;
							} */
					}
					if(!(valid)){
						break;
					}
				}
				console.log("after loop valid: "+valid);
				if(!(valid))
					{
						event.preventDefault();
						//console.log("section same");
						alert("sections cannot be same");
					}
				else{
						console.log("sections ok");
				}
				/*for (var i = 1; i < count; i++) {
					console.log('#selectsection'+i+' option:selected');	
					var sec1=$('#selectsection'+i+' option:selected').text();
					sections.push(sec1);
					console.log("outerSec"+i+": "+sec1);
					for(var j=i+1;j<=count;j++)
						{
						console.log('#selectsection'+j+' option:selected');	
						var sec2=$('#selectsection'+j+' option:selected').text();
							console.log("innerSec"+j+": "+sec2)
							if(sec1==sec2)
								{
								valid=false;
								break;
								}
							else{
								valid=true;
								//event.currentTarget.submit();
							}
						if(!(valid))
							{	
								console.log(valid);
								break;
							}
						else{
							console.log(valid);
							$('#msg').focus();
							$('#msg').html("sections cannot be same");
						}
						}
				}*/
				
		    });
			
		});
	</script>	
	
</body>
</html>