public class My2DArrayTest{
    //之後會整合成SortAPI
	public static void main(String[] args) {
        int [][] tmp = {{1,50,66,-11,5}, {5,6,11,20,8}};
        new2DArray Ra2 = new new2DArray(tmp);
        new2DArray Ra3 = new new2DArray(tmp, -12, 67);
        System.out.println(Ra2.get2DArraySize() + " " + Ra2.getLowerRange() + " " + Ra2.getUpperRange() + " " + Ra2.getColSize() + " " + Ra2.getRowSize());
        System.out.println(Ra3.get2DArraySize() + " " + Ra3.getLowerRange() + " " + Ra3.getUpperRange() + " " + Ra3.getColSize() + " " + Ra3.getRowSize());
    }
}