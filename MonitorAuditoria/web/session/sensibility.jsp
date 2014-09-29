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
                    <a href="Logout" class="btn btn-danger square-btn-adjust">Logout &nbsp; <i class="fa fa-sign-out"></i></a>
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
                            <a class="active-menu" href="sensibility.jsp"><i class="fa fa-warning fa-2x"></i> Information Sensibility </a>
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
                            <h2>Information Sensibility</h2>  
                        </div>
                    </div><!-- /. ROW -->
                    <hr/>
                    <div class="row" id="select"><!--FIRST ONE-->
                        <p>Select a level to modify (<i class="fa fa-cog"></i>) or delete (<i class="fa fa-times"></i>) or Create a new one (<i class="fa fa-plus"></i>)</p><br/>
                        <button type="button" id="plus" class="btn btn-success" title="New Level"><i class="fa fa-plus">&nbsp;New Security Level</i></button>
                        <br/><br/>
                        <div id="sens_select">
                            <div class="panel panel-default">
                                <div class="panel-heading">Select a Security Level to Modify</div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="selected">
                                            <thead>
                                                <tr>
                                                    <th>Security Level</th>
                                                    <th>Options</th>
                                                </tr>
                                            </thead>
                                            <tbody id="contenido_sens"></tbody>                                            
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form action="SensibilityService" method="POST">
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel"><i class="fa fa-exclamation-triangle fa-2x"></i> &nbsp; Are you sure?</h4>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure to delete the sensibility level: <span id="name2"></span>? Make sure you have no roles related to it.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                                            <button id="deleteBtn" type="submit" name="delete" value="" class="btn btn-danger">For Sure</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form><br/> 
                    </div>
                    <div class="row" id="create" style="display: none"><!--SECOND ONE-->
                        <p>Creating a new sensibility template just adds a container for its configurations to the level's list.
                            After the creation you must select it and modifiy (<i class="fa fa-cog"></i>) its parameters in order to use it.</p>
                        <form action="SensibilityService" method="POST">
                            <h4>Name / Description</h4>
                            <input type="text" class="form-control" name="name" autocomplete="off"/>
                            <div class="form-group form-inline" style="padding-top: 15px">  
                                <button class='btn btn-primary btn-lg btn-success' type='submit' name="new">Create</button>
                                <button class='btn btn-primary btn-lg btn-danger' type="reset" id="cancelCreate">Cancel</button>
                            </div>
                        </form>
                    </div>
                    <div class="row" id="modify" style="display: none">
                        <div style="margin: auto; width: 400px"><!--THIRD ONE-->
                            <input id="data" name="data" type="radio" name="type" value="1" checked="checked"/>&nbsp; <label for="data">Data from tables &nbsp;</label>
                            <input id="proc" name="data" type="radio" name="type" value="2"/>&nbsp; <label for="proc">Procedures and Functions &nbsp;</label>
                        </div><br/>                        
                        <div id="dtablas">
                            <div class="panel panel-default">
                                <div class="panel-heading">Selected level: <span id="name1"></span></div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="tablas">
                                            <thead>
                                                <tr>
                                                    <th>Table Name</th>    
                                                    <th>Tablespace</th>
                                                    <th>Select</th>
                                                    <th>Insert</th>
                                                    <th>Delete</th>
                                                    <th>Update</th>
                                                    <th>Columns</th>
                                                </tr>
                                            </thead>
                                            <tbody id="contenido_tablas"></tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div id="divCol" class="panel panel-default" style="display: none">
                                <div class="panel-heading">Column selected: <span id="colSel"></span></div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="columnas">
                                            <thead>
                                                <tr>
                                                    <th>Table Name</th>
                                                    <th>Column Name</th>                                                    
                                                    <th>Update</th>
                                                </tr>
                                            </thead>
                                            <tbody id="contenido_columnas"></tbody>                                            
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="drsrc" style="display: none">
                            <div class="panel panel-default">
                                <div class="panel-heading">Procedures and Functions</div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="rsrc">
                                            <thead>
                                                <tr>
                                                    <th>Resource</th>
                                                    <th>Type</th>                                                    
                                                    <th>Enabled</th>
                                                </tr>
                                            </thead>
                                            <tbody id="contenido_rsrc"></tbody>                                            
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class='form-group'>
                            <button class='btn btn-primary btn-lg btn-success' type='button' name="changes" id="changes">Apply Changes</button>
                            <button class='btn btn-primary btn-lg btn-danger' type="button" id="cancelMod">Cancel</button>
                        </div><br/>
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
        <script src="../js/sensibility.js"></script>
    </body>
</html>