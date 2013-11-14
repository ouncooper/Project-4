import java.util.ArrayList;


public class Issue {

	private int month;
	private int year;
	private ArrayList<Scholar> editors;
	private ArrayList<Scholar> reviewers;
	private ArrayList<Paper> articlesPublished;
	
	/**
	 * Default constructor for the class
	 */
	public Issue() { }
	
	/**
	 * Preferred constructor for the class
	 * @param newMonth Month the issue was published
	 * @param newYear Year the issue was published
	 * @param newEditors Editors of the issue
	 * @param newReviewers Reviewers of the issue
	 * @param newArticlesPublished List of articles published in the issue
	 */
	public Issue(int newMonth, int newYear, ArrayList<Scholar> newEditors, ArrayList<Scholar> newReviewers, ArrayList<Paper> newArticlesPublished)
	{
		month = newMonth;
		year = newYear;
		editors = newEditors;
		reviewers = newReviewers;
		articlesPublished = newArticlesPublished;
	}
	
	/**
	 * @return Month the issue was published
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * @return Year the issue was published
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * @return Editors of the issue
	 */
	public ArrayList<Scholar> getEditors()
	{
		return editors;
	}
	
	/**
	 * @return Reviewers of the issue
	 */
	public ArrayList<Scholar> getReviewers()
	{
		return reviewers;
	}
	
	/**
	 * @return Articles published in the issue
	 */
	public ArrayList<Paper> getArticlesPublished()
	{
		return articlesPublished;
	}
	
	public void removeEditor(Scholar input){
		editors.remove(input);
	}
	public void removeReviewer(Scholar input){
		reviewers.remove(input);
	}
}
