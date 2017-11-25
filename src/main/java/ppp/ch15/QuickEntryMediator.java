package ppp.ch15;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Mediator Pattern
 */
public class QuickEntryMediator {
    private JTextField itsTextField;
    private JList<String> itsList;

    public QuickEntryMediator(JTextField t, JList<String> l) {
        itsTextField = t;
        itsList = l;

        itsTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textFieldChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textFieldChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textFieldChanged();
            }
        });
    }

    private void textFieldChanged() {
        String prefix = itsTextField.getText();

        if (prefix.length() == 0) {
            itsList.clearSelection();
            return;
        }

        ListModel<String> m = itsList.getModel();
        boolean found = false;

        for (int i = 0; found == false && i < m.getSize(); i++) {
            String s = m.getElementAt(i);
            if (s.startsWith(prefix)) {
                itsList.setSelectedValue(s, true);
                found = true;
            }
        }
        if (!found) {
            itsList.clearSelection();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        textField.setBounds(0, 0, 100, 40);

        JList<String> list = new JList<>(new String[] { "hello", "world", "help", "wow" });
        list.setBounds(0, 45, 100, 80);

        frame.add(textField);
        frame.add(list);

        frame.setTitle("Chapter 15 Mediator Pattern");
        frame.setSize(400, 150);
        frame.setLayout(null);
        frame.setVisible(true);

        new QuickEntryMediator(textField, list);
    }
}
