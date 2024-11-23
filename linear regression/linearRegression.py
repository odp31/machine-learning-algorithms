import pandas as pd
import numpy as np
from sklearn.lienar_model import LinearRegression
from sklearn.model_selection import train_test_split

# sample data
data = {'X': [1, 2, 3, 4, 5], 'Y': [2, 4, 5, 4, 5]}
df = pd.DataFrame(data)

# split data into features (X) and target variable (Y)
X = df[['X']]
Y = df['Y']

# split data into training and testing sets 
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state=42)

# create linear regression model
model = LinearRegression()

# train model on training data
model.fit(X_train, y_train)

# make predictions on the testing data
y_pred = model.predict(X_test)

# evaluate model
print("Coefficients:", model.coef_)
print("Intercept;", model.intercept_)
