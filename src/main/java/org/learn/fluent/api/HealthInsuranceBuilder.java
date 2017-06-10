package org.learn.fluent.api;

import org.learn.fluent.api.HealthInsurance.STAGE;

import java.util.ArrayList;
import java.util.List;

/**
 * Semantic wrapper over @{@link HealthInsurance} domain class.
 * <br><br>
 * --- Pros of this approach ---
 * <ul>
 *     <li>Public methods are exposed fluently</li>
 *     <li>Immutable domain class @{@link HealthInsurance} is built incrementally</li>
 * </ul>
 *
 * --- Cons of this approach ---
 * <ul>
 *     <li>Attributes of domain class @{@link HealthInsurance} duplicated in here</li>
 * </ul>
 */
public class HealthInsuranceBuilder
{
    // mandatory attributes
    private String  _proposerName;
    private int     _proposerAge;
    private long    _proposedSumInsured;
    private STAGE   _status;
    private List<String> _preExistingIllness = new ArrayList<>();
    private List<String> _familyHealthIssues = new ArrayList<>();
    private List<String> _proposedRiders     = new ArrayList<>();

    private HealthInsurance _healthInsurance ;

    // do not allow instantiation via constructor
    private HealthInsuranceBuilder()
    {

    }

    public static HealthInsuranceBuilder healthInsurance()
    {
        return new HealthInsuranceBuilder();
    }

    public HealthInsuranceBuilder forSubject(String name)
    {
        _proposerName = name;
        return this;
    }

    public String getProposerName()
    {
        return _proposerName;
    }

    public HealthInsuranceBuilder ofAge(int age )
    {
        _proposerAge = age;
        return this;
    }

    public int getProposerAge()
    {
        return _proposerAge;
    }

    public HealthInsuranceBuilder withProposedSumInsured( long proposedSumInsured )
    {
        _proposedSumInsured = proposedSumInsured;
        return this;
    }

    public long getProposedSumInsured() { return _proposedSumInsured; }

    public HealthInsuranceBuilder withPreExistingDiseases(List<String>preExistingDiseases)
    {
        _preExistingIllness = preExistingDiseases;
        return this;
    }

    public List<String> getDeclaredPreExistingIllness() { return _preExistingIllness ; }

    public HealthInsuranceBuilder withFamilyHistory(List<String> familyHistory)
    {
        _familyHealthIssues = familyHistory;
        return this;
    }

    public List<String> getFamilyHealthIssues() { return _familyHealthIssues ; }

    public HealthInsuranceBuilder withRiders(List<String> optionalRiders)
    {
        _proposedRiders = optionalRiders;
        return this;
    }

    public List<String> getOptedRiders() { return _proposedRiders; }

    public HealthInsurance build()
    {
        _healthInsurance = new HealthInsurance(this);
        try
        {
            _healthInsurance.validate();
        }
        catch (Exception validationFailure)
        {
            System.out.printf("Submitted health insurance is not in correct state !");
        }
        return _healthInsurance;
    }
}
