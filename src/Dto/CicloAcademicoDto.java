package Dto;

import CrudBD.CicloAcademicoCrudBD;
import Dominio.CicloAcademico;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class CicloAcademicoDto {
    public static CicloAcademico buscar(Long id) {

        CicloAcademicoCrudBD cicloAcademicoCrud = new CicloAcademicoCrudBD();
        try {
            CicloAcademico cicloAcademicoBuscado = cicloAcademicoCrud.buscar(id);
            return cicloAcademicoBuscado;

        } catch (Exception e) {
            return new CicloAcademico();
        }
    }

    public static void guardar(CicloAcademico cicloAcademico) throws Exception {
        CicloAcademicoCrudBD cicloAcademicoCrud = new CicloAcademicoCrudBD();
        cicloAcademicoCrud.guardar(cicloAcademico);
    }

    public static void editar(CicloAcademico cicloAcademico) throws Exception {
        CicloAcademicoCrudBD cicloAcademicoCrud = new CicloAcademicoCrudBD();
        cicloAcademicoCrud.actualizar(cicloAcademico);
    }

    public static void eliminar(Long id) throws Exception {
        CicloAcademicoCrudBD cicloAcademicoCrud = new CicloAcademicoCrudBD();
        cicloAcademicoCrud.eliminar(id);
    }

    public static List<CicloAcademico> listarTodo() throws Exception {
        CicloAcademicoCrudBD cicloAcademicoCrud = new CicloAcademicoCrudBD();
        return cicloAcademicoCrud.listarTodos();
    }
}
