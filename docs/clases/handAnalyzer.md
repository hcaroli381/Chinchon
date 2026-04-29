## HandAnalyzer

Clase encargada de analizar la mano del jugador. Determina la puntuación, detecta combinaciones (escaleras y grupos), verifica si puede cerrar y calcula el mejor descarte para la IA.

### Funciones

1. **calculateUncombinedCards(List<Card> hand)**

   Responsabilidad: Calcular la puntuación de cartas sin combinar en una mano.

   - Crea una copia de la mano para análisis
   - Busca conjuntos (grupos de 3+ cartas del mismo valor)
   - Busca escaleras (3+ cartas del mismo palo en secuencia)
   - Suma el valor de las cartas restantes (no combinadas)
   - Retorna la puntuación total

2. **findSets(List<Card> auxiliarHand)**

   Responsabilidad: Encontrar y eliminar grupos de 3+ cartas del mismo valor (método privado).

   - Agrupa las cartas por valor en un mapa
   - Para cada grupo con 3+ cartas, las marca como combinadas
   - Elimina de la mano auxiliar los grupos encontrados

3. **findRuns(List<Card> auxiliarHand)**

   Responsabilidad: Encontrar y eliminar escaleras de 3+ cartas del mismo palo secuenciales (método privado).

   - Agrupa las cartas por palo
   - Para cada grupo, ordena por valor  
   - Busca secuencias de 3+ cartas consecutivas
   - Elimina de la mano auxiliar las escaleras encontradas

4. **findChinchon(List<Card> hand)**

   Responsabilidad: Verificar si la mano contiene un Chinchón (escalera de 7 cartas).

   - Verifica si existe una escalera de exactamente 7 cartas del mismo palo
   - Retorna true si se encuentra Chinchón, false en caso contrario

5. **canClose(List<Card> hand)**

   Responsabilidad: Verificar si el jugador puede cerrar la ronda.

   - Calcula cartas sin combinar
   - Retorna true si tiene 0 cartas sin combinar O si la mayor carta sin combinar tiene valor 1-5
   - Retorna false si no puede cerrar

6. **getCombinedCards(List<Card> hand)**

   Responsabilidad: Obtener la lista de cartas que forman combinaciones válidas.

   - Similar a calculateUncombinedCards pero retorna las cartas combinadas
   - Retorna la lista de cartas que están en grupos o escaleras

7. **getBestDiscard(List<Card> hand)**

   Responsabilidad: Determinar la mejor carta para descartar (para la IA).

   - Analiza cada carta de la mano
   - Calcula la puntuación si se descarta cada una
   - Retorna la carta cuyo descarte da la menor puntuación
   - Si hay empate, retorna la de mayor valor
