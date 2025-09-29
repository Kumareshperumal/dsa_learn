package august.learn;

public class Order {
        String customer;
        String product;
        int amount;

        public Order(String customer, String product, int amount) {
            this.customer = customer;
            this.product = product;
            this.amount = amount;
        }

    @Override
    public String toString() {
        return "Order{" +
                "customer='" + customer + '\'' +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
