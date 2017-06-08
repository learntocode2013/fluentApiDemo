package org.learn.fluent.api;

/**
 * <b>--- Concerns covered ---</b>
 * <ol>
 *     <li>Enforce method call order</li>
 *     <li>Allow terminal methods only after proper state is set</li>
 * </ol>
 *
 * <b>--- Problem with this approach ---</b>
 * <ol>
 *     <li>Too many interfaces required to honor call ordering</li>
 *     <li>No way to validate proper state of created object. Client owns this responsibility</li>
 * </ol>
 */
public class WonderfulHouse implements Planned, Approved, Contracted, ConstructionTask, Completable
{
    private double _maxBudget ;
    private BluePrint _bluePrint;
    private enum STATE { INPROGRESS, COMPLETED } ;
    private STATE _builtStatus;

    public WonderfulHouse()
    {

    }

    // Allow instantiation only via a factory method
    public Planned start()
    {
        return this;
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
    public void commenceConstruction()
    {
        this._builtStatus = STATE.COMPLETED;
    }

    public boolean isCompleted()
    {
        return this._builtStatus.equals(STATE.COMPLETED);
    }

    @Override
    public String toString() {
        return "WonderfulHouse{" +
               "_maxBudget=" + _maxBudget +
               ", _bluePrint=" + _bluePrint +
               ", _builtStatus=" + _builtStatus +
               '}';
    }
}
