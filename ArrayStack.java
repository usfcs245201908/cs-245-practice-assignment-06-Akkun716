public class ArrayStack<T> implements Stack<T>
{
    T[] stack;
    int top;

    public ArrayStack()
    {
        stack = (T[]) new Object[10];
        //top will record index of the top item
        top = -1;
    }

    public void push(T item)
    {
        if(top == stack.length - 1)
        {
            growStack();
        }

        stack[++top] = item;
    }

    public T pop()
    {
        if(empty())
        {
            try
            {
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("[The stack is empty]");
            }
        }

        return stack[top--];
    }

    public T peek()
    {
        if(empty())
        {
            try
            {
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("[The stack is empty]");
            }
        }

        return stack[top];
    }

    public boolean empty()
    {
        if(top < 0)
        {
            return true;
        }

        return false;
    }
    //Doubles the size of the stack array
    private void growStack()
    {
        T[] copy = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, copy, 0, stack.length);
        stack = copy;
    }
}
