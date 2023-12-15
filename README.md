<h1>SimpleNotepad</h1>
<h2>Introduction</h2>
<p>
    The SimpleNotepad is a Java-based application that lets the user take simple notes with the basic functionalities of a notepad.
</p>

<p align="center">
    <img src="https://github.com/murilo-l1/SimpleNotepad/blob/master/projectimage.png" align="center">
</p>

<h2>Technologies Used</h2>
<p>
    Utilizes the default Swing library of raw Java.
</p>

<h2>Class Summaries</h2>

<h3>1.0. NotepadGui </h3>
<p>
    <strong>Description:</strong> This class is responsible for showing the menus and sub - menus, handles the main window properties, the basics of the user interface.
</p>
<p>
    <strong>Summary:</strong> The main focus is to also implements the action - performed method that makes the interactivity between the other classes.
</p>

<h3>2.0. EditInteraction </h3>
<p>
    <strong>Description:</strong> This class handles the undo, redo and find functionalities with the help of the UndoManager presented in NotepadGui that has direct access of the textArea being used.
</p>

<h3>3.0. FileInteraction </h3>
<p>
    <strong>Description:</strong> This class is responsible of managing the files that are brought to the application, letting you create a new file, save, open, name it or just simple exiting the application. 
</p>

<h3>4.0. FormatInteraction </h3>
<p>
    <strong>Description:</strong> This class handles the options of the user to select the desired font and size, as well as the FormatText that wraps the words making the notes more readable.
</p>

<h3>5.0. ThemeInteraction </h3>
<p>
    <strong>Description:</strong> Simirlarly to 'FormatInteraction', lets the user swicth between two main styles - 'Light and 'Dark' that changes the background and text of the application.
</p>

<h3>6.0. KeyHandler </h3>
<p>
    <strong>Description:</strong> Manages the main shortcuts - 'ctrl + s', 'ctrl + o', 'ctrl + z', etc using a KeyBoardListener.
</p>

<h3>7.0. NotepadRunner </h3>
<p>
    <strong>Description:</strong> The NotepadRunner class serves as the initializer for the GUI using the 'invokelater()' to initialize the thread and display the window generated in 'NotepadGui'.
</p>


<p align="center">
    <img src="https://github.com/murilo-l1/SimpleNotepad/blob/master/logo.jpeg" align="center">
</p>

<p align="center">
	Credits for the logo: @JhuliaVitoriaFelix, my love <3
</p>
