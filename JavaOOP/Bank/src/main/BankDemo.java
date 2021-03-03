package main;

import banks.Bank;
import clients.Client;
import products.BankProduct;
import products.Credit;
import products.Deposit;

import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        Deposit shortDeposit = new Deposit("Short Deposit", 3, 3);
        Deposit longDeposit = new Deposit("Long Deposit", 5, 12);

        Credit homeCredit = new Credit("Home credit", 6);
        Credit consumerCredit = new Credit("Consumer credit", 10);

        List<BankProduct> products = new ArrayList<>();
        products.add(shortDeposit);
        products.add(longDeposit);
        products.add(homeCredit);
        products.add(consumerCredit);

        Client client1 = new Client("Ivan", "Sofia", 500, 1200);
        Client client2 = new Client("Petar", "Sofia", 1500, 1800);
        Client client3 = new Client("Todor", "Varna", 800, 1000);
        Client client4 = new Client("Georgi", "Burgas", 1200, 1500);
        Client client5 = new Client("Vasil", "Varna", 1900, 2500);
        Client client6 = new Client("Martin", "Varna", 2500, 2800);

        Client[] clients = {client1,client2,client3,client4,client5,client6};

        Bank bank1 = new Bank("Bulgaria Bank", "Sofia", products, clients);

        client1.openNewDeposit();
        client2.openNewDeposit();
        client3.openNewDeposit();
        client4.openNewDeposit();
        client5.openNewDeposit();
        client6.openNewDeposit();

        bank1.calculateCashReserve();
        bank1.bankInfo();

        bank1.acceptDepositMoney(10, client5, 0);
        bank1.payInterestsOnDeposits();
        bank1.bankInfo();

        bank1.grantLoan(client1, 12, 800);
        bank1.grantLoan(client2, 12, 1000);
        bank1.grantLoan(client3, 12, 600);
        bank1.grantLoan(client4, 12, 1200);
        bank1.grantLoan(client5, 12, 1500);
        bank1.grantLoan(client6, 12, 2000);

        bank1.allBankDeposits();
        bank1.allBankCredits();
        bank1.bankInfo();

        client1.depositsMoneyOnLoans(0);

        bank1.allClients();
    }
}