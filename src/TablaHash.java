import java.util.LinkedList;

public class TablaHash {
    private LinkedList<Usuario>[] tabla;
    private int tamaño;

    public TablaHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];

        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % tamaño;
    }

    // Insertar nuevo usuario
    public boolean insertar(Usuario usuario) {
        int indice = hash(usuario.getUsername());

        for (Usuario u : tabla[indice]) {
            if (u.getUsername().equals(usuario.getUsername())) {
                return false; // usuario duplicado
            }
        }

        tabla[indice].add(usuario);
        return true;
    }

    // Buscar usuario
    public Usuario buscar(String username) {
        int indice = hash(username);

        for (Usuario u : tabla[indice]) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    // Eliminar usuario
    public boolean eliminar(String username) {
        int indice = hash(username);

        for (Usuario u : tabla[indice]) {
            if (u.getUsername().equals(username)) {
                tabla[indice].remove(u);
                return true;
            }
        }
        return false;
    }
}
