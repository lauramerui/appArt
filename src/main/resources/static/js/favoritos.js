$(function () { 
    $('#btnmegusta').on("click",function(){
        $("#megusta").css("display","block");
        $('#btnmisgalerias + label').removeClass("selected");
        $('#btnmegusta + label').addClass("selected");
        $("#galerias").css("display","none");
        $(".btnGaleria").css("display","none");
    });

    $('#btnmisgalerias').on("click",function(){
        $("#megusta").css("display","none");
        $(".btnGaleria").css("display","flex");
        $("#galerias").css("display","flex");
        $('#btnmegusta + label').removeClass("selected");
        $('#btnmisgalerias + label').addClass("selected");
    });
 });