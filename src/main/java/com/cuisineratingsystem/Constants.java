package com.cuisineratingsystem;

public class Constants {

	public class SessionVariables
	{
		public final static String firstName = "firstName";
		public final static String lastName = "lastName";
		public final static String email = "email";
		public final static String contactNo = "contactNo";
	}
	
	public class APIPath
	{
		public class Restaurant
		{
			public static final String GetAllRestaurants = "/api/restaurants";
			public static final String GetRestaurantById = "/api/restaurants/{restid}";
		}
		
		public class Cuisine
		{
			public static final String CuisineSearch = "/api/cuisines/search";
			public static final String GetAllReviewsOfCuisine = "/api/cuisinereviews/{cuisineid}";
			public static final String GetAllCuisines = "/api/cuisines";
			public static final String GetCuisineById = "/api/cuisines/{id}";
			public static final String GetAllCuisinesByRestaurantId = "/api/cuisines/restaurants/{restid}";
			public static final String UpdateCuisineRating = "/api/cuisines/updatecuisinerating";
		}
		
		public class Dish
		{
			public static final String GetAllDishofRestaurant = "/api/dishes/{cuisineid}";
			public static final String CuisineSearch = "/api/dish/search";
			public static final String GetAllReviewsOfDish = "/api/cuisinereviews/{dishid}";
			public static final String GetAllDishes = "/api/dishes";
			public static final String UpdateDishRating = "/api/dishes/updatedishrating";
		}
		
		public class CuisineReview
		{
			public static final String AddCuisineReview = "/api/cuisinereview";
			public static final String GetCuisineReviewById = "api/cuisinereview/{id}";
		}
		
		public class DishReview 
		{
			public static final String AddDishReview = "/api/dishreview";
		}
	}
}
