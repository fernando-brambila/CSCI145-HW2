public class MyTest {

    public static void main(String[] args){
        MatrixRow testRow = new MatrixRow();

        ValueNode n1 = new ValueNode(1, 1, 10);
        ValueNode n2 = new ValueNode(1, 2, 20);
        ValueNode n3 = new ValueNode(1, 3, 30);
        ValueNode n4 = new ValueNode(1, 4, 40);

        // test: adding to matrix row out of order

        testRow.insert(n3);
        testRow.insert(n2);
        testRow.insert(n1);
        testRow.insert(n4);

        // test: get methods on single row

        int testVal = testRow.get(1);
        System.out.println(testVal);
        testRow.testPrint();
    }

}
