import javax.swing.*;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.io.IOException;

public class EditInteraction  {
    private NotepadGui notepadGui;

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

    public void findTextEdit() {
        String searchTerm = JOptionPane.showInputDialog(notepadGui.getWindow(), "Insert the term to find:"); //popando a janela que solicitara o termo
        String textDocument = notepadGui.getTextArea().getText();
        BufferedReader br = new BufferedReader(new StringReader(textDocument));
        HashMap<String, Integer> occurrences = new HashMap<>(); // mapa responsavel pela contagem após comparações
        String line; //linha vazia que vai receber as linhas do arquivo

        try {
            while ((line = br.readLine()) != null) {
                //dividido as linhas em uma array de palavras
                String[] words = line.split("\\s+");

                // Checando se a palavra pesquisada existe na linha de busca
                for (String word : words) {
                    // Via regex, remove os itens que podem atrapalhar a busca
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    // se a palavra sem qualquer detalhe que pode impactar a busca é igual a palavra pesquisada, incrementa a contagem
                    if (cleanWord.equals(searchTerm.toLowerCase())) {
                        // Increment the occurrence count
                        occurrences.put(searchTerm, occurrences.getOrDefault(searchTerm, 0) + 1);
                    }
                }
            }

            // Mostrando ao usuario assim como da maneira que foi pedido (MessageDialog)
            if (occurrences.containsKey(searchTerm)) {
                int count = occurrences.get(searchTerm);
                JOptionPane.showMessageDialog(notepadGui.getWindow(), "Found " + count + " occurrences of '" + searchTerm + "'");
            } else {
                JOptionPane.showMessageDialog(notepadGui.getWindow(), "No occurrences of '" + searchTerm + "' found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}