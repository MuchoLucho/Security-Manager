$(document).ready(function () {
    $.ajax({
        url: 'Log',
        data: {
            call: "log"
        },
        dataType: 'json',
        success: function (response) {
            var ar = "", nom = "";
            for (var i = 0; i < response.length; i++) {
                ar += "<tr>" + "<td>" + response[i].log + "</td>" + "</tr>\n";
            }
            document.getElementById("tLogs").innerHTML = ar;
            sTable = $('#tLogs').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
});