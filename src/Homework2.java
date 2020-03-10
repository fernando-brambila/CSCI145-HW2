  public class Homework2 {
    MatrixReader mr = new MatrixReader();
    SparseMatrix mA;
    SparseMatrix mB;
      public void run() {
        mA = mr.read("matrixA.txt");
        mA.print();
        mB = mr.read("matrixB.txt");
        mB.print();
        SparseMatrix mATranspose = mA.transpose();
        mATranspose.print();
        SparseMatrix mBTranspose = mB.transpose();
        mBTranspose.print();
        SparseMatrix mAProductB = mA.produce(mB);
        mAProductB.print();
      }
  }
