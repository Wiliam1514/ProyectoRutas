/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectorutas.accesoadatos;
import java.util.*;
import java.sql.*;
import static proyectorutas.accesoadatos.DepartamentoDAL.asignarDatosResultSet;
import static proyectorutas.accesoadatos.DepartamentoDAL.obtenerCampos;
import static proyectorutas.accesoadatos.DepartamentoDAL.querySelect;
import proyectorutas.en.*;
/**
 *
 * @author MINEDUCYT
 */
public class DepartamentoDAL {
    
    static String obtenerCampos()
    {
        return "d.Id, d.NombreDepartamento";
    }
    private static String obtenerSelect(Departamento pDepartamento)
    {
        String sql;
        sql = "Select ";
        if(pDepartamento.getTop_aux() > 0 && 
           ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER)
        {
            sql += "Top " + pDepartamento.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " From Departamento d");
        return sql;
    }
    
    private static String agregarOrderBy(Departamento pDepartamento)
    {
        String sql = " Order by d.Id Desc";
        if(pDepartamento.getTop_aux() > 0 && 
        ComunDB.TIPODB == ComunDB.TipoDB.MYSQL)
        {
            sql += "Limit " + pDepartamento.getTop_aux() + " ";
        }
        return sql;
    }
    public static int crear(Departamento pDepartamento) throws Exception
    {
        int result;
        String sql;
        try(Connection conn = ComunDB.obtenerConexion();)
        {
            sql = "Insert Into Departamento(NombreDepartamento) Values(?)";
            try(PreparedStatement st = 
                ComunDB.createPreparedStatement(conn, sql);)
            {
                st.setString(1, pDepartamento.getNombreDepartamento());
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
    public static int modificar(Departamento pDepartamento) throws Exception 
    {
        int result;
        String sql;
        try(Connection conn = ComunDB.obtenerConexion();)
        {
            sql = "Update Departamento Set NombreDepartamento = ? Where Id = ?";
            try(PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);)
            {
                ps.setString(1, pDepartamento.getNombreDepartamento());
                ps.setInt(2, pDepartamento.getId());
                result = ps.executeUpdate();
                ps.close();
            }
            catch(Exception ex)
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
    public static int eliminar(Departamento pDepartamento) throws Exception
    {
        int result;
        String sql;
        try(Connection conn = ComunDB.obtenerConexion();)
        {
            sql = "Delete From Departamento Where Id = ?";
            try(PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);)
            {
                ps.setInt(1, pDepartamento.getId());
                result = ps.executeUpdate();
                ps.close();
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
    static int asignarDatosResultSet(Departamento pDepartamento, ResultSet pResultSet, int pIndex) throws Exception
    {
        pIndex++;
        pDepartamento.setId(pResultSet.getInt(pIndex));
        pIndex++;
        pDepartamento.setNombreDepartamento(pResultSet.getString(pIndex));
        return pIndex;
    }
     private static void obtenerDatos(PreparedStatement pPS, ArrayList<Departamento> pDepartamentos) throws Exception
    {
        try(ResultSet resultset = ComunDB.obtenerResulSet(pPS);)
        {
            while(resultset.next())
            {
                Departamento departamento = new Departamento();
                asignarDatosResultSet(departamento,resultset,0);
                pDepartamentos.add(departamento);
            }
            resultset.close();
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        
    }
     public static Departamento obtenerPorId(Departamento pDepartamento) throws Exception
    {
        Departamento departamento = new Departamento();
        ArrayList<Departamento> departamentos = new ArrayList();
        try(Connection conn = ComunDB.obtenerConexion();)
        {
            String sql = obtenerSelect(pDepartamento);
            sql += " Where Id = ?";
            try(PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);)
            {
                ps.setInt(1, pDepartamento.getId());
                obtenerDatos(ps, departamentos);
                ps.close();
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        if(departamentos.size() > 0)
        {
            departamento = departamentos.get(0);
        }
        return departamento;
    }
     public static ArrayList<Departamento> obtenerTodos() throws Exception
    {
        Departamento departamento = new Departamento();
        ArrayList<Departamento> departamentos = new ArrayList();
        try(Connection conn = ComunDB.obtenerConexion();)
        {
            String sql = obtenerSelect(new Departamento());
            sql += agregarOrderBy(new Departamento());
            try(PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);)
            {
                obtenerDatos(ps, departamentos);
                ps.close();
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        
        return departamentos;
    }
     static void querySelect(Departamento pDepartamento, ComunDB.UtilQuery pUtilQuery) throws Exception
    {
        PreparedStatement statement = pUtilQuery.getStatement();
        if(pDepartamento.getId() > 0)
        {
            pUtilQuery.AgregarWhereAnd(" d.Id = ? ");
            if(statement != null)
            {
                statement.setInt(pUtilQuery.getNumWhere(), 
                        pDepartamento.getId());
            }
        }
        
        if(pDepartamento.getNombreDepartamento() != null && 
           pDepartamento.getNombreDepartamento().trim().isEmpty() == false)
        {
            pUtilQuery.AgregarWhereAnd(" d.NombreDepartamento Like ? ");
            if(statement != null)
            {
                statement.setString(pUtilQuery.getNumWhere(), 
                        "%" + pDepartamento.getNombreDepartamento() + "%");
            }
        }
    }
     public static ArrayList<Departamento> buscar(Departamento pDepartamento) throws Exception
    {
        ArrayList<Departamento> departamentos = new ArrayList();
        try(Connection conn = ComunDB.obtenerConexion();)
        {
            String sql = obtenerSelect(pDepartamento);
            ComunDB comundb = new ComunDB();
            ComunDB.UtilQuery utilQuery = 
            comundb.new UtilQuery(sql,null,0);
            querySelect(pDepartamento, utilQuery);
            sql = utilQuery.getSQL();
            sql += agregarOrderBy(pDepartamento);
            try(PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);)
            {
                utilQuery.setStatement(ps);
                utilQuery.setSQL(null);
                utilQuery.setNumWhere(0);
                querySelect(pDepartamento, utilQuery);
                obtenerDatos(ps, departamentos);
                ps.close();
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        
        return departamentos;
    }
     
}
