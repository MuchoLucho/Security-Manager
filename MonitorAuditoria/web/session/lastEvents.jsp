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
        <link href="../js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
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
                            <a class="active-menu" href="lastEvents.jsp"><i class="fa fa-calendar fa-2x"></i>Last Events</a>
                        </li>
                        <li>
                            <a href="sensibility.jsp"><i class="fa fa-warning fa-2x"></i> Information Sensibility </a>
                        </li>
                        <li>
                            <a href="roles.jsp"><i class="fa fa-users fa-2x"></i> Roles</a>                            
                        </li>
                        <li>
                            <a href="users.jsp"><i class="fa fa-user fa-2x"></i> Users</a>                            
                        </li> 
                        <li>
                            <a href="log.jsp"><i class="fa fa-file-text fa-2x"></i> Manager's Log </a>
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
                            <h2>Last Events</h2>  
                        </div>
                    </div><!-- /. ROW --
                    <hr/>
                    <p>If you do not see any row make sure Audit Mode is On in the <strong>Settings</strong> (<i class="fa fa-cogs"></i>) Tab.
                        If it is on and you do not see any change could be there is not activity in the database</p>
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Last actions made by the software
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="events">
                                            <thead>
                                                <tr>
                                                    <th>User</th>
                                                    <th>Action</th>
                                                    <th>Statement</th>
                                                    <th>Date & Hour</th>
                                                    <th>Condition</th>                                                    
                                                </tr>
                                            </thead>
                                            <tbody id="tEvents"></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!--End Advanced Tables -->
                        </div>
                    </div><!-- /. PAGE INNER -->
                </div><!-- /. PAGE WRAPPER -->
            </div><!-- /. WRAPPER -->
            <script src="../js/jquery-1.10.2.js"></script>
            <script src="../js/bootstrap.min.js"></script>
            <script src="../js/jquery.metisMenu.js"></script>
            <script src="../js/dataTables/jquery.dataTables.js"></script>
            <script src="../js/dataTables/dataTables.bootstrap.js"></script>
            <script src="../js/custom.js"></script>
            <script src="../js/lastEvents.js"></script>
    </body>
</html>
