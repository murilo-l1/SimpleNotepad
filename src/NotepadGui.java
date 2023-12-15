import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NotepadGui extends JFrame implements ActionListener {

    private JFrame window;

    //variaveis de controle para a área de texto
    private JTextArea textArea;
    private JScrollPane scrollBar;

    //Top menu
     private JMenuBar menuBar;
     private JMenu menuFile, menuEdit, menuFormat, menuTheme;

    //componentes de 'file'
    private JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //componentes de 'format'
    private JMenuItem iWrap, iFontArial, iFontVerdana, iFontCourierNew, iFontSize16, iFontSize12, iFontSize20;
    private JMenu menuFont, menuFontSize;
    private boolean wordWrapOn = false;

    //componentes de 'EditMenu' - responsavel pelas ações no texto
    private JMenuItem iUndo, iRedo, iFind;
    private UndoManager um = new UndoManager(); // toma conta das ações possíveis de serem desfeitas no documento;



    //referenciando as classes presentes no projeto
    FileInteraction file = new FileInteraction(this);
    FormatInterection format = new FormatInterection(this);
    ThemeInteraction theme = new ThemeInteraction(this);
    EditInteraction edit = new EditInteraction(this);
    KeyHandler key = new KeyHandler(this);

    public NotepadGui(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createThemeMenu();
        theme.setTheme("Dark");
        createEditMenu();
        //setando a fonte default para ser Arial 16
        format.selectedFont = "Arial";
        format.createFontFormat(16);
        createFormatMenu();
    }
    // responsavel por iniciar a janela da aplicação com os seus atributos
    private void createWindow(){
        window = new JFrame("SimpleNotepad");
        window.setSize(1084,643);
        ImageIcon logo = new ImageIcon("C:\\Users\\muril\\IdeaProjects\\SimpleNotepad\\logo.jpeg");
        window.setIconImage(logo.getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    // criando a área de texto que salva o conteúdo digitado pelo usuário para que assim os métodos externos possam modifica - la quando necessario
    private void createTextArea(){
        textArea = new JTextArea();
        // implementando a interface responsavel por lidar com as modificações na área de texto
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                       um.addEdit(e.getEdit());
                    }
                });

        textArea.addKeyListener(key);
        scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setBorder(BorderFactory.createEmptyBorder()); //removendo a borda gerada pela barra de scroll
        window.add(scrollBar);
        //window.add(textArea);
    }
    //top menu e abaixo as opcoes de cada um dos 'sub-menus'
    private void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuTheme = new JMenu("Themes");
        menuBar.add(menuTheme);
    }

    private void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);


        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save as");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save as");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);

    }

    private void createFormatMenu(){
        iWrap = new JMenuItem("Format Text: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Format Text");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontVerdana = new JMenuItem("Verdana");
        iFontVerdana.addActionListener(this);
        iFontArial.setActionCommand("Verdana");
        menuFont.add(iFontVerdana);

        iFontCourierNew = new JMenuItem("Courier New");
        iFontCourierNew.addActionListener(this);
        iFontCourierNew.setActionCommand("CourierNew");
        menuFont.add(iFontCourierNew);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

    }

    private void createThemeMenu(){
        JMenuItem iLight, iDark;
        iLight = new JMenuItem("Light");
        iLight.addActionListener(this);
        iLight.setActionCommand("Light");
        menuTheme.add(iLight);

        iDark = new JMenuItem("Dark");
        iDark.addActionListener(this);
        iDark.setActionCommand("Dark");
        menuTheme.add(iDark);

    }

    private void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);

        iFind = new JMenuItem("Find");
        iFind.addActionListener(this);
        iFind.setActionCommand("Find");
        menuEdit.add(iFind);
    }
    //iteracao de acao de acordo com a seleção do usuario
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New": file.newFile(); break;
            case "Open": file.openFile(); break;
            case "Save": file.saveFile(); break;
            case "Save as": file.saveAsFile(); break;
            case "Exit": file.exitFile(); break;
            case "Format Text": format.formatTextFormat(); break;
            case "Arial", "Verdana", "CourierNew" : format.setFontFormat(command); break;
            case "size12": format.createFontFormat(12); break;
            case "size16": format.createFontFormat(16); break;
            case "size20": format.createFontFormat(20); break;
            case "Light", "Dark" : theme.setTheme(command); break;
            case "Undo": edit.undoEdit(); break;
            case "Redo": edit.redoEdit(); break;
            case "Find": edit.findTextEdit(); break;
        }

    }
    //getters and setters das variaveis que serao acessadas para modificacoes externas
    public JTextArea getTextArea() {
        return textArea;
    }

    public JFrame getWindow() {
        return window;
    }
    public boolean isWordWrapOn() {
        return wordWrapOn;
    }

    public void setWordWrapOn(boolean wordWrapOn) {
        this.wordWrapOn = wordWrapOn;
    }

    public JMenuItem getiWrap() {
        return iWrap;
    }

    public UndoManager getUm() {
        return um;
    }
}