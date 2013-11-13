
public class Location {
	private String cityName;
	private String stateOrProvince;
	private String country;
	
	/**
	 * Default constuctor for the class
	 */
	public Location() { }
	
	/**
	 * Preferred constructor for the class
	 */
	public Location(String city, String state, String country)
	{
		
	}
	
	/**
	 * @return The name of the city
	 */
	public String getCityName()
	{
		return cityName;
	}
	
	/**
	 * @return Name of the State or Province
	 */
	public String getStateOrProvince()
	{
		return stateOrProvince;
	}
	
	/**
	 * @return The name of the country
	 */
	public String getCountry()
	{
		return country;
	}
}
