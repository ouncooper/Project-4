
public class Driver {
	private ScholarshipModel myModel;
	private ScholarshipModelSelectionView selectionView = new ScholarshipModelSelectionView();
	//private ScholarshipModelDisplayView selectionView = new ScholarshipModelSelectionView();
	
	private ScholarshipModelController myController = new ScholarshipModelController();
	
	public static void main(String[] args)
	{
		new Driver();
		
		//ScholarshipModelSelectionView selectionView = new ScholarshipModelSelectionView();
		//Initialize components, get everything going
	}
	public Driver(){
		myModel = new ScholarshipModel();
		selectionView.setModel(myModel);
		myController.setModel(myModel);
		myController.setSelectionView(selectionView);
	}
}
