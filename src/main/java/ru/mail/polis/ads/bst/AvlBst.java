package ru.mail.polis.ads.bst;

import org.jetbrains.annotations.NotNull;

/**
 * AVL implementation of binary search tree.
 */
public class AvlBst<Key extends Comparable<Key>, Value>
        implements Bst<Key, Value> {

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int height;

        Node(Key key, Value value, int height) {
            this.key = key;
            this.value = value;
            this.height = height;
        }
    }

    @Override
    public Value get(@NotNull Key key) {
        Node ans = getValue(root, key);
        if(ans == null) return null;
        return ans.value;
    }

    private Node getValue(Node node, Key key){
        if(node == null) return null;
        if(key.compareTo(node.key) < 0) return getValue(node.left, key);
        if(key.compareTo(node.key) > 0) return getValue(node.right, key);
        return node;
    }

    @Override
    public void put(@NotNull Key key, @NotNull Value value) {
        root = putValue(root, key, value);
    }

    private Node putValue(Node node, Key key, Value value){
        if(node == null) return new Node(key, value, 1);
        if(key.compareTo(node.key) < 0) {
            node.left = putValue(node.left, key, value);
        } else if(key.compareTo(node.key) > 0) {
            node.right = putValue(node.right, key, value);
        }
        else {
            node.value = value;
        }
        fixHight(node);
        node = balance(node);
        return node;
    }

    private Node balance(Node x) {
        if (factor(x) == 2) {
            if (factor(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            return rotateRight(x);
        }
        if (factor(x) == -2) {
            if (factor(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            return rotateLeft(x);
        }
        return x;
    }


    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        fixHight(y);
        fixHight(x);
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        fixHight(x);
        fixHight(y);
        return y;
    }

    private void fixHight(Node node){
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int factor(Node node){
        return height(node.left) - height(node.right);
    }

    @Override
    public Value remove(@NotNull Key key) {
        Node ans = getValue(root, key);
        if(ans == null) return null;
        root = delete(root, key);
        return ans.value;
    }

    private Node delete(Node node, Key key){
        if(node == null) return null;
        if(key.compareTo(node.key) < 0) { node.left = delete(node.left, key);}
        if(key.compareTo(node.key) > 0) { node.right = delete(node.right, key);}
        if(key.compareTo(node.key) == 0) {
            node = innerDelete(node);
        }
        return node;
    }

    private Node innerDelete(Node node){
        if(node.right == null) return node.left;
        if(node.left == null) return node.right;
        Node t = node;
        node = min(t.right);
        node.right = deleteMin(t.right);
        node.left = t.left;
        return node;
    }

    private Node deleteMin(Node node){
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }


    @Override
    public Key min() {
        Node min = min(root);
        if(min == null) return null;
        return min.key;
    }

    @Override
    public Value minValue() {
        Node min = min(root);
        if(min == null) return null;
        return min.value;
    }

    private Node min(Node node){
        if(node == null) return null;
        if(node.left == null) return node;
        return min(node.left);
    }

    @Override
    public Key max() {
        Node max = max(root);
        if(max == null) return null;
        return max.key;
    }

    @Override
    public Value maxValue() {
        Node max = max(root);
        if(max == null) return null;
        return max.value;
    }

    private Node max(Node x) {
        if (x == null) {
            return null;
        }
        return x.right == null ? x : max(x.right);
    }

    @Override
    public Key floor(@NotNull Key key) {
        Node ans = floor(root, key);
        if(ans == null) return null;
        return ans.key;
    }

    private Node floor(Node node, Key key){
        if(node == null) return null;
        if(key.compareTo(node.key) == 0) return node;
        if (node.key.compareTo(key) > 0) {
            return floor(node.left, key);
        }

        Node v = floor(node.right, key);
        return v == null ? node: v;
    }

    @Override
    public Key ceil(@NotNull Key key) {
        Node x = ceil(root, key);
        return x == null ? null : x.key;
    }

    private Node ceil(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node;
        }
        if (node.key.compareTo(key) < 0) {
            return ceil(node.right, key);
        }

        Node v = ceil(node.left, key);
        return v == null ? node : v;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return size(x.left) + size(x.right) + 1;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node node){
        if(node == null) return 0;
        return node.height;
    }
}
