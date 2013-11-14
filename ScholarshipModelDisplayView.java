import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ScholarshipModelDisplayView extends JFrame {

	private static final long serialVersionUID = -9016628330098315510L;
	private JFrame histogram = null;
	MyPanel hPanel = null;
	
	/**
	 * Default constructor for the class
	 */
	public ScholarshipModelDisplayView() { }
	
	/**
	 * Preferred constructor for the class
	 * @param title The title of the histogram
	 */
	public ScholarshipModelDisplayView(String title) {
		histogram = new JFrame(title);
		histogram.setSize(750, 400);
		histogram.setAlwaysOnTop(true);
		hPanel = new MyPanel();
		histogram.add(hPanel);
		pack();
		setLocationRelativeTo(null);
		histogram.setVisible(true);
		repaint();
		//init(); //Not sure if redund
	}
	
	/**
	 * Adds a bar to the histogram
	 * @param value The value of the bar
	 * @param label The label for the bar
	 */
	public void addBar(int value, String label)
	{
		hPanel.addBar(new Integer(value), label);
	}
	
	/**
	 * Graphs the number of journal articles vs. the number of conference papers 
	 * @param input The author who's data you want to graph
	 */
	public void init(){
		repaint();
	}
	
	/**
	 * Sets the title of the histogram
	 * @param newTitle New title of the histogram
	 */
	public void setGraphicTitle(String newTitle)
	{
		histogram.setTitle(newTitle);
	}
	
	private class MyPanel extends JPanel {
		
		private static final long serialVersionUID = 9103733522947634373L;
		private ArrayList<Integer> bars = new ArrayList<Integer>();
		private ArrayList<String> labels = new ArrayList<String>();
		
		public MyPanel() { }

		public void addBar(Integer value, String label)
		{
			bars.add(value);
			labels.add(label);
		}

	    public void paintComponent(Graphics g) {
	        super.paintComponent(g); 
	        int maxValue = -1;
	        for(Integer value:bars)
	        	maxValue = Math.max(maxValue, value);
	        
	        int indexAt = 0;
	        
	        for(Integer value:bars)
	        {
	        	int height = (int)((value * 1.0 / maxValue) * 200);
	        	g.setColor(new Color((int)(Math.random() * 255) + 1, (int)(Math.random() * 255) + 1, (int)(Math.random() * 255) + 1));
	        	g.fillRect(indexAt * 100 + 25, 300 - height, 80, height);
	        	g.setColor(Color.BLACK);
	        	g.drawString(labels.get(indexAt), indexAt * 100 + 25, 320 + indexAt * 5);
	        	g.drawString(value.toString(), indexAt * 100 + 45, 280 - height);
	        	indexAt++;
	        }
	    }  
	}
}
