app.service('cuisineService',function($http,$timeout){
	
	this.getCuisinesDishes = function(){
		return $http({
        	url: "http://localhost:8080/api/restaurants/1",
        	method: "GET",
          	headers: { "Accept": "application/json" },
    });
	}
	
	this.saveRatingFunction = function(cuisine_ID,rating,no_of_raters){
         console.log('id---'+cuisine_ID);
         console.log('rating---'+rating);
         console.log('no_of_raters---'+no_of_raters);
		var req = {
				method : 'POST',
				url : 'http://localhost:8080/updateCuisineRating',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : {
					cuisine_ID : cuisine_ID,
					rating : rating,
					no_of_raters : no_of_raters
				}
		}

		$http(req).then(
				function(response) {

					if (response.status == 200) {

						console.log("update Successful");
						//swal('Update Successful','','success');
						$timeout(function(){
							//$window.location.href="/html/login.html";
						},3000)

					} else {
						console.log("Error: "
								+ response.data.statusText);
					}
				},
				function(response) {

					if(typeof response.data.message === 'undefined')
						console.log("Error: " + response.statusText);
					else
						console.log("Error: " + response.data.message);
				});


	}
	
	this.saveReviewForCuisine = function(cuisine, cuisine_comment_desc){
		var req = {
				method : 'POST',
				url : 'http://localhost:8080/addCuisineReview',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : {
					cuisine : cuisine.cuisine_ID,
					cuisineCommentDesc : cuisine_comment_desc
				}
		}

		$http(req).then(
				function(response) {

					if (response.status == 200) {

						console.log("review added Successfully");
						/*swal('Update Successful','','success');*/
						
					} else {
						console.log("Error: "
								+ response.data.statusText);
					}
				},
				function(response) {

					if(typeof response.data.message === 'undefined')
						console.log("Error: " + response.statusText);
					else
						console.log("Error: " + response.data.message);
				});
	}
});
