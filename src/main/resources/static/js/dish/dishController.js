app.controller('dishController',function($scope,$timeout,dishService){
	
	$scope.addRatingToDish = function(dish,selectedRating){
		console.log('dish----------'+dish);
		console.log('selectedRating----------'+selectedRating);
		var total = (dish.rating * dish.no_of_raters);
		console.log('dish.rating------'+dish.rating);
		console.log('dish.no_of_raters------'+dish.no_of_raters);
		console.log('total------'+total);
		console.log('selectedRating------'+selectedRating);
		total = total + Number(selectedRating);
		console.log('total------'+total);
		var totalRaters = Number(dish.no_of_raters) + 1;
		console.log('total------'+total);
		console.log('totalRaters------'+totalRaters);
		var latestRating = total / totalRaters;
		dishService.saveRatingForDish($scope.dish_ID,latestRating,totalRaters);
	}
	
	$scope.saveDishReview = function(){
		dishService.saveReviewFunction($scope.dish_ID,$scope.commentBody);
	}
	
	
});