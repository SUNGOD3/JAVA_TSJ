import java.util.Arrays;
public class newArray {
	private int ArraySize,LowerRange,UpperRange/*,Type*/;
	private int[] Arr/*,Color*/;
    //也可以像Set直接丟陣列產生

    //Set成新的Random Array，LowerRange/UpperRange會分別設為陣列最小值/最大值
    public newArray(int[] A){
		Arr = A;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
        ArraySize = A.length;
		for(int i=0;i<ArraySize;++i){
            mi = Math.min(mi,A[i]);
            ma = Math.max(ma,A[i]);
        } 
        LowerRange = mi-1;
        UpperRange = ma+1;
    }

	public newArray(int[] A,int min,int max){
		Arr = A;
		ArraySize = A.length;
        LowerRange = min;
        UpperRange = max;
    }

    @Override
    public String toString(){
        String rt="";
        rt+="ArraySize : " + ArraySize;
        rt+="\nRange of ArraySize[i] : " + LowerRange + " < ArraySize[i] < " + UpperRange + "\n";
        for(int i=0;i<ArraySize;++i){
            rt+=Arr[i]+" ";
        }
        rt+="\n";
        return rt;
    }
    //JAVA不支援隨時擴充陣列，所以基本上要重建
    public void push(int v){
        ++ArraySize;
        Arr = Arrays.copyOf(Arr, ArraySize);
		LowerRange = Math.min(LowerRange,v-1);
        UpperRange = Math.max(UpperRange,v+1);
        Arr[ArraySize-1]=v;
    }

    public int getArraySize(){
        return ArraySize;
    }

    public int getLowerRange(){
        return LowerRange;
    }

    public int getUpperRange(){
        return UpperRange;
    }

    public int[] getArray(){
        return Arr;
    }
}