package repository;

import model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface Repository extends PagingAndSortingRepository<Customer,Integer> {

//    Iterable<T> findAll();
//
//    T findById(Integer id);
//
//    void save(T model);
//
//    void remove(Integer id);

}
