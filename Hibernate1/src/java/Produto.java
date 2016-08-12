
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael.Soares
 */
@Entity
public class Produto {
    @Id
    private int ID;
    private String tipoproduto;
    private String formato;
    private String papel;
    private String acabamento;
    private String impressao;
    private float preco;
    
    public String getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(String tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getImpressao() {
        return impressao;
    }

    public void setImpressao(String impressao) {
        this.impressao = impressao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    
    
    
}
