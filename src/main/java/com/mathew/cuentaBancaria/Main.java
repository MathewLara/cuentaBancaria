package com.mathew.cuentaBancaria;
/*
Autor:Mathew Lara
*Fecha: 23/10/2025
* Clase principal (Main) para probar la jerarquía de Cuentas.
 * Permite al usuario seleccionar un tipo de cuenta (Ahorro o Corriente),
 * crearla con un saldo y tasa iniciales, y realizar operaciones.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * Metodo principal que se ejecuta al iniciar el programa
     * @param args Argumentos de línea de comandos (no se usan).
     * @throws IOException Si ocurre un error al leer la entrada del usuario.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Seleccione el tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(br.readLine());

        System.out.print("Ingrese el saldo inicial: ");
        float saldo = Float.parseFloat(br.readLine());
        System.out.print("Ingrese la tasa anual (%): ");
        float tasa = Float.parseFloat(br.readLine());
        /*
         * Declaramos una variable 'cuenta' del tipo 'Cuenta' (la clase padre).
         * Esto nos permite guardar en ella un objeto de 'CuentaAhorro' o 'CuentaCorriente'.
         */
        Cuenta cuenta;

        if (opcion == 1) {
            cuenta = new CuentaAhorro(saldo, tasa);
            System.out.println("Has seleccionado una Cuenta de Ahorros");
        } else if (opcion == 2) {
            cuenta = new CuentaCorriente(saldo, tasa);
            System.out.println("Has seleccionado una Cuenta Corriente");
        } else {
            System.out.println("Opción no válida");
            return;
        }

        System.out.print("Ingrese el valor a depositar: ");
        float cantidadDepositar = Float.parseFloat(br.readLine());
        cuenta.depositar(cantidadDepositar);

        System.out.print("Ingrese la cantidad a retirar: ");
        float cantidadRetirar = Float.parseFloat(br.readLine());
        cuenta.retirar(cantidadRetirar);

        cuenta.extractoMensual();
        /*
         *Impresion de Resultados
         * Comprobamos (con 'instanceof') de qué tipo es realmente la 'cuenta'
         * para poder "convertirla" (hacer un "cast") a ese tipo
         * y llamar a su metodo 'imprimir(), que no existe en la clase 'Cuenta' padre.
         */
        if (cuenta instanceof CuentaAhorro) {
            ((CuentaAhorro) cuenta).imprimir();
        } else if (cuenta instanceof CuentaCorriente) {
            ((CuentaCorriente) cuenta).imprimir();
        }
    }
}
