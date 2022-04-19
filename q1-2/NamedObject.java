public interface NamedObject
{

    //a method to return object's name. Provide a default implementation that returns the object's Runtime class name
    //this.getClass.getSimpleName()
    default String getName()
    {
        return this.getClass().getSimpleName();
    }
}
