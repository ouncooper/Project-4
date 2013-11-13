import java.util.ArrayList;


public class Conference {
	
	private ArrayList<Meeting> meetingCollection;
	
	/**
	 * Default constructor for the class
	 */
	public Conference() { }
	
	/**
	 * Preferred constructor for the class
	 * @param newMeetingCollection Meetings at the conference
	 */
	public Conference(ArrayList<Meeting> newMeetingCollection){
		meetingCollection = newMeetingCollection;
	}
	
	/**
	 * @return Meetings at the conference
	 */
	public ArrayList<Meeting> getMeetingCollection(){
		return meetingCollection;
	}
}
