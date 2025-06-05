import java.util.Random;

    public class PiedraPapelTijeras {


        /* TODO
         COMENTAR EL CODIGO PARA LA ENTRAGA Y
         PARA QUE EL JUEGO FUNCION HAY QUE HACER UNA INTERFAZ */

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

           int movimientoPc = random.nextInt(3)+1;
           String resultado =decidirGanador(movimientoJugador,movimientoPc);
           if (resultado.equals("Ganador")){
               victoriasJugador++;
           } else if (resultado.equals("Perdedor")) {
               victoriasPc++;
           }
            return resultado ;
        }

        public String decidirGanador (int jugador, int pc){
            if (jugador == pc){
                return "empate";
            }
            if ((jugador == 1 && pc ==3) || (jugador == 2 && pc ==1) || (jugador == 3 && pc ==2)){
                return "Ganador";
            }
            return "Perdedor";
        }

        public int getVictoriasJugador(){
            return victoriasJugador;
        }
        public int getVictoriasPc(){
            return victoriasPc;
        }

        public String convertidor(int num){
            switch (num){
                case 1: return "\uD83E\uDEA8";
                case 2: return "✂\uFE0F";
                case 3: return "\uD83D\uDCDC";
                default: return "Error";
            }
        }


}
