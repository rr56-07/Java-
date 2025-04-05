package DataStructures.LinkedLists;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private final int MAX_HISTORY = 10;

    public void type(String newText) {
        TextState newState = new TextState(newText);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        } else {
            head = newState;
        }
        current = newState;
        newState.next = null;
        enforceHistoryLimit();
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    private void enforceHistoryLimit() {
        int count = 0;
        TextState temp = current;
        while (temp != null && count < MAX_HISTORY) {
            temp = temp.prev;
            count++;
        }
        if (temp != null && temp.prev != null) {
            temp.prev.next = null;
            temp.prev = null;
            head = temp;
        }
    }
}

public class undoredo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.type("Hello Universe");
        editor.displayCurrentState();
        editor.redo();
    }
}
