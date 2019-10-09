package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Item;

@Repository
public class ItemDAO {
	Connection connection;
	
	@Autowired
	public ItemDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Item item){
		String sql = "insert into itens (nomeItem) " +
					"values (?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, item.getNomeItem());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Item> lista(){
		try{
			List<Item> itens = new ArrayList<Item>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM itens");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Item item = new Item();
				
				item.setId(rs.getLong("id"));
				item.setNomeItem(rs.getString("nomeItem"));
				itens.add(item);
			}
			rs.close();
			stmt.close();
			return itens;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Item item){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from itens where id = ?");
			
			stmt.setLong(1, item.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Item buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from itens");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Item item = new Item();

					item.setId(rs.getLong("id"));
					item.setNomeItem(rs.getString("nomeItem"));
				
					return item;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}

	public void altera(Item item){
		String sql = "update itens set nomeItem=? where id = ?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, item.getNomeItem());
			stmt.setLong(2, item.getId());	
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
