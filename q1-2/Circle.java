public class Circle extends PrintableObject implements Shape
{
    private double radius;

    public Circle()
    {
        this.radius = 0;
    }

    public Circle(double radius)
    {
        this.radius = radius;

    }

    public double getRadius()
    {
        return this.radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    @Override
    public String toString()
    {
        return super.getName() + ", " + this.radius + "\n";
    }

    //input string and instantiates and returns
    //a Circle object whose radius is initialized with the value in the input string. The
    //input string is in comma separated format,i.e.:
    //Circle,1. The method returns the object as Circle.
    public static Circle parse(String input)
    {
        String[] inputArray = input.split(",");
        String type = inputArray[0];
        String radius = inputArray[1];

        return new Circle(Double.parseDouble(radius));
    }


    public double getPerimeter()
    {
        return 2 * Math.PI * this.radius;
    }

    public double getArea()
    {
        return Math.PI * Math.pow(this.radius, 2);
    }

    //method and make sure the returned name is in
    //ALL-CAPS.
    @Override
    public String getName() {
        return "CIRCLE";
    }
}
