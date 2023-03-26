package leave.manager;

public class MyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public void insert(Employee val, String type, Boolean isGranted, String year) {
        //Node node = new Node(val, type, isGranted);

        if (head == null) {
            insertAtFirst(val, type, isGranted, 1, year);
        } else {
            Node node = search(val);
            if (node != null && node.type.equals(type)) {
                node.takenLeave++;
            } else {
               
                insertAtLast(val, type, isGranted, 1, year);
                
            }
            
        }
    }

    public void insertAtFirst(Employee val, String type, Boolean isGranted, int takenLeave, String year) {
        Node node = new Node(val, type, isGranted, takenLeave, year);
        
        head = node;
        tail = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }


    public void insertAtLast(Employee val, String type, Boolean isGranted, int takenLeave, String year) {
        if (tail == null) {
            insertAtFirst(val, type, isGranted, takenLeave, year);
            return;
        }
        Node node = new Node(val, type, isGranted, takenLeave,year);
        tail.next = node;
        tail = node;
        size++;
    }

    public Node get(int idx) {
        Node node = head;
        for (int i = 0; i < idx; i++) {
            node = node.next;
        }
        return node;
    }

    public Node search(Employee val) {
        Node node = head;
        while (node != null) {
            if (node.data.name.equalsIgnoreCase(val.name)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Employee deleteFirst() {
        Employee val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public Employee deleteAtIndex(int idx) {
        if (idx == 0) {
            return deleteFirst();
        }
        if (idx == size - 1) {
            return deleteLast();
        }
        Node prev = get(idx - 1);
        Employee val = prev.next.data;
        return val;
    }

    public Employee deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node sl = get(size - 2);
        Employee val = tail.data;
        tail = sl;
        tail.next = null;
        return val;
    }

    public Boolean isLeaveAvailable(Employee e) {
        Node node = search(e);

        if (node != null) {
            if (node.type.equalsIgnoreCase("casual") && node.takenLeave > 15) {
                return false;
            } else if (node.type.equalsIgnoreCase("sick") && node.takenLeave > 12) {
                return false;
            } else if (node.type.equalsIgnoreCase("annual") && node.takenLeave > 2) {
                return false;
            }
            return true;
        }
        return true;
    }

    public void printList() {
        Node temp = head;
        
        while (temp != null) {
            System.out.println("Information: ");
            System.out.println("Name: " + temp.data.name);
            System.out.println("Leave Type: " + temp.type);
            System.out.println("Taken Leave: " + temp.takenLeave);
            System.out.println("");
            temp = temp.next;
        }
        
    }
}
