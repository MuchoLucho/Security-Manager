/*=============================================================
 Authour URI: www.binarycart.com
 License: Commons Attribution 3.0 
 http://creativecommons.org/licenses/by/3.0/ 
 100% To use For Personal And Commercial Use.
 IN EXCHANGE JUST GIVE US CREDITS AND TELL YOUR FRIENDS ABOUT US 
 ========================================================  */

(function ($) {
    "use strict";
    var mainApp = {
        main_fun: function () {
            /*====================================
             METIS MENU 
             ======================================*/
            $('#main-menu').metisMenu();
            /*====================================
             LOAD APPROPRIATE MENU BAR
             ======================================*/
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse');
                } else {
                    $('div.sidebar-collapse').removeClass('collapse');
                }
            });
        },
        initialization: function () {
            mainApp.main_fun();
        }
    };
    // Initializing ///
    $(document).ready(function () {
        mainApp.main_fun();
    });
}(jQuery));

/*VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
 Authour: NARF Inc.
 License: Commons Attribution 3.0 
 http://creativecommons.org/licenses/by/3.0/
VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV*/

function borra(i) {
    document.getElementById("name2").innerHTML = i;
    $('#deleteBtn').attr('value', i);
}

$('#cancelMod').click(function () {
    $('#select').removeAttr("style");
    $('#modify').attr('style', 'display: none');   
});

$('#cancelCreate').click(function () {
    $('#select').removeAttr("style");
    $('#create').attr('style', 'display: none');
});

$('#plus').click(function () {
    $('#create').removeAttr("style");
    $('#select').attr('style', 'display: none');
});