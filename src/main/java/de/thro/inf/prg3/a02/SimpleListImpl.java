package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Benedict Schwind
 * Created on 11/10/18.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object>
{
    /**
     * global variables
     */
    static Element head;
    static int elementCounter = 0;

    /**
     * inner class
     */
    private static class Element
    {
        Object item;
        Element next;

        Element(Object item)
        {
            this.item = item;
            this.next = null;
        }

        public Object getItem() {
            return this.item;
        }

        Element getNext()
        {
            return this.next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    /**
     * inner class
     */
    class SimpleIteratorImpl implements Iterator<Object>
    {
        //initialising iterator with head of list
        private Element current = head;

        @Override
        public boolean hasNext()
        {
            if(current.getNext() == null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        @Override
        public Object next()
        {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }

    /**
     * adds Object on top of list and
     * moves head pointer to new Object
     * @param o Object
     */
    @Override
    public void add(Object o)
    {
        if(head == null)
        {
            head = new Element(o);
            head.setNext(null);
        }
        else
        {
            Element current = head;

            while(current.getNext() != null)
            {
                current = current.getNext();
            }

            current.setNext(new Element(o));
        }

        elementCounter++;
    }

    @Override
    public int size()
    {
        return elementCounter;
    }

    @Override
    public SimpleList filter(SimpleFilter filter)
    {
        return null;
    }

    @Override
    public Iterator iterator() {
        return new SimpleIteratorImpl();
    }
}
