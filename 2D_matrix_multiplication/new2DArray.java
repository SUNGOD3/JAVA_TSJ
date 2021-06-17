import java.util.Arrays;
public class new2DArray {
	private int My2DArraySize,ColSize,RowSize,LowerRange,UpperRange/*,Type*/;
	private int[][] My2DArr/*,Color*/;
    //也可以像Set直接丟陣列產生

    //當讀入合法陣列時也可以轉成newArray
    //請先使用judge中的stringIsArray判斷格式是否正確
    /*public newArray(String A){
        
    }*/

    //Set成新的Random Array，LowerRange/UpperRange會分別設為陣列最小值/最大值
    public new2DArray(int[][] A){
		/*Arr = A;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
        ArraySize = A.length;
		for(int i=0;i<ArraySize;++i){
            mi = Math.min(mi,A[i]);
            ma = Math.max(ma,A[i]);
        } 
        LowerRange = mi-1;
        UpperRange = ma+1;*/
    }

	public new2DArray(int[][] A,int min,int max){
		/*Arr = A;
		ArraySize = A.length;
        LowerRange = min;
        UpperRange = max;*/
    }

    /*@Override
    public String toString(){
        
    }*/
    //JAVA不支援隨時擴充陣列，所以基本上要重建


    public int get2DArraySize(){
        return My2DArraySize;
    }

    public int getLowerRange(){
        return LowerRange;
    }

    public int getUpperRange(){
        return UpperRange;
    }

    public int[][] get2DArray(){
        return My2DArr;
    }
}