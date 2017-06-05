package org.learn.fluent.api;

/**
 * <b>--- Concerns covered ---</b>
 * <ol>
 *     <li>Enforce method call order</li>
 *     <li>Allow terminal methods only after proper state is set</li>
 * </ol>
 */
public class WonderfulHouse implements House, Planned, Approved, Contracted, ConstructionTask, Completable
{
    private double _maxBudget ;
    private BluePrint _bluePrint;

    public WonderfulHouse()
    {

    }

    // Allow instantiation only via a factory method
    public static Planned start()
    {
        return new WonderfulHouse();
    }

    @Override
    public Approved setBudget(double maxBudget)
    {
        _maxBudget = maxBudget;
        return this;
    }

    @Override
    public Planned chooseBlueprint(BluePrint bluePrint)
    {
        _bluePrint = bluePrint;
        return this;
    }

    @Override
    public Contracted getAllApprovals()
    {
        // call to some external service....
        return this;
    }

    @Override
    public ConstructionTask chooseContractor(Contractor selectedContractor)
    {
        return this;
    }

    @Override
    public WonderfulHouse commenceConstruction()
    {
        return this;
    }
}
