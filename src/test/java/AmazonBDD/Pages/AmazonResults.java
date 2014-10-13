package AmazonBDD.Pages;

/**
 * Created by Mihai on 13.10.2014.
 */
public class AmazonResults extends AmazonSearch {
    private int resultNo;
    private String productName, price;

    public AmazonResults(int resultNo, String productName, String price) {
        this.resultNo = resultNo;
        this.productName = productName;
        this.price = price;
    }

    public int getResultNo() {
        return resultNo;
    }

    public void setResultNo(int resultNo) {
        this.resultNo = resultNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
