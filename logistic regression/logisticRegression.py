# stat method used to model prob(binary outcome)
# widely used in machine learning for classification tasks


import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score

# sample data
data = {'Age': [30, 35, 40, 45, 50],
        'Income': [40000, 50000, 60000, 70000, 80000],
        'Buys_Car': [0, 0, 1, 1, 1]}

df = pd.DataFrame(data)

# split data into features(X) and target variable (Y)
X = df[['Age', 'Income']]
Y = df['Buys_Car']

# split into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 42)

model = LogisticRegression()


# Train the model on the training data
model.fit(X_train, y_train)

# Make predictions on the testing data
y_pred = model.predict(X_test)

# Evaluate the model   

accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)
                                              
