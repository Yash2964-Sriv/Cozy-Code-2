# This Python 3 environment comes with many helpful analytics libraries installed
# It is defined by the kaggle/python Docker image: https://github.com/kaggle/docker-python
# For example, here's several helpful packages to load

import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
import seaborn as sns
import matplotlib.pyplot as plt
import warnings
warnings.filterwarnings('ignore')
# Input data files are available in the read-only "../input/" directory
# For example, running this (by clicking run or pressing Shift+Enter) will list all files under the input directory

import os
for dirname, _, filenames in os.walk('/kaggle/input'):
    for filename in filenames:
        print(os.path.join(dirname, filename))

# You can write up to 20GB to the current directory (/kaggle/working/) that gets preserved as output when you create a version using "Save & Run All" 
# You can also write temporary files to /kaggle/temp/, but they won't be saved outside of the current session

df = pd.read_csv('stock_data_july_2025.csv')
df.head()
df.tail()
df.info()
df.describe()
df.isnull().sum()
df.duplicated().sum()
df.shape
df.dtypes
df.columns


plt.figure(figsize=(14, 6))
for ticker in df['Ticker'].unique():
    ticker_data = df[df['Ticker'] == ticker]
    plt.plot(ticker_data['Date'], ticker_data['Close Price'], label=ticker)
plt.title("Closing Price Trends – August 2025")
plt.xlabel("Date")
plt.ylabel("Close Price")
plt.legend()
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()


sector_volume = df.groupby("Sector")["Volume Traded"].mean().sort_values()
sector_volume.plot(kind="barh", color="skyblue", edgecolor="black")
plt.title("Average Daily Trading Volume by Sector")
plt.xlabel("Average Volume Traded")
plt.ylabel("Sector")
plt.tight_layout()
plt.show()

plt.figure(figsize=(12, 6))
sns.boxplot(data=df, x="Sector", y="PE Ratio", palette="coolwarm")
plt.title("PE Ratio Distribution by Sector – August 2025")
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()

plt.figure(figsize=(10, 6))
sns.scatterplot(
    data=df,
    x="Market Cap",
    y="PE Ratio",
    size="EPS",
    hue="Sector",
    alpha=0.7,
    sizes=(50, 400)
)
plt.title("Market Cap vs PE Ratio (Bubble Size = EPS)")
plt.xlabel("Market Cap")
plt.ylabel("PE Ratio")
plt.tight_layout()
plt.show()

plt.figure(figsize=(10, 6))
numeric_cols = ["Open Price", "Close Price", "High Price", "Low Price", 
                "Volume Traded", "Market Cap", "PE Ratio", 
                "Dividend Yield", "EPS", "52 Week High", "52 Week Low"]
corr = df[numeric_cols].corr()
sns.heatmap(corr, annot=True, fmt=".2f", cmap="Blues")
plt.title("Correlation Matrix – Stock Market Data (Aug 2025)")
plt.tight_layout()
plt.show()

from sklearn.preprocessing import LabelEncoder, StandardScaler
from sklearn.model_selection import train_test_split, cross_val_score, StratifiedKFold
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix, precision_score, recall_score, f1_score
from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.svm import SVC
try:
    from xgboost import XGBClassifier
    xgb_available = True
except Exception:
    xgb_available = False

    # Ensure Date is datetime
df['Date'] = pd.to_datetime(df['Date'], errors='coerce')
df = df.dropna(subset=['Date'])
df['day'] = df['Date'].dt.day
df['weekday'] = df['Date'].dt.weekday
df['is_month_start'] = df['Date'].dt.is_month_start.astype(int)


expected_cols = ['Date', 'Ticker', 'Open Price', 'Close Price', 'High Price',
                 'Low Price', 'Volume Traded', 'Market Cap', 'PE Ratio',
                 'Dividend Yield', 'EPS', '52 Week High', '52 Week Low', 'Sector']
missing = [c for c in expected_cols if c not in df.columns]
if missing:
    raise ValueError(f"Missing columns: {missing}")
df = df.sort_values(['Ticker', 'Date']).reset_index(drop=True)
df['prev_close'] = df.groupby('Ticker')['Close Price'].shift(1)
df['prev_volume'] = df.groupby('Ticker')['Volume Traded'].shift(1)
df['ma_3'] = df.groupby('Ticker')['Close Price'].transform(lambda x: x.rolling(window=3, min_periods=1).mean())
df['daily_return'] = (df['Close Price'] - df['Open Price']) / df['Open Price']
df['range_pct'] = (df['High Price'] - df['Low Price']) / df['Low Price'].replace(0, np.nan)
df['day'] = df['Date'].dt.day
df['weekday'] = df['Date'].dt.weekday
df['is_month_start'] = df['Date'].dt.is_month_start.astype(int)
df['Target'] = (df['Close Price'] > df['prev_close']).astype(int)
df = df.dropna(subset=['prev_close']).reset_index(drop=True)

