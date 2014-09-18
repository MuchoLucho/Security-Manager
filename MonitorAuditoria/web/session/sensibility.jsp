<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>NARF Privacy Manager</title>
        <link href="../css/bootstrap.css" rel="stylesheet" />
        <link href="../css/font-awesome.css" rel="stylesheet" />
        <link href="../css/custom.css" rel="stylesheet" />
        <link rel="icon" type="image/png" href="../img/icon.png"/>
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="lastEvents.jsp"> <i class="fa fa-umbrella"></i> NARF Suite</a> 
                </div>
                <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;">
                    <a href="#" class="btn btn-danger square-btn-adjust">Logout &nbsp; <i class="fa fa-sign-out"></i></a>
                </div>
            </nav><!-- /. NAV TOP -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="../img/logo.png" class="user-image img-responsive hidden-xs" alt=""/>
                        </li>
                        <li>
                            <a href="lastEvents.jsp"><i class="fa fa-calendar fa-2x"></i>Last Events</a>
                        </li>
                        <li>
                            <a class="active-menu" href="sensibility.jsp"><i class="fa fa-warning fa-2x"></i> Information Sensibility </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-2x"></i> Roles <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="rolesView.jsp">Roles Viewer</a>
                                </li>
                                <li>
                                    <a href="rolesMan.jsp">Roles Manager</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user fa-2x"></i> Users<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="usersView.jsp">Users Viewer</a>
                                </li>
                                <li>
                                    <a href="usersMan.jsp">Users Manager</a>
                                </li>
                            </ul>
                        </li> 
                        <li>
                            <a href="log.jsp"><i class="fa fa-calendar fa-2x"></i> Manager's Log </a>
                        </li>
                        <li>
                            <a href="settings.jsp"><i class="fa fa-cogs fa-2x"></i> Settings </a>
                        </li>
                        <li>
                            <a href="licenses.jsp"><i class="fa fa-flag fa-2x"></i> Licenses </a>
                        </li>
                    </ul>
                </div>
            </nav> 
            <!-- /. NAV SIDE -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Information Sensibility</h2>  
                        </div>
                    </div><!-- /. ROW -->
                    <hr/>
                </div><!-- /. PAGE INNER -->
            </div><!-- /. PAGE WRAPPER -->
        </div><!-- /. WRAPPER -->
        <script src="../js/jquery-1.10.2.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery.metisMenu.js"></script>
        <script src="../js/custom.js"></script>
    </body>
</html>
