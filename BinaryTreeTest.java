public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch(); // Assuming `BinaryTree` is the class containing your `insert` method.

        // Test: Insert into an empty tree
        tree.insert(50);
        System.out.println("Root value after first insertion: " + tree.getRoot().getValue()); // get the root node. then get the value


        // Test: Insert smaller value (should go to the left of the root)
        tree.insert(30);
        System.out.println("Left child of root: " + tree.getRoot().getLeftChild().getValue()); // get the root node. then get the left child. and get the value

        // Test: Insert larger value (should go to the right of the root)
        tree.insert(70);
        System.out.println("Right child of root: " + tree.getRoot().getRightChild().getValue()); // get the root node. then get the right child. and get the value





        // Test: Insert multiple values to verify the tree structure
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);


        System.out.println("Left child of node 30: " + tree.getRoot().getLeftChild().getLeftChild().getValue()); // Expected: 20
        System.out.println("Right child of node 30: " + tree.getRoot().getLeftChild().getRightChild().getValue()); // Expected: 40
        System.out.println("Right child of node 40: " + tree.getRoot().getRightChild().getLeftChild().getValue()); // Expected: 60
        System.out.println("Right child of node 70: " + tree.getRoot().getRightChild().getRightChild().getValue()); // Expected: 80


        // Test: Attempt to insert duplicate values
        System.out.println("Inserting duplicate value (50):");
        tree.insert(50); // Expected: "Duplicate value found" printed to the console.

        // Test: Verify size of the tree
        System.out.println("Tree size after all insertions: " + tree.getSize()); // Expected: 7

        // Print the tree structure
        System.out.println("Visualizing the Binary Tree:");
        tree.printTree();

        System.out.println("Finding node with value 40:");
        BinaryTreeSearch.BinaryTreeNode foundNode = tree.find(tree.getRoot(), 40);
        System.out.println("Result: " + foundNode.getValue()); // Expected: 40
        System.out.println("Parent: " + foundNode.getParent().getValue());
        System.out.println("leftChild: " + foundNode.getLeftChild());
        System.out.println("rightChild: " + foundNode.getRightChild());

        System.out.println();
        System.out.println();
        System.out.println("Finding node with value 70:");
        BinaryTreeSearch.BinaryTreeNode foundNode1 = tree.find(tree.getRoot(), 70);
        System.out.println("Result: " + foundNode1.getValue()); // Expected: 70
        System.out.println("Parent: " + foundNode1.getParent().getValue());
        System.out.println("leftChild: " + foundNode1.getLeftChild().getValue());
        System.out.println("rightChild: " + foundNode1.getRightChild().getValue());

        System.out.println("---InOrder Traversal:---");
        tree.inOrder(tree.getRoot());
        System.out.println("\n---PreOrder Traversal:---");
        tree.preOrder(tree.getRoot());
        System.out.println("\n---PostOrder Traversal:---");
        tree.postOrder(tree.getRoot());

        System.out.println("\n\nMinimum Node value is: "+ tree.getMin(tree.getRoot()));
        System.out.println("Maximum Node value is: "+ tree.getMax(tree.getRoot()));








    }


}
