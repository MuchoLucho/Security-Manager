$(document).ready(function () {
    reload();
});

function reload() {
    $.ajax({
        url: 'LastEvents',
        data: {
            call: "events"
        },
        dataType: 'json',
        success: function (response) {
            var ar = "";
            for (var i = 0; i < response.length; i++) {
                ar += "<tr><td>" + response[i].User + "</td>" +
                        "<td>" + response[i].Statement + "</td>" +
                        "<td>" + response[i].SQL + "</td>" +
                        "<td>" + response[i].Date + "</td>" +
                        "<td>" + response[i].State + "</td></tr>";
            }
            document.getElementById("tEvents").innerHTML = ar;
            $('#events').dataTable();
        },
        error: function (response) {
            //Error Message
        }
    });
    setTimeout(reload, 60000);
}