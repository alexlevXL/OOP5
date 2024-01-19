package Service;

import java.util.List;

import Data.User;
import Data.Group;
import Data.Teacher;

public class GroupService {

   
    public javax.swing.GroupLayout.Group createGroup (int number, User teacher, List<User> students) {
        
        return Group(number, teacher, students);
    }
   
}