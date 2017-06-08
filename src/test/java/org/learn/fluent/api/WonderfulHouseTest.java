package org.learn.fluent.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WonderfulHouseTest
{
    private final double MAX_BUDGET = 50_00_000;
    private String bluePrintDetails = null;

    @BeforeEach
    void beforeEachTest()
    {
        StringBuilder detailsBuilder = new StringBuilder();
        detailsBuilder.append("Total area : 30ft x 40ft")
                      .append("Number of floors: 3")
                      .append("Designation: G + 2");
        bluePrintDetails = detailsBuilder.toString();
    }

    @Test
    @Tag("sanity")
    @DisplayName("Verifies that a house is built as per standard norms")
    void houseIsComplete()
    {
        WonderfulHouse house = new WonderfulHouse();
        house.start()
             .chooseBlueprint(BluePrint.from(bluePrintDetails))
             .setBudget(MAX_BUDGET)
             .getAllApprovals()
             .chooseContractor(Contractor.DEFAULT_CONTRACTOR)
             .commenceConstruction();

        System.out.printf("Constructed house : %s %n",house);
        assertAll("Constructed house is not in valid state",
                  () -> { assertTrue(house.isCompleted()); }
                  );


    }
}
