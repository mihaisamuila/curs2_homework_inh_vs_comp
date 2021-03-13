package InheritanceVsComposition;

public enum AgeGroup {
    YOUNG(0, 30, "persoane pana la 30:"),
    MIDDLE_AGE(31, 50, "persoane cu varsta intre 31 si 50:"),
    OLD(51, 150, "persoane cu varsta peste 50:");

    private final int lowerTreshold;
    private final int upperTreshold;
    private final String ageGroupDescription;

    AgeGroup(int lowerTreshold, int upperTreshold, String ageGroupDescription) {
        this.lowerTreshold = lowerTreshold;
        this.upperTreshold = upperTreshold;
        this.ageGroupDescription = ageGroupDescription;
    }

    public int getLowerTreshold() {
        return lowerTreshold;
    }

    public int getUpperTreshold() {
        return upperTreshold;
    }

    public String getAgeGroupDescription() {
        return ageGroupDescription;
    }
}
