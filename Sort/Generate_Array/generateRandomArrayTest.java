public class generateRandomArrayTest{
    //之後會整合成SortAPI
	public static void main(String[] args) {
        generateRandomArray Ra = new generateRandomArray(5,0,100);
        System.out.println(Ra.toString());
        Ra.pushRandomArray(-50);
        System.out.println(Ra.toString());
        int [] tmp = {1,50,66,-11,5};
        generateRandomArray Ra2 = new generateRandomArray(tmp);
        System.out.println(Ra2.toString());
        Ra.doc();
    }

}