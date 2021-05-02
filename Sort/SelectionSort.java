public class SelectionSort extends Sort{
	
	private int count;
	
	//請自行補充
	@Override
	public String doc(){
		return "Doc Test~";
	}
	//Override記得寫
	@Override
	public String getName(){
		return "SelectionSort";
	}

	@Override
	public int[] runTest(int [] arr){
		count = 0;
		int temp;
		for(int i=0;i<arr.length;++i){
			int min=i;
			for(int j=i+1;j<arr.length;++j)
				if(arr[j]<arr[min])
					min=j;
			if(min!=i){
				++count;
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}

	@Override
	public int swapTime(){
		return count;
	}
	
}
