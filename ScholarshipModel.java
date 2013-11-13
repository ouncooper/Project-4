import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class ScholarshipModel {

	private ArrayList<Scholar> scholars = new ArrayList<Scholar>();
	private ArrayList<ScholarOrganization> scholarOrganizations;
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModel() { }
	
	/**
	 * Adds an actionListner to the ArrayList to be called on changes.
	 * @param actionListener New ActionListener to add
	 */
	public void addActionListener(ActionListener actionListener){
		actionListenerList.add(actionListener);
	}
	
	/**
	 * Removes an actionListener from the ArrayList.
	 * @param actionListener ActionListener to remove
	 */
	public void removeActionListener(ActionListener actionListener){
		actionListenerList.remove(actionListener);
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

	public ArrayList<Scholar> getScholars() { return scholars;}
	
	public void addScholar(Scholar input){
		scholars.add(input);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Add Scholar"));
	}
	
	/**
	 * Removes a specific scholar
	 * @param name The name of the scholar in the form first middle last
	 */
	public void removeScholar(String name){
		Scholar s = null;
		
		//Find the scholar by name and then remove it
		for(Scholar eachScholar: scholars)
			if((eachScholar.getSecondaryName() + " " + eachScholar.getPrimaryName()).equalsIgnoreCase(name))
				s = eachScholar;
		
		if(s != null){
			scholars.remove(s);
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove Scholar"));
		}
	}
	
	public void removeAllScholars(){
		scholars.clear();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove All Scholars"));
	}
	
	private void processEvent(ActionEvent e){
		//Go through each action listener and tell them that something changed
		for(int i = 0; i < actionListenerList.size(); i++)
			actionListenerList.get(i).actionPerformed(e);
	}
