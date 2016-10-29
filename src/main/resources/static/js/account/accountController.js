
app.controller('accountController',function($scope,accountService){
	/*$scope.firstName;
	$scope.lastName;
	$scope.email;
	$scope.password;
	$scope.contact;*/
	console.log('1---');
	$scope.signUp = function(){
		accountService.saveFunction($scope.firstname,$scope.lastname, $scope.contact, $scope.email, $scope.passWord, $scope.confirmPassword);
	}
	
});