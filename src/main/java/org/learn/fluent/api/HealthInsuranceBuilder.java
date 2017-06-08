package org.learn.fluent.api;

import org.learn.fluent.api.HealthInsurance.STAGE;

import java.util.List;

/**
 * Semantic wrapper over @{@link HealthInsurance} domain class.
 * <br><br>
 * <b>Notice that methods here are exposed fluently.</b>
 */
public class HealthInsuranceBuilder
{
    private final HealthInsurance _healthInsurance ;

    // do not allow instantiation via constructor
    private HealthInsuranceBuilder()
    {
        _healthInsurance = new HealthInsurance();
    }

    public static HealthInsuranceBuilder healthInsurance()
    {
        return new HealthInsuranceBuilder();
    }

    public HealthInsuranceBuilder forAge( int age )
    {
        _healthInsurance.setProposerAge(age);
        return this;
    }

    public HealthInsuranceBuilder withProposedSumInsured( long proposedSumInsured )
    {
        _healthInsurance.setProposedSumInsured(proposedSumInsured);
        return this;
    }

    public HealthInsuranceBuilder withPreExistingDiseases(List<String>preExistingDiseases)
    {
        _healthInsurance.setPreExistingIllness(preExistingDiseases);
        return this;
    }

    public HealthInsuranceBuilder withFamilyHistory(List<String> familyHistory)
    {
        _healthInsurance.setFamilyHealthIssues(familyHistory);
        return this;
    }

    public HealthInsuranceBuilder withRiders(List<String> optionalRiders)
    {
        _healthInsurance.setProposedRiders(optionalRiders);
        return this;
    }

    public HealthInsurance build()
    {
        try
        {
            _healthInsurance.setState(STAGE.APPLIED);
            validateMandatoryFields();
        }
        catch (Exception cause)
        {
            _healthInsurance.setState(STAGE.INFORMATION_REQUIRED);
        }
        return _healthInsurance;
    }

    private void validateMandatoryFields()
    {
        // validate all mandatory fields are set
        _healthInsurance.validate();
    }
}
