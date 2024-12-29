function pass(var1){
	var role  = var1;
	var role8 = null;
	if(role === "ind"){
		role8 = "Industry";
	}
	else if (role === "ad"){
		role8 = "Admin";
	}
	else if(role === "mc"){
		role8 = "Material Composition";
	}
	else if(role === "test"){
		role8 = "Material Testing"
	}
	else if(role === "manu"){
		role8 = "Manufacturing";
	}
	console.log(role);
	var title = document.getElementById("exampleModalLabel").innerHTML = role8 +" "+ "Signin";
	// log fields:
	var uname = document.getElementById("uname");
	var pass = document.getElementById("pass");
	var rn = document.getElementById("rn");
	var role2 = document.getElementById("role2");
	
	// reg fields:
	var un = document.getElementById("un");
	var email = document.getElementById("email");
	var pass1 = document.getElementById("pass1");
	var cpass1 = document.getElementById("cpass1");
	var role1 = document.getElementById("role1");
	
	if (role === "ind"){
		rn.style.display = "block";
		role1.value = role;
		role2.value = role;
		console.log("@@@@"+ document.getElementById("role1").value);
		console.log("ind if condition");
	/*	console.log("client if condition");*/
	}
	else if(role === "ad"){
		role2.value = role;
		console.log("ad if condition");
		rn.style.display = "none";
	}
	else if(role === "mc"){
		rn.style.display = "none";
		role1.value = role;
		role2.value = role;
		console.log("mc if condition");
		
	}
	else if(role === "test"){
		rn.style.display = "none";
		role1.value = role;
		role2.value = role;
		console.log("test if condition");
		
	}
	else if(role === "manu"){
		role2.value = role;
		console.log("manu if condition");
		rn.style.display = "none";
		/*pass.style.display = "none";*/
	}
}