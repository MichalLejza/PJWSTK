# Zadanie 1
# Załóżmy, że jest 10 produktów, ponumerowane od 1 do 100, i 100
# koszyków, również ponumerowanych 1 to 100. Produkt i należy do koszyka b
# wtedy i tylko wtedy i jest dzielnikiem b. Na przykład produkt o numerze 1
# należy do wszystkich koszyków, produkt o numerze 2 należy do 50 koszyków
# parzystych. Koszyk o numerze 12 zawiera produkty {1, 2, 3, 4, 6, 12}. Zakładamy,
# że min_sup = 5. Wyznaczyć:
# a) Które produkty są częste?
# b) Które pary produktów są częste?
# c) Stopień wsparcia i wiarygodności reguł:
# {5, 7} → 2
# {2, 3, 4} → 5



# Zadanie 2
# Wykazać następujące własności zbiorów częstych (ang. frequent itemsets),
# a) Jeśli A ⊆ B to support(B) ≤ support(A).
# b) Każdy podzbiór zbioru częstego jest częsty.
# c) Każdy nadzbiór zbioru nieczęstego jest nieczęsty.
# d) Niech B będzie zbiorem częstym. Niech A1 ⊆ B, A2 ⊆ B i A1 ⊆ A2. Wówczas
# conf(A1 → B \ A1) ≤ conf(A2 → B \ A2)


# Zadanie 3
# Zakłada się, że w bazie transakcyjnej jest n = 1000000 rekordów (transakcji). Liczba produktów jest k = 1000.
# a) Jaka jest maksymalna liczba zbiorów częstych dwu-elementowych?
# b) Jaka jest maksymalna liczba reguł asocjacyjnych dwu-elementowych?
# c) Jaka jest liczba przeglądań bazy danych, żeby znaleźć zbiory częste dwuelementowe?
# d) Jaka jest liczba przeglądań bazy danych, żeby znaleźć wiarygodne reguły dwu-elementowe?

transactions = {
    1: {'A', 'B', 'C', 'D'},
    2: {'B', 'E'},
    3: {'A', 'B', 'C', 'D', 'E'},
    4: {'C', 'D', 'E'},
    5: {'A', 'B', 'D', 'E'},
}


# Zadanie 4
# Rozpatrzmy zbiór transakcji 1
# a) Ile produktów (items) i ile transakcji (records) jest w tym zbiorze?
# b) Skorzystaj¡c z algorytmu Apriori wyznacz wszystkie reguły asocjacyjne z parametrami min_sup = 0.6, min_conf = 0.8.
# c) Dla produktu a znaleźć wszyskie produkty, które występują razem z a w więcej niż 60% transakcjach.
# d) Dla produktu a znaleźć wszyskie reguªy asocjacyjne postaci a → X i X → a
#   (X jest dowolnym zbiorem zbioru produktów) z wsparciem min_sup = 0.6 oraz wiarygodno±ci¡ min_conf = 0.8,

min_sip = 0.6
min_vonf = 0.8
D = len(transactions.keys())



# Zadanie 5.
# Rozpatrzmy zbiór transakcji 2.
# a) Generowa¢ zbiory cz¦ste z parametem min_sup = 0.6.
# b) Ile sprawdza« wykonuje algorytm Apriori? Ile algorytm siªowy (brutteforce)?
# c) Wynaczy¢ wszystkie reguªy asocjacyjne typu: a ∧ b → c z parametrem min_conf = 0.8.
# d) Wynaczy¢ wszystkie reguªy asocjacyjne z parametem min_sup = 0.6, min_conf = 0.8.


# Zadanie 6.
# Oto najpopularniejsze miary oceny reguł asocjacyjnych:
#  Condence: conf(A → B) = P(B|A) = S(A∪B)
# S(A)
#  Lift: lif t(A → B) = conf(A→B)
# S(B)
#  conviction(A → B) = 1−sup(B)
# 1−conf(A→B)
