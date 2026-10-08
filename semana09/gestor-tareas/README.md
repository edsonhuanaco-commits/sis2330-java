# Gestor de Tareas - Navegacion Multi-Vista

## Descripcion

Aplicacion web Vaadin con navegacion entre pantallas: listado con Grid y vista de detalle, envueltas en un layout con menu lateral.

## Como ejecutar

mvn spring-boot:run
# Abrir http://localhost:8080

## Rutas

- / -> Lista de tareas (TareasView)
- /tareas/{id} -> Detalle de una tarea (TareaDetalleView)
- /acerca -> Informacion (AcercaDeView)

## Estructura

- com.tareas.Tarea -- record inmutable (id, descripcion, completada)
- com.tareas.views.MainLayout -- AppLayout con menu lateral
- com.tareas.views.TareasView -- Grid con alta de tareas y enlace al detalle
- com.tareas.views.TareaDetalleView -- detalle por ID (HasUrlParameter<Long>)
- com.tareas.views.AcercaDeView -- vista informativa

## Que se aprendio

- Multiples @Route en la misma app
- RouterLink: navegacion SPA sin recargar
- HasUrlParameter<Long>: recibir parametros de URL (/tareas/{id})
- AppLayout: navbar + drawer (menu lateral)
- Lista estatica compartida entre vistas
- ComponentRenderer: columna del Grid con un RouterLink
