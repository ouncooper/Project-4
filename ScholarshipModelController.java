import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class ScholarshipModelController {
	
	private ScholarshipModel model;
	private ScholarshipModelSelectionView selectionView;
	private ArrayList<ScholarshipModelDisplayView> displayView;
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModelController() { }
	
	/**
	 * @param newModel Model to set
	 */
	public void setModel(ScholarshipModel newModel){
		model = newModel;
	}
	
	/**
	 * @param newView View to set
	 */
	public void setSelectionView(ScholarshipModelSelectionView newView){
		selectionView = newView;
		selectionView.getAddScholarButton().addActionListener(new addScholarButtonActionListener());
		selectionView.getDeleteScholarButton().addActionListener(new deleteScholarButtonActionListener());
		selectionView.getDeleteAllScholarsButton().addActionListener(new deleteAllScholarsButtonActionListener());
		selectionView.getAddSerialButton().addActionListener(new addSerialButtonActionListener());
		selectionView.getDeleteSerialButton().addActionListener(new deleteSerialButtonActionListener());
		selectionView.getDeleteAllSerialsButton().addActionListener(new deleteAllSerialsButtonActionListener());
		selectionView.getAddPaperButton().addActionListener(new addPaperButtonActionListener());
		selectionView.getDeletePaperButton().addActionListener(new deletePaperButtonActionListener());
		selectionView.getDeleteAllPapersButton().addActionListener(new deleteAllPapersButtonActionListener());
		selectionView.getOpenMenuItem().addActionListener(new openActionListener());
		selectionView.getSaveMenuItem().addActionListener(new saveActionListener());
		selectionView.getPlotCPPY().addActionListener(new CPPYActionListener());
		selectionView.getPlotJAPY().addActionListener(new JAPYActionListener());
		selectionView.getPlotNCAPP().addActionListener(new NCAPPActionListener());
		selectionView.getPlotPPY().addActionListener(new PPYActionListener());
		selectionView.getPlotTOP().addActionListener(new TOPActionListener());
	}
	
	/**
	 * Adds a new display view
	 */
	public void addDisplayView(ScholarshipModelDisplayView newDisplayView){
		//TODO
		displayView.add(newDisplayView);
	}
	
	
	//************************************
	public class addScholarButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//pop up and prompt the user for input
			String scholarName = (String)JOptionPane.showInputDialog(null, "Please Enter the Scholar's Name", "Author Name", JOptionPane.QUESTION_MESSAGE, null, null, "First Middle Last");
			String affiliation = (String)JOptionPane.showInputDialog(null, "Please Enter the Scholar's Affiliations (delimited by semi-colons)", "Affiliations", JOptionPane.QUESTION_MESSAGE, null, null, "Affiliation 1; Affiliation 2");
			String researchAreas = (String)JOptionPane.showInputDialog(null, "Please Enter the Scholar's Research areas (delimited by semi-colons)", "Research Areas", JOptionPane.QUESTION_MESSAGE, null, null, "Area 1; Area 2");
			model.addScholar(new Scholar(scholarName, new ArrayList<String>(Arrays.asList(affiliation.split(";"))), new ArrayList<String>(Arrays.asList(researchAreas.split(";"))), null, null));
			selectionView.deleteScholarsButtonSetEnabled(true);
			selectionView.addSerialButtonSetEnabled(true);
			
			//Debugging
			System.out.println(scholarName);
			System.out.println(affiliation);
			System.out.println(researchAreas);
		}
	}
	public class deleteScholarButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			Object[] options = {"No, Don't Delete", "Yes, Delete!"};
			if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete all the scholars?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
				//Get the selected value and remove it
				System.out.println("Attempt to remove scholar:");
				System.out.println(selectionView.getScholarsList().getSelectedValue().toString());
				model.removeScholar(selectionView.getScholarsList().getSelectedValue().toString());
				if(model.getScholars().isEmpty()){
					selectionView.deleteScholarsButtonSetEnabled(false);
					selectionView.addSerialButtonSetEnabled(false);
				}
			}
		}
	}
	public class deleteAllScholarsButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete all scholarship data
			Object[] options = {"No, Don't Delete", "Yes, Delete!"};
			if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete all the scholars?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
				//Get the selected value and remove it
				System.out.println("Attempt to remove all scholars");
				model.removeAllScholars();
				selectionView.deleteScholarsButtonSetEnabled(false);
				selectionView.addSerialButtonSetEnabled(false);
			}
		}
	}
	public class addSerialButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//pop up and prompt the user for input
		}
	}
	public class deleteSerialButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete the selected serial and its data
		}
	}
	public class deleteAllSerialsButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete all serials
		}
	}
	public class addPaperButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//pop up and prompt the user for input
		}
	}
	public class deletePaperButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete the selected paper
		}
	}
	public class deleteAllPapersButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete all papers
		}
	}
	public class openActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Open file was pressed
			System.out.println("works");
		}
	}
	public class saveActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Save file was pressed
			
		}
	}
	public class TOPActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Plot type of publication was pressed
			
		}
	}
	public class PPYActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Plot Papers per year was pressed
			
		}
	}
	public class CPPYActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Plot Conference papers per year was pressed
			
		}
	}
	public class JAPYActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Plot journal articles per year was pressed
			
		}
	}
	public class NCAPPActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Plot number of co-authors per publication was pressed
			
		}
	}
	
	
}
