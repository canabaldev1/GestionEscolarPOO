package CrudBD;

import Dominio.CicloAcademico;
import Infraestructura.Configuracion.BD.ConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lm-carlos
 */
public class CicloAcademicoCrudBD {

    private EntityManagerFactory conexion;

    public CicloAcademicoCrudBD() {
        conexion = ConexionBD.conectar();
    }

    // GUARDAR
    public void guardar(CicloAcademico cicloAcademico) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.persist(cicloAcademico);

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar ciclo académico " + cicloAcademico.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // BUSCAR POR ID
    public CicloAcademico buscar(Long id) throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.find(CicloAcademico.class, id);
        } catch (Exception e) {
            throw new Exception("Error al buscar ciclo académico con ID " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ACTUALIZAR
    public void actualizar(CicloAcademico cicloAcademico) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.merge(cicloAcademico); // Actualiza

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar ciclo académico " + cicloAcademico.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ELIMINAR
    public void eliminar(String id) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            CicloAcademico ciclo = entityManager.find(CicloAcademico.class, id);
            if (ciclo != null) {
                entityManager.remove(ciclo);
            } else {
                throw new Exception("No se encontró el ciclo académico con ID " + id);
            }

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar ciclo académico " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // LISTAR TODOS
    public List<CicloAcademico> listarTodos() throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.createQuery("SELECT c FROM CicloAcademico c", CicloAcademico.class)
                                .getResultList();
        } catch (Exception e) {
            throw new Exception("Error al listar los ciclos académicos: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}

