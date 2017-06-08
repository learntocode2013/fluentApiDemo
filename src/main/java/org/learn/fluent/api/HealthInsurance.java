package org.learn.fluent.api;

import java.util.List;

//======================== A domain class with getters and setters ================//
public class HealthInsurance
{
    // mandatory attributes
    private int  proposerAge;
    private long proposedSumInsured;

    // optional attributes
    private List<String> preExistingIllness;
    private List<String> familyHealthIssues;
    private List<String> proposedRiders;

    public enum STAGE { INFORMATION_REQUIRED, APPLIED, PROCESSING, ISSUED, REJECTED };
    private STAGE _status;

    public void setProposerAge(int proposerAge)
    {
        this.proposerAge = proposerAge;
    }

    public void setProposedSumInsured(long proposedSumInsured)
    {
        this.proposedSumInsured = proposedSumInsured;
    }

    public void setPreExistingIllness(List<String> existingIllness)
    {
        preExistingIllness = existingIllness;
    }

    public void setFamilyHealthIssues(List<String> familyHealthIssues)
    {
        this.familyHealthIssues = familyHealthIssues;
    }

    public void setProposedRiders(List<String> optionalRiders)
    {
        proposedRiders = optionalRiders;
    }

    public void setState(STAGE currentStage)
    {
        _status = currentStage;
    }

    public STAGE getStatus() { return _status ; }

    // Client must know when to check for state validation
    public void validate()
    {
        if( proposedSumInsured < 0 )
        {
            throw new IllegalStateException("Sum assured must be a positive number");
        }

        if(proposerAge < 18 || proposerAge > 70)
        {
            throw new IllegalStateException("Proposer age must be between 18 and 70");
        }

        if(preExistingIllness != null && !preExistingIllness.isEmpty()
           && (familyHealthIssues == null || familyHealthIssues.isEmpty()))
        {
            throw new IllegalStateException("Family history is missing from application");
        }
    }
}
