app.service('accountService',function($http,$window,$timeout){

	this.saveFunction= function(firstName, lastName, contactNo, email, passWord, confirmPassword) {
		console.log('fn--'+firstName);
		console.log('--'+lastName);
		console.log('--'+contactNo);
		console.log('--'+email);
		console.log('--'+passWord);
		var emailId = email.split('.');
		 
		var reqUnique = {
				method : 'GET',
				url : 'http://localhost:8080/users/'+emailId[0]+'-'+emailId[1]
		}
		$http(reqUnique).then(
				function(response){ 
					if((response.status == 200)){
						console.log('response-----'+response);
						if(response.data == "" || response.data == 'undefined'){
							var req = {
									method : 'POST',
									url : 'http://localhost:8080/signUp',
									headers : {
										'Content-Type' : 'application/json'
									},
									data : {
										email : email,
										firstName : firstName,
										lastName : lastName,
										password : passWord,
										contactNo : contactNo
									}
							}
							
								$http(req).then(
										function(response) {

											if (response.status == 200) {

												console.log("Sign Up Successful");
												swal('Registration Successful','','success');
												$timeout(function(){
													$window.location.href="/html/login.html";
												},3000)

											} else {
												console.log("Error: "
														+ response.data.statusText);
											}
										},
										function(response) {

											if(typeof response.data.message === 'undefined')
												console.log("Error: " + response.statusText);
											else
												console.log("Error: " + response.data.message);
										});
							
						}
						else{
							swal('Registration Failed','An account with email id already exists','error');
						}
					}
				});
	}
	
	this.authenticate = function(user)
	{
		console.log(user.email);
		console.log(user.passWord);

		return $http({
        	url: "http://localhost:8080/signIn",
        	method: "POST",
        	data:user,
        	headers: { "Accept": "application/json; odata=verbose" },
    });
		
	}
	
		this.logout = function()
		{
			return $http({
	        	url: "http://localhost:8080/logout",
	        	method: "Get",
	        	headers: { "Accept": "application/json; odata=verbose" },
	    });
	}
		
		this.getCurrentUser= function()
		{
			return $http({
	        	url: "http://localhost:8080/currentuser",
	        	method: "GET",
	          	headers: { "Accept": "application/json" },
	    });
		}
});