package Matrix;

import java.lang.reflect.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Vladimir on 15.11.2014.
 */

public class Matrix<T>
{
    private double[][] _matrix;
    private int _n;
    private int _m;

    /*---Getter-Setter---*/
    public int getN () { return _n; }

    private void setN (int value) { _n = value; }

    public int getM () { return _m; }

    private void setM (int value) { _m = value; }
    /*---Getter-Setter---*/

    /*---Ctor---*/
    public Matrix()
    {
         _matrix = null;
        setN(0);
        setM(0);
    }

    public Matrix(int n)
    {
        _matrix = new double[n][n];
        setN(n);
        setM(n);
    }

    public Matrix(int n,int m)
    {
        _matrix = new double[n][m];
        setN(n);
        setM(m);
    }
    /*---Ctor---*/
    public void fill()
    {
        for(int i=0; i<getN(); ++i )
        {
            for (int j=0; j<getM(); ++j)
            {
                Random rnd = new Random();
                double a = rnd.nextInt(99999) - rnd.nextInt(99999) + rnd.nextInt(9999)/100.0;
                _matrix[i][j] = a;
            }
        }
    }

    public static Matrix transporent(Matrix matrix)
    {
        int height = matrix.getN();
        int width = matrix.getM();
        if (( width > 0 ) && ( height > 0 ))
        {
            Matrix returnedMatrix = new Matrix(width,height);
            for ( int i = 0; i < height; ++i )
            {
                for ( int j = 0; j < width; ++j )
                {
                    returnedMatrix._matrix[j][i] = matrix._matrix[i][j];
                }
            }
            return returnedMatrix;
        }
        return null;
    }

    public static Matrix multiply (Matrix matrix1, Matrix matrix2)
    {
        int height2 = matrix2.getN();
        int width1 = matrix1.getM();
        int height1 = matrix1.getN();
        int width2 = matrix2.getM();
        Matrix returnedMatrix = new Matrix(height1,width2);
        Matrix matrixTransporent = Matrix.transporent(matrix2);
        if (( width1 > 0 ) && (height2 > 0) && (height2 == width1))
        {
            for (int i = 0; i < height1; ++i)
            {
                for (int j = 0; j < width2; ++j)
                {
                    for (int k = 0; k < height2; ++k)
                    {
                        returnedMatrix._matrix[i][j] += matrix1._matrix[i][k] * matrixTransporent._matrix[j][k];
                    }
                }
            }
            return returnedMatrix;
        }
        return null;
    }

    @Override
    public String toString()
    {
        String retString = new String();
        for(int i=0; i<getN(); ++i)
        {
            for (int j = 0; j < getM(); ++j)
            {
                retString += _matrix[i][j] + " ";
            }
            retString += String.format("\n");
        }
        return retString;
    }
}
