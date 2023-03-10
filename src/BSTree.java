public class BSTree <T extends Comparable<T>>{
    private BSTNode<T> root;

    public BSTree() {
        root = null;
    }

    public void add(T data) {
        if (root == null)
            root = new BSTNode<>(data);
        else
            addRecur(root, data);
    }

    private void addRecur(BSTNode<T> root, T data) {
        //if the data is less than the root
        if (data.compareTo(root.getData()) < 0) {
            if (root.getLeft() == null) { //if left does not exist
                root.setLeft(new BSTNode<>(data));
            }
            else { //left exists, recursively call myself on left subtree
                addRecur(root.getLeft(), data);
            }
        }
        else { //if the data is greater than the root
            if (root.getRight() == null) { //if right does not exist
                root.setRight(new BSTNode<>(data));
            }
            else { //right exists
                addRecur(root.getRight(), data);
            }
        }

    }

    public boolean exists(T data) {
        if (search(data) != null) {
            return true;
        }
        return false;
    }


    public BSTNode<T> search(T data) {
        BSTNode<T> tempRoot;
        if (data.compareTo(root.getData()) == 0) { //if the data is the first tree node ##edge case
            return new BSTNode<>(data);
        }

        else {
            if (data.compareTo(root.getData()) < 0) { //if the data is less than the first
                if (root.getLeft() == null) {
                    return null;
                }
                tempRoot = root.getLeft();
                while (tempRoot.getLeft() != null || tempRoot.getRight() != null || tempRoot != null) { //if the left or right nodes exist or temproot equals something
                    if (data.compareTo(tempRoot.getData()) == 0) {
                        return new BSTNode<>(data);
                    }
                    else if (data.compareTo(tempRoot.getData()) < 0 && tempRoot.getLeft() != null) {
                        tempRoot = tempRoot.getLeft();
                    }
                    else if (data.compareTo(tempRoot.getData()) > 0 && tempRoot.getRight() != null) {
                        tempRoot = tempRoot.getRight();
                    }
                    else {
                        return null;
                    }

                }
            }
            else if (data.compareTo(root.getData()) > 0){ //if the data is greater than the first
                if (root.getRight() == null)
                    return null; //if there is no right subtree return false
                tempRoot = root.getRight();
                while (tempRoot.getLeft() != null || tempRoot.getRight() != null || tempRoot != null) { //if the left or right nodes exist or temproot equals something
                    if (data.compareTo(tempRoot.getData()) == 0) {
                        return new BSTNode<>(data);
                    }
                    else if (data.compareTo(tempRoot.getData()) > 0 && tempRoot.getRight() != null) {
                        tempRoot = tempRoot.getRight();
                    }
                    else if (data.compareTo(tempRoot.getData()) < 0 && tempRoot.getLeft() != null) {
                        tempRoot = tempRoot.getLeft();
                    }
                    else {
                        return null;
                    }
                }
            }
        }
        return null;
    }



    public void printInOrder() {
        printInOrderRecur(root);
    }


    private void printInOrderRecur(BSTNode<T> node) {
        if (node == null)
            return;


        printInOrderRecur(node.getLeft());
        System.out.print(node + ",");
        printInOrderRecur(node.getRight());
    }


    public void delete(T data) {
        //find where data is
        //set whatever it points to to null
        //find what points to the data and set it to point to what the data used to point to
        BSTNode<T> removNode = search(data);

        if (removNode.getLeft() != null) {

        }



    }


    public BSTNode<T> getParent(T data) {
        BSTNode<T> tempRoot;
        if (data.compareTo(root.getData()) == 0) { //if the data is the first tree node ##edge case
            return null;
        }

        else {
            if (data.compareTo(root.getData()) < 0) { //if the data is less than the first
                if (root.getLeft() == null) {
                    return null;
                }
                tempRoot = root.getLeft();
                while (tempRoot.getLeft() != null || tempRoot.getRight() != null || tempRoot != null) { //if the left or right nodes exist or temproot equals something
                    if (data.compareTo(tempRoot.getData()) == 0) {
                        if (root.getLeft().getData().compareTo(data) == 0) {
                            return root;
                        }
                        else return tempRoot;
                    }
                    else if (data.compareTo(tempRoot.getData()) < 0 && tempRoot.getLeft() != null) {
                        tempRoot = tempRoot.getLeft();
                    }
                    else if (data.compareTo(tempRoot.getData()) > 0 && tempRoot.getRight() != null) {
                        tempRoot = tempRoot.getRight();
                    }
                    else {
                        return null;
                    }

                }
            }
            else if (data.compareTo(root.getData()) > 0){ //if the data is greater than the first
                if (root.getRight() == null)
                    return null; //if there is no right subtree return false
                tempRoot = root.getRight();
                while (tempRoot.getLeft() != null || tempRoot.getRight() != null || tempRoot != null) { //if the left or right nodes exist or temproot equals something
                    if (data.compareTo(tempRoot.getData()) == 0) {
                        if (root.getRight().getData().compareTo(data) == 0) {
                            return root;
                        }
                        else return tempRoot;
                    }
                    else if (data.compareTo(tempRoot.getData()) > 0 && tempRoot.getRight() != null) {
                        tempRoot = tempRoot.getRight();
                    }
                    else if (data.compareTo(tempRoot.getData()) < 0 && tempRoot.getLeft() != null) {
                        tempRoot = tempRoot.getLeft();
                    }
                    else {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
