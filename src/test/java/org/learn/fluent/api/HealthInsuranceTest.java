package org.learn.fluent.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.learn.fluent.api.HealthInsurance.STAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.learn.fluent.api.ConditionalHealthInsuranceBuilder.*;

//import static org.learn.fluent.api.HealthInsuranceBuilder.*;

public class HealthInsuranceTest
{
    private final String PROPOSER_NAME      = "Dibakar";
    private final long PROPOSED_SUM_INSURED = 30_00_000;
    private final int  PROPOSED_AGE         = 35;
    private final int  INVALID_PROPOSER_AGE = 71;
    private static final List<String> preExistingDiseases = new ArrayList();
    private static final List<String> familyHealthHistory = new ArrayList();
    private static final List<String> optionalRiders      = new ArrayList();
    private static boolean hasNoCriticalIllnessHistory = false ;

    @BeforeAll
    static void beforeAll()
    {
        preExistingDiseases.addAll(
                Arrays.asList("Hypertensive","Auto-immune disorder")
        );

        familyHealthHistory.addAll(
                Arrays.asList("Uncle has cardiology problem",
                              "Grandfather has auto-immune disorder")
        );

        optionalRiders.addAll(
                Arrays.asList("Critical cardiovascular care support",
                              "Critical nephro care support")
        );

        boolean hasCardioProblem = preExistingDiseases.stream()
                                                      .anyMatch(disease -> disease.contains("cardio"));

        boolean hasBP = preExistingDiseases.stream()
                                           .anyMatch(disease -> disease.contains("Hypertensive"));

        boolean familyHasCardioProblem = familyHealthHistory.stream()
                                                            .anyMatch(preExistingDisease -> preExistingDisease.contains("cardio"));

        // Note that the condition is static, that is, known before we use it.
        hasNoCriticalIllnessHistory = ! (hasCardioProblem || hasBP || familyHasCardioProblem);

    }

    @Test
    @Tag("sanity")
    @Tag("customer_input")
    @DisplayName("Verifies that a valid health insurance submission is in correct state")
    void validSubmissionIsInCorrectState()
    {
        // Notice how static import of HealthInsuranceBuilder class results in improved readability
        HealthInsurance healthInsurance = healthInsurance().forSubject(PROPOSER_NAME)
                                                           .ofAge(PROPOSED_AGE)
                                                           .withProposedSumInsured(PROPOSED_SUM_INSURED)
                                                           .withPreExistingDiseases(preExistingDiseases)
                                                           .withFamilyHistory(familyHealthHistory)
                                                           .withRiders(optionalRiders)
                                                           .build();

        assertTrue(healthInsurance.getStatus().equals(STAGE.APPLIED));
    }

    @Test
    @Tag("sanity")
    @Tag("customer_input")
    @DisplayName("Verifies that an invalid health insurance submission is flagged")
    void InvalidSubmissionIsInErrorState()
    {
        // Notice how static import of HealthInsuranceBuilder class results in improved readability
        HealthInsurance healthInsurance = healthInsurance().forSubject(PROPOSER_NAME)
                                                           .ofAge(INVALID_PROPOSER_AGE)
                                                           .withProposedSumInsured(PROPOSED_SUM_INSURED)
                                                           .build();
        assertTrue(healthInsurance.getStatus().equals(STAGE.INFORMATION_REQUIRED));
    }

    @Test
    @Tag("sanity")
    @Tag("underwriting")
    void ridersForExistingDiseasesAreExcluded()
    {
        // Notice how static import of HealthInsuranceBuilder class results in improved readability
        HealthInsurance healthInsurance = healthInsurance().forSubject(PROPOSER_NAME)
                                                 .ofAge(PROPOSED_AGE)
                                                 .withProposedSumInsured(PROPOSED_SUM_INSURED)
                                                 .withPreExistingDiseases(preExistingDiseases)
                                                 .withFamilyHistory(familyHealthHistory)
                                                 .withRiders(optionalRiders)
                                                 .when(hasNoCriticalIllnessHistory)
                                                 .build();

        assertTrue(healthInsurance.getProposedRiders().isEmpty());
    }
}
