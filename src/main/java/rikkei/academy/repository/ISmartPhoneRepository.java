package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.SmartPhone;

public interface ISmartPhoneRepository extends PagingAndSortingRepository<SmartPhone, Long> {
    Iterable<SmartPhone> findAllByProducer(String producer);
}
