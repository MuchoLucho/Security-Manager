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
                            <a href="lastEvents.jsp"><i class="fa fa-calendar  fa-2x"></i>Last Events</a>
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
                            <a class="active-menu" href="log.jsp"><i class="fa fa-file-text fa-2x"></i> Manager's Log </a>
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
                            <h2>Manager's Log</h2>  
                        </div>
                    </div><!-- /. ROW -->
                    <hr/>
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Last actions made by the software
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTable">
                                            <thead>
                                                <tr>
                                                    <th>Event</th>
                                                </tr>
                                            </thead>
                                            <tbody id="tLogs"></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!--End Advanced Tables -->
                        </div>
                    </div><!-- /. ROW  -->
                </div><!-- /. PAGE INNER -->
            </div><!-- /. PAGE WRAPPER -->
        </div><!-- /. WRAPPER -->
        <script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/jquery.metisMenu.js"></script>
        <script type="text/javascript" src="../js/custom.js"></script>
        <script type="text/javascript" src="../js/dataTables/jquery.dataTables.js"></script>
        <script type="text/javascript" src="../js/dataTables/dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="../js/log.js"></script>
    </body>
</html>
