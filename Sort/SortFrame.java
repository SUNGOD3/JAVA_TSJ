import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SortFrame extends JFrame {
	
	private final JComboBox<String> imagesJComboBox,imagesJComboBox2; // hold icon names
	private static final String[] names = {"BubbleSort","InsertionSort","MergeSort","QuickSort","SelectionSort"};
	private static final String[] names2 = {"RandomArray","ExampleArray","ReadArray","InputArray"};
	private String T1,T2;// 捕捉combobox的狀態
	private JButton increaseButton,decreaseButton,generateArray,RunButton,animation,left,right; // button to decrease font size
	private JTextArea inputText,outputText; // displays example text
	private int fontSize = 20, index = 0, it = 0, sizeOfAnimateArray; // current font size
	private newArray Array;
	private JPanel animate,tmpPic;//tmpPic表示animate內的當前圖片panel
	private newArray[] animateArray;
	private ImageIcon gogofuck,gogojpg,errorfuck;//改成全域比較好應事件更改

	public SortFrame() {
		super("Sort Frame Test");
		setLayout(new GridLayout(5,1));
		imagesJComboBox = new JComboBox<String>(names); // set up JComboBox
		imagesJComboBox2 = new JComboBox<String>(names2); // set up JComboBox
      	imagesJComboBox.setMaximumRowCount(5); // display three rows
		imagesJComboBox2.setMaximumRowCount(4); // display three rows
		ItemListener handler1 = new EventListner();
		ItemListener handler2 = new EventListner();
		imagesJComboBox.addItemListener(handler1); 
		imagesJComboBox2.addItemListener(handler2); 
		imagesJComboBox.setSelectedIndex(1); // 改變選項時才偵測,且一開始為0
		imagesJComboBox2.setSelectedIndex(2);// 直接改預設值先讓其跑一次
		EventListner handler = new EventListner();
		// create buttons and add action listeners
		generateArray = new JButton("Generate Array");
		gogofuck = new ImageIcon("fuck.png");
		errorfuck = new ImageIcon("fuck.png");
		gogojpg = new ImageIcon("GoGo.jpg");
		RunButton = new JButton(gogojpg);
		decreaseButton = new JButton("Decrease font size");
		increaseButton = new JButton("Increase font size");
		generateArray.addActionListener(handler);
		RunButton.addActionListener(handler);
		decreaseButton.addActionListener(handler);
		increaseButton.addActionListener(handler);
		animation = new JButton("Run"); //這是下面圖片的RUN
		left = new JButton("<=");
		right = new JButton("=>");
		// create text area and set initial font
		inputText = new JTextArea("Test");
		inputText.setFont(new Font("Consolos", Font.PLAIN, fontSize));
		inputText.setEditable(false);
		outputText = new JTextArea("Test");
		outputText.setFont(new Font("Consolos", Font.PLAIN, fontSize));
		outputText.setEditable(false);

		// add GUI components to frame
		JPanel panel = new JPanel(); // used to get proper layout
		JPanel inpanel = new JPanel();
		inpanel.setLayout(new BorderLayout());
		JPanel outpanel = new JPanel();
		outpanel.setLayout(new BorderLayout());
		inpanel.add(new JScrollPane(inputText));
		outpanel.add(new JScrollPane(outputText));
		tmpPic = new JPanel();
		animate = new JPanel();//animate 之後會改變，所以設成全域
		animate.add(left);
		animate.add(animation);
		animate.add(right);
		left.addActionListener(handler);
		animation.addActionListener(handler);
		right.addActionListener(handler);
		panel.add(generateArray);
		panel.add(RunButton);
		panel.add(increaseButton);
		panel.add(decreaseButton);
		panel.add(imagesJComboBox); // add combobox to JFrame
		panel.add(imagesJComboBox2); // add combobox to JFrame
		add(panel); // add buttons at top
		add(inpanel); // allow scrolling
		add(outpanel); // allow scrolling
		add(animate);
		add(tmpPic);
	}

	private class EventListner implements ActionListener,ItemListener {
		public void setAnimateImg(){//重製新圖片(把舊圖看掉放新的)
			Chart chart = new Chart(animateArray[it]);
			SortFrame.this.remove(tmpPic);
			tmpPic = chart.getChartPanel();
			SortFrame.this.add(tmpPic);
			SortFrame.this.revalidate();
		}
		public void noImage(){ //此項是用來在沒有圖片時作的事
			
		}
		public void judgeSortType(){
			System.out.println("You choose "+T1);
			if(Array==null){
				outputText.setText("Please generate array first!");
				RunButton.setIcon(gogofuck);
			}
			else{
				it = 0;
				RunButton.setIcon(gogojpg);
				Sort Gogo;
				if(T1=="BubbleSort"){
					Gogo = new BubbleSort();
				}
				else if(T1=="InsertionSort"){
					Gogo = new InsertionSort();
				}
				else if(T1=="MergeSort"){
					Gogo = new MergeSort();
				}
				else if(T1=="QuickSort"){
					Gogo = new QuickSort();
				}
				else /*if(T1=="SelectionSort")*/{
					Gogo = new SelectionSort();
				}
				Gogo.SortMain(Array.getArray());
				animateArray = Gogo.getsortStep();
				outputText.setText(Gogo.getOutput());
				if(Gogo.swapTime() == -1){
					
				}
				else {
					sizeOfAnimateArray = Gogo.swapTime();
					it=0;
					/*animate.remove(tmpPic);	//animate和按鈕共用一個panel會因為圖片太大而把按鈕擠掉
					tmpPic = chart.getChartPanel();
					animate.add(tmpPic);*/
					setAnimateImg();
				}
			}
		}
		public void judgeInput(){
			System.out.println("You choose "+T2);
			if(T2=="RandomArray"){
				//參考generateRandomArrayTest
				String sn=JOptionPane.showInputDialog("Input the size of your array");
				String slr=JOptionPane.showInputDialog("Input the lower bound of your array");
				String sur=JOptionPane.showInputDialog("Input the upper bound of your array");
				int n=Integer.parseInt(sn);
				int lr=Integer.parseInt(slr);
				int ur=Integer.parseInt(sur);
				generateRandomArray tmp = new  generateRandomArray(n,lr,ur);
				Array = new newArray(tmp.getArray(),lr,ur);
				inputText.setText(Array.toString());
			}
			else if(T2=="ExampleArray"){
				generateExampleArray tmp = new generateExampleArray();
				Array = new newArray(tmp.getArray());
				inputText.setText(Array.toString());
			}
			else if(T2=="ReadArray"){
				findFile fd = new findFile();
				System.out.println(fd.getName());
				ReadArray tmp = new ReadArray(fd.getName()); 
				Array = new newArray(tmp.run());
				inputText.setText(Array.toString());
			}
			else if(T2=="InputArray"){
				if (generateArray.getText() == "NEW Generate Array") {
					String words = inputText.getText();
					Judge jg = new Judge();
					if(jg.stringIsArray(words)){
						Array = new newArray(words);
						inputText.setText(Array.toString());
						generateArray.setText("Generate Array");
						inputText.setEditable(false);
					}
					else{
						inputText.setText("Input string is not an array! Please try again.");
					}
					//System.out.println(words);
				}
				else if (generateArray.getText() == "Generate Array") {
					generateArray.setText("NEW Generate Array");
					inputText.setText("");
					inputText.setEditable(true);
				}
			}
		}
		public void actionPerformed(ActionEvent e){//當Button被按到時
			
			if(e.getSource()==left){
				if(it>0){
					--it;
					setAnimateImg();
				}
			}
			if(e.getSource()==right){
				if(it<sizeOfAnimateArray){
					++it;
					setAnimateImg();
				}
			}
			if(e.getSource()==generateArray){//產生陣列
				judgeInput();
			}
			if(e.getSource()==RunButton){//Sort
				judgeSortType();
			}
			//以下參考作業
			if(e.getSource()==increaseButton){
				if(fontSize>=160){
					JOptionPane.showMessageDialog(SortFrame.this,"No, it cannot be larger!");
				}
				else{
					fontSize+=2;
					inputText.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
			if(e.getSource()==decreaseButton){
				if(fontSize<=8){
					JOptionPane.showMessageDialog(SortFrame.this,"No, it cannot be smaller!");
				}
				else{
					fontSize-=2;
					inputText.setFont(new Font("Consolas", Font.PLAIN, fontSize));
				}
			}
			if(e.getSource()==animation){
				if(index == 0){
					animation.setText("pause");
					left.setEnabled(false);
					right.setEnabled(false);
					index = 1;
					if(it<sizeOfAnimateArray){
						RunChart r1 = new RunChart();
						Thread thr = new Thread(r1);
						thr.start();
					}
				}
				else if(index == 1){
					animation.setText("Run");
					left.setEnabled(true);
					right.setEnabled(true);
					index = 0;
				}
			}
			/*  當run被按時
				To Do...
			*/
		}

		@Override//捕捉combobox
		public void itemStateChanged(ItemEvent e){
			// determine whether item selected
			if(e.getSource()==imagesJComboBox){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println(e.getItem());
					T1 = (String) e.getItem();
				}
			}
			else if(e.getSource()==imagesJComboBox2){
				if (e.getStateChange() == ItemEvent.SELECTED){
					System.out.println(e.getItem());
					T2 = (String) e.getItem();
				}
			}
			
		} 
		public class RunChart implements Runnable{
			public void run(){
				while(it<sizeOfAnimateArray && index == 1){
					++it;
					setAnimateImg();
					try{
						Thread.sleep(500);
					}catch (InterruptedException e) {
      				return;
					}
				}
			}
		}
	}
}
