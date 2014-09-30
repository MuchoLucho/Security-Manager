/*=============================================================
 Authour: NARF Inc.
 License: Commons Attribution 3.0 
 http://creativecommons.org/licenses/by/3.0/ 
 ==============================================================*/

/*JSON received*/
var tb;
var col;
var rsrc;
/*Specific Variables*/

var selectedLevel = "";
var count = 0; // For Radio Buttons

/*Tables*/

var cTable;
var tTable;
var rTable;
var sTable;
/*Tables Fillers*/

function genRsrc(i) {
    $.ajax({
        url: 'SensibilityService',
        data: {
            call: "rsrc",
            element: i
        },
        dataType: 'json',
        success: function (response) {
            rsrc = (response);
            var ar = "", nom = "";
            for (var i = 0; i < rsrc.length; i++) {
                nom = rsrc[i].rName;
                ar += "<tr>" +
                        "<td>" + nom + "</td>" +
                        "<td>" + rsrc[i].type + "</td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(rsrc[i].selected)) ? " checked='checked'" : "") + "/></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_rsrc").innerHTML = ar;
            rTable = $('#rsrc').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
}

function genTables(i) {
    $.ajax({
        url: 'SensibilityService',
        data: {
            call: "tables",
            element: i
        },
        dataType: 'json',
        success: function (response) {
            tb = (response);
            var ar = "", nom = "";
            for (var i = 0; i < tb.length; i++) {
                nom = tb[i].tName;
                ar += "<tr>" +
                        "<td>" + nom + "</td>" +
                        "<td>" + tb[i].tablespace + "</td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(tb[i].select)) ? " checked='checked'" : "") + "/></td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(tb[i].insert)) ? " checked='checked'" : "") + "/></td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(tb[i].delete)) ? " checked='checked'" : "") + "/></td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(tb[i].update)) ? " checked='checked'" : "") + "/></td>" +
                        "<td><button type='button' value='" + nom + "' class='btn btn-success' onclick='mycolumn(this.value)'>Edit</button></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_tablas").innerHTML = ar;
            tTable = $('#tablas').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
}

function genCols(i) {
    $.ajax({
        url: 'SensibilityService',
        data: {
            call: "columns",
            element: i
        },
        dataType: 'json',
        success: function (response) {
            col = (response);
            var ar = "", nom = "";
            for (var i = 0; i < col.length; i++) {
                nom = col[i].tName + "_" + col[i].cName;
                ar += "<tr>" +
                        "<td>" + col[i].tName + "</td>" +
                        "<td>" + col[i].cName + "</td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + (eval(col[i].update) ? " checked='checked'" : "") + "/></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_columnas").innerHTML = ar;
            cTable = $('#columnas').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
}

$(document).ready(function () {
    $.ajax({
        url: 'SensibilityService',
        data: {
            call: "sens"
        },
        dataType: 'json',
        success: function (response) {
            var ar = "", nom = "";
            for (var i = 0; i < response.length; i++) {
                nom = response[i].sName;
                ar += "<tr>" +
                        "<td>" + nom + "</td>" +
                        "<td>" +
                        "<button type='button' class='btn btn-primary' onclick='cog(\"" + nom + "\")'>" +
                        "<i class='fa fa-cog'></i>&nbsp;Modify Level</button>&nbsp;" +
                        /*"<button type='button' onclick='borra(\"" + nom + "\")' class='btn btn-danger' data-toggle='modal' data-target='#myModal'>" +
                        "<i class='fa fa-times'></i>&nbsp;Delete Level</button></td>" +*/
                        "</tr>";
            }
            document.getElementById("contenido_sens").innerHTML = ar;
            sTable = $('#selected').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
});

/*Objects to JSON*/

function tableToJSON() {
    var str = "[";
    var ar = [];
    tb.forEach(function (x) {
        ar = tTable.$("input[name=" + x.tName + "]");
        str += '{"tName":"' + x.tName +
                '", "tablespace":"' + x.tablespace +
                '", "select":"' + ar[0].checked +
                '", "insert":"' + ar[1].checked +
                '", "delete":"' + ar[2].checked +
                '", "update":"' + ar[3].checked + '"},';
    });
    return str.slice(0, str.length - 1) + "]";
}

function columnsToJSON() {
    var str = "[";
    var ar = [];
    col.forEach(function (x) {
        ar = cTable.$("input[name=" + x.tName + "_" + x.cName + "]");
        str += '{"tName":"' + x.tName +
                '", "cName":"' + x.cName +
                '", "update":"' + ar[0].checked +
                '", "tablespace":"' + x.tablespace +
                '"},';
    });
    return str.slice(0, str.length - 1) + "]";
}

function rsrcToJSON() {
    var str = "[";
    var ar = [];
    rsrc.forEach(function (x) {
        ar = rTable.$("input[name=" + x.rName + "]");
        str += '{"rName":"' + x.rName +
                '", "type":"' + x.type +
                '", "selected":"' + ar[0].checked + '"},';
    });
    return str.slice(0, str.length - 1) + "]";
}

/*Push data*/

function sendNewData() {
    var a = tableToJSON();
    var b = columnsToJSON();
    var c = rsrcToJSON();
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: "SensibilityService",
        data: {tables: a, columns: b, rsrc: c, sens: selectedLevel},
        success: function (response) {
            console.log(response);
            location.reload(true);
        }, error: function (response) {
            location.reload(true);
        }
    });
}


/*Some Listeners*/

function mycolumn(i) {
    $("#divCol").removeAttr("style");
    document.getElementById("colSel").innerHTML = i;
    cTable.fnFilter(i);
}

function cog(i) {
    selectedLevel = i;
    document.getElementById("name1").innerHTML = i;
    genTables(i);
    genCols(i);
    genRsrc(i);
    $('#modify').removeAttr("style");
    $('#select').attr('style', 'display: none');
}

//Changes information acording to radio inputs
$('input[name=data]').on('change', function () {
    if (count % 2 === 0) {
        $('#drsrc').removeAttr("style");
        $('#dtablas').attr('style', 'display: none');
    } else {
        $('#dtablas').removeAttr("style");
        $('#drsrc').attr('style', 'display: none');
    }
    count++;
});

$('#changes').click(function () {
    sendNewData();
});
