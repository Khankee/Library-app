package samgau.holding.libraryapp.book;

import samgau.holding.libraryapp.student.Student;

import javax.persistence.*;

@Entity
public class Book {

    public Book(){}

    public Book(long id, String name, long price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}