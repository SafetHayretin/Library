package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Author {

    private String fullName;

    private String country;

    private String birthDate;

    private String deathDate;

    public Author(String name, String country, String birthDate) {
        setFullName(name);
        setCountry(country);
        setBirthDate(birthDate);
    }

    public Author(String name, String country, String birthDate, String deathDate) {
        this(name, country, birthDate);
        setDeathDate(deathDate);
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
        this.fullName = fullName;
    }

    public void setCountry(String country) {
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country can't be empty!");
        }
        this.country = country;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate == null || birthDate.isBlank()) {
            throw new IllegalArgumentException("Birth date can't be empty!");
        }
        this.birthDate = birthDate;
    }

    public void setDeathDate(String deathDate) {
        if (deathDate == null || deathDate.isBlank()) {
            throw new IllegalArgumentException("Death date can't be empty!");
        }
        this.deathDate = deathDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getFullName().equals(author.getFullName()) && getCountry().equals(author.getCountry()) && getBirthDate().equals(author.getBirthDate()) && Objects.equals(getDeathDate(), author.getDeathDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getCountry(), getBirthDate(), getDeathDate());
    }
}
