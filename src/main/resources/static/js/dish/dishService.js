app.service('dishService',function($http){
	
	
	this.saveRatingForDish = function(dish_ID,rating,no_of_raters){

		console.log(dish_ID);
		var req = {
				method : 'POST',
				url : 'http://localhost:8080/api/dishes/updatedishrating',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : {
					dish_ID : dish_ID,
					rating : rating,
					no_of_raters : no_of_raters
				}
		}

		$http(req).then(
				function(response) {

					if (response.status == 200) {

						console.log("update Successful");
						swal('Update Successful','','success');
						
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
	
	this.saveReviewFunction = function(dish,dish_comment_desc){
		
		var req = {
				method : 'POST',
				url : 'http://localhost:8080/api/dishreview',
				headers : {
					'Content-Type' : 'application/json'
				},
				data : {
					dish : dish.dish_ID,
					dishCommentDesc : dish_comment_desc
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
