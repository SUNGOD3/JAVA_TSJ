import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class SortFrame extends JFrame {
	
	private final JComboBox<String> imagesJComboBox,imagesJComboBox2; // hold icon names
	private static final String[] names = {"BubbleSort","InsertionSort","MergeSort","QuickSort","SelectionSort"};
	private static final String[] names2 = {"RandomArray","ExampleArray","ReadArray","InputArray"};
	private JButton increaseButton,decreaseButton,generateArray; // button to decrease font size
	private JTextArea text; // displays example text
	private int fontSize = 20; // current font size
	private newArray Array;
	private Sort chooseSort;

	public SortFrame() {
		super("Sort Frame Test");
		imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
		imagesJComboBox2 = new JComboBox<String>(names2); // set up JComboBox
      	imagesJComboBox.setMaximumRowCount(5); // display three rows
		imagesJComboBox2.setMaximumRowCount(4); // display three rows
		imagesJComboBox.addItemListener(
			new ItemListener(){ // anonymous inner class
				// handle JComboBox event
				@Override
				public void itemStateChanged(ItemEvent event){
					// determine whether item selected
					if (event.getStateChange() == ItemEvent.SELECTED){
							System.out.println(event.getItem());
					}
				} 
			} // end anonymous inner class
      	); 
		imagesJComboBox2.addItemListener(
			new ItemListener(){ // anonymous inner class
				// handle JComboBox event
				@Override
				public void itemStateChanged(ItemEvent event){
					// determine whether item selected
					if (event.getStateChange() == ItemEvent.SELECTED){
							System.out.println(event.getItem());
					}
				} 
			} // end anonymous inner class
      	); 
		EventListner handler = new EventListner();
		// create buttons and add action listeners
		generateArray = new JButton("Generate Array");
		decreaseButton = new JButton("Decrease font size");
		increaseButton = new JButton("Increase font size");
		generateArray.addActionListener(handler);
		decreaseButton.addActionListener(handler);
		increaseButton.addActionListener(handler);

		// create text area and set initial font
		text = new JTextArea("Test");
		text.setFont(new Font("Consolos", Font.PLAIN, fontSize));

		// add GUI components to frame
		JPanel panel = new JPanel(); // used to get proper layout
		panel.add(generateArray);
		panel.add(increaseButton);
		panel.add(decreaseButton);
		panel.add(imagesJComboBox); // add combobox to JFrame
		panel.add(imagesJComboBox2); // add combobox to JFrame
		add(panel, BorderLayout.NORTH); // add buttons at top
		add(new JScrollPane(text)); // allow scrolling
	}

	private class EventListner implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==generateArray){//參考generateRandomArrayTest
				String sn=JOptionPane.showInputDialog("Input the size of your array");
				String slr=JOptionPane.showInputDialog("Input the lower bound of your array");
				String sur=JOptionPane.showInputDialog("Input the upper bound of your array");
				int n=Integer.parseInt(sn);
				int lr=Integer.parseInt(slr);
				int ur=Integer.parseInt(sur);
				generateRandomArray tmp = new  generateRandomArray(n,lr,ur);
				Array = new newArray(tmp.getArray());
				text.setText(Array.toString());
			}
			//以下參考作業
			if(e.getSource()==increaseButton){
				if(fontSize>=160){
					JOptionPane.showMessageDialog(SortFrame.this,"No, it cannot be larger!");
				}
				else{
					fontSize+=2;
					text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
			if(e.getSource()==decreaseButton){
				if(fontSize<=8){
					JOptionPane.showMessageDialog(SortFrame.this,"No, it cannot be smaller!");
				}
				else{
					fontSize-=2;
					text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
		}
	}
}
