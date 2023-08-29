/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectorutas.accesoadatos;
import java.sql.*;
import java.util.*;
import proyectorutas.en.Departamento;
import proyectorutas.en.Ruta;
/**
 *
 * @author MINEDUCYT
 */
public class RutaDAL {
    static String obtenerCampos()
    {
        return "ru.Id, ru.IdDepartamento, ru.NombreRuta, ru.Recorrido, ru.PuntoSalida, ru.PuntoLlegada" 
                + ", ru.HoraInicio, ru.HoraFin, ru.CodigoBus";
    }
    private static String obtenerSelect(Ruta pRuta)
    {
        String sql;
        sql = "Select ";
        if(pRuta.getTop_aux() > 0 && 
           ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER)
        {
            sql += "Top " + pRuta.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " From Ruta ru");
        return sql;
    }
    
    private static String agregarOrderBy(Ruta pRuta)
    {
        String sql = " Order by ru.Id Desc";
        if(pRuta.getTop_aux() > 0 && 
        ComunDB.TIPODB == ComunDB.TipoDB.MYSQL)
        {
            sql += "Limit " + pRuta.getTop_aux() + " ";
        }
        return sql;
    }
    public static int crear(Ruta pRuta) throws Exception
    {
        int result;
        String sql;
            try(Connection conn = ComunDB.obtenerConexion();)
            {
                sql = "Insert Into Ruta(IdDepartamento, NombreRuta, Recorrido"
                        + ", PuntoSalida, PuntoLlegada, HoraInicio, HoraFin, CodigoBus) Values"
                        + "(?,?,?,?,?,?,?,?)";
                try(PreparedStatement st = 
                    ComunDB.createPreparedStatement(conn, sql);)
                {
                    st.setInt(1, pRuta.getIdDepartamento());
                    st.setString(2, pRuta.getNombreRuta());
                    st.setString(3, pRuta.getRecorrido());
                    st.setString(4, pRuta.getPuntoSalida());
                    st.setString(5, pRuta.getPuntoLlegada());
                    st.setString(6, pRuta.getHoraInicio());
                    st.setString(7, pRuta.getHoraFin());
                    st.setString(8, pRuta.getCodigoBus());
                    result = st.executeUpdate();
                    st.close();
                }
                catch(SQLException ex)
                {
                    throw ex;
                }
            }
            catch(SQLException ex)
            {
                throw ex;
            }
        return result;
    }
    public static int modificar(Ruta pRuta) throws Exception {
        int result;
        String sql;
            try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
                //Definir la consulta UPDATE a la tabla de Usuario utilizando el simbolo ? para enviar parametros
                sql = "UPDATE Ruta SET IdDepartamento=?, NombreRuta=?, PuntoSalida=?, PuntoLlegada=?, HoraInicio=?, HoraFin=?, CodigoBus=? WHERE Id=?";
                try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                    ps.setInt(1, pRuta.getIdDepartamento()); // agregar el parametro a la consulta donde estan el simbolo ? #1  
                    ps.setString(2, pRuta.getNombreRuta());
                    ps.setString(3, pRuta.getRecorrido());
                    ps.setString(4, pRuta.getPuntoSalida());
                    ps.setString(5, pRuta.getPuntoLlegada());
                    ps.setString(6, pRuta.getHoraInicio());
                    ps.setString(7, pRuta.getHoraFin());
                    ps.setString(8, pRuta.getCodigoBus()); 
                    result = ps.executeUpdate(); // ejecutar la consulta UPDATE en la base de datos
                    ps.close(); // cerrar el PreparedStatement
                } catch (SQLException ex) {
                    throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda 
                }
                conn.close(); // cerrar la conexion a la base de datos
            } 
            catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al obtener la conexion en el caso que suceda 
            }
        
        return result; // Retornar el numero de fila afectadas en el UPDATE en la base de datos 
    }
    public static int eliminar(Ruta pRuta) throws Exception {
        int result;
        String sql;
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            sql = "DELETE FROM Ruta WHERE Id=?"; //definir la consulta DELETE a la tabla de Usuario utilizando el simbolo ? para enviar parametros
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {  // obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRuta.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #1 
                result = ps.executeUpdate(); // ejecutar la consulta DELETE en la base de datos
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex;  // enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda 
        }
        return result; // Retornar el numero de fila afectadas en el DELETE en la base de datos 
    }
    static int asignarDatosResultSet(Ruta pRuta, ResultSet pResultSet, int pIndex) throws Exception {
        //  SELECT u.Id(indice 1), u.IdRol(indice 2), u.Nombre(indice 3), u.Apellido(indice 4), u.Login(indice 5), 
        // u.Estatus(indice 6), u.FechaRegistro(indice 7) * FROM Usuario
        pIndex++;
        pRuta.setId(pResultSet.getInt(pIndex)); // index 1
        pIndex++;
        pRuta.setIdDepartamento(pResultSet.getInt(pIndex)); // index 2
        pIndex++;
        pRuta.setNombreRuta(pResultSet.getString(pIndex)); // index 3
        pIndex++;
        pRuta.setRecorrido(pResultSet.getString(pIndex)); // index 4
        pIndex++;
        pRuta.setPuntoSalida(pResultSet.getString(pIndex)); // index 5
        pIndex++;
        pRuta.setPuntoLlegada(pResultSet.getString(pIndex)); // index 6
        pIndex++;
        pRuta.setHoraInicio(pResultSet.getString(pIndex)); // index 7
        pIndex++;
        pRuta.setHoraFin(pResultSet.getString(pIndex));
        pIndex++;
        pRuta.setCodigoBus(pResultSet.getString(pIndex));
        return pIndex;
    }
    private static void obtenerDatos(PreparedStatement pPS, ArrayList<Ruta> pRutas) throws Exception {
        try (ResultSet resultSet = ComunDB.obtenerResulSet(pPS);) { // obtener el ResultSet desde la clase ComunDB
            while (resultSet.next()) { // Recorrer cada una de la fila que regresa la consulta  SELECT de la tabla Usuario
                Ruta ruta = new Ruta();
                // Llenar las propiedaddes de la Entidad Usuario con los datos obtenidos de la fila en el ResultSet
                asignarDatosResultSet(ruta, resultSet, 0);
                pRutas.add(ruta); // agregar la entidad Usuario al ArrayList de Usuario
            }
            resultSet.close(); // cerrar el ResultSet
        } catch (SQLException ex) {
            throw ex;// enviar al siguiente metodo el error al obtener ResultSet de la clase ComunDB   en el caso que suceda 
        }
        
    }
    private static void obtenerDatosIncluirDepartamento(PreparedStatement pPS, ArrayList<Ruta> pRutas) throws Exception {
    try (ResultSet resultSet = ComunDB.obtenerResulSet(pPS)) {
        HashMap<Integer, Departamento> departamentoMap = new HashMap();

        while (resultSet.next()) {
            Ruta ruta = new Ruta();
            int index = asignarDatosResultSet(ruta, resultSet, 0);
            
            // Agregar una impresión para mostrar los datos de la ruta
            System.out.println(ruta);

            if (departamentoMap.containsKey(ruta.getIdDepartamento()) == false) {
                Departamento departamento = new Departamento();
                DepartamentoDAL.asignarDatosResultSet(departamento, resultSet, index);
                departamentoMap.put(departamento.getId(), departamento);
                ruta.setDepartamento(departamento);
            } else {
                ruta.setDepartamento(departamentoMap.get(ruta.getIdDepartamento()));
            }
            System.out.println(ruta);
            pRutas.add(ruta);
            
        }
        resultSet.close();
    } catch (SQLException ex) {
        throw ex;
    }
}

     public static Ruta obtenerPorId(Ruta pRuta) throws Exception {
        Ruta ruta = new Ruta();
        ArrayList<Ruta> rutas = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pRuta); // obtener la consulta SELECT de la tabla Usuario
             // Concatenar a la consulta SELECT de la tabla Usuario el WHERE  para comparar el campo Id
            sql += " WHERE ru.Id=?";
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                ps.setInt(1, pRuta.getId()); // agregar el parametro a la consulta donde estan el simbolo ? #1 
                obtenerDatos(ps, rutas); // Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex; // enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        if (rutas.size() > 0) { // verificar si el ArrayList de Usuario trae mas de un registro en tal caso solo debe de traer uno
            ruta = rutas.get(0); // Si el ArrayList de Usuario trae un registro o mas obtenemos solo el primero
        }
        return ruta; // devolver el Usuario encontrado por Id 
    }
     
     public static ArrayList<Ruta> obtenerTodos() throws Exception {
        ArrayList<Ruta> rutas;
        rutas = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(new Ruta()); // obtener la consulta SELECT de la tabla Usuario
            sql += agregarOrderBy(new Ruta()); // concatenar a la consulta SELECT de la tabla Usuario el ORDER BY por Id 
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                obtenerDatos(ps, rutas); // Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // cerrar la conexion a la base de datos
        }
        catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return rutas; // devolver el ArrayList de Usuario
    }
     
     static void querySelect(Ruta pRuta, ComunDB.UtilQuery pUtilQuery) throws SQLException {
        PreparedStatement statement = pUtilQuery.getStatement(); // obtener el PreparedStatement al cual aplicar los parametros
        if (pRuta.getId() > 0) { // verificar si se va incluir el campo Id en el filtro de la consulta SELECT de la tabla de Usuario
            pUtilQuery.AgregarWhereAnd(" ru.Id=? "); // agregar el campo Id al filtro de la consulta SELECT y agregar el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Id a la consulta SELECT de la tabla de Usuario
                statement.setInt(pUtilQuery.getNumWhere(), pRuta.getId());
            }
        }
        // verificar si se va incluir el campo IdRol en el filtro de la consulta SELECT de la tabla de Usuario
        if (pRuta.getIdDepartamento()> 0) {
            pUtilQuery.AgregarWhereAnd(" ru.IdDepartamento=? "); // agregar el campo IdRol al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo IdRol a la consulta SELECT de la tabla de Usuario
                statement.setInt(pUtilQuery.getNumWhere(), pRuta.getIdDepartamento());
            }
        }
        // verificar si se va incluir el campo Nombre en el filtro de la consulta SELECT de la tabla de Usuario
        if (pRuta.getNombreRuta()!= null && pRuta.getNombreRuta().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.NombreRuta LIKE ? "); // agregar el campo Nombre al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Nombre a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRuta.getNombreRuta() + "%");
            }
        }
        // Verificar si se va incluir el campo Apellido en el filtro de la consulta SELECT de la tabla de Usuario
        if (pRuta.getRecorrido()!= null && pRuta.getRecorrido().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.Recorrido LIKE ? "); // agregar el campo Apellido al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Apellido a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), "%" + pRuta.getRecorrido()+ "%");
            }
        }
        // Verificar si se va incluir el campo Login en el filtro de la consulta SELECT de la tabla de Usuario
        if (pRuta.getPuntoSalida()!= null && pRuta.getPuntoSalida().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.PuntoSalida=? "); // agregar el campo Login al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Login a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), pRuta.getPuntoSalida());
            }
        }
        
        if (pRuta.getPuntoLlegada()!= null && pRuta.getPuntoLlegada().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.PuntoLlegada=? "); // agregar el campo Login al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Login a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), pRuta.getPuntoLlegada());
            }
        }
        // Verificar si se va incluir el campo Estatus en el filtro de la consulta SELECT de la tabla de Usuario
        if (pRuta.getHoraInicio()!= null && pRuta.getHoraInicio().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.HoraInicio=? "); // agregar el campo Login al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Login a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), pRuta.getHoraInicio());
            }
        }
        
        if (pRuta.getHoraFin()!= null && pRuta.getHoraFin().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.HoraFin=? "); // agregar el campo Login al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Login a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), pRuta.getHoraFin());
            }
            
        }
        
        if (pRuta.getCodigoBus()!= null && pRuta.getCodigoBus().trim().isEmpty() == false) {
            pUtilQuery.AgregarWhereAnd(" ru.CodigoBus=? "); // agregar el campo Login al filtro de la consulta SELECT y agregar en el WHERE o AND
            if (statement != null) {
                 // agregar el parametro del campo Login a la consulta SELECT de la tabla de Usuario
                statement.setString(pUtilQuery.getNumWhere(), pRuta.getCodigoBus());
            }
        }
    }
     public static ArrayList<Ruta> buscar(Ruta pRuta) throws Exception {
        ArrayList<Ruta> rutas = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = obtenerSelect(pRuta); // obtener la consulta SELECT de la tabla Usuario
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pRuta, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Usuario 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pRuta); // Concatenar a la consulta SELECT de la tabla Usuario el ORDER BY por Id
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pRuta, utilQuery); // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Usuario
                obtenerDatos(ps, rutas); // Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex; // Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } 
        catch (SQLException ex) {
            throw ex; // Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return rutas; // Devolver el ArrayList de Usuario
    }
     
     public static ArrayList<Ruta> buscarIncluirDepartamento(Ruta pRuta) throws Exception {
        ArrayList<Ruta> rutas = new ArrayList();
        try (Connection conn = ComunDB.obtenerConexion();) { // Obtener la conexion desde la clase ComunDB y encerrarla en try para cierre automatico
            String sql = "SELECT "; // Iniciar la variables para el String de la consulta SELECT
            if (pRuta.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
                sql += "TOP " + pRuta.getTop_aux() + " "; // Agregar el TOP en el caso que se este utilizando SQL SERVER
            }
            sql += obtenerCampos(); // Obtener los campos de la tabla de Usuario que iran en el SELECT
            sql += ",";
            sql += DepartamentoDAL.obtenerCampos(); // Obtener los campos de la tabla de Rol que iran en el SELECT
            sql += " FROM Ruta ru";
            sql += " JOIN Departamento d on (ru.IdDepartamento=d.Id)"; // agregar el join para unir la tabla de Usuario con Rol
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = comundb.new UtilQuery(sql, null, 0);
            querySelect(pRuta, utilQuery); // Asignar el filtro a la consulta SELECT de la tabla de Usuario 
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pRuta); // Concatenar a la consulta SELECT de la tabla Usuario el ORDER BY por Id
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) { // Obtener el PreparedStatement desde la clase ComunDB
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pRuta, utilQuery); // Asignar los parametros al PreparedStatement de la consulta SELECT de la tabla de Usuario
                obtenerDatosIncluirDepartamento(ps, rutas);// Llenar el ArrayList de Usuario con las fila que devolvera la consulta SELECT a la tabla de Usuario
                ps.close(); // Cerrar el PreparedStatement
            } catch (SQLException ex) {
                throw ex;// Enviar al siguiente metodo el error al ejecutar PreparedStatement en el caso que suceda
            }
            conn.close(); // Cerrar la conexion a la base de datos
        } catch (SQLException ex) {
            throw ex;// Enviar al siguiente metodo el error al obtener la conexion  de la clase ComunDB en el caso que suceda
        }
        return rutas; // Devolver el ArrayList de Usuario
    }
     
     
}
