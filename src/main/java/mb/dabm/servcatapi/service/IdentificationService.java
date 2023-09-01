package mb.dabm.servcatapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import mb.dabm.servcatapi.entity.Identification;
import mb.dabm.servcatapi.repository.IdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class IdentificationService {

    @Autowired
    IdentificationRepository repository;

    public Page<Identification> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Identification findById(Long id) {
        return repository.getReferenceById(id);
    }



    public Page<Identification> findByNiinLike(String niin, int page, int size) {
        return repository.getByNiinLike(niin, PageRequest.of(page, size));
    }

  public Page<Identification> findByNiinId(String niin, int page, int size) {
        return repository.getByNiinId(niin, PageRequest.of(page, size));
  }

    public Page<Identification> findByAllNiin(int page, int size) {
        return repository.getByAllNiin(PageRequest.of(page, size));
    }

    public Page<Identification> findByNiinFromFsc(String fsc, int page, int size) {
        return repository.getByNiinFromFsc(fsc, PageRequest.of(page, size));
    }

    public Page<Identification> findByNiinFromInc(String inc, int page, int size) {
        return repository.getByNiinFromInc(inc, PageRequest.of(page, size));
    }


}
