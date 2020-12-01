/*Programmer: Austin Parker
 * Description: This program returns in the console the breadth-first traversal
 * which starts at root. Second it displays the overall height of the binary tree*/

public class MethodsBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Binary {
        static Node root;

        public Binary() {
            root = null;
        }

        /*loop for traversal*/
        void breadthFirstTraversal() {
            int h = height(root);
            int i;
            for (i = 1; i <= h; i++)
                print(root, i);
        }

        /*compares left and right height of binary tree and returns results*/
        int height(Node root) {
            if (root == null)
                return 0;
            else {
                int leftHeight = height(root.left);
                int rightHeight = height(root.right);

                if (leftHeight > rightHeight)
                    return (leftHeight + 1);
                else return (rightHeight + 1);
            }
        }

        /*determines if root level is null, if not calculates*/
        void print(Node root, int level) {
            if (root == null)
                return;
            if (level == 1)
                System.out.print(root.data + " ");
            else if (level > 1) {
                print(root.left, level - 1);
                print(root.right, level - 1);
            }
        }

        /*determines depth of tree*/
        int heightTree(Node node) {
            if (node == null)
                return 0;
            else {
                int leftDepth = heightTree(node.left);
                int rightDepth = heightTree(node.right);
                if (leftDepth > rightDepth)
                    return (leftDepth + 1);
                else
                    return (rightDepth + 1);
            }
        }

        /*main method returning results and displays to user*/
        public static void main(String[] args) {
            Binary tree = new Binary();
            root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            System.out.println("Level order traversal of binary tree is ");
            tree.breadthFirstTraversal();
            System.out.println("\nHeight - " + tree.heightTree(root));
        }/*end of main class*/
    }/*end of binary class*/
}/*end of BST class*/