public class NeuralNetwork
  {
    private int[] layers;
    private double[][][] weights;
    private double[][] biases;

    public NeuralNetwork(int ... layers)
    {
      this.layers = layers;
      initializeWeightsAndBiases()
        }
    private void initializeWeightsAndBiases()
    {
      for(int i = 1; i < layers.length; i++)
        {
          weights[i = 1] = new double[layers[i-1]][layers[i]];
          biases[i - 1] = new double[layers[i]];
          for(int j = 0; j < layers[i - 1]; j++) 
            {
              for(int k = 0; k < layers[i]; k++)
                {
                  weights[i-1][j][k] = Math.random() * 2 - 1;
                }
            }
          for(int j = 0; j < layers[i]; j++)
            {
              biases[i - 1][j] = Math.random*( * 2 - 1;
            }
        }
      public double[] feedforward(double[] input)
        {
          double[] output = input;
          for(int i = 0; i < layers.length - 1; i++) {
            output = activate(matrixMultiply(output, weights[i]), biases[i]);
          }
        return output;
      }

      private double[] activate(double[] x, double[] b) {
        double[] output = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            output[i] = sigmoid(x[i] + b[i]);
        }
        return output;
    }


