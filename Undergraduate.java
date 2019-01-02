//Undergraduate.java

public class Undergraduate extends Student
{
    private int level; //1=freshman, 2=sophomore, 3=junior, 4=senior

    public Undergraduate()
    {
        super();
        System.out.println("Inside Undergraduate default constructor.");
        System.out.println("A default student has been constructed.");
        System.out.println("Now assigning level 1.");
        level = 1;
    }

    public Undergraduate
    (
        String initialName,
        int initialStudentNumber,
        int initialLevel
    )
    {
        super(initialName, initialStudentNumber);
        System.out.println("Inside Undergraduate "
            + "three-parameter constructor.");
        System.out.println("A student with name " + initialName + " and "
            + "student number " + initialStudentNumber
            + " has been constructed.");
        System.out.println("Now assigning level " + initialLevel + ".");
        setLevel(initialLevel); //Checks 1 <= initialLevel <= 4
    }

    public void reset
    (
        String newName,       //in
        int newStudentNumber, //in
        int newLevel          //in
    )
    {
        reset(newName, newStudentNumber); //Student's reset
        setLevel(newLevel); //Checks 1 <= newLevel <= 4
    }

    public void setLevel
    (
        int newLevel //in
    )
    {
        if ((1 <= newLevel) && (newLevel <= 4))
            level = newLevel;
        else
        {
            System.out.println("Illegal level!");
            System.exit(0);
        }
    }

    public int getLevel()
    {
        return level;
    }

    public void writeOutput()
    {
        System.out.println("Inside Undergraduate's writeOutput method.");
        System.out.println("Displaying the undergraduate's name, "
            + "student number and level.");
        System.out.println("Name: " + getName());
        System.out.println("Student Number: " + getStudentNumber());
        System.out.println("Student Level: " + level);
    }
}
