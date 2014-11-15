package Matrix;

/**
 * Created by Vladimir on 15.11.2014.
 */

public class Matrix
{
    private float[][] _matrix;
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
        _matrix = new float[n][n];
        setN(n);
        setM(n);
    }

    public Matrix(int n,int m)
    {
        _matrix = new float[n][m];
        setN(n);
        setM(m);
    }
    /*---Ctor---*/

    public Matrix transporent(Matrix matrix)
    {

        return matrix;
    }

    public static Matrix multiply (Matrix matrix1, Matrix matrix2)
    {
        Matrix returnedMatrix = new Matrix();



        return returnedMatrix;
    }
}
