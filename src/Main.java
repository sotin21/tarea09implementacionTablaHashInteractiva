import java.util.Scanner;


public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TablaHash usuarios = new TablaHash(20);

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Validar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1: // Registrar
                    System.out.print("Ingrese nombre de usuario: ");
                    String username = sc.nextLine();

                    System.out.print("Ingrese contraseña: ");
                    String password = sc.nextLine();

                    if (usuarios.insertar(new Usuario(username, password))) {
                        System.out.println("✔ Usuario registrado correctamente.");
                    } else {
                        System.out.println("❌ El nombre de usuario ya existe.");
                    }
                    break;

                case 2: // Validar
                    System.out.print("Ingrese nombre de usuario: ");
                    String user = sc.nextLine();

                    System.out.print("Ingrese contraseña: ");
                    String pass = sc.nextLine();

                    Usuario encontrado = usuarios.buscar(user);

                    if (encontrado != null && encontrado.getPassword().equals(pass)) {
                        System.out.println("✔ Acceso permitido.");
                    } else {
                        System.out.println("❌ Usuario inexistente o contraseña incorrecta.");
                    }
                    break;

                case 3: // Eliminar
                    System.out.print("Ingrese el nombre del usuario a eliminar: ");
                    String eliminarUser = sc.nextLine();

                    if (usuarios.eliminar(eliminarUser)) {
                        System.out.println("✔ Usuario eliminado correctamente.");
                    } else {
                        System.out.println("❌ No se encontró el usuario.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
}
