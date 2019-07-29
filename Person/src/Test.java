
public class Test {

	public static void main(String[] args){
		Robot aibo = new Robot();
		Robot asimo = new Robot();
		Robot pepper= new Robot();

		aibo.name = "aibo";
		asimo.name = "asimo";
		pepper.name = "pepper";

		aibo.talk();
		aibo.walk();
		aibo.run();
		asimo.talk();
		asimo.walk();
		asimo.run();
		pepper.talk();
		pepper.walk();
		pepper.run();
	}
}
