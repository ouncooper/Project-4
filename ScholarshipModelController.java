import java.util.ArrayList;


public class ScholarshipModelController {
	
	private ScholarshipModel model;
	private ScholarshipModelSelectionView selectionView;
	private ArrayList<ScholarshipModelDisplayView> displayView;
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModelController() { }
	
	/**
	 * Adds an actionListener to the controller
	 */
	public void addScholarshipActionListener()
	{
		
	}
	
	/**
	 * @param newModel Model to set
	 */
	public void setModel(ScholarshipModel newModel)
	{
		model = newModel;
	}
	
	/**
	 * @param newView View to set
	 */
	public void setSelection(ScholarshipModelSelectionView newView)
	{
		selectionView = newView;
	}
	
	/**
	 * Adds a new display view
	 */
	public void addDisplayView(ScholarshipModelDisplayView newDisplayView)
	{
		displayView.add(newDisplayView);
	}
	
}
