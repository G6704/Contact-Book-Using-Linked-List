import org.w3c.dom.ls.LSInput;

import java.util.*;

public class BookList {

    public ListNode head;
    public int size;

    public BookList() {
        head = null;
        size = 0;
    }

    public void run(Scanner s) {
        String opt = "";
        String name = "";
        String phone = "";
        String emailAd = "";
        while(!opt.equals("Q")) {
            start();
            opt = s.nextLine();
            switch (opt) {
                case "A":
                    System.out.print("Name? ");
                    name = s.nextLine();
                    System.out.print("Phone Number? ");
                    phone = s.nextLine();
                    System.out.print("Email Address? ");
                    emailAd = s.nextLine();
                    add(name, phone, emailAd);
                    break;
                case "D":
                    System.out.print("Who would you like to remove? ");
                    name = s.next();
                    del(name);
                    break;
                case "E":
                    System.out.print("Email? ");
                    emailAd = s.next();
                    emailSearch(emailAd);
                    break;
                case "P":
                    print();
                    break;
                case "S":
                    System.out.print("Name? ");
                    name = s.next();
                    search(name);
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        System.exit(0);
    }

    public void start() {
        System.out.println("*************************************************************************");
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail Search");
        System.out.println("(P)rint List");
        System.out.println("(S)earch");
        System.out.println("(Q)uit");
        System.out.println("*************************************************************************");
        System.out.println("Please enter a command: ");
    }

    public void add(String name, String phone, String emailAd) {
        ListNode temp = head;
        if(head == null) {
            head = new ListNode(name, phone, emailAd, null);
        } else {
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(name, phone, emailAd, null);
        }
    }

    public void del(String name) {
        ListNode temp = head;
        ListNode temp2 = temp;
        if (head == null) {
            System.out.println("Does not exist");
            return;
        } else if (head.name.equals(name)) {
            head = head.next;
        } else {
            while (!temp.next.name.equals(name)) {
                temp = temp.next;
                temp2 = temp;
            }
            temp.next = temp2.next.next;
        }
    }

    public void emailSearch(String email) {
        ListNode temp = head;
        if(head == null) {
            System.out.println("Does not exist");
            return;
        } else if(head.email.equals(email)) {
            System.out.println("Name: " + head.name + " Phone: " + head.phone + " Email: " + head.email);
        } else {
            // keep going through list until either temp reaches null or temp points to given email
            while(temp != null && !temp.email.equals(email)) {
                temp = temp.next;
            }
            // condition and action for when email doesn't exist
            if(temp == null) {
                System.out.println("Does not exist");
                return;
            }
            System.out.println("Name: " + temp.name + " Phone: " + temp.phone + " Email: " + temp.email);
        }

    }

    public void print() {
        ListNode temp = head;
        int i = 1;
        if(head == null) {
            System.out.println("Contact Book is empty. Use another command to add a contact");
        } else {
            while(temp != null) {
                System.out.println(i+". "+"Name: " + temp.name + "|| Phone: " + temp.phone + "|| Email: " + temp.email);
                i++;
                temp = temp.next;
            }
        }

    }

    public void search(String name) {
        ListNode temp = head;
        if(head == null) {
            System.out.println("Does not exist");
            return;
        }  else if(head.name.equals(name)) {
            System.out.println("Name: " + head.name + " Phone: " + head.phone + " Email: " + head.email);
        } else {
            // keep going through list until either temp reaches null or temp points to given email
            while(temp != null && !temp.name.equals(name)) {
                temp = temp.next;
            }
            // condition and action for when email doesn't exist
            if(temp == null) {
                System.out.println("Does not exist");
                return;
            }
            System.out.println("Name: " + temp.name + " Phone: " + temp.phone + " Email: " + temp.email);
        }
    }
}