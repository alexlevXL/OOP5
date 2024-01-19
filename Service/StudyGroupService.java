package Service;

import java.util.ArrayList;
import java.util.List;

import Data.Student;
import Data.Teacher;
import Data.Type;
import Data.User;

public class StudyGroupService {
    private List<User> userList;
    public StudyGroupService() {
        this.userList = new ArrayList<>();
    }
    public void create(String firsName, String secondName,String lastName,  Type type) {
        User user;
        if (Type.STUDENT == type);{
          user = new Student(lastName, secondName, lastName, 0);
    }
        if (Type.TEACHER == type);{
          user = new Teacher(lastName, secondName, lastName, 0);
    }
    userList.add(user);
    }
    private int getFreeId(Type type){
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
            for (User user : userList) {
                if(user instanceof Teacher && !itsStudent){
                    lastId = ((Teacher) user).getTeacherId() + 1;
                }
                if(user instanceof Student && itsStudent){
                    lastId = ((Student) user).getStudentId() + 1;
                }

            }
        return lastId;
    }

    public User getUserById(Type type, int id){
        boolean itsStudent = Type.STUDENT == type;
        for(User user: userList){
            if(user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id){
                return user;
            }
            if(user instanceof Student && itsStudent && ((Student) user).getStudentId() == id){
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUser(){
        return userList;
    }

    public List<User> getAllStudent(){
        List<User> resultList = new ArrayList<>();
        for(User user : userList){
            if (user instanceof Student){
                resultList.add(user);
            }
        }
        return resultList;
    }

    public List<User> getAllTeacher(){
        List<User> resultList = new ArrayList<>();
        for(User user : userList){
            if (user instanceof Teacher){
                resultList.add(user);
            }
        }
        return resultList;
     }
}