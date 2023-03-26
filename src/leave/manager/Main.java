package leave.manager;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome!! ");
        System.out.println("Project Title: Leave Manager");
        System.out.println("Group members name and ID list:");
        System.out.println("1.Kazi Ferdous Hasan\nID: 2020-1-60-053");
        System.out.println("2.Karib Shams\nID: 2020-1-60-056");
        System.out.println("3.Nowshin Tasnia\nID: 2020-1-60-197\n\n");
        
        User user = new User();
        Admin a = new Admin();
        int option;
        
        System.out.println("Enter your choice: ");
        System.out.println("Press (1) if you are Employee");
        System.out.println("Press (2) if you are Admin");
        System.out.println("Press (0) to EXIT");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        do {
            if (option == 1) {
                user.showHomePage(a);
                user.showAllLeave();
            } else if (option == 2) {
                a.showHomePage(user);
            }
            System.out.println("Enter your choice: ");
            System.out.println("Press (1) if you are Employee");
            System.out.println("Press (2) if you are Admin");
            System.out.println("Press (0) to EXIT");
            option = sc.nextInt();  
        } while (option != 0);
    }
}
