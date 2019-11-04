package agenda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Agenda extends JFrame{
    
    public void inicializar(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                //Inicializando o painel com todos os componentes da direita
                JPanel painelDir = new JPanel();
                painelDir.setLayout(new BorderLayout());
                painelDir.setPreferredSize(new Dimension(260, 200));
                painelDir.add(PainelBotões.retornaPainel(), BorderLayout.SOUTH);
                painelDir.add(PainelInformações.retornaInformacoes(), BorderLayout.EAST);
                painelDir.add(PainelInformações.retornaHolders(), BorderLayout.CENTER);

                //Inicializando o painel
                JPanel painel = new JPanel();
                painel.setLayout(new BorderLayout());
                painel.setPreferredSize(new Dimension(500, 200));
                painel.add(painelDir, BorderLayout.EAST);
                painel.add(ListaNomes.retornaLista(), BorderLayout.WEST);

                //Inicializando a janela
                JFrame janela = new JFrame("Agenda");
                janela.getContentPane().add(painel);
                janela.setJMenuBar(Menu.retornaMenu());
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.pack();
                janela.setVisible(true);
            }
        });
    }
    
    public static void main(String[] args){
        Agenda a = new Agenda();
        a.inicializar();
    }
}
