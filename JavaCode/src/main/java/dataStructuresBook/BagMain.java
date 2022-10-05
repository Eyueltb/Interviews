/*
package dataStructuresBook;

import java.util.Iterator;
import java.util.NoSuchElementException;

*/
/**
 * http://tomgu1991.github.io/blog/Technical/DS_Al/notes_on_ds_abs_java/Notes%20on%20Data%20Structures%20and%20Abstractions%20with%20Java.html
 *//*

public class BagMain {
}
class ArrayBag<T> implements BagInterface<T>{
    private T[] bag;
    private static final int DEFAUTL_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag(){this(DEFAUTL_CAPACITY);}

    public ArrayBag(int cap){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tem = (T[])new Object[cap];
        bag = tem;
    }

    // add:
    // check full
    // bag[numberOfEntries] = T; num++
    // isFull
    // num == bag.length
    // toArray
    // new Object
    // forEach assign
    // isEmpty
    // num is 0
    // getCurrentSize()
    // return num
    // getFrequencyOf(T)
    // ForEach count
    // contains
    // while(not found and has more)
    // if equals -> return,break
    // clear
    // not empty() -> remove()
    // remove
    // bag[num-1] = null; num--;
    // remove(T)
    // getIndex
    // remove index
    // removeEntry(index)
    // num--; bag[index] = bug[num];bug[num]=null; // change index and the last entry
    // getIndex
    // forEach check
}


class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode; // address of the most recently element
    private int num;

    private class Node{
        T data;
        Node next;
    }
    // begin
    // newNode references a new instance of Node, place data in newNode，num++
    // firstNode = address of newNode
    // add
    // newNode references a new instance of Node, place data in newNode, link to firstNode
    // firstNode = address of newNode,num++
    // toArray | getFrequencyOf | contains
    // while -> from firstNode
    // remove
    // firstNode = firstNode.next, num--
    // remove(T)
    // locate node N, replace with firstNode, remove()
    //
}

interface StackInterface<T> {
    void push(T t);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}

class LinkedStack<T> implements StackInterface<T>{
    private Node topNode;

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
    // constructor
    // push(T)
    // newNode; topNode = newNode
    // T peek()
    // topNode#data
    // T pop()
    // tem = peek();topNode = topNode#next
}

interface QueueInterface<T> {
    public void enqueue(T newEntry);
    public T dequeue();
    public T getFront();
    public boolean isEmpty();
    public void clear();
}
//Double-ended queue (Deque “deck”)
interface DequeInterface<T> {
    public void addToFront(T newEntry);
    public void addToBack(T newEntry);
    public T removeFront();
    public T removeBack();
    public T getFront();
    public T getBack();
    public boolean isEmpty();
    public void clear();
}

*/
/**
 * Priority Queue
 * The ADT priority queue organizes objects according to their priorities.
 * Exactly what form a prior- ity takes depends on the nature of the object.
 *//*

interface PriorityQueueInterface<T extends Comparable<? super T>> {
    public void add(T newEntry);
    public T remove();
    public T peek();
    public boolean isEmpty();
    public int getSize();
    public void clear();
}
*/
/**
 *  Adding a tail reference—an external reference to the last node in the chain—is one approach to this problem and is the one we will take here.
 *//*


class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    // enqueue(T)
    // newNode;
    // if empty -> firstNode = newNode; else lastNode#next = newNode
    // lastNode = newNode
    // getFront()
    // notEmpt() -> firstNode#data; null
    // dequeue()
    // front = firstNode#data, firstNode= firsNode#next
    // isEmpty()
    // firstNode and lastNode both null
}

*/
/**
 * Deque - Doubly linked chain
 *//*


public class DLNode {
    private T data;
    private DLNode next;
    private DLNode previous;
}

class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode first;
    private DLNode last;
    // addToBack
    // newNode(last, newEntry, null)
    // empty? first = newNode: last#next=new
    // last = new
    // addToFront
    // newNode(null, newEntry, first)
    // empty? last = newNode : first#pre = newNode
    // first = newNode
    // removeFront
    // empty -> null
    // front = first#data
    // first = first#next
    // first null? last = null : first#pre = null
    // removeBack
    // empty -> null
    // back = last#data
    // last = last#prev
    // last null ? first = null : last#next = null
}

*/
/**
 * Lists
 *//*


interface ListInterface<T> {
    public void add(T newEntry);
    public boolean add(int pos, T newEntry);
    public T remove(int pos);
    public void clear();
    public boolean replace(int pos, T newEntry);
    public T getEntry(int pos);
    public boolean contains(T anEntry);
    public int getLength();
    public boolean isEmpty();
    public T[] toArray();
}

*/
/**
 * Lists implementation as Arrays
 *//*


class AList<T> implements ListInterface<T> {
    private T[] list:
    private int num;

    @Override
    public void add(T newEntry) {

    }

    @Override
    public boolean add(int pos, T newEntry) {
        return false;
    }

    @Override
    public T remove(int pos) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean replace(int pos, T newEntry) {
        return false;
    }

    @Override
    public T getEntry(int pos) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }
    // constructor

    // ensureCapacity
    // if num == list.length
    // list = Arrays.copyof(list, 2*list.length)
    // makeRoom(pos)
    // check pos; nIndex = pos -1;
    // for lastIndex to nIndex -> list[index+1] = list[index]
    // removeGap(pos)
    // check pos; rIndex = pos-1;
    // for rIndex to lastIndex -> list[index] = list[index+1]

    // add(T)
    // ensureCapacity();
    // list[num] = T
    // num++;
    // toArray
    // build array
    // add(pos, T)
    // check pos; ensureCap; makeRoom(pos),list[pos-1]=T;num++
    // remove(pos)
    // check pos; result = list[pos-1];
    // removeGap(pos);num--
    // replace | getEntry ==> easy
    // contains
    // for to check
}

*/
/**
 * Lists implementation as Linked Data
 *//*

class LList<T> implements ListInterface<T> {
    private Node first;
    private Node last;
    private int num;

    @Override
    public void add(T newEntry) {

    }

    @Override
    public boolean add(int pos, T newEntry) {
        return false;
    }

    @Override
    public T remove(int pos) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean replace(int pos, T newEntry) {
        return false;
    }

    @Override
    public T getEntry(int pos) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    class Node{

    }
    // getNodeAt(pos)
    // check pos
    // for counter=1 to pos; currentNode = currentNode#next; return currentNode

    // add(T)
    // if empty -> first = last = newNode
    // else -> last#next=newNode; last = newNode
    // num++
    // add(pos, T)
    // check pos
    // pos = 1; newNode#next = first;first = newNode
    // pos !=1;
    //bef=getNodeAt(pos);
    //aft=nodeBefore#next;
    //bef#next=newNode;newNode#nex=aft
    // num++
    // isEmpty()
    // check num
    // remove(pos)
    // check pos;
    // pos = 1; first = first#next;
    // pos !=1;
    // bef = getNodeAt(pos-1);rmv = bef#next;aft=rmv#next
    // bef#next=aft
    // num--
    // replace(pos, T)
    // node = getNodeAt(pos); node#data=T
    // getEntry
    // node = getNodeAt(pos); node#data
    // contains(T)
    // while

}

*/
/**
 * Iterators
 * An iterator is an object that traverses a collection of data
 *//*


interface ListWithIteratorInterface<T> extends ListInterface<T> {
    public Iterator<T> getIterator();
}

class LinkedListWithIterator<T> implements ListWithIteratorInterface<T> {
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    } // end getIterator

    @Override
    public void add(T newEntry) {

    }

    @Override
    public boolean add(int pos, T newEntry) {
        return false;
    }

    @Override
    public T remove(int pos) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean replace(int pos, T newEntry) {
        return false;
    }

    @Override
    public T getEntry(int pos) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    private class IteratorForLinkedList implements Iterator<T> {
        private Node nextNode;
        private IteratorForLinkedList() {
            nextNode = firstNode;
        }
        // other methods
        // public T next()
        // nextNode = nextNode#next
        // return nextNode#data
        // public boolean hasNext()
        // nextNode != null
    }
}

*/
/**
 * Sorted List
 *//*

interface SortedListInterface<T extends Comparable<? super T>> {
    public void add(T nEntry);
    public boolean remove(T anEntry);
    public int getPosition(T anEntry);
    public T getEntry(int givenPosition);
    public boolean contains(T anEntry);
    public T remove(int givenPosition);
    public void clear();
    public int getLength();
    public boolean isEmpty();
    public T[] toArray();
}

class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
    private Node first;
    private int num;

    @Override
    public void add(T nEntry) {

    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        return 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T remove(int givenPosition) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }
    // getNodeBef(e)
    // while(cur!=null && e.compareTo(cur) > 0)
    // bef = cur;cur=cur#next
    // add
    // newNode; bef=getNodeBef(newNode)
    // if empty -> new#next(first); first=newNode
    // else -> aft=bef#next;new#next=aft;bef#next=newNode
    // num++
}

*/
/**
 * Dictionaries-The dictionary, map, table contains entries that each have two parts: keyword and value.
 *//*



interface DictionaryInterface<K, V> {
    public V add(K key, V value);
    public V remove(K key);
    public V getValue(K key);
    public boolean contains(K key);
    public Iterator<K> getKeyIterator();
    public Iterator<V> getValueIterator();
    public boolean isEmpty();
    public int getSize();
    public void clear();
}

*/
/**
 *  Dictionary Implementation
 *//*


class Entry<S, T> {
    private S key;
    private T value;
}
class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {
    private Entry<K, V>[] dictionary; // array of unsorted entries
    private int numberOfEntries;
    private final static int DEFAULT_CAPACITY = 25;

    @Override
    public V add(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        return null;
    }

    @Override
    public Iterator<V> getValueIterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

    }

    // localIndex(k)
    // while -> equals

    // add(k,v)
    // key=localIndex(k)
    // key < num -> dic[key]#data=v
    // else -> dic[num] = new Entry(k,v)
    // num++
    // remove
    // exist -> index, delete index, move last here
    // not ->
}

*/
/**
 * Trees
 *//*


interface TreeInterface<T> {
    public T getRootData();
    public int getHeight();
    public int getNumberOfNodes();
    public boolean isEmpty();
    public void clear();
}

interface TreeIteratorInterface<T> {
    public Iterator<T> getPreorderIterator();
    public Iterator<T> getPostorderIterator();
    public Iterator<T> getInorderIterator();
    public Iterator<T> getLevelOrderIterator();
}

interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T> {
    public void setTree(T rootData);
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree);
}

*/
/**
 * Tree implementation
 * stack -> inorder
 * queue -> level order
 *//*


interface BinaryNodeInterface<T> {
    public T getData();
    public void setData(T newData);
    public BinaryNodeInterface<T> getLeftChild();
    public BinaryNodeInterface<T> getRightChild();
    public void setLeftChild(BinaryNodeInterface<T> leftChild);
    public void setRightChild(BinaryNodeInterface<T> rightChild);
    public boolean hasLeftChild();
    public boolean hasRightChild();
    public boolean isLeaf();
    public int getNumberOfNodes();
    public int getHeight();
}

*/
/*interface BinaryTreeInterface<T> extends TreeInterface<T>,
        TreeIteratorInterface<T> {
    public void setTree(T rootData);
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree);
}*//*


class BinaryNode<T> implements BinaryNodeInterface<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNodeInterface<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<T>(data);
        if (left != null)
            newRoot.left = (BinaryNode<T>)left.copy();
        if (right != null)
            newRoot.right = (BinaryNode<T>)right.copy();
        return newRoot; } // end copy

    public int getHeight() {
        return getHeight(this); // call private getHeight
    } // end getHeight

    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null)
            height = 1 + Math.max(getHeight(node.left),
                    getHeight(node.right));
        return height;
    } // end getHeight

    @Override
    public T getData() {
        return null;
    }

    @Override
    public void setData(T newData) {

    }

    @Override
    public BinaryNodeInterface<T> getLeftChild() {
        return null;
    }

    @Override
    public BinaryNodeInterface<T> getRightChild() {
        return null;
    }

    @Override
    public void setLeftChild(BinaryNodeInterface<T> leftChild) {

    }

    @Override
    public void setRightChild(BinaryNodeInterface<T> rightChild) {

    }

    @Override
    public boolean hasLeftChild() {
        return false;
    }

    @Override
    public boolean hasRightChild() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    public int getNumberOfNodes() {
        int leftNumber = 0; int rightNumber = 0;
        if (left != null)
            leftNumber = left.getNumberOfNodes();
        if (right != null)
            rightNumber = right.getNumberOfNodes();
        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes

}

 class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNodeInterface<T> root;

    private void privateSetTree(T rootData, BinaryTree<T> leftTree,
                                BinaryTree<T> rightTree){
        root = new BinaryNode<T>(rootData);
        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root.copy());
        if ((rightTree != null) && !rightTree.isEmpty())
            root.setRightChild(rightTree.root.copy());
    } // end privateSetTree

     @Override
     public T getRootData() {
         return null;
     }

     public int getHeight() {
        return root.getHeight(); } // end getHeight

    public int getNumberOfNodes() {
        return root.getNumberOfNodes(); } // end getNumberOfNodes

     @Override
     public boolean isEmpty() {
         return false;
     }

     @Override
     public void clear() {

     }

     @Override
     public Iterator<T> getPreorderIterator() {
         return null;
     }

     @Override
     public Iterator<T> getPostorderIterator() {
         return null;
     }

     @Override
     public Iterator<T> getInorderIterator() {
         return null;
     }

     @Override
     public Iterator<T> getLevelOrderIterator() {
         return null;
     }

     @Override
     public void setTree(T rootData) {

     }

     @Override
     public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {

     }
 }
*/
/*
class InorderIterator implements Iterator<T> {
    private StackInterface<BinaryNodeInterface<T>> nodeStack;
    private BinaryNodeInterface<T> currentNode;

    public InorderIterator() {
        nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
        currentNode = root;
    } // end default constructor

    public boolean hasNext() {
        return !nodeStack.isEmpty() || (currentNode != null);
    } // end hasNext

    public T next() {
        BinaryNodeInterface<T> nextNode = null;
        // find leftmost node with no left child
        while (currentNode != null) {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
        } // end while
        // get leftmost node, then move to its right subtree
        if (!nodeStack.isEmpty()) {
            nextNode = nodeStack.pop();
            assert nextNode != null; // since nodeStack was not empty
            // before the pop
            currentNode = nextNode.getRightChild();
        }else
            throw new NoSuchElementException();
        return nextNode.getData();
    } // end next

}

*//*

*/
/**
PreOrder
    1. result = currentNode#data
    2. push(current#right)
    3. current= current#left

 PostOrder

    self, left
    if no left, right,
    if no right, end
    pop one,return result, currentNode = stack.peek#right
*//*


*/
/**
 * Graph
 * In a graph, the circles are called vertices, or nodes, and the lines are called edges. A graph, then, is a collection of distinct vertices and distinct edges. A subgraph is a portion of a graph that is itself a graph, just as the road map in Figure 28-1 actually is a part of a larger map.
 *//*


*/
/**
 * BFS
 * Algorithm getBreadthFirstTraversal(originVertex) {
 *   traversalOrder = anewqueuefortheresultingtraversalorder
 *   vertexQueue = anewqueuetoholdverticesastheyarevisited
 *
 *   Mark originVertex as visited
 *   traversalOrder.enqueue(originVertex)
 *   vertexQueue.enqueue(originVertex)
 *
 *   while (!vertexQueue.isEmpty()) {
 * 	frontVertex = vertexQueue.dequeue()
 * 	while (frontVertex has a neighbor) {
 * 	  nextNeighbor = nextneighboroffrontVertex
 * 	  if (nextNeighbor is not visited) {
 * 	    Mark nextNeighbor as visited
 * 	    traversalOrder.enqueue(nextNeighbor)
 * 	    vertexQueue.enqueue(nextNeighbor)
 *            }
 * 	}
 *   }
 *   return traversalOrder
 * }
 *//*


*/
/**
 * DFS
 * Algorithm getDepthFirstTraversal(originVertex) {
 *   traversalOrder = anewqueuefortheresultingtraversalorder
 *   vertexStack = anewstacktoholdverticesastheyarevisited
 *
 *   Mark originVertex as visited
 *   traversalOrder.enqueue(originVertex)
 *   vertexStack.push(originVertex)
 *
 *   while (!vertexStack.isEmpty()) {
 * 	topVertex = vertexStack.peek()
 * 	if (topVertex has a nunvisited neighbor) {
 * 		nextNeighbor = nextunvisitedneighboroftopVertex
 *         Mark nextNeighbor as visited
 *         traversalOrder.enqueue(nextNeighbor)
 *         vertexStack.push(nextNeighbor)
 *        } else // all neighbors are visited
 *       vertexStack.pop()
 *   }
 *   return traversalOrder
 * }
 *//*


*/
/**
 * Topological Order
 * Algorithm getTopologicalOrder()
 * vertexStack = a new stack to hold vertices as they are visited
 * numberOfVertices = number of vertices in the graph
 * for (counter = 1 to numberOfVertices)
 * {
 * nextVertex = an unvisited vertex whose neighbors,if any,are all visited
 * Mark nextVertex as visited
 * vertexStack.push(nextVertex)
 * }
 * return vertexStack
 *//*


*/
/**
 *    Graph implementation
 *    Two common implementations of the ADT graph use either an array or a list to represent the graph’s edges.
 *    The array is typically a two-dimensional array called an adjacency matrix.
 *    The list is called an adjacency list. Each of these constructs represents the connections—that is,
 *    the edges—among the vertices in the graph.
 *   From an adjacency matrix, you quickly can see whether an edge exists between any two given ver- tices.
 *   This operation is O(1). But if you want to know all the neighbors of a particular vertex,
 *   you need to scan an entire row of the matrix, an O(n) task. Additionally, the matrix occupies a consider- able,
 *   fixed amount of space that depends on the number of vertices but not on the number of edges.
 *   An adjacency list for a given vertex represents only those edges that originate from the vertex.
 *//*


class Vertex<T> */
/*implements VertexInterface<T>*//*
 {
    private T label;
    private ListWithIteratorInterface<T> edgeList;
    private boolean visited;
    //private VertexInterface<T> previousVertex;
    private double cost;

    */
/*public boolean connect(VertexInterface<T> endVertex, double edgeWeight){
        // check exist
    }*//*

    public boolean hasNeighbor(){}
    //public VertexInterface<T> getUnvisitedNeighbor(){}
}

class DirectedGraph<T> */
/*implements GraphInterface<T>*//*
 {
    //private DictionaryInterface<T, VertexInterface<T>> vertices;
    private int edgeCount;

    public boolean addVertex(T vertexLabel){  return false; }
    public boolean addEdge(T begin, T end, double edgeWeight){ return false;}
    public boolean hasEdge(T begin, T end){ return false; }
}*/
