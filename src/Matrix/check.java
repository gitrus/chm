package Matrix;

import java.io.IOException;
/**
 * Created by Vladimir on 15.11.2014.
 */
public class check
{
    public static void main (String [] args) throws IOException
    {
        Matrix m2 = new Matrix(10,10);
        m2.fillRandom();
        ExcelWork.writeExcel("10x10.xls",m2);
        Matrix m1 =  ExcelWork.readExcel("10x10.xls");
        System.out.print(m1+"\n");

        Matrix.setNull(m1);
        System.out.print(m1);

    }

}
