package by.jd2.library.services;

import by.jd2.library.dao.IBookDao;
import by.jd2.library.pojos.Book;
import by.jd2.library.selectHqlEnum.SelectHql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookService implements IBookService<Book> {

    @Autowired
    IBookDao bookDao;

    @Override
    public Book get(Serializable id) {
        return (Book) bookDao.get(Book.class, id);
    }

    @Override
    public List<Book> getBooks(String sortRow, String sortFlag, String countResult, String pageNumber) {
        String parametersSort = sortRow.toUpperCase() + "_" + sortFlag.toUpperCase();

        String hql = SelectHql.valueOf(parametersSort).getHql();

        int countResultInt = Integer.parseInt(countResult);

        int startResult = (Integer.parseInt(pageNumber) - 1) * countResultInt;
        return bookDao.getBooks(hql, countResultInt, startResult);
    }

//    return pageNumber
    @Override
    public String[] getPageNumber(String pageNumber, String countResult, String btnNav) {
        long countPages = 1;
        long countBooks = bookDao.getCountBooks();

        int countResultInt = Integer.parseInt(countResult);

        if (countBooks % countResultInt == 0) {
            countPages = countBooks / countResultInt;
        } else {
            countPages = countBooks / countResultInt + 1;
        }

        if ("<<".equals(btnNav))
            pageNumber = "1";
        else if ("<".equals(btnNav)) {
            int temp = Integer.parseInt(pageNumber) - 1;
            if (temp <= 0)
                pageNumber = "1";
            else
                pageNumber = temp + "";
        } else if (">>".equals(btnNav))
            pageNumber = countPages + "";
        else if (">".equals(btnNav))
        {
            int temp = Integer.parseInt(pageNumber) + 1;
            if (temp > (int) countPages)
                pageNumber = countPages + "";
            else
                pageNumber = temp + "";
        }

        String[] result = new String[2];
        result[0] = pageNumber;
        result[1] = countPages + "";
        return result;
    }

    //    return list authors from class Book, use BookDao
    @Override
    public List<String> getAuthors() {
        return bookDao.getAuthors();
    }
}
