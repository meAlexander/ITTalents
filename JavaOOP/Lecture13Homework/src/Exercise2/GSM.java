package Exercise2;

public class GSM {
    private String model;
    private boolean hasSimCard;
    private String simMobileNumber;
    private int outgoingCallsDuration = 0;
    private Call lastIncomingCall;
    private Call lastOutgoingCall;

    public void insertSimCard(String newSimMobileNumber) {
        if (newSimMobileNumber.length() == 10 && newSimMobileNumber.startsWith("08")) {
            simMobileNumber = newSimMobileNumber;
            hasSimCard = true;
        } else {
            System.out.println("Phone number is not in the correct format.");
        }
    }

    public void removeSimCard() {
        hasSimCard = false;
    }

    public void call(GSM receiver, int duration) {
        if (duration < 1 || duration > 60) {
            System.out.println("Duration time is not correct.");
            return;
        }
        if (!receiver.hasSimCard || !hasSimCard) {
            System.out.println("Sim card/s missing");
            return;
        }
        if (receiver.simMobileNumber.equals(simMobileNumber)) {
            System.out.println("You can`t call to yourself.");
            return;
        }
        this.lastOutgoingCall = new Call();
        this.lastOutgoingCall.setCaller(this);
        this.lastOutgoingCall.setReceiver(receiver);
        this.lastOutgoingCall.setDuration(duration);

        receiver.lastIncomingCall = new Call();
        receiver.lastIncomingCall.setCaller(this);
        receiver.lastIncomingCall.setReceiver(receiver);
        receiver.lastIncomingCall.setDuration(duration);

        this.outgoingCallsDuration += duration;
        System.out.println("Your call is successful.");
    }

    public double getSumForCalls() {
        return this.outgoingCallsDuration * Call.getPriceForMinute();
    }

    public void printInfoForTheLastIncomingCall() {
        if (lastIncomingCall == null) {
            System.out.println("No incoming calls!");
            return;
        }
        System.out.println("--Last incoming call info:");
        System.out.println("Caller: " + lastIncomingCall.getCaller().simMobileNumber +
                "\nReceiver: " + lastIncomingCall.getReceiver().simMobileNumber +
                "\nDuration: " + lastIncomingCall.getDuration());
    }

    public void printInfoForTheLastOutgoingCall() {
        if (lastOutgoingCall == null) {
            System.out.println("No outgoing calls!");
            return;
        }
        System.out.println("--Last outgoing call info:");
        System.out.println("Caller: " + lastOutgoingCall.getCaller().simMobileNumber +
                "\nReceiver: " + lastOutgoingCall.getReceiver().simMobileNumber +
                "\nDuration: " + lastOutgoingCall.getDuration() +
                "\nPrice: " + lastOutgoingCall.getDuration() * Call.getPriceForMinute());
        System.out.println("Your bill for outgoing calls: " + getSumForCalls());
    }
}