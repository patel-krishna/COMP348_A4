using System;
using comp348_a4_q3; 

namespace ExtensionMethod{
using System;
using comp348_a4_q3; 
    static class NewMethodClass {

        public static void Print(this IShape s){
             Console.WriteLine(s.ToString()); 
        }

    }
}

namespace Rectangle{
    using System;
    using comp348_a4_q3; 
    static class RectangleNewMethod{
        public static Rectangle Parse(string s){
            
            string[] element = s.Split(',');
            double length = Double.Parse(element[1]); 
            double width = Double.Parse(element[2]); 
            return new Rectangle(length, width); 
        }
    }
}

namespace Circle{        
    using System;
    using comp348_a4_q3; 
    static class CircleNewMethod{
        public static Circle Parse(string s){
            
            string[] element = s.Split(',');
            double radius = Double.Parse(element[1]); 
            return new Circle(radius);
        }
    }
}

