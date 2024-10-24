import java.util.Scanner;

// Clase base del personaje
class Personaje {
    String nombre;
    int fuerza;
    int velocidad;
    int vida_hp;
    Scanner scanner = new Scanner(System.in);
    // Definir constructor
    public Personaje(
            String nombre,
            int fuerza,
            int velocidad,
            int vida_hp) 
    {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
    }
}

class SuperHero extends Personaje {
    // definir el constructor
    public SuperHero(
        String nombre,
        int fuerza,
        int velocidad,
        int vida_hp)
    {
            super(nombre, fuerza, velocidad, vida_hp);

    }
    public boolean atacar(Villano villano){
        // EN la funcion de ataque se ejecuta la defenza segun la decision que se tome, si se defiende se consume el turno 
        System.out.println(this.nombre + " va a atacar");
        System.out.println(villano.nombre + " quiere defenderse?");
        System.out.println("Seleccione");
        System.out.println("1 -> Sí");
        System.out.println("2 -> No");
        int seleccion = scanner.nextInt();
        if(seleccion == 1){
            villano.defenderVillano(this.fuerza);
            return true;
        }else{
            int dañoRealizado = this.fuerza;
            villano.vida_hp -= dañoRealizado;
            System.out.println("Causaste " + dañoRealizado + " de daño a " + villano.nombre);
            System.out.println("Vida restante " + villano.vida_hp);
            return false;
        }

    }
    public void defender(int daño){
        // reduce el daño que se le pasa entre dos y lo resta a la vida actual
        int dañoRecibido = daño/2;
        this.vida_hp -= dañoRecibido;
        System.out.println(this.nombre + " ha recibido " + dañoRecibido + " de daño");
    }
    public void aumentarKi(){
        // ataque maximo para aumentar: 500
        if(this.fuerza >= 500){
            System.out.println("No se puede aumentar más la fuerza");
        }else{
            this.fuerza = this.fuerza*2;
            System.out.println("La fuerza de " + this.nombre +  " ha aumentado a " + this.fuerza);
        }
    }
    public void recuperarse(){
        // vida maxima 4000
        if(this.vida_hp >= 4000){
            System.out.println("No se puede aumentar más la vida");
        }else{
            this.vida_hp = this.vida_hp*2;
            System.out.println(this.nombre + " ha aumentado su vida a " + this.vida_hp);
        }
    }
    public void estadisticas(){
        System.out.println("Estadisticas de " + this.nombre);
        System.out.println("fuerza " + this.fuerza);
        System.out.println("vida " + this.vida_hp);
        System.out.println("velocidad " + this.velocidad);
    }
    public void ataqueEspecial(Villano villano){
        System.out.println("Has realizado un KameHameHa");
        
        villano.vida_hp -= 500;
        System.out.println("Has reducido 500 puntos de vida a " + villano.nombre);
    }
    public void acciones(){
        System.out.println("Seleccione una acción para " + this.nombre);
        System.out.println("1 -> Atacar");
        System.out.println("2 -> Aumentar Ataque");
        System.out.println("3 -> Recuperarse");
        System.out.println("4 -> Estadisticas actuales");
        System.out.println("5 -> Ataque especial");
    }
}

