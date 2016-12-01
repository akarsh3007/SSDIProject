app.service('mapsService',function(){

	this.createMapDataString = function(rest_name,city,zipcode)
	{
		var strData = "";
		var arrOfRest = rest_name.split(' ');
		for(i=0; i< arrOfRest.length;i++)
			{
				strData = strData + arrOfRest[i] + "+";
			}
		
		strData = strData + "," + city + "+" + zipcode;
		return strData;
	}
	
});