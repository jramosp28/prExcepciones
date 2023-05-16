package com.example.parking;
import java.util.ArrayList;

/**
 *
 * @author javierrampob
 */

public class Parking {
    private ArrayList<String> matriculas;
    private String nombre;

    public Parking(String nombre, int numPlazas) {
        this.nombre = nombre;
        matriculas = new ArrayList<>(numPlazas);
        for (int i = 0; i < numPlazas; i++) {
            matriculas.add(null);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int plaza) throws Exception {
        if (matricula == null || matricula.length() < 4) {
            throw new Exception("Matrícula incorrecta");
        }

        if (plaza < 0 || plaza >= matriculas.size()) {
            throw new Exception("Plaza ocupada");
        }

        if (matriculas.get(plaza) != null) {
            throw new Exception("Matrícula repetida");
        }

        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws Exception {
        int plaza = matriculas.indexOf(matricula);
        if (plaza == -1) {
            throw new Exception("Matrícula no existente");
        }

        matriculas.set(plaza, null);
        return plaza;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int ocupadas = 0;
        for (String matricula : matriculas) {
            if (matricula != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getPlazasLibres() {
        return matriculas.size() - getPlazasOcupadas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parking: ").append(nombre).append("\n");
        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("Plaza ").append(i).append(": ");
            String matricula = matriculas.get(i);
            if (matricula == null) {
                sb.append("Libre");
            } else {
                sb.append(matricula);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
