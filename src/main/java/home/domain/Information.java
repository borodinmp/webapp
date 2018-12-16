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
    @NotBlank(message = "Пожалуйста, введите наименование организации")
    @Length(max = 255, message = "Слишком длинный текст")
    private String nameOrg;
    @Length(min = 10, max = 12, message = "Введите значение ИНН состоящее из 10-12 цифр")
    private String inn;
    @Length(min = 13, max = 15, message = "Введите значение ОГРН состоящее из 13-15 цифр")
    private String ogrn;
    @NotBlank(message = "Пожалуйста, введите адрес организации")
    @Length(max = 255, message = "Слишком длинный текст")
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
