import java.util.ArrayList;


public class Meeting {
	
	private int month;
	private int year;
	private Location location;
	private ArrayList<Scholar> programChairs;
	private ArrayList<Scholar> committeeMembers;
	private ArrayList<Paper> papersPublished;
	
	/**
	 * Default constructor for the class
	 */
	public Meeting() { }
	
	/**
	 * Preferred constructor for the class
	 * @param newMonth Month of the meeting
	 * @param newYear Year of the meeting
	 * @param newLocation Location of the meeting
	 * @param newProgramChairs Chairs of the meeting
	 * @param newCommitteeMembers Committee of the meeting
	 * @param newPapersPublished Papers published at the meeting
	 */
	public Meeting(int newMonth, int newYear, Location newLocation, ArrayList<Scholar> newProgramChairs, ArrayList<Scholar> newCommitteeMembers, ArrayList<Paper> newPapersPublished)
	{
		month = newMonth;
		year = newYear;
		location = newLocation;
		programChairs = newProgramChairs;
		committeeMembers = newCommitteeMembers;
		papersPublished = newPapersPublished;
	}
	
	/**
	 * @return Month of the meeting
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * @return Year of the meeting
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * @return Location of the meeting
	 */
	public Location getLocation()
	{
		return location;
	}
	
	/**
	 * @return Chairs of the meeting
	 */
	public ArrayList<Scholar> getChairs()
	{
		return programChairs;
	}
	
	/**
	 * @return Committee of the meeting
	 */
	public ArrayList<Scholar> getCommittee()
	{
		return committeeMembers;
	}
	
	/**
	 * @return Papers published at the meeting
	 */
	public ArrayList<Paper> getPapersPublished()
	{
		return papersPublished;
	}
	
	public void removeProgramChair(Scholar input){
		programChairs.remove(input);
	}
	
	public void removeCommitteeMember(Scholar input){
		committeeMembers.remove(input);
	}
}
