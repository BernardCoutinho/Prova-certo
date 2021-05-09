package Classes;

public class Produtos{
    
    private int estoq;
    private String nome, codigo;
    private double valor;


    public  Produtos(String codigo, int estoq, String nome, double valor ){
        this.codigo = codigo;
        this.estoq = estoq;
        this.nome = nome;
        this.valor = valor;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
       
        if(codigo.matches("^[a-z]*$")){
             
             throw new NumberFormatException("\nERRO: Código formado apenas por números!!.\nDigite um código VÁLIDO!!");
        }else{
            this.codigo = codigo;
            
        }
    }


    public int getEstoq() {
        return estoq;
    }


    public void setEstoq(int estoq) {
        this.estoq = estoq;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }
 
 
    

        
 
    @Override
        public String toString(){
        return "\nCodigo: " + codigo + " \nNome: " + nome + " \nValor: " + valor + " \nEm estoque: " + estoq;
 }
  


}
