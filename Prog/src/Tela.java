import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.Usuario;
import controle.UsuarioC;
import java.util.List;

public class Tela {
    private UsuarioC controle = new UsuarioC();

    @FXML
    private AnchorPane Tela;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnCancelar;

    @FXML
    private PasswordField campoConfirmar;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    private ChoiceBox<?> listaUsuarios;

    void alertaErro(String texto) {
        Alert mensagem = new Alert(AlertType.ERROR);
        mensagem.setContentText(texto);
        mensagem.show();
    }

    void alertaInfo(String texto) {
        Alert mensagem = new Alert(AlertType.INFORMATION);
        mensagem.setContentText(texto);
        mensagem.show();
    }

    @FXML
    void cadastrar(ActionEvent event) {
        if(campoSenha.getText().equals("") || campoConfirmar.getText().equals("")) {
            alertaErro("Senhas não podem ser em branco.");
        } else if(!campoSenha.getText().equals(campoConfirmar.getText())) {
            alertaErro("Senhas estão diferentes.");
        } else if(campoUsuario.getText().equals("")) {
            alertaErro("Deixe de ser jumento e preencha o nome do usuário.");
        } else {
            // Criando um objeto da classe modelo.
            Usuario user = new Usuario();
            // Populando o objeto.
            user.setNome(campoUsuario.getText());
            user.setSenha(campoSenha.getText());
            if(controle.adicionarUsuario(user)) {
                alertaInfo("Usuário cadastrado com sucesso.");
                listaUsuarios.getItems().clear();
                listaUsuarios.getItems().addAll(controle.nomes());
            } else {
                alertaErro("Usuário já cadastrado");
            }
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        campoUsuario.setText("");
        campoSenha.setText("");
        campoConfirmar.setText("");
    }
}
