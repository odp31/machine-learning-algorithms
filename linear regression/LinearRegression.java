import java.util.Arrays;

public class LinearRegression
  {
    private double[] coefficients;

    public LinearRegression(double[][] X, double[] y)
    {
      coefficients = train(X, y);
    }
    private double[] train(double[][] X, double[] y)
    {
      int m = X.length;
      int n = X[0].length;
      double[] theta = new double[n];
      double alpha = 0.01;
      int iterations = 1000;

      for(int i = 0; i < iterations; i ++)
        {
          double[] gradient = new double[n];
          for(int j = 0; j < m; j++)
            {
              double prediction = predict(X[j], theta);
              double error = prediction - y[j];
              for(int k = 0; k < n; k++)
                {
                  gradient[k] += error * X[j][k];
                }
            }
          for(int j = 0; j < n; j++)
            {
              theta[j] -= (alpha / m) * gradient[j];
            }
        }
      return theta;
    }
    public double predict(double[] x, double[] theta)
    {
      double prediction = 0;
      for(int i = 0; i < x.length; i++)
        {
          prediction += theta[i] * x[i];
        }
      return prediction;
    }
    public double predict(double[] x)
    {
      return predict(x, coefficients);
    }
    public double[] getCoefficients()
    {
      return coefficients;
    }
  }


      
