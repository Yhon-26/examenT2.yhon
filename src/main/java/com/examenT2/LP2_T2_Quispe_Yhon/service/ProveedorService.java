package com.examenT2.LP2_T2_Quispe_Yhon.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.examenT2.LP2_T2_Quispe_Yhon.model.ProveedorQuispeYhon;
import com.examenT2.LP2_T2_Quispe_Yhon.repository.ProveedorRepository;

@Service
@RequiredArgsConstructor
public class ProveedorService {

	private final ProveedorRepository proveedorRepository;

	public List<ProveedorQuispeYhon> getAll() {
		return proveedorRepository.findAll();
	}
}
