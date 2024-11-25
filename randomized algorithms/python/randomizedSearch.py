from sklearn.model_selection import RandomizedSearchCV
from sklearn.ensemble import RandomForestClassifier
from sklearn.datasets import load_iris

# load iris dataset
iris = load_iris()
X = iris.data
y = iris.target

# create a random forest classifier
rf = RandomForestClassifier()

# define hyperparameter space
param_dist = 
{
  'n_estimators': [50, 100, 200],
  'max_depth': [None, 4, 10, 20],
  'min_samples_split': [2, 5, 10],
  'min_samples_leaf': [1, 2, 4]
}

# create randomizedSearchCv object
random_search = RandomizedSearchCV(rf, param_distributions=param_dist, n_iter=10, cv=5, random_state=42)

# fit randomizedSearchCv object to the data
random_search.fit(X, y)

# print best hyperparameters and score
print(random_search.best_params_)
print(random_search.best_score_)
