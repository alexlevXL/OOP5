import Controler.Controler;

public class Main {
   
       
        public static void main(String[] args) {
            Controler controler = new Controler();
            controler.createStudent("1", "1","1");
            controler.getAllStudent();
            controler.createStudent("3", "3","3");
            controler.getAllStudent();
            controler.createTeacher("f", "g","j");
            controler.getAllTeacher();
            controler.createGroup();
        }
    
}