package domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class PersonPK implements Serializable {

    private  String identification;
    private  String type_identification;

    public PersonPK() {
    }

    public PersonPK(String identification, String type_identification) {
        this.identification = identification;
        this.type_identification = type_identification;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.identification);
        hash = 59 * hash + Objects.hashCode(this.type_identification);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonPK other = (PersonPK) obj;
        if (!Objects.equals(this.identification, other.identification)) {
            return false;
        }
        if (!Objects.equals(this.type_identification, other.type_identification)) {
            return false;
        }
        return true;
    }

}
