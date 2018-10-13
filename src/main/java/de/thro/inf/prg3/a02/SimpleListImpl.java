package de.thro.inf.prg3.a02;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * @author Benedict Schwind
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable
{
    /**
     * global variables
     */
    static Element head;
    static Element current;
    static int eCounter = 0;

    /**
     * inner class
     */
    private static class Element
    {
        Object item;
        Element next = null;

        Element(Object item)
        {
            this.item = item;
            this.next = null;
        }

        public Object getItem() {
            return item;
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
    static class SimpleIteratorImpl implements Iterator
    {
        @Override
        public boolean hasNext()
        {
            if(SimpleListImpl.current.getNext() == null)
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
            current = head;

            while(current.getNext() != null)
            {
                current = current.getNext();
            }

            current.setNext(new Element(o));
        }

        eCounter++;
    }

    @Override
    public int size()
    {
        return eCounter;
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
