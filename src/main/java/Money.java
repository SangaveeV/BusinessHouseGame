public class Money {
    double amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    void amountAddition(double amount) {
        this.amount += amount;

    }

    void amountDeduction(double amount){
         this.amount -= amount;
    }

}
