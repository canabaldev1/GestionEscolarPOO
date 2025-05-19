package Crud;

import Dominio.Contrato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ContratoCrud {
    public static HashMap<String, Contrato> contratos = new HashMap<>();
    
    public static void agregar (Contrato contrato) throws Exception {
        if (contratos.containsKey(contrato.getId())) {
            throw new Exception ("el contrato "+contrato.getId()+" ya existe!");
        }
        contratos.put(contrato.getId(), contrato );
    }

    public static Contrato buscar (String contrato_id) throws Exception {
        if (!contratos.containsKey(contrato_id)) {
            throw new Exception ("el contrato "+contrato_id+" no existe!");
        }
        return contratos.get(contrato_id);
    }

    public static void editar (Contrato contrato) throws Exception {
        if (!contratos.containsKey(contrato.getId())) {
            throw new Exception ("el contrato "+contrato.getId()+" no existe!");
        }
        contratos.put(contrato.getId(), contrato);
    }
    
    public static void eliminar (String contrato_id) throws Exception {
        if (!contratos.containsKey(contrato_id)) {
            throw new Exception ("el contrato "+contrato_id+" no existe!");
        }
        contratos.remove(contrato_id);
    }
    
    public static List<Contrato> listarTodo () {
        return new ArrayList<>(contratos.values());
    }
    
    public static int contarTodo () {
        return contratos.size();
    }
}