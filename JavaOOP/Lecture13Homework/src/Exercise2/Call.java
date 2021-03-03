package Exercise2;

public class Call {
    private static final double priceForMinute = 0.35;
    private GSM caller;
    private GSM receiver;
    private int duration;

    public static double getPriceForMinute() {
        return priceForMinute;
    }

    public GSM getCaller() {
        return caller;
    }

    public GSM getReceiver() {
        return receiver;
    }

    public int getDuration() {
        return duration;
    }

    public void setCaller(GSM caller) {
        this.caller = caller;
    }

    public void setReceiver(GSM receiver) {
        this.receiver = receiver;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}