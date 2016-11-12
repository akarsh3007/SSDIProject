app.controller('searchController',function($scope,$mdDialog,searchService){

	$scope.SearchResult = {};
	$scope.searchOption = {};
	$scope.searchOption.selected = "true";
	
	$scope.searchCuisine = function(searchQuery)
	{
		searchService.searchCuisine(searchQuery).then(
				function (data, status, headers, config) {
		              
						console.log(data);
						$scope.SearchResult = data.data;
		               
		            },
		            function (data, status, headers, config) {
		                console.log("Error " + status);
		            });
	}
	
	 $scope.showAdvanced = function(ev) {
		    $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'cuisineDetail.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
		    })
		    .then(function(answer) {
		      $scope.status = 'You said the information was "' + answer + '".';
		    }, function() {
		      $scope.status = 'You cancelled the dialog.';
		    });
		  };
	
	function DialogController($scope, $mdDialog) {
	    $scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
	
});