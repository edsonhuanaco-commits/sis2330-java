# estadisticas-hs

Proyecto Haskell con Stack: procesa listas de estudiantes con recursion, comprensiones de lista y funciones de orden superior.

## Modulos

- `src/Estadisticas.hs` -- funciones puras (promedio, masAlto, ordenarPorNota, aprobados)
- `app/Main.hs` -- IO: lee N estudiantes y muestra el reporte

## Como correr

    stack build     # compila (GHC ya instalado de semana 11)
    stack run       # ejecuta el reporte interactivo
    stack ghci      # REPL para probar funciones puras

## Ejemplo de uso

    Cuantos estudiantes vas a ingresar?
    3
    Nombre: Ana
    Nota: 90
    Nombre: Luis
    Nota: 45
    Nombre: Marta
    Nota: 70

    Promedio del grupo: 68.33333333333333
    Mas alto: ("Ana",90.0)
    Ordenados por nota: [("Ana",90.0),("Marta",70.0),("Luis",45.0)]
    Aprobados: [("Ana",90.0),("Marta",70.0)]

## Que se aprendio

- Listas: `(:)` cons, `(++)` concatenar, `map`, `filter`, `foldr`
- Comprensiones de lista: `[expr | gen, cond]`
- Tuplas: `(String, Double)`, `fst`, `snd`
- Recursion con caso base + caso recursivo
- Pattern matching avanzado: guards (`| otherwise`)
- Funciones de orden superior: `map`, `filter`, `sortBy`, `comparing`
- `Control.Monad.replicateM` para IO repetido
- Funciones puras (sin IO) vs `Main.hs` (con IO)
