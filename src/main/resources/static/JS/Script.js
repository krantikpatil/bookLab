 const toggleSideMenu = () =>{
	
	if($(".sidemenu").is(":visible")){
	
		$(".sidemenu").css("display", "none");
		$(".content").css("margin-left", "2%");		
	}else{
		$(".sidemenu").css("display", "block");
		$(".content").css("margin-left", "20%");
	}
	
}