package br.com.fiap.dao;

import br.com.fiap.to.CalendarioTO;
import java.sql.*;
import java.util.ArrayList;

public class CalendarioDAO {
    public ArrayList<CalendarioTO> findAll() {
        ArrayList<CalendarioTO> calendarios = new ArrayList<CalendarioTO>();
        String sql = "select * from hcf_calendario order by id";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    CalendarioTO calendario = new CalendarioTO();
                    calendario.setId(rs.getLong("id"));
                    calendario.setData_consulta(rs.getDate("data_consulta").toLocalDate());
                    calendario.setHora_consulta(rs.getString("hora_consulta"));
                    calendario.setEspecialidade(rs.getString("especialidade"));
                    calendario.setLocal(rs.getString("local"));
                    calendarios.add(calendario);
                }
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return calendarios;
    }

    public CalendarioTO save(CalendarioTO calendario){
        String sql = "insert into hcf_calendario( data_consulta, hora_consulta, especialidade, local) values (?,?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setDate(1, Date.valueOf(calendario.getData_consulta()));
            ps.setString(2, calendario.getHora_consulta());
            ps.setString(3, calendario.getEspecialidade() );
            ps.setString(4, calendario.getLocal());
            if (ps.executeUpdate() > 0){
                return calendario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " +  e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "delete from hcf_calendario where id = ? ";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
         ps.setLong(1, id);
         return ps.executeUpdate() > 0;
        } catch (SQLException e ){
            System.out.println("Erro ao Excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public CalendarioTO update (CalendarioTO calendario) {
        String sql = "update hcf_calendario set data_consulta=?, hora_consulta =?, especialidade = ?, local =? ";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setDate(1, Date.valueOf(calendario.getData_consulta()));
            ps.setString(2, calendario.getHora_consulta());
            ps.setString(3, calendario.getEspecialidade() );
            ps.setString(4, calendario.getLocal());
            if (ps.executeUpdate() > 0){
                return null;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
