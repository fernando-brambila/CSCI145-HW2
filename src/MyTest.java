public class MyTest {

    public static void main(String[] args){
        MatrixRow testRow = new MatrixRow();
        MatrixColumn testColumn = new MatrixColumn();

        // init row

        ValueNode n1 = new ValueNode(1, 1, 10);
        ValueNode n2 = new ValueNode(1, 2, 20);
        ValueNode n3 = new ValueNode(1, 3, 30);
        ValueNode n4 = new ValueNode(1, 4, 40);

        // init column, shape of matrix resembles Q4

        ValueNode n5 = new ValueNode(2, 1, 50);
        ValueNode n6 = new ValueNode(3, 1, 60);
        ValueNode n7 = new ValueNode(4, 1, 70);
        ValueNode n8 = new ValueNode(5, 1, 80);

        // test: adding to matrix rows/cols out of order

        testRow.insert(n3);
        testRow.insert(n2);
        testRow.insert(n1);
        testRow.insert(n4);
        testRow.testPrint();

        testColumn.insert(n1); // this is the top-left node
        testColumn.insert(n7);
        testColumn.insert(n6);
        testColumn.insert(n5);
        testColumn.insert(n8);
        testColumn.testPrint();

        // test: get methods

        int testVal = testRow.get(2);
        int testVal2 = testColumn.get(2);
        System.out.println("The 2nd get of testRow is:\n\t" + testVal);
        System.out.println("The 2nd get of testColumn is:\n\t" + testVal2);
        System.out.println();

        // test: make a sparse matrix

        SparseMatrix testMatrix = new SparseMatrix(3, 3);
        testMatrix.insert(1, 1, 1);
        testMatrix.insert(1, 2, 2);
        testMatrix.insert(1, 3, 3);
        testMatrix.insert(2, 1, 4);
        testMatrix.insert(2, 2, 5);
        testMatrix.insert(2, 3, 6);
        testMatrix.insert(3, 1, 7);
        testMatrix.insert(3, 2, 8);
        testMatrix.insert(3, 3, 9);

        System.out.println("ORIGINAL");
        testMatrix.print();

        // test: transposed matrix from testMatrix

        System.out.println("TRANSPOSED");
        SparseMatrix testTransposedMatrix = testMatrix.transpose();
        testTransposedMatrix.print();

        // test: product of matrices
        System.out.println("PRODUCT");
        SparseMatrix testProductMatrix = testMatrix.produce(testTransposedMatrix);
        testProductMatrix.print();

        // test: product of matrices with different dimensions
        SparseMatrix m1 = new SparseMatrix(2, 3);
        m1.insert(1, 1, 1);
        m1.insert(1, 2, 2);
        m1.insert(1, 3, 3);
        m1.insert(2, 1, 4);
        m1.insert(2, 2, 5);
        m1.insert(2, 3, 6);

        SparseMatrix m2 = m1.transpose();

        m1.print();
        m2.print();

        System.out.println("PRODUCT # 2");
        SparseMatrix m3 = m1.produce(m2);
        m3.print();

    }

}
