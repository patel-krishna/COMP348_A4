using System.Linq;
using Circle;
using comp348_a4_q3;
using Rectangle;

//q5
public static class TextFileProcessor {
    public static event MyEventHandler? LineRead;

    public static void Read(string file){
        //get all lines from file
        string allLines = File.ReadAllText(file);
        
        //split all of the lines into separate lines
        String[] splitLines = allLines.Split('\n');

        // call lineRead on each line
        splitLines.ToList().ForEach( x => LineRead(x));
    }
}

public delegate void MyEventHandler(string sender); 

//q6
public static class Main_ {

    static List<IShape> shapes = new List<IShape>();
    static void Main(string[] args){
        TextFileProcessor.LineRead += OnEvent;
        TextFileProcessor.Read("/Users/rosiers/RiderProjects/a4_csharp/csharp_q/shapes.txt");
        
        //Sort by name then area
        Console.WriteLine("Displaying shapes by name and area");
        
        var sortByArea = 
            from shape in shapes 
            orderby shape.GetType().Name, shape.GetArea()
            select shape;

        foreach(var s in sortByArea)
            Console.WriteLine($"{s.Name},{s.GetArea()}");

        //Sort by perimeter only
        Console.WriteLine("\nDisplaying shapes by perimeter");

        var sortByPerimeter = 
            from shape in shapes
            orderby shape.GetPerimeter()
            select shape;
    
        foreach( var s in sortByPerimeter)
            Console.WriteLine($"{s.Name},{s.GetPerimeter()}");
        
        //calculate required statistics for all shapes
        double averageArea = (shapes.Sum(s => s.GetArea())) / (shapes.Count);
        double averagePerimeter = (shapes.Sum( s => s.GetPerimeter())) / (shapes.Count);

        Console.WriteLine("\nAverages per shape");
        
        //group stats by shape
        var group =
            from shape in shapes
            group shape by shape.Name into shapeGroup
            orderby shapeGroup.Key
            select shapeGroup;
        
        //calculate statistics per shape
        group.ToList().ForEach(eachShape => {        
            int i = 0;
            foreach (var shape in eachShape) {
                i++;
            }
            
            double avgAreaPerShape = (eachShape.Sum(s => s.GetArea())) / (i);    
            Console.WriteLine("Average area for " + eachShape.Key + ": " + avgAreaPerShape);
            
            double avgPerimeterPerShape = (eachShape.Sum( s => s.GetPerimeter())) / (i);    
            Console.WriteLine("Average perimeter for " + eachShape.Key + ": " + avgPerimeterPerShape);
        });

        Console.WriteLine("\nTotal number of shapes: " + shapes.Count);
        Console.WriteLine("Average Perimeter: " + averagePerimeter);
        Console.WriteLine("Average Area: " + averageArea);
        Console.ReadLine();
    }

    static void OnEvent(string input) {
        string[] shapeName = input.Split(',');
        
        // call correct parse method based on first element on line
        if (shapeName[0] == "Circle")
            shapes.Add(CircleNewMethod.Parse(input));
        else if (shapeName[0] == "Rectangle")
            shapes.Add(RectangleNewMethod.Parse(input));
    }
}

