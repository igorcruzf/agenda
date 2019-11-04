package agenda;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelBotões {
    
    public static JButton adicionar = new JButton ("Adiciona");
    public static JButton remover = new JButton ("Remove");
    public static JButton editar = new JButton ("Atualiza");
    
    public static void inicializaBotões(){
                
                //Adicionar
                
                adicionar.setVerticalTextPosition (AbstractButton.CENTER);
                adicionar.setHorizontalTextPosition (AbstractButton.LEFT);
                adicionar.setEnabled (true);
                adicionar.addActionListener(new Eventos.Adicionar());
                
                //Remover
                
                remover.setVerticalTextPosition (AbstractButton.CENTER);
                remover.setHorizontalTextPosition (AbstractButton.LEFT);
                remover.setEnabled (true);
                remover.addActionListener(new Eventos.Remover());
                
                //Atualizar
                
                editar.setVerticalTextPosition (AbstractButton.CENTER);
                editar.setHorizontalTextPosition (AbstractButton.LEFT);
                editar.setEnabled (true);
                editar.addActionListener(new Eventos.Atualizar());
            }

    public static JPanel retornaPainel(){
        PainelBotões.inicializaBotões();
        JPanel botões = new JPanel();
        botões.setLayout(new FlowLayout());
        botões.add(adicionar);
        botões.add(remover);
        botões.add(editar);
        return botões;
    }
}
