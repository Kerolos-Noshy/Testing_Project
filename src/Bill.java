public class Bill {
    private static int bills = 0;
    private int billID;
    private double price;

    public Bill(double price){
        bills++;
        billID = bills;
        this.price = price;
    }




}
