import javax.swing.JOptionPane;


public class Principal {
	public static void main(String[] args){
		
		int num_vertices = Integer.parseInt(JOptionPane.showInputDialog("Entre com o tamanho da matriz:"));
		boolean orientado = Boolean.parseBoolean(JOptionPane.showInputDialog("Se o grafo for orientado digite true, se não for digite false:"));
		
		Grafo grafo = new Grafo(num_vertices, orientado);

		int[][] g = new int[num_vertices][num_vertices]; 
		
		if(orientado){
			for(int i = 0; i < num_vertices; i++){
				for(int j = 0; j < num_vertices; j++){
					g[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com o valor entre V["+(i)+"] e V["+(j)+"]"));
				}
			}
		}
		else {
			for(int i = 0; i < num_vertices; i++){
				for(int j = 0; j < num_vertices; j++){
					if(i < j){
						g[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Entre com o valor entre V["+(i)+"] e V["+(j)+"]"));
					}
					else{
						g[i][j] = 0;
					}
				}
			}
		}
		
		grafo.setMatrizValorada(g);
		grafo.eliminaLaco();
		// se não for orientado
		if(!grafo.isFl_orientado()){
			grafo.preecheMatrizNaoOrientada();
		}
		
		Dijkstra dijkstra = new Dijkstra(grafo);
		
		// passando 0 como vertice inicial
		dijkstra.algoritmo(0);
		
		// Debug vertor de V usados
		for(Integer u: dijkstra.getUsados()){
			System.out.println(u);
		}
		
		
//		JOptionPane.showMessageDialog(null, grafo.imprimeMatriz(grafo.getMatrizValorada()));
//		JOptionPane.showMessageDialog(null, grafo.imprimeMatriz(grafo.getMatrizCaminhos()));
		
	}
}
