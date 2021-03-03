package banks;

import clients.Client;
import products.BankProduct;
import products.Credit;
import products.Deposit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Bank {
    private String name;
    private String address;
    private double bankCashReserve;
    private static double bankMoney;
    private static List<Deposit> deposits;
    private static List<Credit> credits;
    private static List<BankProduct> products;
    private final Client[] clients;
    private static final int BANK_CASH_RESERVE_PERCENTAGE = 10;

    public Bank(String name, String address, List<BankProduct> products, Client[] clients) {
        this.name = name;
        this.address = address;
        Bank.bankMoney = 0;
        deposits = new ArrayList<>();
        credits = new ArrayList<>();
        Bank.products = products;
        this.clients = clients;
    }

    public static List<BankProduct> getProducts() {
        return Bank.products;
    }

    public static List<Deposit> getDeposits() {
        return Bank.deposits;
    }

    public static void updateBankMoney(double bankMoney) {
        Bank.bankMoney += bankMoney;
    }

    public void acceptDepositMoney(double money, Client client, int depositNum) {
        if (Arrays.asList(this.clients).contains(client)) {
            for (Client currentClient : this.clients) {
                if (currentClient.equals(client)) {
                    if (client.getMoneyInCash() >= money) {
                        if (depositNum >= 0 && depositNum < client.getDepositList().size()) {
                            client.setMoneyInCash(client.getMoneyInCash() - money);
                            client.getDepositList().get(depositNum)
                                    .setMoney(client.getDepositList()
                                            .get(depositNum).getMoney() + money);
                            break;
                        } else {
                            System.out.println("Deposit number not found!");
                            return;
                        }
                    } else {
                        System.out.println("Money in cash are not enough to deposit this sum of money!");
                        return;
                    }
                }
            }
            Bank.bankMoney += money;
            this.bankCashReserve = (Bank.bankMoney * Bank.BANK_CASH_RESERVE_PERCENTAGE) / 100;
        } else {
            System.out.println("Person is not a client of the bank!");
        }
    }

    public void payInterestsOnDeposits() {
        for (Client client : this.clients) {
            for (int j = 0; j < client.getDepositList().size(); j++) {
                //лихва на депозита
                double interests = ((client.getDepositList().get(j).getMoney()
                                            * client.getDepositList().get(j).getAnnualInterestRate()) / 100);
                //депози + лихвата върху него
                client.getDepositList().get(j).setMoney(client.getDepositList().get(j).getMoney() + interests);
            }
        }
    }

    public void grantLoan(Client client, int monthPeriod, double sum) {
        Random random = new Random();
        double monthSumOfAllCredits = 0;

        if(Arrays.asList(this.clients).contains(client)) {
            for (int i = 0; i < client.getCreditList().size(); i++) {
                monthSumOfAllCredits += client.getCreditList().get(i).getMonthlyPaymentOfCredit();
            }

            if(monthSumOfAllCredits <= client.getSalary()) {
                if(Bank.bankMoney - sum > this.bankCashReserve) {
                    //отпускане на кредит
                    Bank.bankMoney -= sum;

                    //get random credit from existing
                    Credit d = (Credit) Bank.getProducts().get(random.nextInt(2) + 2);

                    //create a new credit to client using existing bank credit got above
                    Credit newCredit = new Credit(d.getName(), d.getAnnualInterestRate());
                    newCredit.setMonthPeriod(monthPeriod);
                    newCredit.setMoney(-sum);

                    //цялата лихва на кредита
                    double interest = (sum * newCredit.getAnnualInterestRate()) / 100;
                    //месечните вносни по кредита
                    double monthMoneyPayment = (sum + interest) / monthPeriod;
                    newCredit.setMonthlyPaymentOfCredit(Double.parseDouble(String.format("%.2f", monthMoneyPayment).replace(",", ".")));

                    client.getCreditList().add(newCredit);
                    Bank.credits.add(newCredit);
                }else{
                    System.out.println("Credit sum(" + sum + ") exceeds the bank cash reserve and credit cannot be granted to " + client.getName() + "!");
                }
            }else{
                System.out.println("Monthly taxes for all credits exceeds half the salary and new credit cannot be granted!");
            }
        }else{
            System.out.println("Person is not a client of the bank!");
        }
    }

    public void calculateCashReserve() {
        //ако методът се извика много пъти би увеличило парите и резерва, затова нулираме всеки път
        Bank.bankMoney = 0;
        for (Client client : this.clients) {
            for (int j = 0; j < client.getDepositList().size(); j++) {
                Bank.bankMoney += client.getDepositList().get(j).getMoney();
            }
        }
        this.bankCashReserve = (Bank.bankMoney * Bank.BANK_CASH_RESERVE_PERCENTAGE) / 100;
    }

    public void bankInfo() {
        System.out.println("Financial condition of bank " + this.name + ", " + this.address);
        System.out.println("Bank money: " + Bank.bankMoney);
        System.out.println("Cash reserve: " + this.bankCashReserve);
    }

    public void allBankDeposits(){
        System.out.println("All deposits...");
        for(BankProduct product : Bank.deposits){
            System.out.println(product);
        }
    }

    public void allBankCredits(){
        System.out.println("All credits...");
        for(BankProduct product : Bank.credits){
            System.out.println(product);
        }
    }

    public void allClients(){
        System.out.println("All clients...");
        for(Client client : clients){
            System.out.println(client);
        }
    }
}