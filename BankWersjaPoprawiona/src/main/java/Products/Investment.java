package Products;

import Interest.Interest;

public class Investment extends Product {
    public Investment(Interest interest, int ID, double amount, int durationTime) {
        super(interest, ID);
        description = "Lokata na: " + durationTime + " dni na kwote: " + amount + " z oprocentowaniem: " + interest + ". Zalozona: " + CreateDate.toString();
        this.amount=amount;
        this.durationTime=durationTime;
    }
    private int durationTime;
    private double income;
    private String description;
    private double amount;


    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
