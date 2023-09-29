package projetotematico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Tela de Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margens internas entre os componentes

        JLabel usernameLabel = new JLabel("Usuário:");
        JLabel passwordLabel = new JLabel("Senha:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Entrar");
        JButton cadastreSeButton = new JButton("Cadastre-se"); // Novo botão de cadastro

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica de autenticação aqui
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                // Verifique o nome de usuário e senha no banco de dados ou em algum local seguro
                // Aqui, assumimos que o usuário admin é "admin" e a senha é "admin123"
                if (username.equals("admin") && password.equals("admin123")) {
                    openAddInfosScreen(); // Abra a tela AddInfosScreen para o usuário admin
                } else {
                    openInitialScreen(); // Abra a tela InitialScreen para outros usuários
                }
            }
        });

        cadastreSeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCadastroScreen(); // Abra a tela de cadastro
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cadastreSeButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void openAddInfosScreen() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddInfosScreen(); // Abra a tela AddInfosScreen para o usuário admin
                dispose(); // Feche a tela de login
            }
        });
    }

    private void openInitialScreen() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InitialScreen(); // Abra a tela InitialScreen para outros usuários
                dispose(); // Feche a tela de login
            }
        });
    }

    private void openCadastroScreen() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroScreen(); // Abra a tela de cadastro
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen();
            }
        });
    }
}
