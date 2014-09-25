/*=============================================================
 Authour: NARF Inc.
 License: Commons Attribution 3.0 
 http://creativecommons.org/licenses/by/3.0/
 =============================================================*/

//var sens = [{"name": "luis", "selected": true}, {"name": "jota", "selected": false}];
//var roles = [{"name": "admin"}, {"name": "peasant"}];

/*Tables*/

var sTable;
var rTable;

/*Specific Variables*/

var selectedRole = "";

/*Tables Fillers*/

function genSens(i) {
    $.ajax({
        url: 'RolesService',
        data: {
            call: "sens",
            element: i
        },
        dataType: 'json',
        success: function (response) {
            sens = response;
            var ar = "", nom = "";
            for (var i = 0; i < sens.length; i++) {
                nom = sens[i].name;
                ar += "<tr>" +
                        "<td>" + nom + "</td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(sens[i].selected)) ? " checked='checked'" : "") + "/></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_sens").innerHTML = ar;
            sTable = $('#sens').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
}

/*Objects to JSON*/

function sensToJSON() {
    var str = "[";
    var ar = [];
    sens.forEach(function (x) {
        ar = sTable.$("input[name=" + x.tName + "]");
        str += '{"name":"' + x.tName +
                '", "selected":"' + ar[0].checked +'"},';
    });
    str = str.slice(0, str.length - 1) + "]";
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: "RolesService",
        data: {set: "sens", element: str, sens: selectedRole}/*,
         success: function (response) {
         //Message from server
         },
         error: function (response) {
         //If u can not connect
         }*/
    });
}

/*Some Listeners*/

$(document).ready(function () {
    $.ajax({
        url: 'RolesService',
        data: {
            call: "roles"
        },
        dataType: 'json',
        success: function (response) {
            var ar = "", nom = "";
            for (var i = 0; i < response.length; i++) {
                nom = response[i].name;
                ar += "<tr>" +
                        "<td>" + nom + "</td>" +
                        "<td>" +
                        "<button type='button' class='btn btn-primary' onclick='cog(\"" + nom + "\")'>" +
                        "<i class='fa fa-cog'></i>&nbsp;Modify Role</button>&nbsp;" +
                        "<button type='button' onclick='borra(\"" + nom + "\")' class='btn btn-danger' data-toggle='modal' data-target='#myModal'>" +
                        "<i class='fa fa-times'></i>&nbsp;Delete Role</button></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_roles").innerHTML = ar;
            sTable = $('#roles').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
});

function cog(i) {
    selectedRole = i;
    document.getElementById("name1").innerHTML = i;
    genSens(i);
    $('#modify').removeAttr("style");
    $('#select').attr('style', 'display: none');
}

$('#changes').click(function () {
//Al aplicar los cambios
});