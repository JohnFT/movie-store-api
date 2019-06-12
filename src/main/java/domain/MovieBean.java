package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "movie")
public class MovieBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private  String description;

    @Column(nullable = false, length = 60)
    private String gender;

    @Column(nullable = false, length = 300)
    private  String director;

    @Column(nullable = false)
    private Integer stars;

    @Column(nullable = false)
    private Integer time;
    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private  String background;

    @Column(nullable = false)
    private Long price;

    public MovieBean() {
    }

    public MovieBean(String name, String description, String gender, String director, Integer stars, Integer time, String avatar, String background, Long price) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.director = director;
        this.stars = stars;
        this.time = time;
        this.avatar = avatar;
        this.background = background;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "MovieBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", gender='" + gender + '\'' +
                ", director='" + director + '\'' +
                ", stars=" + stars +
                ", time=" + time +
                ", avatar='" + avatar + '\'' +
                ", background='" + background + '\'' +
                ", price=" + price +
                '}';
    }
}
