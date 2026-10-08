import modelo.Estudiante;
import servicio.SistemaEstudiantes;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        SistemaEstudiantes sistema = new SistemaEstudiantes();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n1. Registrar 2. Buscar 3. Actualizar 4. Ranking 5. Top N 6. Salir");
            System.out.print("Opcion: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Codigo: ");
                    String cod = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Promedio (0-100): ");
                    try {
                        double prom = Double.parseDouble(sc.nextLine());
                        boolean ok = sistema.registrar(new Estudiante(cod, nom, prom));
                        System.out.println(ok ? "Registrado" : "Codigo duplicado");
                    } catch (NumberFormatException ex) {
                        System.out.println("Promedio invalido.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Codigo a buscar: ");
                    Estudiante e = sistema.buscarPorCodigo(sc.nextLine());
                    System.out.println(e != null ? e : "No encontrado");
                }
                case 3 -> {
                    System.out.print("Codigo: ");
                    String c2 = sc.nextLine();
                    System.out.print("Nuevo promedio: ");
                    try {
                        double np = Double.parseDouble(sc.nextLine());
                        System.out.println(
                            sistema.actualizarPromedio(c2, np) ? "OK" : "No encontrado");
                    } catch (NumberFormatException ex) {
                        System.out.println("Promedio invalido.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
                case 4 -> {
                    var ranking = sistema.listarRanking();
                    if (ranking.isEmpty()) {
                        System.out.println("Sin estudiantes registrados.");
                    } else {
                        for (Estudiante r : ranking) System.out.println(r);
                    }
                }
                case 5 -> {
                    System.out.print("N: ");
                    try {
                        int n = Integer.parseInt(sc.nextLine());
                        var top = sistema.topN(n);
                        if (top.isEmpty()) {
                            System.out.println("No hay estudiantes.");
                        } else {
                            for (Estudiante e : top) System.out.println(e);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("N invalido.");
                    }
                }
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
