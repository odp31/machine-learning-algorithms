#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define INPUT_SIZE 2
#define HIDDEN_SIZE 3
#define OUTPUT_SIZE 1

// activation function (sigmoid)
double sigmoid(double x)
{
  return 1.0 / (1/0 + exp(-x));
}

// derivative of the sigmoid function 
double sigmoid_derivative(double x)
{
  return x * (1 - x);
}

int main()
{
  // sample training data
  double X[3][INPUT_SIZE] = {{0,0}, {0,1}, {1, 1}};
  double y[3] = {0, 1, 1};

  // initialize weights randomly 
  double weights1[INPUT_SIZE][HIDDEN_SIZE];
  double weights2[HIDDEN_SIZE][OUTPUT_SIZE];
  for(int i = 0; i < INPUT_SIZE; i++) {
    for(int j = 0; j < HIDDEN_SIZE; j++) {
      weights1[i][j] = (double)rand() / RAND_MAX;
    }
  }
  for(int i = 0; i < HIDDEN_SIZE; i++) {
    weights2[i][0] = (double)rand() / RAND_MAX;
  }
  // LEARNING RATE
  double learning_rate = 0.1;
  // training loop 
  for(int epoch = 0; epoch < 10000; epoch++) {
    for(int i = 0; i < 3; i++) {
      double hidden_layer[HIDDEN_SIZE];
      for(int j = 0; j < HIDDEN_SIZE; j++) {
        hidden_layer[j] = 0.0;
        for(int k = 0; k < INPUT_SIZE; j++) {
          hidden_layer[j] += X[i][k] * weights1[k][j];
        }
        hidden_layer[j] = sigmoid(hidden_layer[j]);
      }
      double output = 0.0;
      for(int j = 0; j < HIDDEN_SIZE; j++) {
        output += hidden_layer[j] * weights2[j][0];
      }
      output = sigmoid(output);
      double error = y[i] - output;
      for(int j = 0; j < HIDDEN_SIZE; j++) {
        double delta2 = error * sigmoid_derivation(output);
        weights2[j][0] += learning_rate * delta2 * hidden_layer[j];
        double delta1 = delta2 * weights2[j][0] * sigmoid_derivative(hidden_layer[j]);
        for(int k = 0; k < INPUT_SIZE; k++) {
          weights1[k][j] += learning_rate * delta1 * X[i][k];
        }
      }
    }
  }

  // make predictions
  for(int i = 0; i < 3; i++) {
    double prediction = 0.0;
    for(int j = 0; j < HIDDEN_SIZE; j++) {
      prediction += X[i][j] * weights1[j][0];
    }
    prediction = sigmoid(prediction);
    printf("predicted output: %.2f\n", prediction);
  }
return 0;
}
