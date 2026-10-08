# calculadora-hs

Proyecto Haskell con Stack: funciones puras y programa IO.

## Como correr

    stack build     # compila (descarga GHC la primera vez)
    stack run       # ejecuta app/Main.hs
    stack ghci      # REPL interactivo con los modulos cargados
    stack test      # corre los tests

## Modulos

- `src/Lib.hs` -- funciones puras (suma, doble, promedio)
- `app/Main.hs` -- IO: lee dos numeros y muestra la suma
- `test/Spec.hs` -- tests automatizados

## Que hace

Pide dos numeros enteros por consola, los suma y muestra el resultado.

## Que se aprendio

- Stack: gestor de proyectos (equivalente a Maven)
- Tipos basicos: Int, Integer, Double, Bool, Char, String
- Funciones puras vs IO
- `do`-notation para secuenciar acciones IO
- `read` / `show` para convertir entre texto y valores
- `stack ghci` para probar funciones interactivamente
