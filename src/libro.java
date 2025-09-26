import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class libro {
    private int id;
    private String titulo;
    private String autor;
    private int cantidadTotal;
    private int cantidadDisponible;


    public libro() {
    }

    public libro(int id, String titulo, String autor, int cantidadTotal, int cantidadDisponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


    //Metodos Propios
    //Metodo Prestar

    public int prestar(int deseo){

        return this.cantidadDisponible;
    }


    //Metodo Devolver

    public int devolver(int deseo){
        return cantidadDisponible;
    }

    //Metodo to String

    @Override
    public String toString() {
        return "libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadTotal=" + cantidadTotal +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }


    //Metodo Menu


    public static void menu() {
        Scanner leer = new Scanner(System.in);
        List<libro> listaLibros = new ArrayList<>();
        do{
            System.out.println("---------------------Biblioteca-------------------");
            System.out.println("¿Que tramite quiere hacer?");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listas de libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libro");
            System.out.println("6. Eliminar libro ");
            System.out.println("7. Salir");
            System.out.println("Eliga una de las opciones: ");
            int opcion = leer.nextInt();
            switch (opcion){

                case 1:
                    System.out.println("Escriba el ID del libro: ");
                    int id = leer.nextInt();
                    System.out.println("Escriba el Titulo del libro: ");
                    String titulo = leer.next();
                    System.out.println("Escriba el Autor del libro: ");
                    String autor = leer.next();
                    System.out.println("Escriba la cantidad total que hay de este libro: ");
                    int cantidadTotal = leer.nextInt();
                    System.out.println("Escriba cuanta es la cantidad disponible del libro: ");
                    int cantidadDisponible = leer.nextInt();
                    listaLibros.add(new libro(id, titulo, autor, cantidadTotal, cantidadDisponible));
                    break;

                case 2:
                    for (libro N: listaLibros){
                        System.out.println(N);
                    }
                    break;

                case 3:
                    System.out.println("Digite el id del libro que quiere tomar prestado: ");
                    int idLibro = leer.nextInt();

                    boolean existente = false;
                    for (libro N: listaLibros){
                        if (N.getId() == idLibro){
                            System.out.println("Digite cuantos libros quiere tomar prestado: ");
                            int deseo = leer.nextInt();
                            if(deseo>N.cantidadDisponible){
                                System.out.println("No hay esa cantidad de libros, en este momento hay: "+N.cantidadDisponible);
                                System.out.println("Digita otra vez el numero de libros que quieres tomar");
                                deseo = leer.nextInt();
                            }
                            N.prestar(N.cantidadDisponible-=deseo);
                            System.out.println("Quedaron "+N.cantidadDisponible+" libros disponibles");
                        }
                        existente = true;
                        System.out.println("No existe ese libro");
                    }
                    if(!existente)
                        System.out.println("No existe ese libro");
                    break;

                case 4:
                    System.out.println("Digite el id del libro que quiere devolver: ");
                    int idLiro = leer.nextInt();

                    boolean exstente = false;
                    for (libro N: listaLibros){
                        if (N.getId() == idLiro){
                            System.out.println("Digite cuantos libros esta devolviendo: ");
                            int deseo = leer.nextInt();
                            if (deseo<=0){
                                System.out.println("No se devolvio ningun libro");
                            }
                            N.devolver(N.cantidadDisponible+=deseo);
                            System.out.println("Quedaron "+N.cantidadDisponible+" libros disponibles");
                        }
                        exstente = true;
                        System.out.println("No existe ese libro");
                    }
                    if(!exstente)
                        System.out.println("No existe ese libro");
                    break;

                case 5:
                    System.out.println("Digite el id del libro que quiere Buscar: ");
                    int idLio = leer.nextInt();

                    boolean extente = false;
                    for (libro N: listaLibros){
                        if (N.getId() == idLio){
                            System.out.println(N);
                        }
                        extente = true;
                        System.out.println("No existe ese libro");
                    }
                    if(!extente)
                        System.out.println("No existe ese libro");
                    break;

                case 6:
                    System.out.println("Digite el id del libro que quiere eliminar: ");
                    int idLo = leer.nextInt();

                    boolean exente = false;
                    for (libro N: listaLibros){
                        if (N.getId() == idLo){
                            listaLibros.remove(N);
                            System.out.println("Libro eliminado");}
                        exente = true;
                        System.out.println("No existe ese libro");
                    }
                    if(!exente)
                        System.out.println("No existe ese libro");
                    break;

                case 7:
                    System.exit(0);
                    break;
            }
        }while(true);


    }

}
