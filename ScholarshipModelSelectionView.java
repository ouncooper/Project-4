import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ScholarshipModelSelectionView extends JFrame implements ActionListener{

	private ScholarshipModel model;
	
	private JButton addScholarButton = new JButton("Add Scholar");
	private JButton deleteScholarButton = new JButton("Delete Scholar");
	private JButton deleteAllScholarsButton = new JButton("Delete All Scholars");
	private JButton addSerialButton = new JButton("Add Serial");
	private JButton deleteSerialButton = new JButton("Delete Serial");
	private JButton deleteAllSerialsButton = new JButton("Delete All Serials");
	private JButton addPaperButton = new JButton("Add Paper");
	private JButton deletePaperButton = new JButton("Delete Paper");
	private JButton deleteAllPapersButton = new JButton("Delete All Papers");
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu plotMenu = new JMenu("Plot");
	private JMenuItem openMenuItem = new JMenuItem("Open");
	private JMenuItem saveMenuItem = new JMenuItem("Save");
	private JMenuItem plotTOP = new JMenuItem("Types of Publications");
	private JMenuItem plotPPY = new JMenuItem("Publications per Year");
	private JMenuItem plotCPPY = new JMenuItem("Conference Papers per Year");
	private JMenuItem plotJAPY = new JMenuItem("Journal Articles per Year");
	private JMenuItem plotNCAPP = new JMenuItem("Co-authors per Publication");
	
	
	private DefaultListModel<String> scholarsModel;
	private DefaultListModel<String> serialsModel;
	private DefaultListModel<String> papersModel;
	
	private JList<String> scholarsList;
	private JList<String> serialsList;
	private JList<String> papersList;
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModelSelectionView() { 
		this.setTitle("ScholarPub");
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		scholarsModel = new DefaultListModel<String>();
		serialsModel = new DefaultListModel<String>();
		papersModel = new DefaultListModel<String>();
		
		scholarsList = new JList<String>(scholarsModel);
		serialsList = new JList<String>(serialsModel);
		papersList = new JList<String>(papersModel);
		
		JScrollPane scholarsScroll = new JScrollPane(scholarsList);
		JScrollPane serialsScroll = new JScrollPane(serialsList);
		JScrollPane papersScroll = new JScrollPane(papersList);
		
		scholarsScroll.setViewportView(scholarsList);
		serialsScroll.setViewportView(scholarsList);
		papersScroll.setViewportView(scholarsList);
		
		c.gridx = 0; //Location
		c.gridy = 0;
		c.weighty = 0; //Size
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(new JLabel("Scholars"), c);
		
		c.gridx = 1; //Location
		c.gridy = 0;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(new JLabel("Serials"), c);
		
		c.gridx = 2; //Location
		c.gridy = 0;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(new JLabel("Papers"), c);

		c.gridx = 0; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(scholarsList, c);
		
		c.gridx = 1; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(serialsList, c);
		
		c.gridx = 2; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(papersList, c);
		
		c.gridx = 2; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		this.add(papersList, c);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3,1));
		leftPanel.add(addScholarButton, 0, 0);
		leftPanel.add(deleteScholarButton, 1, 0);
		leftPanel.add(deleteAllScholarsButton, 2, 0);
		addScholarButton.setEnabled(true);
		deleteScholarButton.setEnabled(false);
		deleteAllScholarsButton.setEnabled(false);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(leftPanel, c);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1));
		centerPanel.add(addSerialButton, 0, 0);
		centerPanel.add(deleteSerialButton, 1, 0);
		centerPanel.add(deleteAllSerialsButton, 2, 0);
		addSerialButton.setEnabled(false);
		deleteSerialButton.setEnabled(false);
		deleteAllSerialsButton.setEnabled(false);
		
		c.gridx = 1;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(centerPanel, c);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3,1));
		rightPanel.add(addPaperButton, 0, 0);
		rightPanel.add(deletePaperButton, 1, 0);
		rightPanel.add(deleteAllPapersButton, 2, 0);
		addPaperButton.setEnabled(false);
		deletePaperButton.setEnabled(false);
		deleteAllPapersButton.setEnabled(false);
		
		c.gridx = 2;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(rightPanel, c);
		
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		plotMenu.add(plotTOP);
		plotMenu.add(plotPPY);
		plotMenu.add(plotCPPY);
		plotMenu.add(plotJAPY);
		plotMenu.add(plotNCAPP);
		menuBar.add(fileMenu);
		menuBar.add(plotMenu);
		plotMenu.setEnabled(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(menuBar); //GLORIOUS
		this.pack();
		this.setSize(this.getWidth(), 500);
		this.setVisible(true);
	}
	
	public void setModel(ScholarshipModel newModel){
		model = newModel;
		model.addActionListener(this);
	}
	
	//Used by the controller
	public JButton getAddScholarButton(){ return addScholarButton;}
	public JButton getDeleteScholarButton(){ return deleteScholarButton;}
	public JButton getDeleteAllScholarsButton(){ return deleteAllScholarsButton;}
	public JButton getAddSerialButton(){ return addSerialButton;}
	public JButton getDeleteSerialButton(){ return deleteSerialButton;}
	public JButton getDeleteAllSerialsButton(){ return deleteAllSerialsButton;}
	public JButton getAddPaperButton(){ return addPaperButton;}
	public JButton getDeletePaperButton(){ return deletePaperButton;}
	public JButton getDeleteAllPapersButton(){ return deleteAllPapersButton;}
	public JMenuItem getOpenMenuItem(){ return openMenuItem;}
	public JMenuItem getSaveMenuItem(){ return saveMenuItem;}
	public JMenuItem getPlotTOP(){ return plotTOP;}
	public JMenuItem getPlotPPY(){ return plotPPY;}
	public JMenuItem getPlotCPPY(){ return plotCPPY;}
	public JMenuItem getPlotJAPY(){ return plotJAPY;}
	public JMenuItem getPlotNCAPP(){ return plotNCAPP;}
	
	public JList<String> getScholarsList(){ return scholarsList;}
	public JList<String> getSerialsList(){ return serialsList;}
	public JList<String> getPapersList(){ return papersList;}
	
	
	public void actionPerformed(ActionEvent e) {
		//Update the scholar list
		scholarsModel.clear();
		for(Scholar eachScholar: model.getScholars())
			scholarsModel.addElement(eachScholar.getSecondaryName() + " " + eachScholar.getPrimaryName());
		
		//Update the serial list
		serialsModel.clear();
		for(ScholarOrganization eachSerial: model.getSerials())
			serialsModel.addElement(eachSerial.getName());
		
		//Update the papers list
		papersModel.clear();
		for(Paper eachPaper: model.getPapers())
			papersModel.addElement(eachPaper.getTitle());
	}
	
	public void deleteScholarsButtonSetEnabled(boolean input){
		deleteScholarButton.setEnabled(input);
		deleteAllScholarsButton.setEnabled(input);
	}
	public void addSerialButtonSetEnabled(boolean input){
		addSerialButton.setEnabled(input);
	}
	public void deleteSerialsButtonSetEnabled(boolean input){
		deleteSerialButton.setEnabled(input);
		deleteAllSerialsButton.setEnabled(input);
	}
	public void addPaperButtonSetEnabled(boolean input){
		addPaperButton.setEnabled(input);
	}
	public void deletePapersButtonSetEnabled(boolean input){
		deletePaperButton.setEnabled(input);
		deleteAllPapersButton.setEnabled(input);
	}
	public void plotMenuSetEnabled(boolean input){
		plotMenu.setEnabled(input);
	}
}
