import java.util.Random;

public class PiedraPapelTijeras {

    private int victoriasJugador;
    private int victoriasPc;
    private final Random random;

    public PiedraPapelTijeras() {
        this.random = new Random();
        this.victoriasJugador = 0;
        this.victoriasPc = 0;
    }

    public String comenzarPartida(int movimientoJugador){
        if (movimientoJugador < 1 || movimientoJugador > 3){
            throw new IllegalArgumentException("Movimiento invalido, la jugada debe ser 1,2 o 3");
        }

        return "";
    }

}
