package edu.nyu.cs.structure.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.nyu.cs.algorithm.util.Check;

public class BST<E extends Comparable<? super E>> {
    private Element<E> root;
    private int size;
    
    private static class Element<E> {
        private final E key;
        private Element<E> parent;
        private Element<E> left;
        private Element<E> right;
        
        Element(E key, Element<E> parent, Element<E> left, Element<E> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        
    }
    
    public BST() {
        root = null;
        size = 0;
    }
    
    public void add(E key) {
        Check.nullCheck(key, "add key");
        
        Element<E> curr = root;
        Element<E> parent = null;
        while (curr != null) {
            parent = curr;
            if (key.compareTo(curr.key) <= 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (parent == null) {
            root = new Element<E>(key, null, null, null);
        } else if (key.compareTo(parent.key) <= 0) {
            parent.left = new Element<E>(key, parent, null, null);
        } else {
            parent.right = new Element<E>(key, parent, null, null);
        }
        size = size + 1;
    }
    
    public void clear() {
        root = null;
        size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        E key = null;
        try {
            key = (E) o;
        } catch (ClassCastException e) {
            return false;
        }
        Element<E> curr = root;
        while (curr != null) {
            if (key.compareTo(curr.key) == 0) {
                return true;
            } else if (key.compareTo(curr.key) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }
    
    public int getSize() {
        return size;
    }
    
    public List<E> keysInOrder() {
        List<E> result = new ArrayList<E>();
        Stack<Element<E>> s = new Stack<Element<E>>();
        Element<E> curr = root;
        while (curr != null || !s.isEmpty()) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                result.add(curr.key);
                curr = curr.right;
            }
        }
        return Collections.unmodifiableList(result);
    }
    
    @SuppressWarnings("unused")
    private void keysInOrderHelper(List<E> result, Element<E> e) {
        if (e != null) {
            keysInOrderHelper(result, e.left);
            result.add(e.key);
            keysInOrderHelper(result, e.right);
        }
    }
    
    public List<E> keysPostOrder() {
        List<E> result = new ArrayList<E>();
        Stack<Element<E>> s1 = new Stack<Element<E>>();
        Stack<Element<E>> s2 = new Stack<Element<E>>();
        Element<E> curr = root;
        if (curr == null) {
            return Collections.unmodifiableList(result);
        }
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }
        }
        while (!s2.isEmpty()) {
            result.add(s2.pop().key);
        }
        return Collections.unmodifiableList(result);
    }
    
    @SuppressWarnings("unused")
    private void keysPostOrderHelper(List<E> result, Element<E> e) {
        if (e != null) {
            keysPostOrderHelper(result, e.left);
            keysPostOrderHelper(result, e.right);
            result.add(e.key);
        }
    }
    
    public List<E> keysPreOrder() {
        List<E> result = new ArrayList<E>();
        Stack<Element<E>> s = new Stack<Element<E>>();
        Element<E> curr = root;
        if (curr == null) {
            return Collections.unmodifiableList(result);
        }
        s.push(curr);
        while (!s.isEmpty()) {
            curr = s.pop();
            result.add(curr.key);
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
        return Collections.unmodifiableList(result);
    }
    
    @SuppressWarnings("unused")
    private void keysPreOrderHelper(List<E> result, Element<E> e) {
        if (e != null) {
            result.add(e.key);
            keysPreOrderHelper(result, e.left);
            keysPreOrderHelper(result, e.right);
        }
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public E max() {
        if (root == null) {
            return null;
        }
        Element<E> curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.key;
    }
    
    private E max(Element<E> e) {
        if (e.right == null) {
            return e.key;
        } else {
            return max(e.right);
        }
    }
    
    public E min() {
        if (root == null) {
            return null;
        }
        Element<E> curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.key;
    }
    
    private E min(Element<E> e) {
        if (e.left == null) {
            return e.key;
        } else {
            return min(e.left);
        }
    }
    
    public E predecessor(E key) {
        if (key == null) {
            return null;
        }
        Element<E> curr = root;
        while (curr != null && key.compareTo(curr.key) != 0) {
            if (key.compareTo(curr.key) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return null;
        } else if (curr.left != null) {
            return max(curr.left);
        } else {
            Element<E> parent = curr.parent;
            while (parent != null && parent.left == curr) {
                curr = parent;
                parent = parent.parent;
            }
            return parent != null ? parent.key : null;
        }
    }
    
    public boolean remove(E key) {
        if (key == null) {
            return false;
        }
        Element<E> curr = root;
        while (curr != null && key.compareTo(curr.key) != 0) {
            if (key.compareTo(curr.key) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return false;
        } else if (curr.left == null) {
            transplant(curr, curr.right);
        } else if (curr.right == null) {
            transplant(curr, curr.left);
        } else {
            Element<E> succ = curr.right;
            while (succ.left != null) {
                succ = succ.left;
            }
            if (succ != curr.right) {
                transplant(succ, succ.right);
                succ.right = curr.right;
                succ.right.parent = succ;
            }
            transplant(curr, succ);
            succ.left = curr.left;
            succ.left.parent = succ;
        }
        size = size - 1;
        return true;
    }
    
    private void transplant(Element<E> u, Element<E> v) {
        if (u.parent == null) {
            root = v;
        } else if (u.parent.left == u) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }
    
    public E successor(E key) {
        if (key == null) {
            return null;
        }
        Element<E> curr = root;
        while (curr != null && key.compareTo(curr.key) != 0) {
            if (key.compareTo(curr.key) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return null;
        } else if (curr.right != null) {
            return min(curr.right);
        } else {
            Element<E> parent = curr.parent;
            while (parent != null && parent.right == curr) {
                curr = parent;
                parent = parent.parent;
            }
            return parent != null ? parent.key : null;
        }
    }
    
}
