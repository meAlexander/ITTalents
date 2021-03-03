package dragons;

import heros.Hero;
import main.Creature;

import java.util.Random;

public abstract class Dragon extends Creature {
    private final Random randomValue = new Random();

    public Dragon(double life, double hitPower, double chanceForCriticalHit, double chanceToAvoidHit) {
        super(life, hitPower, chanceForCriticalHit, chanceToAvoidHit);
    }

    public void hit(Hero hero) {
        double damage = super.hitPower;
        if (isDragonSpaskaAlive()) {
            if (this.randomValue.nextInt(100) < hero.getChanceToAvoidHit()) {
                System.out.println("Dragon Spaska MISSED!");
            } else {
                if (this.randomValue.nextInt(100) < super.chanceForCriticalHit) {
                    damage += super.hitPower + super.hitPower * (super.chanceForCriticalHit / 100);
                    hero.setLife(damage);
                } else {
                    hero.setLife(damage);
                    System.out.println("Dragon Spaska hits Hero" + " for " +
                            damage + " damage and Hero left with " + hero.getLife() + " health");
                }
            }
        }
    }

    public boolean isDragonSpaskaAlive() {
        return super.life > 0;
    }
}