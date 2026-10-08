# Gestor de Tareas (Vaadin)

## Descripcion

Aplicacion web Vaadin que permite agregar tareas a una lista en memoria y verlas como texto plano.

## Como ejecutar

mvn spring-boot:run
# Abrir http://localhost:8080

## Estructura

- com.tareas.Application -- punto de entrada @SpringBootApplication
- com.tareas.Tarea -- record con id, descripcion, completada
- com.tareas.views.TareasView -- vista principal @Route("")

## Nota

Las tareas se pierden al reiniciar la aplicacion (almacenamiento en memoria).

## Que se aprendio

- Vaadin: framework Java para UI web sin HTML/CSS/JS
- @Route(""): mapea la clase a la URL raiz
- Componentes: TextField, Button, Div, Paragraph, Notification
- Layouts: VerticalLayout, HorizontalLayout
- Eventos: addClickListener con lambda
- Spring Boot: arranca el servidor embebido (Tomcat) en el puerto 8080
