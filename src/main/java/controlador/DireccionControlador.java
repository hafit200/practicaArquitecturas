/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Direccion;
import model.PDF;

public class DireccionControlador {

    ConexionBDD conectar = new ConexionBDD();
    Connection conectado = (Connection) conectar.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    // INSERTAR
    public void insertarDireccion(Direccion d, int idPais) {

        try {

            String sentenciaSQL = "INSERT INTO direcciones(calle, ciudad, cod_postal, id_pais) VALUES("
                    + "'" + d.getCalle() + "',"
                    + "'" + d.getCiudad() + "',"
                    + "'" + d.getCodPostal() + "',"
                    + idPais + ");";

            ejecutar = conectado.prepareCall(sentenciaSQL);

            int res = ejecutar.executeUpdate();

            if (res > 0) {

                JOptionPane.showMessageDialog(null,
                        "Dirección creada con éxito");

                ejecutar.close();

            } else {

                JOptionPane.showMessageDialog(null,
                        "No se pudo crear la dirección.");

            }

            conectado.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Comuníquese con el administrador.");

            System.out.println(e);

        }

    }

    // OBTENER TODAS
    public ArrayList<String[]> obtenerDirecciones() {

        ArrayList<String[]> lista = new ArrayList<>();

        try {

            String sentenciaSQL = "SELECT * FROM direcciones";

            ejecutar = conectado.prepareCall(sentenciaSQL);

            ResultSet res = ejecutar.executeQuery();

            while (res.next()) {

                String datos[] = new String[5];

                datos[0] = String.valueOf(res.getInt("id_direccion"));
                datos[1] = res.getString("calle");
                datos[2] = res.getString("ciudad");
                datos[3] = res.getString("cod_postal");
                datos[4] = String.valueOf(res.getInt("id_pais"));

                lista.add(datos);

            }

            res.close();
            ejecutar.close();
            conectado.close();

        } catch (SQLException e) {

            System.out.println(e);

        }

        return lista;

    }

    // EDITAR
    public void editarDireccion(int idDireccion, Direccion d, int idPais) {

        Connection conectado = conectar.conectar();

        String sentenciaSQL = "UPDATE direcciones SET "
                + "calle='" + d.getCalle() + "',"
                + "ciudad='" + d.getCiudad() + "',"
                + "cod_postal='" + d.getCodPostal() + "',"
                + "id_pais=" + idPais
                + " WHERE id_direccion=" + idDireccion + ";";

        try {

            ejecutar = conectado.prepareStatement(sentenciaSQL);

            int res = ejecutar.executeUpdate();

            if (res > 0) {

                JOptionPane.showMessageDialog(null,
                        "Dirección actualizada con éxito");

            } else {

                JOptionPane.showMessageDialog(null,
                        "No se pudo actualizar.");

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Error al editar.");

            System.out.println(e);

        }

    }

    // ELIMINAR
    public void eliminarDireccion(int idDireccion) {

        Connection conectado = conectar.conectar();

        String sentenciaSQL = "DELETE FROM direcciones WHERE id_direccion=" + idDireccion + ";";

        try {

            ejecutar = conectado.prepareStatement(sentenciaSQL);

            int res = ejecutar.executeUpdate();

            if (res > 0) {

                JOptionPane.showMessageDialog(null,
                        "Dirección eliminada con éxito");

            } else {

                JOptionPane.showMessageDialog(null,
                        "No se encontró la dirección.");

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "No se pudo eliminar la dirección.");

            System.out.println(e);

        }

    }

    // GENERAR PDF
    public void obtenerDireccionesTodas() {

        String contenido = "";

        try {

            String sentenciaSQL = "SELECT * FROM direcciones";

            ejecutar = conectado.prepareCall(sentenciaSQL);

            ResultSet res = ejecutar.executeQuery();

            while (res.next()) {

                contenido += "ID: " + res.getInt("id_direccion") + "\n";
                contenido += "Calle: " + res.getString("calle") + "\n";
                contenido += "Ciudad: " + res.getString("ciudad") + "\n";
                contenido += "Código Postal: " + res.getString("cod_postal") + "\n";
                contenido += "ID País: " + res.getInt("id_pais") + "\n";
                contenido += "-----------------------------\n";

            }

            PDF pdf = new PDF();

            pdf.btnPDFActionPerformed(contenido);

            res.close();
            ejecutar.close();
            conectado.close();

        } catch (SQLException e) {

            System.out.println(e);

        }

    }

}
