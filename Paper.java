import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Paper implements Serializable
{	
	private static final long serialVersionUID = -8913776819739550541L;
	
	/* A variable to store the authors of the paper.*/
	private ArrayList<Scholar> authors = new ArrayList<Scholar>();
	/* A variable to store the title of the paper.*/
	private String title;
	/* A variable to store the pages the paper is on.*/
	private String pageRange;
	/* A variable to store the digital object identifier of the paper.*/
	private String DOI;
	/* A variable to store the year published*/
	private int year;
	
	/**
	 * Default constructor.
	 */
	public Paper() {}

	/**
	 * @return the authors of the paper
	 */
	public ArrayList<Scholar> getAuthors() {
		return authors;
	}

	/**
	 * @param the authors of the paper
	 */
	public void addAuthor(Scholar author) {
		authors.add(author);
	}

	public void removeAuthor(Scholar author) {
		authors.remove(author);
	}
	/**
	 * @return the title of the paper
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param the title of the paper
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pages the paper is found on in the format "start-end"
	 */
	public String getPageRange() {
		return pageRange;
	}

	/**
	 * @param the pages the paper is found on in the format "start-end"
	 */
	public void setPageRange(String pageRange) {
		this.pageRange = pageRange;
	}

	/**
	 * @return the digital object identifier of the paper
	 */
	public String getDOI() {
		return DOI;
	}

	/**
	 * @param the digital object identifier of the paper
	 */
	public void setDOI(String DOI) {
		this.DOI = DOI;
	}
	
	public void setYear(int year){
		this.year = year;
	}
}
