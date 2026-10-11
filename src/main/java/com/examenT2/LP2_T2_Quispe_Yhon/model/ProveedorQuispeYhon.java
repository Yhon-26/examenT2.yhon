package com.examenT2.LP2_T2_Quispe_Yhon.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_proveedor")
@Getter
@Setter
public class ProveedorQuispeYhon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "ruc", columnDefinition = "char(11)", length = 11)
	private String ruc;

	@Column(name = "razon_social", length = 50)
	private String razonSocial;

	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;

	@Column(name = "direccion", length = 100)
	private String direccion;

	@Column(name = "pagina_web", length = 100)
	private String paginaWeb;

	@ManyToOne
	@JoinColumn(name = "id_rubro")
	private RubroQuispeYhon rubro;
}
