import javax.swing.*;

public class NotepadRunner {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            NotepadGui editor = new NotepadGui();
        });
    }
}