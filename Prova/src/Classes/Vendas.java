package Classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vendas {
    private LocalDate data;
    private Produtos produtos;
    private double valorVendaTotal;
    private int quantVendida;
    
    
    
    public Vendas(LocalDate data, Produtos produtos, double valorVendaTotal, int quantVendida){
        this.data = data;
        this.produtos = produtos;
        this.valorVendaTotal = valorVendaTotal;
        this.quantVendida = quantVendida;
    }

    
    


    
  
 
   public int getQuantVendida() {
        return quantVendida;
    }








    public void setQuantVendida(int quantVendida) {
        this.quantVendida = quantVendida;
    }








public LocalDate getData() {
        return data;
    }




    public void setData(LocalDate data) {
        this.data = data;
    }




    public Produtos getProdutos() {
        return produtos;
    }




    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

     


public double getValorVendaTotal() {
        return valorVendaTotal;
    }







    public void setValorVendaTotal(double valorVendaTotal) {
        this.valorVendaTotal = valorVendaTotal;
    }







@Override
   public String toString() {
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       return String.format("Informações da venda/; ",  data.format(format), produtos );
   }
}
    

