package Matrix;

import java.io.IOException;
/**
 * Created by Vladimir on 15.11.2014.
 */
public class check
{
    public static void main (String [] args) throws IOException
    {

        Matrix m1 = new Matrix(5,10);
        m1.fill();
        Matrix m2 = new Matrix(2,3);
        m2.fill();
        Matrix m3 = new Matrix(7,2);
        m3.fill();
        ExcelWork.writeExcel("Formulas.xls", m1);
        ExcelWork.writeExcel("Formulas1.xls", m2);
        ExcelWork.writeExcel("Formulas2.xls", m3);
        /*System.out.print(m1.toString());
        Matrix m2 = new Matrix(50,50);
        m2.fill();
        //Matrix m = Matrix.transporent(m2);
        System.out.print(m2.toString());
        System.out.print("\n");
        Matrix m3 = Matrix.multiply(m1,m2);
        System.out.print(m3.toString());
        //System.out.println("Hello, World!");*/

    }

}
