import java.io.Serializable;


public class Location implements Serializable{

	private static final long serialVersionUID = 3407614860934296952L;
	private String cityName;
	private String stateOrProvince;
	private String country;
	
	/**
	 * Default constuctor for the class
	 */
	public Location() { }
	
	/**
	 * Preferred constructor for the class
	 * @param city The name of the City
	 * @param state The state or province
	 * @param country The country
	 */
	public Location(String city, String state, String country)
	{
		cityName = city;
		stateOrProvince = state;
		this.country = country;
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
