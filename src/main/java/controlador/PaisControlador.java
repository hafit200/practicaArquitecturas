package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PDF;
import model.Pais;

/**
 *
 * @author hp
 */
public class PaisControlador {

    //INSTANCIAR LA CONEXIÓN A LA BASE DE DATOS
    ConexionBDD conectar = new ConexionBDD();
    //CLASE QUE ME PERMITA CONECTARME DIRECTAMENTE A MYSQL
    Connection conectado = (Connection) conectar.conectar();
    //CLASE QUE ME PERMITE EJECUTAR MI SENTENCIA SQL
    PreparedStatement ejecutar;
    //OBTENER RESULTADOS DE LA CONSULTA
    ResultSet resultado;

    //Metodo de editar pais
    // 1. MÉTODO PARA EDITAR: Recibe el ID de la base de datos y el objeto Pais con los nuevos datos
    public void editarPais(int idPais, Pais p) {
        Connection conectado = conectar.conectar();

        // Concatenamos las variables directamente en el String del SQL
        String sentenciaSQL = "UPDATE Paises SET nombre_pais = '" + p.getNombre() + "', "
                + "capital_pais = '" + p.getCapital() + "' "
                + "WHERE id_pais = " + idPais + ";";

        try {
            // Al no haber "?", no necesitamos pasar parámetros después.
            // Se ejecuta la sentencia tal cual se armó arriba.
            ejecutar = conectado.prepareStatement(sentenciaSQL);

            int res = ejecutar.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "País actualizado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el país.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar editar.");
            System.out.println("Error en editarPais: " + e);
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
                if (conectado != null) {
                    conectado.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e);
            }
        }
    }

// 2. MÉTODO PARA ELIMINAR: Solo recibe el ID del país a borrar
    public void eliminarPais(int idPais) {
        Connection conectado = conectar.conectar();

        // Concatenamos el ID directamente en la sentencia SQL
        String sentenciaSQL = "DELETE FROM Paises WHERE id_pais = " + idPais + ";";

        try {
            // Ejecutamos la sentencia tal cual se armó arriba
            ejecutar = conectado.prepareStatement(sentenciaSQL);

            // Ya no necesitamos la línea ejecutar.setInt(1, idPais); 
            // porque el ID ya va escrito dentro del String de la consulta.
            int res = ejecutar.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "País eliminado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún país con el ID proporcionado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el país. Puede estar asociado a un estudiante.");
            System.out.println("Error en eliminarPais: " + e);
        } finally {
            try {
                if (ejecutar != null) {
                    ejecutar.close();
                }
                if (conectado != null) {
                    conectado.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e);
            }
        }
    }

    //MÉTODOS DE TRANSACCIONABILIDAD
    public void insertarPais(Pais p) {
        //1.- UTILIZAR EXCEPCIÓN
        try {//LANZAR TESTEAR UN CONJUNTO DE CÓDIGO 
            String sentenciaSQL = "INSERT INTO Paises(nombre_pais,capital_pais)values "
                    + "('" + p.getNombre() + "','" + p.getCapital() + "');";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            //TODA INSERCIÓN DEVUELVE UN ESTADO >0 CUANDO FUE FAVORABLE Y MENOR A O CUANDO NO SE REALIZÓ 
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null,
                        "País Creado con éxito");
                ejecutar.close();
            } else {
                JOptionPane.showMessageDialog(null,
                        "El País no ha sido creado,"
                        + " revise que los datos ingresados sean correctos");
            }
            conectado.close();

        } catch (SQLException e) {
            //CAPTURAR PARA DARLE UN TRATAMIENTO 
            JOptionPane.showMessageDialog(null,
                    "Comuniquese con el Administrador para solicitar ayuda");
            System.out.println("---------------" + e);
        }

    }

    public ArrayList<String[]> obtenerPaises() {
        ArrayList<String[]> lregistros = new ArrayList<>();

        try {
            String sentenciaSQL = "SELECT * FROM paises";
            ejecutar = conectado.prepareCall(sentenciaSQL);
            ResultSet res = ejecutar.executeQuery();

            while (res.next()) {
                String[] listaPaises = new String[3];

                listaPaises[0] = String.valueOf(res.getInt("id_pais"));
                listaPaises[1] = res.getString("nombre_pais");
                listaPaises[2] = res.getString("capital_pais");

                lregistros.add(listaPaises);
            }

            res.close();
            ejecutar.close();
            conectado.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return lregistros;

    }

    public void obtenerPaisesTodos() {

    String contenido = "";

    try {
        String sentenciaSQL = "SELECT * FROM paises";

        ejecutar = conectado.prepareCall(sentenciaSQL);

        ResultSet res = ejecutar.executeQuery();

        while (res.next()) {

            contenido += "ID: " + res.getInt("id_pais") + "\n";
            contenido += "Nombre: " + res.getString("nombre_pais") + "\n";
            contenido += "Capital: " + res.getString("capital_pais") + "\n";
            contenido += "-----------------------------\n";
        }

        PDF pdf = new PDF();

        pdf.btnPDFActionPerformed(contenido);
        System.out.println("PDF creado");

        res.close();
        ejecutar.close();
        conectado.close();

    } catch (SQLException e) {
        System.out.println(e);
    }
}
}
