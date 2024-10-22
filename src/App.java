import java.util.Scanner;

// Clase base del personaje
class Personaje {
    String nombre;
    int fuerza;
    int velocidad;
    int vida_hp;

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
    public void atacar(Villano villano){
        int dañoRealizado = this.fuerza;
        villano.vida_hp = villano.vida_hp - dañoRealizado;
        System.out.println("Causaste " + dañoRealizado + " de daño a " + villano.nombre);
        System.out.println("Vida restante " + villano.vida_hp);
    }
    /*public void defender(Villano villano){
        int dañoRecibido = villano.fuerza/2;
        System.out.println(this.nombre + " ha recibido " + dañoRecibido + " de daño");
    }*/
    public void aumentarKi(){
        if(this.fuerza >= 500){
            System.out.println("No se puede aumentar más la fuerza");
        }else{
            this.fuerza = this.fuerza*2;
            System.out.println("La fuerza de " + this.nombre +  " ha aumentado a " + this.fuerza);
        }
    }
    public void recuperarse(){
        if(this.vida_hp >= 2000){
            System.out.println("No se puede aumentar más la vida");
        }
            this.vida_hp = this.vida_hp*2;
            System.out.println(this.nombre + " ha aumentado su vida a " + this.vida_hp);
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
        System.out.println("Seleccione una acción para el heroe");
        System.out.println("1 -> Atacar");
        //System.out.println("2 -> Defender");
        System.out.println("3 -> Aumentar Ataque");
        System.out.println("4 -> Recuperarse");
        System.out.println("5 -> Estadisticas actuales");
        System.out.println("6 -> Ataque especial");
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
    public void atacarVillano(SuperHero superHero){
        int dañoRealizado = this.fuerza;
        superHero.vida_hp = superHero.vida_hp - dañoRealizado;
        System.out.println("Causaste " + dañoRealizado + " de daño a " + superHero.nombre);
        System.out.println("Vida restante " + superHero.vida_hp);
    }
    /*public void defenderVillano(SuperHero superHero){
        int dañoRecibido = superHero.fuerza/2;
        System.out.println(this.nombre + " ha recibido " + dañoRecibido + " de daño");
    }*/
    public void aumentarAtaqueVillano(){
        if(this.fuerza >= 500){
            System.out.println("No se puede aumentar más la fuerza");
        }else{
        this.fuerza = this.fuerza*2;
        System.out.println("La fuerza de " + this.nombre +  " ha aumentado a " + this.fuerza);
        }
    }
    public void recuperarseVillano(){
     if(this.vida_hp >= 20000)
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
        System.out.println("Has intercambiado la fuerza con el enemigo");
        int intercambio = superHero.fuerza;
        superHero.fuerza = this.fuerza;
        this.fuerza = intercambio;
        System.out.println("Fuerza actual " + this.fuerza);
    }
    public void accionesVillano(){
        System.out.println("Seleccione una acción para el villano");
        System.out.println("1 -> Atacar");
        //System.out.println("2 -> Defender");
        System.out.println("3 -> Aumentar Ki");
        System.out.println("4 -> Recuperarse");
        System.out.println("5 -> Estadisticas actuales");
        System.out.println("6 -> Truco");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Primero crearemos a tu superheroe");
        System.out.println("Digite el nombre");
        String nombre = scanner.nextLine();
        System.out.println("Digite la fuerza");
        int fuerza = scanner.nextInt();
        System.out.println("Digite la velocidad");
        int velocidad = scanner.nextInt();
        System.out.println("Digite la vida");
        int vida = scanner.nextInt();
        SuperHero superHeroe = new SuperHero(nombre, fuerza, velocidad, vida);
        scanner.nextLine();
        System.out.println("Ahora crea los atributos para el villano");
        System.out.println("Digite el nombre");
        String nombreVillano = scanner.nextLine();
        System.out.println("Digite la fuerza");
        int fuerzaVillano = scanner.nextInt();
        System.out.println("Digite la velocidad");
        int velocidadVillano= scanner.nextInt();
        System.out.println("Digite la vida");
        int vidaVillano = scanner.nextInt();
        Villano villano = new Villano(nombreVillano, fuerzaVillano, velocidadVillano, vidaVillano);
        int turnoheroe;
        if(superHeroe.velocidad >= villano.velocidad){
            turnoheroe = 1;  
        }else{
            turnoheroe = 0;  
        }

        while (villano.vida_hp > 0 && superHeroe.vida_hp > 0) {
            
            //Turno del heroe
            if(turnoheroe == 1){
                superHeroe.acciones();
                int accion = scanner.nextInt();
                switch (accion) {
                    case 1:
                        superHeroe.atacar(villano);
                        break;
                    case 2:
                        //superHeroe.defender(villano);
                        break;
                    case 3:
                        superHeroe.aumentarKi();
                        break;
                    case 4:
                        superHeroe.recuperarse();
                        break;
                    case 5:
                        superHeroe.estadisticas();
                        break;
                    case 6:
                        superHeroe.ataqueEspecial(villano);
                        break;
                    default:
                        System.out.println("Acción no seleccionada, has perdido el turno");
                        break;   
                }
            
                if(villano.vida_hp <= 0){
                    System.out.println("Los heroes han ganado");
                }
                else{
                    turnoheroe = 0;
                }
            }
            if(turnoheroe == 0){
                //Villano Turno
                villano.accionesVillano();
                int accionVillano = scanner.nextInt();
                switch (accionVillano) {
                    case 1:
                        villano.atacarVillano(superHeroe);
                        break;
                    case 2:
                        //villano.defenderVillano(superHeroe);
                        break;
                    case 3:
                        villano.aumentarAtaqueVillano();
                        break;
                    case 4:
                        villano.recuperarseVillano();
                        break;
                    case 5:
                        villano.estadisticasVillano();
                        break;
                    case 6:
                        villano.trampaVillano(superHeroe);
                        break;
                    default:
                        System.out.println("Acción no seleccionada, has perdido el turno");
                        break;   
                }
                if(superHeroe.vida_hp <= 0){
                    System.out.println("Los villano han ganado");
                }else{
                    turnoheroe = 1;
                }
            }
            
        }

    }
}
