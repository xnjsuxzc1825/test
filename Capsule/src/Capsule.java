
public class Capsule {
	public static void main(String[] args){
		Person taro = new Person("山田太郎",20);
		System.out.println(taro.getName());
		System.out.println(taro.getAge());

		taro.setName("花子");
		taro.setAge(30);
		System.out.println(taro.getName());
		System.out.println(taro.getAge());
	}
}
