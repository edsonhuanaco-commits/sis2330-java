# Gestor de Tareas P00

## Descripcion

Gestor de Tareas: clase Tarea encapsulada con IDs autoincrementales, CRUD por consola usando ArrayList<Tarea>, organizado en paquetes modelo/ y app/.

## Como se ejecuta

cd src
javac modelo/Tarea.java app/GestorTareas.java
java app.GestorTareas

## Que se aprendio

1. POO vs procedural: POO agrupa datos y comportamiento en clases.
2. Clase vs objeto: clase = plantilla; objeto = instancia concreta en memoria.
3. Constructores: inicializan el objeto al crearlo. Si defines uno, Java ya no crea el por defecto.
4. Encapsulacion: atributos private, acceso mediante getters/setters. Valida en el setter.
5. this: referencia al objeto actual. Obligatorio cuando parametro y atributo comparten nombre.
6. ArrayList: array dinamico con O(1) acceso por indice y O(1) amortizado al agregar al final.
