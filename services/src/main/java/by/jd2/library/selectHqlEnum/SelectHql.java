// select hql request

package by.jd2.library.selectHqlEnum;

public enum SelectHql {
    BOOKS_UP {
        {
            this.hql = "FROM Book B ORDER BY B.bookName ASC";
        }
    },
    BOOKS_DOWN {
        {
            this.hql = "FROM Book B ORDER BY B.bookName DESC";
        }
    },
    AUTHORS_UP {
        {
            this.hql = "FROM Book B ORDER BY B.bookAuthor ASC";
        }
    },
    AUTHORS_DOWN {
        {
            this.hql = "FROM Book B ORDER BY B.bookAuthor DESC";
        }
    };

    String hql;

    public String getHql() {
        return hql;
    }
}
