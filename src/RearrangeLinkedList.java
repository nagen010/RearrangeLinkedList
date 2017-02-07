/**
 * Rearrange the LinkedList
 * 1->2->3->4->5 to 1->5->2->4->3
 * Created by nagen on 2/6/17.
 */
public class RearrangeLinkedList {
    static class Node {
        int data;
        Node next;
        Node (int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        RearrangeLinkedList r = new RearrangeLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        System.out.println();
        System.out.println("Reversed List: " );
        printList(head);
        System.out.println();
        System.out.println("Rearranged List: " );
        r.rearrangeList(head);
        printList(head);
    }

    private static void printList(Node input) {
        if(input == null)
            return;

        while(input != null) {
            System.out.print(input.data + "->");
            input = input.next;
        }
    }

    private Node reverseList(Node n) {
        Node prev = null, curr = n, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        n = prev;
        return n;
    }

    private Node rearrangeList(Node n) {
        Node slow = n, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node x = new Node(0), n1 = n, n2 = slow.next;

        slow.next = null;
        Node output = x;
        n2 = reverseList(n2);

        while (n1 != null || n2 != null) {
            if (n1 != null) {
                output.next = n1;
                output = output.next;
                n1 = n1.next;
            }

            if (n2 != null) {
                output.next = n2;
                output = output.next;
                n2 = n2.next;
            }
        }

        output = output.next;
        return output;
    }
}
