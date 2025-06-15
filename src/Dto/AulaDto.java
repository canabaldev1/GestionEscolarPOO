package Dto;

import CrudBD.AulaCrudBD;
import Dominio.Aula;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AulaDto {
    public static Aula buscar(Long id) {

        AulaCrudBD aulaCrud = new AulaCrudBD();
        try {
            Aula aulaBuscado = aulaCrud.buscar(id);
            return aulaBuscado;

        } catch (Exception e) {
            return new Aula();
        }
    }

    public static void guardar(Aula aula) throws Exception {
        AulaCrudBD aulaCrud = new AulaCrudBD();
        aulaCrud.guardar(aula);
    }

    public static void editar(Aula aula) throws Exception {
        AulaCrudBD aulaCrud = new AulaCrudBD();
        aulaCrud.actualizar(aula);
    }

    public static void eliminar(Long id) throws Exception {
        AulaCrudBD aulaCrud = new AulaCrudBD();
        aulaCrud.eliminar(id);
    }

    public static List<Aula> listarTodo() throws Exception {
        AulaCrudBD aulaCrud = new AulaCrudBD();
        return aulaCrud.listarTodos();
    }
}
