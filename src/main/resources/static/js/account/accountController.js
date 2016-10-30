
app.controller('accountController',function($scope,$window,accountService){
	/*$scope.firstName;
	$scope.lastName;
	$scope.email;
	$scope.password;
	$scope.contact;*/
	console.log('1---');
	$scope.user = {email:"", password:""}
	$scope.isAuthentionValid = true;
	$scope.signUp = function(){
		accountService.saveFunction($scope.firstname,$scope.lastname, $scope.contact, $scope.email, $scope.passWord, $scope.confirmPassword);
	}
	
	$scope.signIn = function()
	{
		console.log($scope.user);
		accountService.authenticate($scope.user).then(
	            function (data, status, headers, config) {
	               console.log(data.data);
	               if(data.data)
	            	   {
	            	   	console.log("login success");
	            	   	$scope.isAuthentionValid = true;
	            	   	$window.location.href="/html/home.html";
	            	   }
	               else
	            	   {
	            	   	 console.log("login failed");
	            	   	$scope.isAuthentionValid = false;
	            	   }
	               console.log(status);
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
	}
	
	$scope.logout = function()
	{
		console.log("inside logout");
		accountService.logout().then(
	            function (data, status, headers, config) {
		               	console.log(data);
		               	console.log("logout successfully");
		                var url = "http://" + $window.location.host + "/index.html";
		                $window.location.href = url;
		               
		            },
		            function (data, status, headers, config) {
		                console.log("Error " + status);
		            });
	}
});