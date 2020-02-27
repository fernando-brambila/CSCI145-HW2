public class MyTest {

    public static void main(String[] args){
        MatrixRow testRow = new MatrixRow();

        ValueNode n1 = new ValueNode(1, 1, 1);
        ValueNode n2 = new ValueNode(2, 1, 2);
        ValueNode n3 = new ValueNode(3, 1, 3);

        testRow.insert(n1);
        testRow.insert(n2);
    }

}
