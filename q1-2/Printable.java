public interface Printable
{

    //a void method to print object's info to the console.
    void print();

    //method that receives a list of printables and calls their print()
    //methods
    //To implement static Printable.print() method, use vararg for the argument type and use Java foreach to loop through the elements.
    static void print(Printable ...p)
    {
        for(Printable object : p)
        {
            object.print();
        }
    }
}
