import java.util.Scanner;
public class Desafio {
    public static void main(String[] args) {
        /*
        crear un sistema que permita a los clientes consultar su saldo,
        retirar dinero, depositar dinero y salir del sistema. Para ello,
        deberás utilizar la consola como interfaz, mostrando un menú con
        las opciones disponibles. El usuario podrá interactuar con el
        sistema escribiendo el número de la opción que desea realizar.
        Además, deberás implementar algunas validaciones, como por ejemplo,
        verificar que el usuario no intente retirar más dinero del que tiene
        en su cuenta.
        datos del cliente:
        nombre del cliente
        tipo de cuenta
        saldo disponible
        *******************************
        "Escriba el numero de la opcion deseada*
        1-Consultar Saldo
        2-Retirar
        3-Depositar
        9-Salir
         */
        Scanner read=new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("Datos del cliente");
        DatosCliente("Anibal Misel", "Corriente",5000);

        double saldo=0;
        int option;
        boolean exit=true;

        while (exit){

            menu();
            option= read.nextInt();

            switch (option){
                case 1:
                    saldo=ConsultarSaldo(5000);
                    System.out.println("Su saldo es: "+saldo+" $");
                    break;
                case 2:
                    System.out.println("Indique la cantidad a retirar:");
                    double cantidad= read.nextDouble();

                    if (cantidad<=saldo) {
                        saldo=Retirar(cantidad, saldo);

                        System.out.println("Su retiro ha sido exitoso");
                        System.out.println("Saldo restante: "+saldo+" $");
                    }else{
                        String mensaje = """
                                La cantidad a retirar excede su saldo.
                                Su saldo: %.2f $
                                """.formatted(saldo);  // Usar %d para enteros
                        System.out.println(mensaje);
                    }
                    break;
                case 3:
                    System.out.println("Indique la cantidad a depositar:");
                    double cantidadD= read.nextDouble();
                    saldo=Depositar(cantidadD, saldo);
                    String mensaje= """
                                Depósito exitoso.
                                Su saldo es: %.2f $
                                """.formatted(saldo);  // Usar %d para enteros
                    System.out.println(mensaje);
                    break;
                case 9:
                    System.out.println("Gracias por preferirnos, hasta luego");
                    exit=false;
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    break;

            }

        }
        read.close();  // Cerrar el scanner para evitar posibles fugas de recursos
    }
    public static void DatosCliente(String nombre, String cuenta, double saldo){
        String datosCliente = """
                * Nombre del cliente: %s
                * Tipo de cuenta: %s
                * Saldo: %.2f $
                """.formatted(nombre, cuenta, saldo);  // Formato adecuado para cadenas y enteros
        System.out.println(datosCliente);
    }
    public static void menu(){
        System.out.println("***********************************************");
        System.out.println("Escriba el número de la opción deseada");
        String menu="""
                1-Consultar Saldo
                2-Retirar
                3-Depositar
                9-Salir
                """;
        System.out.println(menu);
    }
    public static double ConsultarSaldo(double cantidad){
        double consultaSaldo=0;
        consultaSaldo+=cantidad;
        return consultaSaldo;
    }
    public static double Retirar(double cantidadRetirar, double saldo ){
        double saldoActual=ConsultarSaldo(saldo);
        return saldoActual-cantidadRetirar;
    }
    public static double Depositar(double cantidadDepositar, double saldo){
        double saldoActual=ConsultarSaldo(saldo);
        return saldoActual+cantidadDepositar;
    }
}