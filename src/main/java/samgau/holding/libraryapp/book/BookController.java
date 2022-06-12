package samgau.holding.libraryapp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import samgau.holding.libraryapp.student.Student;
import samgau.holding.libraryapp.student.StudentRepository;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/countbook")
    public String calculateBook(Model model){
        long sum = bookService.sumPrice();
        return"redirect:/index";
    }

    //CREATE method
    @PostMapping( "/addbook")
    public String addBook(@Validated Book book, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.addBook(book);
        return "redirect:/index";
    }

    //READ method
    @GetMapping("/edit/{id}")
    public String showBook(@PathVariable("id") long id, Model model){

        Book book = bookService.getBook(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid Book id" + id));

        model.addAttribute("book", book);
        return "update-book";
    }

    //UPDATE method
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, @Validated Book book,
                             BindingResult result, Model model) {
        model.addAttribute("listStudents", studentRepo.findAll());
        if (result.hasErrors()) {
            book.setId(id);
            return "update-student";
        }
        bookRepository.save(book);
        return "redirect:/index";
    }

    //DELETE method
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        bookService.deleteBook(id);
        return "redirect:/index";
    }

}
