import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class ConferencePaper extends Paper implements Serializable
{
	private static final long serialVersionUID = 8507820325335680360L;

	private Conference conferenceReference;
	
	/**
	 * Default constructor for the class.
	 */
	public ConferencePaper() {}
	
	/**
	 * Inherits from the Paper class.
	 * Creates a ConferencePaper Object
	 * @param newConferenceReference Reference to the conference the paper was published at
	 * @param newAuthors Authors of the paper in the format Last, First Middle; Last, First Middle; etc.
	 * @param newTitle Title of the paper.
	 * @param newPageRange Page range specified in the file.
	 * @param newDOI Digital Object Identifier for the paper.
	 */
	public ConferencePaper(Conference newConferenceReference, ArrayList<Scholar> newAuthors, String newTitle, String newPageRange, String newDOI)
	{
		conferenceReference = newConferenceReference;
		for(Scholar eachScholar: newAuthors)
			addAuthor(eachScholar);
		setTitle(newTitle);
		setPageRange(newPageRange);
		setDOI(newDOI);
	}
	
	/**
	 * @return The conference this paper was published at
	 */
	public Conference getConference()
	{
		return conferenceReference;
	}
	
}
