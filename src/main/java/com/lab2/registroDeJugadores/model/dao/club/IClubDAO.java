package com.lab2.registroDeJugadores.model.dao.club;

import java.util.ArrayList;
import java.util.List;

import com.lab2.registroDeJugadores.model.vo.Club;
public interface IClubDAO {
	//me devuelve todos los clubes
	public List<Club> consultarClubs();
	//alta de club
	public boolean altaClub(Club club);
	//modificacion de un club
	public boolean modificarClub(Club club) ;
	//baja club
	public boolean bajaClub(int idClub);
	// get club
	public Club getClub(int id);
}
