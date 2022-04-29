package eu.deltasorce.internship.library.author;

import java.util.Date;

public class AuthorModel {
    private String fullName;
    private String country;
    private Date birthDate;
    private Date deathDate;

    public AuthorModel(String name, String country, Date birthDate){
        setFullName(name);
        setCountry(country);
        setBirthDate(birthDate);
    }

    public AuthorModel(String name, String country, Date birthDate, Date deathDate){
        setFullName(name);
        setCountry(country);
        setBirthDate(birthDate);
        setDeathDate(deathDate);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }
}
