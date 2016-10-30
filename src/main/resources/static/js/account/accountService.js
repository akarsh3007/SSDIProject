app.service('accountService',function($http){

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
							if(passWord === confirmPassword){
								$http(req).then(
										function(response) {

											if (response.status == 200) {

												console.log("Sign Up Successful");


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
							}else{
								alert("Your password and confirmation password do not match");
							}	
						}
						else{
							alert("An account with this email id already exists.");
						}
					}
				});

	}
});