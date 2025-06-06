package Pruebas.Crud;

import CrudBD.CicloAcademicoCrudBD;
import CrudBD.MatriculaCrudBD;
import Dominio.CicloAcademico;
import Dominio.Constantes.EstadoCicloAcademico;
import Dominio.Matricula;
import java.time.LocalDate;

/**
 *
 * @author lm-carlos
 */
public class CicloAcademicoPrueba {

    public static void crearCicloAcademicoSinError() {

        // crear ciclo academico
        CicloAcademico ciclo2024 = new CicloAcademico();
        ciclo2024.setAnio(2024);
        ciclo2024.setEstado(EstadoCicloAcademico.FINALIZADO);
        ciclo2024.setCantidadSemanas(30);
        ciclo2024.setFechaInicio(LocalDate.of(2024, 2, 1));
        ciclo2024.setFechaFin(LocalDate.of(2024, 11, 30));

        // crear clase CRUD
        try {
            CicloAcademicoCrudBD cicloAcademicoCrudBD = new CicloAcademicoCrudBD();

            cicloAcademicoCrudBD.guardar(ciclo2024);

            System.out.println("Ciclo Academico Guardado: " + ciclo2024.getId());

        } catch (Exception e) {

            System.err.println("Error al guardar ciclo academico: " + e.getMessage());

        }

    }

    public static void buscarYModificar(Long id) {
        try {
            CicloAcademicoCrudBD cicloAcademicoCrudBD = new CicloAcademicoCrudBD();

            CicloAcademico cicloBuscado = cicloAcademicoCrudBD.buscar(id);

            System.out.println(cicloBuscado);

            cicloBuscado.setAnio(300000);

            cicloAcademicoCrudBD.actualizar(cicloBuscado);

            System.out.println("Ciclo modificado exitosamente");

        } catch (Exception e) {

            System.err.println("Error al guardar ciclo academico: " + e.getMessage());

        }

    }

    public static void crearMatricula() {
        try {
            CicloAcademicoCrudBD cicloAcademicoCrudBD = new CicloAcademicoCrudBD();

            Long id = 3L;
            CicloAcademico cicloBuscado = cicloAcademicoCrudBD.buscar(id);

            Matricula matriculaNueva = new Matricula();
            matriculaNueva.setCicloAcademico(cicloBuscado);

            MatriculaCrudBD matriculaCrudBD = new MatriculaCrudBD();

            matriculaCrudBD.guardar(matriculaNueva);

            System.out.println("Matricula creada exitosamente");

        } catch (Exception e) {

            System.err.println("Error al crear matricula: " + e.getMessage());

        }

    }

    public static void buscarMatricula() {
        try {
            MatriculaCrudBD matriculaCrudBD = new MatriculaCrudBD();

            Matricula matriculaBuscada = matriculaCrudBD.buscar(1L);

            System.out.println("Matricula encontrada exitosamente:\n" + matriculaBuscada);

        } catch (Exception e) {

            System.err.println("Error al crear matricula: " + e.getMessage());

        }

    }
}
