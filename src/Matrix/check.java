package Matrix;

import java.io.IOException;
/**
 * Created by Vladimir on 15.11.2014.
 */
public class check
{
    public static void main (String [] args) throws IOException
    {

        Matrix m1 = new Matrix(10,10);
        m1.fillRandom();
        System.out.print(m1.toString());
        System.out.print(Matrix.transparent(Matrix.cofactor(m1)));

        System.out.print(Matrix.inverse(m1));

        /*Matrix m1 = new Matrix(5,10);
        m1.fillRandom();
        Matrix m2 = new Matrix(2,3);
        m2.fillRandom();
        Matrix m3 = new Matrix(7,2);
        m3.fillRandom();
        double[][] matrix = {{4,5},{6,7}};
        Matrix m1= new Matrix(matrix);
        System.out.print(Matrix.inverse(m1).toString());*/

        /*ExcelWork.writeExcel("Formulas.xls", m1);
        ExcelWork.writeExcel("Formulas1.xls", m2);
        ExcelWork.writeExcel("Formulas2.xls", m3);
        ExcelWork.readExcel("Formulas.xls");
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
