package org.learn.fluent.api;

/**
 * Created by disen on 05/06/17.
 */
public class BluePrint
{
    private final String _details ;

    private BluePrint(String details)
    {
        this._details = details;
    }

    public static BluePrint from(String details)
    {
        return new BluePrint(details);
    }

    @Override
    public String toString() {
        return "BluePrint{" +
               "_details='" + _details + '\'' +
               '}';
    }
}
