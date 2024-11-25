# combines multiple decision trees to improve predictive accuracy and reduce overfitting
# widely used in machine learning tasks including classification and regression

# key concepts:
# decision trees: decision trees are a type of supervised learning algorithm that makes decisions based
# on a series of rules
# ensemble learning; combining multiple models to improve predictive performance
# bagging; technique where multiple models are trained on different subsets of training data
# random feature selection; at each node of a decision tree, a random subset of features is considered for splitting

from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split

from sklearn.datasets import load_iris
from sklearn.metrics import accuracy_score

# load iris dataset
iris = load_iris()
X = iris.data
y = iris.target

# split data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# create random forest classifier
clf = RandomForestClassifier(n_estimators=100, random_state=42)

# train model
clf.fit(X_train, y_train)

# make predictions on test set
y_pred = clf.predict(X_test)

# evaluate model
accuracy = accuracy_score(y_test, y_pred)
print("accuracy", accuracy)
