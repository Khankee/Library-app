package samgau.holding.libraryapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import samgau.holding.libraryapp.book.BookRepository;

//This is StudentController class which handles all main edit/add/delete methods
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    private BookRepository bookRepo;

    //CREATE method
    @PostMapping( "/addstudent")
    public String addStudent(@Validated Student student, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-student";
        }
        studentService.addStudent(student);
        return "redirect:/index";
    }

    //READ method
    @GetMapping("/editstudent/{id}")
    public String showStudent(@PathVariable("id") long id, Model model){

        Student student = studentService.getStudent(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid Student id" + id));

        model.addAttribute("student", student);
        return "update-student";
    }

    //UPDATE method
    @PostMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") long id, @Validated Student student,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }

        studentRepository.save(student);
        return "redirect:/index";
    }

    //DELETE method
    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        studentService.deleteStudent(id);
        return "redirect:/index";
    }
}
