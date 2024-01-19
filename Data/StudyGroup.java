package Data;
import java.util.List;

public abstract class StudyGroup {

    private User teacherGroup;
    private List<User> students;

    public StudyGroup(User teacherGroup, List<User> students) {
        this.teacherGroup = teacherGroup;
        this.students = students;
        
    }

    public User getTeacherGroup() {
        return teacherGroup;
    }

    public void setTeacherGroup(Teacher teacherGroup) {
        this.teacherGroup = teacherGroup;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }
    
}