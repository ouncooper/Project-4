import java.io.Serializable;
import java.util.Comparator;

public class JournalArticle extends Paper implements Serializable, Comparator<Paper>
{
	private static final long serialVersionUID = 3324219143415691342L;
	
	/* A variable to store the volume and issue of the article. */
	private String volumeIssue;
	private Journal journalReference;
	
	/**
	 * Default constructor for the class.
	 */
	public JournalArticle() {}
	
	/**
	 * Inherits from the Paper class.
	 * Creates a JournalArticle Object
	 * @param newName Name of the paper ("Journal Article").
	 * @param newAuthors Authors of the paper in the format Last, First Middle; Last, First Middle; etc.
	 * @param newTitle Title of the paper.
	 * @param newSerialTitle Serial title of the paper.
	 * @param newDate Date the paper was published.
	 * @param newVolumeIssuePageRange Volume, issue, and page range specified in the file.  Split into two variables.
	 * @param newDOI Digital Object Identifier for the paper.
	 **/
	public JournalArticle(Journal newJournal, String newName, String newAuthors, String newTitle, String newSerialTitle, String newVolumeIssuePageRange, String newDate, String newDOI)
	{
		setName(newName);
		for(String author: newAuthors.split("; "))
			addAuthor(author);
		setTitle(newTitle);
		setSerialTitle(newSerialTitle);
		volumeIssue = newVolumeIssuePageRange.split(":")[0];
		setPageRange(newVolumeIssuePageRange.split(":")[1]);
		setDate(newDate);
		setDOI(newDOI);
	}
	
	/**
	 * Gets the volume and issue of the Journal article
	 * @return a string containing the volume and issue in the format "volume(issue)"
	 */
	public String getVolumeIssue() {
		return volumeIssue;
	}
	
	/**
	 * @return The journal this article was published in
	 */
	public Journal getJournal()
	{
		return journalReference;
	}
	
	/**
	 * Converts the object to a string separated by " // "
	 */
	public String toString()
	{
		return "";
	}

	/**
	 * Compares one paper to another
	 */
	@Override
	public int compare(Paper o1, Paper o2) {
		return 0;
	}
}
