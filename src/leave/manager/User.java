package leave.manager;
import java.util.Scanner;

public class User {
    MyLinkedList leaves = new MyLinkedList();
    Employee employee = new Employee();
    void showOption() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your choice: ");
        System.out.println("Press(1) to Request Leave");
        System.out.println("Press (0) to EXIT");
        int n,m;
        n = sc.nextInt();
        do {
            switch (n) {
                case 1:
                    leaveOption();
                    m = sc.nextInt();
                    do {
                switch (m) {
                    case 1:
                        applyForCasualLeave();
                        break;
                    case 2:
                        applyForSickLeave();
                        break;
                    case 3:
                        applyForAnnualLeave();
                        break;
                    case 4:
                        applyForMaternityLeave();
                        break;
                    default:
                        break;
                }
                        leaveOption();
                        m = sc.nextInt();
                    } while (m != 0);
                    break;
            //showEmployee();
                case 2:
                    break;
                case 3:
                    Admin a = new Admin();
                    // a.showHomePage();
                    break;
                default:
                    break;
            }
            
            System.out.println("Enter your choice: ");
            System.out.println("Press(1) to Request Leave");
            System.out.println("Press (0) to EXIT");
            n = sc.nextInt();
        } while (n != 0);
    }

    void leaveOption() {
        System.out.println("Enter your choice: ");
        System.out.println("Press(1) for Casual Leave");
        System.out.println("Press (2) for Sick Leave");
        System.out.println("Press (3) for Annual Leave");

        if (employee.getGender().equalsIgnoreCase("female")) {
            System.out.println("Press (4) for Maternity Leave");
        }
        System.out.println("Press (0) to EXIT");
    }
    
    void showHomePage(Admin a) {
        int flag = 0;
        MyQueue queue = a.queue;
        employee = new Employee();
        String name, gender;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        for (Employee data : queue.data) {
            if (data == null) {
                break;
            }
            if (data.name.equalsIgnoreCase(name)) {
                employee.setGender(data.gender);
                employee.setName(data.name);
                flag = 1;
                break;
            }
        }
        if(flag == 1){
           showOption();
        }
        else if (flag == 0){
            System.out.println("You are not a registered user.");
        }
        
    }

    private void applyForCasualLeave() {
        String year;
        Scanner sc = new Scanner(System.in);
        if (leaves.isLeaveAvailable(employee)) {
            System.out.println("Enter year: ");
            year = sc.next();
            leaves.insert(employee, "Casual", false,year);
        } else {
            System.out.println("You don't have available leaves");
        }
    }
    private void applyForSickLeave() {
        String year;
        Scanner sc = new Scanner(System.in);
        if (leaves.isLeaveAvailable(employee)) {
            System.out.println("Enter year: ");
            year = sc.next();
            leaves.insert(employee, "Sick", false, year);
        } else {
            System.out.println("You don't have available leaves");
        }
    }
    private void applyForAnnualLeave() {
        String year;
        Scanner sc = new Scanner(System.in);
        if (leaves.isLeaveAvailable(employee)) {
            System.out.println("Enter year: ");
            year = sc.next();
            leaves.insert(employee, "Annual", false,year);
        } else {
            System.out.println("You don't have available leaves");
        }
    }
    private void applyForMaternityLeave() {
        String year;
        Scanner sc = new Scanner(System.in);
        if (leaves.isLeaveAvailable(employee)) {
            System.out.print("Enter year: ");
            year = sc.next();
            leaves.insert(employee, "Maternity", false,year);
        } else {
            System.out.println("You don't have available leaves");
        }
    }
    
    public void showAllLeave(){
        leaves.printList();
    }
}
