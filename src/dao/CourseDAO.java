package dao;

import db.DBConnection;
import model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public void addCourse(String name, String instructor, int duration) {
        try {
            Connection con = DBConnection.getConnection();
            String q = "INSERT INTO courses(name, instructor, duration) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, name);
            ps.setString(2, instructor);
            ps.setInt(3, duration);

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses");

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructor"),
                        rs.getInt("duration")
                ));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateCourse(int id, String name, String instructor, int duration) {
        try {
            Connection con = DBConnection.getConnection();
            String q = "UPDATE courses SET name=?, instructor=?, duration=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, name);
            ps.setString(2, instructor);
            ps.setInt(3, duration);
            ps.setInt(4, id);

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String q = "DELETE FROM courses WHERE id=?";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}