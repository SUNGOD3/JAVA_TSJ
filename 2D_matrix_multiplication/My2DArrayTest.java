public class My2DArrayTest{
    //之後會整合成SortAPI
	public static void main(String[] args) {
        int [][] tmp = {{1,50,66,-11,5}, {5,6,11,20,8}};
        String [] tmp2 = {"1 5 -5 66","15 66 52 88"};
        new2DArray Ra2 = new new2DArray(tmp);
        new2DArray Ra3 = new new2DArray(tmp, -12, 67);
        new2DArray Ra4 = new new2DArray(tmp2);
        System.out.println(Ra2.toString());
        System.out.println(Ra3.toString());
        System.out.println(Ra4.toString());
        generate2DExampleArray Rx = new generate2DExampleArray();
        generate2DRandomArray Ry = new generate2DRandomArray(20, 55, -200, 600);
        new2DArray Ra5 = new new2DArray(Rx.getArray());
        new2DArray Ra6 = new new2DArray(Ry.getArray());
        System.out.println(Ra5.toString());
        System.out.println(Ra6.toString());
    }
}