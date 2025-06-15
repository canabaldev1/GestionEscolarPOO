package Dto;

import CrudBD.CursoCrudBD;
import Dominio.Curso;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class CursoDto {
    public static Curso buscar(Long id) {

        CursoCrudBD cursoCrud = new CursoCrudBD();
        try {
            Curso cursoBuscado = cursoCrud.buscar(id);
            return cursoBuscado;

        } catch (Exception e) {
            return new Curso();
        }
    }

    public static void guardar(Curso curso) throws Exception {
        CursoCrudBD cursoCrud = new CursoCrudBD();
        cursoCrud.guardar(curso);
    }

    public static void editar(Curso curso) throws Exception {
        CursoCrudBD cursoCrud = new CursoCrudBD();
        cursoCrud.actualizar(curso);
    }

    public static void eliminar(Long id) throws Exception {
        CursoCrudBD cursoCrud = new CursoCrudBD();
        cursoCrud.eliminar(id);
    }

    public static List<Curso> listarTodo() throws Exception {
        CursoCrudBD cursoCrud = new CursoCrudBD();
        return cursoCrud.listarTodos();
    }
}
