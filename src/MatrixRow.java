import com.sun.jdi.Value;
//TODO: remove debug souts
public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    // sparseMatrix is going to fetch corresponding row, then will pass value node here.
    // from here, set corresponding column by going through all rows up to column number
    public void insert(ValueNode value) {
        ValueNode current = first;
        ValueNode prev;
        int targetColumn = value.getColumn();

        // case 1: this is the first node
        if (first == null){
            System.out.println("Inserted " + value.getValue() + " as first");
            first = value;
            return;
        }

        // case 2: the node has smallest column value in column
        if (first.getColumn() > targetColumn){
            // make value the first
            System.out.println("Inserted " + value.getValue() + " to beginning");
            value.setNextColumn(first); // or current, shouldn't matter?
            first = value;
            return;
        }

        // case 3: stop when current is bigger, prev is smaller, and put val in between
        while (current.getNextColumn() != null){
            prev = current;
            current = current.getNextColumn();
            if (current.getColumn() > targetColumn){
                // put value in between prev and current
                System.out.println("Inserted " + value.getValue() + " in between");
                value.setNextColumn(current);
                prev.setNextColumn(value);
                return;
            }
        }
        System.out.println("Inserted " + value.getValue() + " to last");
        // case 3 b: the end of the list has been reached, thus toInsert has largest column value
        current.setNextColumn(value);
    }

    public int get(int position) {
        // case where first node is desired position
        ValueNode current = first;
        if (first != null && first.getColumn() == position){
            return first.getValue();
        }
        // iterate through nodes until it equals position
        // but it passes it and column > position, it doesn't exist
        while (current.getNextColumn() != null){
            current = current.getNextColumn();
            System.out.println("Current column: " + current.getColumn());
            if (current.getColumn() == position){
                return current.getValue();
            }
            if (current.getColumn() > position){
                System.out.println("missed my stop");
                return 0;
            }
        }
        // case where only one node exists, or position is too high
        System.out.println("end case, only node or too high");
        return 0;
    }

    public void testPrint(){
        System.out.println("Printing MatrixRow content:");
        ValueNode current = first;
        while (current.getNextColumn() != null){
            System.out.println("\t Col:" + current.getColumn() + " | Val:" + current.getValue() + " | " + current.hashCode());
            current = current.getNextColumn();
        }
        System.out.println("\t Col:" + current.getColumn() + " | Val:" + current.getValue() + " | " + current.hashCode());
    }

}