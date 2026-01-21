import java.util.*;

class Solution {

    private StringBuilder document = new StringBuilder();
    private Stack<Character> undoStack = new Stack<>();
    private Stack<Character> redoStack = new Stack<>();

    // append x into document
    public void append(char x) {
        document.append(x);
        undoStack.push(x);
        redoStack.clear();   // new operation clears redo history
    }

    // undo last change
    public void undo() {
        if (!undoStack.isEmpty()) {
            char ch = undoStack.pop();
            document.deleteCharAt(document.length() - 1);
            redoStack.push(ch);
        }
    }

    // redo changes
    public void redo() {
        if (!redoStack.isEmpty()) {
            char ch = redoStack.pop();
            document.append(ch);
            undoStack.push(ch);
        }
    }

    // read the document
    public String read() {
        return document.toString();
    }
}
