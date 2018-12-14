package home.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Please fill the text")
    @Length(max = 255, message = "Text is to long")
    private String nameOrg;
    @NotBlank(message = "Please fill the text")
    @Length(max = 255, message = "Text is to long")
    private String inn;
    @NotBlank(message = "Please fill the text")
    @Length(max = 255, message = "Text is to long")
    private String ogrn;
    @NotBlank(message = "Please fill the text")
    @Length(max = 255, message = "Text is to long")
    private String address;

    public Information() {
    }

    public Information(String nameOrg, String inn, String ogrn, String address) {
        this.nameOrg = nameOrg;
        this.inn = inn;
        this.ogrn = ogrn;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOrg() {
        return nameOrg;
    }

    public void setNameOrg(String nameOrg) {
        this.nameOrg = nameOrg;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
