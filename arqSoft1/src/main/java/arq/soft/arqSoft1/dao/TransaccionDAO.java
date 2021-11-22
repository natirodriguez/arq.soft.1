package arq.soft.arqSoft1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import arq.soft.arqSoft1.entitys.Transaccion;

public interface TransaccionDAO extends JpaRepository<Transaccion,Long>  {

}
