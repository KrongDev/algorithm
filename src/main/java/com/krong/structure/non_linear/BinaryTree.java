package com.krong.structure.non_linear;

import com.krong.structure.non_linear.vo.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    TreeNode<Integer> root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer value) {
        root = add(root, value);
    }

    private TreeNode<Integer> add(TreeNode<Integer> current, Integer value) {
        if(current == null) {
            return new TreeNode<>(value);
        }

        if(current.getValue() < value) {
            current.setRight(add(current.getRight(), value));
        } else {
            current.setLeft(add(current.getLeft(), value));
        }

        return current;
    }

    private TreeNode<Integer> add(TreeNode<Integer> current, TreeNode<Integer> prevNode) {
        if(current == null) {
            return prevNode;
        }

        if(current.getValue() < prevNode.getValue()) {
            current.setRight(add(current.getRight(), prevNode));
        } else {
            current.setLeft(add(current.getLeft(), prevNode));
        }

        return current;
    }

    public void remove(Integer value) {
        root = remove(root, value);
    }

    private TreeNode<Integer> remove(TreeNode<Integer> current, Integer value) {
        if(current == null) return null;

        if(!Objects.equals(current.getValue(), value)) {
            current.setLeft(remove(current.getLeft(), value));
            current.setRight(remove(current.getRight(), value));
            return current;
        }

        // Leaf일 때 삭제
        if(current.getRight() == null && current.getLeft() == null)
            return null;

        if(current.getLeft() == null) return current.getRight();
        if(current.getRight() == null) return current.getLeft();

//        // 중위 전임자(In-order Predecessor)
//        TreeNode<Integer> predecessor = predecessor(current.getLeft());
//        predecessor.setRight(current.getRight());
//        if(current.getLeft() != null)
//           add(predecessor, current.getLeft());
//        return predecessor;

        // 중위 후속자(In-order Successor)
        TreeNode<Integer> successor = successor(current.getRight());
        successor.setLeft(current.getLeft());
        if(current.getRight() != null)
            add(successor, current.getRight());

        return successor;

    }

    // 중위 전임자(In-order Predecessor): 삭제할 노드의 왼쪽 서브트리에서 가장 큰 값을 가진 노드.
    private TreeNode<Integer> predecessor(TreeNode<Integer> current) {
        if(current.getRight() == null)
            return current;

        TreeNode<Integer> predecessor =  predecessor(current.getRight());
        if(Objects.equals(current.getRight().getValue(), predecessor.getValue()))
            current.setRight(null);

        return predecessor;
    }

    // 중위 후속자(In-order Successor): 삭제할 노드의 오른쪽 서브트리에서 가장 작은 값을 가진 노드.
    private TreeNode<Integer> successor(TreeNode<Integer> current) {
        if(current.getLeft() == null)
            return current;

        TreeNode<Integer> successor =  successor(current.getLeft());
        if(Objects.equals(current.getLeft().getValue(), successor.getValue()))
            current.setLeft(null);
        return successor;
    }


    // 전위 순회 (Pre-order Traversal) 출력 메서드
    public void traversePreOrder(TreeNode<Integer> node) {
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    // 중위 순회 (In-order Traversal) 출력 메서드
    public void traverseInOrder(TreeNode<Integer> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    // 후위 순회 (Post-order Traversal) 출력 메서드
    public void traversePostOrder(TreeNode node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(" " + node.getValue());
        }
    }

    // 레벨 순회 (Level-order Traversal) 출력 메서드
    public void traverseLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(" " + node.getValue());

            if (node.getLeft() != null) queue.add(node.getLeft());
            if (node.getRight() != null) queue.add(node.getRight());
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(5);
        bt.add(2);
        bt.add(3);
        bt.add(1);
        bt.add(0);
        bt.add(7);
        bt.add(8);
        bt.add(6);

        bt.remove(5);

        // 순회 결과 출력
        System.out.print("Pre-order traversal:");
        bt.traversePreOrder(bt.root);
        System.out.println();

        System.out.print("In-order traversal:");
        bt.traverseInOrder(bt.root);
        System.out.println();

        System.out.print("Post-order traversal:");
        bt.traversePostOrder(bt.root);
        System.out.println();

        System.out.print("Level-order traversal:");
        bt.traverseLevelOrder(bt.root);
        System.out.println();
    }
}
