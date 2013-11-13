import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.*;


public class ScholarshipModelSelectionView {

	private ArrayList<JButton> buttons;
	private JMenuBar menuBar;
	private JMenu menu;
	private ArrayList<JMenuItem> menuItems;
	
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
		
		JList<String> scholarsList = new JList<String>(scholarsModel);
		JList<String> serialsList = new JList<String>(serialsModel);
		JList<String> papersList = new JList<String>(papersModel);
		
		selectionPane.add(new JLabel("Scholars"));
		c.gridx = 0; //Location
		c.gridy = 0;
		
		
		selectionPane.add(new JLabel("Serials"));
		selectionPane.add(new JLabel("Papers"));
		selectionPane.add(scholarsList);
		selectionPane.add(serialsList);
		selectionPane.add(papersList);
		
		selectionFrame.setSize(1000,500);
		selectionFrame.setVisible(true);
	}
	//Create the GUI.  Unsure of necessary components at the time.
}
