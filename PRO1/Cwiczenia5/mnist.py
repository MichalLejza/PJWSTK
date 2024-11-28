import os

import matplotlib.pyplot as plt
from sklearn.decomposition import PCA
from sklearn.manifold import TSNE
from sklearn.metrics import silhouette_score

from Cwiczenia4.mnist import DataHandler

data_dir = '/Users/michallejza/Desktop/Data/MNIST/classic'
train_images_path = os.path.join(data_dir, 'train-images')
train_labels_path = os.path.join(data_dir, 'train-labels')

train_data = DataHandler(train_images_path, train_labels_path)

train_images = train_data.images[:3000]
train_labels = train_data.labels[:3000]

# Step 3: Initialize variables to store best silhouette score and perplexity
best_score = -1
best_perplexity = 5
best_X_tsne = None

# Step 4: Loop over a range of perplexities to find the best one
perplexities = [5, 10, 20, 30, 40, 50]  # Example set of perplexities

for perplexity in perplexities:
    # Step 5: Apply t-SNE with the current perplexity
    tsne = TSNE(n_components=2, random_state=42, perplexity=perplexity)
    X_tsne = tsne.fit_transform(train_images)

    # Step 6: Calculate silhouette score for the current t-SNE output
    score = silhouette_score(X_tsne, train_labels)
    # Step 7: If this is the best score so far, update the best silhouette score and the corresponding t-SNE result
    if score > best_score:
        best_score = score
        best_perplexity = perplexity
        best_X_tsne = X_tsne

# Step 8: Visualize the best t-SNE result
plt.figure(figsize=(10, 7))
scatter = plt.scatter(best_X_tsne[:, 0], best_X_tsne[:, 1], c=train_labels, cmap='tab10', alpha=0.7, s=10)
plt.colorbar(scatter, label='Digit Label')
plt.title(
    f"t-SNE Visualization of the First 1000 MNIST Images (2D)\nBest Perplexity: {best_perplexity}, Silhouette Score: {best_score:.4f}")
plt.xlabel("t-SNE Dimension 1")
plt.ylabel("t-SNE Dimension 2")

pca = PCA(n_components=2)
train_images_pca = pca.fit_transform(train_images)

# Rysowanie wykresu
plt.figure(figsize=(8, 6))

# Zróbmy scatter plot, gdzie punkty mają różne kolory w zależności od klasy
scatter = plt.scatter(train_images_pca[:, 0], train_images_pca[:, 1], c=train_labels, cmap='viridis', s=10)
plt.colorbar(scatter)  # Pokazuje legendę kolorów dla klas
plt.title('PCA Projection of MNIST Dataset')
plt.xlabel('Principal Component 1')
plt.ylabel('Principal Component 2')
plt.show()
