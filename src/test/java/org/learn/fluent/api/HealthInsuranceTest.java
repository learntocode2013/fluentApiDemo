package org.learn.fluent.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.learn.fluent.api.HealthInsurance.STAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HealthInsuranceTest
{
    private final long PROPOSED_SUM_INSURED = 30_00_000;
    private final int  PROPOSED_AGE         = 35;
    private final List<String> preExistingDiseases = new ArrayList();
    private final List<String> familyHealthHistory = new ArrayList();
    private final List<String> optionalRiders      = new ArrayList();

    @BeforeEach
    void beforeEach()
    {
        preExistingDiseases.addAll(
                Arrays.asList("Hypertensive","Auto-immune disorder")
        );

        familyHealthHistory.addAll(
                Arrays.asList("Uncle has cardiology problem",
                              "Grandfather has auto-immune disorder")
        );
    }

    @Test
    @Tag("sanity")
    @DisplayName("Verifies that an issued health insurance has all necessary attributes/details")
    void issuedHealthInsuranceHasAllDetails()
    {
        HealthInsurance healthInsurance = HealthInsuranceBuilder.healthInsurance()
                                                      .forAge(PROPOSED_AGE)
                                                      .withProposedSumInsured(PROPOSED_SUM_INSURED)
                                                      .withPreExistingDiseases(preExistingDiseases)
                                                      //.withFamilyHistory(familyHealthHistory)
                                                      .withRiders(optionalRiders)
                                                      .build();

        assertTrue(healthInsurance.getStatus().equals(STAGE.INFORMATION_REQUIRED));
    }
}
