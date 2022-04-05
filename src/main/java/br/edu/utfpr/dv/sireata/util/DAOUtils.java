package br.edu.utfpr.dv.sireata.util;

import br.edu.utfpr.dv.sireata.dao.ConnectionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOUtils {
    Connection conn = null;
    PreparedStatement stmt = null;

    public PreparedStatement handlePrepareStatement(String sql, int id) throws SQLException {
        conn = ConnectionDAO.getInstance().getConnection();
        stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        return stmt;
    }
}
