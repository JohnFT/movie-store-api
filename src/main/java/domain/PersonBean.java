package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity(name = "person")
@IdClass(value = PersonPK.class)
public class PersonBean implements Serializable {
    @Id
    @Column(nullable = false, length = 20)
    private  String identification;

    @Id
    @Column(nullable = false, length = 2)
    private  String type_identification;

    @Column(name = "first_name",nullable = false, length = 60)
    private  String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(length = 12)
    private String phone;

    @Column()
    private Integer years;

    @Column(length = 100)
    private String address;

    @Column(length = 300)
    private String email;

    public PersonBean() {
    }

    public PersonBean(String identification, String type_identification, String firstName, String lastName, String phone, Integer years, String address, String email) {
        this.identification = identification;
        this.type_identification = type_identification;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.years = years;
        this.address = address;
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getType_identification() {
        return type_identification;
    }

    public void setType_identification(String type_identification) {
        this.type_identification = type_identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "identification='" + identification + '\'' +
                ", type_identification='" + type_identification + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", years=" + years +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
