package org.learn.fluent.api;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Stream;

/**
 * An immutable domain class with getters only
 */
public class HealthInsurance
{
    public enum STAGE { INFORMATION_REQUIRED, APPLIED, PROCESSING, ISSUED, REJECTED };

    // mandatory attributes
    private final String        proposerName;
    private final int           proposerAge;
    private final long          proposedSumInsured;
    private final List<String>  preExistingIllness;
    private final List<String>  familyHealthIssues;
    private final List<String>  proposedRiders;
    private STAGE         status;

    public HealthInsurance(HealthInsuranceBuilder constructionBuilder)
    {
        proposerName        = constructionBuilder.getProposerName();
        proposerAge         = constructionBuilder.getProposerAge();
        proposedSumInsured  = constructionBuilder.getProposedSumInsured();
        preExistingIllness  = constructionBuilder.getDeclaredPreExistingIllness();
        familyHealthIssues  = constructionBuilder.getFamilyHealthIssues();
        proposedRiders      = constructionBuilder.getOptedRiders();
        status              = STAGE.APPLIED;
    }

    public int getProposerAge(int proposerAge)
    {
        return proposerAge;
    }

    public long getProposedSumInsured(long proposedSumInsured)
    {
        return proposedSumInsured;
    }

    public Stream<String> getPreExistingIllness()
    {
       return preExistingIllness.stream();
    }

    public List<String> getFamilyHealthIssues() { return familyHealthIssues ; }

    public List<String> getProposedRiders() { return proposedRiders ; }

    public STAGE getStatus() { return status ; }

    // Client must know when to check for state validation
    public void validate()
    {
        String errMsg = StringUtils.EMPTY;

        if( proposedSumInsured < 0 )
        {
            errMsg = "Sum assured must be a positive number";
        }

        if(proposerAge < 18 || proposerAge > 70)
        {
            errMsg = "Proposer age must be between 18 and 70";
        }

        if(preExistingIllness != null && !preExistingIllness.isEmpty()
           && (familyHealthIssues == null || familyHealthIssues.isEmpty()))
        {
            errMsg = "Family history is missing from application";
        }

        if(StringUtils.isNotEmpty(errMsg))
        {
            status = STAGE.INFORMATION_REQUIRED;
            throw new IllegalStateException(errMsg);
        }
    }
}
