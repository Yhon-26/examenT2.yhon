package com.examenT2.LP2_T2_Quispe_Yhon.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.examenT2.LP2_T2_Quispe_Yhon.model.RubroQuispeYhon;
import com.examenT2.LP2_T2_Quispe_Yhon.repository.RubroRepository;

@Service
@RequiredArgsConstructor
public class RubroService {

	private final RubroRepository rubroRepository;

	public List<RubroQuispeYhon> getAll() {
		return rubroRepository.findAll();
	}
}
