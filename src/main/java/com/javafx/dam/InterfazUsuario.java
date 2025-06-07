package com.javafx.dam;

import java.util.Scanner;

public class InterfazUsuario {  // Cambiado de "interface" a "class"
    private final PiedraPapelTijeras juego;
    private final Scanner scanner;

    public InterfazUsuario() {
        this.juego = new PiedraPapelTijeras();  // Inicializa el juego
        this.scanner = new Scanner(System.in);  // Inicializa el Scanner
    }

    public void iniciarJuego() {
        System.out.println("¡Bienvenido a Piedra, Papel o Tijeras!");
        System.out.println("Opciones:");
        System.out.println("1. Piedra \uD83E\uDEA8");
        System.out.println("2. Tijeras ✂️");
        System.out.println("3. Papel \uD83D\uDCDC");

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("\nElige tu movimiento (1-3): ");
                int movimiento = scanner.nextInt();

                String resultado = juego.comenzarPartida(movimiento);
                mostrarResultado(resultado);

                System.out.println("Marcador:");
                System.out.println("Jugador: " + juego.getVictoriasJugador());
                System.out.println("PC: " + juego.getVictoriasPc());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
                continue;
            }

            System.out.print("¿Quieres jugar otra vez? (s/n): ");
            continuar = scanner.next().equalsIgnoreCase("s");
            scanner.nextLine();
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }


}