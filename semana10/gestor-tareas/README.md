# Gestor de Tareas - Spring Boot + Vaadin + Persistencia

## Descripcion

Aplicacion web completa con Vaadin frontend, Spring Boot backend, servicio de negocio inyectado y persistencia JSON en tareas.json.

## Como ejecutar

mvn spring-boot:run
# Abrir http://localhost:8080

## Empaquetar

mvn clean package
java -jar target/gestor-tareas-0.0.1-SNAPSHOT.jar

## Persistencia

Los datos se guardan en tareas.json (directorio de ejecucion).
Las tareas sobreviven a reinicios del servidor.

## Estructura

- TareaService -- logica de negocio + persistencia JSON
- TareasView -- Grid con CRUD
- TareaDetalleView -- detalle por ID
- TareaEditable -- clase mutable para el Binder
- MainLayout -- AppLayout con menu lateral

## Que se aprendio

- @Service: capa de negocio gestionada por Spring
- Inyeccion por constructor: Spring pasa el servicio a las vistas
- Gson: serializacion/deserializacion de List<Tarea> a JSON
- Persistencia: archivo tareas.json en el directorio de ejecucion
- vaadin.productionMode=true: frontend optimizado
- JAR ejecutable con Spring Boot embebido
