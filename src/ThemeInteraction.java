import java.awt.*;

public class ThemeInteraction {

    NotepadGui notepadGui;


    public ThemeInteraction(NotepadGui notepadGui){
        this.notepadGui = notepadGui;
    }

    public void setTheme(String themeName){
        switch(themeName) {
            case "Light": {
                notepadGui.getWindow().getContentPane().setBackground(new Color(255, 255, 240));
                notepadGui.getTextArea().setBackground(new Color(255, 255, 240));
                notepadGui.getTextArea().setForeground(Color.BLACK);
                notepadGui.getTextArea().setCaretColor(Color.BLACK);
                break;
            }
            case "Dark": {
                notepadGui.getWindow().getContentPane().setBackground(Color.darkGray);
                notepadGui.getTextArea().setBackground(Color.darkGray);
                notepadGui.getTextArea().setForeground(Color.WHITE);
                notepadGui.getTextArea().setCaretColor(Color.white);
                break;
            }


        }



    }


}
