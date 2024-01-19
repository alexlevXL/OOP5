package Data;
public class Teacher extends User{
    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherID(int teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(String firstName, String secondName, String lastName, int teacherID) {
        super(firstName, secondName, lastName);
        this.teacherId = teacherID;

    }
    

    @Override
    public String toString() {
        return " Педагог [" + "ID =" + teacherId + " Имя: " + super.getFirstName() + "  Отчество: "
                + super.getSecondName() + " + Фамилия: " + super.getLastName();
    }

}
