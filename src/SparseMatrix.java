
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

    }

    public void insert(int row, int column, int value) {
        ValueNode newNode = new ValueNode(row, column, value);
        //they have get methods that return their position
        MatrixRow assignedRow = firstRow;
        MatrixColumn assignedColumn = firstColumn;

        // get corresponding matrix row
        for (int i = 1; i < row; i++){
            assignedRow = assignedRow.getNext();
        }
    }

    public MatrixRow getRow(int position) {
        return null;
    }

    public MatrixColumn getColumn(int position) {
        return null;
    }

    public int getValue(int row, int column) {
        return 0;
    }

    public void print() {

    }

    public SparseMatrix transpose() {
        return null;
    }

    public SparseMatrix produce(SparseMatrix other) {
        return null;
    }
}
