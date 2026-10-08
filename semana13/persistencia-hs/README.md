# persistencia-hs

Proyecto Haskell con Stack: persistencia de estudiantes en archivo CSV, con manejo seguro de errores usando Either String Estudiante.

## Formato del archivo estudiantes.csv

Una linea por estudiante, con formato `nombre,nota`:

    Ana,90.0
    Luis,45.0
    Marta,70.0

Las lineas mal formadas se reportan por consola como avisos, pero no detienen la carga del resto.

## Manejo de errores con Either

`parsearLinea :: String -> Either String Estudiante` es pura:

- `Right (nombre, nota)` si la linea esta bien formada
- `Left "mensaje de error"` si falta la coma, el nombre esta vacio, o la nota no es numero

Esto significa que las lineas invalidas **son datos**, no excepciones: el programa nunca crashea por un CSV mal formado.

## Modulos

- `src/Modelo.hs` -- tipo Estudiante y funciones puras (promedio, aprobados)
- `src/Persistencia.hs` -- cargar/guardar CSV + parsearLinea pura
- `app/Main.hs` -- IO: carga, agrega, guarda

## Como correr

    stack build
    stack run

El archivo `estudiantes.csv` se guarda en el directorio actual. La segunda ejecucion carga los estudiantes previos.

## Que se aprendio

- Maybe: computos que pueden fallar (Just / Nothing)
- Either: validacion con mensaje de error (Left / Right)
- Encadenamiento con `>>=` y con `do`-notation
- Monad: patron comun de Maybe, Either e IO
- IO de archivos: `readFile`, `writeFile`, `appendFile`
- `doesFileExist` para el primer arranque sin archivo
- Lazy IO y sus precauciones
