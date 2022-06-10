package samgau.holding.libraryapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import samgau.holding.libraryapp.student.Student;
import samgau.holding.libraryapp.student.StudentService;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @Autowired
    private StudentService studentService2;

    @PostMapping( "/addstudent")
    public String addStudent(@Validated Student student, Model model){
        studentService2.addStudent(student);

        return "redirect:/";
    }
}
