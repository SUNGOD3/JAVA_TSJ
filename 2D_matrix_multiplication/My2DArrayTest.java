public class My2DArrayTest{
    //之後會整合成SortAPI
	public static void main(String[] args) {
        int [][] tmp = {{1,50,66,-11,5}, {5,6,11,20,8}};
        new2DArray Ra2 = new new2DArray(tmp);
        new2DArray Ra3 = new new2DArray(tmp, -12, 67);
        System.out.println(Ra2.toString());
        System.out.println(Ra3.toString());
    }
}