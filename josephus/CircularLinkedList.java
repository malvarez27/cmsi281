public class CircularLinkedList extends AbstractLinkedList implements CircularCollectible {
    Node last;

    public CircularLinkedList() {
        super();
        last = null;
    }

    public CircularLinkedList(String[] elements) {
        super(elements);
    }


    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(String s) {
        first = new Node(first, s);
        if (size() == 0) {
            last = first;
        } last.next = first;
          n++;
    }


    public String first() {
        return first.value;    //display first value
    }

    public void remove(String s) {
        boolean remove= false;
        Node current = first;
        for ( int i = 0; i < n && !remove; i++){
            if(current.next.value == s){                //if the following value is = s 
                current.next = current.next.next;       //so make that current value = to next.next to remove
                n--;                                    //linked list size will decrease
                remove = true;
            }
            current = current.next;
        }
    }

    public void removeAll(String s){
         Node current = first;
         for( int i = 0; i < n; i++){               //iterate through the linked list to remove all the string s values
            if(current.next.value ==s){
                current.next = current.next.next;   //way to remove the current
                n--;
            } current= current.next;
         }
    }
    public CircularIterator iterator() {
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements CircularIterator {
         Node current;
        
        public CircularLinkedListIterator() {
            current = new Node (first, "");
        }

        public boolean hasNext() {
            return n == 0;
        }

        public String next() {
            current = current.next;         //return the next value
            return current.value;

        }
        public void remove(){
            current.value = current.next.value;
            current.next = current.next.next;
            if(first.value == current.value){
                first = current;
            } current = new Node (current, "");
              n--;
        }
        public String removeKthElement(int k) {
            for(int i=0; i < k; i++){
                next();
             
            }
            String kth = current.value;
            remove();
            return kth;
        }

        public boolean oneElementLeft() {
            return n == 1;
        }
      }
    }


