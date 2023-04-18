package com.contacts.webproject.webapp;

import java.awt.Color;
import java.awt.Font;
import java.io.OutputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFrameConsoleOutputStream extends OutputStream {

    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane jScrollPane;

    public JFrameConsoleOutputStream() {
        this.frame = new JFrame("WebApp");

        this.textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setFont(new Font(Font.MONOSPACED, 0, 12));

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