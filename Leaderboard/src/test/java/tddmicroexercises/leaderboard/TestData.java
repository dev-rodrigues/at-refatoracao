package tddmicroexercises.leaderboard;

public class TestData {

    public static CountryDriver countryDriver1;
    public static CountryDriver countryDriver2;
    public static CountryDriver countryDriver3;
    public static CompanyDrivingCar driver4;

    public static Race race1;
    public static Race race2;
    public static Race race3;
    public static Race race4;
    public static Race race5;
    public static Race race6;

    public static Leaderboard sampleLeaderboard1;
    public static Leaderboard sampleLeaderboard2;

    static {
        countryDriver1 = new CountryDriver("Nico Rosberg", "DE");
        countryDriver2 = new CountryDriver("Lewis Hamilton", "UK");
        countryDriver3 = new CountryDriver("Sebastian Vettel", "DE");
        driver4 = new CompanyDrivingCar("1.2", "Acme");

        race1 = new Race("Australian Grand Prix", countryDriver1, countryDriver2, countryDriver3);
        race2 = new Race("Malaysian Grand Prix", countryDriver3, countryDriver2, countryDriver1);
        race3 = new Race("Chinese Grand Prix", countryDriver2, countryDriver1, countryDriver3);
        race4 = new Race("Fictional Grand Prix 1", countryDriver1, countryDriver2, driver4);
        race5 = new Race("Fictional Grand Prix 2", driver4, countryDriver2, countryDriver1);
        driver4.setAlgorithmVersion("1.3");
        race6 = new Race("Fictional Grand Prix 3", countryDriver2, countryDriver1, driver4);

        sampleLeaderboard1 = new Leaderboard(race1, race2, race3);
        sampleLeaderboard2 = new Leaderboard(race4, race5, race6);
    }
}
