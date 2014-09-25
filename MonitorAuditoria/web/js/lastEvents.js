$(document).ready(function () {
    $('#events').dataTable();
});

function reload() {
    $.ajax({
        url: 'LastEvents',
        data: {
            call: "events"
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
}