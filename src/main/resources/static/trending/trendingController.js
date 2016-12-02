app.controller('trendingController',function($scope,cuisineService,dishService){

	$scope.getTrendingCuisineList = function(){
		console.log("function called");
		cuisineService.getTrendingCuisines().then(
				function (data, status, headers, config) {  
					console.log("trending response");
					console.log(data);
					if(data)
						{
							$scope.trendingCuisines = data.data;
						}
					else
						{
							
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
	}
	
	$scope.getTrendingDishesList = function(){
		dishService.getTrendingDishes().then(
				function (data, status, headers, config) {  
					console.log("trending response");
					console.log(data);
					if(data)
						{
							$scope.trendingdishes = data.data;
						}
					else
						{
							
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
	}
	
});	
