package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void isShouldCalculateDriverPoints() {
        assertEquals(25, TestData.race1.getPoints(TestData.countryDriver1));
        assertEquals(18, TestData.race1.getPoints(TestData.countryDriver2));
        assertEquals(15, TestData.race1.getPoints(TestData.countryDriver3));
    }

}
