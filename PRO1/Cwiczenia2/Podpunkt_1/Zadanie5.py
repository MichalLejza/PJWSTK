from matplotlib import pyplot as plt

"""
Dla wyników klasykacji podanych w tablicy
niżej sporządzić wykres ROC (zbiór punktów o współrzśdnych (FP-rate, TP-rate)) 
dla następujących punktów cięcia: 1.0, 0.9, 0.8, 0.7, 0.6
Porównać jakość listy rankongowej niżej podanej
z listą podaną w zadaniu 4.

Id      Score          Yes  No
1-10    [0.97-0.90]     8   2
11-20   [0.86-0.82]     7   3
21-30   [0.79-0.78]     6   4
31-40   [0.73-0.70]     3   7
41-50   [0.65-0.60]     1   9

Id      Score          Yes  No
1-10    [0.97-0.90]     7   3
11-20   [0.86-0.82]     6   5
21-30   [0.79-0.78]     5   5
31-40   [0.73-0.70]     4   6
41-50   [0.65-0.60]     3   6
"""
# Punkty cięcia
cut_points = [1.0, 0.9, 0.8, 0.7, 0.6]

table1 = {
    'id_range': ['1-10', '11-20', '21-30', '31-40', '41-50'],
    'score_range': [0.97, 0.86, 0.79, 0.73, 0.65],  # Używamy najwyższych wartości z zakresów
    'yes': [8, 7, 6, 3, 1],
    'no': [2, 3, 4, 7, 9]
}

table2 = {
    'id_range': ['1-10', '11-20', '21-30', '31-40', '41-50'],
    'score_range': [0.97, 0.86, 0.79, 0.73, 0.65],  # Używamy najwyższych wartości z zakresów
    'yes': [7, 6, 5, 4, 3],
    'no': [3, 5, 5, 6, 6]
}

# pierwsza Tabela
table1_yes = sum(table1['yes'])
table1_no = sum(table1['no'])

table1_tpr = []
table1_fpr = []

for cut in cut_points:
    # Obliczamy liczbę True Positives (TP) i False Positives (FP)
    tp = sum(table1['yes'][i] for i in range(len(table1['yes'])) if table1['score_range'][i] >= cut)
    fp = sum(table1['no'][i] for i in range(len(table1['no'])) if table1['score_range'][i] >= cut)

    # Obliczamy TPR i FPR
    tpr = tp / table1_yes
    fpr = fp / table1_no

    table1_tpr.append(tpr)
    table1_fpr.append(fpr)

# druga tabela
table2_yes = sum(table2['yes'])
table2_no = sum(table2['no'])

table2_tpr = []
table2_fpr = []

for cut in cut_points:
    tp = sum(table2['yes'][i] for i in range(len(table2['yes'])) if table2['score_range'][i] >= cut)
    fp = sum(table2['no'][i] for i in range(len(table2['no'])) if table2['score_range'][i] >= cut)

    tpr = tp / table2_yes
    fpr = fp / table2_no

    table2_tpr.append(tpr)
    table2_fpr.append(fpr)

plt.figure(figsize=(8, 8))
plt.plot(table1_fpr, table1_tpr, marker='o', linestyle='-', color='b', label='Tabela 1')
for (x, y) in zip(table1_fpr, table1_tpr):
    plt.annotate(f'({x}, {y})', (x, y), textcoords="offset points", xytext=(0, -12), ha='center')

plt.plot(table2_fpr, table2_tpr, marker='o', linestyle='-', color='r', label='Tabela 2')
for (x, y) in zip(table2_fpr, table2_tpr):
    plt.annotate(f'({x}, {y})', (x, y), textcoords="offset points", xytext=(0, -12), ha='center')
plt.title('ROC Curve')
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate (Recall)')
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.0])
plt.legend()
plt.grid(True)
plt.plot([0, 1], [0, 1], linestyle='--', color='red')
plt.show()
