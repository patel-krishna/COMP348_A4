using System;
using ExtensionMethod;
using Rectangle;
using Circle;

namespace comp348_a4_q3
{
    interface IShape
    {
        string Name{
            get;
        }

        double GetPerimeter();
        double GetArea();
    }
    

    class Rectangle : IShape{
        
        public string Name{
            get=> this.GetType().Name;
        }
       // double length;
       // double width;
        double Length{
           // get{ return length;}
           // set{length=value; }
           get;
           set;
        }

        double Width{
            //get{return width;}
            //set{width=value;}
            get;
            set;
        }

        public Rectangle(){
            this.Length = 0;
            this.Width = 0; 
        }
        public Rectangle(double l, double w){
            this.Length = l;
            this.Width = w;
        }

        public override string ToString()
        {
            return this.Name+","+this.Length+","+this.Width;
        }

        public double GetPerimeter(){
            return (2*this.Length)+(2*this.Width);
        }

        public double GetArea(){
            return this.Length*this.Width; 
        }
    }

    class Circle : IShape{

        public string Name{
            get=> this.GetType().Name;
        }
        double Radius{
            get;
            set;
        }

        public Circle(){
            this.Radius=0;
        }

        public Circle(double r){
            this.Radius =r;
        }

        public override string ToString()
        {
            return this.Name+","+this.Radius;
        }

        public double GetArea(){
            return (this.Radius)*(this.Radius)*3.14159265359;

        }

        public double GetPerimeter(){
            return 2*3.14159265359*(this.Radius); 

        }
    }

class Program 
{
  static void Main(string[] args) 
  {
    Rectangle test= new Rectangle(2,3);
    Console.WriteLine(test.GetPerimeter());
    Console.WriteLine(test.GetArea());
    Console.WriteLine(test.ToString());

    Circle test2 = new Circle(2);
    Console.WriteLine(test2.GetPerimeter());
    Console.WriteLine(test2.GetArea());
    Console.WriteLine(test2.ToString());

    IShape test3 = RectangleNewMethod.Parse("Rectangle,2,3.5"); 
    Console.WriteLine(test3.ToString());

    IShape test4 = CircleNewMethod.Parse("Circle,7"); 
    Console.WriteLine(test4.ToString());

  }
}
}
