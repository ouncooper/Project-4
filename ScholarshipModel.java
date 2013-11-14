import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


public class ScholarshipModel implements Serializable{

	
	private static final long serialVersionUID = -4692275818772626767L;
	private ArrayList<Scholar> scholars = new ArrayList<Scholar>();
	private ArrayList<ScholarOrganization> scholarOrganizations = new ArrayList<ScholarOrganization>();
	private ArrayList<Paper> papers = new ArrayList<Paper>();
	
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
	 * Saves data to a specified file
	 * @param filepath Filepath to save to
	 */
	public void saveData(String filepath)
	{
	
	}

	public ArrayList<Scholar> getScholars() { return scholars;}
	public ArrayList<ScholarOrganization> getSerials(){ return scholarOrganizations;}
	public ArrayList<Paper> getPapers(){ return papers;}
	
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
			//Go through each paper and remove the scholar
			ArrayList<Paper> papersToRemove = new ArrayList<Paper>();
			for(Paper eachPaper: papers){
				eachPaper.removeAuthor(s);
				//If that paper doesn't have an author anymore, remove it
				if(eachPaper.getAuthors().isEmpty())
					papersToRemove.add(eachPaper);
			}
			for(Paper eachPaperToRemove: papersToRemove)
				papers.remove(eachPaperToRemove);
			
			//Go through each serial and remove the scholar
			ArrayList<ScholarOrganization> serialsToRemove = new ArrayList<ScholarOrganization>();
			for(ScholarOrganization eachSerial: scholarOrganizations){
				if(eachSerial instanceof Conference){
					for(Meeting eachMeeting: ((Conference) eachSerial).getMeetingCollection()){
						eachMeeting.removeProgramChair(s);
						eachMeeting.removeCommitteeMember(s);
						
						//If this serial doesn't have a program chair or committee member anymore, remove it
						if(eachMeeting.getChairs().isEmpty() || eachMeeting.getCommittee().isEmpty())
							serialsToRemove.add(eachSerial);
					}
				}
				if(eachSerial instanceof Journal){
					for(Volume eachVolume: ((Journal) eachSerial).getVolumeCollection()){
						for(Issue eachIssue: eachVolume.getIssueCollection()){
							eachIssue.removeEditor(s);
							eachIssue.removeReviewer(s);
							
							//If this Serial doesn't have an editor or reviewer member anymore, remove it
							if(eachIssue.getEditors().isEmpty() || eachIssue.getReviewers().isEmpty())
								serialsToRemove.add(eachSerial);
						}
					}
				}
			}
			for(ScholarOrganization eachSerialToRemove: serialsToRemove)
				scholarOrganizations.remove(eachSerialToRemove);
			
			scholars.remove(s);
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove Scholar"));
		}
	}
	public void removeAllScholars(){
		scholars.clear();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove All Scholars"));
	}
	public void addSerial(ScholarOrganization input){
		scholarOrganizations.add(input);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Add Serial"));
	}
	public void removeSerial(String name){
		ScholarOrganization s = null;
		
		//Find the serial by name and then remove it
		for(ScholarOrganization eachSerial: scholarOrganizations)
			if(eachSerial.getName().equalsIgnoreCase(name))
				s = eachSerial;
		
		if(s != null){
			scholarOrganizations.remove(s);
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove Serial"));
		}
	}
	public void removeAllSerials(){
		scholarOrganizations.clear();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove All Serials"));
	}
	public void addPaper(Paper input){
		papers.add(input);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Add Paper"));
	}
	public void removePaper(String title){
		Paper s = null;
		
		//Find the paper by title and then remove it
		for(Paper eachPaper: papers)
			if((eachPaper.getTitle().equalsIgnoreCase(title)))
				s = eachPaper;
		
		if(s != null){
			papers.remove(s);
			processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove Paper"));
		}
	}
	public void removeAllPapers(){
		papers.clear();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Remove All Papers"));
	}
	
	private void processEvent(ActionEvent e){
		//Go through each action listener and tell them that something changed
		for(int i = 0; i < actionListenerList.size(); i++)
			actionListenerList.get(i).actionPerformed(e);
	}
	
	public void setScholars(ArrayList<Scholar> input){
		scholars = input;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
	}
	public void setSerials(ArrayList<ScholarOrganization> input){
		scholarOrganizations = input;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
	}
	public void setPapers(ArrayList<Paper> input){
		papers = input;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
	}
}
