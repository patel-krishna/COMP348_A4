public class Rhombus extends PrintableObject implements Shape
{
    private double d1, d2;

    public Rhombus(double d1, double d2)
    {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.sqrt(Math.pow(this.d1, 2) + Math.pow(this.d2, 2));
    }

    @Override
    public double getArea()
    {
        return (1/2) * this.d1 * this.d2;
    }

    //maybe In case of error, the method returns null.
    public double inradius()
    {
        return this.d1 * this.d2 / (2 * Math.sqrt(Math.pow(this.d1, 2) + Math.pow(this.d2, 2)));
    }
}
