import matplotlib.pyplot as plt

"""
Dla wyników klasykacji podanych w tablicy
niżej sporządzić wykres ROC (zbiór punktów o współrzśdnych (FP-rate, TP-rate)) 
dla następujących punktów cięcia: 1.0, 0.9, 0.8, 0.7, 0.6

Id      Score          Yes  No
1-10    [0.97-0.90]     8   2
11-20   [0.86-0.82]     7   3
21-30   [0.79-0.78]     6   4
31-40   [0.73-0.70]     3   7
41-50   [0.65-0.60]     1   9
"""

# Dane: id, score, liczba "Yes", liczba "No"
data = {
    'id_range': ['1-10', '11-20', '21-30', '31-40', '41-50'],
    'score_range': [0.97, 0.86, 0.79, 0.73, 0.65],  # Używamy najwyższych wartości z zakresów
    'yes': [8, 7, 6, 3, 1],
    'no': [2, 3, 4, 7, 9]
}

# Suma wszystkich "Yes" i "No"
total_yes = sum(data['yes'])
total_no = sum(data['no'])

# Punkty cięcia
cut_points = [1.0, 0.9, 0.8, 0.7, 0.6]
tpr_values = []
fpr_values = []

# Oblicz TPR i FPR dla każdego punktu cięcia
for cut in cut_points:
    # Obliczamy liczbę True Positives (TP) i False Positives (FP)
    tp = sum(data['yes'][i] for i in range(len(data['yes'])) if data['score_range'][i] >= cut)
    fp = sum(data['no'][i] for i in range(len(data['no'])) if data['score_range'][i] >= cut)

    # Obliczamy TPR i FPR
    tpr = tp / total_yes
    fpr = fp / total_no

    tpr_values.append(tpr)
    fpr_values.append(fpr)

# Tworzymy wykres krzywej ROC
plt.figure(figsize=(8, 8))
plt.plot(fpr_values, tpr_values, marker='o', linestyle='-', color='b', label='Tabela 1')
for (x, y) in zip(fpr_values, tpr_values):
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
