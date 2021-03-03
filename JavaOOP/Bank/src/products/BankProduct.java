package products;

public class BankProduct {
    private final String name;
    private final double annualInterestRate;
    private int monthPeriod;
    private double money;

    public BankProduct(String name, double annualInterestRate) {
        this.name = name;
        this.annualInterestRate = annualInterestRate;
    }

    public BankProduct(String name, double annualInterestRate, int monthPeriod) {
        this.name = name;
        this.annualInterestRate = annualInterestRate;
        setMonthPeriod(monthPeriod);
    }

    public String getName() {
        return name;
    }

    public int getMonthPeriod() {
        return monthPeriod;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMoney() {
        return money;
    }



    public void setMonthPeriod(int monthPeriod) {
        if (monthPeriod < 1 || monthPeriod > 60) {
            System.out.println("Month period must be between 1 and 60.");
            return;
        }
        this.monthPeriod = monthPeriod;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BankProduct{" +
                "name='" + name + '\'' +
                ", annualInterestRate=" + annualInterestRate +
                ", monthPeriod=" + monthPeriod +
                ", money=" + money +
                '}';
    }
}