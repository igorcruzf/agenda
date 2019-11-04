package agenda;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;

public class Menu {
    public static JMenu menu = new JMenu ("Ferramentas");
    public static JMenuItem adicionar = new JMenuItem ("Adicionar", MenuKeyEvent.VK_A);
    public static JMenuItem remover = new JMenuItem ("Remover", MenuKeyEvent.VK_R);
    public static JMenuItem atualizar = new JMenuItem ("Atualizar", MenuKeyEvent.VK_A);
    
    public static void inicializa(JMenuBar menuBar){
        menuBar.add (menu);
        adicionar.addActionListener(new Eventos.Adicionar());
        menu.add(adicionar);
        menu.addSeparator ();
        remover.addActionListener(new Eventos.Remover());
        menu.add(remover);
        menu.addSeparator ();
        atualizar.addActionListener(new Eventos.Atualizar());
        menu.add(atualizar);
    }
    
    public static JMenuBar retornaMenu (){
        JMenuBar menuBar = new JMenuBar();
        Menu.inicializa(menuBar);
        return menuBar;
    }
}
