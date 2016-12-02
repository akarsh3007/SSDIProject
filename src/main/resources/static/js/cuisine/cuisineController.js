app.controller('cuisineController',function($scope,$timeout,$mdDialog,cuisineService,dishService){
	$scope.restaurantDetail={};
	
	
	$scope.addRatiing = function(cuisine, newRating){
		var totalc = (cuisine.rating * cuisine.no_of_raters);
		totalc = totalc + Number(newRating);
		var totalRatersc = Number(cuisine.no_of_raters) + 1;
		var latestRatingc = totalc / totalRatersc;
		
		cuisineService.saveRatingFunction(cuisine.cuisine_ID,latestRatingc,totalRatersc).then(
				function (data, status, headers, config) {  
					console.log("rating response");
					console.log(data);
					if(data)
						{
							$scope.hide();
							cuisine.rating = latestRatingc;
							cuisine.no_of_raters = totalRatersc;
							swal('Thanks for your Rating. Rating Added.','','success');
						}
					else
						{
							$scope.hide();
							swal('There was some error adding your rating','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
		
	}
	$scope.getCuisines = function(){
		var id = cuisineService.GetQueryStringParameter("id");
		cuisineService.getCuisinesDishes(id).then(function (data, status, headers, config) {
			$scope.restaurantDetail=data.data;
			console.log($scope.restaurantDetail);
        },
        function (data, status, headers, config) {
            console.log("Error " + status);
        });
	}
	//$scope.getCuisines();
	
	
	$scope.saveCuisineReview = function(cuisineReview){
		console.log('newReview---------'+cuisineReview)
		cuisineService.saveReviewForCuisine(cuisineReview).then(
				function (data, status, headers, config) {    
					if(data)
						{
							$scope.hide();
							swal('Thanks for your review. Review Added.','','success');
						}
					else
						{
							$scope.hide();
							swal('There was some error adding your review','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
	}
	 
	$scope.addRatingToDish = function(dish,selectedRating){
		var total = (dish.rating * dish.no_of_raters);
		total = total + Number(selectedRating);
		var totalRaters = Number(dish.no_of_raters) + 1;
		var latestRating = total / totalRaters;
		dishService.saveRatingForDish(dish,latestRating,totalRaters).then(
				function (data, status, headers, config) {  
					console.log("rating response");
					console.log(data);
					if(data)
						{
							$scope.hide();
							dish.rating = latestRating;
							dish.no_of_raters = totalRaters;
							swal('Thanks for your Rating. Rating Added.','','success');
						}
					else
						{
							$scope.hide();
							swal('There was some error adding your rating','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
		$scope.hide();
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
		console.log("logging cuisine passed to modal");
		$scope.currentCuisine = cuisine;
		$scope.newCuisineReview = {
			    "cuisineCommentDesc": "",
			    "cuisine": {"cuisine_ID": cuisine.cuisine_ID }
		}
		console.log("new comment :"+ $scope.newCuisineReview.cuisineCommentDesc);
		console.log("cuisine id: "+ $scope.newCuisineReview.cuisine.cuisine_ID);
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
});