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
     * head: pointer to head of list
     * elementCounter: amount of Elements in list
     */
    private static Element head;
    private static int elementCounter = 0;

    /**
     * inner class
     * payload: payload
     * next: pointer to next Element
     */
    private static class Element
    {
        private Object payload;
        private Element next;

        Element(Object payload)
        {
            this.payload = payload;
            this.next = null;
        }

        public Object getPayload() {
            return this.payload;
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
    private class SimpleIteratorImpl implements Iterator<Object>
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
            Object payload = current.getPayload();
            current = current.getNext();
            return payload;
        }
    }

    /**
     * adds Object on top of list and
     * moves head pointer to new Object
     * @param object Object
     */
    @Override
    public void add(Object object)
    {
        if(head == null)
        {
            head = new Element(object);
        }
        else
        {
            Element current = head;

            while(current.getNext() != null)
            {
                current = current.getNext();
            }

            current.setNext(new Element(object));
        }

        elementCounter++;
    }

    /**
     * function to reset the list to original state
     * used int unit test
     */
    public void deleteList()
    {
        head = null;
        elementCounter = 0;
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
