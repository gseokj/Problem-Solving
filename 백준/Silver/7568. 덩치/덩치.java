import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int dung;
	static List<Person> list;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N=scann.nextInt();
		list= new LinkedList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Person(scann.nextInt(), scann.nextInt()));
		}
		
		
		for (int i = 0; i < N; i++) {
			int cnt=1;
			for (int j = 0; j < N; j++) {
				if(list.get(i).compareTo(list.get(j)) ==1 ) {
					cnt++;
				}
			}
			
			System.out.print(cnt+" ");
		}
	}
	static class Person implements Comparable<Person>{
	private int x;
	private int y;
	
	
		Person(int x, int y){
		this.x = x;
		this.y = y;
		}

		@Override
		public int compareTo(Person p) {
			int rx=x-p.x;
			int ry = y-p.y;
			if(rx>-0 && ry>0) return -1;
			else if(rx<0 && ry<0) return 1;
			else return 0;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			
			Person other = (Person) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}