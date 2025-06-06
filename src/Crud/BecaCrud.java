package Crud;

import Dominio.Beca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class BecaCrud {

    public static HashMap<String, Beca> becas = new HashMap<>();

    public static void agregar(Beca beca) throws Exception {
        if (becas.containsKey(beca.getId().toString())) {
            throw new Exception("la beca " + beca.getId().toString() + " ya existe!");
        }
        becas.put(beca.getId().toString(), beca);
    }

    public static Beca buscar(String beca_id) throws Exception {
        if (!becas.containsKey(beca_id)) {
            throw new Exception("la beca " + beca_id + " no existe!");
        }
        return becas.get(beca_id);
    }

    public static void editar(Beca beca) throws Exception {
        if (!becas.containsKey(beca.getId().toString())) {
            throw new Exception("la beca " + beca.getId().toString() + " no existe!");
        }
        becas.put(beca.getId().toString(), beca);
    }

    public static void eliminar(String beca_id) throws Exception {
        if (!becas.containsKey(beca_id)) {
            throw new Exception("la beca " + beca_id + " no existe!");
        }
        becas.remove(beca_id);
    }

    public static List<Beca> listarTodo() {
        return new ArrayList<>(becas.values());
    }

    public static int contarTodo() {
        return becas.size();
    }
}
