import java.util.ArrayList;


public class Volume {

	private ArrayList<Issue> issueCollection;
	
	/**
	 * Default constructor for the class
	 */
	public Volume() { }
	
	/**
	 * Preferred constructor for the class
	 * @param newIssueCollection List of issues for the volume
	 */
	public Volume(ArrayList<Issue> newIssueCollection)
	{
		issueCollection = newIssueCollection;
	}
	
	public ArrayList<Issue> getIssueCollection()
	{
		return issueCollection;
	}
}
