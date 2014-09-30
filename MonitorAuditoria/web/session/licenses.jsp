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
                    <form method="post" action="Logout"><button type="submit" class="btn btn-danger square-btn-adjust">Logout &nbsp; <i class="fa fa-sign-out"></i></button></form>
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
                            <a href="log.jsp"><i class="fa fa-file-text fa-2x"></i> Manager's Log </a>
                        </li>
                        <li>
                            <a href="settings.jsp"><i class="fa fa-cogs fa-2x"></i> Settings </a>
                        </li>
                        <li>
                            <a class="active-menu" href="licenses.jsp"><i class="fa fa-flag fa-2x"></i> Licenses </a>
                        </li>
                    </ul>
                </div>
            </nav> 
            <!-- /. NAV SIDE -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Licenses</h2>  
                        </div>
                    </div><!-- /. ROW -->
                    <hr/>
                    <div class="row">
                        <div class="col-lg-8 col-md-8">
                            <h2>This Software is licensed by GPL 3.0 and Creative Commons 3.0</h2>
                            <p>The art used in this site is licensed by Creative Commons BY-SA</p>                            
                        </div>
                        <div class="col-lg-4 col-md-4">
                            <img style="width: 150px; margin: 5px" src="../img/cc-by-sa.png" alt="" class="hidden-xs"/>
                            <img style="width: 150px; margin: 5px" src="../img/gpl.png" alt="" class="hidden-xs"/>
                        </div>
                        <div class="col-lg-12 col-md-12">
                            <p>
                                NARF Security Manager for Oracle Database
                                Copyright &COPY; 2014, NARF Inc., Some rights reserved
                                This program is free software: you can redistribute it and/or modify
                                it under the terms of the GNU General Public License as published by
                                the Free Software Foundation, either version 3 of the License, or
                                (at your option) any later version.
                                This program is distributed in the hope that it will be useful,
                                but WITHOUT ANY WARRANTY; without even the implied warranty of
                                MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
                                GNU General Public License for more details.
                                You should have received a copy of the GNU General Public License
                                along with this program.
                                If not, see <a href="http://www.gnu.org/licenses">http://www.gnu.org/licenses/</a>.
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h3>Bootstrap</h3>
                            <p>The MIT License (MIT)
                                <br/>
                                Copyright (c) 2011-2014 Twitter, Inc
                                <br/>
                                Permission is hereby granted, free of charge, to any person obtaining a copy
                                of this software and associated documentation files (the "Software"), to deal
                                in the Software without restriction, including without limitation the rights
                                to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
                                copies of the Software, and to permit persons to whom the Software is
                                furnished to do so, subject to the following conditions:
                                <br/>
                                The above copyright notice and this permission notice shall be included in
                                all copies or substantial portions of the Software.
                                <br/>
                                THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
                                IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
                                FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
                                AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
                                LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
                                OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
                                THE SOFTWARE.
                            </p>
                            <h5><a href="http://getbootstrap.com/">Oficial Site</a></h5>
                        </div>                         
                        <div class="col-md-6">
                            <h3>jQuery</h3>
                            <p>
                                Licencia MIT/GPL
                                <br/>
                                The MIT License is a free software license originating at the Massachusetts Institute of Technology (MIT).
                                It is a permissive free software license, meaning that it permits reuse within proprietary software provided 
                                all copies of the licensed software include a copy of the MIT License terms and the copyright notice. 
                                Such proprietary software retains its proprietary nature even though it incorporates software under the MIT 
                                License. The license is also GPL-compatible, meaning that the GPL permits combination and redistribution with
                                software that uses the MIT License.
                                <br/>
                                Notable software packages that use one of the versions of the MIT License include Expat, the Mono development 
                                platform class libraries, Ruby on Rails, Nodejs, Lua (from version 5.0 onwards), Wayland and the X Window 
                                System, for which the license was written.
                                <br/>
                                The GNU General Public License (GNU GPL or GPL) is the most widely used free software 
                                license, which guarantees end users (individuals, organizations, companies) the 
                                freedoms to use, study, share (copy), and modify the software. Software that allows 
                                these rights is called free software and, if the software is copylefted, then it also 
                                requires that this be retained. The GPL demands both. The license was originally 
                                written by Richard Stallman of the Free Software Foundation (FSF) for the GNU project.
                                <br/>
                                In other words, the GPL grants the recipients of a computer program the rights of the 
                                Free Software Definition[6] and uses copyleft to ensure the freedoms are preserved 
                                whenever the work is distributed, even when the work is changed or added to. The GPL 
                                is a copyleft license, which means that derived works can only be distributed under 
                                the same license terms. This is in distinction to permissive free software licenses, 
                                of which the BSD licenses and the MIT License are the standard examples. GPL was the 
                                first copyleft license for general use.
                            </p>
                            <h5><a href="http://www.jquery.com">Official Site</a></h5>
                        </div>
                    </div>
                </div><!-- /. PAGE INNER -->
            </div><!-- /. PAGE WRAPPER -->
        </div><!-- /. WRAPPER -->
        <script src="../js/jquery-1.10.2.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery.metisMenu.js"></script>
        <script src="../js/custom.js"></script>
    </body>
</html>
