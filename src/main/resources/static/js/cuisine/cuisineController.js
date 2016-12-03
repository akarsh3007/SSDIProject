app.controller('cuisineController',function($scope,$stateParams,$timeout,$mdDialog,cuisineService,dishService,restaurant){
	$scope.restaurantDetail= restaurant.data;
	currentUser = $scope.$root.user.fullName;
	
		function addRating(cuisine, newRating){
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
							
							cuisine.rating = latestRatingc;
							cuisine.no_of_raters = totalRatersc;
							swal('Thanks for your Rating. Rating Added.','','success');
							$mdDialog.hide();
						}
					else
						{
						  $mdDialog.hide();
							swal('There was some error adding your rating','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
		
	}
	$scope.getCuisines = function(){
		//var id = $stateParams.restId;//cuisineService.GetQueryStringParameter("id");
		cuisineService.getCuisinesDishes(id).then(function (data, status, headers, config) {
			$scope.restaurantDetail=data.data;
			console.log($scope.restaurantDetail);
        },
        function (data, status, headers, config) {
            console.log("Error " + status);
        });
	}
	//$scope.getCuisines();
	
	
	 function saveCuisineReview(cuisineReview){
		console.log('newReview---------'+cuisineReview)
		cuisineService.saveReviewForCuisine(cuisineReview).then(
				function (data, status, headers, config) {    
					if(data)
						{
						 	$mdDialog.hide();
						 	$scope.selectedCuisine.cuisineReviews.push(cuisineReview);
							swal('Thanks for your review. Review Added.','','success');
						}
					else
						{
						 $mdDialog.hide();
							swal('There was some error adding your review','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
	}
	 
	 function addRatingToDish(dish,selectedRating){
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
						$mdDialog.hide();
							dish.rating = latestRating;
							dish.no_of_raters = totalRaters;
							swal('Thanks for your Rating. Rating Added.','','success');
						}
					else
						{
						$mdDialog.hide();
							swal('There was some error adding your rating','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
		$scope.hide();
	}
	
	 function saveDishReview(newDishReview){
		dishService.saveReviewFunction(newDishReview).then(
				function (data, status, headers, config) {    
					if(data)
						{
						 $mdDialog.hide();
						 $scope.selectedDish.dishReviews.push(newDishReview);
						 swal('Thanks for your review. Review Added.','','success');
						}
					else
						{
						 $mdDialog.hide();
							swal('There was some error adding your review','','error');
						}
					
	            },
	            function (data, status, headers, config) {
	                console.log("Error " + status);
	            });
	}
	
	$scope.addCuisineReviews = function(ev,cuisine) {
		$scope.selectedCuisine = cuisine ;
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'html/writeCuisineReviews.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      locals:{
		    	  cuisine:cuisine
		      },
		      fullscreen: $scope.customFullscreen 
		    })
		  };

	 $scope.showCuisineReviews = function(ev,cuisine) {
		 $mdDialog.show({
		      controller: DialogController,
		      templateUrl: 'html/reviews.tmpl.html',
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
		      templateUrl: 'html/rating.tmpl.html',
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
				      templateUrl: 'html/dishReviews.tmpl.html',
				      parent: angular.element(document.body),
				      targetEvent: ev,
				      clickOutsideToClose:true,
				      locals:{
				    	  dish:dish
				      },
				      fullscreen: $scope.customFullscreen 
				    })
				  };

			  $scope.addDishReviews = function(ev,dish,cuisineId) {
					dish.cuisine_ID = cuisineId;
					$scope.selectedDish = dish ;
				  $mdDialog.show({
					      controller: dishDialogController,
					      templateUrl: 'html/writeDishReviews.tmpl.html',
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
				      templateUrl: 'html/dishRating.tmpl2.html',
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
		$scope.currentCuisine.addRating = addRating;
		$scope.currentCuisine.saveCuisineReview = saveCuisineReview;
		$scope.newCuisineReview = {
			    "cuisineCommentDesc": "",
			    "userName": currentUser,
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
		$scope.currentDish.addRatingToDish = addRatingToDish;
		$scope.currentDish.saveDishReview = saveDishReview;
		$scope.newDishReview = {
			    "dishCommentDesc": "",
			    "userName": currentUser,
			    "dish": {"dish_ID": dish.dish_ID,
			    	"cuisine": {"cuisine_ID": dish.cuisine_ID }}
			    
		}
		$scope.hide = function() {
	      $mdDialog.hide();
	    };

	    $scope.cancel = function() {
	      $mdDialog.cancel();
	    };
	  }
	

});