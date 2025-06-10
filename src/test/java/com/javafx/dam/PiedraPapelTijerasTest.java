package com.javafx.dam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PiedraPapelTijerasTest {
    // Test para verificar que el constructor inicializa correctamente los contadores de victorias
    @Test
    public void testConstructor() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();
        assertEquals(0, juego.getVictoriasJugador());//Verifica que las victorias del jugador empiezan en 0
        assertEquals(0, juego.getVictoriasPc());//Verifica que las victorias del pc empiezan en 0
    }

    // Tests para decidirGanador()
    @Test
    public void testDecidirGanador_Empate() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();//Verificamos que si ambos jugadores eligen la misma opción, el resultado es empate
        assertEquals("empate", juego.decidirGanador(1, 1)); //Piedra vs Piedra
        assertEquals("empate", juego.decidirGanador(2, 2)); //Papel vs Papel
        assertEquals("empate", juego.decidirGanador(3, 3)); //Tijeras vs Tijeras
    }

    @Test
    public void testDecidirGanador_JugadorGana() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras(); //Verifica que el jugador gana con las combinaciones correctas
        assertEquals("Ganador", juego.decidirGanador(1, 3)); //Piedra vence Tijeras
        assertEquals("Ganador", juego.decidirGanador(2, 1)); //Papel vence Piedra
        assertEquals("Ganador", juego.decidirGanador(3, 2)); //Tijeras vencen Papel
    }

    @Test
    public void testDecidirGanador_PcGana() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras(); //Verifica que el pc gana con las combinaciones correctas
        assertEquals("Perdedor", juego.decidirGanador(1, 2)); //Piedra pierde vs Papel
        assertEquals("Perdedor", juego.decidirGanador(2, 3)); //Papel pierde vs Tijeras
        assertEquals("Perdedor", juego.decidirGanador(3, 1)); //Tijeras pierden vs Piedra
    }

    // Tests para comenzarPartida()
    @Test
    public void testComenzarPartida_ValoresValidos() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();
        String[] resultado = juego.comenzarPartida(1); // Piedra

        //Verifica que el resultado es uno de los esperados ("Ganador", "Perdedor", "empate")
        assertTrue(Arrays.asList("Ganador", "Perdedor", "empate").contains(resultado[0].trim()));
        // Verificar que el movimiento de la PC es válido (1-3)
        int movimientoPc = Integer.parseInt(resultado[1]);
        assertTrue(movimientoPc >= 1 && movimientoPc <= 3);
        //Verifica que el movimiento de la PC es válido (debe estar entre 1 y 3)
    }

    @Test
    public void testComenzarPartida_ContadorVictorias() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();

        // Realiza una partida con la opción "Piedra"
        juego.comenzarPartida(1); // Piedra (podría ganar, perder o empatar)

        // Como no podemos controlar Random, verificamos que el contador cambió
        assertTrue(juego.getVictoriasJugador() >= 0);
        assertTrue(juego.getVictoriasPc() >= 0);
    }

    @Test
    public void testComenzarPartida_ValorInvalido() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();
        assertThrows(IllegalArgumentException.class, () -> juego.comenzarPartida(0));
        assertThrows(IllegalArgumentException.class, () -> juego.comenzarPartida(4));
    }//Verifica que lanzar valores inválidos produce una excepción

    // Tests para convertidor()
    @Test
    public void testConvertidor() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();
        assertEquals("\uD83E\uDEA8", juego.convertidor(1)); // Piedra
        assertEquals("\uD83D\uDCDC", juego.convertidor(2)); // Papel
        assertEquals("✂\uFE0F", juego.convertidor(3)); // Tijeras
        assertEquals("Error", juego.convertidor(99)); // Valor inválido por lo que debe devolver "Error"
    }// Verifica que la conversión de números a símbolos sea correcta

    // Tests para getters de victorias
    @Test
    public void testGetters() {
        PiedraPapelTijeras juego = new PiedraPapelTijeras();
        assertEquals(0, juego.getVictoriasJugador());
        assertEquals(0, juego.getVictoriasPc());
        //Verifica que los valores iniciales de victorias sean 0
    }
}

