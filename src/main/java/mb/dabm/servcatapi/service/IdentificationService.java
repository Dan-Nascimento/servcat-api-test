package mb.dabm.servcatapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import mb.dabm.servcatapi.entity.Identification;
import mb.dabm.servcatapi.repository.IdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public Identification findByNiinId(String niin){
        return repository.getByNiinId(niin);
  }

  public Page<Identification> findByAllNiin(String niin, int page, int size) {
        return repository.getByAllNiin(niin, PageRequest.of(page, size));
  }

  public Page<Identification> findByNiinFromFsc(String niin, int page, int size){
        return repository.getByNiinFromFsc(niin, PageRequest.of(page, size));
  }

  public Page<Identification> findByNiinFromInc(String niin, int page, int size) {
        return repository.getByNiinFromInc(niin, PageRequest.of(page, size));
  }

}
