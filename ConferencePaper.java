import java.io.Serializable;
import java.util.Comparator;

public class ConferencePaper extends Paper implements Serializable, Comparator<Paper>
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
	 * @param newName Name of the paper ("Conference Paper").
	 * @param newAuthors Authors of the paper in the format Last, First Middle; Last, First Middle; etc.
	 * @param newTitle Title of the paper.
	 * @param newSerialTitle Serial title of the paper.
	 * @param newDate Date the paper was published.
	 * @param newPageRange Page range specified in the file.
	 * @param newDOI Digital Object Identifier for the paper.
	 */
	public ConferencePaper(Conference newConferenceReference, String newAuthors, String newTitle, String newPageRange, String newDOI)
	{
		conferenceReference = newConferenceReference;
		for(String author:newAuthors.split("; "))
			addAuthor(author);
		setTitle(newTitle);
		setPageRange(newPageRange);
		setDOI(newDOI);
	}
	
	/**
	 * Converts the object to a string separated by " // "
	 */
	public String toString()
	{
		return "";
	}

	/**
	 * @return The conference this paper was published at
	 */
	public Conference getConference()
	{
		return conferenceReference;
	}
	
	/**
	 * Compares one paper to another.
	 */
	@Override
	public int compare(Paper o1, Paper o2) {
		return 0;
	}
}
