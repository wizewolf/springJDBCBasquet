package com.lab2.registroDeJugadores.model.dao.club;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lab2.registroDeJugadores.model.vo.Club;

public class ClubJDBCTemple implements IClubDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	public void getDataSourse(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Club> consultarClubs() {
		
		//me devuelve todos los club en una lista
		String consulta = "SELECT * FROM clubs";
		List<Club> clubs  = jdbcTemplateObj.query(consulta, new ClubMapper());		

		return clubs;

	}

	@Override
	public boolean altaClub(Club club) {
		
		String query = "INSERT INTO club(nombre,domicilio)" + "values (?,?)";
		int i = jdbcTemplateObj.update(query,club.getNombre(),club.getDireccion());
		if (i==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modificarClub(Club club) {
		
		String consulta = "UPDATE club SET nombre=?,domicilio=? WHERE idClub=?";
		int i = jdbcTemplateObj.update(consulta,club.getNombre(),club.getDireccion(),club.getId());
		if (i==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean bajaClub(int idClub) {
		String consulta = "UPDATE club SET baja=true WHERE idClub=?";
		int i = jdbcTemplateObj.update(consulta,idClub);
		if (i==1) {
			return true;
		}
		return false;
	}


	@Override
	public Club getClub(int id) {
		String SQL = "SELECT * FROM club where idClub = ?";
	      Club club = jdbcTemplateObj.queryForObject(SQL, 
	         new Object[]{id}, new ClubMapper());
		return null;
	}

}
