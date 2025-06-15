package Dto;

import CrudBD.AlumnoCrudBD;
import Dominio.Alumno;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AlumnoDto {

    public static Alumno buscar(Long id) {

        AlumnoCrudBD alumnoCrud = new AlumnoCrudBD();
        try {
            Alumno alumnoBuscado = alumnoCrud.buscar(id);
            return alumnoBuscado;

        } catch (Exception e) {
            return new Alumno();
        }
    }

    public static void guardar(Alumno alumno) throws Exception {
        AlumnoCrudBD alumnoCrud = new AlumnoCrudBD();
        alumnoCrud.guardar(alumno);
    }

    public static void editar(Alumno alumno) throws Exception {
        AlumnoCrudBD alumnoCrud = new AlumnoCrudBD();
        alumnoCrud.actualizar(alumno);
    }

    public static void eliminar(Long id) throws Exception {
        AlumnoCrudBD alumnoCrud = new AlumnoCrudBD();
        alumnoCrud.eliminar(id);
    }

    public static List<Alumno> listarTodo() throws Exception {
        AlumnoCrudBD alumnoCrud = new AlumnoCrudBD();
        return alumnoCrud.listarTodos();
    }

}
