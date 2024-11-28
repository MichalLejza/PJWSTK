import pandas as pd

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

# wstępne analizy
print("Wstepna analiza: ")
print("Liczba rekordów: ", df.shape[0])
print("Liczba kolumn: ", df.shape[1], end='\n\n')
print("Typy atrybutów:\n", df.dtypes, end="\n\n")
print("Liczba wartości Null w każdej kolumnie:\n", df.isnull().sum())

df.drop(columns='ocean_proximity', inplace=True)

outliers = pd.DataFrame()
for column in df.columns:
    Q1 = df[column].quantile(0.25)
    Q3 = df[column].quantile(0.75)
    IQR = Q3 - Q1
    lower_bound = Q1 - 1.5 * IQR
    upper_bound = Q3 + 1.5 * IQR
    outliers = df[(df[column] < lower_bound) | (df[column] > upper_bound)]

print("Liczba wartości odstających: ", outliers.shape[0], end='\n\n')

print("Wartości najmniejsze: \n", df.min())
print("Wartości największe: \n", df.max())
