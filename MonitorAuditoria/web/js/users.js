/*=============================================================
 Authour: NARF Inc.
 License: Commons Attribution 3.0 
 http://creativecommons.org/licenses/by/3.0/
 =============================================================*/

/*Tables*/

var sTable;
var rTable;

/*Specific Variables*/

var selecteduser = "";
var roles;
var users;

/*Tables Fillers*/

function genroles(i) {
    $.ajax({
        url: 'UsersService',
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
            rTable = $('#roles').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
}

$(document).ready(function () {
    $.ajax({
        url: 'UsersService',
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
                        /*"<button type='button' onclick='borra(\"" + nom + "\")' class='btn btn-danger' data-toggle='modal' data-target='#myModal'>" +
                        "<i class='fa fa-times'></i>&nbsp;Delete user</button></td>" +*/
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

/*Objects to JSON*/

function rolesToJSON() {
    var str = "[";
    var ar = [];
    roles.forEach(function (x) {
        ar = rTable.$("input[name=" + x.name + "]");
        str += '{"name":"' + x.name +
                '", "selected":"' + ar[0].checked + '"},';
    });
    str = str.slice(0, str.length - 1) + "]";
    $.ajax({
        type: 'post',
        dataType: 'json',
        url: "UsersService",
        data: {set: selecteduser, element: str},
        success: function (response) {
            console.log(response);
            location.reload(true);
        }, error: function (response) {
            location.reload(true);
        }
    });
}

/*Some Listeners*/

function cog(i) {
    selecteduser = i;
    document.getElementById("name1").innerHTML = i;
    genroles(i);
    $('#modify').removeAttr("style");
    $('#select').attr('style', 'display: none');
}

$('#changes').click(function () {
    rolesToJSON();
});
