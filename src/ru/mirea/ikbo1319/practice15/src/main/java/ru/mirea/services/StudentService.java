package ru.mirea.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.dto.StudentToGroupRequest;
import ru.mirea.models.Group;
import ru.mirea.models.Student;
import ru.mirea.repositories.GroupRepository;
import ru.mirea.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void publish(StudentToGroupRequest request) {
        String groupName = request.getGroupName();
        Group group = groupRepository.findByGroupName(groupName);
        if (group == null) {
            return;
        }
        Student student = new Student();
        student.setGroup(group);
        student.setFirstName(request.getStudentFirstName());
        student.setMiddleName(request.getStudentMiddleName());
        student.setLastName(request.getStudentLastName());
        studentRepository.save(student);
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
