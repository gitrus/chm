package Matrix;


/**
 * Created by Vladimir on 15.11.2014.
 */
public class check
{
    public static void main (String [] args)
    {
        Matrix m1 = new Matrix(2,1);
        m1.fill();
        System.out.print(m1.toString());
        Matrix m2 = new Matrix(1,2);
        m2.fill();
        Matrix m = Matrix.transporent(m2);
        System.out.print(m2.toString());
        System.out.print("\n");
        Matrix m3 = Matrix.multiply(m1,m2);
        System.out.print(m3.toString());
        //System.out.println("Hello, World!");
    }

}
