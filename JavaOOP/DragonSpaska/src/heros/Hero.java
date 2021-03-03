package heros;

import armors.Armor;
import armors.BronzeArmor;
import armors.GoldenArmor;
import armors.SilverArmor;
import dragons.DragonSpaska;
import guns.Bazooka;
import guns.Gun;
import guns.Pistol;
import guns.Rifle;
import main.Creature;
import rabbits.Rabbit;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hero extends Creature {
    private static final int MAX_ARMORS = 3;
    private static final int MAX_GUNS = 2;
    private final Armor[] armors;
    private final Gun[] guns;
    private final double mainHitPower;
    private final String sex;
    private final String color;
    private int armorCounter = 0;
    private int gunsCounter = 0;
    private final Random randomValue = new Random();
    private final Scanner scanner = new Scanner(System.in);


    public Hero(String sex, String color) {
        super(100,5, 0, 0);
        this.armors = new Armor[MAX_ARMORS];
        this.guns = new Gun[MAX_GUNS];
        this.mainHitPower = hitPower;
        this.sex = sex;
        this.color = color;
        setAdditionalHitPower();
    }

    public void setAdditionalHitPower() {
        if (this.sex.equalsIgnoreCase("m") || this.sex.equalsIgnoreCase("male")) {
            super.hitPower += 2;
        }
        if (this.color.equalsIgnoreCase("black") || this.color.equalsIgnoreCase("white")) {
            super.hitPower += 2;
        }
    }

    public void addArmor(Armor armor) {
        if (this.armorCounter >= 3) {
            System.out.println("Hero can't take more than 3 armors!");
            exchangeArmor(armor);
            return;
        }
        this.armors[this.armorCounter++] = armor;
        super.life += armor.getAdditionalLife();
        super.chanceToAvoidHit += armor.getChanceToAvoidHit();
    }

    private void exchangeArmor(Armor armor) {
        System.out.println("Your armors: ");
        for(Armor armor1 : this.armors){
            System.out.println(armor1.toString());
        }
        System.out.println("New armor: " + armor.toString());

        System.out.println("If you want to exchange the won armor for one of yours type 'yes'..");
        if(scanner.next().equalsIgnoreCase("yes")){
            System.out.println("Which one you want to exchange: 1,2,3?");
            switch (scanner.next()) {
                case "1" -> {
                    super.life -= this.armors[0].getAdditionalLife();
                    super.chanceToAvoidHit -= this.armors[0].getChanceToAvoidHit();
                    this.armors[0] = armor;
                }
                case "2" -> {
                    super.life -= this.armors[1].getAdditionalLife();
                    super.chanceToAvoidHit -= this.armors[1].getChanceToAvoidHit();
                    this.armors[1] = armor;
                }
                case "3" -> {
                    super.life -= this.armors[2].getAdditionalLife();
                    super.chanceToAvoidHit -= this.armors[2].getChanceToAvoidHit();
                    this.armors[2] = armor;
                }
                default -> {
                    System.out.println("Invalid option!");
                    return;
                }
            }
            super.life += armor.getAdditionalLife();
            super.chanceToAvoidHit += armor.getChanceToAvoidHit();
            System.out.println("Armors were exchanged!");
        }
    }

    public void addGun(Gun gun) {
        if (this.gunsCounter >= 2) {
            System.out.println("Hero can't take more than 2 guns!");
            exchangeGun(gun);
            return;
        }
        this.guns[this.gunsCounter++] = gun;
        super.hitPower += gun.getAdditionalHitPower();
        super.chanceForCriticalHit += gun.getChanceForCriticalHit();
    }

    private void exchangeGun(Gun gun) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your guns: ");
        for(Gun gun1 : this.guns){
            System.out.println(gun1.toString());
        }
        System.out.println("New gun: " + gun.toString());

        System.out.println("If you want to exchange the won gun for one of yours type 'yes'.");
        if(scanner.next().equalsIgnoreCase("yes")){
            System.out.println("Which One you want to exchange: 1,2?");
            switch (scanner.next()){
                case "1" -> {
                    super.hitPower -= guns[0].getAdditionalHitPower();
                    super.chanceForCriticalHit -= guns[0].getChanceForCriticalHit();
                    this.guns[0] = gun;
                }
                case "2" -> {
                    super.hitPower -= guns[1].getAdditionalHitPower();
                    super.chanceForCriticalHit -= guns[1].getChanceForCriticalHit();
                    this.guns[1] = gun;
                }
                default -> {
                    System.out.println("Invalid option!");
                    return;
                }
            }
//            if(scanner.next().equals("1")){
//                this.hitPower -= guns[0].getAdditionalHitPower();
//                this.chanceForCriticalHit -= guns[0].getChanceForCriticalHit();
//                guns[0] = gun;
//            }else if(scanner.next().equals("2")){
//                this.hitPower -= guns[1].getAdditionalHitPower();
//                this.chanceForCriticalHit -= guns[1].getChanceForCriticalHit();
//                guns[1] = gun;
//            }
            super.hitPower += gun.getAdditionalHitPower();
            super.chanceForCriticalHit += gun.getChanceForCriticalHit();
            System.out.println("Guns were exchanged!");
        }
    }

    public void hitRabbit(Rabbit rabbit) {
        double damage = super.hitPower;
        if (isHeroAlive()) {
            if (this.randomValue.nextInt(100) < rabbit.getChanceToAvoidHit()) {
                System.out.println("Hero MISSED!");
            } else {
                if (this.randomValue.nextInt(100) < super.chanceForCriticalHit) {
                    if (this.gunsCounter == 2) {
                        damage += this.mainHitPower * 3;
                    } else {
                        damage += this.mainHitPower * 1.5;
                    }
                }
                rabbit.setLife(damage);
                System.out.println("Hero hits Rabbit for " + damage + " and Rabbit left with " + rabbit.getLife() + " health");
            }
        }
    }

    public void battleWithRabbit(Rabbit rabbit) {
        int rounds = 0;
        while (true) {
            if (!this.isHeroAlive()) {
                System.out.println("Hero is dead!");
                break;
            }

            System.out.println("Round: " + ++rounds);
            if (this.randomValue.nextBoolean()) {
                this.hitRabbit(rabbit);
                rabbit.hit(this);
            } else {
                rabbit.hit(this);
                this.hitRabbit(rabbit);
            }

            if (!this.isHeroAlive()) {
                System.out.println("Hero is dead!");
                break;
            }
            if (!rabbit.isRabbitAlive()) {
                System.out.println("Rabbit is dead!");
                getItem();
                break;
            }
        }
    }

    private void getItem() {
        int item = this.randomValue.nextInt(2);

        if(item == 0){
            getArmor();
        }else{
            getGun();
        }
    }

    private void getArmor(){
        int armor = this.randomValue.nextInt(3);

        if(armor == 0){
            addArmor(new BronzeArmor());
        }else if (armor == 1){
            addArmor(new SilverArmor());
        }else{
            addArmor(new GoldenArmor());
        }
    }

    private void getGun(){
        int gun = this.randomValue.nextInt(3);

        if(gun == 0){
            addGun(new Pistol());
        }else if(gun == 1){
            addGun(new Rifle());
        }else{
            addGun(new Bazooka());
        }
    }

    public void hitDragonSpaska(DragonSpaska dragonSpaska) {
        double damage = super.hitPower;

        if (isHeroAlive()) {
            if (this.randomValue.nextInt(100) < dragonSpaska.getChanceToAvoidHit()) {
                System.out.println("Hero MISSED!");
            } else {
                if (this.randomValue.nextInt(100) < super.chanceForCriticalHit) {
                    if (this.gunsCounter == 2) {
                        damage += this.mainHitPower * 3;
                    } else {
                        damage += this.mainHitPower * 1.5;
                    }
                }
                dragonSpaska.setLife(damage);
                System.out.println("Hero hits Dragon Spaska for " + damage +
                        " and Dragon Spaska left with " + dragonSpaska.getLife() + " health");
            }
        }
    }

    public void battleWithDragonSpaska(DragonSpaska dragonSpaska) {
        int rounds = 0;
        if (!this.isHeroAlive()) {
            System.out.println("Hero is dead!");
            return;
        }

        if (!dragonSpaska.isDragonSpaskaAlive()) {
            System.out.println("Dragon Spaska is dead!");
            return;
        }
        while (true) {
            System.out.println("Round: " + ++rounds);
            if (this.randomValue.nextBoolean()) {
                this.hitDragonSpaska(dragonSpaska);
                dragonSpaska.hit(this);
            } else {
                dragonSpaska.hit(this);
                this.hitDragonSpaska(dragonSpaska);
            }

            if (!this.isHeroAlive()) {
                System.out.println("Hero is dead!");
                break;
            }
            if (!dragonSpaska.isDragonSpaskaAlive()) {
                System.out.println("Dragon Spaska is dead!");
                break;
            }
        }
    }

    boolean isHeroAlive() {
        return this.life > 0;
    }

    public void drinkBeerAndRestoreLife() {
        if (super.life < 100) {
            super.life = 100;
            System.out.println("Hero life was restored to 100!");

            getItems();
            return;
        }
        System.out.println("There is no need to reset life because Hero life is more or equals to 100!");
    }

    private void getItems() {
        for(Armor armor : this.armors){
            if(armor != null) {
                super.life += armor.getAdditionalLife();
                System.out.println("Hero's " + armor.getClass().getSimpleName() + " were taken!");
            }
        }
    }

    public void viewHeroStatus() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Hero{" +
                "\narmors=" + Arrays.toString(this.armors) +
                ",\nguns=" + Arrays.toString(this.guns) +
                ",\nlife=" + super.life +
                ", hitPower=" + super.hitPower +
                ", mainHitPower=" + this.mainHitPower +
                ", chanceToAvoidHit=" + super.chanceToAvoidHit +
                ", chanceForCriticalHit=" + super.chanceForCriticalHit +
                ", sex='" + this.sex + '\'' +
                '}';
    }
}