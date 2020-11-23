package ru.mail.polis.ads.hash;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class HashTableRealize<Key, Value> implements HashTable<Key, Value> {

    private int capacity = 16;
    private int size = 0;
    private final double loadFactor = 0.75;

    private Node<Key, Value>[] tableHash = new Node[capacity];

    private static class Node<Key, Value>{
        Key key;
        Value value;
        Node<Key, Value> nextNode;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int localCode(Key key){
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    @Override
    public @Nullable Value get(@NotNull Key key) {
        int localCode = localCode(key);
        Node<Key, Value> node = tableHash[localCode];
        while (node != null && !key.equals(node.key)){
            node = node.nextNode;
        }
        return node == null ? null : node.value;
    }

    @Override
    public boolean containsKey(@NotNull Key key) {
        int localHash = localCode(key);
        Node<Key, Value> parent = tableHash[localHash];
        if(parent == null) return false;
        while (parent != null && !key.equals(parent.key)){
            parent = parent.nextNode;
        }
        return parent != null;
    }

    @Override
    public void put(@NotNull Key key, @NotNull Value value) {
        int localCode = localCode(key);
        if(tableHash[localCode] == null){
            tableHash[localCode] = new Node<>(key, value);
            size++;
        }
        else {
            Node<Key, Value> parent = tableHash[localCode];
            do {
                if (parent.key.equals(key)) {
                    parent.value = value;
                    break;
                }
                if (parent.nextNode == null) {
                    parent.nextNode = new Node<>(key, value);
                    size++;
                    break;
                }
                parent = parent.nextNode;
            } while (true);
        }
        if(loadFactor < (double)size/capacity){
            rehash();
        }
    }

    private void rehash(){
        Node<Key, Value>[] oldTable = tableHash;
        capacity = capacity * 2;
        tableHash = new Node[capacity];
        for(Node<Key, Value> node : oldTable){
            while (node != null){
                put(node.key, node.value);
                node = node.nextNode;
            }
        }
    }

    @Override
    public @Nullable Value remove(@NotNull Key key) {
        int localCode = localCode(key);
        Node<Key, Value> parent = tableHash[localCode];
        if(parent == null) return null;
        if(key.equals(parent.key)){
            Value value = parent.value;
            tableHash[localCode] = null;
            size--;
            return value;
        }
        while (parent.nextNode != null && !key.equals(parent.nextNode.key)){
            parent = parent.nextNode;
        }
        if(parent.nextNode == null) return null;
        Value value = parent.nextNode.value;
        parent.nextNode = parent.nextNode.nextNode;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
