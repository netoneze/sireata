package br.edu.utfpr.dv.sireata.factory;

import br.edu.utfpr.dv.sireata.dao.AnexoDAO;
import br.edu.utfpr.dv.sireata.dao.PautaDAO;

public class DAOFactory {
    public DAO getDAO (String channel) {
        if (channel == null || channel.isEmpty())
            return null;
        switch (channel) {
            case "Anexo":
                return new AnexoDAO();
            case "Pauta":
                return new PautaDAO();
            default:
                throw new IllegalArgumentException("Wrong channel "+channel);
        }
    }
}

