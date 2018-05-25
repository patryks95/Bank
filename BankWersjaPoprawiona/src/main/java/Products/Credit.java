package Products;

import Interest.Interest;

public class Credit extends  Product {
    public Credit(Interest interest, int ID, int time, double balance) {
        super(interest, ID);
        this.setBalance(balance);
        this.setDurationTime(time);
    }
    private int durationTime;

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
}
