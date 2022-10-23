package rikkei.academy.service.smart_phone;

import rikkei.academy.model.SmartPhone;
import rikkei.academy.service.IGeneralService;

public interface ISmartPhoneService extends IGeneralService<SmartPhone> {
    Iterable<SmartPhone> findAllByProducer(String producer);

}
