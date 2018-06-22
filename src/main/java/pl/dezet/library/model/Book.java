package pl.dezet.library.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Column(name = "id")
    @Id
    @GeneratedValue
    private String id;
    private String author;
    private String name;
    private String description;
    private boolean isAvailible;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailible() {
        return isAvailible;
    }

    public void setAvailible(boolean availible) {
        isAvailible = availible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(name, book.name) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, name, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
