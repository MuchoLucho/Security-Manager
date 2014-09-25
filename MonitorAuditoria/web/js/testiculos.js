var tables = [];
var priv = [];

var arSwag;
tables.forEach(function (x) {
    

});

$.inArray(value, array)

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