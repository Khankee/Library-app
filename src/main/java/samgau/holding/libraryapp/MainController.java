package samgau.holding.libraryapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import samgau.holding.libraryapp.student.Student;
import samgau.holding.libraryapp.student.StudentRepository;

@Controller
public class MainController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Student student) {
        return "add-student";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }


}
