/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelo.Usuario;


/**
 *
 * @author javs
 */
public class UsuarioDAO {
    
    private static final String SQL_INSERT = "insert into usuarioo(nombre,aPaterno,aMaterno,email,nombreUsuario,claveUsuario,tipoUsuario) values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update usuarioo set nombre=?,aPeterno=?,aMaterno=?,email=?,nombreUsuario=?,tipoUsuario=? where idUsuario=?";
    private static final String SQL_DELETE = "delete from usuarioo where idUsuario=?";
    private static final String SQL_SELECT ="select * from usuarioo where idUsuario=?";
    private static final String SQL_SELECT_ALL ="select * from usuarioo";
    private static final String SQL_GRAFICAR ="{call spDatosGrafica()}";
    
    
    private static final String SQL_INSERTALUMNO = "insert into alumnos(nombre,paterno,carrera_id1) values(?,?,?)";
    private static final String SQL_UPDATEALUMNO = "update alumnos set nombre=?,aPeterno=?,aMaterno=?,email=?,nombreUsuario=?,tipoUsuario=? where idUsuario=?";
    private static final String SQL_DELETEALUMNO = "delete from alumnos where idAlumnos=?";
    private static final String SQL_SELECTALUMNO ="select * from alumnos where idAlumnos=?";
    private static final String SQL_SELECT_ALLALUMNO ="select * from alumnos";
    private static final String SQL_GRAFICARALUMNO ="{call spDatosGrafica()}";
    
    private String url = "jdbc:mysql://localhost:3306/Usuario";
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String password = "root";
	private Connection conexionDB = null;

	public UsuarioDAO() {
		this.conexionDB = conectar(this.url, this.driver, this.usuario,
				this.password);
                
                System.out.println("conexion establecida");
	}

	public Connection conectar(String url, String driver, String usuario,
			String password) {
		try {

			Class.forName(driver);

			java.sql.Connection con = DriverManager.getConnection(url, usuario,
					password);

			// System.out.println("Conexion establecida");

			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    
    //private Connection con = null;
    public void create(Usuario usuario)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getaPaterno());
            ps.setString(3, usuario.getaMaterno());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getUsuario());
            ps.setString(6, usuario.getClave());
            ps.setString(7, usuario.getTipoUsuario());
            //ps.setInt(8,1);
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
    public void createAlumno(Alumno alumno)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERTALUMNO);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getPaterno());//checar
            ps.setInt(3, alumno.getCarrera());
            //ps.setInt(8,1);
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
    
    
    public void update(Usuario usuario)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERT);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getaPaterno());
            ps.setString(3, usuario.getaMaterno());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getUsuario());
            ps.setString(6, usuario.getClave());
            //ps.setString(7, usuario.getTipoUsuario());
            ps.setInt(7, usuario.getId());
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    public void delet(Usuario usuario)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_DELETE);
            ps.setInt(1, usuario.getId());
            //ps.setString(7, usuario.getTipoUsuario());
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
    public Usuario load(Usuario usuario)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_SELECT);
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();
            //ps.setString(7, usuario.getTipoUsuario());
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
            {
                return (Usuario)resultados.get(0);
            }
            else {
                return null;
            }
            //ps.executeUpdate();
            
        }
        finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }

    public List obtenerResultados(ResultSet rs)throws SQLException{
        
       List res = new LinkedList();
       while(rs.next()){
           Usuario user = new Usuario();
           user.setId(rs.getInt("idUsuario"));
           user.setNombre(rs.getString("nombre"));
           
           //System.out.println(rs.getString("nombre"));
           
           user.setaPaterno(rs.getString("aPaterno"));
           user.setaMaterno(rs.getString("aMaterno"));
           user.setEmail(rs.getString("email"));
           user.setUsuario(rs.getString("nombreUsuario"));
           user.setClave(rs.getString("claveUsuario"));
           user.setTipoUsuario(rs.getString("tipoUsuario"));
           
           res.add(user);
           
       }
        
        return res;
    }
    
    
     public List loadAll()throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_SELECT_ALL);
 
            rs = ps.executeQuery();
            //ps.setString(7, usuario.getTipoUsuario());
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
            {
                //System.out.println("los resultados son"+resultados.size());
                return resultados;//resultados
            }
            else {
                return null;
            }
            //ps.executeUpdate();
            
        }
        finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
           // if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
     
     
      public List grafica() throws SQLException { 
            
          CallableStatement cs = null; 
          ResultSet rs = null; 
          List lista = new ArrayList(); 
          try { 
                cs = conexionDB.prepareCall(SQL_GRAFICAR); 
                rs = cs.executeQuery(); 
                while (rs.next()) { 
                    Grafica grafica = new Grafica(); 
                    grafica.setCantidad(Integer.parseInt(rs.getString("Alumnos"))); 
                    grafica.setNombre(rs.getString("carrera")); 
                    lista.add(grafica); 
                } 
            }finally { 
                if (rs != null) { 
                rs.close(); 
            } 
            if (cs != null) { 
                cs.close(); 
            } 
            } 
        return lista; 
    }
      
      public boolean verificarUsuario(String user,String pass){
		try {
                    PreparedStatement ps= conexionDB.prepareStatement("Select * from usuarioo where usuarioo.nombre=? and usuarioo.claveUsuario=?");
                    ps.setString(1, user);
                    ps.setString(2, pass);
                    ResultSet r = ps.executeQuery();
            
			if(r.next()){
				//System.out.println(r.getObject(1));
                                //System.out.println(r.getObject(2));
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
      
      
}


