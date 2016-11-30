app.service('cuisineService',function($http,$timeout){
	
	this.getCuisinesDishes = function(id){
		var endPointUri = "http://localhost:8080/api/restaurants/"+id;
		return $http({
        	url: endPointUri,
        	method: "GET",
          	headers: { "Accept": "application/json" },
    });
	}
	
	this.saveRatingFunction = function(cuisine_ID,rating,no_of_raters){
		
		return $http({
        	url: 'http://localhost:8080/api/cuisines/updatecuisinerating',
        	method: "POST",
        	data:
        		{
        			cuisine_ID : cuisine_ID,
        			rating : rating,
        			no_of_raters : no_of_raters
        		},
        	headers: { "Accept": "application/json; odata=verbose" },
		});
	}
	
	this.saveReviewForCuisine = function(cuisineReview){
			
		return $http({
        	url: "http://localhost:8080/api/cuisinereview",
        	method: "POST",
        	data:cuisineReview,
        	headers: { "Accept": "application/json; odata=verbose" },
		});
	}
	
	 this.GetQueryStringParameter = function (paramToRetrieve) {
	        /*var params =
	        document.URL.split("?")[1].split("&");
	        var strParams = "";
	        for (var i = 0; i < params.length; i = i + 1) {
	            var singleParam = params[i].split("=");
	            if (singleParam[0] == paramToRetrieve)
	                return singleParam[1];
	        }*/
	 }
	
	 this.getTrendingCuisines = function(){
		 return $http({
			 	url: "http://localhost:8080/api/cuisines/gettrendingcuisines",
	        	method: "GET",
	          	headers: { "Accept": "application/json" }
		});
	 }
});
