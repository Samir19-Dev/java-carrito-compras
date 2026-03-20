
import com.practica.samir.config.Conexion;
import com.practica.samir.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO {

    public ArrayList<Producto> ListarTodos() {
        // Variables fuera del try-catch
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Producto> lista = new ArrayList<Producto>(); // Inicialización de la lista

        try {
            // Establecer la conexión a la base de datos
            cn = Conexion.getConnection();
            String sql = "select * from Producto"; // Consulta SQL
            ps = cn.prepareStatement(sql); // Preparar la consulta
            rs = ps.executeQuery(); // Ejecutar la consulta

            // Iterar sobre el resultado
            while (rs.next()) {
                Producto obj = new Producto();
                obj.setIdProd(rs.getInt("id_prod"));
                obj.setNombre(rs.getString("nombre"));
                obj.setPrecio(rs.getDouble("precio"));
                obj.setImagen(rs.getString("imagen"));
                lista.add(obj); // Añadir el objeto a la lista
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Manejo de excepciones
        } finally {
            try {
                // Cerrar los recursos
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // Manejo de excepciones de cierre de recursos
            }
        }

        return lista; // Retornar la lista con los productos
    }
}
