package arq.soft.arqSoft1.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import arq.soft.arqSoft1.entitys.Producto;

@Repository
public class ProductoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Producto> obtenerProductosByNombreYDescripcion(String nombreDescripcion, double precioMinimo, double precioMax){
		List<Predicate> predicados = new ArrayList<Predicate>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);

        Root<Producto> prod = cq.from(Producto.class);
        if(!StringUtils.isBlank(nombreDescripcion)) {
        	Predicate busquedaNombre = cb.like(prod.get("nombre"), "%" + nombreDescripcion + "%");
        	Predicate busquedaDescripcion = cb.like(prod.get("descripcion"), "%" + nombreDescripcion + "%");
        	Predicate busquedaDetalle = cb.or(busquedaNombre,busquedaDescripcion);
 
        	predicados.add(busquedaDetalle);
        }
        if(precioMinimo > 0) {
        	Predicate busquedaPrecioMin = cb.greaterThan(prod.get("precio").as(Double.class), precioMinimo);
        	predicados.add(busquedaPrecioMin);
        }
        if(precioMax > 0) {
        	Predicate busquedaPrecioMax = cb.lessThan(prod.get("precio").as(Double.class), precioMax);
        	predicados.add(busquedaPrecioMax);
        }

       	cq.where(predicados.toArray(new Predicate[0]));
        TypedQuery<Producto> query = em.createQuery(cq);
        return query.getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