class Villano extends Personaje {
    // definir el constructor
    public Villano(
        String nombre,
        int fuerza,
        int velocidad,
        int vida_hp)
    {
            super(nombre, fuerza, velocidad, vida_hp);
    }
    public boolean atacarVillano(SuperHero superHero){
        System.out.println(this.nombre + " va a atacar");
        System.out.println(superHero.nombre + " quiere defenderse?");
        System.out.println("Seleccione");
        System.out.println("1 -> Sí");
        System.out.println("2 -> No");
        int seleccion = scanner.nextInt();
        if(seleccion == 1){
            superHero.defender(this.fuerza);
            return true;
        }else{
            int dañoRealizado = this.fuerza;
            superHero.vida_hp -= dañoRealizado;
            System.out.println("Causaste " + dañoRealizado + " de daño a " + superHero.nombre);
            System.out.println("Vida restante " + superHero.vida_hp);
            return false;
        }
    }
    public void defenderVillano(int daño){
        int dañoRecibido = daño/2;
        this.vida_hp -= dañoRecibido;
        System.out.println(this.nombre + " ha recibido " + dañoRecibido + " de daño");
    }
    public void aumentarAtaqueVillano(){
        if(this.fuerza >= 500){
            System.out.println("No se puede aumentar más la fuerza");
        }else{
        this.fuerza = this.fuerza*2;
        System.out.println("La fuerza de " + this.nombre +  " ha aumentado a " + this.fuerza);
        }
    }
    public void recuperarseVillano(){
     if(this.vida_hp >= 4000)
     {
     System.out.println("No se puede aumentar más la vida");
    }else{
        this.vida_hp = this.vida_hp*2;
        System.out.println(this.nombre + " ha aumentado su vida a " + this.vida_hp);  
    }

    }
    public void estadisticasVillano(){
        System.out.println("Estadisticas de " + this.nombre);
        System.out.println("fuerza " + this.fuerza);
        System.out.println("vida " + this.vida_hp);
        System.out.println("velocidad " + this.velocidad);
    }
    public void trampaVillano(SuperHero superHero){
        // hace referencia al ataque del heroe y lo cambia por la actual del villano
        System.out.println("Has intercambiado la fuerza con " + superHero.nombre);
        int intercambio = superHero.fuerza;
        superHero.fuerza = this.fuerza;
        this.fuerza = intercambio;
        System.out.println("Fuerza actual " + this.fuerza);
    }
    public void accionesVillano(){
        System.out.println("Seleccione una acción para " + this.nombre);
        System.out.println("1 -> Atacar");
        System.out.println("2 -> Aumentar Ki");
        System.out.println("3 -> Recuperarse");
        System.out.println("4 -> Estadisticas actuales");
        System.out.println("5 -> Truco");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SuperHero superHeroe = null;
        Villano villano = null;
        int personaje;
        String nombre = null;
        int fuerza = 0;
        int velocidad = 0;
        int vida = 0;
        boolean turnoDeHeroe = false;
        boolean turnoDeVillano = false;
        boolean validacion;
        int cantidadJugadores = 2;
        for(int i = 1; i <= cantidadJugadores; i++){
            //Esto me ayudará a que no ingresen un dato mal de la tabla
            validacion = false;
            // Calcula si el numero es impar o par
            double calculo = i % 2;
            String roll = (calculo  == 0) ? "Villano" : "Heroe";
            while(!validacion){
                System.out.println("Seleccione un personaje para el " + roll);
                System.out.println("1 -> Goku");
                System.out.println("2 -> Vegeta");
                System.out.println("3 -> Son Gohan");
                System.out.println("4 -> Freezer");
                System.out.println("5 -> Broly");
                System.out.println("6 -> Krilin");
                // Pide el numero para seleccionar y crear automaticamente los valores de los atributos
                personaje = scanner.nextInt();
                switch (personaje) {
                    case 1:
                        nombre = "Goku";
                        fuerza = 300;
                        velocidad = 1000;
                        vida = 2000;
                        System.out.println("Has seleccionado a " + nombre);
                        validacion = true;
                        break;
                    case 2:
                        nombre = "Vegeta";
                        fuerza = 260;
                        velocidad = 1100;
                        vida = 1800;
                        System.out.println("Has seleccionado a " + nombre);
                        validacion = true;
                        break;
                    case 3:
                        nombre = "Son Gohan";
                        fuerza = 260;
                        velocidad = 900;
                        vida = 2000;
                        System.out.println("Has seleccionado a " + nombre);
                        validacion = true;
                        break;
                    case 4:
                        nombre = "Freezer";
                        fuerza = 300;
                        velocidad = 1400;
                        vida = 1600;
                        System.out.println("Has seleccionado a " + nombre);
                        validacion = true;
                        break;
                    case 5:
                        nombre = "Broly";
                        fuerza = 450;
                        velocidad = 800;
                        vida = 2500;
                        System.out.println("Has seleccionado a " + nombre);
                        validacion = true;
                        break;
                    case 6:
                        nombre = "Krilin";
                        fuerza = 500;
                        velocidad = 1000;
                        vida = 4000;
                        System.out.println("Has seleccionado a " + nombre);
                        validacion = true;
                        break;
                    default:
                        System.out.println("Numero invalido, seleccione otra vez");
                        validacion = false;
                        break;
                }
            }
                if(calculo == 0){
                    villano = new Villano(nombre, fuerza, velocidad, vida);
                }else{
                    superHeroe = new SuperHero(nombre, fuerza, velocidad, vida);
                }
        }
        int turno;
        if(superHeroe.velocidad >= villano.velocidad){
            turno = 1;  
        }else{
            turno = 0;  
        }
        while (villano.vida_hp > 0 && superHeroe.vida_hp > 0) {
            
            
            //Turno del heroe
            if(turno == 1){
                if(!turnoDeHeroe){
                    superHeroe.acciones();
                    int accion = scanner.nextInt();
                    switch (accion) {
                        case 1:
                            turnoDeVillano = superHeroe.atacar(villano);
                            break;
                        case 2:
                            superHeroe.aumentarKi();
                            break;
                        case 3:
                            superHeroe.recuperarse();
                            break;
                        case 4:
                            superHeroe.estadisticas();
                            break;
                        case 5:
                            superHeroe.ataqueEspecial(villano);
                            break;
                        default:
                            System.out.println("Acción no seleccionada, has perdido el turno");
                            break;   
                    }
                }else{
                    turnoDeHeroe = false;
                }
            
                if(villano.vida_hp <= 0){
                    System.out.println("Los heroes han ganado");
                }
                else{ // Si no se defendió, cambia el turno
                    turno = 0; 
                }
            }
            if(turno == 0){
                if(!turnoDeVillano){
                    //Villano Turno
                    villano.accionesVillano();
                    int accionVillano = scanner.nextInt();
                    switch (accionVillano) {
                        case 1:
                            turnoDeHeroe = villano.atacarVillano(superHeroe);
                            break;
                        case 2:
                            villano.aumentarAtaqueVillano();
                            break;
                        case 3:
                            villano.recuperarseVillano();
                            break;
                        case 4:
                            villano.estadisticasVillano();
                            break;
                        case 5:
                            villano.trampaVillano(superHeroe);
                            break;
                        default:
                            System.out.println("Acción no seleccionada, has perdido el turno");
                            break;   
                    }
                }else{
                    turnoDeVillano = false;
                }
                if(superHeroe.vida_hp <= 0){
                    System.out.println("Los villano han ganado");
                }else{ // Si no se defendió, cambia el turno
                    turno = 1;
                }
            }
            
        }

    }
}
