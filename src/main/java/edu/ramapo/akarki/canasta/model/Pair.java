package edu.ramapo.akarki.canasta.model;

public class Pair<K, V> {

    private K mFirst;
    private V mSecond;

    /**
     * Default Contructor for Pair Class.
     * 
     * @param none
     * 
     * @return none
     */
    public Pair(K aFirst, V aSecond)
    {
        this.mFirst = aFirst;
        this.mSecond = aSecond;
    }

    /**
     * Gets the first item of the pair
     * 
     * @param none
     * 
     * @return object of K by value returns the first item of the pair
     */
    public K getFirst()
    {
        return mFirst;
    }

    /**
     * Gets the second item of the pair
     * 
     * @param none
     * 
     * @return object of K by value returns the second item of the pair
     */
    public V getSecond()
    {
        return mSecond;
    }

    /**
     * Sets the first item of the pair
     * 
     * @param object of type K, sets the passed variable to m_first
     * 
     * @return true to indicate successful setting of the first variable of the
     *         pair
     */
    public boolean setFirst(K aFirst)
    {
        mFirst = aFirst;
        return true;
    }

    /**
     * Sets the second item of the pair
     * 
     * @param object of type V, sets the passed variable to m_second
     * 
     * @return true to indicate a successful setting of the second variable of
     *         the pair
     */
    public boolean setSecond(V aSecond)
    {
        mSecond = aSecond;
        return true;
    }
}