package se.iths.twentytwo.Labb2BobHogvall;

import java.math.BigDecimal;
import java.util.Objects;

class Product implements Comparable<Product>{
    private String productName;
    private String category;
    private BigDecimal fullPrice;
    private String brand; 
    private int eanId;

    public Product (String productName, String category, BigDecimal fullPrice, String brand, int eanId){
        this.productName = productName;
        this.category = category;
        this.fullPrice = fullPrice;
        this.brand = brand;
        this.eanId = eanId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName){
        if (productName != null){
            this.productName = productName;
        } else {
            throw new NullPointerException();
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null){
            this.category = category;
        } else {
            throw new NullPointerException();
        }
    }


    public BigDecimal getFullPrice() {
        return fullPrice;
    }
    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
        //try catch, att de kan använda både punkt och komma
    }


    public String getBrand() { return brand;}
    public void setBrand(String brand) {
        if (brand != null){
            this.brand = brand;
        } else {
            throw new NullPointerException();
        }

    }


    public int getEanId() {
        return eanId;
    }

    public void setEanId(int eanId) {
        if (eanId > 0){
            this.eanId = eanId;
        } else {
            throw new IllegalArgumentException("Otillåtet ID");
        }
    }



// vilken av formerna vill jag ha? Samt lista ut vad de betyder/gör...


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return eanId == product.eanId && Objects.equals(productName, product.productName) && Objects.equals(category, product.category) && Objects.equals(fullPrice, product.fullPrice) && Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, category, fullPrice, brand, eanId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", fullPrice=" + fullPrice +
                ", brand='" + brand + '\'' +
                ", eanId=" + eanId +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }

}
