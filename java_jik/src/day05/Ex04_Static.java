package day05;

public class Ex04_Static {

	public static void main(String[] args) {
		/* static p.192
		 * - static이 없는 필드와 메서드는 객체명을 통해 호출
		 *   - static 없는 필드/메서드
		 *     - 객체마다 가지고 있는 필드/메서드
		 *       => 각 객체가 공유하지 않고 자기만 사용
		 * - static이 있는 필드와 메서드는 클래스명을 통해 호출
		 *   - static 필드/메서드
		 *     - 클래스가 가지고 있는 필드/메서드
		 *       => 모든 객체가 공통으로 사용 가능(공유)
		 * 
		 */
		HYCar car1 = new HYCar("아반떼");
		car1.print();
		HYCar car2 = new HYCar("아이오닉5");
		car2.print();
		//제조사명(static 필드)이 현대에서 HY로 변경
		HYCar.company = "HY";
		//
		car1.name = "아반떼 N";
		car1.print();
		car2.print();
	}

}
class HYCar{
	public static String company = "현대";
	public String name;
	
	public HYCar(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println("제조사 : " + company);
		System.out.println("차명 : " + name);
	}
}




