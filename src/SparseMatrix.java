
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        totalRows = rows;
        totalColumns = columns;

        // initialize all matrix rows
        this.firstRow = new MatrixRow();
        MatrixRow currentRow = firstRow;
        for (int i = 0; i < totalRows - 1; i++){
            MatrixRow newMatrixRow = new MatrixRow();
            currentRow.setNext(newMatrixRow);
            currentRow = currentRow.getNext();
        }

        // initialize all matrix columns
        this.firstColumn = new MatrixColumn();
        MatrixColumn currentColumn = firstColumn;
        for (int i = 0; i < totalColumns - 1; i++){
            MatrixColumn newMatrixColumn = new MatrixColumn();
            currentColumn.setNext(newMatrixColumn);
            currentColumn = currentColumn.getNext();
        }
    }

    public void insert(int row, int column, int value) {
        ValueNode newNode = new ValueNode(row, column, value);
        MatrixRow homeRow = getRow(row);
        MatrixColumn homeColumn = getColumn(column);

        homeRow.insert(newNode);
        homeColumn.insert(newNode);
    }

    public MatrixRow getRow(int position) {
        MatrixRow current = firstRow; // this offsets iteration index
        for (int i = 0; i < position - 1; i++){
            if (current.getNext() == null){
                System.out.println("getRow: Hit max, returning last");
                break;
            }
            current = current.getNext();
        }
        //System.out.println("Returning matrix row: " + current.hashCode());
        return current;
    }

    public MatrixColumn getColumn(int position) {
        // traveling right
        MatrixColumn current = firstColumn;
        for (int i = 0; i < position - 1; i++){
            if (current.getNext() == null){
                System.out.println("getColumn: Hit max, returning last");
                break;
            }
            //System.out.println("step");
            current = current.getNext();
        }
        return current;
    }

    public int getValue(int row, int column) {
        // navigate to corresponding row's first node
        MatrixRow startRow = getRow(row);
        ValueNode current = startRow.getFirst();
        // traverse rightwards through nodes until column is reached
        // case 0: nothing exists
        if (current == null){
            return 0;
        }
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
        System.out.println("Printing Matrix:");
        MatrixRow currentRow = firstRow;
        // for each row...
        for (int row = 1; row < totalRows + 1; row++){
            for (int col = 1; col < totalColumns + 1; col++){
                System.out.print(getValue(row, col) + "\t");
            }
            //currentRow = currentRow.getNext();
            System.out.print("\n");
        }
        System.out.println();
    }

    public int getTotalRows(){
        return totalRows;
    }

    public int getTotalColumns(){
        return totalColumns;
    }

    public SparseMatrix transpose() {
        // TODO: write better while loops

        int newRows = totalColumns;
        int newColumns = totalRows;
        SparseMatrix transposedMatrix = new SparseMatrix(newRows, newColumns);

        // for each row in this obj, copy nodes to corresponding transposed matrix column
        MatrixRow currentRow = firstRow;
        ValueNode currentNode = firstRow.getFirst();
        // go through rows

        while (currentRow.getNext() != null) {
            if (currentNode == null){
                // there are no nodes in this row, so skip to next row
                currentRow = currentRow.getNext();
                currentNode = currentRow.getFirst();
                continue;
            }
            // go through all nodes in this row and insert to transposed
            while (currentNode.getNextColumn() != null) {
                int nodeRow = currentNode.getColumn();
                int nodeColumn = currentNode.getRow();
                int nodeValue = currentNode.getValue();
                transposedMatrix.insert(nodeRow, nodeColumn, nodeValue);
                currentNode = currentNode.getNextColumn();
            }
            // case: last node in row
            int nodeRow = currentNode.getColumn();
            int nodeColumn = currentNode.getRow();
            int nodeValue = currentNode.getValue();
            transposedMatrix.insert(nodeRow, nodeColumn, nodeValue);

            currentRow = currentRow.getNext();
            currentNode = currentRow.getFirst();
        }
        // case: last row
        // go through all nodes in this row and insert to transposed
        if (currentNode != null) {
        while (currentNode.getNextColumn() != null) {
            int nodeRow = currentNode.getColumn();
            int nodeColumn = currentNode.getRow();
            int nodeValue = currentNode.getValue();
            transposedMatrix.insert(nodeRow, nodeColumn, nodeValue);
            currentNode = currentNode.getNextColumn();
        }
        // case: last node in row

            int nodeRow = currentNode.getColumn();
            int nodeColumn = currentNode.getRow();
            int nodeValue = currentNode.getValue();
            transposedMatrix.insert(nodeRow, nodeColumn, nodeValue);
        }

        return transposedMatrix;
    }

    public SparseMatrix produce(SparseMatrix other) {
        SparseMatrix productMatrix = new SparseMatrix(totalRows, other.getTotalColumns());

        // directly implemented from assignment pseudocode
        for (int i = 1; i <= totalRows; i++){ // total rows in matrix A
            for (int j = 1; j <= other.getTotalColumns(); j++){ // total columns in matrix B
                int sum = 0;
                for (int k = 1; k <= totalColumns; k++){
                    int toAdd = getValue(i, k) * other.getValue(k, j);
                    sum += toAdd;
                }
                productMatrix.insert(i, j, sum);
            }

        }

        return productMatrix;
    }
}
