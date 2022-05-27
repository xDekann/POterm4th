# POterm4th
Repository created for keeping projects/algorithms created for univeristy classes (4th term)
Zdefiniuj własną, sparametryzowaną klasę Stosu z wykorzystaniem klasy LinkedList.

Zadanie 1
Klasa ma definiować podstawowe operacje stosu:
-dodanie nowej wartości,
-zdjęcie wartości ze stosu
-zwrot liczby elementów stosu
-podglądnięcie (bez zdjęcia) wartości ze szczytu stosu
-metodę toString, wyświetlającą zawartość stosu.
Nie zapomnij zabezpieczyć stosu przed błędami (np. próba pobrania wartości z pustego stosu, itp.).

Zadanie 2
Zdefiniuj klasę Set<T>, której zadaniem będzie przechowywać posortowany zbiór obiektów (nie zawierający duplikatów). 
Do porównywania obiektów w Javie służy metoda compareTo. Jest to osobna metoda zdefiniowana w interfejsie Comparable. 
O typie T zakładamy, że implementuje interface systemowy Comparable<T>. 
Na potrzeby zadania, zdefiniuj dwie dowolne klasy (proste) implementujące interfejs Comparable. W testach, dodawaj do zbioru, obiekty swojej klasy. (2 pkt)

Klasa posiada następujące pola prywatne:

-T [] set - tablica, w której przechowywane będą obiekty

-int pojemnosc - maksymalna liczba elementów, możliwych do przechowywania

-int rozmiar - aktualna liczba przechowywanych elementów

Implementacja klasy Set powinna mieć również następujące metody:

-Konstruktor z parametrem określającym pojemność, który przydziela pamięć dla tablicy obiektów oraz ustala wartości pozostałych pól klasy. (1 pkt)
  
-dodajElement - metoda, która przyjmuje dokładnie jeden element, który zostanie dodany do zbioru w przypadku, gdy nie występuje już w zbiorze. W przypadku gdy zbiór jest już pełny powinien zostać rzucony wyjątek, obsłużony poza metodą (w miejscu wywołania metody dodajElement). Nowo dodane obiekty powinny być zapisane na odpowiednim miejscu tablicy (zbiór ma być posortowany). (1 pkt)
  
-szukaj - metoda, wywoływana z jednym parametrem, określającym szukany obiekt, natomiast wynikiem pozycja podanego obiektu w tablicy (licząc od 0) lub -1, gdy obiekt nie występuje w zbiorze (zamiast zwracać wartość -1, można rzucić wyjątkiem). (1 pkt)
  
-metodę toString, która wypisuje informacje o zbiorze, w tym jego rozmiar, pojemność oraz listę przechowywanych elementów. (1 pkt)
  
-Metodę ,,usunElement'', która usuwa podany jako parametr element, jeżeli znajduje się on w zbiorze. (1 pkt) 
  
-Metodę ,,dodajElementy'', która dodaje elementy dwóch zbiorów, tworząc nowy zbiór składający się z elementów z obu zbiorów.  (1 pkt)
  
-Metodę ,,OdejmijElementy'', która odejmuje elementy z pierwszego zbioru, występujące w zbiorze drugim.  (1 pkt)
  
-Metodę ,,przecięcie'', która będzie tworzyć zbiór składający się z liczb, które występują w obu zbiorach. (1 pkt) 
