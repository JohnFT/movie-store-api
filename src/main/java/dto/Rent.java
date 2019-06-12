package dto;

import java.sql.Date;

public class Rent {

    private Integer id;
    private Integer movie;
    private Date initDate;
    private Integer days;
    private Date deliveryDate;
    private Integer price;
    private Integer account;

    public Rent(){

    }
    public Rent(Integer id, Integer movie, Date initDate, Integer days, Date deliveryDate, Integer price, Integer account) {
        this.id = id;
        this.movie = movie;
        this.initDate = initDate;
        this.days = days;
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

    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
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
        return "Rent{" +
                "id=" + id +
                ", movie=" + movie +
                ", initDate=" + initDate +
                ", days=" + days +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                ", account=" + account +
                '}';
    }
}
