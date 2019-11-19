public class ArrayQueue<T> implements Queue<T>
{
    T[] queue;
    int head, tail, emptyCount;


    public ArrayQueue()
    {
        queue = (T[]) new Object[10];
        //Head will record the index of the last added item in array
        head = -1;
        //tail will record index of the first-most item in array
        tail = 0;
        //When an item is dequeued, this will count number of "empty" spaces in queue array
        emptyCount = 0;
    }

    public T dequeue()
    {
        if(empty())
        {
            try
            {
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("[The queue is empty]");
            }
        }

        T temp = queue[tail++];
        emptyCount++;
        return temp;
    }

    public void enqueue(T item)
    {
        if(head == queue.length - 1)
        {
            growQueue();
        }

        queue[++head] = item;
    }

    public boolean empty()
    {
        if(head < tail)
        {
            return true;
        }

        return false;
    }

    private void growQueue()
    {
        if(head < tail)
        {
            head = -1;
            tail = 0;
            emptyCount = 0;
        }
        else if(emptyCount > 0)
        {
            for(int i = 0; i <= head - emptyCount; i++)
            {
                queue[i] = queue[tail + i];
            }

            head -= tail;
            tail = 0;
            emptyCount = 0;
        }
        else
        {
            T[] copy = (T[]) new Object[queue.length * 2];
            System.arraycopy(queue, 0, copy, 0, queue.length);
            queue = copy;
        }
    }
}
