import java.util.ArrayList;


public class Journal {

	private Location location;
	private ArrayList<Volume> volumeCollection;
	
	/**
	 * The default constructor for the class
	 */
	public Journal() { }
	
	/**
	 * The preferred constructor for the class
	 */
	public Journal(Location newLocation, ArrayList<Volume> newVolumeCollection)
	{
		
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
