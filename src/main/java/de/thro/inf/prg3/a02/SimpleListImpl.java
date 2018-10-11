package de.thro.inf.prg3.a02;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

/**
 * @author Peter Kurfer
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
            Object tmp = new Element();

            tmp = SimpleListImpl.current;
            current = current.getNext();

            return tmp;
        }
    }

    /**
     * inner class
     * @TODO wofür ist item ?
     */
    private static class Element
    {
        Object item;
        Element next = null;

        Element getNext()
        {
            return this.next;
        }

        public void setNext(Element next) {
            this.next = next;
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
        Object newObject = new Element();

        ((Element) newObject).setNext(head);
        head = (Element) newObject;
    }

    @Override
    public int size()
    {
        return 0;
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
