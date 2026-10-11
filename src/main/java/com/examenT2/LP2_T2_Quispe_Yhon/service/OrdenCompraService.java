package com.examenT2.LP2_T2_Quispe_Yhon.service;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.examenT2.LP2_T2_Quispe_Yhon.model.OrdenCompraQuispeYhon;
import com.examenT2.LP2_T2_Quispe_Yhon.repository.OrdenCompraRepository;
import com.examenT2.LP2_T2_Quispe_Yhon.dto.ResultadoResponse;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {

	private final OrdenCompraRepository ordenCompraRepository;

	public List<OrdenCompraQuispeYhon> getAll() {
		return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
	}

	public OrdenCompraQuispeYhon getOne(Integer nroOrden) {
		return ordenCompraRepository.findById(nroOrden).orElse(null);
	}

	@Transactional
	public ResultadoResponse create(OrdenCompraQuispeYhon ordenCompra) {
		try {
			var registrada = ordenCompraRepository.save(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d registrada.", registrada.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	@Transactional
	public ResultadoResponse update(OrdenCompraQuispeYhon ordenCompra) {
		try {
			var registrada = ordenCompraRepository.save(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d actualizada.", registrada.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
