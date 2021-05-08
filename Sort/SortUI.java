import javax.swing.JFrame;
//Sort 的 UI 介面，能由其他介面進入，功能待補充
public class SortUI {
	public static void main(String args[]) {
		SortFrame TestUI = new SortFrame();
		TestUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TestUI.setSize(1000, 600); // set frame size
		TestUI.setVisible(true); // display frame
	}
}