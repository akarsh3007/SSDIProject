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
	
	 $scope.showAdvanced = function(ev,cuisine) {
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'cuisineDetail.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      locals:{
		    	  cuisine:cuisine
		      },
		      fullscreen: $scope.customFullscreen 
		    })
		  };
	
	function DialogController($scope, $mdDialog,cuisine) {
		$scope.currentCuisine = cuisine;
		console.log($scope.currentCuisine);
		console.log($scope.currentCuisine.restaurant.rest_name);
		console.log($scope.currentCuisine.rating);
		console.log($scope.currentCuisine.cuisineReviews);
		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
	
});