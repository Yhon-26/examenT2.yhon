package com.examenT2.LP2_T2_Quispe_Yhon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.RequiredArgsConstructor;
import com.examenT2.LP2_T2_Quispe_Yhon.model.OrdenCompraQuispeYhon;
import com.examenT2.LP2_T2_Quispe_Yhon.service.OrdenCompraService;
import com.examenT2.LP2_T2_Quispe_Yhon.service.ProveedorService;
import com.examenT2.LP2_T2_Quispe_Yhon.util.Alert;

@Controller
@RequestMapping("ordencompra")
@RequiredArgsConstructor
public class OrdenCompraController {

	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrdenesCompra", ordenCompraService.getAll());
		return "ordencompra/listadoQuispeYhon";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", new OrdenCompraQuispeYhon());
		return "ordencompra/nuevoQuispeYhon";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraQuispeYhon ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.create(ordenCompra);
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), response.success() ? "success" : "error", 5000));
		return "redirect:/ordencompra/listado";
	}

	@GetMapping("edicion/{nroOrden}")
	public String edicion(@PathVariable Integer nroOrden, Model model, RedirectAttributes flash) {
		var ordenCompra = ordenCompraService.getOne(nroOrden);
		if (ordenCompra == null) {
			flash.addFlashAttribute("alert", Alert.sweetToast("Orden de compra no encontrada", "error", 5000));
			return "redirect:/ordencompra/listado";
		}
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", ordenCompra);
		return "ordencompra/edicionQuispeYhon";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraQuispeYhon ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.update(ordenCompra);
		flash.addFlashAttribute("alert", Alert.sweetToast(response.mensaje(), response.success() ? "success" : "error", 5000));
		return "redirect:/ordencompra/listado";
	}
}
