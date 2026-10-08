# Sistema de Estudiantes Avanzado

## Descripcion

Sistema de consola que registra estudiantes y mantiene un ranking automatico por promedio.

## Por que estas estructuras

- **HashMap<String, Estudiante>**: busqueda O(1) por codigo.
- **TreeSet<Estudiante>**: ranking siempre ordenado, sin volver a ordenar manualmente en cada consulta.
- **topN devuelve ArrayList**: nunca se expone el TreeSet interno, evita que el llamador lo modifique.

## Como ejecutar

cd src
javac modelo/Estudiante.java servicio/SistemaEstudiantes.java Principal.java
java Principal

## Ejemplo de salida

1. Registrar 2. Buscar 3. Actualizar 4. Ranking 5. Top N 6. Salir
Opcion: 4
#A01 Ana (95.00)
#A03 Marta (92.00)
#A02 Luis (88.00)

## Que se aprendio

- Java Collections Framework: interfaces vs implementaciones
- ArrayList vs LinkedList: acceso por indice vs extremos
- HashSet vs TreeSet: sin orden O(1) vs ordenado O(log n)
- HashMap vs TreeMap: sin orden O(1) vs ordenado O(log n)
- Comparable (orden natural) vs Comparator (orden externo)
- equals/hashCode: siempre juntos, mismos campos
- Iterator: recorrer y modificar sin ConcurrentModificationException
