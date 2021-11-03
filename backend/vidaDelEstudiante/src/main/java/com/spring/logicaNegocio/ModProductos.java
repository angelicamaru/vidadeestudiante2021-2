
package com.spring.logicaNegocio;

import basededatos.ConexionProducto;
import com.entidades.Producto;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ModProductos {
    
    ConexionProducto con;
    
    
     public ArrayList getProductos() {
        con = new ConexionProducto();
        ArrayList productos = con.traerProducto();
        con.desconectar();
        return productos;
    }
    
}
