package com.examenT2.LP2_T2_Quispe_Yhon.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examenT2.LP2_T2_Quispe_Yhon.model.OrdenCompraQuispeYhon;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraQuispeYhon, Integer> {

	List<OrdenCompraQuispeYhon> findAllByOrderByNroOrdenDesc();
}
