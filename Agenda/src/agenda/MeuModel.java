package agenda;

import javax.swing.AbstractListModel;
import java.util.ArrayList;
import java.util.Arrays;

public class MeuModel extends AbstractListModel{
   
    public ArrayList<String> pessoas = new ArrayList<>(Arrays.asList("José", "João", "Maria", "Paulo", "Pedro"));
    public void addElement(String obj) {
        pessoas.add(obj);
        fireIntervalAdded(this, pessoas.size()-1, pessoas.size()-1);
    }

    @Override
    public Object getElementAt(int index) { return pessoas.get(index); }

    @Override
    public int getSize() { return pessoas.size(); }
    
    public void refresh(){
        fireContentsChanged(this, pessoas.size(), pessoas.size());
    }
    
    public void removeElementAt(int index){
        pessoas.remove(index);
        fireIntervalRemoved(this, pessoas.size(), pessoas.size());
    }
}

