public class generateArrayTest{
    //之後會整合成SortAPI
	public static void main(String[] args) {
        generateRandomArray Ra = new generateRandomArray(5,0,100);
        /*generateExampleArray Rx = new generateExampleArray()*/
        /*readArray Ry = new readArray("string")*/
        int [] tmp = {1,50,66,-11,5};
        Array Ra2 = new Array(tmp);
        Array Ra3 = new Array(Ra.getArray());
        Array Ra4 = new Array(Ra.getArray(),Ra.getLowerRange(),Ra.getUpperRange());
        System.out.println(Ra.doc());
        System.out.println(Ra.toString());
        System.out.println(Ra2.toString());
        Ra2.push(370);
        System.out.println(Ra2.toString());
        System.out.println(Ra3.toString());
        System.out.println(Ra4.toString());
    }

}