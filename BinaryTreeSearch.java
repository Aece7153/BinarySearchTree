public class BinaryTreeSearch {
    public class BinaryTreeNode {
        private int value;
        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;
        private BinaryTreeNode parent;

        // Declare the properties of a Binary Tree Node
        public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild, BinaryTreeNode parent){
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        public int getValue(){
            return value;
        }
        public BinaryTreeNode getLeftChild() {
            return leftChild;
        }
        public BinaryTreeNode getRightChild() {
            return rightChild;
        }
        public BinaryTreeNode getParent() {
            return parent;
        }


        public void setValue(int value){
            this.value = value;
        }
        public void setLeftChild(BinaryTreeNode leftChild) {
            this.leftChild = leftChild;
        }
        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;
        }
        public void setParent(BinaryTreeNode parent) {
            this.parent = parent;
        }
    }

    private BinaryTreeNode root;
    private int size;
    BinaryTreeSearch() {
        root = null;
        size = 0;
    }
    BinaryTreeNode getRoot(){
        return this.root;
    }
    int getSize(){
        return this.size;
    }


    // Follow left children to find min
    int getMin(BinaryTreeNode node) {
        if (node.leftChild == null) {
            return node.value;
        }
        return getMin(node.leftChild);

    }
    // Follow right children to find max
    int getMax(BinaryTreeNode node) {
        if (node.rightChild == null) {
            return node.value;
        }
        return getMax(node.rightChild);

    }




    boolean isEmpty(){
        return (size == 0);
    }

    void insert(int keyVal){
        // Make a new node object with value and no connection to other nodes
        BinaryTreeNode newNode = new BinaryTreeNode(keyVal, null, null, null);
        // If this is the first node we will set it as our root
        if (isEmpty()){
            // set new node as root ; increase size of tree by one ; end insert method by return
            root = newNode;size++;return;
        }

        // If the tree is not empty, start at our root node
        BinaryTreeNode current = root;
        BinaryTreeNode parent;

        // loop until a proper insertion point is found.
        while(true){
                 /*
                 Move down the tree and make the current node the parent
                 We will use this loop recursively always starting at the parent node
                 At the end of the loop we assign a new node as the parent and start again from there
                 */

            parent = current;
            // We cannot have duplicate values in our tree
            if (keyVal == current.value){
                System.out.println("Duplicate value found");
                return;
            }
            // If the Key value is less than the current value
            else if (keyVal < current.value){
                // Move to the leftChild
                current = current.leftChild;
                // If there is no left child
                if (current == null){
                    // Make the new Node the left child of the parent
                    parent.leftChild = newNode;
                    // Exit loop
                    break;
                }
            }
            // If the Key value is more than the current node value
            else{
                // Move to the right of the current node
                current = current.rightChild;
                // If rightChild is empty
                if (current == null){
                    // Make this new node the rightChild
                    parent.rightChild = newNode;
                    // Exit loop
                    break;
                }
            }
        }
        //end of loop
        // Set the parent reference for the new node and update the size
        newNode.parent = parent; size++;
    }

    BinaryTreeNode find(BinaryTreeNode node, int keyVal){
        if (node == null){
            System.out.println("search failed");
            return null;
        }
        if (node.value == keyVal){
            return node;
        }
        if (keyVal > node.value){
            return find(node.rightChild, keyVal);
            }
        else {return find(node.leftChild, keyVal);
        }
    }

    void inOrder(BinaryTreeNode node){
        if (node != null){
            inOrder(node.leftChild);
            System.out.print(node.value+",");
            inOrder(node.rightChild);
        }
    }
    void postOrder(BinaryTreeNode node){
        if (node != null){
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.value+",");
        }
    }
    void preOrder(BinaryTreeNode node){
        if (node != null){
            System.out.print(node.value+",");
            preOrder(node.leftChild);
            preOrder(node.rightChild);

        }
    }


        // Method to print the tree structure
        public void printTree() {
            printTreeRecursive(root, 0);
        }
        // Recursive helper method for printing the tree
        private void printTreeRecursive(BinaryTreeNode node, int level) {
            if (node == null) {
                return; // Base case: If the node is null, do nothing
            }

            // Print right subtree first (to display it at the top when visualized)
            printTreeRecursive(node.rightChild, level + 1);

            // Print the current node with indentation based on its level
            System.out.println("   ".repeat(level) + node.value);

            // Print left subtree
            printTreeRecursive(node.leftChild, level + 1);
        }


}
