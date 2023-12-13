import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    NotepadGui notepadGui;

    public KeyHandler(NotepadGui notepadGui){
        this.notepadGui = notepadGui;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            notepadGui.file.saveFile();
        }
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z){
            notepadGui.edit.undoEdit();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y){
            notepadGui.edit.redoEdit();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O){
            notepadGui.file.openFile();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
