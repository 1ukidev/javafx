package controle;
import model.Usuario;
import java.util.ArrayList;

public class UsuarioC {
    private ArrayList<Usuario> lista = new ArrayList<Usuario>();

    public boolean adicionarUsuario(Usuario user) {
        boolean retorno = false;
        if(!consultarUsuario(user)) {
            lista.add(user);
            retorno = true;
        }
        return retorno;
    }

    public void mostrarLista() {
        for(int i = 0; i < lista.size(); i++) {
            System.out.println("Nome: " + lista.get(i).getNome());
            System.out.println("Senha: " + lista.get(i).getSenha());
            System.out.println("-----------------------");
        }
    }

    public ArrayList<String> nomes() {
        ArrayList<String> nomes = new ArrayList<String>();
        for(int i = 0; i < lista.size(); i++) {
            nomes.add(lista.get(i).getNome());
        }
        return nomes;
    } 

    public boolean consultarUsuario(Usuario user) {
        boolean retorno = false;
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNome().equals(user.getNome())) {
                retorno = true;
            }
        }
        return retorno;
    }
}