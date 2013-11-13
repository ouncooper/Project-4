import java.util.ArrayList;


public class Scholar {

	private String primaryName;
	private String secondaryName;
	private ArrayList<String> affiliations;
	private ArrayList<String> researchAreas;
	private ArrayList<Paper> paperList;
	private ArrayList<ScholarOrganization> scholarlyEfforts;
	
	/**
	 * Default constructor for the class.
	 */
	public Scholar() { }
	
	/**
	 * Preferred constructor for the class.
	 * @param name Name of the scholar in last, first middle or first middle last format
	 * @param newAffiliations Affiliations the scholar has
	 * @param newResearchAreas Research areas the scholar has been a part of
	 * @param newPaperList List of papers written by the scholar
	 * @param newScholarlyEfforts List of organizations the scholar is a part of
	 */
	public Scholar(String name, ArrayList<String> newAffiliations, ArrayList<String> newResearchAreas, ArrayList<Paper> newPaperList, ArrayList<ScholarOrganization> newScholarlyEfforts)
	{
		String[] nameParts = name.split(" ");
		if(nameParts[0].endsWith(",")){	//Must be last, first middle format
			primaryName = nameParts[0].split(",")[0];
			secondaryName = nameParts[1] + " " + nameParts[2];
		}
		else{	//Must be first middle last format
			primaryName = nameParts[2];
			secondaryName = nameParts[0] + " " + nameParts[1];
		}
		affiliations = newAffiliations;
		researchAreas = newResearchAreas;
		paperList = newPaperList;
		scholarlyEfforts = newScholarlyEfforts;
	}
	
	
	public String getPrimaryName(){ return primaryName;}
	public String getSecondaryName(){ return secondaryName;}
	public ArrayList<String> getAffiliations(){ return affiliations;}
	public ArrayList<String> getResearchAreas(){ return researchAreas;}
	public ArrayList<Paper> getPaperList(){ return paperList;}
	public ArrayList<ScholarOrganization> getScholarlyEfforts(){ return scholarlyEfforts;}
}
