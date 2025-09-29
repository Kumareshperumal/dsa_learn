package august.learn;

import java.time.LocalDate;

public class Products {
    String customerId;
    String productId;
    LocalDate orderDate;

    public Products(String customerId, String productId, LocalDate orderDate) {
        this.customerId = customerId;
        this.productId = productId;
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
