package com.lab2.registroDeJugadores.model.dao.jugador;

import java.util.ArrayList;
import java.util.List;

import com.lab2.registroDeJugadores.model.vo.Club;
import com.lab2.registroDeJugadores.model.vo.Jugador;

public interface IJugadorDAO {
	public List<Jugador> consultarJugadores(int idClub);
	public Jugador consultarJugador(int dni);
	public Jugador consultarJugadorId(int id);
	public boolean altaJugador(Jugador jugador);
	public boolean modificarJugador(Jugador jugador) ;
	public boolean bajaJugador(int idJugador);
}