feature_cols = [
    'Open Price', 'High Price', 'Low Price', 'Close Price', 'Volume Traded',
    'Market Cap', 'PE Ratio', 'Dividend Yield', 'EPS', '52 Week High', '52 Week Low',
    'prev_close', 'prev_volume', 'ma_3', 'daily_return', 'range_pct',
    'day', 'weekday', 'is_month_start',
    'Ticker', 'Sector'
]

X = df[feature_cols].copy()
y = df['Target'].copy()
numeric_cols = X.select_dtypes(include=[np.number]).columns.tolist()
X[numeric_cols] = X[numeric_cols].fillna(X[numeric_cols].median())
le_ticker = LabelEncoder()
le_sector = LabelEncoder()
X['Ticker'] = le_ticker.fit_transform(X['Ticker'])
X['Sector'] = le_sector.fit_transform(X['Sector'].astype(str))
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42, stratify=y
)

scaler = StandardScaler()
X_train_scaled = pd.DataFrame(scaler.fit_transform(X_train), columns=X_train.columns, index=X_train.index)
X_test_scaled = pd.DataFrame(scaler.transform(X_test), columns=X_test.columns, index=X_test.index)

models = {
    "LogisticRegression": LogisticRegression(max_iter=1000, random_state=42),
    "DecisionTree": DecisionTreeClassifier(random_state=42),
    "RandomForest": RandomForestClassifier(n_estimators=200, random_state=42),
    "GradientBoosting": GradientBoostingClassifier(n_estimators=200, random_state=42),
    "KNN": KNeighborsClassifier(n_neighbors=5),
    "NaiveBayes": GaussianNB(),
    "SVM": SVC(probability=True, random_state=42)
}
if xgb_available:
    models["XGBoost"] = XGBClassifier(use_label_encoder=False, eval_metric='logloss', random_state=42)
results = []
for name, model in models.items():
    model.fit(X_train_scaled, y_train)
    y_pred = model.predict(X_test_scaled)
    acc = accuracy_score(y_test, y_pred)
    prec = precision_score(y_test, y_pred, zero_division=0)
    rec = recall_score(y_test, y_pred, zero_division=0)
    f1 = f1_score(y_test, y_pred, zero_division=0)
    cv_scores = cross_val_score(model, X_train_scaled, y_train, cv=StratifiedKFold(n_splits=5, shuffle=True, random_state=42), scoring='accuracy')
    results.append({
        'model': name,
        'accuracy': acc,
        'precision': prec,
        'recall': rec,
        'f1': f1,
        'cv_mean_acc': cv_scores.mean()
    })
    print(f"\n=== {name} ===")
    print(f"Test Accuracy: {acc*100:.2f}%")
    print(f"Precision: {prec*100:.2f}% | Recall: {rec*100:.2f}% | F1: {f1*100:.2f}%")
    print(f"5-fold CV Accuracy (train): {cv_scores.mean()*100:.2f}% (+/- {cv_scores.std()*100:.2f}%)")
    print("\nClassification report (test):")
    print(classification_report(y_test, y_pred, digits=4))
    # Confusion matrix
    cm = confusion_matrix(y_test, y_pred)
    plt.figure(figsize=(5,4))
    sns.heatmap(cm, annot=True, fmt='d', cmap='Blues')
    plt.title(f'Confusion Matrix - {name}')
    plt.xlabel('Predicted')
    plt.ylabel('Actual')
    plt.show()
res_df = pd.DataFrame(results).sort_values('accuracy', ascending=False)
res_df_display = res_df.copy()
for col in ['accuracy', 'precision', 'recall', 'f1', 'cv_mean_acc']:
    res_df_display[col] = (res_df_display[col] * 100).round(2).astype(str) + '%'
print("\nModel comparison (test metrics):")
print(res_df_display[['model','accuracy','precision','recall','f1','cv_mean_acc']])
for tree_model_name in ['RandomForest', 'GradientBoosting', 'DecisionTree']:
    if tree_model_name in models:
        m = models[tree_model_name]
        if hasattr(m, 'feature_importances_'):
            fi = pd.Series(m.feature_importances_, index=X_train.columns).sort_values(ascending=False).head(20)
            plt.figure(figsize=(8,6))
            sns.barplot(x=fi.values, y=fi.index)
            plt.title(f'Feature importances - {tree_model_name}')
            plt.xlabel('Importance')
            plt.tight_layout()
            plt.show()