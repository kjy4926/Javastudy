package kgboostcamp_05_03_vo_dto_dao;

import java.util.ArrayList;

abstract class DAO<T> {
	abstract ArrayList<T> selectAll();
	abstract boolean insert(T t);
	abstract int delete(T t);
}