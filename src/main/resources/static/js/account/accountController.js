app.controller('accountController',function($scope,$window,accountService){
	//var firstname =  $scope.firstname;
	$scope.count=accountService.saveFunction('abcd');
});