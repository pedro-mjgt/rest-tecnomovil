package com.example.rest_tecnomovil.util.convert;

import com.example.rest_tecnomovil.dto.VentaDto;
import com.example.rest_tecnomovil.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaConvert {

    public VentaDto convertirVentaADto(Venta venta) {
        return VentaDto.builder()
                .ventaid(venta.getVentaid())
                .fecha(venta.getFecha())
                .clienteid(venta.getCliente().getClienteid())
                .build();
    }

}
