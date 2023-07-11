$('div').on("click",function(){
    
    if($(this).next("p").css("display")=="none"){

        $(this).siblings(".contents").slideUp();
        $(this).next().slideDown();
        
    }else{
        $(this).next().slideUp();
    }
    
})

