public class SortTest {
	//供自行test，之後會做出簡單的互動介面代替
	public static void main(String args[]) {
		Sort Test1 = new SelectionSort();
		Sort Test2 = new BubbleSort();
		Sort Test3 = new QuickSort();
		int [] TestArr = {5,2,4,3,1};
		System.out.println(Test1.doc());
		Test1.SortMain(TestArr);
		ResetTestArr(TestArr);
		System.out.println(Test2.doc());
		Test2.SortMain(TestArr);
		ResetTestArr(TestArr);
		System.out.println(Test3.doc());
		Test3.SortMain(TestArr);
		ResetTestArr(TestArr);
	}
	public static int[] ResetTestArr(int[] TestArr){
		for(int i = 0; i < TestArr.length; ++i){
			TestArr[i] = TestArr.length - i;
		}
		return TestArr;
	}
}