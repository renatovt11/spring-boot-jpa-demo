package pe.demo.jpaspringbootdemo.business.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import pe.demo.jpaspringbootdemo.business.BookService;
import pe.demo.jpaspringbootdemo.dao.entity.BookEntity;
import pe.demo.jpaspringbootdemo.dao.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(
            BookRepository bookRepository
    ) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookEntity> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public BookEntity findById(Integer id) {
        return this.bookRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public BookEntity save(BookEntity bookEntity) {
        return this.bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity update(Integer id, BookEntity bookEntity) {
        bookEntity.setId(id);
        return this.bookRepository.save(bookEntity);
    }

    @Override
    public void delete(Integer id) {
        this.bookRepository.delete(this.findById(id));
    }

}
