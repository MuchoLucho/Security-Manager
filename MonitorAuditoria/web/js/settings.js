$(document).ready(function () {
    document.getElementById('selected').selectedIndex = 0;
    $.ajax({
        url: 'SettingsService',
        data: {
            ask: "state"
        },
        dataType: 'json',
        success: function (response) {
            if (eval(response.state)) {
                $('#space').removeAttr("style");
                $('#suspend').removeAttr("style");
            } else {
                $('#suspend').removeAttr("style");
            }
        },
        error: function (response) {
        }
    });
});

$('#suspend').click(function () {
    $('#space').attr("style", "display:none");
    $('#suspend').attr("style", "display:none");
    $('#enable').removeAttr("style");
});

$('#enable').click(function () {
    $('#space').removeAttr("style");
    $('#suspend').removeAttr("style");
    $('#enable').attr("style", "display:none");
});

$('#selected').change(function(){
    $('#change').removeAttr("disabled");
});