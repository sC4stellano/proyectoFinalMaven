package com.javafx.dam;

import java.util.Random;

public class PiedraPapelTijeras {
//Variables para almacenar las victorias del jugador y de la PC
    private int victoriasJugador;
    private int victoriasPc;
    private final Random random;//Utilizamos el  Random para generar movimientos aleatorios de la PC

    public PiedraPapelTijeras() {//Constructor que inicializa los contadores de victorias y el generador aleatorio
        this.random = new Random();
        this.victoriasJugador = 0;
        this.victoriasPc = 0;
    }

    public String [] comenzarPartida(int movimientoJugador){
        if (movimientoJugador < 1 || movimientoJugador > 3) {
            throw new IllegalArgumentException("Movimiento invalido, la jugada debe ser 1,2 o 3");
        }//Validamos el movimiento del jugador, si el movimiento no es valido lanzamos una excepción

        int movimientoPc = random.nextInt(3)+1; //Generamos los movimientos aleatorios que usara la pc
        String resultado =decidirGanador(movimientoJugador,movimientoPc);
        if (resultado.equals("Ganador")){
            victoriasJugador++;
        } else if (resultado.equals("Perdedor")) {
            victoriasPc++;
        }
        return new String[]{resultado, String.valueOf(movimientoPc)};
    }//Se determina el ganador y se actualiza el contador de victorias y finalmente devolvemos el resultado y el movimento que hace el pc (antes no aparecia lo que elegia el pc)

    public String decidirGanador (int jugador, int pc){
        if (jugador == pc){
            return "empate";
        }
        if ((jugador == 1 && pc ==3) || (jugador == 2 && pc ==1) || (jugador == 3 && pc ==2)){
            return "Ganador";
        }
        return "Perdedor";
    }//Verificamos la condiciones y se decide quien gana y pierde o si surge un empate

    public int getVictoriasJugador(){
        return victoriasJugador; //Obtiene el numero de victorias del juagador
    }
    public int getVictoriasPc(){
        return victoriasPc;//Obtiene el numero de victorias del pc
    }

    public String convertidor(int num){ //Covierte los numeros en su representacion como emoji, 1:piedra/2:papel/3:tijeras
        switch (num){
            case 1: return "\uD83E\uDEA8";
            case 2: return "\uD83D\uDCDC";
            case 3: return  "✂\uFE0F";
            default: return "Error"; //Si no introduce un numero del 1 al 3 lanza un error que llama a la excepcion anterior
        }
    }

}
