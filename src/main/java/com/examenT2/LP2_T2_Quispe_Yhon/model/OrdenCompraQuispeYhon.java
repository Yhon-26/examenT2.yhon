package com.examenT2.LP2_T2_Quispe_Yhon.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class OrdenCompraQuispeYhon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private ProveedorQuispeYhon proveedor;

	@Column(name = "monto", precision = 10, scale = 2)
	private BigDecimal monto;

	@Column(name = "direccion_entrega", length = 255)
	private String direccionEntrega;

	@Column(name = "fecha_entrega")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEntrega;

	@Column(name = "estado", columnDefinition = "char(1)", length = 1)
	private String estado;
}
