app.controller('searchController',function($scope,$mdDialog,searchService){

	$scope.cuisineSearchResult = {};
	$scope.cuisineSearchOption = {};
	$scope.dishSearchOption = {};
	$scope.searchCuisine = function(searchQuery)
	{
		searchService.searchCuisine(searchQuery).then(
				function (data, status, headers, config) {
		              
						console.log(data);
						$scope.cuisineSearchResult = data.data;
		            },
		            function (data, status, headers, config) {
		                console.log("Error " + status);
		            });
	}
	
	$scope.searchDish = function(searchQuery)
	{
		searchService.searchDish(searchQuery).then(
				function (data, status, headers, config) {
		              
						console.log(data);
						$scope.dishSearchResult = data.data;
						console.log(data.data);
		            },
		            function (data, status, headers, config) {
		                console.log("Error " + status);
		            });
	}
	
	 $scope.showCuisineDetail = function(ev,cuisine) {
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'cuisineDetail.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      locals:{
		    	  item:cuisine
		      },
		      fullscreen: $scope.customFullscreen 
		    })
		  };
		  $scope.showDishDetail = function(ev,dish) {
				 $mdDialog.show({
				      controller: DialogController,
				      templateUrl: 'dishDetail.tmpl.html',
				      parent: angular.element(document.body),
				      targetEvent: ev,
				      clickOutsideToClose:true,
				      locals:{
				    	  item:dish
				      },
				      fullscreen: $scope.customFullscreen 
				    })
				  };
			
	function DialogController($scope, $mdDialog,item) {
		$scope.currentItem = item;
		console.log($scope.currentItem);
		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
	
});