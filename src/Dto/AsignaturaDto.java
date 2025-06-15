package Dto;

import CrudBD.AsignaturaCrudBD;
import Dominio.Asignatura;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AsignaturaDto {
    
    public static Asignatura buscar(Long id) {

        AsignaturaCrudBD asignaturaCrud = new AsignaturaCrudBD();
        try {
            Asignatura asignaturaBuscado = asignaturaCrud.buscar(id);
            return asignaturaBuscado;

        } catch (Exception e) {
            return new Asignatura();
        }
    }

    public static void guardar(Asignatura asignatura) throws Exception {
        AsignaturaCrudBD asignaturaCrud = new AsignaturaCrudBD();
        asignaturaCrud.guardar(asignatura);
    }

    public static void editar(Asignatura asignatura) throws Exception {
        AsignaturaCrudBD asignaturaCrud = new AsignaturaCrudBD();
        asignaturaCrud.actualizar(asignatura);
    }

    public static void eliminar(Long id) throws Exception {
        AsignaturaCrudBD asignaturaCrud = new AsignaturaCrudBD();
        asignaturaCrud.eliminar(id);
    }

    public static List<Asignatura> listarTodo() throws Exception {
        AsignaturaCrudBD asignaturaCrud = new AsignaturaCrudBD();
        return asignaturaCrud.listarTodos();
    }

}
