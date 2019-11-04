package agenda;

import static agenda.ListaNomes.model;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Eventos {
    public static class SharedListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (!lsm.isSelectionEmpty()) {
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                        PainelInformações.nome.setText(model.pessoas.get(i));
                        PainelInformações.detalhes.setText(PainelInformações.dicDetalhes.get(model.pessoas.get(i)));
                        PainelInformações.telefone.setText(PainelInformações.dicTelefone.get(model.pessoas.get(i)));
                    }
                }
            }
        }
    }
    
    public static class Adicionar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = PainelInformações.nome.getText();
            if(!nome.trim().isEmpty()){
                String telefone = PainelInformações.telefone.getText();
                String detalhes = PainelInformações.detalhes.getText();
                if(!ListaNomes.model.pessoas.contains(nome)){
                    ListaNomes.model.addElement(nome);
                    PainelInformações.dicTelefone.put(nome, telefone);
                    PainelInformações.dicDetalhes.put(nome, detalhes);
                    Collections.sort(model.pessoas);
                    ListaNomes.listaNomes.clearSelection();
                }
            }
        }
    }
    
    public static class Remover implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = PainelInformações.nome.getText();
            if(ListaNomes.model.pessoas.contains(nome)){
                int index = ListaNomes.listaNomes.getSelectedIndex();
                if(index >= 0){
                    ListaNomes.model.removeElementAt(index);
                    PainelInformações.dicTelefone.remove(nome);
                    PainelInformações.dicDetalhes.remove(nome);
                    ListaNomes.listaNomes.clearSelection();
                    PainelInformações.detalhes.setText("");
                    PainelInformações.nome.setText("");
                    PainelInformações.telefone.setText("");
                }
            }
        }
    }
    
    public static class Atualizar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = PainelInformações.nome.getText();
            String telefone = PainelInformações.telefone.getText();
            String detalhes = PainelInformações.detalhes.getText();
            if(!nome.trim().isEmpty()){
                if(!ListaNomes.model.pessoas.contains(nome)){
                    int index = ListaNomes.listaNomes.getSelectedIndex();
                    String nome_anterior = ListaNomes.model.pessoas.get(index);
                    ListaNomes.model.pessoas.set(index, nome);
                    PainelInformações.dicTelefone.remove(nome_anterior);
                    PainelInformações.dicDetalhes.remove(nome_anterior);
                    PainelInformações.dicTelefone.put(nome, telefone);
                    PainelInformações.dicDetalhes.put(nome, detalhes); 
                }
                else{
                    PainelInformações.dicTelefone.replace(nome, telefone);
                    PainelInformações.dicDetalhes.replace(nome, detalhes);
                }
                ListaNomes.listaNomes.clearSelection();
                PainelInformações.detalhes.setText("");
                PainelInformações.nome.setText("");
                PainelInformações.telefone.setText("");
            } 
            Collections.sort(ListaNomes.model.pessoas);
            ListaNomes.model.refresh();
        }
    }
}

