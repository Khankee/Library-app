package samgau.holding.libraryapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //GET DEFAULT METHOD OF SPECIFIC ONE
    @RequestMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable String id){
        return studentService.getStudent(id);
    }

    /*//POST METHOD (Create value)
    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }*/

    //DELETE METHOD (Remove the value)
    @RequestMapping(method = RequestMethod.DELETE, value = "students/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }

    //PUT METHOD (Update the value)
    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable String id ){
        studentService.updateTopic(id, student);
    }
}
