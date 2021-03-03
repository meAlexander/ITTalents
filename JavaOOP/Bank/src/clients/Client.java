package clients;

import banks.Bank;
import products.Credit;
import products.Deposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    private final String name;
    private String address;
    private double moneyInCash;
    private double salary;
    private final List<Deposit> depositList;
    private final List<Credit> creditList;

    public Client(String name, String address, double moneyInCash, double salary) {
        this.name = name;
        this.address = address;
        this.moneyInCash = moneyInCash;
        newMonth(salary);
        depositList = new ArrayList<>();
        creditList = new ArrayList<>();
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public double getMoneyInCash() {
        return moneyInCash;
    }

    public void setMoneyInCash(double moneyInCash) {
        this.moneyInCash = moneyInCash;
    }

    public void openNewDeposit(){
        if(this.moneyInCash <= 0){
            System.out.println("Money are not enough to open a deposit!");
            return;
        }
        Random random = new Random();
        int depositPercent = random.nextInt(20) + 81;
        double depositMoney = (this.moneyInCash * depositPercent) / 100;

        //get random deposit from existing
        Deposit deposit = (Deposit) Bank.getProducts().get(random.nextInt(2));

        //create a new deposit to client using existing bank deposit got above
        Deposit newDeposit = new Deposit(deposit.getName(), deposit.getAnnualInterestRate(), deposit.getMonthPeriod());
        newDeposit.setMoney(depositMoney);
        newDeposit.setAnnuallyPaymentOfInterest((deposit.getAnnualInterestRate() * newDeposit.getMoney()) / 100);

        this.depositList.add(newDeposit);
        Bank.getDeposits().add(newDeposit);

        this.moneyInCash -= depositMoney;
    }

    public void depositsMoneyOnLoans(int creditNum){
        if (creditNum >= 0 && creditNum < getDepositList().size()){
            double monthTax = getCreditList().get(creditNum).getMonthlyPaymentOfCredit();
            getCreditList().get(creditNum).updateMoney(monthTax);

            Bank.updateBankMoney(monthTax);
            this.salary -= monthTax;
        }else{
            System.out.println("Deposit number not found!");
        }
    }

    public void newMonth(double salary){
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", moneyInCash=" + moneyInCash +
                ", salary=" + salary +
                ",\ndepositList=" + depositList +
                ",\ncreditList=" + creditList +
                '}';
    }
}