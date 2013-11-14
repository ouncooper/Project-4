import java.util.ArrayList;


public class Conference extends ScholarOrganization{
	
	private ArrayList<Meeting> meetingCollection;
	
	/**
	 * Default constructor for the class
	 */
	public Conference() { }
	
	/**
	 * Preferred constructor for the class
	 * @param newMeetingCollection Meetings at the conference
	 * @param organizationName The name of the organization
	 */
	public Conference(ArrayList<Meeting> newMeetingCollection, String organizationName){
		meetingCollection = newMeetingCollection;
		this.setName(organizationName);
	}
	
	/**
	 * @return Meetings at the conference
	 */
	public ArrayList<Meeting> getMeetingCollection(){
		return meetingCollection;
	}
}
