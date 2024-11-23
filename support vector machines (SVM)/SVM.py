# powerful supervised learning algorithm used for both classification and
# regression tasks; work for finding optimal hyperplane that 
# separates data points into different classes 

# basic example: classification


import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import accuracy_score

# sample data
data = {'Age': [30, 35, 40, 45, 50],
        'Income': [40000, 50000, 60000, 70000, 80000],
        'Buys_Car': [0, 0, 1, 1, 1]}
df = pd.DataFrame(data)

# split data into features(X) and target variable (y)
X = df[['Age', 'Income']]
y = df['Buys_Car']

# split data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# create svm classifier
clf = SVC()

# train model on training data
clf.fit(X_train, y_train)

# make predicitions on training data 
y_pred = clf.predict(X_test)

# evaluate model 
accuracy = accuracy_score(y_test, y_pred)
print("accuracy:", accuracy)

