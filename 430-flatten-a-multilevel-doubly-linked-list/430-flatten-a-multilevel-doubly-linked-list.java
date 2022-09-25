/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        if(head == null) return null;
        
        Node current = head;
        
        while(current != null) {
            if(current.child != null) {
                if(current.next != null) {
                    stack.push(current.next);
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
            if(current.next == null && !stack.isEmpty()) {
                current.next = stack.peek();
                current.next.prev = current;
                stack.pop();
            }
            current = current.next;
        }
        return head;
    }
}