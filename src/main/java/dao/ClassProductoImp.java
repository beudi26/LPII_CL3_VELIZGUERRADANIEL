package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProducto;
import model.TblProductocl3;

public class ClassProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(producto);
		System.out.println("Producto registrado correctamente");
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager emanager=em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(producto);
		System.out.println("Producto Actualizado en la BD");
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager emanager=em.createEntityManager();
		emanager.getTransaction().begin();
		TblProductocl3 elim=emanager.merge(producto);
		emanager.remove(elim);
		System.out.println("Producto eliminado de la BD");
		emanager.getTransaction().commit();
		emanager.close();
	}

	@Override
	public List<TblProductocl3> ListarProducto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl3> listado = em.createQuery("SELECT p FROM TblProductocl3 p",TblProductocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listado;
	}

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager em=fabr.createEntityManager();
		em.getTransaction().begin();
		TblProductocl3 busproducto=em.find(TblProductocl3.class,producto.getIdproductoscl3());
		em.getTransaction().commit();
		em.close();
		return busproducto;
	}

}
