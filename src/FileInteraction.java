import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInteraction {
    private final NotepadGui notepadGui;
    private String fileName;
    private String filePath;


    public FileInteraction(NotepadGui notepadGui){
        this.notepadGui = notepadGui;
    }

    // criar um arquivo ao acessar a aba em 'File'
    public void newFile(){
        notepadGui.getTextArea().setText("");
        notepadGui.getWindow().setTitle("New");
        fileName = null;
        filePath = null;
    }

    // abrir um arquivo de texto presente no computador
    public void openFile(){
        FileDialog fileDialog = new FileDialog(notepadGui.getWindow(), "Open File", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if(fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            filePath = fileDialog.getDirectory();
            notepadGui.getWindow().setTitle(fileName);
        }else{
            System.out.println("Não foi possível carregar o arquivo do explorador.");
        }

        //pegando os dados do arquivo desejado para que possa ser copiado para o nosso notepad
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath + fileName));
            notepadGui.getTextArea().setText(""); // nova area de texto comeca vazia

            String line; // linha que vai armazenar os dados a serem lidos

            // enquanto houver conteúdo a ser lido do arquivo
            while((line = br.readLine()) != null){
                notepadGui.getTextArea().append(line + "\n");
            }

            br.close();

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void saveFile(){
            if(fileName == null){
                saveAsFile();
            }else{
                try {
                    FileWriter fw = new FileWriter(filePath + fileName);
                    fw.write(notepadGui.getTextArea().getText());
                    notepadGui.getWindow().setTitle(fileName);

                    if(!fileName.toLowerCase().endsWith(".txt")){
                        fileName = fileName + ".txt";
                    }

                    fw.close();

                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

    }
    public void saveAsFile(){
            FileDialog fileDialog = new FileDialog(notepadGui.getWindow(), "Save as", FileDialog.SAVE);
            fileDialog.setVisible(true);
             if(fileDialog.getFile() != null){
                fileName = fileDialog.getFile();
                filePath = fileDialog.getDirectory();
                notepadGui.getWindow().setTitle(fileName);
            }
             else{
            System.out.println("Não foi possível carregar o arquivo do explorador.");
            }

             if(!fileName.toLowerCase().endsWith(".txt")){
                 fileName = fileName + ".txt";
             }

            try {
                FileWriter fw = new FileWriter(filePath + fileName);
                fw.write(notepadGui.getTextArea().getText());
                fw.close();

            }catch (IOException ioe){
                ioe.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }

    public void exitFile(){
        System.exit(0);
    }

}