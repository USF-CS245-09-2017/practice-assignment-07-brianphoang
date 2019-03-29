import java.util.*;

public class ArrayList<T> implements List<T>
{
    public int size;
    public T[] arrList;
    
    public ArrayList()
    {
        size = 0;
        Object[] temporaryList = new Object[10];
        arrList = (T[]) temporaryList;
    }
    
    //add item
    //grow if full
    @Override
    public void add(int pos, T item)
    {
        if (size == arrList.length)
        {
            grow();
        }
                
        for (int i = size; i > pos; i++)
        {
            arrList[i] = arrList[i - 1];
        }
        
        arrList[pos] = item;
        size++;
    }

    //add item
    //grow if full
    @Override
    public void add(T item)
    {
        if (size + 1 == arrList.length)
        {
            grow();
        }
        arrList[size++] = item;
    }
    
    //get item position
    @Override
    public T get(int pos)
    {
        return arrList[pos];
    }

    //remove item
    @Override
    public T remove(int pos)
    {
        T t = arrList[pos];
       
        for (int i = pos; i < size; i++)
        {
            arrList[i] = arrList[i + 1];
        }
        size--;
        return t;
    }
    
    //list size
    @Override
    public int size()
    {
        return size;
    }
    
    //creates temporary list that is 2x size of current list
    //copies temporary list to current list
    public void grow()
    {
        T[] temporaryList = (T[]) new Object[arrList.length * 2];
        temporaryList = Arrays.copyOf(arrList, temporaryList.length);
        arrList = temporaryList;
    }
}