package products;

public class Deposit extends BankProduct {
    private double annuallyPaymentOfInterest;

    public Deposit(String name, double annualInterestRate, int monthPeriod) {
        super(name, annualInterestRate, monthPeriod);
    }

    public double getAnnuallyPaymentOfInterest() {
        return annuallyPaymentOfInterest;
    }

    public void setAnnuallyPaymentOfInterest(double annuallyPaymentOfInterest) {
        this.annuallyPaymentOfInterest = annuallyPaymentOfInterest;
    }

    @Override
    public String toString() {
        return super.toString() + "Deposit{" +
                "annuallyPaymentOfInterest=" + annuallyPaymentOfInterest +
                '}';
    }
}