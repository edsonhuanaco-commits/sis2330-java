# testing-hs

Proyecto Haskell con Stack: tests automatizados (HUnit + QuickCheck) y patron State para acumular estado sin variables mutables.

## Modulos

- `src/Notas.hs` -- funciones puras (promedio, masAlto, ordenarPorNota, aprobados, parsearLinea)
- `src/Historial.hs` -- `State (Map String Int)` para contar consultas
- `test/Spec.hs` -- suite HUnit (6 tests) + propiedad QuickCheck
- `app/Main.hs` -- IO: procesa lineas, reporta, simula consultas

## Como correr

    stack build     # compila
    stack test      # corre HUnit + QuickCheck
    stack run       # ejecuta Main.hs

## Que se aprendio

- HUnit: tests de casos concretos (`TestCase`, `assertEqual`, `TestList`)
- QuickCheck: propiedades generales (100 casos generados al azar)
- `stack test` ejecuta la suite `test/Spec.hs`
- State monad: acumular sin variables mutables (`get`, `put`, `modify`, `execState`)
- `Map` con `insertWith` para contar ocurrencias
- Separacion pura/IO: `Notas.hs` y `Historial.hs` son puras, `Main.hs` es IO
- `Maybe` para representar "no hay resultado" (masAlto [])
