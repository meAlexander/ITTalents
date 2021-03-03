package guns;

public abstract class Gun {
    private final double additionalHitPower;
    private final double chanceForCriticalHit;

    public Gun(double additionalHitPower, double chanceForCriticalHit) {
        this.additionalHitPower = additionalHitPower;
        this.chanceForCriticalHit = chanceForCriticalHit;
    }

    public double getAdditionalHitPower() {
        return additionalHitPower;
    }

    public double getChanceForCriticalHit() {
        return chanceForCriticalHit;
    }

    @Override
    public String toString() {
        return "={" +
                "additionalHitPower=" + additionalHitPower +
                ", chanceForCriticalHit=" + chanceForCriticalHit +
                '}';
    }
}