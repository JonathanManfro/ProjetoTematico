package projetotematico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class PlayMusicScreen extends JFrame {
    private String message;

    public PlayMusicScreen(String message) {
        this.message = message;
        setTitle("Tela Secundária");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(this.message);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        add(label, BorderLayout.CENTER);

        setVisible(true);
    }
    
    public void iniciarTocar() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                tocar();
            }
        });
        thread.start();
    }
    
    public void tocar() {
        ControllerMusicThread controllerMusic = new ControllerMusicThread("C:\\Users\\manfr\\eclipse-workspace\\aqui\\ProjetoTematico\\Musica\\01 Almost with You.mp3");
        controllerMusic.tocar();
        new QuizScreen().setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        PlayMusicScreen playMusic = new PlayMusicScreen("");
        playMusic.tocar();
    }
}
