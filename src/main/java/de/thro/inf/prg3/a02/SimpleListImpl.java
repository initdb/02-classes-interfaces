package de.thro.inf.prg3.a02;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList
{
	Element head;

    private static class Element
    {
        Object item;
        Element next;
    }

    @Override
    public void add(Object o)
    {

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
}
