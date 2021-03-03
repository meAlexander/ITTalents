package Exercise2;

public class PhoneCallDemo {
    public static void main(String[] args) {
        GSM phone1 = new GSM();
        GSM phone2 = new GSM();
        GSM phone3 = new GSM();

        phone1.insertSimCard("0898433998");
        phone2.insertSimCard("0898433995");

        phone1.call(phone2, 5);
        phone2.call(phone1, 25);
        phone1.call(phone2, 15);
        phone2.call(phone1, 35);

        System.out.println("------------");
        //test wrong input
        //call to yourself
        phone1.call(phone1,6);
        //duration time must be between 1 and 60
        phone1.call(phone2,66);
        //phone 3 does not have sim card
        phone3.call(phone2, 55);
        //phone 3 number is not in the correct format
        phone3.insertSimCard("0008468998");
        System.out.println("-----------------");

        phone1.printInfoForTheLastIncomingCall();
        phone1.printInfoForTheLastOutgoingCall();

        System.out.println("-----------------");
        phone2.printInfoForTheLastIncomingCall();
        phone2.printInfoForTheLastOutgoingCall();
       }
}