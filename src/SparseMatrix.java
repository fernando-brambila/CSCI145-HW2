
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        // initialize all matrix rows
        this.firstRow = new MatrixRow();
        MatrixRow currentRow = firstRow;
        for (int i = 0; i < rows - 1; i++){
            MatrixRow newMatrixRow = new MatrixRow();
            currentRow.setNext(newMatrixRow);
            currentRow = currentRow.getNext();
        }

        // initialize all matrix columns
        this.firstColumn = new MatrixColumn();
        MatrixColumn currentColumn = firstColumn;
        for (int i = 0; i < columns - 1; i++){
            MatrixColumn newMatrixColumn = new MatrixColumn();
            currentColumn.setNext(newMatrixColumn);
            currentColumn = currentColumn.getNext();
        }
    }

    public void insert(int row, int column, int value) {

    }

    public MatrixRow getRow(int position) {
        // traveling down
        MatrixRow current = firstRow;
        for (int i = 0; i < position; i++){
            if (current.getNext() == null){
                System.out.println("Couldn't find desired MatrixRow");
                return null;
            }
            current = current.getNext();
        }
        return current;
    }

    public MatrixColumn getColumn(int position) {
        // traveling right
        MatrixColumn current = firstColumn;
        for (int i = 0; i < position; i++){
            if (current.getNext() == null){
                System.out.println("Couldn't find desired MatrixColumn");
                return null;
            }
            current = current.getNext();
        }
        return current;
    }

    public int getValue(int row, int column) {
        // navigate to corresponding row's first node
        MatrixRow startRow = getRow(row);
        ValueNode current = startRow.getFirst();
        // traverse rightwards through nodes until column is reached
        // case 1: the first node is the desired node
        if (current.getColumn() == column){
            return current.getValue();
        }
        // case 2: the node belongs to another node
        while (current.getNextColumn() != null){
            current = current.getNextColumn();
            if (current.getColumn() == column){
                return current.getValue();
            }
        }
        // at this point, nothing exists
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
