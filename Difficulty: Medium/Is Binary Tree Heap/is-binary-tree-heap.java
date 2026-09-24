/*
class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int size = 0;
    private boolean heap(Node tree) {
        if(tree == null) return true;
        size++;
        if((tree.left == null || tree.data > tree.left.data )
        && (tree.right == null || tree.data > tree.right.data )) {
            return true && isHeap(tree.left) && isHeap(tree.right);
        }
        return false;
    }
    
    private boolean iscbt(Node tree, int s) {
        if(tree == null) return true;
        if(s > size) return false;
        return iscbt(tree.left, s * 2) && iscbt(tree.right, s * 2 + 1);
    }
    
    public boolean isHeap(Node tree) {
        // code here
        return heap(tree) && iscbt(tree, 1);
    }
}