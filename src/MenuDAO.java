import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {

    public List<MenuItem> getAllMenu() {
        List<MenuItem> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                MenuItem menu = new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getString("image_path")
                );
                list.add(menu);
            }
        } catch (SQLException e) {
            System.out.println("Error getAllMenu: " + e.getMessage());
        }
        return list;
    }

    public boolean insertMenu(MenuItem menu) {
        String sql = "INSERT INTO menu_items (name, category, price, stock, image_path) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, menu.getName());
            pst.setString(2, menu.getCategory());
            pst.setDouble(3, menu.getPrice());
            pst.setInt(4, menu.getStock());
            pst.setString(5, menu.getImagePath());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error insertMenu: " + e.getMessage());
            return false;
        }
    }

    public boolean updateMenu(MenuItem menu) {
        String sql = "UPDATE menu_items SET name=?, category=?, price=?, stock=?, image_path=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, menu.getName());
            pst.setString(2, menu.getCategory());
            pst.setDouble(3, menu.getPrice());
            pst.setInt(4, menu.getStock());
            pst.setString(5, menu.getImagePath());
            pst.setInt(6, menu.getId());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updateMenu: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteMenu(int id) {
        String sql = "DELETE FROM menu_items WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleteMenu: " + e.getMessage());
            return false;
        }
    }
}