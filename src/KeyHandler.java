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
    // estabelecendo shortcuts basicas como ctrl + s, ctrl + o...
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

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N)
            notepadGui.file.newFile();

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F){
            notepadGui.edit.findTextEdit();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
