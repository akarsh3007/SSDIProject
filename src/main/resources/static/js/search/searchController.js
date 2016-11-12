app.controller('searchController',function($scope,searchService){

	$scope.SearchResult = {};
	$scope.searchOption = {};
	$scope.searchOption.selected = "Cuisine";
	
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
	
});