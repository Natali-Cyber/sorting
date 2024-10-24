package sorting;


class BinaryTreeSort implements SortingMethod {
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    private void insert(Node node, int value) {
        if (node == null) {
            root = new Node(value);
        } else {
            if (value < node.value) {
                if (node.left == null) {
                    node.left = new Node(value);
                } else {
                    insert(node.left, value);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(value);
                } else {
                    insert(node.right, value);
                }
            }
        }
    }

    private void inorder(Node node, int[] array, int[] index) {
        if (node != null) {
            inorder(node.left, array, index);
            array[index[0]++] = node.value;
            inorder(node.right, array, index);
        }
    }

    @Override
    public void sort(int[] array) {
        for (int value : array) {
            insert(root, value);
        }

        int[] index = {0};
        inorder(root, array, index);
    }
}
