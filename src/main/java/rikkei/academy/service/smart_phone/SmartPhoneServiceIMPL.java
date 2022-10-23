package rikkei.academy.service.smart_phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rikkei.academy.model.SmartPhone;
import rikkei.academy.repository.ISmartPhoneRepository;

import java.util.Optional;

@Service
@Transactional
public class SmartPhoneServiceIMPL implements ISmartPhoneService {

    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public Iterable<SmartPhone> findAllByProducer(String producer) {
        return smartPhoneRepository.findAllByProducer(producer);
    }
}
