package eu.deltasorce.internship.library.model.book;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Author which gives information about Author of books
 * Contains base way of creating author
 * Have validations for the parameters
 * Have Equals and Hashcode
 */
@Getter
public class Author {

    private String fullName;

    private String country;

    private LocalDate birthDate;

    private LocalDate deathDate;

    /**
     * Base way to creating author who is still alive
     *
     * @param name        The name of the author
     * @param country     The country the author is from
     * @param birthDate    The birthdate of the author
     */
    public Author(String name, String country, LocalDate birthDate) {
        setFullName(name);
        setCountry(country);
        setBirthDate(birthDate);
    }

    /**
     * Base way to creating author who is not alive
     *
     * @param name        The name of the author
     * @param country     The country the author is from
     * @param birthDate The birthdate of the author
     * @param deathDate The day author died
     */
    public Author(String name, String country, LocalDate birthDate, LocalDate deathDate) {
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

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date can't be empty!");
        }
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        if (deathDate == null) {
            throw new IllegalArgumentException("Death date can't be empty!");
        }
        if (deathDate.isBefore(birthDate)){
            throw new IllegalArgumentException("Death date can't be before birthDate");
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
