package kgboostcamp_04_19_oop;

// generic interface
public interface MyList {
	public abstract boolean add(Object o);
	public abstract boolean add(int index, Object o);
	public abstract Object get(int index);
}