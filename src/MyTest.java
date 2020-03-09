public class MyTest {

    public static void main(String[] args){
        MatrixRow testRow = new MatrixRow();

        ValueNode n1 = new ValueNode(1, 1, 10);
        ValueNode n2 = new ValueNode(2, 1, 20);
        ValueNode n3 = new ValueNode(3, 1, 30);

        testRow.insert(n1);
        testRow.insert(n2);
        testRow.insert(n3);

        int testVal = testRow.get(2);
        System.out.println(testVal);
        testRow.testPrint();
    }

}
