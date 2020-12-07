package pe.demo.jpaspringbootdemo.business;

import java.util.List;

import pe.demo.jpaspringbootdemo.dao.entity.BookEntity;

public interface BookService {

    List<BookEntity> getAll();

    BookEntity findById(Integer id);

    BookEntity save(BookEntity bookEntity);

    BookEntity update(Integer id, BookEntity bookEntity);

    void delete(Integer id);

}
