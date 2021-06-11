import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SortFrame extends JFrame {
	
	private JButton selectionSort,bubbleSort;//選擇Sort的按鈕
	private JButton generateArray;//產生陣列的按鈕
	private JButton increaseButton,decreaseButton; // button to decrease font size
	private JTextArea text; // displays example text
	private int fontSize = 20; // current font size
	private generateRandomArray Array;
	private Sort chooseSort;

	public SortFrame() {
		super("Sort Frame Test");

		EventListner handler = new EventListner();

		// create buttons and add action listeners
		selectionSort = new JButton("Selection Sort");
		bubbleSort = new JButton("Bubble Sort");
		generateArray = new JButton("Generate Array");
		decreaseButton = new JButton("Decrease font size");
		increaseButton = new JButton("Increase font size");
		selectionSort.addActionListener(handler);
		bubbleSort.addActionListener(handler);
		generateArray.addActionListener(handler);
		decreaseButton.addActionListener(handler);
		increaseButton.addActionListener(handler);

		// create text area and set initial font
		text = new JTextArea("Test");
		text.setFont(new Font("Consolos", Font.PLAIN, fontSize));

		// add GUI components to frame
		JPanel panel = new JPanel(); // used to get proper layout
		panel.add(selectionSort);
		panel.add(bubbleSort);
		panel.add(generateArray);
		panel.add(increaseButton);
		panel.add(decreaseButton);

		add(panel, BorderLayout.NORTH); // add buttons at top
		add(new JScrollPane(text)); // allow scrolling
	}

	private class EventListner implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==selectionSort){
				JOptionPane.showMessageDialog(SortFrame.this,"You choose the Selection Sort!");
				chooseSort = new SelectionSort();
				chooseSort.SortMain(Array.getArray());
			}
			if(e.getSource()==bubbleSort){
				JOptionPane.showMessageDialog(SortFrame.this,"You choose the Bubble Sort!");
				//chooseSort = new bubbleSort();
				//chooseSort.SortMain(Array.getArray());
				//To Do
			}
			if(e.getSource()==generateArray){//參考generateRandomArrayTest
				String sn=JOptionPane.showInputDialog("Input the size of your array");
				String slr=JOptionPane.showInputDialog("Input the lower bound of your array");
				String sur=JOptionPane.showInputDialog("Input the upper bound of your array");
				int n=Integer.parseInt(sn);
				int lr=Integer.parseInt(slr);
				int ur=Integer.parseInt(sur);
				Array = new generateRandomArray(n,lr,ur);
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
