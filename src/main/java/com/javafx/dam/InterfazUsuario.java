package com.javafx.dam;

import java.util.Arrays;
import java.util.Scanner;

public class InterfazUsuario {  //Cambiado de "interface" a "class"
    private final PiedraPapelTijeras juego;
    private final Scanner scanner;

    public InterfazUsuario() {
        this.juego = new PiedraPapelTijeras();  //Inicializa el juego
        this.scanner = new Scanner(System.in);  //Inicializa el scanner para leer por consola
    }

    public void iniciarJuego() {
        System.out.println("¡Bienvenido a Piedra, Papel o Tijeras!");
//Metodo principal para poder iniciar el programa el cual presenta el menu, lee por pantalla la opcion que el jugador
//realiza  y muestra el resultado en cada ronda

        boolean continuar = true; //Variable con la que se controla el juego

        while (continuar) {//Bucle principal del juego que se ejecuta hasta que el jugador decida no continuar
            try {//Muestra las opciones del juego al jugador
                System.out.println("Opciones:");
                System.out.println("1. Piedra \uD83E\uDEA8");
                System.out.println("2. Papel \uD83D\uDCDC");
                System.out.println("3. Tiejras  ✂️");

                System.out.print("Elige tu movimiento (1-3): ");//Solicita al jugador que elija su movimiento y lee la entrada del jugador como numero entero
                int movimiento = scanner.nextInt();
                //Llama al método comenzarPartida para ejecutar una ronda del juego
                String[] resultado = juego.comenzarPartida(movimiento);
                mostrarResultado(resultado, movimiento);//Muestra el resultado de la ronda al jugador
                //Mustra el marcador actual
                System.out.println("Marcador:");
                System.out.println("Jugador: " + juego.getVictoriasJugador());
                System.out.println("Computadora: " + juego.getVictoriasPc());

            } catch (IllegalArgumentException e) {
                //Captura la excepción IllegalArgumentException si el jugador ingresa un movimiento inválido
                System.out.println("Error: " + e.getMessage());//Muestra el mensaje de error
                scanner.nextLine();//Limpia el buffer del scanner para evitar bucles infinitos
                continue;//Vuelve al inicio del bucle while para que el juador pueda intentar de nuevo
            }

            System.out.print("¿Quieres jugar otra vez? (s/n): "); //Pregunta al jugador si quiere jugar otra vez
            continuar = scanner.next().equalsIgnoreCase("s");
            //Lee la respuesta del usuario y verifica si es "s" (sí) ignorando mayúsculas y minúsculas
            scanner.nextLine();//Volvemos a limpiar el buffer del scanner después de leer la respuesta del usuario
        }

        System.out.println("Gracias por jugar!"); //Mensaje para terminar el juego
    }

    //Metodo para mostrar el resultado del juego en cada ronda
    private void mostrarResultado(String[] resultado, int movimientoJugador) {
        int movimientoPc = Integer.parseInt(resultado[1]);//Obtiene el resultado del pc y lo convierte a un entero
    //Muestra la elección del jugador y del pc utilizando el método convertidor para obtener la representación en emoji
        System.out.println("Tú elegiste: " + juego.convertidor(movimientoJugador));
        System.out.println("La computadora eligió: " + juego.convertidor(movimientoPc));

        // Muestra el resultado de la ronda
        switch (resultado[0]) {
            case "Ganador":
                System.out.println("¡Ganaste esta ronda! 🎉");
                break;
            case "Perdedor":
                System.out.println("¡Perdiste esta ronda! 😢");
                break;
            case "empate":
                System.out.println("¡Empate! 🤝");
                break;
        }
    }
}