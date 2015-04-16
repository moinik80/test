//interface for BookDao

package by.jd2.library.dao;

import java.util.List;

public interface IBookDao<T> extends Dao<T> {
    List<T> getBooks(String hql, int countResultInt, int startResult);
    List<String> getAuthors();
    long getCountBooks();
}
