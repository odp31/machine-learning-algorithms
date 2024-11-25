import java.util.Random;

public class StochasticGradientDescent
  {
    public static double[] gradientDescent(double[][] X, double[] y, double learningRate, int iterations)
    {
      int m = X.length;
      int n = X[0].length;
      double[] theta = new double[n];

      Random random = new Random();

      for(int i = 0; i < iterations; i++)
        {
          int index = random.nextInt(m);
          double[] x_i = X[index];
          double y_i = y[index];
          double prediction = 0;
          for(int j = 0; j < n; j++)
            {
              prediction += theta[j] * x_i[j];
            }
          for(int j = 0; j < n; j++)
            {
              theta[j] -= learningRate * (prediction - y_i) * x_i[j];
            }
        }
      return theta;
    }
  }
