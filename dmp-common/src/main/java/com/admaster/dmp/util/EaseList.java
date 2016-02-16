package com.admaster.dmp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * 简易操作List
 *
 *
 * @author ming.peng
 * @date 2012-12-6
 * @since 2.2.0
 */
public class EaseList<E> implements List<E> {

	protected final List<E> list;
	
	public EaseList() {
		this.list = new ArrayList<E>();
	}

	public EaseList(List<E> list) {
		this.list = list;
	}

	public EaseList(int size) {
		this.list = new ArrayList<E>(size);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return list.add(e);
	}
	
	public EaseList<E> addRthis(E e) {
		list.add(e);
		return this;
	}

	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}
	
	public EaseList<E> removeRthis(Object o) {
		list.remove(o);
		return this;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c == null || c.size() == 0) {
			return false;
		}
		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return list.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public E get(int index) {
		return list.get(index);
	}

	@Override
	public E set(int index, E element) {
		return list.set(index, element);
	}

	@Override
	public void add(int index, E element) {
		list.add(index, element);
	}

	@Override
	public E remove(int index) {
		return list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return list.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	public static <E> EaseList<E> init(E e){
		return new EaseList<E>().addRthis(e);
	}

	public static <E> EaseList<E> initNull(E e){
		return e == null ? null : new EaseList<E>().addRthis(e);
	}

	public static <E> EaseList<E> initEmpty(E e){
		return e == null ? new EaseList<E>() : new EaseList<E>().addRthis(e);
	}

}
