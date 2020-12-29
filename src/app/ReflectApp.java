package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dto.JoinDto;
import dto.LoginDto;

public class ReflectApp {

	static <T> void myReflect(T dto) {
		Method[] methods = dto.getClass().getMethods(); // 메소드를 동적으로 읽는다

		for (Method method : methods) {
//			System.out.println(method.getName());
		}

		Field[] fs = dto.getClass().getDeclaredFields();

		for (Field f : fs) {
			f.setAccessible(true); // private에 접근하게 해주는 기법
			try {
				if (f.getName().equals("username")) {
					f.set(dto, "cos");
				}
				Object o = f.get(dto);
				System.out.println(f.get(dto));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ssar");
		loginDto.setPassword("1234");
		
		JoinDto joinDto = new  JoinDto();
		joinDto.setUsername("ssar");
		joinDto.setPassword("1234");
		joinDto.setEmail("ssar@nate.com");
		
		myReflect(joinDto);

	}

}
