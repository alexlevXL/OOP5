package Controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.GroupLayout.Group;

import Data.Student;
import Data.Teacher;
import Data.Type;
import Data.User;
import Service.GroupService;
import Service.GroupView;
import Service.StudyGroupService;
import View.StudentView;
import View.TeacherView;


public class Controler {
    private final StudyGroupService service= new StudyGroupService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final GroupView groupView = new GroupView();
    private final GroupService groupService = new GroupService();

    public void createStudent(String firstName, String secondName, String lastName) {
        service.create(firstName, secondName, lastName, Type.STUDENT);
    }

    public void getAllStudent(){
        List<User> userList = service.getAllStudent();
        for (User user: userList){
            studentView.printOnConsole((Student) user);
        }
    }

    public void createTeacher(String firstName, String secondName, String lastNameS) {
        service.create(firstName, secondName, lastNameS, Type.TEACHER); // создаем преподавателя
    }

    public void getAllTeacher() {
        List<User> userList = service.getAllTeacher();
        for (User user : userList){
            teacherView.printOnConsole((Teacher) user);
        }
    }

    public Integer getGroupNumber() {// присвоить номер группе
        int number;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите номер группы");
            number = scanner.nextInt();
        }
        return number;

    }

    public User getGroupTeacher() { // назначить преподавателя группы
        int id;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ID педагога");
            id = scanner.nextInt();
        }
        // scanner.close();
        return service.getUserById(Type.TEACHER, id);

    }

    public List<User> studentsInGroup() { // подбираем студентов в группу

        List<User> studentsGroup = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ID студентов, закончите - введите 0");

            while (true) {

                int number = scanner.nextInt();

                studentsGroup.add(service.getUserById(Type.STUDENT, number));

                if (number == 0) {

                    break;
                }

            }
        }
        return studentsGroup;

    }

   
    public void createGroup() {
      
        int numberGroup = getGroupNumber();
        User teacherGroup = getGroupTeacher();
        List<User> students = studentsInGroup();
        Group group = (Group) groupService.createGroup(numberGroup, teacherGroup, students)
        groupView.printOnConsole(group);

    }
}
