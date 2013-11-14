import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class JournalArticle extends Paper implements Serializable
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
	 * @param newJournal Reference to the journal the article is published in
	 * @param newAuthors Authors of the paper in the format Last, First Middle; Last, First Middle; etc.
	 * @param newTitle Title of the paper.
	 * @param newVolumeIssue volume and issue
	 * @param newPageRange page range of the article
	 * @param newDOI Digital Object Identifier for the paper.
	 **/
	public JournalArticle(Journal newJournal, ArrayList<Scholar> newAuthors, String newTitle, String newVolumeIssue, String newPageRange, String newDOI, int newYear)
	{
		journalReference = newJournal;
		for(Scholar eachScholar: newAuthors)
			addAuthor(eachScholar);
		setTitle(newTitle);
		volumeIssue = newVolumeIssue;
		setPageRange(newPageRange);
		setDOI(newDOI);
		setYear(newYear);
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

}
