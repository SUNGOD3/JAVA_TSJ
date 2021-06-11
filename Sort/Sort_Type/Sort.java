//此class為所有sort的模型，abstract的部分代表每種sort都要有該功能
public abstract class Sort{
	private Array[] sortStep;//儲存排序時的每個陣列
	private int[] tmpArr;//儲存排序好的陣列
	//說明文件
	public abstract String doc();
	//就是get name
	public abstract String getName();
	
	public void printArr(int[] arr){
		for(int i=0;i<arr.length;++i)
			System.out.printf("%d ",arr[i]);
		System.out.println();
	}
	//主程式，sort傳入的陣列
	public abstract int[] runTest(int arr[]);
	//計算swap的次數
	public abstract int swapTime();

	public void SortMain(int [] arr){
		tmpArr = new int[arr.length];
		for(int i=0;i<arr.length;++i){
			tmpArr[i]=arr[i];
		}
		double time1,time2;
		printArr(arr);
		//計時
		time1 = System.currentTimeMillis();
		tmpArr = runTest(tmpArr);
		time2 = System.currentTimeMillis();
		printArr(tmpArr);
		System.out.printf("%s used %f to sort the array\n",getName(),time2-time1);
		System.out.printf("Swap Times : %d\n",swapTime());
	}

}
