# empleados-api

API REST de empleados construida con Spring Boot + JPA + H2, organizada con Clean Architecture (Domain, Application, Infrastructure, Presentation).

## Diagrama de capas

    +----------------+
    | Presentation   |  Controllers, DTOs
    +-------+--------+
            | usa
    +-------v--------+
    | Application    |  EmployeeService
    +-------+--------+
            | usa
    +-------v--------+
    | Domain         |  Employee, Salary, EmployeeRepository (interfaz)
    +-------+--------+
            | implementa
    +-------v--------+
    | Infrastructure |  JPA, H2, adapter
    +----------------+

Regla de oro: las dependencias solo apuntan hacia adentro. El dominio NO importa JPA, Spring ni nada externo.

## Por que el dominio no puede importar JPA

El dominio debe ser testeable sin frameworks. Si `Employee` tuviera `@Entity`, no podriamos probarlo sin arrancar Spring. Al mantener el dominio puro y usar un adapter en Infrastructure, el negocio se prueba con un simple `new Employee(...)`.

## Endpoints

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET | /api/empleados | Lista todos |
| GET | /api/empleados/{id} | Obtiene uno por id |
| POST | /api/empleados | Crea un empleado |

## Como compilar y correr los tests

    mvn clean test

## Como ejecutar la API

    mvn spring-boot:run
    # Abrir http://localhost:8080/api/empleados

## Que se aprendio

- Clean Architecture: dependencias apuntan hacia adentro
- Domain puro (Employee, Salary) sin JPA ni Spring
- Repository interface en domain, adapter JPA en infrastructure
- DTOs (Request/Response) separados del modelo de dominio
- Application Service orquesta (no contiene logica de negocio)
- Inyeccion de dependencias por constructor
- Tests unitarios de dominio (sin Spring) y service (con repository fake)
