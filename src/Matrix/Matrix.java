package Matrix;

import java.lang.reflect.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Vladimir on 15.11.2014.
 */

public class Matrix
{
    private double[][] _matrix;
    private int _n;
    private int _m;

    /*---Getter-Setter---*/
    public int getN () { return _n; }

    private void setN (int value) { _n = value; }

    public int getM () { return _m; }

    private void setM (int value) { _m = value; }

    public double getValueAt(int x, int y){ return ( x > -1 ) && ( y > -1 ) ? this._matrix[x][y] : null; }

    public void setValueAt(int y, int x, double value) { if (( x > -1 ) && ( y > -1 ) && ( x <= getM() ) && ( y <= getN() )) _matrix[y][x] = value; }

    public static void setNull(Matrix matrix)
    {
        int width = matrix.getM();
        int height = matrix.getN();
        double eps = 0.00001;
        for ( int i = 0; i < height; ++i )
        {
            for ( int j = 0; j < width; ++j)
            {
                if ((matrix.getValueAt(i, j) < eps) && (matrix.getValueAt(i, j) > 0))
                    matrix.setValueAt(i, j, 0);
                if ((matrix.getValueAt(i, j) > (-eps)) && (matrix.getValueAt(i, j) < 0))
                    matrix.setValueAt(i, j, 0);
            }
        }
    }

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
        if ((n <= 0) && (m <= 0)) return;
        _matrix = new double[n][m];
        setN(n);
        setM(m);
    }

    public Matrix(double[][] inpMatrix)
    {
        setN(inpMatrix.length);
        setM(inpMatrix[0].length);
        _matrix = new double[getN()][getM()];

        for ( int i = 0; i < getN(); ++i)
            for(int j = 0; j <getM(); ++j)
                _matrix[i][j] = inpMatrix[i][j];
    }
    /*---Ctor---*/

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

    public boolean isSquare() { return ( getM() == getN() ); }

    public void fillRandom()
    {
        for(int i=0; i<getN(); ++i )
        {
            for (int j=0; j<getM(); ++j)
            {
                Random rnd = new Random();
                double a = rnd.nextInt(99999) - rnd.nextInt(99999) + rnd.nextInt(9999)/100.00;
                _matrix[i][j] = a;
            }
        }
    }

    public static Matrix createSubMatrix(Matrix matrix, int delRow, int delColumn)
    {
        if ((delColumn<0)&&(delRow<0)) return null;

        Matrix returnedMatrix = new Matrix(matrix.getN()-1,matrix.getM()-1);
        int x = -1;
        int y;

        for (int i = 0; i < matrix.getN(); ++i)
        {
            if ( i == delRow ) continue;
            ++x;
            y = -1;
            for (int j = 0; j < matrix.getM(); ++j)
            {
                if ( j == delColumn ) continue;
                returnedMatrix.setValueAt(x, ++y, matrix.getValueAt(i, j));
            }
        }
        return returnedMatrix;
    }

    public static Matrix transparent(Matrix matrix)
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
        int width1 = matrix1.getM();
        int height1 = matrix1.getN();
        int height2 = matrix2.getN();
        int width2 = matrix2.getM();

        Matrix returnedMatrix = new Matrix(height1,width2);
        Matrix matrixTransparent = Matrix.transparent(matrix2);

        if (( width1 > 0 ) && (height2 > 0) && (height2 == width1))
        {
            for (int i = 0; i < height1; ++i)
            {
                for (int j = 0; j < width2; ++j)
                {
                    for (int k = 0; k < height2; ++k)
                    {
                        returnedMatrix._matrix[i][j] += matrix1.getValueAt(i,k) * matrixTransparent.getValueAt(j,k);
                    }
                }
            }
            return returnedMatrix;
        }
        return null;
    }

    public static double determinant(Matrix matrix)
    {
        if (!matrix.isSquare())
            return 0;
        if (matrix.getM() == 1)
        {
            return matrix.getValueAt(0, 0);
        }
        if (matrix.getN() == 2)
        {
            return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - ( matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
        }
        int sign;
        double mySum = 0.0;
        for ( int i = 0; i < matrix.getN(); ++i)
        {
            sign = (i%2 == 0) ? 1 : -1;
            mySum += sign * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
        }
        return mySum;
    }

    public static Matrix cofactor(Matrix matrix)
    {
        Matrix returnedMatrix = new Matrix(matrix.getN(), matrix.getM());
        int signI;
        int signJ;
        for ( int i = 0; i < matrix.getN(); ++i )
        {
            for ( int j = 0; j < matrix.getM(); ++j)
            {
                signI = (i%2 == 0) ? 1 : -1;
                signJ = (j%2 == 0) ? 1 : -1;
                returnedMatrix.setValueAt(i, j, signI * signJ * determinant(createSubMatrix(matrix, i, j)));
            }
        }
        return returnedMatrix;
    }

    public static Matrix inverse(Matrix matrix)
    {
        double myConst = (1.0/determinant(matrix));
        int width = matrix.getM();
        int height = matrix.getN();
        Matrix returnedMatrix = new Matrix(height,width);
        for ( int i = 0; i < height; ++i)
        {
            if (( width == 1) && ( height == 1))
            {
                returnedMatrix.setValueAt(0, 0, myConst);
                break;
            }
            for ( int j = 0; j < width; ++j)
            {
                returnedMatrix.setValueAt(i, j, myConst * transparent(cofactor(matrix)).getValueAt(i, j));
            }
        }

        return returnedMatrix;
    }

}
