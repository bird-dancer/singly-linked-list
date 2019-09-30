/**
 *
 * @author felix
 * @param <T>
 */
public class List<T>{
    private Node<T> start;
    
    public void appendNode(Node<T> node){
        if(this.start == null) this.start = node;
        else{
            Node<T> current = this.start;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
        }
    }
    
    @Override
    public String toString(){
        Node<T> current = start;
        String output = "";
        while(current != null){
            output += current.toString() + ", ";
            current = current.getNext();
        }
        return output;
    }

    public Node<T> getStart() {
        return start;
    }

    public void setStart(Node<T> start) {
        this.start = start;
    }
    

    public Node<T> getPrev(Node<T> current){
        Node<T> i = this.start;
        while(i != null && i.getNext() != current){
            i = i.getNext();
        }
        return i;
    }
    
    public void swap(Node<T> k1, Node<T> k2){   
        if(k1 == this.start){
            Node<T> temp = k2.getNext();
            k2.setNext(k1);
            this.start = k2;
            k1.setNext(temp);
        }
        else{
            Node<T> temp = k2.getNext();
            k2.setNext(k1);
            getPrev(k1).setNext(k2);
            k1.setNext(temp);
        }
    }
    
    public int getLength(){
        Node<T> current = this.start;
        int size = 0;
        while(current != null){
            current = current.getNext();
            size++;
        }
        return size;
    }
    
    public void bubbleSort() {
        Node<T> j;
        boolean swapped = true;
        while(swapped){
            j = this.start;
            swapped = false;
            while(j != null && j.getNext() != null){
                if(j.greaterThan(j.getNext())){
                swap(j, j.getNext());
                swapped = true;
                }
                j = j.getNext();
            }
        }
    }
    
    public Node<T> getLast(){
        Node<T> current = this.start;
        while(current.getNext() != null)    current = current.getNext();
        return current;
    }
    
    public void removeNode(Node<T> rmv){
        if(rmv == this.start)   this.start = rmv.getNext();
        else    getPrev(rmv).setNext(rmv.getNext()); 
    }
    
    public void prependNewNode(Node<T> pre){
        Node<T> temp = this.start;
        this.start = pre;
        this.start.setNext(temp);
    }
    
    public void insertNodePrior(Node<T> ins, Node<T> pri){
        if(pri == this.start){
            getPrev(ins).setNext(ins.getNext());
            this.start = ins;
            ins.setNext(pri);
        }
        else{
            getPrev(ins).setNext(ins.getNext());
            getPrev(pri).setNext(ins);
            ins.setNext(pri);
        }
    }
    
    public void quickSort(){
        quickSort(this.start, this.start.getNext(), null);
    }
    
    public void quickSort(Node<T> pivot, Node<T> min, Node<T> max){
        Node<T> temp;
        Node<T> save = pivot;
        while(min != max){
            if(pivot.greaterThan(min)){
                temp = min.getNext();
                insertNodePrior(min, save);
                save = min;
                min = temp;
            }
            else    min = min.getNext();
        }
        if(pivot != max && pivot.getNext() != max)    quickSort(pivot.getNext(), pivot.getNext().getNext(), null);
        if(save != pivot && save.getNext() != pivot)    quickSort(save, save.getNext(), pivot);
    }
}
