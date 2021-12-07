package com.john.service;

import com.john.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

/**
 * @author John
 * @create 2021-10-2123:37
 */
public interface BookService {
    // 增加一本书
    int addBook(Books book);

    // 删除一本数
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books book);

    // 查询一本数
    Books queryBookById(int id);

    //查询一本书
    List<Books> queryAllBook();

    Books queryBookByName(String bookName);
}
