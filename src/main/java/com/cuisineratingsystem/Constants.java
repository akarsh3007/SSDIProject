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
			public static final String GetSingleRestaurant = "/api/restaurants/{restid}";
		}
		
		public class Cuisine
		{
			public static final String GetAllCuisineOfRestaurant = "/api/cuisines/{restid}";
			public static final String CuisineSearch = "/api/cuisines/search";
			public static final String GetAllReviewsOfCuisine = "/api/cuisinereviews/{cuisineid}";
		}
		
		public class Dish
		{
			public static final String GetAllDishofRestaurant = "/api/dishes/{cuisineid}";
			public static final String CuisineSearch = "/api/dishes/search";
			public static final String GetAllReviewsOfDish = "/api/cuisinereviews/{dishid}";
		}
	}
}
