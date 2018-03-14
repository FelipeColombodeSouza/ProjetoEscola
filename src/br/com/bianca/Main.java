/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bianca;

import br.com.bianca.Escola.Aluno;
import br.com.bianca.Escola.Disciplina;
import br.com.bianca.Escola.Pessoa;
import br.com.bianca.Escola.Professor;
import java.awt.AWTEventMulticaster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author bianca.149817
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {     
      String Nome =JOptionPane.showInputDialog("Informe o Nome da Disciplina: ");
      String departamento =JOptionPane.showInputDialog("Informe o Departamento: ");
      char status = JOptionPane.showInputDialog("Informe o Status: ").charAt(0);
      
      Disciplina disciplina = new Disciplina(Nome, departamento, status);
    
      String nomePr = JOptionPane.showInputDialog("Informe o nome do Professor: ");
      String rgPr   = JOptionPane.showInputDialog("Informe o RG do Professor: ");
      String cpfpr  = JOptionPane.showInputDialog("Informe o CPF do Professor:");
      SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = sdfr.parse(JOptionPane.showInputDialog("informe a data de Nascimento do Professor: "));
      int cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horaria: ")) ;
      float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da Hora: "));
      
      Professor professor = new Professor(cargaHoraria, valorHora, nomePr, rgPr, cpfpr, dataNascimento);
      professor.getDisciplina().add(disciplina);
       
     String nomeA = JOptionPane.showInputDialog("Informe o nome do Aluno: ");
     String rgA = JOptionPane.showInputDialog("Informe o RG do Aluno: ");
     String cpfA= JOptionPane.showInputDialog("Informe o CPF do Aluno:");
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date dataA = sdf.parse(JOptionPane.showInputDialog("Informe a data de Nascimento do Aluno: "));
     int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matricula do Aluno: "));
     Date dataM = sdf.parse(JOptionPane.showInputDialog("Informe a data de Matricula do Aluno: "));
      
     
     Aluno aluno = new Aluno(matricula, dataA, nomeA, rgA, cpfA, dataM);
     aluno.getDisciplina().add(disciplina);
     
     JOptionPane.showMessageDialog(null, disciplina.toString());
     JOptionPane.showMessageDialog(null, professor.toString());
     JOptionPane.showMessageDialog(null, aluno.toString());
    }
    
}
