package projetotematico;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialScreen extends JFrame {
    public InitialScreen() {
        setTitle("Tela Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton botao = new JButton("Iniciar Jogo");

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                String message = "APÓS 45 SEGUNDOS VOCÊ SERÁ DIRECIONADO A TELA DE PERGUNTAS";
                // Abre a tela secundária em uma thread separada
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        PlayMusicScreen playMusic = new PlayMusicScreen(message);
                        playMusic.setVisible(true);
                        // Inicia a reprodução de música na tela secundária
                        playMusic.iniciarTocar();
                    }
                });
            }
        });

        setLayout(new BorderLayout());
        add(botao, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InitialScreen().setVisible(true);
            }
        });
    }
}
