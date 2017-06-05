package org.learn.fluent.api;

public interface Planned
{
    Planned chooseBlueprint(BluePrint bluePrint);

    Approved setBudget(double maxBudget);
}
