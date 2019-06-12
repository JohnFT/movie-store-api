package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "account")
public class AccountBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15)
    private String username;

    @Column(nullable = false, length = 15)
    private  String password;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private  Integer state;

    @Column(nullable = false)
    private String person_id;

    @Column(nullable = false)
    private String person_type;


    @Column(nullable = false)
    private Integer rol;


    public AccountBean() {
    }

    public AccountBean(String username, String password, String avatar, Integer state, String person_id, String person_type, Integer rol) {
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.state = state;
        this.person_id = person_id;
        this.person_type = person_type;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "AccountBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", state=" + state +
                ", person_id='" + person_id + '\'' +
                ", person_type='" + person_type + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
