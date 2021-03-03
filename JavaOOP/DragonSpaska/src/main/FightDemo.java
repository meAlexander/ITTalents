package main;

import dragons.DragonSpaska;
import heros.Hero;
import rabbits.FuckingRabbit;
import rabbits.HealthyRabbit;
import rabbits.StupidRabbit;

import java.util.Scanner;

public class FightDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero spas = new Hero("Male", "Black");
        DragonSpaska dragonSpaska = new DragonSpaska();

        menu(spas, dragonSpaska, scanner);
    }

    private static void menu(Hero hero, DragonSpaska dragonSpaska, Scanner scanner) {
        int option;

        do {
            System.out.println("------------------------------");
            System.out.println("1.Go to the forest and fight rabbits -> battle with a rabbit");
            System.out.println("2.Go to the bar and drink beer -> restore life");
            System.out.println("3.Go to the cave and try against the Dragon Spaska -> battle with the dragon");
            System.out.println("4.View status -> returns all characteristics of the character");
            System.out.println("5.Exit");
            System.out.print("Choose option: ");
            option = scanner.nextInt();
        } while (option < 1 || option > 5);

        if (option == 1) {
            rabbitBattleMenu(hero, dragonSpaska, scanner);
        } else if (option == 2) {
            hero.drinkBeerAndRestoreLife();
        } else if (option == 3) {
            hero.battleWithDragonSpaska(dragonSpaska);
        } else if(option == 4){
            hero.viewHeroStatus();
        }else{
            System.exit(0);
        }
        menu(hero, dragonSpaska, scanner);
    }

    private static void rabbitBattleMenu(Hero hero, DragonSpaska dragonSpaska, Scanner scanner) {
        int option;

        do {
            System.out.println("1.Battle with a stupid rabbit");
            System.out.println("2.Battle with a healthy rabbit");
            System.out.println("3.Battle with a fucking rabbit");
            System.out.println("4.Main menu");
            System.out.print("Choose option: ");
            option = scanner.nextInt();
        } while (option < 1 || option > 4);

        if (option == 1) {
            hero.battleWithRabbit(new StupidRabbit());
        } else if (option == 2) {
            hero.battleWithRabbit(new HealthyRabbit());
        } else if(option == 3){
            hero.battleWithRabbit(new FuckingRabbit());
        }else{
            menu(hero,dragonSpaska, scanner);
        }
    }
}