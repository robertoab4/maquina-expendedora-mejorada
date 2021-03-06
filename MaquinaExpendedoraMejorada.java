public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El total de billetes impresos
    private int contadorBilletes;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Maquina con premio
    private boolean maquinaConPremio;
    // Numero maximo de billetes que puede vender
    private int numeroMaximoDeBilletes;
    // Billete premiado
    private int premioBillete;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaPremiada, int maximoNumBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        contadorBilletes = 0;
        maquinaConPremio = maquinaPremiada;
        numeroMaximoDeBilletes = maximoNumBilletes;
        premioBillete = 0;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroMaximoDeBilletes == contadorBilletes) {
            System.out.println("No se puede introducir mas dinero");
        }
        else{
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
                System.out.println(); 
            }
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroMaximoDeBilletes == contadorBilletes) {
            System.out.println("No se pueden imprimir mas billetes");
        }
        else{
            if (cantidadDeDineroQueFalta <= 0) {
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();   
                
                //Se cuenta el numero de billetes vendidos
                contadorBilletes = contadorBilletes + 1;
                premioBillete = premioBillete + 1;
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                
                if (maquinaConPremio = true){
                    if (premioBillete == 3){
                    System.out.println("Ha obtenido un descuento de " + (precioBillete * 0.1) + "€ para el comercio que usted elija");
                    System.out.println();
                    premioBillete = 0;
                    }
                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
                System.out.println();         
            }
        }    
    }
        
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Vacia los dos depositos de la maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int vaciadoDeLaMaquina;
        if (balanceClienteActual > 0) {
            System.out.println("Error - Operación en curso");
            System.out.println();   
            vaciadoDeLaMaquina = -1;
        } 
        else {
            vaciadoDeLaMaquina = totalDineroAcumulado + balanceClienteActual;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return vaciadoDeLaMaquina;
    }   
    
    /**
     * Devuelve el numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos () {   
        return contadorBilletes;        
    }   
    
    /**
     * Imprime por pantalla el numero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos () {
            System.out.println("Lleva " + contadorBilletes + " billetes vendidos");   
            System.out.println();     
        
    }
}
