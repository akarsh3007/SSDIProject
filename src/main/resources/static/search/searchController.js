app.controller('searchController',function($scope,$mdDialog,searchService,mapsService){

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
	
	$scope.searchRestaurants = function(searchQuery)
	{
		searchService.searchRestaurants(searchQuery).then(
				function (data, status, headers, config) {
		              
						console.log(data);
						$scope.RestaurantSearchResult = data.data;
						console.log(data.data);
		            },
		            function (data, status, headers, config) {
		                console.log("Error " + status);
		            });
	}
	
	 $scope.showCuisineDetail = function(ev,cuisine) {
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: '/html/cuisineDetail.tmpl.html',
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
				      templateUrl: '/html/dishDetail.tmpl.html',
				      parent: angular.element(document.body),
				      targetEvent: ev,
				      clickOutsideToClose:true,
				      locals:{
				    	  item:dish
				      },
				      fullscreen: $scope.customFullscreen 
				    })
				  };
			
			$scope.showOnMap = function(ev,item) {

				var mapData = mapsService.createMapDataString(item.rest_name,item.city,item.zipcode);
				console.log(mapData);
				item.mapData = mapData;
					$mdDialog.show({
						      controller: DialogController,
						      templateUrl: 'maps/maps.tmpl.html',
						      parent: angular.element(document.body),
						      targetEvent: ev,
						      clickOutsideToClose:true,
						      locals:{
						    	  item:item
						      },
						      fullscreen: $scope.customFullscreen 
						    })
						  };
					
	function DialogController($scope, $mdDialog,item) {
		$scope.currentItem = item;
		$scope.currentItem.mapSrc = "https://www.google.com/maps/embed/v1/place?key=AIzaSyA2yu7pJ56FFS6kC1fH5NTPlk-Sam4sGiY&zoom=18&q="+item.mapData
		console.log("currentItem in Dialog");
		console.log($scope.currentItem);
		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
	
});