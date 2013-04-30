
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package trabalho1_grafos;

/**
 *
 * @author Paulo
 * @author Romeu
 */
public class Grafo {
    
    private int num_vertices;
//    private int valor_aresta;
//    private int vertice_inicial;
    private boolean fl_orientado;
    private int[][] matrizValorada;
    
    public Grafo() {
	
    }
    
    public Grafo(int num_vertices, boolean fl_orientado) {
    	this.num_vertices = num_vertices;
		this.fl_orientado = fl_orientado;
		this.matrizValorada = new int[num_vertices][num_vertices];
	}
    
	public int getNum_vertices() {
        return num_vertices;
    }

    public void setNum_vertices(int num_vertices) {
        this.num_vertices = num_vertices;
    }

//    public int getValor_aresta() {
//        return valor_aresta;
//    }
//
//    public void setValor_aresta(int valor_aresta) {
//        this.valor_aresta = valor_aresta;
//    }

    public boolean isFl_orientado() {
        return fl_orientado;
    }

    public void setFl_orientado(boolean fl_orientado) {
        this.fl_orientado = fl_orientado;
    }
    
    public int[][] getMatrizValorada() {
		return matrizValorada;
	}

	public void setMatrizValorada(int[][] matrizValorada) {
		this.matrizValorada = matrizValorada;
	}
	

	// Elimina os laços na matriz
    public void eliminaLaco(){
    	for(int i = 0; i < this.num_vertices; i++){
			for(int j = 0; j < this.num_vertices; j++){
				if(i == j){
					this.matrizValorada[i][j] = 0; 
				}
			}
		}
    }
    
    // Preenche a diagonal triangular secundaria da matriz com os 
    // valores da diagonal triangular primaria
    public void preecheMatrizNaoOrientada(){
    	if(!this.fl_orientado){
        	for(int i = 0; i < this.num_vertices; i++){
    			for(int j = 0; j < this.num_vertices; j++){
    				if(i > j){
    					this.matrizValorada[i][j] = this.matrizValorada[j][i];
    				}
    			}
    		}
    	}
    }
    
    // Função para debug
    public String imprimeMatriz(int[][] matriz){
		String matrizFinal = "";
		for(int i = 0; i < num_vertices; i++){
			for(int j = 0; j < num_vertices; j++){
				matrizFinal += "-" + matriz[i][j] + "-";
			}
			matrizFinal += "\n";
		}
    	return matrizFinal;
    }
    

//    public int getVertice_inicial() {
//        return vertice_inicial;
//    }
//
//    public void setVertice_inicial(int vertice_inicial) {
//        this.vertice_inicial = vertice_inicial;
//    }            

}
