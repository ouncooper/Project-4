import java.util.ArrayList;


public class Journal extends ScholarOrganization{

	private Location location;
	private ArrayList<Volume> volumeCollection;
	
	/**
	 * The default constructor for the class
	 */
	public Journal() { }
	
	/**
	 * The preferred constructor for the class
	 */
	public Journal(Location newLocation, ArrayList<Volume> newVolumeCollection, String organizationName)
	{
		location = newLocation;
		volumeCollection = newVolumeCollection;
		this.setName(organizationName);
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public ArrayList<Volume> getVolumeCollection()
	{
		return volumeCollection;
	}
}
