import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn import ensemble
from sklearn.decomposition import PCA
from sklearn.preprocessing import scale
from sklearn.metrics import mean_squared_error
import os

# Load the dataset
file_path = r"D:\Study Material\HousingData.csv"
if not os.path.exists(file_path):
    raise FileNotFoundError(f"Dataset not found at {file_path}")

data = pd.read_csv(file_path)

# Display basic statistics
print(data.describe())

# Handle missing values if any
data = data.dropna()

# Check column names
print("Dataset Columns:", data.columns)

# Convert 'date' column to binary (1 for 2014, else 0) if it exists
if 'date' in data.columns:
    data['date'] = [1 if str(value).startswith('2014') else 0 for value in data['date']]

# Drop unnecessary columns for model training
if 'id' in data.columns:
    data = data.drop(['id'], axis=1)

# Define features and target variable
if 'price' in data.columns:
    target_column = 'price'
elif 'MEDV' in data.columns:  # For Boston Housing Dataset
    target_column = 'MEDV'
else:
    raise ValueError("Target variable not found in dataset")

labels = data[target_column]
train1 = data.drop([target_column], axis=1)

# Train-test split (90% train, 10% test)
x_train, x_test, y_train, y_test = train_test_split(train1, labels, test_size=0.10, random_state=2)

# Creating a Linear Regression Model
reg = LinearRegression()
reg.fit(x_train, y_train)
print(f"Linear Regression R^2 score: {reg.score(x_test, y_test)}")

# Gradient Boosting Regressor Model
clf = ensemble.GradientBoostingRegressor(n_estimators=400, max_depth=5, min_samples_split=2)
clf.fit(x_train, y_train)
print(f"Gradient Boosting Regressor R^2 score: {clf.score(x_test, y_test)}")

# Evaluating Gradient Boosting Regressor with staged prediction
t_sc = np.zeros((clf.n_estimators), dtype=np.float64)
for i, y_pred in enumerate(clf.staged_predict(x_test)):
    t_sc[i] = mean_squared_error(y_test, y_pred)

testsc = np.arange(clf.n_estimators) + 1

# Plot training and testing error over n_estimators
plt.figure(figsize=(12, 6))
plt.plot(testsc, clf.train_score_, 'b-', label='Training error')
plt.plot(testsc, t_sc, 'r-', label='Testing error')
plt.title('Training and Testing Error over Estimators')
plt.xlabel('Number of Estimators')
plt.ylabel('Loss (MSE)')
plt.legend()
plt.show()

# Principal Component Analysis (PCA) for dimensionality reduction
pca = PCA()
train1_scaled = scale(train1)
pca.fit_transform(train1_scaled)
print("PCA transformation completed.")
