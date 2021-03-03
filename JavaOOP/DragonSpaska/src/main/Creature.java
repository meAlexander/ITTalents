package main;

public abstract class Creature {
    protected double life;
    protected double hitPower;
    protected double chanceForCriticalHit;
    protected double chanceToAvoidHit;

    public Creature(double life, double hitPower, double chanceForCriticalHit, double chanceToAvoidHit) {
        this.life = life;
        this.hitPower = hitPower;
        this.chanceForCriticalHit = chanceForCriticalHit;
        this.chanceToAvoidHit = chanceToAvoidHit;
    }

    public double getChanceToAvoidHit() {
        return this.chanceToAvoidHit;
    }

    public double getLife() {
        return this.life;
    }

    public void setLife(double life) {
        this.life -= life;
    }
}