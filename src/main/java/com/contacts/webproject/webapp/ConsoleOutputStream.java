package com.contacts.webproject.webapp;

import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsoleOutputStream extends OutputStream {

    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane jScrollPane;

    public ConsoleOutputStream() {
        this.frame = new JFrame("WebApp");
        this.textArea = new JTextArea();
        this.jScrollPane = new JScrollPane(this.textArea);

        frame.setBounds(1280, 720, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this.jScrollPane);
        frame.setLocation(0, 0);
        frame.setVisible(true);
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}