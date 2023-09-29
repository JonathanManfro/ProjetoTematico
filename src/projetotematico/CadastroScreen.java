package projetotematico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton adminRadioButton;
    private JRadioButton userRadioButton;

    public CadastroScreen() {
        setTitle("Cadastro de Usuário");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel usernameLabel = new JLabel("Novo Usuário:");
        JLabel passwordLabel = new JLabel("Nova Senha:");
        JLabel roleLabel = new JLabel("Função:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        ButtonGroup roleGroup = new ButtonGroup();
        adminRadioButton = new JRadioButton("Administrador");
        userRadioButton = new JRadioButton("Usuário");

        roleGroup.add(adminRadioButton);
        roleGroup.add(userRadioButton);

        JButton cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para salvar o novo usuário no banco de dados
                String novoUsuario = usernameField.getText();
                String novaSenha = new String(passwordField.getPassword());
                String funcao = adminRadioButton.isSelected() ? "Administrador" : "Usuário";

                // Faça algo com os dados, como salvá-los no banco de dados
                // Por enquanto, só exibiremos os dados como exemplo:
                JOptionPane.showMessageDialog(null, "Novo Usuário: " + novoUsuario + "\nSenha: " + novaSenha + "\nFunção: " + funcao);

                // Limpe os campos após o cadastro
                usernameField.setText("");
                passwordField.setText("");
                roleGroup.clearSelection();
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(roleLabel);
        panel.add(adminRadioButton);
        panel.add(new JLabel()); // Espaço em branco
        panel.add(userRadioButton);
        panel.add(new JLabel()); // Espaço em branco
        panel.add(cadastrarButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroScreen();
            }
        });
    }
}
