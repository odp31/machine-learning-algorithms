#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// sigmoid function 
double sigmoid(double x)
{
  return 1.0 / (1.0 + exp(-x));
}

// cost function
double costFunction(vector<double> &weights, vector<vector<double>> &X, vector<int> &y)
{
  double cost = 0.0;
  int m = X.size();
  for(int i = 0; i < m; i++) {
    double z = 0.0;
    for(int j = 0; j < X[i].size(); j++) {
      z += weights[j] * X[i][j];
    }
    double h = sigmoid(z);
    cost += -y[i] * log(h) - (1 - y[i]) * log(1 - h);
  }
return cost / m;
}

// gradient descent
void gradientDescent(vector<double> &weights, vector<vector<double>> &X, vector<int> &y, double alpha, int iterations)
{
  int m = X.size();
  int n = X[0].size();

  for(int iter = 0; iter < iterations; iter++) {
    vector<double> gradient(n, 0.0);
    for(int i = 0; i < m; i++) {
      double z = 0.0;
      for(int j = 0; j < n; j++) {
        z += weights[j] * X[i][j];
      }
      double error = sigmoid(z) - y]i];
      for(int j = 0; j < n; j++) {
        gradient[j] += error * X[i][j];
      }
    }
    for(int j = 0; j < n; j++) {
      weights[j] -= alpha * gradient[j] / m;
    }
  }
}

int main()
{
  // example data
  vector<vector<double>> X = {{1, 2}, {2, 3}, {3, 4}};
  vector<int> y = {0, 1, 1};
  // initialize weights
  vector<double> weights = {0.0, 0.0};
  // hyperparameters
  double alpha = 0.1;
  int iterations = 1000;
  // train model
  gradientDescent(weights, X, y, alpha, iterations);
  // make predictions
  for(int i = 0; i < X.size(); i++) {
    double z = 0.0;
    for(int j = 0; j < X[i].size(); j++) {
      z += weights[j] * X[i][j];
    }
    double prediction = sigmoid(z);
    cout << "predicted probability: " << prediction << end1;
  }
return 0;
}
