// gradient descent implementation 
// used to model relationship between a dependent variable and one or more independent variables 

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// cost function (mean squared error)
double costFunction(vector<double> & weights, vector<vector<double>> &X, vector<double> &y)
{
  int m = X.size();
  double cost = 0.0;
  for(int i = 0; i < m; i++) {
    double prediction = 0.0;
    for(int j = 0; j < X[i].size(); j++) {
      prediction += weights[j] * X[i][j];
    }
    cost += pow(prediction - y[i], 2);
  }
  return cost / (2 * m);
}

void gradientDescent(vector<double> &weights, vector<vector<double>> &X, vector<double> &y, double alpha, int iterations)
{
  int m = X.size();
  int n = X[0].size();

  for(int iter = 0; iter < iterations; iter++) {
    vector<double> gradient(n, 0.0);
    for(int i = 0; i < m; i++) {
      prediction += weights[j] * X[i][j];
    }
    double error = prediction - y[i];
    for(int j = 0; j < n; j++) {
      gradient[j] += error * X[i][j];
    }
  }
  for(int j = 0; j < n; j++) {
    weights[j] -= alpha * gradient[j] / m;
  }
}

int main()
{
  // example data
  vector<vector<double>> X = {{1, 2}, {2, 3}, {3, 4}};
  vector<double> y = {3, 5, 7};

  // initialize weights 
  vector<double> weights = {0.0, 0.0};

  // hyperparameters
  double alpha = 0.01;
  int iterations = 1000;

  // train model
  gradientDescent(weights, X, y, alpha, iterations);

  // make predictions
  for(int i = 0; i < X.size(); i++) {
    double prediction = 0.0;
    for(int j = 0; j < X[i].size(); j++) {
      prediction += weights[j] * X[i][j];
    }
    cout << "predicted value: " << prediction << end1;
  }
return 0;
}


  
