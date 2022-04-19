
public class Rectangle extends PrintableObject implements Shape
{
    private double length, height;

    public Rectangle()
    {
        this.length = 0;
        this.height = 0;
    }

    public Rectangle(double length, double height)
    {
        this.length = length;
        this.height = height;
    }

    public double getLength()
    {
        return this.length;
    }

    public double getHeight()
    {
        return this.height;
    }


    public void setLength(double length)
    {
        this.length = length;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return super.getName() + ", " + this.length + ", " + this.height + "\n";
    }

    //The input string is in comma separated format,i.e.: 'Rectangle,2,3.5. The method returns
    //the object as Rectangle.
    public static Rectangle parse(String input)
    {
        String[] inputArray = input.split(",");
        String type = inputArray[0];
        String width = inputArray[1];
        String height = inputArray[2];

        return new Rectangle(Double.parseDouble(width), Double.parseDouble(height));
    }


    public double getPerimeter()
    {
        return (this.height + this.length) * 2;
    }

    public double getArea()
    {
        return this.height * this.length;
    }

}
