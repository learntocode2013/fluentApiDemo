package org.learn.fluent.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <b>--- Concerns covered ---</b>
 * <br>
 * <ol>
 *     <li>All shared functionality in the object hierarchy is in the base class</li>
 *     <li>All fluent public methods return a concrete class type</li>
 * </ol>
 *
 * <b>--- Salient features ---</b>
 * <ol>
 *     <li>Make the base class aware of the child class by passing on the information as a type parameter.</li>
 *     <li>Call order of the fluent public methods do not matter</li>
 * </ol>
 *
 * <b>--- Problem with this approach ---</b>
 * <ol>
 *     <li>No way to enforce method call order</li>
 *     <li>No way to validate proper state of created object. Client owns this responsibility</li>
 * </ol>
 *
 */
public abstract class DigitalDevice<Child extends DigitalDevice<Child>>
{
    protected enum TYPE { MEDICAL, COMPUTER, HANDHELD } ;

    // Seems like all are optional parameters, since none of them are final
    // and not enforced via the constructor.
    private TYPE            _type;
    private LocalDateTime   _assemblyTime ;
    private String          _display;

    public String getType()
    {
        return _type.toString();
    }

    public LocalDate getManufacturingDate()
    {
        return _assemblyTime.toLocalDate();
    }

    public String getDisplaySpec() { return _display ; }

    protected Child ofType(TYPE type)
    {
        this._type = type;
        return (Child) this;
    }

    public Child withDisplay(String display)
    {
        this._display = display;
        return (Child) this;
    }

    public Child manufactoredOn(LocalDateTime mfgDateAndTime)
    {
        this._assemblyTime = mfgDateAndTime;
        return (Child) this;
    }
}
