package leave.manager;

public class MyStack {
    protected UsedLeave []data;
    private static final int DEFAULT_SIZE = 50;
    int ptr = -1;
    
    public MyStack() {
        this(DEFAULT_SIZE);
    }
    
    public MyStack(int size) {
        this.data = new UsedLeave[size];
    }
    
    private boolean isFull() {
        return ptr == data.length-1;
    }
    private boolean isEmpty() {
        return ptr == -1;
    }
    
    public boolean push(UsedLeave item){
        if(isFull()){
            System.out.println("Stack is full!");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    
    public UsedLeave pop() throws Exception{
        if(isEmpty()){
            throw  new Exception("Cannot pop, Stack is empty!");
        }
        return data[ptr--];
    }
    public UsedLeave peek() throws Exception{
        if(isEmpty()){
            throw  new Exception("Cannot show peek, Stack is empty!");
        }
        return data[ptr];
    }
    
    
}
