package samgau.holding.libraryapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import samgau.holding.libraryapp.book.Book;
import samgau.holding.libraryapp.book.BookRepository;
import samgau.holding.libraryapp.student.Student;
import samgau.holding.libraryapp.student.StudentRepository;

@Controller
public class MainController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/createstudent")
    public String showFormStudents(Student student) {
        return "add-student";
    }

    @GetMapping("/createbook")
    public String showFormBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listStudents", studentRepository.findAll());
        return "add-book";
    }

    @GetMapping("/index")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }


}
