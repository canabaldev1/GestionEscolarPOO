package carloscanabal;

import Crud.AdministrativoCrud;
import Crud.AlumnoCrud;
import Crud.AsignaturaCrud;
import Crud.AulaCrud;
import Crud.BecaCrud;
import Crud.BloqueHorarioCrud;
import Crud.CicloAcademicoCrud;
import Crud.ClaseCrud;
import Crud.ContratoCrud;
import Crud.CursoCrud;
import Crud.GrupoInfantilCrud;
import Crud.GrupoRegularCrud;
import Crud.MatriculaCrud;
import Crud.ModalidadCrud;
import Crud.NivelEducativoCrud;
import Crud.ProfesorInfantilCrud;
import Crud.ProfesorRegularCrud;
import Crud.ServicioComplementarioCrud;
import Crud.SesionCrud;
import Dominio.Administrativo;
import Dominio.Alumno;
import Dominio.AsignacionAlumnoGrupo;
import Dominio.AsignacionAlumnoServicio;
import Dominio.Asignatura;
import Dominio.AsistenciaSesion;
import Dominio.Aula;
import Dominio.Beca;
import Dominio.BloqueHorario;
import Dominio.CicloAcademico;
import Dominio.Clase;
import Dominio.Constantes.AreaAdministrativa;
import Dominio.Constantes.DiaSemana;
import Dominio.Constantes.EstadoAsignacionServicio;
import Dominio.Constantes.EstadoBeca;
import Dominio.Constantes.EstadoCicloAcademico;
import Dominio.Constantes.EstadoContrato;
import Dominio.Constantes.EstadoDesempenoEstudiante;
import Dominio.Constantes.EstadoEmpleado;
import Dominio.Constantes.EstadoMatricula;
import Dominio.Constantes.EstadoServicioComplementario;
import Dominio.Constantes.ParentescoAcudiente;
import Dominio.Constantes.PrioridadAsignatura;
import Dominio.Constantes.TipoContrato;
import Dominio.Constantes.TipoCuenta;
import Dominio.Constantes.TipoNivelEducativo;
import Dominio.Contrato;
import Dominio.Curso;
import Dominio.DesempenoAlumno;
import Dominio.GrupoInfantil;
import Dominio.GrupoRegular;
import Dominio.HorarioClase;
import Dominio.Matricula;
import Dominio.Modalidad;
import Dominio.NivelEducativo;
import Dominio.ProfesorInfantil;
import Dominio.ProfesorRegular;
import Dominio.ServicioComplementario;
import Dominio.Sesion;
import Infraestructura.Configuracion.BD.ConexionBD;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 *
 * @author lm-carlos
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) throws InterruptedException {

        // Ahora se procede a instanciar objetos utilizando las clases. Primero,
        // se instanciará un objeto con el constructor por defecto y luego otro
        // utilizando los argumentos. Luego se mostrarán algunas propiedades de 
        // cada uno utilizando los getters. Y luego se completará toda la 
        // demás información con los setters.
        //
        // NOTA:
        // Las clases Usuario, Empleado, Profesor y Grupo son abstractas, porque
        // son clases que heredan a otras, y no se usan para instanciar objetos
        // directamente.
        //
        // ALUMNOS
        System.out.println("\033[1;31m-------------------------------------------------------------------------");
        System.out.println("\033[1;31m-------------------- CREACION DE OBJETOS Y RELACIONES -------------------");
        System.out.println("\033[1;31m-------------------------------------------------------------------------");

        System.out.println("\n----- ALUMNOS -----\n");
        Alumno alumno1 = new Alumno();
        alumno1.setId("AL001");
        alumno1.setNombres("Bart");
        alumno1.setApellidos("Simpson");
        alumno1.setContrasena("barto123");
        alumno1.setEmail("bart@udc.com");
        alumno1.setTelefono("3005551234");
        alumno1.setDireccion("Av Siempre Viva 123");
        alumno1.setNombreAcudiente("Homero");
        alumno1.setApellidoAcudiente("Simpson");
        alumno1.setParentesco(ParentescoAcudiente.PADRE);
        alumno1.setFechaNacimiento(LocalDate.of(2010, 4, 1));

        Alumno alumno2 = new Alumno(
                "AL002",
                "Lisa",
                "Simpson",
                "7@]63Yt_X9X6\\X£",
                "lisa@udc.com"
        );

        alumno2.setTelefono("3005554321");
        alumno2.setDireccion("Av Siempre Viva 123");
        alumno2.setNombreAcudiente("Marge");
        alumno2.setApellidoAcudiente("Bouvier");
        alumno2.setParentesco(ParentescoAcudiente.MADRE);
        alumno2.setFechaNacimiento(LocalDate.of(2012, 5, 9));

        System.out.println(alumno1);
        System.out.println(alumno2);

        // ADMINISTRATIVOS
        //
        System.out.println("\n----- ADMINISTRATIVOS-----\n");
        Administrativo admin1 = new Administrativo();
        admin1.setId("AD001");
        admin1.setNombres("Lionel");
        admin1.setApellidos("Messi");
        admin1.setContrasena("goat10");
        admin1.setEmail("lio@udc.com");
        admin1.setFechaNacimiento(LocalDate.of(1987, 6, 24));
        admin1.setTelefono("3101010101");
        admin1.setDireccion("Rosario, Argentina");
        admin1.setProfesion("Atleta");
        admin1.setNumeroCuentaBancaria("101010101010");
        admin1.setTipoCuentaBancaria(TipoCuenta.CORRIENTE);
        admin1.setBancoAsociado("Banco De Argentina");
        admin1.setFechaIngreso(LocalDate.now());
        admin1.setEstado(EstadoEmpleado.ACTIVO);
        admin1.setAreaAdministrativa(AreaAdministrativa.RECURSOS_HUMANOS);

        Administrativo admin2 = new Administrativo(
                "AD002",
                "Kylian",
                "Mbappe",
                "fast7",
                "mbappe@udc.com",
                LocalDate.now()
        );

        admin2.setFechaNacimiento(LocalDate.of(1998, 12, 20));
        admin2.setTelefono("3117418529");
        admin2.setDireccion("París, Francia");

        admin2.setProfesion("Preparador Físico");
        admin2.setNumeroCuentaBancaria("1111111111");
        admin2.setTipoCuentaBancaria(TipoCuenta.AHORROS);
        admin2.setBancoAsociado("Banco Paris");
        admin2.setEstado(EstadoEmpleado.INACTIVO);
        admin2.setAreaAdministrativa(AreaAdministrativa.CONTABILIDAD);

        System.out.println(admin1);
        System.out.println(admin2);

        //PROFESOR REGULAR
        System.out.println("\n----- PROFESORES REGULARES -----\n");

        ProfesorRegular profesorRegular1 = new ProfesorRegular();
        profesorRegular1.setId("PR001");
        profesorRegular1.setNombres("Albert");
        profesorRegular1.setApellidos("Einstein");
        profesorRegular1.setContrasena("relatividad123");
        profesorRegular1.setEmail("einstein@udc.com");
        profesorRegular1.setFechaNacimiento(LocalDate.of(1879, 3, 14));
        profesorRegular1.setTelefono("3001112233");
        profesorRegular1.setDireccion("Ulm, Alemania");

        profesorRegular1.setProfesion("Físico Teórico");
        profesorRegular1.setNumeroCuentaBancaria("2222222222");
        profesorRegular1.setTipoCuentaBancaria(TipoCuenta.CORRIENTE);
        profesorRegular1.setBancoAsociado("Banco Alemania");
        profesorRegular1.setFechaIngreso(LocalDate.now());
        profesorRegular1.setEstado(EstadoEmpleado.ACTIVO);
        profesorRegular1.setTitulacionAcademica("Doctorado en Física");

        ProfesorRegular profesorRegular2 = new ProfesorRegular(
                "PR002",
                "Robert",
                "Oppenheimer",
                "atomico1",
                "robopp@udc.com",
                LocalDate.now()
        );

        profesorRegular2.setFechaNacimiento(LocalDate.of(1867, 11, 7));
        profesorRegular2.setTelefono("3002223344");
        profesorRegular2.setDireccion("Nueva York");

        profesorRegular2.setProfesion("Químico y Físico");
        profesorRegular2.setNumeroCuentaBancaria("3333333333");
        profesorRegular2.setTipoCuentaBancaria(TipoCuenta.AHORROS);
        profesorRegular2.setBancoAsociado("Banco De Nueva York");
        profesorRegular2.setEstado(EstadoEmpleado.ACTIVO);
        profesorRegular2.setTitulacionAcademica("Doctorado en Ciencias Físicas");

        System.out.println(profesorRegular1);
        System.out.println(profesorRegular2);

        // PROFESORES INFANTILES
        System.out.println("\n----- PROFESORES INFANTILES-----\n");

        ProfesorInfantil profesorInfantil1 = new ProfesorInfantil();
        profesorInfantil1.setId("PI001");
        profesorInfantil1.setNombres("Isaac");
        profesorInfantil1.setApellidos("Newton");
        profesorInfantil1.setContrasena("gravedad9.81");
        profesorInfantil1.setEmail("newton@udc.com");
        profesorInfantil1.setFechaNacimiento(LocalDate.of(1643, 1, 4));
        profesorInfantil1.setTelefono("3009876543");
        profesorInfantil1.setDireccion("Lincolnshire, Inglaterra");

        profesorInfantil1.setProfesion("Matemático y Físico");
        profesorInfantil1.setNumeroCuentaBancaria("4444444444");
        profesorInfantil1.setTipoCuentaBancaria(TipoCuenta.CORRIENTE);
        profesorInfantil1.setBancoAsociado("Banco Inglaterra");
        profesorInfantil1.setFechaIngreso(LocalDate.now());
        profesorInfantil1.setEstado(EstadoEmpleado.ACTIVO);
        profesorInfantil1.setTitulacionAcademica("Maestría en Matemáticas");

        ProfesorInfantil profesorInfantil2 = new ProfesorInfantil(
                "PI002",
                "Galileo",
                "Galilei",
                "telescopio1",
                "galileo@udc.com",
                LocalDate.now()
        );

        profesorInfantil2.setFechaNacimiento(LocalDate.of(1564, 2, 15));
        profesorInfantil2.setTelefono("3009988776");
        profesorInfantil2.setDireccion("Pisa, Italia");

        profesorInfantil2.setProfesion("Astrónomo y Físico");
        profesorInfantil2.setNumeroCuentaBancaria("5555555555");
        profesorInfantil2.setTipoCuentaBancaria(TipoCuenta.AHORROS);
        profesorInfantil2.setBancoAsociado("Banco Italia");
        profesorInfantil2.setEstado(EstadoEmpleado.ACTIVO);
        profesorInfantil2.setTitulacionAcademica("Doctorado en Ciencias Naturales");

        ProfesorInfantil profesorInfantil3 = new ProfesorInfantil(
                "PI003",
                "Juan Bautista",
                "De La Salle",
                "lasalle123",
                "jbls@udc.com",
                LocalDate.now()
        );

        profesorInfantil3.setFechaNacimiento(LocalDate.of(1651, 4, 30));
        profesorInfantil3.setTelefono("3001234567");
        profesorInfantil3.setDireccion("Reims, Francia");

        profesorInfantil3.setProfesion("Sacerdote y Pedagogo");
        profesorInfantil3.setNumeroCuentaBancaria("7005006005");
        profesorInfantil3.setTipoCuentaBancaria(TipoCuenta.AHORROS);
        profesorInfantil3.setBancoAsociado("Banco de Reims");
        profesorInfantil3.setEstado(EstadoEmpleado.ACTIVO);
        profesorInfantil3.setTitulacionAcademica("Doctorado y Educación");

        ProfesorInfantil profesorInfantil4 = new ProfesorInfantil(
                "PI004",
                "Jean",
                "Piaget",
                "jeancho123",
                "piaget@udc.com",
                LocalDate.now()
        );

        profesorInfantil4.setFechaNacimiento(LocalDate.of(1896, 8, 9));
        profesorInfantil4.setTelefono("3012345678");
        profesorInfantil4.setDireccion("Neuchatel, Suiza");

        profesorInfantil4.setProfesion("Psicólogo y Biólogo");
        profesorInfantil4.setNumeroCuentaBancaria("7777777777");
        profesorInfantil4.setTipoCuentaBancaria(TipoCuenta.CORRIENTE);
        profesorInfantil4.setBancoAsociado("Banco Suizo de Desarrollo");
        profesorInfantil4.setEstado(EstadoEmpleado.ACTIVO);
        profesorInfantil4.setTitulacionAcademica("Doctorado en Ciencias Naturales y Psicología");

        // Necesito 4 profesores infantiles, porque tengo 2 grupos. Y a cada uno
        // Le corresponden 2 profesores.
        System.out.println(profesorInfantil1);
        System.out.println(profesorInfantil2);
        System.out.println(profesorInfantil3);
        System.out.println(profesorInfantil4);

        // AULAS
        System.out.println("\n----- AULAS -----\n");

        Aula aula1 = new Aula();
        aula1.setId("AU-B205");
        aula1.setNombre("Bloque B salon 205");
        aula1.setCapacidad(35);
        aula1.setUbicacion("Edificio B - Piso 2 - Salon 5");

        Aula aula2 = new Aula(
                "AU-B206",
                "Bloque B salon 206",
                35,
                "Edificio B - Piso 2 - Salon 6"
        );
        Aula aula3 = new Aula(
                "AU-C102",
                "Bloque C salon 102",
                40,
                "Edificio C - Piso 1 - Salon 2"
        );
        Aula aula4 = new Aula(
                "AU-C103",
                "Bloque C salon 103",
                40,
                "Edificio C - Piso 1 - Salon 3"
        );

        // Se crear 4 aulas, para posteriormente asociarla a los 4 grupos que se
        // crearán (2 infantiles, y 2 regulares)
        System.out.println(aula1);
        System.out.println(aula2);
        System.out.println(aula3);
        System.out.println(aula4);

        // NIVELES EDUCATIVOS
        System.out.println("\n----- NIVELES EDUCATIVOS -----\n");

        NivelEducativo nivel1 = new NivelEducativo();
        nivel1.setId("NE001");
        nivel1.setNombre("Primer ciclo de educación infantil");
        nivel1.setDescripcion("Nivel para niños de 0 a 3 años.");
        nivel1.setTipo(TipoNivelEducativo.INFANTIL);

        NivelEducativo nivel2 = new NivelEducativo(
                "NE002",
                "Educación Primaria",
                TipoNivelEducativo.PRIMARIA
        );
        nivel2.setDescripcion("Nivel para niños de 6 a 12 años.");
        NivelEducativo nivel3 = new NivelEducativo(
                "NE003",
                "Bachillerato",
                TipoNivelEducativo.BACHILLERATO
        );
        nivel3.setDescripcion("Nivel para adolecentes de 16 a 18 años.");

        System.out.println(nivel1);
        System.out.println(nivel2);
        System.out.println(nivel3);

        // MODALIDADES
        System.out.println("\n----- MODALIDADES -----\n");

        Modalidad modalidad1 = new Modalidad();
        modalidad1.setId("MOD001");
        modalidad1.setNombre("Artes");
        modalidad1.setDescripcion("Bachillerato enfocado en las habilidades artisticas.");
        modalidad1.setNivelEducativo(nivel3);

        // relacion entre modalidad y nivel educativo.
        nivel3.addModalidad(modalidad1);

        Modalidad modalidad2 = new Modalidad(
                "MOD002",
                "Tecnología",
                nivel3
        );
        modalidad2.setDescripcion("Bachillerato enfocado en las ciencias de la tecnología.");

        //Se agrega modalidad2 a la lista de modalidades disponibles de nivel3
        nivel3.addModalidad(modalidad2);

        System.out.println(modalidad1);
        System.out.println(modalidad2);

        // Se imprime nivel3, que debería tener una cantidad de modalidades de 2.
        System.out.println(nivel3);

        // CURSOS
        System.out.println("\n----- CURSOS -----\n");

        Curso curso1 = new Curso();
        curso1.setId("C001");
        curso1.setNombre("Jardin");
        curso1.setNivelEducativo(nivel1);

        // Relaciones entre Curso y Modalidad y Curso y Nivel Educativo
        nivel1.addCurso(curso1);

        Curso curso2 = new Curso(
                "C002",
                "Segundo de Bachillerato",
                nivel3
        );

        // Relaciones entre Curso y Modalidad y Curso y Nivel Educativo
        curso2.setModalidad(modalidad2);

        nivel3.addCurso(curso2);
        modalidad2.addCurso(curso2);

        System.out.println(curso1);
        System.out.println(curso2);

        //CICLO ACADEMICO
        System.out.println("\n----- CICLOS ACADÉMICOS -----\n");

        CicloAcademico ciclo2024 = new CicloAcademico();
        ciclo2024.setId("CA001");
        ciclo2024.setAnio(2024);
        ciclo2024.setEstado(EstadoCicloAcademico.FINALIZADO);
        ciclo2024.setCantidadSemanas(30);
        ciclo2024.setFechaInicio(LocalDate.of(2024, 2, 1));
        ciclo2024.setFechaFin(LocalDate.of(2024, 11, 30));

        CicloAcademico ciclo2025 = new CicloAcademico("CA002", 2025, 32);
        ciclo2025.setFechaInicio(LocalDate.of(2025, 2, 4));
        ciclo2025.setFechaFin(LocalDate.of(2025, 12, 4));
        ciclo2025.setEstado(EstadoCicloAcademico.ACTUAL);

        System.out.println(ciclo2024);
        System.out.println(ciclo2025);

        // GRUPOS INFANTILES
        System.out.println("\n----- GRUPOS INFANTILES -----\n");

        GrupoInfantil grupoInfantil1 = new GrupoInfantil();
        grupoInfantil1.setId("GI001");
        grupoInfantil1.setNombre("Jardín A 2025");
        grupoInfantil1.setCurso(curso1);
        grupoInfantil1.setCicloAcademico(ciclo2025);
        grupoInfantil1.setAula(aula1);
        grupoInfantil1.setProfesorEncargado(profesorInfantil1);
        grupoInfantil1.setProfesorAsistente(profesorInfantil2);

        // Relaciones entre grupo infantil y profesores infantiles, grupo
        // y curso, entre grupo y ciclo educativo, entre grupo y aula.
        curso1.addGrupo(grupoInfantil1);
        ciclo2025.addGrupo(grupoInfantil1);
        aula1.addGrupo(grupoInfantil1);
        profesorInfantil1.setGrupo(grupoInfantil1);
        profesorInfantil2.setGrupo(grupoInfantil1);

        GrupoInfantil grupoInfantil2 = new GrupoInfantil(
                "GI002", "Jardín B 2025", curso1, ciclo2025);
        grupoInfantil2.setAula(aula2);
        grupoInfantil2.setProfesorEncargado(profesorInfantil3);
        grupoInfantil2.setProfesorAsistente(profesorInfantil4);

        // Relaciones entre grupo infantil y profesores infantiles, grupo
        // y curso, entre grupo y ciclo educativo, entre grupo y aula.
        curso1.addGrupo(grupoInfantil2);
        ciclo2025.addGrupo(grupoInfantil2);
        aula2.addGrupo(grupoInfantil2);
        profesorInfantil3.setGrupo(grupoInfantil2);
        profesorInfantil4.setGrupo(grupoInfantil2);

        System.out.println(grupoInfantil1);
        System.out.println(grupoInfantil2);

        // GRUPOS REGULARES
        System.out.println("\n----- GRUPOS REGULARES -----\n");

        GrupoRegular grupoRegular1 = new GrupoRegular();
        grupoRegular1.setId("GR001");
        grupoRegular1.setNombre("Segundo Bachillerato A 2025");
        grupoRegular1.setCurso(curso2);
        grupoRegular1.setCicloAcademico(ciclo2025);
        grupoRegular1.setAula(aula3);
        grupoRegular1.setProfesorEncargado(profesorRegular1);

        // Relaciones entre grupo regular y profesor regular, grupo
        // y curso, entre grupo y ciclo educativo, entre grupo y aula.
        curso2.addGrupo(grupoRegular1);
        ciclo2025.addGrupo(grupoRegular1);
        aula3.addGrupo(grupoRegular1);
        profesorRegular1.setGrupo(grupoRegular1);

        GrupoRegular grupoRegular2 = new GrupoRegular(
                "GR002", "Segundo Bachillerato B 2025", curso2, ciclo2025);
        grupoRegular2.setAula(aula4);
        grupoRegular2.setProfesorEncargado(profesorRegular2);

        // Relaciones entre grupo regular y profesor regular, grupo
        // y curso, entre grupo y ciclo educativo, entre grupo y aula.
        curso2.addGrupo(grupoRegular2);
        ciclo2025.addGrupo(grupoRegular2);
        aula4.addGrupo(grupoRegular2);
        profesorRegular2.setGrupo(grupoRegular2);

        System.out.println(grupoRegular1);
        System.out.println(grupoRegular2);

        // ASIGNATURAS
        System.out.println("\n----- ASIGNATURAS -----\n");

        Asignatura asignatura1 = new Asignatura();
        asignatura1.setId("AS001");
        asignatura1.setNombre("Matemáticas");
        asignatura1.setDescripcion("Asignatura que estudia los numeros.");
        asignatura1.setPrioridad(PrioridadAsignatura.ALTA);

        Asignatura asignatura2 = new Asignatura("AS002", "Educación Física");
        asignatura2.setDescripcion("Clase para acondicionamiento físico.");
        asignatura2.setPrioridad(PrioridadAsignatura.MEDIA);

        System.out.println(asignatura1);
        System.out.println(asignatura2);

        // BLOQUES HORARIOS
        System.out.println("\n----- BLOQUES HORARIOS -----\n");
        BloqueHorario bloqueHorario1 = new BloqueHorario();
        bloqueHorario1.setId("BH001");
        bloqueHorario1.setDia(DiaSemana.LUNES);
        bloqueHorario1.setHoraInicio(LocalTime.of(8, 0));
        bloqueHorario1.setHoraFin(LocalTime.of(9, 0));

        BloqueHorario bloqueHorario2 = new BloqueHorario(
                "BH002",
                DiaSemana.LUNES,
                LocalTime.of(9, 0),
                LocalTime.of(10, 0)
        );
        BloqueHorario bloqueHorario3 = new BloqueHorario(
                "BH003",
                DiaSemana.MIERCOLES,
                LocalTime.of(11, 0),
                LocalTime.of(13, 0)
        );

        System.out.println(bloqueHorario1);
        System.out.println(bloqueHorario2);
        System.out.println(bloqueHorario3);

        // CLASES
        System.out.println("\n----- CLASES -----\n");
        Clase clase1 = new Clase();
        clase1.setId("CL001");
        clase1.setGrupo(grupoRegular1);
        clase1.setAsignatura(asignatura1);
        clase1.setCicloAcademico(ciclo2025);
        clase1.setProfesor(profesorRegular1);

        // Relaciones entre clases y grupo regular, entre clase y
        // asignatura, entre clase y ciclo academico, y clase 
        // y profesor regular.
        grupoRegular1.addClase(clase1);
        asignatura1.addClase(clase1);
        ciclo2025.addClase(clase1);
        profesorRegular1.addClase(clase1);

        Clase clase2 = new Clase(
                "CL002",
                grupoRegular1,
                asignatura2,
                ciclo2025
        );
        clase2.setProfesor(profesorRegular2);

        // Relaciones entre clases y grupo regular, entre clase y 
        // asignatura, entre clase y ciclo academico, y clase 
        // y profesor regular.
        grupoRegular1.addClase(clase2);
        asignatura2.addClase(clase2);
        ciclo2025.addClase(clase2);
        profesorRegular2.addClase(clase2);

        System.out.println(clase1);
        System.out.println(clase2);

        // SESIONES
        System.out.println("\n----- SESIONES -----\n");
        Sesion sesion1 = new Sesion();
        sesion1.setId("S001");
        sesion1.setFecha(LocalDate.of(2025, 4, 21));
        sesion1.setSemana(5);
        sesion1.setBloqueHorario(bloqueHorario1);
        sesion1.setAula(aula1);
        sesion1.setClase(clase1);

        // Relacion entre sesion y bloque horario, entre sesion y 
        // aula, y entre sesion y clase.
        bloqueHorario1.addSesion(sesion1);
        aula1.addSesion(sesion1);
        clase1.addSesion(sesion1);

        Sesion sesion2 = new Sesion(
                "S002",
                LocalDate.of(2025, 4, 28),
                6,
                bloqueHorario1,
                aula1,
                clase1
        );

        // Relacion entre sesion y bloque horario, entre sesion y 
        // aula, y entre sesion y clase.
        bloqueHorario1.addSesion(sesion2);
        aula1.addSesion(sesion2);
        clase1.addSesion(sesion2);

        System.out.println(sesion1);
        System.out.println(sesion2);

        // BECAS
        System.out.println("\n----- BECAS -----\n");
        Beca beca1 = new Beca();
        beca1.setId("B001");
        beca1.setNombre("Beca Excelencia Académica");
        beca1.setDescripcion(
                "Otorgada a estudiantes con promedio sobresaliente.");
        beca1.setValorDescuento(500000);
        beca1.setObservaciones("Aplica únicamente al primer ciclo.");
        beca1.setOtorgadaPor("Dirección Académica");
        beca1.setEstado(EstadoBeca.ACTIVA);

        Beca beca2 = new Beca(
                "B002", "Beca de Inclusión", "Ministerio de Educación");
        beca2.setDescripcion(
                "Otorgada a estudiantes provenientes de comunidades vulnerables.");
        beca2.setValorDescuento(450000);
        beca2.setObservaciones("Renovable si mantiene promedio alto.");
        beca2.setEstado(EstadoBeca.DISPONIBLE);

        System.out.println(beca1);
        System.out.println(beca2);

        // MATRICULAS
        System.out.println("\n----- MATRICULAS -----\n");
        Matricula matricula1 = new Matricula();
        matricula1.setId("M001");
        matricula1.setFechaMatricula(LocalDateTime.of(2025, 3, 1, 10, 00));
        matricula1.setEstado(EstadoMatricula.VIGENTE);
        matricula1.setFechaPago(LocalDateTime.of(2025, 3, 1, 10, 0));
        matricula1.setValorMatricula(500000);
        matricula1.setValorMensualidad(150000);
        matricula1.setObservaciones("Pago completo realizado.");
        matricula1.setAlumno(alumno1);
        matricula1.setCicloAcademico(ciclo2025);
        matricula1.setCurso(curso2);
        matricula1.setBeca(beca1);

        // relaciones entre matricula y alumno, entre matricula y curso, entre
        // matricula y beca, y entre matricula y ciclo academico.
        alumno1.addMatricula(matricula1);
        curso2.addMatricula(matricula1);
        beca1.setMatricula(matricula1);
        ciclo2025.addMatricula(matricula1);

        Matricula matricula2 = new Matricula(
                "M002", LocalDateTime.of(2025, 3, 1, 10, 15), alumno2, ciclo2025);
        matricula2.setValorMatricula(500000);
        matricula2.setValorMensualidad(120000);
        matricula2.setCurso(curso1);
        matricula2.setEstado(EstadoMatricula.PENDIENTE);

        // relaciones entre matricula y alumno, entre matricula y curso, entre
        // matricula y beca, y entre matricula y ciclo academico.
        alumno2.addMatricula(matricula2);
        curso1.addMatricula(matricula2);
        ciclo2025.addMatricula(matricula2);

        System.out.println(alumno1);
        System.out.println(alumno2.getMatriculas());
        System.out.println(matricula1);
        System.out.println(matricula2);

        // CONTRATOS
        System.out.println("\n----- CONTRATOS -----\n");
        Contrato contrato1 = new Contrato();
        contrato1.setId("CON001");
        contrato1.setTipo(TipoContrato.OPS);
        contrato1.setFechaInicio(LocalDate.of(2025, 1, 1));
        contrato1.setFechaFin(LocalDate.of(2025, 12, 31));
        contrato1.setValorSalario(5000000);
        contrato1.setEstado(EstadoContrato.VIGENTE);
        contrato1.setObservaciones("Contrato anual con posibilidad de renovación.");
        contrato1.setCargo("Docente");
        contrato1.setEmpleado(profesorRegular1);
        contrato1.setCicloAcademico(ciclo2025);

        // Relaciones entre contrato y empleado y contrato y ciclo academico
        profesorRegular1.addContrato(contrato1);
        ciclo2025.addContrato(contrato1);

        Contrato contrato2 = new Contrato(
                "CON002",
                TipoContrato.PLANTA,
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 12, 31),
                3500000,
                admin1,
                ciclo2025
        );
        contrato2.setCargo("Auxiliar contable");
        contrato2.setEstado(EstadoContrato.VIGENTE);

        // Relaciones entre contrato y empleado y contrato y ciclo academico
        admin1.addContrato(contrato2);
        ciclo2025.addContrato(contrato2);

        System.out.println(contrato1);
        System.out.println(contrato2);

        // SERVICIOS COMPLEMENTARIOS
        System.out.println("\n----- SERVICIOS COMPLEMENTARIOS -----\n");
        ServicioComplementario servicio1 = new ServicioComplementario();
        servicio1.setId("SC001");
        servicio1.setNombre("Ruta escolar");
        servicio1.setDescripcion("Transporte del colegio a la casa y viceversa.");
        servicio1.setValor(700000);
        servicio1.setFechaInicio(LocalDate.of(2025, 2, 1));
        servicio1.setFechaFin(LocalDate.of(2025, 11, 30));
        servicio1.setEstado(EstadoServicioComplementario.DISPONIBLE);
        servicio1.setCicloAcademico(ciclo2025);

        // Relacion entre servicios complementarios y ciclo academico
        ciclo2025.addServicioComplementario(servicio1);

        ServicioComplementario servicio2 = new ServicioComplementario(
                "SC002", "Comedor", ciclo2025);
        servicio2.setDescripcion(
                "Espacio extracurricular para experimentos y actividades científicas.");
        servicio2.setValor(150000);
        servicio2.setFechaInicio(LocalDate.of(2025, 2, 1));
        servicio2.setFechaFin(LocalDate.of(2025, 11, 30));
        servicio2.setEstado(EstadoServicioComplementario.DISPONIBLE);

        // Relacion entre servicios complementarios y ciclo academico
        ciclo2025.addServicioComplementario(servicio2);

        System.out.println(servicio1);
        System.out.println(servicio2);

        // OTRAS RELACIONES - DE MUCHOS A MUCHOS
        
        System.out.println("\n----- RELACIONES MUCHOS A MUCHOS -----\n\n");

        //Asignacion de alumnos a grupos por medio de la clase AsignacionAlumnoGrupo
        System.out.println("\n----- ALUMNOS Y GRUPOS -----\n");
        AsignacionAlumnoGrupo asignacionAlumnoGrupo1 = new AsignacionAlumnoGrupo();
        asignacionAlumnoGrupo1.setId("AsAG001");
        asignacionAlumnoGrupo1.setAlumno(alumno1);
        asignacionAlumnoGrupo1.setGrupo(grupoRegular1);
        asignacionAlumnoGrupo1.setFechaInicioInscripcion(LocalDate.of(2025, 2, 1));
        asignacionAlumnoGrupo1.setFechaFinInscripcion(LocalDate.of(2025, 5, 1));

        alumno1.addGrupo(asignacionAlumnoGrupo1);
        grupoRegular1.addAlumno(asignacionAlumnoGrupo1);

        AsignacionAlumnoGrupo asignacionAlumnoGrupo2 = new AsignacionAlumnoGrupo("AsAG002", alumno1, grupoRegular2);
        asignacionAlumnoGrupo2.setFechaInicioInscripcion(LocalDate.of(2025, 5, 2));
        asignacionAlumnoGrupo2.setFechaFinInscripcion(LocalDate.of(2025, 11, 30));

        alumno1.addGrupo(asignacionAlumnoGrupo2);
        grupoRegular2.addAlumno(asignacionAlumnoGrupo2);

        System.out.println(alumno1);
        System.out.println(grupoRegular1);
        System.out.println(grupoRegular2);
        System.out.println(asignacionAlumnoGrupo1);
        System.out.println(asignacionAlumnoGrupo2);

        // Asistencia de alumnos a sesiones por medio de la clase AsistenciaSesion
        System.out.println("\n----- ALUMNOS Y SESIONES -----\n");

        AsistenciaSesion asistenciaSesion1 = new AsistenciaSesion();
        asistenciaSesion1.setId("AS001");
        asistenciaSesion1.setAlumno(alumno1);
        asistenciaSesion1.setSesion(sesion1);
        asistenciaSesion1.setPresente(Boolean.TRUE);
        asistenciaSesion1.setObservaciones("Buen comportamiento");

        alumno1.addSesion(asistenciaSesion1);
        sesion1.addAlumno(asistenciaSesion1);

        AsistenciaSesion asistenciaSesion2 = new AsistenciaSesion("AS002", alumno1, sesion2, Boolean.FALSE);
        asistenciaSesion2.setObservaciones("Fue al baño y se quedó jugando futbol.");

        alumno1.addSesion(asistenciaSesion2);
        sesion2.addAlumno(asistenciaSesion2);

        System.out.println(alumno1);
        System.out.println(sesion1);
        System.out.println(sesion2);

        System.out.println(asistenciaSesion1);
        System.out.println(asistenciaSesion2);

        // Desempeño de alumnos en clases por medio de la clase DesempenoAlumno
        System.out.println("\n----- ALUMNOS Y CLASES -----\n");

        DesempenoAlumno desempeno1 = new DesempenoAlumno();
        desempeno1.setId("DA001");
        desempeno1.setAlumno(alumno1);
        desempeno1.setClase(clase1);
        desempeno1.setNotaPrimerTrimestre(5);
        desempeno1.setNotaSegundoTrimestre(4);
        desempeno1.setNotaTercerTrimestre(3);
        desempeno1.setEstado(EstadoDesempenoEstudiante.APROBADO);

        alumno1.addClase(desempeno1);
        clase1.addAlumno(desempeno1);

        desempeno1.setNotaPrimerTrimestre(3);
        desempeno1.setNotaSegundoTrimestre(2);
        desempeno1.setNotaTercerTrimestre(3);
        desempeno1.setNotaHabilitacion(1);

        DesempenoAlumno desempeno2 = new DesempenoAlumno("DA002", alumno1, clase2);

        desempeno2.setObservaciones("No entregó tareas a tiempo.");
        desempeno2.setEstado(EstadoDesempenoEstudiante.DESAPROBADO);

        alumno1.addClase(desempeno2);
        clase2.addAlumno(desempeno2);

        System.out.println(alumno1);
        System.out.println(clase1);
        System.out.println(clase2);
        System.out.println(desempeno1);
        System.out.println(desempeno2);

        // Asignación de alumnos a servicios complementarios por medio de la clase AsignacionAlumnoServicio
        System.out.println("\n----- ALUMNOS Y SERVICIOS COMPLEMENTARIOS -----\n");

        AsignacionAlumnoServicio asignacionAlumnoServicio1 = new AsignacionAlumnoServicio();
        asignacionAlumnoServicio1.setId("ASERV001");
        asignacionAlumnoServicio1.setAlumno(alumno1);
        asignacionAlumnoServicio1.setServicioComplementario(servicio1);
        asignacionAlumnoServicio1.setFechaInicioAsignacion(LocalDate.of(2025, 3, 1));
        asignacionAlumnoServicio1.setFechaFinAsignacion(LocalDate.of(2025, 11, 30));
        asignacionAlumnoServicio1.setEstado(EstadoAsignacionServicio.ACTIVA);

        alumno1.addServicioComplementario(asignacionAlumnoServicio1);
        servicio1.addAlumno(asignacionAlumnoServicio1);

        AsignacionAlumnoServicio asignacionAlumnoServicio2 = new AsignacionAlumnoServicio("ASERV002", alumno1, servicio2);
        asignacionAlumnoServicio2.setFechaInicioAsignacion(LocalDate.of(2025, 3, 1));
        asignacionAlumnoServicio2.setFechaFinAsignacion(LocalDate.of(2025, 6, 30));
        asignacionAlumnoServicio2.setEstado(EstadoAsignacionServicio.FINALIZADA);

        alumno1.addServicioComplementario(asignacionAlumnoServicio2);
        servicio2.addAlumno(asignacionAlumnoServicio2);

        System.out.println(alumno1);
        System.out.println(servicio1);
        System.out.println(servicio2);
        System.out.println(asignacionAlumnoServicio1);
        System.out.println(asignacionAlumnoServicio2);

        // Organización de las clases en bloques horarios por medio de la clase intermedia HorarioClase
        System.out.println("\n----- CLASES Y BLOQUES HORARIOS -----\n");

        HorarioClase horarioClase1 = new HorarioClase();
        horarioClase1.setId("HC001");
        horarioClase1.setClase(clase1);
        horarioClase1.setBloqueHorario(bloqueHorario1);

        clase1.addBloqueHorario(horarioClase1);
        bloqueHorario1.addClase(horarioClase1);

        HorarioClase horarioClase2 = new HorarioClase("HC002", clase1, bloqueHorario2);

        clase1.addBloqueHorario(horarioClase2);
        bloqueHorario2.addClase(horarioClase2);

        System.out.println(clase1);
        System.out.println(bloqueHorario1);
        System.out.println(bloqueHorario2);
        System.out.println(horarioClase1);
        System.out.println(horarioClase2);

        
        
        
        System.out.println("\033[1;31m-------------------------------------------------------------------------");
        System.out.println("\033[1;31m---------------------------------- CRUD ---------------------------------");
        System.out.println("\033[1;31m-------------------------------------------------------------------------");

        System.out.println("\n----- ALUMNOS -----\n");

        // Agrego al alumno 1 a la lista
        try {
            AlumnoCrud.agregar(alumno1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de alumnos que hay hasta el momento
        try {
            int total = AlumnoCrud.contarTodo();
            System.out.println("La cantidad de alumnos es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco al alumno con su codigo
        try {
            Alumno alumnoBuscado = AlumnoCrud.buscar("AL001");
            System.out.println(alumnoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco al alumno 2, que no existe
        try {
            Alumno alumnoBuscado = AlumnoCrud.buscar("AL002");
            System.out.println(alumnoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego al alumno 2 a la lista ahora si
        try {
            AlumnoCrud.agregar(alumno2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de alumno 1, y lo actualizo en la lista
        try {
            alumno1.setNombres("Maggie");
            alumno1.setEmail("pequenamaggie@udc.com");
            alumno1.setFechaNacimiento(LocalDate.of(2024, 10, 10));

            AlumnoCrud.editar(alumno1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar al alumno 1 modificado y al alumno 2
        System.out.println(AlumnoCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino al alumno 3, lo que no se puede porque no existe.
        try {
            AlumnoCrud.eliminar("AL003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino al alumno 2.
        try {
            AlumnoCrud.eliminar("AL002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocacioón solo debe mostrar al alumno 1
        System.out.println(AlumnoCrud.listarTodo());
        

        System.out.println("\n----- ADMINISTRATIVOS -----\n");

        // Agrego a administrativo 1 a la lista
        try {
            AdministrativoCrud.agregar(admin1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de administrativos que hay hasta el momento
        try {
            int total = AdministrativoCrud.contarTodo();
            System.out.println("La cantidad de administrativos es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a administrativo 1 con su codigo
        try {
            Administrativo administrativoBuscado = AdministrativoCrud.buscar("AD001");
            System.out.println(administrativoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a administrativo 2, que no existe
        try {
            Administrativo administrativoBuscado = AdministrativoCrud.buscar("AD002");
            System.out.println(administrativoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a administrativo 2 a la lista ahora si
        try {
            AdministrativoCrud.agregar(admin2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de administrativo 1, y lo actualizo en la lista
        try {
            admin1.setEmail("leo-miami@udc.com");
            admin1.setDireccion("Miami");
            admin1.setContrasena("quemiraboboandapalla");

            AdministrativoCrud.editar(admin1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a administrativo 1 modificado y a administrativo 2
        System.out.println(AdministrativoCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a administrativo 3, lo que no se puede porque no existe.
        try {
            AdministrativoCrud.eliminar("AD003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a administrativo 2.
        try {
            AdministrativoCrud.eliminar("AD002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a administrativo 1
        System.out.println(AdministrativoCrud.listarTodo());

        System.out.println("\n----- PROFESOR REGULAR -----\n");

        // Agrego a profesor regular 1 a la lista
        try {
            ProfesorRegularCrud.agregar(profesorRegular1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de profesores regulares que hay hasta el momento
        try {
            int total = ProfesorRegularCrud.contarTodo();
            System.out.println("La cantidad de profesores regulares es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a profesor regular 1 con su codigo
        try {
            ProfesorRegular profesoreRegularBuscado = ProfesorRegularCrud.buscar("PR001");
            System.out.println(profesoreRegularBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a profesor regular 2, que no existe
        try {
            ProfesorRegular profesoreRegularBuscado = ProfesorRegularCrud.buscar("PR002");
            System.out.println(profesoreRegularBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a profesor regular 2 a la lista ahora si
        try {
            ProfesorRegularCrud.agregar(profesorRegular2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de profesor regular 1, y lo actualizo en la lista
        try {
            profesorRegular1.setContrasena("velocidaddelaluz");
            profesorRegular1.setEmail("mc2@udc.com");

            ProfesorRegularCrud.editar(profesorRegular1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a profesor regular 1 modificado y a profesor regular 2
        System.out.println(ProfesorRegularCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a profesor regular 3, lo que no se puede porque no existe.
        try {
            ProfesorRegularCrud.eliminar("PR003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a profesor regular 2.
        try {
            ProfesorRegularCrud.eliminar("PR002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a profesor regular 1
        System.out.println(ProfesorRegularCrud.listarTodo());

        System.out.println("\n----- PROFESOR INFANTIL -----\n");

        // Agrego a profesor infantil 1 a la lista
        try {
            ProfesorInfantilCrud.agregar(profesorInfantil1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de profesores infantiles que hay hasta el momento
        try {
            int total = ProfesorInfantilCrud.contarTodo();
            System.out.println("La cantidad de profesores infantiles es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a profesor infantil 1 con su codigo
        try {
            ProfesorInfantil profesorInfantilBuscado = ProfesorInfantilCrud.buscar("PI001");
            System.out.println(profesorInfantilBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a profesor infantil 2, que no existe
        try {
            ProfesorInfantil profesorInfantilBuscado = ProfesorInfantilCrud.buscar("PI002");
            System.out.println(profesorInfantilBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a profesor infantil 2 a la lista ahora si
        try {
            ProfesorInfantilCrud.agregar(profesorInfantil2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de profesor infantil 1, y lo actualizo en la lista
        try {
            profesorInfantil1.setProfesion("Cientifico revolucionario");
            profesorInfantil1.setContrasena("ManzanaCae1");

            ProfesorInfantilCrud.editar(profesorInfantil1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a profesor infantil 1 modificado y a profesor infantil 2
        System.out.println(ProfesorInfantilCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a profesor infantil 3, lo que no se puede porque no existe.
        try {
            ProfesorInfantilCrud.eliminar("PI003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a profesor infantil 2.
        try {
            ProfesorInfantilCrud.eliminar("PI002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a profesor infantil 1
        System.out.println(ProfesorInfantilCrud.listarTodo());

        System.out.println("\n----- AULA -----\n");

        // Agrego a aula 1 a la lista
        try {
            AulaCrud.agregar(aula1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de aulas que hay hasta el momento
        try {
            int total = AulaCrud.contarTodo();
            System.out.println("La cantidad de aulas es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a aula 1 con su codigo
        try {
            Aula aulaBuscada = AulaCrud.buscar("AU-B205");
            System.out.println(aulaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a aula 2, que no existe
        try {
            Aula aulaBuscada = AulaCrud.buscar("AU-B206");
            System.out.println(aulaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a aula 2 a la lista ahora si
        try {
            AulaCrud.agregar(aula2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de aula 1, y lo actualizo en la lista
        try {
            aula1.setNombre("Bloque C salon 101");
            aula1.setUbicacion("Edificio C - Piso 1 - Salon 1");

            AulaCrud.editar(aula1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a aula 1 modificado y a aula 2
        System.out.println(AulaCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a aula 3, lo que no se puede porque no existe.
        try {
            AulaCrud.eliminar("AU-B210");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a aula 2.
        try {
            AulaCrud.eliminar("AU-B206");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a aula 1
        System.out.println(AulaCrud.listarTodo());

        System.out.println("\n----- NIVEL EDUCATIVO -----\n");

        // Agrego a nivel educativo 1 a la lista
        try {
            NivelEducativoCrud.agregar(nivel1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de niveles educativos que hay hasta el momento
        try {
            int total = NivelEducativoCrud.contarTodo();
            System.out.println("La cantidad de niveles educativos es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a nivel educativo 1 con su codigo
        try {
            NivelEducativo nivelBuscado = NivelEducativoCrud.buscar("NE001");
            System.out.println(nivelBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a nivel educativo 2, que no existe
        try {
            NivelEducativo nivelBuscado = NivelEducativoCrud.buscar("NE002");
            System.out.println(nivelBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a nivel educativo 2 a la lista ahora si
        try {
            NivelEducativoCrud.agregar(nivel2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de nivel educativo 1, y lo actualizo en la lista
        try {

            nivel1.setNombre("Ciclo intermedio de educación infantil");
            nivel1.setDescripcion("Nivel para niños de 2 a 8 años.");
            nivel1.setTipo(TipoNivelEducativo.PRIMARIA);

            NivelEducativoCrud.editar(nivel1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a nivel educativo 1 modificado y a nivel educativo 2
        System.out.println(NivelEducativoCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a nivel educativo 3, lo que no se puede porque no existe.
        try {
            NivelEducativoCrud.eliminar("NE003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a nivel educativo 2.
        try {
            NivelEducativoCrud.eliminar("NE002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a nivel educativo 1
        System.out.println(NivelEducativoCrud.listarTodo());
        
        

        System.out.println("\n----- MODALIDAD -----\n");

        // Agrego a modalidad 1 a la lista
        try {
            ModalidadCrud.agregar(modalidad1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de modalidades que hay hasta el momento
        try {
            int total = ModalidadCrud.contarTodo();
            System.out.println("La cantidad de modalidades es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a modalidad 1 con su codigo
        try {
            Modalidad modalidadBuscada = ModalidadCrud.buscar("MOD001");
            System.out.println(modalidadBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a modalidad 2, que no existe
        try {
            Modalidad modalidadBuscada = ModalidadCrud.buscar("MOD002");
            System.out.println(modalidadBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a modalidad 2 a la lista ahora si
        try {
            ModalidadCrud.agregar(modalidad2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de modalidad 1, y lo actualizo en la lista
        try {
            modalidad1.setNombre("Humanidades");
            modalidad1.setDescripcion("Bachillerato enfocado en las ciencias humanas.");

            ModalidadCrud.editar(modalidad1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a modalidad 1 modificado y a modalidad 2
        System.out.println(ModalidadCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a modalidad 3, lo que no se puede porque no existe.
        try {
            ModalidadCrud.eliminar("MOD003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a modalidad 2.
        try {
            ModalidadCrud.eliminar("MOD002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a modalidad 1
        System.out.println(ModalidadCrud.listarTodo());
        
        
        
        System.out.println("\n----- CURSO -----\n");

        // Agrego a curso 1 a la lista
        try {
            CursoCrud.agregar(curso1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de cursos que hay hasta el momento
        try {
            int total = CursoCrud.contarTodo();
            System.out.println("La cantidad de cursos es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a curso 1 con su codigo
        try {
            Curso cursoBuscado = CursoCrud.buscar("C001");
            System.out.println(cursoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a curso 2, que no existe
        try {
            Curso cursoBuscado = CursoCrud.buscar("C002");
            System.out.println(cursoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a curso 2 a la lista ahora si
        try {
            CursoCrud.agregar(curso2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de curso 1, y lo actualizo en la lista
        try {
            curso1.setNombre("Pre-Jardin");

            CursoCrud.editar(curso1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a curso 1 modificado y a curso 2
        System.out.println(CursoCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a curso 3, lo que no se puede porque no existe.
        try {
            CursoCrud.eliminar("C003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a curso 2.
        try {
            CursoCrud.eliminar("C002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a curso 1
        System.out.println(CursoCrud.listarTodo());
        
        
        
        
        System.out.println("\n----- CICLO ACADEMICO -----\n");

        // Agrego a ciclo academico 1 a la lista
        try {
            CicloAcademicoCrud.agregar(ciclo2024);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de ciclos academicos que hay hasta el momento
        try {
            int total = CicloAcademicoCrud.contarTodo();
            System.out.println("La cantidad de ciclos academicos es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a ciclo academico 1 con su codigo
        try {
            CicloAcademico cicloBuscado = CicloAcademicoCrud.buscar("CA001");
            System.out.println(cicloBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a ciclo academico 2, que no existe
        try {
            CicloAcademico cicloBuscado = CicloAcademicoCrud.buscar("CA002");
            System.out.println(cicloBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a ciclo academico 2 a la lista ahora si
        try {
            CicloAcademicoCrud.agregar(ciclo2025);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de ciclo academico 1, y lo actualizo en la lista
        try {
            ciclo2024.setCantidadSemanas(34);
            ciclo2024.setFechaFin(LocalDate.of(2024, 12, 15));

            CicloAcademicoCrud.editar(ciclo2024);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a ciclo academico 1 modificado y a ciclo academico 2
        System.out.println(CicloAcademicoCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a ciclo academico 3, lo que no se puede porque no existe.
        try {
            CicloAcademicoCrud.eliminar("CA003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a ciclo academico 2.
        try {
            CicloAcademicoCrud.eliminar("CA002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a ciclo academico 1
        System.out.println(CicloAcademicoCrud.listarTodo());
        
        
        
        System.out.println("\n----- GRUPO INFANTIL -----\n");

        // Agrego a grupo infantil 1 a la lista
        try {
            GrupoInfantilCrud.agregar(grupoInfantil1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de grupos infantiles que hay hasta el momento
        try {
            int total = GrupoInfantilCrud.contarTodo();
            System.out.println("La cantidad de grupos infantiles es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a grupo infantil 1 con su codigo
        try {
            GrupoInfantil grupoInfantilBuscado = GrupoInfantilCrud.buscar("GI001");
            System.out.println(grupoInfantilBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a grupo infantil 2, que no existe
        try {
            GrupoInfantil grupoInfantilBuscado = GrupoInfantilCrud.buscar("GI002");
            System.out.println(grupoInfantilBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a grupo infantil 2 a la lista ahora si
        try {
            GrupoInfantilCrud.agregar(grupoInfantil2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de grupo infantil 1, y lo actualizo en la lista
        try {
            grupoInfantil1.setNombre("Jardín C 2024");
            grupoInfantil1.setCicloAcademico(ciclo2024);

            GrupoInfantilCrud.editar(grupoInfantil1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a grupo infantil 1 modificado y a grupo infantil 2
        System.out.println(GrupoInfantilCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a grupo infantil 3, lo que no se puede porque no existe.
        try {
            GrupoInfantilCrud.eliminar("GI003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a grupo infantil 2.
        try {
            GrupoInfantilCrud.eliminar("GI002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a grupo infantil 1
        System.out.println(GrupoInfantilCrud.listarTodo());
        
        
        
        System.out.println("\n----- GRUPO REGULAR -----\n");

        // Agrego a grupo regular 1 a la lista
        try {
            GrupoRegularCrud.agregar(grupoRegular1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de grupos regulares que hay hasta el momento
        try {
            int total = GrupoRegularCrud.contarTodo();
            System.out.println("La cantidad de grupos regulares es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a grupo regular 1 con su codigo
        try {
            GrupoRegular grupoRegularBuscado = GrupoRegularCrud.buscar("GR001");
            System.out.println(grupoRegularBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a grupo regular 2, que no existe
        try {
            GrupoRegular grupoRegularBuscado = GrupoRegularCrud.buscar("GR002");
            System.out.println(grupoRegularBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a grupo regular 2 a la lista ahora si
        try {
            GrupoRegularCrud.agregar(grupoRegular2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de grupo regular 1, y lo actualizo en la lista
        try {
            grupoRegular1.setNombre("Tercero Bachillerato D 2025");
            grupoRegular1.setProfesorEncargado(profesorRegular2);

            GrupoRegularCrud.editar(grupoRegular1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a grupo regular 1 modificado y a grupo regular 2
        System.out.println(GrupoRegularCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a grupo regular 3, lo que no se puede porque no existe.
        try {
            GrupoRegularCrud.eliminar("GR003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a grupo regular 2.
        try {
            GrupoRegularCrud.eliminar("GR002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a grupo regular 1
        System.out.println(GrupoRegularCrud.listarTodo());
        
        
        
        System.out.println("\n----- ASIGNATURA -----\n");

        // Agrego a asignatura 1 a la lista
        try {
            AsignaturaCrud.agregar(asignatura1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de asignaturas que hay hasta el momento
        try {
            int total = AsignaturaCrud.contarTodo();
            System.out.println("La cantidad de asignaturas es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a asignatura 1 con su codigo
        try {
            Asignatura asignaturaBuscada = AsignaturaCrud.buscar("AS001");
            System.out.println(asignaturaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a asignatura 2, que no existe
        try {
            Asignatura asignaturaBuscada = AsignaturaCrud.buscar("AS002");
            System.out.println(asignaturaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a asignatura 2 a la lista ahora si
        try {
            AsignaturaCrud.agregar(asignatura2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de asignatura 1, y lo actualizo en la lista
        try {
            asignatura1.setNombre("Álgebra");
            asignatura1.setDescripcion("Estudio de las operaciones aritméticas.");

            AsignaturaCrud.editar(asignatura1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a asignatura 1 modificado y a asignatura 2
        System.out.println(AsignaturaCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a asignatura 3, lo que no se puede porque no existe.
        try {
            AsignaturaCrud.eliminar("AS003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a asignatura 2.
        try {
            AsignaturaCrud.eliminar("AS002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a asignatura 1
        System.out.println(AsignaturaCrud.listarTodo());




System.out.println("\n----- BLOQUE HORARIO -----\n");

        // Agrego a bloque horario 1 a la lista
        try {
            BloqueHorarioCrud.agregar(bloqueHorario1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de bloques horarios que hay hasta el momento
        try {
            int total = BloqueHorarioCrud.contarTodo();
            System.out.println("La cantidad de bloques horarios es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a bloque horario 1 con su codigo
        try {
            BloqueHorario bloqueHorarioBuscado = BloqueHorarioCrud.buscar("BH001");
            System.out.println(bloqueHorarioBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a bloque horario 2, que no existe
        try {
            BloqueHorario bloqueHorarioBuscado = BloqueHorarioCrud.buscar("BH002");
            System.out.println(bloqueHorarioBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a bloque horario 2 a la lista ahora si
        try {
            BloqueHorarioCrud.agregar(bloqueHorario2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de bloque horario 1, y lo actualizo en la lista
        try {
            bloqueHorario1.setDia(DiaSemana.JUEVES);
            bloqueHorario1.setHoraInicio(LocalTime.of(7, 0));
            bloqueHorario1.setHoraFin(LocalTime.of(8, 30));

            BloqueHorarioCrud.editar(bloqueHorario1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a bloque horario 1 modificado y a bloque horario 2
        System.out.println(BloqueHorarioCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a bloque horario 3, lo que no se puede porque no existe.
        try {
            BloqueHorarioCrud.eliminar("BH003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a bloque horario 2.
        try {
            BloqueHorarioCrud.eliminar("BH002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a bloque horario 1
        System.out.println(BloqueHorarioCrud.listarTodo());



System.out.println("\n----- CLASE -----\n");

        // Agrego a clase 1 a la lista
        try {
            ClaseCrud.agregar(clase1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de clases que hay hasta el momento
        try {
            int total = ClaseCrud.contarTodo();
            System.out.println("La cantidad de clases es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a clase 1 con su codigo
        try {
            Clase claseBuscada = ClaseCrud.buscar("CL001");
            System.out.println(claseBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a clase 2, que no existe
        try {
            Clase claseBuscada = ClaseCrud.buscar("CL002");
            System.out.println(claseBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a clase 2 a la lista ahora si
        try {
            ClaseCrud.agregar(clase2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de clase 1, y lo actualizo en la lista
        try {
            clase1.setGrupo(grupoRegular2);

            ClaseCrud.editar(clase1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a clase 1 modificado y a clase 2
        System.out.println(ClaseCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a clase 3, lo que no se puede porque no existe.
        try {
            ClaseCrud.eliminar("CL003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a clase 2.
        try {
            ClaseCrud.eliminar("CL002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a clase 1
        System.out.println(ClaseCrud.listarTodo());





System.out.println("\n----- SESION -----\n");

        // Agrego a sesion 1 a la lista
        try {
            SesionCrud.agregar(sesion1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de sesiones que hay hasta el momento
        try {
            int total = SesionCrud.contarTodo();
            System.out.println("La cantidad de sesiones es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a sesion 1 con su codigo
        try {
            Sesion sesionBuscada = SesionCrud.buscar("S001");
            System.out.println(sesionBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a sesion 2, que no existe
        try {
            Sesion sesionBuscada = SesionCrud.buscar("S002");
            System.out.println(sesionBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a sesion 2 a la lista ahora si
        try {
            SesionCrud.agregar(sesion2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de sesion 1, y lo actualizo en la lista
        try {
            sesion1.setSemana(6);
            sesion1.setBloqueHorario(bloqueHorario2);

            SesionCrud.editar(sesion1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a sesion 1 modificado y a sesion 2
        System.out.println(SesionCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a sesion 3, lo que no se puede porque no existe.
        try {
            SesionCrud.eliminar("S003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a sesion 2.
        try {
            SesionCrud.eliminar("S002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a sesion 1
        System.out.println(SesionCrud.listarTodo());





System.out.println("\n----- BECA -----\n");

        // Agrego a beca 1 a la lista
        try {
            BecaCrud.agregar(beca1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de becas que hay hasta el momento
        try {
            int total = BecaCrud.contarTodo();
            System.out.println("La cantidad de becas es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a beca 1 con su codigo
        try {
            Beca becaBuscada = BecaCrud.buscar("B001");
            System.out.println(becaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a beca 2, que no existe
        try {
            Beca becaBuscada = BecaCrud.buscar("B002");
            System.out.println(becaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a beca 2 a la lista ahora si
        try {
            BecaCrud.agregar(beca2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de beca 1, y lo actualizo en la lista
        try {
            beca1.setNombre("Beca Ecopetrol");
            beca1.setDescripcion("Otorgada al mejor estudiante del curso.");

            BecaCrud.editar(beca1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a beca 1 modificado y a beca 2
        System.out.println(BecaCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a beca 3, lo que no se puede porque no existe.
        try {
            BecaCrud.eliminar("B003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a beca 2.
        try {
            BecaCrud.eliminar("B002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a beca 1
        System.out.println(BecaCrud.listarTodo());







System.out.println("\n----- MATRICULA -----\n");

        // Agrego a matricula 1 a la lista
        try {
            MatriculaCrud.agregar(matricula1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de matriculas que hay hasta el momento
        try {
            int total = MatriculaCrud.contarTodo();
            System.out.println("La cantidad de matriculas es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a matricula 1 con su codigo
        try {
            Matricula matriculaBuscada = MatriculaCrud.buscar("M001");
            System.out.println(matriculaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a matricula 2, que no existe
        try {
            Matricula matriculaBuscada = MatriculaCrud.buscar("M002");
            System.out.println(matriculaBuscada);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a matricula 2 a la lista ahora si
        try {
            MatriculaCrud.agregar(matricula2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de matricula 1, y lo actualizo en la lista
        try {
            matricula1.setEstado(EstadoMatricula.CANCELADA);
            matricula1.setObservaciones("El estudiante se retira del colegio.");


            MatriculaCrud.editar(matricula1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a matricula 1 modificado y a matricula 2
        System.out.println(MatriculaCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a matricula 3, lo que no se puede porque no existe.
        try {
            MatriculaCrud.eliminar("M003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a matricula 2.
        try {
            MatriculaCrud.eliminar("M002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a matricula 1
        System.out.println(MatriculaCrud.listarTodo());





System.out.println("\n----- CONTRATO -----\n");

        // Agrego a contrato 1 a la lista
        try {
            ContratoCrud.agregar(contrato1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de contratos que hay hasta el momento
        try {
            int total = ContratoCrud.contarTodo();
            System.out.println("La cantidad de contratos es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a contrato 1 con su codigo
        try {
            Contrato contratoBuscado = ContratoCrud.buscar("CON001");
            System.out.println(contratoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a contrato 2, que no existe
        try {
            Contrato contratoBuscado = ContratoCrud.buscar("CON002");
            System.out.println(contratoBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a contrato 2 a la lista ahora si
        try {
            ContratoCrud.agregar(contrato2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de contrato 1, y lo actualizo en la lista
        try {
            contrato1.setValorSalario(7000000);
            contrato1.setEstado(EstadoContrato.EN_PROYECCION);

            ContratoCrud.editar(contrato1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a contrato 1 modificado y a contrato 2
        System.out.println(ContratoCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a contrato 3, lo que no se puede porque no existe.
        try {
            ContratoCrud.eliminar("CON003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a contrato 2.
        try {
            ContratoCrud.eliminar("CON002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a contrato 1
        System.out.println(ContratoCrud.listarTodo());





System.out.println("\n----- SERVICIO COMPLEMENTARIO -----\n");

        // Agrego a servicio complementario 1 a la lista
        try {
            ServicioComplementarioCrud.agregar(servicio1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Cuento la cantidad de servicios complementarios que hay hasta el momento
        try {
            int total = ServicioComplementarioCrud.contarTodo();
            System.out.println("La cantidad de servicios complementarios es " + total);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a servicio complementario 1 con su codigo
        try {
            ServicioComplementario servicioBuscado = ServicioComplementarioCrud.buscar("SC001");
            System.out.println(servicioBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Busco a servicio complementario 2, que no existe
        try {
            ServicioComplementario servicioBuscado = ServicioComplementarioCrud.buscar("SC002");
            System.out.println(servicioBuscado);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Agrego a servicio complementario 2 a la lista ahora si
        try {
            ServicioComplementarioCrud.agregar(servicio2);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Edito las propiedades de servicio complementario 1, y lo actualizo en la lista
        try {
            servicio1.setNombre("Biblioteca");
            servicio1.setDescripcion("Prestamo de libros y otros materiales.");


            ServicioComplementarioCrud.editar(servicio1);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo. Debe mostrar a servicio complementario 1 modificado y a servicio complementario 2
        System.out.println(ServicioComplementarioCrud.listarTodo());

        Thread.sleep(10);

        // Ahora elimino a servicio complementario 3, lo que no se puede porque no existe.
        try {
            ServicioComplementarioCrud.eliminar("SC003");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora si elimino a servicio complementario 2.
        try {
            ServicioComplementarioCrud.eliminar("SC002");
        } catch (Exception ex) {
            System.err.println(ex);
        }

        Thread.sleep(10);

        // Ahora listo todo nuevamente, en esta ocasión solo debe mostrar a servicio complementario 1
        System.out.println(ServicioComplementarioCrud.listarTodo());
        
        
    }*/
    
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Prueba base de datos");
        
        ConexionBD.conectar();
        
        ConexionBD.desconectar();
        
    }

}
