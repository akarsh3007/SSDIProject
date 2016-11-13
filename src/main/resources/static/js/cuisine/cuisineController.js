app.controller('cuisineController',function($scope,$timeout,$mdDialog,cuisineService,dishService){
	$scope.cuisineRows={};
	$scope.addRatiing = function(cuisine, newRating){
		console.log('cuisine----------'+cuisine);
		console.log('newRating----------'+newRating);
		var total = (cuisine.rating * cuisine.no_of_raters);
		console.log('cuisine.rating------'+cuisine.rating);
		console.log('cuisine.no_of_raters------'+cuisine.no_of_raters);
		console.log('total------'+total);
		console.log('newRating------'+newRating);
		total = total + Number(newRating);
		console.log('total------'+total);
		var totalRaters = Number(cuisine.no_of_raters) + 1;
		console.log('total------'+total);
		console.log('totalRaters------'+totalRaters);
		var latestRating = total / totalRaters;
		cuisineService.saveRatingFunction(cuisine.cuisine_ID,latestRating,totalRaters);
	}
	$scope.getCuisines = function(){
		cuisineService.getCuisinesDishes().then(function (data, status, headers, config) {
			$scope.cuisineRows=data.data;
			console.log('cuisines------------'+$scope.cuisineRows);
        },
        function (data, status, headers, config) {
            console.log("Error " + status);
        });
	}
	$scope.getCuisines();
	
	
	$scope.saveCuisineReview = function(cuisine, newReview){
		console.log('newReview---------'+newReview)
		cuisineService.saveReviewForCuisine(cuisine,newReview);
	}
	 
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
		dishService.saveRatingForDish(dish,latestRating,totalRaters);
	}
	
	$scope.saveDishReview = function(dish, newDishReview){
		dishService.saveReviewFunction(dish,newDishReview);
	}
	
	 $scope.showCuisineReviews = function(ev,cuisine) {
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'reviews.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      locals:{
		    	  cuisine:cuisine
		      },
		      fullscreen: $scope.customFullscreen 
		    })
		  };

	  $scope.addCuisineReviews = function(ev,cuisine) {
			 $mdDialog.show({
			      controller: DialogController,
			      templateUrl: 'writeCuisineReviews.tmpl.html',
			      parent: angular.element(document.body),
			      targetEvent: ev,
			      clickOutsideToClose:true,
			      locals:{
			    	  cuisine:cuisine
			      },
			      fullscreen: $scope.customFullscreen 
			    })
			  };
		  
	 $scope.showAdvanced = function(ev,cuisine) {
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'rating.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      locals:{
		    	  cuisine:cuisine
		      },
		      fullscreen: $scope.customFullscreen 
		    })
		  };
	
		  $scope.showDishReviews = function(ev,dish) {
				 $mdDialog.show({
				      controller: dishDialogController,
				      templateUrl: 'dishReviews.tmpl.html',
				      parent: angular.element(document.body),
				      targetEvent: ev,
				      clickOutsideToClose:true,
				      locals:{
				    	  dish:dish
				      },
				      fullscreen: $scope.customFullscreen 
				    })
				  };

			  $scope.addDishReviews = function(ev,dish) {
					 $mdDialog.show({
					      controller: dishDialogController,
					      templateUrl: 'writeDishReviews.tmpl.html',
					      parent: angular.element(document.body),
					      targetEvent: ev,
					      clickOutsideToClose:true,
					      locals:{
					    	  dish:dish
					      },
					      fullscreen: $scope.customFullscreen 
					    })
					  };
				  
			 $scope.rateDish = function(ev,dish) {
				 $mdDialog.show({
				      controller: dishDialogController,
				      templateUrl: 'dishRating.tmpl2.html',
				      parent: angular.element(document.body),
				      targetEvent: ev,
				      clickOutsideToClose:true,
				      locals:{
				    	  dish:dish
				      },
				      fullscreen: $scope.customFullscreen 
				    })
				  };
			
	function DialogController($scope,$mdDialog,cuisine) {
		$scope.currentCuisine = cuisine;
		console.log($scope.currentCuisine);
		console.log($scope.currentCuisine.cuisine_ID);
		console.log($scope.currentCuisine.rating);
		console.log($scope.currentCuisine.num_of_raters);
		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
	
	function dishDialogController($scope, $mdDialog,dish) {
		$scope.currentDish = dish;
		console.log($scope.currentDish);
		console.log($scope.currentDish.dish_ID);
		console.log($scope.currentDish.rating);
		console.log($scope.currentDish.num_of_raters);
		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
});