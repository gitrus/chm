package Matrix;


/**
 * Created by Владимир on 15.11.2014.
 */
public class check
{
    public static void main (String [] args)
    {
        Matrix m1 = new Matrix(300,300);
        m1.fill();
        System.out.print(m1.toString());
        Matrix m2 = new Matrix(3,3);
        Matrix m = Matrix.transporent(m1);
        System.out.print(m.toString());

        System.out.println("Hello, World!");
    }

}
