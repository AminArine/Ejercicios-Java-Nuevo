public class clases {

    static class Book {
        String title;
        String author;

        public Book(String title, String author) {
            this.author = author;
            this.title = title;
        }

        public static void Presentacio(String author, String title) {
            System.out.println("El libro titulado '" + title + "' fue escrito por " + author);
        }
    }
    static class Dog{
        String sonido;
        public Dog(String sonido){
            this.sonido=sonido;
        }
        public static void ladrido(String sonido){
            System.out.println("! WOOOF,WOOOF !");
        }
    }
    
    static class Car{
        String brand;
        String model;
        public Car( String brand,String model){
            this.brand=brand;
            this.model=model;
        }
        public static void showData(String brand,String model){
            System.out.println("Mi coche es de la marca "+brand+" y es de modelo "+model);
        }
    }
    static class Student{
        int score;
        public Student(int score){
            this.score=score;
        }
        public static void nota(int score){
           if(score<60){
            System.out.println("Suspensoooo");
           }else{
             System.out.println("Aprobadooooooo");
           }
        }
    }
    static class BankAccount{
        int balance;
        int cuenta;
        public BankAccount(int balance,int cuenta){
            this.balance=balance;
            this.cuenta=cuenta;
        }
        public static void deposit(int balance,int cuenta){
           System.out.println("Su saldo inicial es de ...."+cuenta );
           cuenta+=balance;
           System.out.println("Su saldo actual es de ...."+cuenta);

        }
    }
    static class Rectangle{
        int ladoancho;
        int ladolargo;
        public Rectangle(int ladolargo,int ladoancho){
            this.ladolargo=ladolargo;
            this.ladoancho=ladoancho;
        }
        public static void area(int ladolargo,int ladoancho){
            int calculoarea=0;
            calculoarea=ladoancho*ladolargo;
           System.out.println("Su saldo inicial es de ...."+calculoarea );

        }
        public static void perimetro(int ladolargo,int ladoancho){
            int calculoperimetro=0;
            calculoperimetro=2*(ladoancho*ladolargo);
           System.out.println("Su saldo inicial es de ...."+calculoperimetro );
           
        }
    }
    static class Worker{
        String nombre;
        int salario;
        public Worker( String nombre,int salario){
            this.nombre=nombre;
            this.salario=salario;
        }
        public static void showData(String nombre,int salario){
            System.out.println("Mi nombre es  "+nombre+" y cobro  "+salario+"$");
        }
    }

    public static void main(String[] args) {

        // 1. Crea una clase Book con atributos title y author. Crea un objeto y muestra sus datos.
        // 2. Crea una clase Dog con un método bark() que imprima su sonido.

        // 3. Añade un constructor a la clase Book que reciba title y author.

        // 4. Crea una clase Car con atributos brand y model y un método showData().

        // 5. Crea una clase Student con atributo score y un método que diga si aprobó (mayor o igual a 60).

        // 6. Crea una clase BankAccount con atributo balance y un método deposit() que sume el saldo.

        // 7. Crea una clase Rectangle con métodos para calcular el área y el perímetro.

        // 8. Crea una clase Worker que reciba nombre y salario, y un método para mostrar su salario.

        // 9. Crea varios objetos Person y guárdalos en un ArrayList.

        // 10. Crea una clase Product y un método que aplique un descuento sobre su precio.
    }
}
