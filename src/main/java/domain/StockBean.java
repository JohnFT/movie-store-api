package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name ="stock")
public class StockBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    Integer movie;


    @Column()
    Integer state;

    @Column( columnDefinition = "DATE DEFAULT CURRENT_DATE")
    Date date;

    public StockBean(Integer movie, Integer state, Date date) {
        this.movie = movie;
        this.state = state;
        this.date = date;
    }

    public StockBean() {


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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StockBean{" +
                "id=" + id +
                ", movie=" + movie +
                ", state=" + state +
                ", date=" + date +
                '}';
    }
}
