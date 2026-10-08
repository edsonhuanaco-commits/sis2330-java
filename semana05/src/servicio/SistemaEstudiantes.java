package servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import modelo.Estudiante;

public class SistemaEstudiantes {
    private final HashMap<String, Estudiante> porCodigo;
    private final TreeSet<Estudiante> ranking;

    public SistemaEstudiantes() {
        this.porCodigo = new HashMap<>();
        this.ranking = new TreeSet<>();
    }

    public boolean registrar(Estudiante e) {
        if (porCodigo.containsKey(e.getCodigo())) {
            return false; // codigo duplicado
        }
        porCodigo.put(e.getCodigo(), e);
        ranking.add(e);
        return true;
    }

    public Estudiante buscarPorCodigo(String codigo) {
        return porCodigo.get(codigo); // O(1)
    }

    public boolean actualizarPromedio(String codigo, double nuevoPromedio) {
        Estudiante e = porCodigo.get(codigo);
        if (e == null) return false;
        // TreeSet ordena por promedio: hay que sacarlo antes de mutarlo
        ranking.remove(e);
        e.setPromedio(nuevoPromedio);
        ranking.add(e);
        return true;
    }

    public boolean eliminar(String codigo) {
        Estudiante e = porCodigo.remove(codigo);
        if (e == null) return false;
        ranking.remove(e);
        return true;
    }

    public ArrayList<Estudiante> listarRanking() {
        return new ArrayList<>(ranking); // copia: no expone el TreeSet interno
    }

    public ArrayList<Estudiante> topN(int n) {
        ArrayList<Estudiante> top = new ArrayList<>();
        if (n <= 0) return top;
        int i = 0;
        for (Estudiante e : ranking) {
            if (i >= n) break;
            top.add(e);
            i++;
        }
        return top;
    }

    public int getCantidad() {
        return porCodigo.size();
    }
}
