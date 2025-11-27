import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Gagal menerapkan tema sistem: " + e.getMessage());
        }

        System.out.println("Memeriksa koneksi database...");
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Koneksi sukses! Membuka aplikasi...");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal terhubung ke Database!\n\n" +
                            "Pastikan:\n" +
                            "1. XAMPP / MySQL Server sudah dijalankan (Start).\n" +
                            "2. Nama database 'db_restoran_final' sudah benar.\n\n" +
                            "Pesan Error: " + e.getMessage(),
                    "Critical Error",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(0);
        }

        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
    }
}