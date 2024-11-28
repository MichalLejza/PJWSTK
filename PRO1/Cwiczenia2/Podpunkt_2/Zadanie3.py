import pandas as pd
import matplotlib.pyplot as plt

"""
Zadanie 3: (Wizualizacja)
Zadanie: Wyświetlić lokalizację geograczną nieruchomości z zaznaczeniem,
które się znajdują się blisko morza. Wskazówka: Stworzyć wykres punkowy, 
osiami są latitude i longitute, kolor
według ocean-proximity.
"""

path = "/Users/michallejza/PycharmProjects/PRO/Data/Housing.csv"
df = pd.read_csv(path)

longitude = df['longitude']
latitude = df['latitude']
ocean_proximity = df['ocean_proximity']

color_map = {
    '<1H OCEAN': 'green',
    'INLAND': 'blue',
    'NEAR OCEAN': 'red',
    'ISLAND': 'orange',
    'NEAR BAY': 'yellow'
}

colors = [color_map[proximity] for proximity in ocean_proximity]

plt.scatter(longitude, latitude, color=colors, marker='o', alpha=0.5, s=10)

# Dodanie tytułu i etykiet osi
plt.title('Ocean Proximity Scatter Chart')
plt.xlabel('Longitude')
plt.ylabel('Latitude')

handles = [plt.Line2D([0], [0], marker='o', color='w', markerfacecolor=color, markersize=8) for color in color_map.values()]  # Ustawienie rozmiaru legendy
plt.legend(handles, color_map.keys(), title='Ocean Proximity', loc='upper right', frameon=False, fontsize='medium', title_fontsize='large')
# Wyświetlenie wykresu
plt.grid(True)  # Opcjonalnie dodanie siatki
plt.show()
