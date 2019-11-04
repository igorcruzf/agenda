package agenda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelInformações {
    public final static JTextField nome = new JTextField (20);
    public final static JTextArea detalhes = new JTextArea(2, 2);
    public final static JTextField telefone = new JTextField (20);
    public static JScrollPane scrollDetalhes = new JScrollPane(detalhes);
    public static JScrollPane scrollNome = new JScrollPane(nome);
    public static JScrollPane scrollTelefone = new JScrollPane(telefone);
    public static JLabel nomeHolder = new JLabel("Nome:");
    public static JLabel detalhesHolder = new JLabel("Detalhes:");
    public static JLabel telefoneHolder = new JLabel("Telefone:");
    public static Map<String, String> dicTelefone  = new HashMap<String, String>() {{
    put("João", "(21) 98544-3338");
    put("José", "(21) 2713-7032");
    put("Maria", "(21) 98765-4321");
    put("Paulo", "(22) 91234-5678");
    put("Pedro", "(24) 92456-2351");
}};
    public static Map<String, String> dicDetalhes  = new HashMap<String, String>() {{
    put("João", "Amigo");
    put("José", "Irmão");
    put("Maria", "Esposa do Pedro");
    put("Paulo", "");
    put("Pedro", "Marido de Maria");
}};
    
    public static JPanel retornaInformacoes(){
        JPanel informacoes = new JPanel();
        informacoes.setPreferredSize(new Dimension(200,200));
        informacoes.setLayout(new GridLayout(3,2));
        JPanel nomePanel = new JPanel();
        nomePanel.setPreferredSize(new Dimension (50,200));
        nomePanel.setLayout(new BorderLayout());
        nomePanel.add(scrollNome, BorderLayout.WEST);
        JPanel telefonePanel = new JPanel();
        telefonePanel.setPreferredSize(new Dimension (50,200));
        telefonePanel.setLayout(new BorderLayout());
        telefonePanel.add(scrollTelefone, BorderLayout.WEST);
        informacoes.add(nomePanel);
        informacoes.add(telefonePanel);
        informacoes.add(scrollDetalhes);
        return informacoes;
    }
    
    public static JPanel retornaHolders(){
        JPanel holders = new JPanel();
        holders.setPreferredSize(new Dimension(50,200));
        holders.setLayout(new GridLayout(3,2));
        holders.add(nomeHolder);
        holders.add(telefoneHolder);
        holders.add(detalhesHolder);
        return holders;
    }
}
