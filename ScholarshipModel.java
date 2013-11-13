import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ScholarshipModel {

	private ArrayList<Scholar> scholars;
	private ArrayList<ScholarOrganization> scholarOrganizations;
	private ArrayList<ActionListener> actionListenerList;
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModel() { }
	
	/**
	 * Adds an actionListner to the ArrayList to be called on changes.
	 * @param actionListener New ActionListener to add
	 */
	public void addActionListener(ActionListener al)
	{
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();
		actionListenerList.add(al);
	}
	
	/**
	 * Removes an actionListener from the ArrayList.
	 * @param actionListener ActionListener to remove
	 */
	public void removeActionListener(ActionListener al)
	{
		if (actionListenerList.contains(al))
			actionListenerList.remove(al);
	}
	
	/**
	 * Imports data from a specified file
	 * @param filepath Filepath to import from
	 */
	public void importData(String filepath)
	{
		
	}
	
	/**
	 * Loads data from a specified file
	 * @param filepath Filepath to load from
	 */
	public void loadData(String filepath)
	{
		
	}
	
	/**
	 * Appends new data into the specified file
	 * @param filepath Filepath to append to
	 */
	public void enterNewData(String filepath)
	{
		
	}
	
	/**
	 * Exports data to a specified file
	 * @param filepath Filepath to export to
	 */
	public void exportData(String filepath)
	{
		
	}
	
	/**
	 * Saves data to a specified file
	 * @param filepath Filepath to save to
	 */
	public void saveData(String filepath)
	{
	
	}

	public ArrayList<Scholar> getScholars() {
		return null; //Necessary for junit
	}
}
