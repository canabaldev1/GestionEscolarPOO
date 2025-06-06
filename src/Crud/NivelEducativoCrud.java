package Crud;

import Dominio.NivelEducativo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class NivelEducativoCrud {

    public static HashMap<String, NivelEducativo> nivelesEducativos = new HashMap<>();

    public static void agregar(NivelEducativo nivelEducativo) throws Exception {
        if (nivelesEducativos.containsKey(nivelEducativo.getId().toString())) {
            throw new Exception("el nivel educativo "+nivelEducativo.getId().toString()+" ya existe!");
        }
        nivelesEducativos.put(nivelEducativo.getId().toString(), nivelEducativo);
    }

    public static NivelEducativo buscar(String nivelEducativo_id) throws Exception {
        if (!nivelesEducativos.containsKey(nivelEducativo_id)) {
            throw new Exception("el nivel educativo "+nivelEducativo_id+" no existe!");
        }
        return nivelesEducativos.get(nivelEducativo_id);
    }

    public static void editar(NivelEducativo nivelEducativo) throws Exception {
        if (!nivelesEducativos.containsKey(nivelEducativo.getId().toString())) {
            throw new Exception("el nivel educativo "+nivelEducativo.getId().toString()+" no existe!");
        }
        nivelesEducativos.put(nivelEducativo.getId().toString(), nivelEducativo);
    }

    public static void eliminar(String nivelEducativo_id) throws Exception {
        if (!nivelesEducativos.containsKey(nivelEducativo_id)) {
            throw new Exception("el nivel educativo "+nivelEducativo_id+" no existe!");
        }
        nivelesEducativos.remove(nivelEducativo_id);
    }

    public static List<NivelEducativo> listarTodo() {
        return new ArrayList<>(nivelesEducativos.values());
    }

    public static int contarTodo() {
        return nivelesEducativos.size();
    }
}

