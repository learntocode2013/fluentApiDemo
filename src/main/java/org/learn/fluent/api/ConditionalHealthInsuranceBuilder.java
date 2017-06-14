package org.learn.fluent.api;

import org.learn.fluent.api.HealthInsurance.STAGE;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>An expression builder which exposes fluent API on top of a conventional command-query API class</b>
 * <br><br>
 * ---- salient points ----
 * <ul>
 *     <li>All actions invoked on fluent interfaces are aggregated for execution only on final build command</li>
 *     <li>Ability to conditionally remove the last added action</li>
 * </ul>
 */
public class ConditionalHealthInsuranceBuilder implements ExpressionBuilder
{
    // all build actions will be aggregated in here.
    private final List<Action<ConditionalHealthInsuranceBuilder>> _builderActions = new ArrayList();

    // mandatory attributes
    private String  _proposerName;
    private int     _proposerAge;
    private long    _proposedSumInsured;
    private STAGE   _status;
    private List<String> _preExistingIllness = new ArrayList<>();
    private List<String> _familyHealthIssues = new ArrayList<>();
    private List<String> _proposedRiders     = new ArrayList<>();

    private ConditionalHealthInsuranceBuilder()
    {
        //do now allow direct instantiation from API clients
    }

    public static ConditionalHealthInsuranceBuilder healthInsurance()
    {
        return new ConditionalHealthInsuranceBuilder() ;
    }

    public HealthInsurance build()
    {
        // set the correct state of this builder taking care of conditionals
        _builderActions.stream().forEach( action -> action.apply(this));
        // go ahead and construct the immutable object
        HealthInsurance insurance = new HealthInsurance(this);
        try
        {
            insurance.validate();
        }
        catch (Exception validationFailure)
        {
            System.out.printf("Submitted health insurance is not in correct state !");
        }
        return insurance;
    }

    @Override
    public String getProposerName() {
        return _proposerName ;
    }

    @Override
    public int getProposerAge() {
        return _proposerAge ;
    }

    @Override
    public long getProposedSumInsured() {
        return _proposedSumInsured ;
    }

    @Override
    public List<String> getDeclaredPreExistingIllness() {
        return _preExistingIllness ;
    }

    @Override
    public List<String> getFamilyHealthIssues() {
        return _familyHealthIssues ;
    }

    @Override
    public List<String> getOptedRiders() {
        return _proposedRiders ;
    }

    public ConditionalHealthInsuranceBuilder forSubject(String name)
    {
        _builderActions.add(builder -> builder._proposerName = name);
        return this;
    }

    public ConditionalHealthInsuranceBuilder ofAge(int age )
    {
        _builderActions.add(builder -> builder._proposerAge = age);
        return this;
    }

    public ConditionalHealthInsuranceBuilder withProposedSumInsured( long proposedSumInsured )
    {
        _builderActions.add(builder -> builder._proposedSumInsured = proposedSumInsured);
        return this;
    }

    public ConditionalHealthInsuranceBuilder withPreExistingDiseases(List<String>preExistingDiseases)
    {
        _builderActions.add(builder -> builder._preExistingIllness = preExistingDiseases);
        return this;
    }

    public ConditionalHealthInsuranceBuilder withFamilyHistory(List<String> familyHistory)
    {
        _builderActions.add(builder -> builder._familyHealthIssues = familyHistory);
        return this;
    }

    public ConditionalHealthInsuranceBuilder withRiders(List<String> optionalRiders)
    {
        _builderActions.add(builder -> builder._proposedRiders = optionalRiders);
        return this;
    }

    public ConditionalHealthInsuranceBuilder when(boolean hasNoCriticalIllnessHistory)
    {
        if(!hasNoCriticalIllnessHistory)
        {
            Action<ConditionalHealthInsuranceBuilder> mostRecentAddedAction =
                    _builderActions.get(_builderActions.size() - 1);
            _builderActions.remove(mostRecentAddedAction);
        }

        return this;
    }
}
