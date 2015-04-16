//entity Book

package by.jd2.library.pojos;

//import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book implements Serializable {

//    for serializable
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column
    private String bookName;

    @Column
    private String bookAuthor;

    @Column(columnDefinition="TEXT")
    private String bookDescription;

    @Column(columnDefinition="TEXT")
    private String bookText;

    @Column
    private String pathImg;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "categoryId")})
    private Set<Category> categories = new HashSet<Category>();

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookText() {
        return bookText;
    }

    public void setBookText(String bookText) {
        this.bookText = bookText;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (!bookAuthor.equals(book.bookAuthor)) return false;
        if (!bookDescription.equals(book.bookDescription)) return false;
        if (!bookName.equals(book.bookName)) return false;
        if (!bookText.equals(book.bookText)) return false;
        if (!categories.equals(book.categories)) return false;
        if (!pathImg.equals(book.pathImg)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + bookName.hashCode();
        result = 31 * result + bookAuthor.hashCode();
        result = 31 * result + bookDescription.hashCode();
        result = 31 * result + bookText.hashCode();
        result = 31 * result + pathImg.hashCode();
        return result;
    }
}
