package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tddmicroexercises.leaderboard.TestData.countryDriver1;
import static tddmicroexercises.leaderboard.TestData.countryDriver2;
import static tddmicroexercises.leaderboard.TestData.countryDriver3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LeaderboardTest {

    @Test
    void itShouldSumThePoints() {
        // setup

        // act
        Map<String, Integer> results = TestData.sampleLeaderboard1.driverResults();

        // verify
        assertTrue(results.containsKey("Lewis Hamilton"), "results " + results);
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    void isShouldFindTheWinner() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard1.driverRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
    }

    @Test
    void itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", countryDriver1, countryDriver2, countryDriver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", countryDriver2, countryDriver1, countryDriver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(countryDriver1.getName(), countryDriver2.getName(), countryDriver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
