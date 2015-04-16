//interface for BookService

package by.jd2.library.services;

import by.jd2.library.pojos.Book;

import java.io.Serializable;
import java.util.List;

public interface IBookService<T> {
    Book get(Serializable id);
    List<T> getBooks(String sortRow, String sortFlag, String countResult, String pageNumber);
    String[] getPageNumber(String pageNumber, String countResult, String btnNav);
    List<String> getAuthors();
}
