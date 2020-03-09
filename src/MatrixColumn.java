public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        // travelling horizontally!
        ValueNode current = first;
        ValueNode prev;
        int targetRow = value.getRow();

        // case 1: first node
        if (first == null){
            first = value;
            return;
        }

        // case 2: smallest node
        if (first.getRow() > targetRow){
            value.setNextRow(first);
            first = value;
            return;
        }

        // case 3: goes in between
        while (current.getNextRow() != null){
            prev = current;
            current = current.getNextRow();
            if (current.getRow() > targetRow){
                // make value first
                value.setNextRow(current);
                prev.setNextRow(value);
                return;
            }
        }

        // case 3b: is the last/biggest
        current.setNextRow(value);
    }

    public int get(int position) {
        // travel right until you hit specified valuenode (if it exists)
        ValueNode current = first;
        while (current.getRow() < position){
            current = current.getNextRow();
        }
        if (current.getRow() == position){
            return current.getValue();
        }
        // doesn't exist, so return 0
        return 0;
    }

}
