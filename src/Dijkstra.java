import java.util.ArrayList;


public class Dijkstra {

	
	private ArrayList<Integer> naoUsados;
	private ArrayList<Integer> usados;
	private ArrayList<Integer> distancias;
	private Grafo grafo;
	private int custoDoMenorCaminho;
	
	public Dijkstra(Grafo grafo) {
		this.naoUsados = new ArrayList<Integer>();
		this.usados = new ArrayList<Integer>();
		this.distancias = new ArrayList<Integer>();
		this.grafo = grafo;
		this.iniNaoUsados();
		this.custoDoMenorCaminho = 0;
		
	}

	
	public ArrayList<Integer> getUsados() {
		return usados;
	}

	public int getCustoDoMenorCaminho() {
		return custoDoMenorCaminho;
	}

	public void iniNaoUsados(){
		for(int j = 0; j < grafo.getMatrizValorada().length; j++){
			naoUsados.add(j);
		}
	}
	
	// array com as distancias da linha do algoritmo
	public void atualizaDistancias(int v){
		for(int j = 0; j < grafo.getMatrizValorada().length; j++){
//			if(v < j){ // pegar somente a diagonal triangular superior
				distancias.add(grafo.getMatrizValorada()[v][j]);	
//			}
//			else if(v > j){
//				distancias.add(grafo.getMatrizValorada()[v][j]);
//			}
		}
	}

	public int pegaVerticeMenorValor(int v){
        int menor = 999999;
        int indice = 0;
        //Laço para pegar o menor elemento
        for (int i = 0; i < distancias.size(); i++) {  
        	if(distancias.get(i) < menor && distancias.get(i) != 0){  
        		menor =  distancias.get(i);
            }  
        }
        
        System.out.println("---- Dentro do pegaVertice -----");
        System.out.println("V = " + v);
        System.out.println("menor distancia = " + menor);
        
        custoDoMenorCaminho += menor;
        // localiza o a coluna do menor elemento
    	for(int j = 0; j < grafo.getNum_vertices(); j++){
			if(this.grafo.getMatrizValorada()[v][j] == menor){
				indice = j;
			}
    	}
        System.out.println("indice = " + indice);
    	
    	System.out.println("---- Dentro do pegaVertice -----");
        return indice;
	}
	
	public void algoritmo(int v){
		
		System.out.println("V = " + v);

		System.out.println("--------- naoUsados ------------");
		for(Integer n : naoUsados){
			System.out.println("v = " + n);
		}
		System.out.println("--------- naoUsados ------------");
		
		int indice = this.naoUsados.indexOf(v);
		this.naoUsados.remove(indice);

		System.out.println("--------- naoUsados (remove) ------------");
		for(Integer n : naoUsados){
			System.out.println("v = " + n);
		}
		System.out.println("--------- naoUsados (remove) ------------");
		
		
		this.usados.add(v);
		atualizaDistancias(v);

		System.out.println("--------- distancias ------------");
		for(Integer n : distancias){
			System.out.println("v = " + n);
		}
		System.out.println("--------- distancias ------------");

		
		while(!this.naoUsados.isEmpty()){
			v = pegaVerticeMenorValor(v);
			if(this.usados.indexOf(v) != -1){ // verifica se o v já foi usado
				break;
			}
			System.out.println("dentro do laço v=" +v);
			this.distancias.clear();
			this.algoritmo(v);
		}
		
	}


}
