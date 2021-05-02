public class SortTest {
	//供自行test，之後會做出簡單的互動介面代替
	public static void main(String args[]) {
		Sort Test = new SelectionSort();
		int [] TestArr = {5,2,4,3,1};
		System.out.println(Test.doc());
		Test.SortMain(TestArr);
	}
	
}