package projetotematico;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AddInfosScreen extends JFrame {
    private JTextField musicField;
    private JTextField questionField;
    private JTextField answerField;
    private File selectedMusicFile = null;

    public AddInfosScreen() {
        setTitle("Adicionar Informações");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel musicLabel = new JLabel("Música:");
        JLabel questionLabel = new JLabel("Pergunta:");
        JLabel answerLabel = new JLabel("Resposta:");
        musicField = new JTextField(20);
        questionField = new JTextField(20);
        answerField = new JTextField(20);
        JButton fileChooserButton = new JButton("Selecionar MP3");

        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos MP3", "mp3"));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedMusicFile = fileChooser.getSelectedFile();
                    musicField.setText(selectedMusicFile.getAbsolutePath());
                }
            }
        });

        JButton saveButton = new JButton("Salvar");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica se um arquivo de música foi selecionado
                if (selectedMusicFile != null) {
                    // Define o caminho de destino onde a música será armazenada
                    String destinationPath = "C:\\Users\\manfr\\eclipse-workspace\\ProjetoTematico\\Musica";

                    try {
                        // Copia o arquivo selecionado para o destino
                        Files.copy(
                            selectedMusicFile.toPath(),
                            new File(destinationPath, selectedMusicFile.getName()).toPath(),
                            StandardCopyOption.REPLACE_EXISTING
                        );

                        // Agora você tem o arquivo de música na pasta de destino
                        // Você pode salvar o caminho desse arquivo no banco de dados
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        // Trate qualquer exceção de cópia aqui
                    }
                }
                
                // Lógica para salvar as informações no banco de dados
                saveData();
            }
        });

        panel.add(musicLabel);
        panel.add(musicField);
        panel.add(questionLabel);
        panel.add(questionField);
        panel.add(answerLabel);
        panel.add(answerField);
        panel.add(fileChooserButton);
        panel.add(saveButton);

        add(panel);
        setVisible(true);
    }

    private void saveData() {
        // Implemente a lógica para salvar as informações no banco de dados
        // Use as informações dos campos musicField, questionField e answerField
        // Após salvar, você pode limpar os campos ou fazer outras ações necessárias
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddInfosScreen();
            }
        });
    }
}
