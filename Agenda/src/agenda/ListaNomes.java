package agenda;

import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ListaNomes {
    public static MeuModel model = new MeuModel();
    public static JList listaNomes = new JList(model);
    public static JScrollPane scroll = new JScrollPane(listaNomes);

    public static void InicializaLista(){
        ListSelectionModel listSelectionModel = listaNomes.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new Eventos.SharedListSelectionHandler());
        listaNomes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaNomes.setSelectedIndex(2);
        
        scroll.setPreferredSize(new Dimension(200, 400));
    }
    
    public static JPanel retornaLista(){
        ListaNomes.InicializaLista();
        JPanel painelLista = new JPanel();
        painelLista.add(scroll);
        painelLista.setPreferredSize(new Dimension(200, 200));
        
        return painelLista;
    }
}
