import java.util.Random;
import java.util.Arrays;
public class generateRandomArray{
    //可以當成是陣列的功能擴增
	private int ArraySize,LowerRange,UpperRange;
    private int[]  RandomArray;
    //設定陣列(陣列大小，最小值，最大值)
	public generateRandomArray(int ArraySize,int LowerRange,int UpperRange){
		if(ArraySize<=0){
            System.out.println("Error value of variable ArraySize,set ArraySize to 10");
            ArraySize=10;
        }
        if(LowerRange>UpperRange){
            System.out.println("Error value of variable LowerRange//UpperRange,set them to 0//100");
            LowerRange=0;
            UpperRange=100;
        }
        this.ArraySize=ArraySize;
		this.LowerRange=LowerRange;
		this.UpperRange=UpperRange;
        int[] RandomArray = new int [ArraySize];
        Random rd = new Random();
        for(int i=0;i<ArraySize;++i){
            RandomArray[i]=(int)(rd.nextFloat()*UpperRange+LowerRange);
        }
        this.RandomArray=RandomArray;
	}

    //也可以像Set直接丟陣列產生
    public generateRandomArray(int[] Array){
        ArraySize = Array.length;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
        for(int i=0;i<ArraySize;++i){
            mi = Math.min(mi,Array[i]);
            ma = Math.max(ma,Array[i]);
        } 
        RandomArray = Array;
        LowerRange = mi-1;
        UpperRange = ma+1;
    }

    //Set成新的Random Array，LowerRange/UpperRange會分別設為陣列最小值-1/最大值+1
    public void setRandomArray(int[] Array){
        ArraySize = Array.length;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
        for(int i=0;i<ArraySize;++i){
            mi = Math.min(mi,Array[i]);
            ma = Math.max(ma,Array[i]);
        } 
        RandomArray = Array;
        LowerRange = mi;
        UpperRange = ma;
    }

    @Override
    public String toString(){
        String rt="";
        rt+="ArraySize : " + ArraySize;
        rt+="\nRange of ArraySize[i] : " + LowerRange + " < ArraySize[i] < " + UpperRange + "\n";
        for(int i=0;i<ArraySize;++i){
            rt+=RandomArray[i]+" ";
        }
        rt+="\n";
        return rt;
    }
    //JAVA不支援隨時擴充陣列，所以基本上要重建
    public void pushRandomArray(int v){
        ++ArraySize;
        RandomArray = Arrays.copyOf(RandomArray, ArraySize);
        RandomArray[ArraySize-1]=v;
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

    public void doc(){
        System.out.println("It can generate a Random (int) Array");
        System.out.println("You need input with 3 variable: ArraySize,LowerRange,UpperRange");
    }
}