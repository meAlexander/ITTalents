package rabbits;

import heros.Hero;
import main.Creature;

import java.util.Random;

public abstract class Rabbit extends Creature {
    private final Random randomValue = new Random();

    public Rabbit(double life, double hitPower, double chanceForCriticalHit, double chanceToAvoidHit) {
        super(life, hitPower, chanceForCriticalHit, chanceToAvoidHit);
    }

    public void hit(Hero hero) {
        double damage = super.hitPower;
        if (isRabbitAlive()) {
            if (this.randomValue.nextInt(100) < hero.getChanceToAvoidHit()) {
                System.out.println("Rabbit MISSED!");
            } else {
                if (this.randomValue.nextInt(100) < super.chanceForCriticalHit) {
                    damage = super.hitPower + super.hitPower * (super.chanceForCriticalHit / 100);
                    hero.setLife(damage);
                } else {
                    hero.setLife(damage);
                    System.out.println("Rabbit hits Hero" + " for " +
                            damage + " damage and Hero left with " + hero.getLife() + " health");
                }
            }
        }
    }

    public boolean isRabbitAlive() {
        return super.life > 0;
    }
}