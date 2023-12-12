import java.awt.*;

public class FormatInterection {

    NotepadGui notepadGui;
    Font arial, verdana, courierNew;
    String selectedFont;

    public FormatInterection(NotepadGui notepadGui){
        this.notepadGui = notepadGui;
    }

    public void formatTextFormat(){
        if(!notepadGui.isWordWrapOn()){
            notepadGui.setWordWrapOn(true);
            notepadGui.getTextArea().setLineWrap(true);
            notepadGui.getTextArea().setWrapStyleWord(true);
            notepadGui.getiWrap().setText("Format Text: On");
        }
        else{
            notepadGui.setWordWrapOn(false);
            notepadGui.getTextArea().setLineWrap(false);
            notepadGui.getTextArea().setWrapStyleWord(false);
            notepadGui.getiWrap().setText("Format Text: Off");
        }
    }

    public void createFontFormat(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        verdana = new Font("Verdana", Font.PLAIN, fontSize);
        courierNew = new Font("Courier New", Font.PLAIN, fontSize);
        setFontFormat(selectedFont);
    }

    public void setFontFormat(String font){
        selectedFont = font;
        switch (selectedFont){
            case "Arial": notepadGui.getTextArea().setFont(arial); break;
            case "Verdana": notepadGui.getTextArea().setFont(verdana); break;
            case "CourierNew": notepadGui.getTextArea().setFont(courierNew); break;
        }

    }


}
