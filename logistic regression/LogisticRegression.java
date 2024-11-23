public class LogisticRegression
  {
    private double[] coefficients;
    public LogisticRegression(double[][] X, double[] y)
    {
      coefficients = train(X, y);
    }
    private double[] train(double[][] X, double[] y)
    {
      int m = X.length; // num samples
      int n = X[0].length;     // num features 

      // initialize coefficients 
      double[] theta = new double[n];

      // hyperparameters
      double alpha = 0.01 // learning rate
      int iterations = 1000; 

      for(int i = 0; i < iterations; i++)
        {
          double[] gradient = new double[n];
          for(int j = 0; j < m; j++) {
            double prediction = sigmoid(predict(X[j], theta));
            double error = prediction - y[j];
            for(int k = 0; k < n; k++) {
              gradient[k] += error * X[j][k];
            }
          }
          for(int j = 0; j < n; j++) {
            theta[j] -= (alpha / m) * gradient[j];
          }
        }
      return theta;
    }
    private double sigmoid(double z)
    {
      return 1 / (1 + Math.exp(-z));
    }
    public double predict(double[] x, double[] theta)
    {
      double prediction = 0;
      for(int i = 0; i < x.length; i++) {
        prediction += theta[i] * x[i];
      }
      return prediction;
    }
    public double predict(double[] x)
    {
      return sigmoid(predict(x, coefficients));
    }
    public double[] getCoefficients(){
      return coefficients;
    }

