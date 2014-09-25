/*=============================================================
 Authour: NARF Inc.
 License: Commons Attribution 3.0 
 http://creativecommons.org/licenses/by/3.0/
 =============================================================*/

//var roles = [{"name": "luis", "selected": true}, {"name": "jota", "selected": false}];
//var users = [{"name": "admin"}, {"name": "peasant"}];

/*Tables*/

var sTable;
var rTable;

/*Specific Variables*/

var selecteduser = "";

/*Tables Fillers*/

function genroles(i) {
    $.ajax({
        url: 'RolesService',
        data: {
            call: "roles",
            element: i
        },
        dataType: 'json',
        success: function (response) {
            roles = response;
            var ar = "", nom = "";
            for (var i = 0; i < roles.length; i++) {
                nom = roles[i].name;
                ar += "<tr>" +
                        "<td>" + nom + "</td>" +
                        "<td><input type='checkbox' name='" + nom + "'" + ((eval(roles[i].selected)) ? " checked='checked'" : "") + "/></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_roles").innerHTML = ar;
            sTable = $('#roles').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
}

/*Objects to JSON*/

function rolesToJSON() {
    var str = "[";
    var ar = [];
    roles.forEach(function (x) {
        ar = sTable.$("input[name=" + x.tName + "]");
        str += '{"name":"' + x.tName +
                '", "selected":"' + ar[0].checked +'"},';
    });
    str = str.slice(0, str.length - 1) + "]";
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: "rolesibilityService",
        data: {set: "roles", element: str, roles: selecteduser}/*,
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
            call: "users"
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
                        "<i class='fa fa-cog'></i>&nbsp;Modify user</button>&nbsp;" +
                        "<button type='button' onclick='borra(\"" + nom + "\")' class='btn btn-danger' data-toggle='modal' data-target='#myModal'>" +
                        "<i class='fa fa-times'></i>&nbsp;Delete user</button></td>" +
                        "</tr>";
            }
            document.getElementById("contenido_users").innerHTML = ar;
            sTable = $('#users').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
});

function cog(i) {
    selecteduser = i;
    document.getElementById("name1").innerHTML = i;
    genroles(i);
    $('#modify').removeAttr("style");
    $('#select').attr('style', 'display: none');
}

$('#changes').click(function () {
//Al aplicar los cambios
});