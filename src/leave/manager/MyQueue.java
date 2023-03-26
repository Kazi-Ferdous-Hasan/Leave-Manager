package leave.manager;

public class MyQueue {
    protected Employee []data;
    private static final int DEFAULT_SIZE = 50;
    int end = 0;
    
    public MyQueue() {
        this(DEFAULT_SIZE);
    }
    
    public MyQueue(int size) {
        this.data = new Employee[size];
    }
    
    private boolean isFull() {
        return end == data.length;
    }
    private boolean isEmpty() {
        return end == 0;
    }
    
    public boolean enqueue(Employee val){
        if(isFull()){
            return false;
        }
        data[end++] = val;
        return true;
    }
    
    public Employee dequeue() throws Exception{
        if(isFull()){
            throw new Exception("Cannot delete, the Queue is empty!");
        }
        Employee tmp = data[0];
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return tmp;
    }
    
    public Employee front() throws Exception{
        if(isEmpty()){
            throw new Exception("The Queue is empty!");
        }
        return data[0];
    }
    
    public void printQueue(){
        
        for(int i=0; i<end; i++){
            System.out.println("Information of Employee "+(i+1)+": "); 
            System.out.println("Name: " + data[i].name);
            System.out.println("Gender: " + data[i].gender);
            System.out.println("");
        }
    }
}
