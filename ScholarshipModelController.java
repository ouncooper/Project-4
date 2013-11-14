import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
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
			if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete the scholars?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
				model.removeScholar(selectionView.getScholarsList().getSelectedValue().toString());
				if(model.getScholars().isEmpty()){
					selectionView.deleteScholarsButtonSetEnabled(false);
					selectionView.addSerialButtonSetEnabled(false);
					//Fire the deleteAllSerials Action Listener to delete all the serials
					ActionListener deleteAllSerials = new deleteAllSerialsButtonActionListener();
					deleteAllSerials.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Force Remove All Serials"));
				}
			}
		}
	}
	public class deleteAllScholarsButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete all scholarship data
			Object[] options = {"No, Don't Delete", "Yes, Delete!"};
			if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete all the scholars?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
				model.removeAllScholars();
				selectionView.deleteScholarsButtonSetEnabled(false);
				selectionView.addSerialButtonSetEnabled(false);
				//Fire the deleteAllSerials Action Listener to delete all the serials
				ActionListener deleteAllSerials = new deleteAllSerialsButtonActionListener();
				deleteAllSerials.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Force Remove All Serials"));
			}
		}
	}
	public class addSerialButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			Object[] options = {"Conference", "Journal"};
			
			ArrayList<Scholar> scholars = model.getScholars();
			String[] scholarNames = new String[scholars.size()];
			for(int i = 0; i < scholars.size(); i++)
				scholarNames[i] = (scholars.get(i).getSecondaryName() + " " + scholars.get(i).getPrimaryName());
			JList<String> scholarList = new JList<String>(scholarNames);
			
			String organizationName;
			String date;
			String location;
			ArrayList<Scholar> programChairs = new ArrayList<Scholar>();
			ArrayList<Scholar> committeeMembers = new ArrayList<Scholar>();
			ArrayList<Scholar> editors = new ArrayList<Scholar>();
			ArrayList<Scholar> reviewers = new ArrayList<Scholar>();
			
			
			if(0==JOptionPane.showOptionDialog(null, "Do you want to add a conference or journal?", "Conference or Journal?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0])){
				//conference
				organizationName = (String)JOptionPane.showInputDialog(null, "Please Enter the Organization's Name", "Organization Name", JOptionPane.QUESTION_MESSAGE, null, null, "TEDx");
				date = (String)JOptionPane.showInputDialog(null, "Please enter the date", "Month and Year", JOptionPane.QUESTION_MESSAGE, null, null, "03, 2011");
				location = (String)JOptionPane.showInputDialog(null, "Please Enter the Location", "Location", JOptionPane.QUESTION_MESSAGE, null, null, "Oklahoma City, OK, USA");
				JOptionPane.showMessageDialog(null, scholarList, "Select Program Chairs", JOptionPane.PLAIN_MESSAGE);
				for(int i = 0; i < scholarList.getSelectedIndices().length; i++)
					programChairs.add(scholars.get(scholarList.getSelectedIndices()[i]));
				JOptionPane.showMessageDialog(null, scholarList, "Select Committee Members", JOptionPane.PLAIN_MESSAGE);
				for(int i = 0; i < scholarList.getSelectedIndices().length; i++)
					committeeMembers.add(scholars.get(scholarList.getSelectedIndices()[i]));
				
				ArrayList<Meeting> meetingList = new ArrayList<Meeting>();
				
				int month = Integer.parseInt(date.split(", ")[0]);
				int year = Integer.parseInt(date.split(", ")[1]);
				Location loc = new Location(location.split(" ")[0], location.split(" ")[1], location.split(" ")[2]);
				meetingList.add(new Meeting(month, year, loc, programChairs, committeeMembers, new ArrayList<Paper>()));
				
				System.out.println("Month: " + month + " Year: " + year);
				model.addSerial(new Conference(meetingList, organizationName));
				selectionView.deleteSerialsButtonSetEnabled(true);
				selectionView.addPaperButtonSetEnabled(true);
				
			}else{
				//Journal
				organizationName = (String)JOptionPane.showInputDialog(null, "Please Enter the Organization's Name", "Organization Name", JOptionPane.QUESTION_MESSAGE, null, null, "TEDx");
				date = (String)JOptionPane.showInputDialog(null, "Please enter the date", "Month and Year", JOptionPane.QUESTION_MESSAGE, null, null, "03, 2011");
				location = (String)JOptionPane.showInputDialog(null, "Please Enter the Location", "Location", JOptionPane.QUESTION_MESSAGE, null, null, "Oklahoma City, OK, USA");
				JOptionPane.showMessageDialog(null, scholarList, "Select Editors", JOptionPane.PLAIN_MESSAGE);
				for(int i = 0; i < scholarList.getSelectedIndices().length; i++)
					editors.add(scholars.get(scholarList.getSelectedIndices()[i]));
				JOptionPane.showMessageDialog(null, scholarList, "Select Reviewers", JOptionPane.PLAIN_MESSAGE);
				for(int i = 0; i < scholarList.getSelectedIndices().length; i++)
					reviewers.add(scholars.get(scholarList.getSelectedIndices()[i]));
				
				ArrayList<Volume> volumeList = new ArrayList<Volume>();
				ArrayList<Issue> issueList = new ArrayList<Issue>();
				
				int month = Integer.parseInt(date.split(", ")[0]);
				int year = Integer.parseInt(date.split(", ")[1]);
				Location loc = new Location(location.split(" ")[0], location.split(" ")[1], location.split(" ")[2]);
				issueList.add(new Issue(month, year, editors, reviewers, new ArrayList<Paper>()));
				volumeList.add(new Volume(issueList));
				
				System.out.println("Month: " + month + " Year: " + year);
				model.addSerial(new Journal(loc, volumeList, organizationName));
				selectionView.deleteSerialsButtonSetEnabled(true);
				selectionView.addPaperButtonSetEnabled(true);
			}
		}
	}
	public class deleteSerialButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete the selected serial and its data
			Object[] options = {"No, Don't Delete", "Yes, Delete!"};
			if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete the serial?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
				//Get the selected value and remove it
				model.removeSerial(selectionView.getSerialsList().getSelectedValue().toString());
				if(model.getSerials().isEmpty()){
					selectionView.deleteSerialsButtonSetEnabled(false);
					selectionView.addPaperButtonSetEnabled(false);
					//Fire the DeleteAllpapers Action Listener to delete all the papers
					ActionListener deleteAllPapers = new deleteAllPapersButtonActionListener();
					deleteAllPapers.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Force Remove All Papers"));
				}
			}
		}
	}
	public class deleteAllSerialsButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			if(!actionEvent.getActionCommand().equalsIgnoreCase("Force Remove All Serials")){
				//a dialog will pop up to confirm whether the user wants to delete all serials
				Object[] options = {"No, Don't Delete", "Yes, Delete!"};
				if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete all the serials?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
					//Get the selected value and remove it
					model.removeAllSerials();
					selectionView.deleteSerialsButtonSetEnabled(false);
					selectionView.addPaperButtonSetEnabled(false);
					//Fire the DeleteAllpapers Action Listener to delete all the papers
					ActionListener deleteAllPapers = new deleteAllPapersButtonActionListener();
					deleteAllPapers.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Force Remove All Papers"));
				}
			}else{	//Force Remove all serials
				model.removeAllSerials();
				selectionView.deleteSerialsButtonSetEnabled(false);
				selectionView.addPaperButtonSetEnabled(false);
				//Fire the DeleteAllpapers Action Listener to delete all the papers
				ActionListener deleteAllPapers = new deleteAllPapersButtonActionListener();
				deleteAllPapers.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Force Remove All Papers"));
			}
		}
	}
	public class addPaperButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			Object[] options = {"Conference Paper", "Journal Article"};
			
			ArrayList<Scholar> scholars = model.getScholars();
			String[] scholarNames = new String[scholars.size()];
			for(int i = 0; i < scholars.size(); i++)
				scholarNames[i] = (scholars.get(i).getSecondaryName() + " " + scholars.get(i).getPrimaryName());
			JList<String> scholarList = new JList<String>(scholarNames);
			
			ArrayList<ScholarOrganization> serials = model.getSerials();
			String[] serialNames = new String[serials.size()];
			for(int i = 0; i < serials.size(); i++)
				serialNames[i] = serials.get(i).getName();
			JList<String> serialList = new JList<String>(serialNames);
			
			String paperTitle;
			String volumeIssue;
			String pageRange;
			String DOI;
			ArrayList<Scholar> authors = new ArrayList<Scholar>();
			Journal journalReference;
			Conference conferenceReference;
			
			
			if(0==JOptionPane.showOptionDialog(null, "Do you want to add a conference paper or journal article?", "Conference or Journal?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0])){
				//conference Paper
				paperTitle = (String)JOptionPane.showInputDialog(null, "Please Enter the Paper Title", "Paper Title", JOptionPane.QUESTION_MESSAGE, null, null, "Sample Title");
				pageRange = (String)JOptionPane.showInputDialog(null, "Please Enter the Page Range", "Page Range", JOptionPane.QUESTION_MESSAGE, null, null, "101-108");
				DOI = (String)JOptionPane.showInputDialog(null, "Please Enter the Digital Object Identifier", "DOI", JOptionPane.QUESTION_MESSAGE, null, null, "http://www.papers.com/samplePaper.pdf");
				JOptionPane.showMessageDialog(null, scholarList, "Select Authors", JOptionPane.PLAIN_MESSAGE);
				for(int i = 0; i < scholarList.getSelectedIndices().length; i++)
					authors.add(scholars.get(scholarList.getSelectedIndices()[i]));
				JOptionPane.showMessageDialog(null, serialList, "Select Serial", JOptionPane.PLAIN_MESSAGE);
				conferenceReference = (Conference)serials.get(serialList.getSelectedIndex());
				
				model.addPaper(new ConferencePaper(conferenceReference, authors, paperTitle, pageRange, DOI));
				selectionView.deletePapersButtonSetEnabled(true);
				
			}else{
				//Journal Article
				paperTitle = (String)JOptionPane.showInputDialog(null, "Please Enter the Paper Title", "Paper Title", JOptionPane.QUESTION_MESSAGE, null, null, "Sample Title");
				volumeIssue = (String)JOptionPane.showInputDialog(null, "Please Enter the Volume and Issue", "Volume Issue", JOptionPane.QUESTION_MESSAGE, null, null, "foobar");
				pageRange = (String)JOptionPane.showInputDialog(null, "Please Enter the Page Range", "Page Range", JOptionPane.QUESTION_MESSAGE, null, null, "101-108");
				DOI = (String)JOptionPane.showInputDialog(null, "Please Enter the Digital Object Identifier", "DOI", JOptionPane.QUESTION_MESSAGE, null, null, "http://www.papers.com/samplePaper.pdf");
				JOptionPane.showMessageDialog(null, scholarList, "Select Authors", JOptionPane.PLAIN_MESSAGE);
				for(int i = 0; i < scholarList.getSelectedIndices().length; i++)
					authors.add(scholars.get(scholarList.getSelectedIndices()[i]));
				JOptionPane.showMessageDialog(null, serialList, "Select Serial", JOptionPane.PLAIN_MESSAGE);
				journalReference = (Journal)serials.get(serialList.getSelectedIndex());
				
				model.addPaper(new JournalArticle(journalReference, authors, paperTitle, volumeIssue, pageRange, DOI));
				selectionView.deletePapersButtonSetEnabled(true);
			}
		}
	}
	public class deletePaperButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			//a dialog will pop up to confirm whether the user wants to delete the selected paper
			Object[] options = {"No, Don't Delete", "Yes, Delete!"};
			if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete the paper?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
				//Get the selected value and remove it
				model.removePaper(selectionView.getPapersList().getSelectedValue().toString());
				if(model.getPapers().isEmpty()){
					selectionView.deletePapersButtonSetEnabled(false);
				}
			}
		}
	}
	public class deleteAllPapersButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//The button was pressed
			if(!actionEvent.getActionCommand().equalsIgnoreCase("Force Remove All Papers")){
				//a dialog will pop up to confirm whether the user wants to delete all papers
				Object[] options = {"No, Don't Delete", "Yes, Delete!"};
				if(1==JOptionPane.showOptionDialog(null, "Are you sure you want to delete all the papers?", "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0])){
					//Get the selected value and remove it
					model.removeAllPapers();
					selectionView.deletePapersButtonSetEnabled(false);
				}
			}else{	//Force remove all papers
				model.removeAllPapers();
				selectionView.deletePapersButtonSetEnabled(false);
			}
		}
	}
	
	/**** NICKS JOB ******/
	public class openActionListener implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {	//Open file was pressed
			
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
