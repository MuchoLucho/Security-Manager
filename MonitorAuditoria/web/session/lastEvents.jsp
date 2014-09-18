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
        <script type="text/javascript">
            window.onload = function () {
                var chart = new CanvasJS.Chart("chartContainer",
                        {
                            zoomEnabled: false,
                            title: {
                                text: "Mobile Phone Subscriptions"
                            },
                            axisY2: {
                                valueFormatString: "0.0 bn",
                                maximum: 1.2,
                                interval: .2,
                                interlacedColor: "#F5F5F5",
                                gridColor: "#D7D7D7",
                                tickColor: "#D7D7D7"
                            },
                            theme: "theme2",
                            toolTip: {
                                shared: true
                            },
                            legend: {
                                verticalAlign: "bottom",
                                horizontalAlign: "center",
                                fontSize: 15,
                                fontFamily: "Lucida Sans Unicode"

                            },
                            data: [
                                {
                                    type: "line",
                                    lineThickness: 3,
                                    axisYType: "secondary",
                                    showInLegend: true,
                                    name: "India",
                                    dataPoints: [
                                        {x: new Date(2001, 0), y: 0},
                                        {x: new Date(2002, 0), y: 0.001},
                                        {x: new Date(2003, 0), y: 0.01},
                                        {x: new Date(2004, 0), y: 0.05},
                                        {x: new Date(2005, 0), y: 0.1},
                                        {x: new Date(2006, 0), y: 0.15},
                                        {x: new Date(2007, 0), y: 0.22},
                                        {x: new Date(2008, 0), y: 0.38},
                                        {x: new Date(2009, 0), y: 0.56},
                                        {x: new Date(2010, 0), y: 0.77},
                                        {x: new Date(2011, 0), y: 0.91},
                                        {x: new Date(2012, 0), y: 0.94}
                                    ]
                                },
                                {
                                    type: "line",
                                    lineThickness: 3,
                                    showInLegend: true,
                                    name: "China",
                                    axisYType: "secondary",
                                    dataPoints: [
                                        {x: new Date(2001, 00), y: 0.18},
                                        {x: new Date(2002, 00), y: 0.2},
                                        {x: new Date(2003, 0), y: 0.25},
                                        {x: new Date(2004, 0), y: 0.35},
                                        {x: new Date(2005, 0), y: 0.42},
                                        {x: new Date(2006, 0), y: 0.5},
                                        {x: new Date(2007, 0), y: 0.58},
                                        {x: new Date(2008, 0), y: 0.67},
                                        {x: new Date(2009, 0), y: 0.78},
                                        {x: new Date(2010, 0), y: 0.88},
                                        {x: new Date(2011, 0), y: 0.98},
                                        {x: new Date(2012, 0), y: 1.04}
                                    ]
                                },
                                {
                                    type: "line",
                                    lineThickness: 3,
                                    showInLegend: true,
                                    name: "USA",
                                    axisYType: "secondary",
                                    dataPoints: [
                                        {x: new Date(2001, 00), y: 0.16},
                                        {x: new Date(2002, 0), y: 0.17},
                                        {x: new Date(2003, 0), y: 0.18},
                                        {x: new Date(2004, 0), y: 0.19},
                                        {x: new Date(2005, 0), y: 0.20},
                                        {x: new Date(2006, 0), y: 0.23},
                                        {x: new Date(2007, 0), y: 0.261},
                                        {x: new Date(2008, 0), y: 0.289},
                                        {x: new Date(2009, 0), y: 0.3},
                                        {x: new Date(2010, 0), y: 0.31},
                                        {x: new Date(2011, 0), y: 0.32},
                                        {x: new Date(2012, 0), y: 0.33}
                                    ]
                                }
                            ],
                            legend: {
                                cursor: "pointer",
                                itemclick: function (e) {
                                    if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                                        e.dataSeries.visible = false;
                                    }
                                    else {
                                        e.dataSeries.visible = true;
                                    }
                                    chart.render();
                                }
                            }
                        });

                chart.render();
            }
        </script>
        <script type="text/javascript" src="../js/canvasjs.min.js"></script>
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
                            <h2>Last Events</h2>  
                        </div>
                    </div><!-- /. ROW -->
                    <hr/>
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Advanced Tables
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>Rendering engine</th>
                                                    <th>Browser</th>
                                                    <th>Platform(s)</th>
                                                    <th>Engine version</th>
                                                    <th>CSS grade</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="odd gradeX">
                                                    <td>Trident</td>
                                                    <td>Internet Explorer 4.0</td>
                                                    <td>Win 95+</td>
                                                    <td class="center">4</td>
                                                    <td class="center">X</td>
                                                </tr>
                                                <tr class="even gradeC">
                                                    <td>Trident</td>
                                                    <td>Internet Explorer 5.0</td>
                                                    <td>Win 95+</td>
                                                    <td class="center">5</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="odd gradeA">
                                                    <td>Trident</td>
                                                    <td>Internet Explorer 5.5</td>
                                                    <td>Win 95+</td>
                                                    <td class="center">5.5</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="even gradeA">
                                                    <td>Trident</td>
                                                    <td>Internet Explorer 6</td>
                                                    <td>Win 98+</td>
                                                    <td class="center">6</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="odd gradeA">
                                                    <td>Trident</td>
                                                    <td>Internet Explorer 7</td>
                                                    <td>Win XP SP2+</td>
                                                    <td class="center">7</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="even gradeA">
                                                    <td>Trident</td>
                                                    <td>AOL browser (AOL desktop)</td>
                                                    <td>Win XP</td>
                                                    <td class="center">6</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Firefox 1.0</td>
                                                    <td>Win 98+ / OSX.2+</td>
                                                    <td class="center">1.7</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Firefox 1.5</td>
                                                    <td>Win 98+ / OSX.2+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Firefox 2.0</td>
                                                    <td>Win 98+ / OSX.2+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Firefox 3.0</td>
                                                    <td>Win 2k+ / OSX.3+</td>
                                                    <td class="center">1.9</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Camino 1.0</td>
                                                    <td>OSX.2+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Camino 1.5</td>
                                                    <td>OSX.3+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Netscape 7.2</td>
                                                    <td>Win 95+ / Mac OS 8.6-9.2</td>
                                                    <td class="center">1.7</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Netscape Browser 8</td>
                                                    <td>Win 98SE+</td>
                                                    <td class="center">1.7</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Netscape Navigator 9</td>
                                                    <td>Win 98+ / OSX.2+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.0</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.1</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1.1</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.2</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1.2</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.3</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1.3</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.4</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1.4</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.5</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1.5</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.6</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">1.6</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.7</td>
                                                    <td>Win 98+ / OSX.1+</td>
                                                    <td class="center">1.7</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Mozilla 1.8</td>
                                                    <td>Win 98+ / OSX.1+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Seamonkey 1.1</td>
                                                    <td>Win 98+ / OSX.2+</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Gecko</td>
                                                    <td>Epiphany 2.20</td>
                                                    <td>Gnome</td>
                                                    <td class="center">1.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>Safari 1.2</td>
                                                    <td>OSX.3</td>
                                                    <td class="center">125.5</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>Safari 1.3</td>
                                                    <td>OSX.3</td>
                                                    <td class="center">312.8</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>Safari 2.0</td>
                                                    <td>OSX.4+</td>
                                                    <td class="center">419.3</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>Safari 3.0</td>
                                                    <td>OSX.4+</td>
                                                    <td class="center">522.1</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>OmniWeb 5.5</td>
                                                    <td>OSX.4+</td>
                                                    <td class="center">420</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>iPod Touch / iPhone</td>
                                                    <td>iPod</td>
                                                    <td class="center">420.1</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Webkit</td>
                                                    <td>S60</td>
                                                    <td>S60</td>
                                                    <td class="center">413</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 7.0</td>
                                                    <td>Win 95+ / OSX.1+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 7.5</td>
                                                    <td>Win 95+ / OSX.2+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 8.0</td>
                                                    <td>Win 95+ / OSX.2+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 8.5</td>
                                                    <td>Win 95+ / OSX.2+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 9.0</td>
                                                    <td>Win 95+ / OSX.3+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 9.2</td>
                                                    <td>Win 88+ / OSX.3+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera 9.5</td>
                                                    <td>Win 88+ / OSX.3+</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Opera for Wii</td>
                                                    <td>Wii</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Nokia N800</td>
                                                    <td>N800</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Presto</td>
                                                    <td>Nintendo DS browser</td>
                                                    <td>Nintendo DS</td>
                                                    <td class="center">8.5</td>
                                                    <td class="center">C/A<sup>1</sup>
                                                    </td>
                                                </tr>
                                                <tr class="gradeC">
                                                    <td>KHTML</td>
                                                    <td>Konqureror 3.1</td>
                                                    <td>KDE 3.1</td>
                                                    <td class="center">3.1</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>KHTML</td>
                                                    <td>Konqureror 3.3</td>
                                                    <td>KDE 3.3</td>
                                                    <td class="center">3.3</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>KHTML</td>
                                                    <td>Konqureror 3.5</td>
                                                    <td>KDE 3.5</td>
                                                    <td class="center">3.5</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeX">
                                                    <td>Tasman</td>
                                                    <td>Internet Explorer 4.5</td>
                                                    <td>Mac OS 8-9</td>
                                                    <td class="center">-</td>
                                                    <td class="center">X</td>
                                                </tr>
                                                <tr class="gradeC">
                                                    <td>Tasman</td>
                                                    <td>Internet Explorer 5.1</td>
                                                    <td>Mac OS 7.6-9</td>
                                                    <td class="center">1</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="gradeC">
                                                    <td>Tasman</td>
                                                    <td>Internet Explorer 5.2</td>
                                                    <td>Mac OS 8-X</td>
                                                    <td class="center">1</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Misc</td>
                                                    <td>NetFront 3.1</td>
                                                    <td>Embedded devices</td>
                                                    <td class="center">-</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="gradeA">
                                                    <td>Misc</td>
                                                    <td>NetFront 3.4</td>
                                                    <td>Embedded devices</td>
                                                    <td class="center">-</td>
                                                    <td class="center">A</td>
                                                </tr>
                                                <tr class="gradeX">
                                                    <td>Misc</td>
                                                    <td>Dillo 0.8</td>
                                                    <td>Embedded devices</td>
                                                    <td class="center">-</td>
                                                    <td class="center">X</td>
                                                </tr>
                                                <tr class="gradeX">
                                                    <td>Misc</td>
                                                    <td>Links</td>
                                                    <td>Text only</td>
                                                    <td class="center">-</td>
                                                    <td class="center">X</td>
                                                </tr>
                                                <tr class="gradeX">
                                                    <td>Misc</td>
                                                    <td>Lynx</td>
                                                    <td>Text only</td>
                                                    <td class="center">-</td>
                                                    <td class="center">X</td>
                                                </tr>
                                                <tr class="gradeC">
                                                    <td>Misc</td>
                                                    <td>IE Mobile</td>
                                                    <td>Windows Mobile 6</td>
                                                    <td class="center">-</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="gradeC">
                                                    <td>Misc</td>
                                                    <td>PSP browser</td>
                                                    <td>PSP</td>
                                                    <td class="center">-</td>
                                                    <td class="center">C</td>
                                                </tr>
                                                <tr class="gradeU">
                                                    <td>Other browsers</td>
                                                    <td>All others</td>
                                                    <td>-</td>
                                                    <td class="center">-</td>
                                                    <td class="center">U</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div><!--End Advanced Tables -->

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <!--   Kitchen Sink -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Kitchen Sink
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Username</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- End  Kitchen Sink -->
                        </div>
                        <div class="col-md-6">
                            <div id="chartContainer" style="height: 300px; width: 100%;"></div>
                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <div class="row">
                        <div class="col-md-6">
                            <!--    Striped Rows Table  -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Striped Rows Table
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Username</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!--  End  Striped Rows Table  -->
                        </div>
                        <div class="col-md-6">
                            <!--    Bordered Table  -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Bordered Table
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive table-bordered">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Username</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!--  End  Bordered Table  -->
                        </div>
                    </div>
                </div><!-- /. PAGE INNER -->
            </div><!-- /. PAGE WRAPPER -->
        </div><!-- /. WRAPPER -->
        <script src="../js/jquery-1.10.2.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery.metisMenu.js"></script>
        <script src="../js/dataTables/jquery.dataTables.js"></script>
        <script src="../js/dataTables/dataTables.bootstrap.js"></script>
        <script>
                    $(document).ready(function () {
                        $('#dataTables-example').dataTable();
                    });
        </script>
        <script src="../js/custom.js"></script>
    </body>
</html>
