app.service('searchService',function($http){

	this.searchCuisine = function(searchToken)
	{
		var endPointUrl = "http://localhost:8080/api/cuisines/search?searchToken=" + searchToken;
		return $http({
        	url: endPointUrl,
        	method: "Get",
        	headers: { "Accept": "application/json; odata=verbose" },
		});
	}
	
	this.searchDish = function(searchToken)
	{
		var endPointUrl = "http://localhost:8080/api/dish/search?searchToken=" + searchToken;
		return $http({
        	url: endPointUrl,
        	method: "Get",
        	headers: { "Accept": "application/json; odata=verbose" },
		});
	}
	
});