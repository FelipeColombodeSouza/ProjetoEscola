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
import java.util.ArrayList;
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
     int escMenu = 0;
     ArrayList<Disciplina> materias = new ArrayList<>();
     ArrayList<Aluno> alunos = new ArrayList<>();
     ArrayList<Professor> prof = new ArrayList<>();
     
     do{
        escMenu = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções/; \n"
                 +"1. Cadastro Disciplinas \n"
                 +"2. Cadastro de Alunos \n"
                 +"3. Cadastro de Professores \n"
                 +"4. Sair"));
        switch(escMenu){
             case 1:{
                 do{
                 String Nome =JOptionPane.showInputDialog("Informe o Nome da Disciplina: ");
                 String departamento =JOptionPane.showInputDialog("Informe o Departamento: ");
                 char status = JOptionPane.showInputDialog("Informe o Status: ").charAt(0);   
                 materias.add(new Disciplina(Nome, departamento, status));
                                     
                 }while((JOptionPane.showConfirmDialog(null, "Deseja continuar?"))==0);
                   break;                         
             }
             case 2:{
                do{
                 int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe a matricula do Aluno: "));   
                 String nome= JOptionPane.showInputDialog("Informe o nome do Aluno: ");
                 String rg = JOptionPane.showInputDialog("Informe o RG do Aluno: ");
                 String cpf= JOptionPane.showInputDialog("Informe o CPF do Aluno:");
                 
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 Date dataA = sdf.parse(JOptionPane.showInputDialog("Informe a data de Nascimento do Aluno: "));            
                 Date dataM = sdf.parse(JOptionPane.showInputDialog("Informe a data de Matricula do Aluno: "));   
     
                 alunos.add(new Aluno(matricula, dataA, nome, rg, cpf, dataM));
                 
                 if (JOptionPane.showConfirmDialog(null,"O aluno já se matriculou em alguma disciplina?")==0){
                     String materiasExistentes = " ";
                      for (Disciplina materia : materias){
                        materiasExistentes += materias.indexOf(materia) + " " + materia.getNome() + "\n";
                      }
                      do{
                          int esc = Integer.parseInt(JOptionPane.showInputDialog("-- Informe a matéria -- \n" + materiasExistentes));
                          alunos.get(alunos.size()-1).getDisciplina().add(materias.get(esc));
                      }while((JOptionPane.showConfirmDialog(null, "Tem outra matéria para cadastrar?"))==0);
                     
                 }
                 
                }while((JOptionPane.showConfirmDialog(null, "Deseja continuar?"))==0);
                  break;
             }
             
             case 3:{
                 do{             
                String nome = JOptionPane.showInputDialog("Informe o nome do Professor: ");
                String rg   = JOptionPane.showInputDialog("Informe o RG do Professor: ");
                String cpf  = JOptionPane.showInputDialog("Informe o CPF do Professor:");
               
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataNascimento = sdf.parse(JOptionPane.showInputDialog("informe a data de Nascimento do Professor: "));
                
                int cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horaria: ")) ;
                float valorHora = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da Hora: "));
      
              prof.add(new Professor(cargaHoraria, valorHora, nome, rg, cpf, dataNascimento));
               if (JOptionPane.showConfirmDialog(null,"O aluno já se matriculou em alguma disciplina?")==0){
                     String materiasExistentes = " ";
                      for (Disciplina materia : materias){
                        materiasExistentes += materias.indexOf(materia) + " " + materia.getNome() + "\n";
                      }
                       do{
                        int esc = Integer.parseInt(JOptionPane.showInputDialog("-- Informe a matéria -- \n" + materiasExistentes));
                        alunos.get(alunos.size()-1).getDisciplina().add(materias.get(esc));
                      }while((JOptionPane.showConfirmDialog(null, "Tem outra matéria para cadastrar?"))==0);
                     
               }
               
              }while((JOptionPane.showConfirmDialog(null, "Deseja continuar?"))==0);
                break;    
                 
             }
         }                 
     }while (escMenu != 4);
             
    }
    
}
