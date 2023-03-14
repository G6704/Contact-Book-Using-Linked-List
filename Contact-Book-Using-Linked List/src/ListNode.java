public class ListNode {
    public ListNode next;
    public String name;
    public String email;
    public String phone;

    public ListNode(String name, String phone, String email, ListNode next) {
        this.name = name;
        this.email = email;
        this.phone = phone;

        this.next = next;
    }

    public ListNode() {
        next = null;
        name = "Add Name";
        email = "Add Email";
        phone = "Add Phone Number";
    }

}
