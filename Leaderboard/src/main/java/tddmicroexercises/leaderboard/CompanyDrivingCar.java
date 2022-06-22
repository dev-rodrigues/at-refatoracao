package tddmicroexercises.leaderboard;

import java.util.Objects;

public class CompanyDrivingCar extends CountryDriver {

    private final String company;
    private String algorithmVersion;

    public CompanyDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
        this.company = company;
    }

    @Override
    public String getName() {
        StringBuilder builder = new StringBuilder();
        builder.append("Self Driving Car - ");
        builder.append(this.company);
        builder.append(" (");
        builder.append(getAlgorithmVersion());
        builder.append(")");
        return builder.toString();
    }
    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompanyDrivingCar that = (CompanyDrivingCar) o;
        return Objects.equals(company, that.company) && Objects.equals(algorithmVersion, that.algorithmVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, algorithmVersion);
    }
}
