/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        Node node = new Node(-1);
        Node copy = node;
        temp = head;
        while(temp != null) {
            copy.next = map.get(temp);
            copy = copy.next; 
            copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return node.next;
    }
}