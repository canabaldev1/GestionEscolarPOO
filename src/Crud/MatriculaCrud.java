package Crud;

import Dominio.Matricula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class MatriculaCrud {

    public static HashMap<String, Matricula> matriculas = new HashMap<>();

    public static void agregar(Matricula matricula) throws Exception {
        if (matriculas.containsKey(matricula.getId().toString())) {
            throw new Exception("la matricula "+matricula.getId().toString()+" ya existe!");
        }
        matriculas.put(matricula.getId().toString(), matricula);
    }

    public static Matricula buscar(String matricula_id) throws Exception {
        if (!matriculas.containsKey(matricula_id)) {
            throw new Exception("la matricula "+matricula_id+" no existe!");
        }
        return matriculas.get(matricula_id);
    }

    public static void editar(Matricula matricula) throws Exception {
        if (!matriculas.containsKey(matricula.getId().toString())) {
            throw new Exception("la matricula "+matricula.getId().toString()+" no existe!");
        }
        matriculas.put(matricula.getId().toString(), matricula);
    }

    public static void eliminar(String matricula_id) throws Exception {
        if (!matriculas.containsKey(matricula_id)) {
            throw new Exception("la matricula "+matricula_id+" no existe!");
        }
        matriculas.remove(matricula_id);
    }

    public static List<Matricula> listarTodo() {
        return new ArrayList<>(matriculas.values());
    }

    public static int contarTodo() {
        return matriculas.size();
    }
}
