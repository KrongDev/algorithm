package com.krong.structure.non_linear;

import com.krong.structure.non_linear.vo.TreeNode;

import java.util.LinkedList;
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
        bt.add(7);
        bt.add(8);
        bt.add(6);

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
