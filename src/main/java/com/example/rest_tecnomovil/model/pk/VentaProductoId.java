package com.example.rest_tecnomovil.model.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class VentaProductoId {

    private Integer ventaid;
    private Integer productoid;

}
