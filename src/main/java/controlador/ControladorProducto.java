package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassProductoImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }//fin del controlador

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassProductoImp crud = new ClassProductoImp();
		List<TblProductocl3> listarproducto = crud.ListarProducto();
		request.setAttribute("listadoproductos", listarproducto);
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
	}//fin del metodo do get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombrecl3 = request.getParameter("nombre");
		Double precioventacl3 = Double.parseDouble(request.getParameter("precioventa"));
		Double preciocompracl3 = Double.parseDouble(request.getParameter("preciocompra"));
		String estadocl3 = request.getParameter("estado");
		String descripcl3 = request.getParameter("descrip");
		
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl3(nombrecl3);
		producto.setPrecioventacl3(precioventacl3);
		producto.setPreciocompcl3(preciocompracl3);
		producto.setEstadocl3(estadocl3);
		producto.setDescripcl3(descripcl3);
		crud.RegistrarProducto(producto);
		
		List<TblProductocl3> listarProducto = crud.ListarProducto();
		request.setAttribute("listadoproductos", listarProducto);
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
	}//fin del metodo do post

}//fin del servlet
