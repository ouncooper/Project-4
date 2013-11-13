import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;


public class ScholarshipModelSelectionView {

	private ArrayList<JButton> buttons;
	private JMenuBar menuBar;
	private JMenu menu;
	private ArrayList<JMenuItem> menuItems;
	private ScholarshipModel model;
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModelSelectionView() { 
		initComponents();
	}
	
	
	public void initComponents()
	{
		JFrame selectionFrame = new JFrame("Something something title something");
		JPanel selectionPane = new JPanel();
		
		selectionFrame.add(selectionPane);
		selectionPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		DefaultListModel<String> scholarsModel = new DefaultListModel<String>();
		DefaultListModel<String> serialsModel = new DefaultListModel<String>();
		DefaultListModel<String> papersModel = new DefaultListModel<String>();
		
		for (int i = 0; i < 22; i++)
		{
			scholarsModel.add(i, i + " ");
			serialsModel.add(i, i + " ");
			papersModel.add(i, i + " ");
		}
		
		JList<String> scholarsList = new JList<String>(scholarsModel);
		JList<String> serialsList = new JList<String>(serialsModel);
		JList<String> papersList = new JList<String>(papersModel);
		
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
		selectionPane.add(new JLabel("Scholars"), c);
		
		c.gridx = 1; //Location
		c.gridy = 0;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		selectionPane.add(new JLabel("Serials"), c);
		
		c.gridx = 2; //Location
		c.gridy = 0;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		selectionPane.add(new JLabel("Papers"), c);

		c.gridx = 0; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		selectionPane.add(scholarsList, c);
		
		c.gridx = 1; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		selectionPane.add(serialsList, c);
		
		c.gridx = 2; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		selectionPane.add(papersList, c);
		
		c.gridx = 2; //Location
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		selectionPane.add(papersList, c);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3,1));
		JButton addScholarButton = new JButton("Add Scholar");
		JButton deleteScholarButton = new JButton("Delete Scholar");
		JButton deleteAllScholarsButton = new JButton("Delete All Scholars");
		leftPanel.add(addScholarButton, 0, 0);
		leftPanel.add(deleteScholarButton, 1, 0);
		leftPanel.add(deleteAllScholarsButton, 2, 0);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		selectionPane.add(leftPanel, c);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1));
		JButton addSerialButton = new JButton("Add Serial");
		JButton deleteSerialButton = new JButton("Delete Serial");
		JButton deleteAllSerialsButton = new JButton("Delete All Serials");
		centerPanel.add(addSerialButton, 0, 0);
		centerPanel.add(deleteSerialButton, 1, 0);
		centerPanel.add(deleteAllSerialsButton, 2, 0);
		
		c.gridx = 1;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		selectionPane.add(centerPanel, c);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3,1));
		JButton addPaperButton = new JButton("Add Paper");
		JButton deletePaperButton = new JButton("Delete Paper");
		JButton deleteAllPapersButton = new JButton("Delete All Papers");
		rightPanel.add(addPaperButton, 0, 0);
		rightPanel.add(deletePaperButton, 1, 0);
		rightPanel.add(deleteAllPapersButton, 2, 0);
		
		c.gridx = 2;
		c.gridy = 2;
		c.weighty = 0;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		selectionPane.add(rightPanel, c);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu();
		JMenu plotMenu = new JMenu();
		JMenuItem openMenuItem = new JMenuItem();
		JMenuItem saveMenuItem = new JMenuItem();
		JMenuItem plotTOP = new JMenuItem();
		JMenuItem plotPPY = new JMenuItem();
		JMenuItem plotCPPY = new JMenuItem();
		JMenuItem plotJAPY = new JMenuItem();
		JMenuItem plotNCAPP = new JMenuItem();
		
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		plotMenu.add(plotTOP);
		plotMenu.add(plotPPY);
		plotMenu.add(plotCPPY);
		plotMenu.add(plotJAPY);
		plotMenu.add(plotNCAPP);
		menuBar.add(fileMenu);
		menuBar.add(plotMenu);
		
		selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectionFrame.setJMenuBar(menuBar); //GLORIOUS
		selectionFrame.pack();
		selectionFrame.setVisible(true);
	}
	
	public void setModel(ScholarshipModel newModel)
	{
		model = newModel;
	}
	//Create the GUI.  Unsure of necessary components at the time.
}
