package com.lab2.registroDeJugadores.model.dao.club;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.lab2.registroDeJugadores.model.vo.Club;

public class ClubMapper implements RowMapper<Club>  {

	@Override
	public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
		Club club = new Club();
		club.setId(rs.getInt("idClub"));
		club.setDireccion(rs.getString("direccion"));
		club.setNombre(rs.getString("nombre"));
		return club;
	}

}
