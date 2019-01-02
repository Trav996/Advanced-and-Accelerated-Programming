//Person.java

public class Person
{
    private String name;

    public Person()
    {
        System.out.println("Inside Person default constructor.");
        System.out.println("Assigning name as \"No name yet\".");
        name = "No name yet";
    }

    public Person
    (
        String initialName //in
    )
    {
        System.out.println("Inside Person one-parameter constructor.");
        System.out.println("Assigning name as " + initialName + ".");
        name = initialName;
    }

    public void setName
    (
        String newName //in
    )
    {
        name = newName;
    }

    public String getName()
    {
        return name;
    }

    public void writeOutput()
    {
        System.out.println("Inside Person's writeOutput method.");
        System.out.println("Displaying the person's name.");
        System.out.println("Name: " + name);
    }
}
