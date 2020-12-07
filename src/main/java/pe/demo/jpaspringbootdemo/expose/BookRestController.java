package pe.demo.jpaspringbootdemo.expose;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.demo.jpaspringbootdemo.business.BookService;
import pe.demo.jpaspringbootdemo.dao.entity.BookEntity;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookEntity> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping(value = "/{id}")
    public BookEntity findById(@PathVariable(name = "id") Integer id) {
        return this.bookService.findById(id);
    }

    @PostMapping
    public BookEntity save(@RequestBody BookEntity bookEntity) {
        return this.bookService.save(bookEntity);
    }

    @PutMapping(value = "/{id}")
    public BookEntity update(
            @PathVariable(name = "id") Integer id,
            @RequestBody BookEntity bookEntity
    ) {
        return this.bookService.update(id, bookEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        this.bookService.delete(id);
    }

}
