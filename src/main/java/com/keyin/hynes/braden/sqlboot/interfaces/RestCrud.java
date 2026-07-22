package com.keyin.hynes.braden.sqlboot.interfaces;
import java.util.List;
public interface RestCrud<E, I> {
  List<E> getAll();
  E getOne(final I id);
  E add(final E post);
  E edit(
    final I id,
    final E changes
  );
  void delete(final I id);
}