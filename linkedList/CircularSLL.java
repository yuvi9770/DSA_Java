package linkedList;

class nodes{
    int data;
    nodes next;

    public nodes(int data) {
        this.data = data;
    }
}

public class CircularSLL {

    public nodes addToEmpty(nodes last, int data){
        if (last != null) {
            return last;
        }

        nodes newNode = new nodes(data);
        last = newNode;
        newNode.next = last;
        return last;
    }

    public nodes addFront(nodes last, int data){
        if (last == null) {
            return addToEmpty(last, data);
        }

        nodes newNode = new nodes(data);
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    public nodes addEnd(nodes last, int data){
        if (last == null) {
            return addToEmpty(last, data);
        }

        nodes newNode = new nodes(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    // add after particular item if present in ll
    public nodes addAfterItem(nodes last, int data, int item){
        if (last == null) {
            return null;
        }
        nodes p = last.next;
        do{
            if (p.data == item) {
                nodes newNode = new nodes(data);
                newNode.next = p.next;
                p.next = newNode;

                if (p == last) {
                    last = newNode;
                }
                return last;
            }
            p = p.next;

        }while(p != last.next);

        System.out.println(item + " not exists");
        return last;
    }

    // traverse
    public void traverse(nodes last){
        if (last == null) {
            System.out.println("ll is empty");
            return;
        }
        nodes p = last.next;
        do{
            System.out.print(p.data + " ");
            p = p.next;
        }while(p != last.next);
        System.out.println();
    }

    // deleteFirst
    public nodes deleteFirst(nodes last){
        if (last == null) {
            System.out.println("ll is empty");
            return null;

        }else if (last.next == last) {
            last = null;
            return null;
        }

        last.next = last.next.next;
        return last;
    }

    // deleteLast
    public nodes deletelast(nodes last){
        if (last == null) {
            System.out.println("ll is empty");
            return null;

        }else if (last.next == last) {
            last = null;
            return null;
        }

        nodes curr = last;

        while (curr.next != last) {
            curr = curr.next;
        }

        curr.next = curr.next.next; // last.next
        return curr;
    }

    // find length of CLL
    public static int length(nodes last){
        if (last == null) {
            return 0;
        }
        nodes curr = last;
        int count = 0;

        do{
            curr = curr.next;
            count++;
        }while(curr != last);

        return count;
    }

    // deleteAtPos
    public nodes deleteAtPos(nodes last, int index){
        int len = length(last);

        if (last == null) {
            System.out.println("ll is empty");
            return null;

        }else if (index >= len || index < 0) {
           System.out.println("index out of range"); 
           return null;

        }else if (index == 0) {
            return deleteFirst(last);

        }else if (index == len-1) {
            return deletelast(last);
        }

        int count = 1;
        nodes prev = last.next;
        nodes curr = last.next.next;

        while (index != count) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        prev.next = curr.next;
        return last;
    }

    // deletenode by key(data)
    public nodes deletenode(nodes last, int key){
        if (last == null) {
            System.out.println("ll is empty");
            return null;

        }else if (last.data == key && last.next == last) {
            last = null;
            return last;

        }else if (last.data == key && last.next != last) {
            return deletelast(last);
        }

        nodes temp = last; nodes d = null;

        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next.data == key) {
            d = temp.next;
            temp.next = d.next;

        }else{
            System.out.println("element not found");
        }

        return last;
    }

    
    public static void main(String[] args) {
        CircularSLL ll = new CircularSLL();
        nodes last = null;

        last = ll.addToEmpty(last, 80);
        last = ll.addFront(last, 10);
        last = ll.addEnd(last, 9);
        last = ll.addAfterItem(last, 16, 10);
        ll.traverse(last);

        last = ll.deleteFirst(last);
        ll.traverse(last);
        System.out.println(last.data);

        last = ll.deletelast(last);
        ll.traverse(last);

        System.out.println(length(last));
        last = ll.deleteAtPos(last, 2);
        ll.traverse(last);

        last = ll.deletenode(last, 80);
        ll.traverse(last);
    }
}