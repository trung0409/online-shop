/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import control.updateControl;
import entity.Account;
import entity.Category;
import entity.Item;
import entity.Product;
import entity.SubCategory;
import entity.itemOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trant
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product_HE172761";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductOfCategory(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product_HE172761\n"
                + "where SubCategory like '" + cid + "%'";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductOfSubCategory(String scid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product_HE172761\n"
                + "where SubCategory like '" + scid + "%'";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category_HE172761";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SubCategory> getAllSubCategory(String cid) {
        List<SubCategory> list = new ArrayList<>();
        String query = "select * from SubCategory_HE172761 where CategoryID = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SubCategory(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String pid) {
        Product p = new Product();
        String query = "select * from Product_HE172761 where id = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public List<Product> searchProductsByName(String name) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product_HE172761 where [Name] like ? ";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getLong(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account login(String username, String password) {
        String query = "select * from account_HE172761 where username = ? and Password = ? COLLATE Latin1_General_CS_AS";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        String.valueOf(rs.getDate(6)),
                        rs.getString(7),
                        rs.getString(8));
            }

        } catch (Exception e) {
        }

        return null;
    }

    public boolean checkAccoutExist(String username) {
        String query = "select * from account_HE172761 where username = ? COLLATE Latin1_General_CS_AS";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
        }

        return false;
    }

    public boolean checkEmailExist(String email) {
        String query = "select * from account_HE172761 where email = ? COLLATE Latin1_General_CS_AS";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
        }

        return false;
    }

    public void signup(String fullname, String email, String sdt, String address, String date, String username, String password) {
        String query = "insert into Account_HE172761\n"
                + "values (0,?,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, sdt);
            ps.setString(4, address);
            ps.setString(5, date);

            ps.setString(6, username);
            ps.setString(7, password);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void updateProfile(String username, String fullname, String email, String sdt, String address, String date) {
        String query = "update Account_HE172761 set FullName = ?,Email = ?,sdt = ?,[address] = ?,[date]=?"
                + " where username = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, sdt);
            ps.setString(4, address);
            ps.setString(5, date);
            ps.setString(6, username);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void changePass(String username, String newPass) {
        String query = "update Account_HE172761\n"
                + "set Password = ?\n"
                + "where Username = ?";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setString(2, username);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteProduct(String pid) {
        String query = "delete from Product_HE172761 where id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(String pid, String name, String image, String price, String discount, String quantity, String detail, String information) {
        String query = "update Product_HE172761 set [Name] = ?,[Image] = ?,\n"
                + "Price = ?,Discount = ?, Quantity = ?,Detail = ?,Information = ?\n"
                + "where ID = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, discount);
            ps.setString(5, quantity);
            ps.setString(6, detail);
            ps.setString(7, information);
            ps.setString(8, pid);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getMaxIDProduct(String scid) {
        List<Integer> list = new ArrayList<>();
        int maxID = 0;
        String query = "select * from STRING_SPLIT((select top(1) Id from product_HE172761 where SubCategory = ? order by ID desc),'-')";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, scid);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(Integer.valueOf(rs.getString(1)));

            }
        } catch (Exception e) {
            return (maxID + 1);
        }
        try {
            maxID = list.get(2);
        } catch (Exception e) {
            return maxID;
        }

        return (maxID + 1);
    }

    public void addProduct(String pid, String name, String image, String price, String discount, String quantity, String detail, String information, String scid) {
        String query = "INSERT INTO  Product_HE172761 \n"
                + "VALUES\n"
                + "  (?,?,?,?,?,?,?,0,?,'No',?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, pid);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setString(4, price);
            ps.setString(5, discount);
            ps.setString(6, quantity);
            ps.setString(7, detail);
            ps.setString(8, information);
            ps.setString(9, scid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public List<Item> getAllItemInCart(String username) {
        String query = "select i.iid,pid,quantity from item_HE172761 i,Cart_HE172761 c where i.iID = c.iID and username = ?";
        ArrayList<Item> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getMaxIDItem(String username) {
        String query = "select top(1) iid from item_HE172761 order by iid desc";
        int maxID = 0;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return String.valueOf(maxID + 1);
    }

    public void addToCart(String iid, String pid, String quantity, String username) {
        String query = "insert into item_HE172761 \n"
                + "values(?,?,?)\n"
                + "insert into cart_HE172761 \n"
                + "values (?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, iid);
            ps.setString(2, pid);
            ps.setString(3, quantity);
            ps.setString(4, username);
            ps.setString(5, iid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteFromCart(String iid) {
        String query = "delete from Cart_HE172761 where iID = ?\n"
                + "delete from item_HE172761 where iID = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, iid);
            ps.setString(2, iid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean checkProductExitInCart(String pid) {
        String query = "select * from item_HE172761 where pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
        }

        return false;
    }

    public void updateItemInCart(String pid, String quantity) {
        String query = "update item_HE172761 set quantity = ? where pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, quantity);
            ps.setString(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public int getQuantityInCart(String pid) {
        int quantity = 0;
        String query = "select quantity from item_HE172761 where pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return quantity;
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();

        String query = "select * from account_HE172761";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void setRoll(String roll, String username) {
        String query = "update Account_HE172761\n"
                + "set roll = ?\n"
                + "where Username = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, roll);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getMaxIDOrder(String username) {
        String query = "select top(1) ID from [order_HE172761] order by ID desc";
        int maxID = 0;
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxID = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return String.valueOf(maxID + 1);
    }

    public void addOrder(String ID, String username, String iid, String fullName, String sdt, String email, String address, String note, String date, String totalPrice, String pid, String quantity) {
        String query = "insert into [order_HE172761] \n"
                + "values(?,?,?,?,?,?,?,?,?,'Yes',?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, ID);
            ps.setString(2, username);
            ps.setString(3, iid);
            ps.setString(4, fullName);
            ps.setString(5, sdt);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setString(8, note);
            ps.setString(9, date);
            ps.setString(10, totalPrice);
            ps.setString(11, pid);
            ps.setString(12, quantity);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Account getAccountByEmail(String email) {
        String query = "select * from account_he172761\n"
                + "where email = ?";
        Account acc = new Account();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return acc;
    }

    public List<itemOrder> getAllOrders(String username) {
        List<itemOrder> list = new ArrayList<>();
        String query = "select * from [Order_HE172761] where username = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new itemOrder(rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public itemOrder getItemOrders(String username, String pid, String oid) {
        itemOrder i = null;
        String query = "select * from [Order_HE172761] where username = ? and id = ? and pid = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, oid);
            ps.setString(3, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = new itemOrder(rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(12),
                        rs.getInt(13));
            }
        } catch (Exception e) {
        }
        return i;
    }

    public void updownInCart(String iid, String type) {
        String query;
        if (type.equals("up")) {
            query = "update item_HE172761\n"
                    + "set quantity = quantity + 1\n"
                    + "where iID = ?";
        }
        else {
            query = "update item_HE172761\n"
                    + "set quantity = quantity - 1\n"
                    + "where iID = ?";
        }
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, iid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        List<itemOrder> list = dao.getItemOrders("ttnnguyen","1-1-1","1");
//
//        for (itemOrder i :list){
//            System.out.println(i);
//        }
//       
        System.out.println(dao.getAllCategory());

    }
}
