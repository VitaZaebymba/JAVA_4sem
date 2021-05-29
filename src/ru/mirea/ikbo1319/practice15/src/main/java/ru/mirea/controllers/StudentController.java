package ru.mirea.controllers;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.DtoConverter;
import ru.mirea.dto.StudentToGroupRequest;
import ru.mirea.services.GroupService;
import ru.mirea.services.StudentService;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/addstudent")
    public RedirectView addstudent(
            @Valid @ModelAttribute("addStudent") StudentToGroupRequest studentToGroupRequest,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            groupService.publish(studentToGroupRequest);
            studentService.publish(studentToGroupRequest);
        }
        return new RedirectView("/home");
    }

    @PostMapping("/{studentId}/delete")
    public RedirectView delete(@PathVariable long studentId) {
        studentService.delete(studentId);
        return new RedirectView("/home");
    }
}
