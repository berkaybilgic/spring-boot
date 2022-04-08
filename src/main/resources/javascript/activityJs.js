<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

$(document).ready(function(){

    setTimeout(function(){

        $("#kaybolanMesaj").fadeOut("slow", function () {

            $("#kaybolanMesaj").remove();

        });

    }, 1500);

});
