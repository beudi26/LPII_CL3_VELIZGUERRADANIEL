package test;

import java.util.List;

import dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();

		/*
		//Testeamos el metodo registrar
				producto.setNombrecl3("Gaseosa");
				producto.setPrecioventacl3(3.50);
				producto.setPreciocompcl3(2.50);
				producto.setEstadocl3("Buenisimo");
				producto.setDescripcl3("Gaseosa Inca Kola 1L");
				crud.RegistrarProducto(producto);
				
		*/
		
		//Testeamos el metodo listar
				List<TblProductocl3> listarProducto = crud.ListarProducto();
				for(TblProductocl3 p:listarProducto){
					System.out.println("Código: "+p.getIdproductoscl3()+"\n"+
										"Nombre: "+p.getNombrecl3()+"\n"+
										"Precio de Venta: "+p.getPrecioventacl3()+"\n"+
										"Precio de Compra: "+p.getPreciocompcl3()+"\n"+
										"Estado: "+p.getEstadocl3()+"\n"+
										"Descripción: "+p.getDescripcl3()+"\n");
				}//fin del bucle for
		
	}

}
