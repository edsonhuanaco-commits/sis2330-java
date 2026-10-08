# Sistema de Estudiantes (Maven + JUnit)

## Descripcion

Sistema de estudiantes construido con Maven, con ranking por promedio y suite de pruebas JUnit 5.

## Como ejecutar

mvn compile         # compila src/main/java a target/classes
mvn test            # corre la suite de tests de JUnit
mvn clean package   # compila, testea y genera el .jar en target/
java -jar target/sistema-estudiantes-1.0.0.jar   # ejecuta el .jar

## Tests incluidos

- registrarEstudianteNuevoDevuelveTrue
- registrarCodigoDuplicadoDevuelveFalse
- buscarPorCodigoExistenteDevuelveEstudiante
- buscarPorCodigoInexistenteDevuelveNull
- actualizarPromedioDeEstudianteExistenteDevuelveTrue
- actualizarPromedioDeEstudianteInexistenteDevuelveFalse
- eliminarEstudianteExistenteDevuelveTrueYLoQuitaDelRanking
- listarRankingConColeccionVaciaDevuelveListaVacia
- listarRankingOrdenaPorPromedioDescendente
- topNConNMayorAlTotalDevuelveTodosSinLanzarExcepcion
- promedioFueraDeRangoLanzaExcepcion
- codigoVacioLanzaExcepcion

## Resultado

Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

## Que se aprendio

- Maven: pom.xml, dependencias, ciclo de vida (compile, test, package)
- JUnit 5: @Test, @BeforeEach, aserciones (assertEquals, assertTrue, assertThrows)
- Estructura estandar Maven: src/main/java vs src/test/java
- Scopes: compile (defecto) vs test
- Dependencias transitivas: Maven descarga JUnit + sus dependencias automaticamente
