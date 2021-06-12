import java.util.Random;
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
            RandomArray[i]=(int)((rd.nextFloat()*(UpperRange-LowerRange-1))+LowerRange+1);
        }
        this.RandomArray=RandomArray;
	}

    //Set成新的Random Array，LowerRange/UpperRange會分別設為陣列最小值/最大值
    public void setRandomArray(int[] Array){
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
        return RandomArray;
    }

    public String doc(){
        return "It can generate a Random (int) Array\nYou need input with 3 variable: ArraySize,LowerRange,UpperRange";
    }
}