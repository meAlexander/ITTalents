package armors;

public abstract class Armor {
    private final double additionalLife;
    private final double chanceToAvoidHit;

    public Armor(double additionalLife, double chanceToAvoidHit) {
        this.additionalLife = additionalLife;
        this.chanceToAvoidHit = chanceToAvoidHit;
    }

    public double getAdditionalLife() {
        return additionalLife;
    }

    public double getChanceToAvoidHit() {
        return chanceToAvoidHit;
    }

    @Override
    public String toString() {
        return "={" +
                "additionalLife=" + additionalLife +
                ", chanceToAvoidHit=" + chanceToAvoidHit +
                '}';
    }
}