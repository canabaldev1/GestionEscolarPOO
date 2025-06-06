package CrudBD;

import Dominio.GrupoInfantil;
import Infraestructura.Configuracion.BD.ConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lm-carlos
 */
public class GrupoInfantilCrudBD {

    private EntityManagerFactory conexion;

    public GrupoInfantilCrudBD() {
        conexion = ConexionBD.conectar();
    }

    // GUARDAR
    public void guardar(GrupoInfantil grupoInfantil) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.persist(grupoInfantil);

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar grupo infantil " + grupoInfantil.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // BUSCAR POR ID
    public GrupoInfantil buscar(Long id) throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.find(GrupoInfantil.class, id);
        } catch (Exception e) {
            throw new Exception("Error al buscar grupo infantil con ID " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ACTUALIZAR
    public void actualizar(GrupoInfantil grupoInfantil) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.merge(grupoInfantil); // Actualiza

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar grupo infantil " + grupoInfantil.getId() + ": " + e.getMessage(), e);
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

            GrupoInfantil grupoInfantilBuscado = entityManager.find(GrupoInfantil.class, id);
            if (grupoInfantilBuscado != null) {
                entityManager.remove(grupoInfantilBuscado);
            } else {
                throw new Exception("No se encontró grupo infantil con ID " + id);
            }

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar grupo infantil " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // LISTAR TODOS
    public List<GrupoInfantil> listarTodos() throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.createQuery("SELECT c FROM GrupoInfantil c", GrupoInfantil.class)
                                .getResultList();
        } catch (Exception e) {
            throw new Exception("Error al listar grupo infantil: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
