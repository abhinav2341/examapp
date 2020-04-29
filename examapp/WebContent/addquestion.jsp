<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
	<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>test add question</title>

  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
  <style type="text/css">
  	.card-body
  	{
  		width:21rem;
  	}
  </style>
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
      
a
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
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
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
          <h1 class="h3 mb-2 text-gray-800">Set Question paper</h1>
          <div class="mb-4" style="color:red"><!-- Success message -->
          	<%
			if(request.getAttribute("result") !=null) {
				String Message=(String)request.getAttribute("result");
				out.println(Message);
			}
			%>
          </div>

          <!-- Content Row -->
          <div class="row">

            <div class="col-xl-8 col-lg-7">

              <!-- Area Chart -->
              <div class="card shadow mb-4">
              <div class="card-header py-3" style="background:#4e73df;color:white"></div>
              <div class="card-body">
              	<form id="addQuestionForm" action="Addquestion" method="post">
                
                <div class="form-group">
                  <label>Select Section</label>  
                  <div>
                  <select id="select_section" name="select_section" class="form-control">
                     <option value="0" selected="true">Select section</option>
		                <%
						 Map<Integer, List<String>> userMap1 = request.getAttribute("SectionList") != null ? (Map<Integer, List<String>>)request.getAttribute("SectionList") : null;
						%> 
						<%  if(userMap1 != null) {
						  	 for(Map.Entry<Integer, List<String>> entry : userMap1.entrySet()) {
							 for(String data : entry.getValue()) {%>
							 
							 <option value="<%= entry.getKey()%>"> <%=data%> </option>
						<% }
						 }
						} %>
                  </select>
                  </div>
                </div>            
              	
              	<div class="form-group">
	                  <label  for="selectdifficulty">Difficulty</label>
	                  <div>
	                    <select id="selectdifficulty" name="selectdifficulty" class="form-control form-control-lg">
	                      <option value="0" selected="true">Select difficulty</option>
	                      <option value="1">Basic</option>
	                      <option value="2">Intermediate</option>
	                      <option value="3">Advance</option>
	                    </select>
	                  </div>
	                </div>
              	
                <div class="form-group">
                <label>Question</label>  
                <textarea id="Question" name="Question_ip" rows="4" cols="50"></textarea>   
                </div>
                              
                <!-- Text input-->
                <div class="form-group">
                  <label>option 1</label>  
                  <textarea id="option 1"  name="option_ip1" rows="2" cols="50"></textarea>
                </div>
                
                <!-- Text input-->
                <div class="form-group">
                  <label>option 2</label>  
				<textarea id="option2" rows="2" name="option_ip2" cols="50"></textarea>
                </div>
                
                <!-- Text input-->
                <div class="form-group">
                  <label>option 3</label>  
                  <textarea id="option3" name="option_ip3" rows="2" cols="50"></textarea>
                </div>
                
                <div class="form-group">
                  <label>option 4</label>  
               	<textarea id="option4" name="option_ip4" rows="2" cols="50"></textarea>
                </div>
                
                <div class="form-group">
                  <label >correct option</label>
                  <div id="selectoption"> 
                     <label class="radio-inline checkbox-inline" for="radios-0">
                      <input type="radio" name="radios" id="radios-0" value="1" checked="checked">
                      1
                    </label> 
                    <label class="radio-inline checkbox-inline" for="radios-1">
                      <input type="radio" name="radios" id="radios-1" value="2">
                      2
                    </label> 
                    <label class="radio-inline checkbox-inline" for="radios-2">
                      <input type="radio" name="radios" id="radios-2" value="3">
                      3
                    </label> 
                    <label class="radio-inline checkbox-inline" for="radios-3">
                      <input type="radio" name="radios" id="radios-3" value="4">
                      4
                    </label> 
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="description">description</label>
                  <div >                     
                    <textarea id="description" rows="4" cols="50" placeholder="add instruction for candidates" name="description"></textarea>
                  </div>
                </div>
                
                <div class="form-group">
                  <button type="submit" class="btn-primary btn" value="submit">submit</button>
                  <button type="reset" class="btn-primary btn" value="reset">reset</button>
                </div>
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
	            <div class="row">
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
	            <div class="row">
					<div class="card shadow mb-4">
	                <!-- Card Header - Dropdown -->
	                <div class="card-header py-3" style="background:#4e73df;color:white">
	                  <h6 class="m-0 font-weight-bold">Questions</h6>
	                </div>
		            <div id="question_box" class="card-body">
		                  <ul>
		                    <li>Q1</li>
		                    <li>Q2</li>
		                    <li>Q3</li>
		                    <li>Q4</li>
		                  </ul>
		                </div>
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
  <!-- form logic js file -->
  <script type="text/javascript" src="resources/js/addquestion.js"></script>
</body>
</html>  
