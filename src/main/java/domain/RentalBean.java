package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity(name = "rental")
public class RentalBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer stock;


    @Column(name = "init_date",nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date initDate;


    @Column(nullable = false)
    private Integer days;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date date;


    @Column(name = "delivery_date", nullable = false)
    private Date deliveryDate;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer account;

    public RentalBean() {
    }


    public RentalBean(Integer stock, Date initDate, Integer days, Date date, Date deliveryDate, Integer price, Integer account) {
        this.stock = stock;
        this.initDate = initDate;
        this.days = days;
        this.date = date;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "RentalBean{" +
                "id=" + id +
                ", stock=" + stock +
                ", initDate=" + initDate +
                ", days=" + days +
                ", date=" + date +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", account=" + account +
                '}';
    }
}
