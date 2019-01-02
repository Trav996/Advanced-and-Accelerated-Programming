//Student.java

public class Student extends Person
{
    private int studentNumber;

    public Student()
    {
        super();
        System.out.println("Inside Student default constructor.");
        System.out.println("A default person has been constructed.");
        System.out.println("Now assigning studentNumber 0.");
        studentNumber = 0; //Indicating no number yet
    }

    public Student
    (
        String initialName,      //in
        int initialStudentNumber //in
    )
    {
        super(initialName);
        System.out.println("Inside Student two-parameter constructor.");
        System.out.println("A person with name " + initialName
            + " has been created.");
        System.out.println("Now assigning studentNumber "
            + initialStudentNumber + ".");
        studentNumber = initialStudentNumber;
    }

    public void reset
    (
        String newName,      //in
        int newStudentNumber //in
    )
    {
        setName(newName);
        studentNumber = newStudentNumber;
    }

    public void setStudentNumber
    (
        int newStudentNumber //in
    )
    {
        studentNumber = newStudentNumber;
    }

    public int getStudentNumber()
    {
        return studentNumber;
    }

    public void writeOutput()
    {
        System.out.println("Inside Student's writeOutput method.");
        System.out.println("Displaying the student's name and student number.");
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + studentNumber);
    }
}
