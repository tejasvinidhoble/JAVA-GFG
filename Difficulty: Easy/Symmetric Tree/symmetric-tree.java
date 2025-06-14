/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/


class Solution {
    public boolean isSymmetric(Node root) {
        // Code here
         if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return (node1.data == node2.data)
            && isMirror(node1.left, node2.right)
            && isMirror(node1.right, node2.left);
        
    }
}