package org.learn.fluent.api;

import java.util.List;

public interface ExpressionBuilder
{
    public String getProposerName();
    public int    getProposerAge() ;
    public long   getProposedSumInsured();
    public List<String> getDeclaredPreExistingIllness();
    public List<String> getFamilyHealthIssues();
    public List<String> getOptedRiders();
}
