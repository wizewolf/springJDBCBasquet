package com.lab2.registroDeJugadores.model.dao.jugador;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lab2.registroDeJugadores.model.dao.club.ClubMapper;
import com.lab2.registroDeJugadores.model.vo.Club;
import com.lab2.registroDeJugadores.model.vo.Jugador;

public class JugadorJDBCTemple implements IJugadorDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;

	public void getDataSourse(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Jugador> consultarJugadores(int idClub) {
		String consulta = "SELECT * FROM jugadores";
		List<Jugador> jugador = jdbcTemplateObj.query(consulta, new JugadorMapper());

		return jugador;

	}

	@Override
	public Jugador consultarJugador(int dni) {
		String consulta = "SELECT * FROM jugadores where dni=?";
		Jugador jugador = jdbcTemplateObj.queryForObject(consulta, new Object[] { dni }, new JugadorMapper());
		return jugador;
	}

	@Override
	public Jugador consultarJugadorId(int id) {
		String consulta = "SELECT * FROM jugadores where id=?";
		Jugador jugador = jdbcTemplateObj.queryForObject(consulta, new Object[] { id }, new JugadorMapper());
		return jugador;
	}

	@Override
	public boolean altaJugador(Jugador jugador) {
		int i = 0;
		try {
			String consulta = "INSERT INTO jugadores(nombre,apellido,dni,fechaNac,entregado,idClub,idClubPase,pase,foto)"
					+ "values (?,?,?,?,?,?,?,?,?)";

			i = jdbcTemplateObj.update(consulta, jugador.getNombre(), jugador.getApellido(), jugador.getDni(),
					jugador.getDni(), jugador.getFechaNacSql(), jugador.isEntregado(), jugador.getIdclub(),
					jugador.getIdClubPase(), jugador.getPase(), imagenABlob(jugador.getFoto()));
		} catch (DataAccessException | IOException | SQLException e) {
			// si falla la conversion del la imagen a blob
			e.printStackTrace();
			return false;
		}
		if (i == 1) {
			return true;
		}
		return false;

	}

	@Override
	public boolean modificarJugador(Jugador jugador) {
		int i = 0;
		try {
			String consulta = "UPDATE jugadores SET nombre=?,apellido=?,dni=?,fechaNac=?,entregado=?,idClub=?,idClubPase=?,pase=?,foto=?";

			i = jdbcTemplateObj.update(consulta, jugador.getNombre(), jugador.getApellido(), jugador.getDni(),
					jugador.getDni(), jugador.getFechaNacSql(), jugador.isEntregado(), jugador.getIdclub(),
					jugador.getIdClubPase(), jugador.getPase(), imagenABlob(jugador.getFoto()));
		} catch (DataAccessException | IOException | SQLException e) {
			// si falla la conversion del la imagen a blob
			e.printStackTrace();
			return false;
		}
		if (i == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean bajaJugador(int idJugador) {
		String consulta = "UPDATE jugador SET baja=true WHERE idJugador=?";
		int i = jdbcTemplateObj.update(consulta,idJugador);
		if (i==1) {
			return true;
		}
		return false;
	}

	public Blob imagenABlob(Image image) throws IOException, SQLException {
		// transforma la imagen en un BufferedImage para poder convertilo a blob
		BufferedImage buffered = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.SCALE_SMOOTH);
		buffered.getGraphics().drawImage(image, 0, 0, null);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(buffered, "jpg", baos);
		byte[] imageInByte = baos.toByteArray();
		Blob blob = new javax.sql.rowset.serial.SerialBlob(imageInByte);
		blob.setBytes(1, imageInByte);
		return blob;
	}

}
