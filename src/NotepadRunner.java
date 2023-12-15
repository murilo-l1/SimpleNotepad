import javax.swing.*;

public class NotepadRunner {
    public static void main(String[] args) {
        //setando a thread que garante segurança na inicializacao da aplicacao
        SwingUtilities.invokeLater(() -> {
            NotepadGui editor = new NotepadGui();
        });
    }
}