package gt.edu.url.examen2.problema4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                
               LinkedPositionalList<String> show = new LinkedPositionalList<>();
               
               show.addFirst("Hola");
               show.addFirst("estoy");
               show.addLast("Listo");
               System.out.println(show.positionAtIndex(1).getElement()) ;                     

	}

}
