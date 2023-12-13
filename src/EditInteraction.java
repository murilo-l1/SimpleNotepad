public class EditInteraction  {
    NotepadGui notepadGui;

    public EditInteraction(NotepadGui notepadGui){
        this.notepadGui = notepadGui;
    }

    public void undoEdit(){
            if(notepadGui.getUm().canUndo()){
                notepadGui.getUm().undo();
            }
    }

    public void redoEdit(){
        if(notepadGui.getUm().canRedo()){
            notepadGui.getUm().redo();
        }
    }

    // findEdit() a ser implementado: contendo um pop de uma janelinha e fazendo um highlight nas palavras encontradas




}