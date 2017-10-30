package gt.edu.url.examen2.problema2;

public class Main {

	public static void main(String[] args) {
       DemostracionLista show= new DemostracionLista();
	           for (int i = 0; i <show.crearDemoList().size(); i++) {
                       int shows = show.crearDemoList().remove(i);
                       System.out.print(shows);
                
            }
	}

}
