package leave.manager;

import java.util.Scanner;

public class Admin {

    MyQueue queue = new MyQueue();
    MyStack stack = new MyStack();
    User users;
    public Admin(){
        
    }
    
    void showOption(){
        System.out.println("Enter your choice: ");
        System.out.println("Press (1) to Add Employee");
        System.out.println("Press (2) to Show All Employee");
        System.out.println("Press (3) to Manage Leave");
        System.out.println("Press (4) to View Report");
        System.out.println("Press (0) to EXIT");
    }
    
    void showHomePage(User user) {
        int n;
        users = user;
        showOption();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(true){
            if(n==0)break;
            else if(n==1){addEmployee();break;}
            else if(n==2){showEmployee();break;}
            else if(n==3){manageLeaves(user);break;}
            else if(n==4){viewReport();break;}
            
            /*switch (n) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    manageLeaves(user);
                    break;
                case 4:
                    viewReport();
                default:
                    break;
            }*/
            //showOption();
            n = sc.nextInt();
            
        }//while(n != 0);
    }
    
    void addEmployee(){
        String name, gender;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter gender: ");
        gender = sc.nextLine();
        System.out.println("");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setGender(gender);
        
        queue.enqueue(employee);
        showHomePage(users);
    }

    
    private void showEmployee() {
        queue.printQueue();
    }
    
    
    private void manageLeaves(User user){
        int n;
        System.out.println("Press (1) to show all leaves");
        System.out.println("Press (2) to approve leaves");
        System.out.println("Press (0) to EXIT");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        do{
            if(n == 1){
                showLeaves(user);
            } else if(n == 2){
                approaveLeaves(user);
            }
        System.out.println("Press (1) to show all leaves");
        System.out.println("Press (2) to approve leaves");
        System.out.println("Press (0) to EXIT");
            n = sc.nextInt();
        }while(n != 0);
    }
    
    private void showLeaves(User user){
        MyLinkedList leaves = user.leaves;
        
        Node temp = leaves.head;
        while (temp != null) {
            System.out.println("Leave status: ");
            System.out.println("Name: " + temp.data.name);
            System.out.println("Leave Type: " + temp.type);
            System.out.println("Taken Leave: " + temp.takenLeave);
            System.out.println("Status: " + temp.isGranted);
            System.out.println("");
            temp = temp.next;
        }
    }
    
    
    private void approaveLeaves(User user){
        MyLinkedList leaves = user.leaves;
        String name, type;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter Leave type:");
        type = sc.nextLine();
        
        
        Node temp = leaves.head;
        while (temp != null) {
            if (temp.data.name.equalsIgnoreCase(name) && temp.type.equalsIgnoreCase(type)){
                temp.isGranted = true;
                UsedLeave ul = new UsedLeave();
                ul.setEmployee(temp.data);
                ul.setYear(temp.year);
                if (type.equalsIgnoreCase("casual")) {
                    ul.setCasualLeave(temp.takenLeave);
                }else if (type.equalsIgnoreCase("sick")) {
                    ul.setSickLeave(temp.takenLeave);
                }if (type.equalsIgnoreCase("annual")) {
                    ul.setAnnualLeave(temp.takenLeave);
                }
                
                stack.push(ul);
                //String str = "x";
                break;
                
            } 
            
            temp = temp.next;
        }
        
        showLeaves(user);
    }

    private void viewReport() {
        String year;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year to view yearly report: ");
        year = sc.next();
        for (UsedLeave data : stack.data) {
            if (data == null) {
                break;
            }
            if (data.year.equalsIgnoreCase(year)) {
                System.out.println("Yearly Leave report: ");
                System.out.println("Name: " + data.employee.name);
                System.out.println("Used Casual Leave: " + data.casualLeave);
                System.out.println("Used Sick Leave: " + data.sickLeave);
                System.out.println("Used Annual Leave: " + data.annualLeave);
                System.out.println("");
                if (data.employee.gender.equalsIgnoreCase("female")) {
                    System.out.println("Used Maternity Leave: " + data.maternityLeave);
                    System.out.println("");
                }
            }
        }
    }
}
