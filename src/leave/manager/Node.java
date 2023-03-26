package leave.manager;

public class Node {

    public Employee data;
    public String type;
    public Boolean isGranted;
    public int takenLeave;
    public Node next;
    String year;

    public Node(Employee data, String type, Boolean isGranted, int takenLeave, String year) {
        this.data = data;
        this.type = type;
        this.isGranted = isGranted;
        this.takenLeave = takenLeave;
        this.year = year;
    }

    public Node(Employee data, Node next) {
        this.data = data;
        this.next = next;
    }
}
