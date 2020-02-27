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

    public void insert(ValueNode value) {
        //TODO: insert in sorted order
        ValueNode current = first;
        while (current.getNextRow() != null){
            current = current.getNextRow();
        }
        current.setNextRow(value);
    }

    public int get(int position) {
        int count = 0;
        ValueNode current = first;
        while (current != null){
            current = current.getNextRow();
            count += 1;
            if (count == position){
                return current.getValue();
            }
        }
        //if nothing is found, return 0
        return 0;
    }

}