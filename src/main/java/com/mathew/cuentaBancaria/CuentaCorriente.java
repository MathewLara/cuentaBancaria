package com.mathew.cuentaBancaria;
/*
Autor:Mathew Lara
*Fecha: 23/10/2025
*Descripcion : Esta clase denominada CuentaCorriente modela una cuenta bancaria que es una
*subclase de cuenta. Tiene un nuevo atributo: sobregiro
**/

public class CuentaCorriente extends Cuenta {
    float sobregiro;
    /*
    * Constructor de la clase CuentaCorriente
    * @param saldo Parametro que define el saldo de la cuenta corriente
    * @param tasa Parametro que feine la tasa anual de interes de la cuenta corriente
     */
    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        sobregiro = 0;
    }
    /*
     * Metodo que recibe una cantidad de dinero a retirar y actualiza el saldo.
     * @param cantidad Parametro que define la cantidad a retirar.
     */
    public void retirar (float cantidad){
        float resultado = saldo - cantidad;
        if(resultado <= 0){
            sobregiro = sobregiro-resultado;
            saldo=0;
        }else{
            super.retirar (cantidad);
        }
    }
    /*
     * Metodo que recibe una cantidad de dinero a depositar y actualiza el saldo.
     * @param cantidad Parametro que define la cantidad a depositar.
     */
    public void depositar (float cantidad){
        float residuo= sobregiro - cantidad;
        if(sobregiro>0){
            if (residuo>0){
                sobregiro=0;
                saldo=residuo;
            }else{
                sobregiro=-residuo;
                saldo=0;
            }
        }else{
            super.depositar (cantidad);
        }
    }
    /*
     * Metodo que muestra en la pantalla los datoos de una cuenta corriente
     *
     */
    public void imprimir (){
        System.out.println ("Saldo: $" + saldo);
        System.out.println ("Cargo Mensual: $" + comisionMensual);
        System.out.println ("Numero de Transacciones: " + (numeroDepositos+numeroRetiro));
        System.out.println ("Valor Sobregiros: $" + sobregiro);
        System.out.println ();
    }

}
