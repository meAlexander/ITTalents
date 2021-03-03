package products;

public class Credit extends BankProduct{
    private double monthlyPaymentOfCredit;

    public Credit(String name, double annualInterestRate) {
        super(name, annualInterestRate);
    }

    public void setMonthlyPaymentOfCredit(double monthlyPaymentOfCredit) {
        this.monthlyPaymentOfCredit = monthlyPaymentOfCredit;
    }

    public double getMonthlyPaymentOfCredit() {
        return monthlyPaymentOfCredit;
    }

    public void updateMoney(double money) {
        super.setMoney(super.getMoney() + money);
    }

    @Override
    public String toString() {
        return super.toString() + "Credit{" +
                "monthlyPaymentOfCredit=" + monthlyPaymentOfCredit +
                '}';
    }
}