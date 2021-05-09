package Telas;
import java.util.List;
import java.util.Scanner;


import Classes.Produtos;

public class TelaCadastro  {
    // TODO Botar proteções e deixar bonito;

    public void cadastroDeProdutos(Scanner ler, List<Produtos> produto){
        int x;
        
        do{
        System.out.println("\n======Cadastro de Produtos======");
        System.out.println("\nEscolha uma das opções ou 0 para encerrar.");
        System.out.println("\n1 - Listar produtos registrados");
        System.out.println("\n2 - Registrar produtos");
        System.out.println("\n3 - Remover produto");
        System.out.println("\n0 - Sair");
    
        
         x = ler.nextInt();
            ler.nextLine();
        switch(x){
            
            
           
            case 1:
               boolean aux = false; 
               System.out.println("\n=====Consulta de Produtos=======");
               System.out.println("\nDigite o código do produto que deseja consultar\nENTER para listar todos ou 0 para sair.");

               String codP = ler.nextLine();
               
              if(codP.isBlank()){
                aux = true;  
                System.out.println("\nTodos os produtos:\n");
                for(Produtos produtos : produto){
                     System.out.println(produtos);

                } 
                    
                }else{
                    for (Produtos produtos : produto) {
                        if(codP.equals(produtos.getCodigo())){
                            aux = true;
                            System.out.println("\nProduto requerido:" + produtos);
                            
                            break;
                      
                      
                        }
                    }
                }                
                 if(aux == false){
                     System.out.println("\nProduto Inválido.");
                 }

            break;
            case 2:
                System.out.println("\nDigite o código do produto.");
                
                String codProd = ler.nextLine();
                try{
                    Integer.valueOf(codProd);

                }catch(Exception e){
                    System.out.println("\nERRO: Código formado apenas por números!!.\nDigite um código VÁLIDO!!");;
                    break;
                }
                System.out.println("\nDigite o nome do produto.");
                String nomeProd = ler.nextLine();
                 if(nomeProd == ("^[0-9]*$")){
                    System.out.println("\nERRO: Nome formado apenas por letras!!.\nDigite um nome VÁLIDO!!");;
                    break;

                 }    

                
                System.out.println("\nDigite o valor do produto.");
                double valorProd = ler.nextDouble();
                ler.nextLine();
                System.out.println("Digite a quantidade em estoque do produto.");
                int estoqProduto = ler.nextInt();
                
                
                Produtos produtos = new Produtos(codProd, estoqProduto, nomeProd, valorProd);
                produto.add( produtos);
                
                break;
            
            case 3:
                
                System.out.println("\nDigite o produto que deseja remover.");
                String produtoRemover = ler.nextLine(); 
                
                if(produto.removeIf(p -> p.getNome().equalsIgnoreCase(produtoRemover))){
                    System.out.printf("%s foi removido com sucesso!", produtoRemover);

                }else{
                    System.out.println("Produto não encontrado.");
                }
                 break; 
               
            default:
               System.out.println("Digite uma opção válida");
                } 
         
            }while(x!=0);
        
        }
 }
