import java.io.Serializable;
import java.util.ArrayList;


public class Journal extends ScholarOrganization implements Serializable{

	private static final long serialVersionUID = 381167438674763534L;
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
	
	/**
	 * 
	 * @return The location of the journal publisher
	 */
	public Location getLocation()
	{
		return location;
	}
	
	/**
	 * 
	 * @return The volume of issues
	 */
	public ArrayList<Volume> getVolumeCollection()
	{
		return volumeCollection;
	}
}
