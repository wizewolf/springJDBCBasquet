package com.lab2.registroDeJugadores.model.dao.jugador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;

import org.springframework.jdbc.core.RowMapper;

import com.lab2.registroDeJugadores.model.vo.Jugador;

public class JugadorMapper implements RowMapper<Jugador> {
	
	@Override
	public Jugador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Jugador jugador = new Jugador();
		try {
			jugador.setId(rs.getInt("idJugador"));
			jugador.setNombre(rs.getString("nombre"));
			jugador.setDni(rs.getInt("dni"));
			jugador.setApellido(rs.getString("apellido"));
			jugador.setIdclub(rs.getInt("idClub"));
			jugador.setIdClubPase(rs.getInt("idClubPase"));
			jugador.setFechaNac(rs.getDate("nacimiento"));
			jugador.setPase(rs.getString("pase"));
			jugador.setFoto(obtenerImagen(rs.getBlob("foto")));
		} catch (IOException e) {
			//si falla la transformacion de la imagen
			e.printStackTrace();
		}
		return jugador;
	}

	public BufferedImage obtenerImagen(Blob blob) throws IOException, SQLException {
		byte[] data = blob.getBytes(1, (int) blob.length());
		return ImageIO.read(new ByteArrayInputStream(data));
	}

}
