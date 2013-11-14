import java.io.Serializable;
import java.util.ArrayList;


public class Volume implements Serializable{

	private static final long serialVersionUID = 3293466092240848663L;
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
