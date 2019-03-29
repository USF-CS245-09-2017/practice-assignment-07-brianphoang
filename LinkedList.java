class Node<T> 
{
    public Node<T> next;
    public T data;
    
    public Node(T data)
    {
        this.data = data;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public Node<T> getNext()
    {
        return next;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }
}
    
public class LinkedList<T> implements List<T>
{    
    public int size;
    public Node<T> head;
    
    //dummy head
    public LinkedList()
    {
        size = 0;
        head = new Node(null); 
    }
    
    //adds to list
    @Override
    public void add(int pos, T item)
    {
        Node<T> previousNode = head;
        for (int i = 0; i < pos - 1; i++)
        {
            previousNode = previousNode.next;
        }
        Node<T> newNode = new Node(item);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        size++;
    }

    //adds to list
    @Override
    public void add(T item)
    {
        Node<T> currentNode = head;
        while (currentNode.next != null)
        {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(item);
        size++;
    }
    
    //get item position
    @Override
    public T get(int pos)
    {        
        Node<T> currentNode = head;        
        for (int i = 0; i <= pos; i++)
        {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }
    
    //remove item
    @Override
    public T remove(int pos)
    {
        Node<T> previousNode = head;
        for (int i = 0; i < pos - 1; i++)
        {
            previousNode = previousNode.next;
        }
        T t = previousNode.next.data;
        previousNode.next = previousNode.next.next;
        size--;
        return t;
    }

    //list size
    @Override
    public int size()
    {
        return size;
    }
   
}