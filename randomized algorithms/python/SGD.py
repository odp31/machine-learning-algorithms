# stochastic gradient descent
# optimization algorithm commonly used in machine learning to minimize loss function of a model 
# calculates gradient on a randomly selected subset of the data known as a mini-batch 

import numpy as np
def gradient_descent(X, y, learning_rate, epochs):
  m, n = X.shape
  theta = np.zeros(n)

  for i in range(epochs):
    # randomly select a data point
    index = np.random.randint(m)
    x_i = X[index]
    y_i = y[index]
    # compute gradient
    gradient = (1 / m) * np.dot(x_i.T, (np.dot(x_i, theta) - y_i))
    #update parameters
    theta -= learning_rate * gradient
  return theta 

# example usage
X = np.array([1,2], [2,3], [3,4], [4, 5]])
y = np.array([3, 5, 7, 9])

learning_rate = 0.01
epochs = 1000

theta = gradient_descent(X, y, learning_rate, epochs)
print(theta)
