app.service('dishService',function($http){
	
	
	this.saveRatingForDish = function(dish,rating,no_of_raters){

		return $http({
        	url: 'http://localhost:8080/api/dishes/updatedishrating',
        	method: "POST",
        	data:
        		{
        			dish_ID : dish.dish_ID,
        			rating : rating,
        			no_of_raters : no_of_raters,
        			cuisine:{
        				cuisine_ID:dish.cuisine
        			}
        		},
        	headers: { "Accept": "application/json; odata=verbose" },
		});
	}
	
	this.saveReviewFunction = function(dishReview){
			
		return $http({
        	url: "http://localhost:8080/api/dishreview",
        	method: "POST",
        	data:dishReview,
        	headers: { "Accept": "application/json; odata=verbose" },
		});
	}
	
	this.getTrendingDishes = function(){
		 return $http({
			 	url: "http://localhost:8080/api/dishes/gettrendingdishes",
	        	method: "GET",
	          	headers: { "Accept": "application/json" }
		});
	 }
		
});
