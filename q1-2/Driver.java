import java.io.*;
import java.util.*;

//TODO Make sure all exceptions are caught. In case of format error
// or any particular runtime error, the program prints the details of the error and simply terminates.
// array point to null

public class Driver
{


    //need to use try-with-resources to open the file
    public static void main(String[] args) throws Exception {
        //Shape[] shapes = new Shape[12];
        //List<Shape> shapeList = new ArrayList<>();
        String[] shapeList = new String[12];
//        double[] circlenum = new double[100];
//        double[] rectanglenum = new double[100];
//        double[] rectanglenum2 = new double[100];
//        double[] Rhombusnum = new double[100];
//        double[] Rhombusnum2 = new double[100];
        int i = 0;
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the filename.
        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();

        //try(BufferedReader file = new BufferedReader(new FileReader(filename))){
        try(BufferedReader file = new BufferedReader(new FileReader(filename))){
            Scanner inputFile = new Scanner(file);
            // Read lines from the file until no more are left.

            shapeList = (String[]) Arrays.stream(shapeList).map(x -> inputFile.hasNext()).map(x -> inputFile.nextLine());
            Arrays.stream(shapeList).map(x -> inputFile.hasNext()).filter(x -> x.contains("Rectangle")).forEach(System.out::println);
            //Arrays.stream(shapeList).forEach(x -> inputFile.hasNext());

//            while (inputFile.hasNext())
//            {
//                // Read the next name.
//                String shape = inputFile.nextLine();
//
//                if(shape.contains("Rectangle"))
//                {
//                    shapeList[i] = "Rectangle";
//
//
//                }else if(shape.contains("Circle")){
//                    shapeList[i] = "Circle";
//                    circlenum[i] = Double.parseDouble(shape.split(",")[0]);
//                }else{
//                    shapeList[i] = "Rhombus";
//
//                }
//
//                i++;
//
//           }



//            while (inputFile.hasNext())
//            {
//                // Read the next name.
//                String shape = inputFile.nextLine();
//
//                if(shape.contains("Rectangle"))
//                {
//                    shapes[i] = Rectangle.parse(shape);
//
//                }else{
//                    shapes[i] = Circle.parse(shape);
//                }
//
//                i++;
//
//            }

//            Arrays.sort(shapes, new Comparator()
//            {
//
//                public int compare(Object o1, Object o2)
//                {
//                    Shape sa = (Shape) o1;
//                    Shape sb = (Shape) o2;
//                    String name1 =  sa.getName();
//                    String name2 =  sb.getName();
//
//
//                    if(name1.equals(name2))
//                    {
//                        double a1 = sa.getArea();
//                        double a2 = sb.getArea();
//
//                        if(a1 > a2)
//                        {
//                            return 1;
//                        }else if(a1 == a2)
//                        {
//                            return 0;
//                        }else{
//                            return -1;
//                        }
//                    }else{
//                       return name1.compareTo(name2);
//                    }
//
//                }
//            }   );


            //Printable.print(java.util.Arrays.copyOf(shapes, shapes.length, Printable[].class));
            Printable.print(java.util.Arrays.copyOf(shapeList, shapeList.length, Printable[].class));

            // Close the file.
            inputFile.close();
            keyboard.close();
        }



    }
}
