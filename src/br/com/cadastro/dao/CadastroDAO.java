package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Cadastro;

@Repository
public class CadastroDAO {
	Connection connection;
	
	@Autowired
	public CadastroDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Cadastro cadastro){
		String sql = "insert into cadastros (nome, sexo, descricao, idCadastrocadastro) " +
					"values (?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, cadastro.getNome());
			stmt.setString(2, cadastro.getSexo());
			stmt.setString(3, cadastro.getDescricao());
			stmt.setLong(4, cadastro.getIdCadastroUsuario());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Cadastro> lista(){
		try{
			List<Cadastro> cadastros = new ArrayList<Cadastro>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM cadastros");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Cadastro cadastro = new Cadastro();
				
				cadastro.setId(rs.getLong("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setSexo(rs.getString("sexo"));
				cadastro.setIdCadastroUsuario();
				if(rs.getDate("data_hora") != null){
					Calendar data_hora = Calendar.getInstance();
					data_hora.setTime(rs.getDate("data_hora"));
					cadastro.setData_hora(data_hora);
				}
				cadastros.add(cadastro);
			}
			rs.close();
			stmt.close();
			return cadastros;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Cadastro cadastro){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from cadastros where id = ?");
			
			stmt.setLong(1, cadastro.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Cadastro buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from cadastros");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Cadastro cadastro = new Cadastro();

					cadastro.setId(rs.getLong("id"));
					cadastro.setNome(rs.getString("nome"));
					cadastro.setSexo(rs.getString("sexo"));
					cadastro.setIdCadastroUsuario();
					if(rs.getDate("data_hora") != null){
						Calendar data_hora = Calendar.getInstance();
						data_hora.setTime(rs.getDate("data_hora"));
						cadastro.setData_hora(data_hora);
					}
					
					return cadastro;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Cadastro cadastro){
		String sql = "update cadastros set nome=? , login=?, senha=MD5(?), dataNascimento=?, altura=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, cadastro.getNome());
			stmt.setString(2, cadastro.getDescricao());
			stmt.setString(3, cadastro.getSexo());
			if(cadastro.getData_hora() != null)
			{
				stmt.setDate(4, new java.sql.Date(cadastro.getData_hora().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(4, null);
			}
			stmt.setLong(5, cadastro.getIdCadastroUsuario());
			stmt.setLong(6, cadastro.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
