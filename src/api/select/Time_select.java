package api.select;
import java.util.StringJoiner;

import api.BDConnection;
import models.Monitoring;

public class Time_select {

    public StringJoiner getAll() {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT * FROM MONITORIA WHERE QUANTIDADE > 0 ORDER BY IDMONITORIA DESC";

        StringJoiner result = conexaoBd.executarQueryGet(sqlQuery);

        return result;
    }

    public String getCount() {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT COUNT(*) FROM MONITORIA WHERE QUANTIDADE > 0";

        StringJoiner resultQueryGet = conexaoBd.executarQueryGet(sqlQuery);
        String result = "";
        for (int x = 0; x < resultQueryGet.length(); x++) {
            if (resultQueryGet.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < resultQueryGet.length(); y++) {
                    if (resultQueryGet.toString().substring(y, y + 1).equals("]")) {
                        result = resultQueryGet.toString().substring(x + 1, y);
                        break;
                    }
                }

            }
        }
        return result;
    }

    public String getNameMonitor(int id_Monitoria, int ra) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;

        sqlQuery = "SELECT NOME FROM USUARIO WHERE ra =" + ra
                + ";";

        StringJoiner resultQueryGet = conexaoBd.executarQueryGet(sqlQuery);
        String result = "";
        for (int x = 0; x < resultQueryGet.length(); x++) {
            if (resultQueryGet.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < resultQueryGet.length(); y++) {
                    if (resultQueryGet.toString().substring(y, y + 1).equals("]")) {
                        result = resultQueryGet.toString().substring(x + 1, y);
                        break;
                    }
                }

            }
        }
        return result;
    }

    public Monitoring getTimeForSchedule(int id_Monitoria) {
        BDConnection conexaoBd = new BDConnection();
        conexaoBd.openConnection();
        String sqlQuery;
        Monitoring monitoring = new Monitoring();
        
        sqlQuery = "SELECT * FROM MONITORIA WHERE IDMONITORIA = " + id_Monitoria + " ORDER BY IDMONITORIA DESC";

        StringJoiner resultQueryGet = conexaoBd.executarQueryGet(sqlQuery);
        int cont = 0;
        monitoring = new Monitoring();
        for (int x = 0; x < resultQueryGet.length(); x++) {
            if (resultQueryGet.toString().substring(x, x + 1).equals("=")) {
                for (int y = x + 1; y < resultQueryGet.length(); y++) {
                    if (resultQueryGet.toString().substring(y, y + 1).equals(",")
                            || resultQueryGet.toString().substring(y, y + 1).equals("]")) {
                        if (cont == 0) {
                            monitoring.setMonitoring(Integer.parseInt(resultQueryGet.toString().substring(x + 1, y)));
                            cont++;
                        } else if (cont == 1) {
                            monitoring.setUser(Integer.parseInt(resultQueryGet.toString().substring(x + 1, y)));
                            cont++;
                        } else if (cont == 2) {
                            monitoring.setDate(resultQueryGet.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 3) {
                            monitoring.setHour(resultQueryGet.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 4) {
                            monitoring.setDiscipline(resultQueryGet.toString().substring(x + 1, y));
                            cont++;
                        } else if (cont == 5) {
                            monitoring.setRoom(resultQueryGet.toString().substring(x + 1, y));
                            cont++;
                        } else {
                            monitoring.setQuantity(Integer.parseInt(resultQueryGet.toString().substring(x + 1, y)));
                            cont = 0;
                        }
                        break;
                    }
                }
            }
        }

        return monitoring;
    }
}
