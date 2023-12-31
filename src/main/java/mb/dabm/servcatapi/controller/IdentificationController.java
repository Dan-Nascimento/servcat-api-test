package mb.dabm.servcatapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import mb.dabm.servcatapi.entity.Identification;
import mb.dabm.servcatapi.service.IdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identifications")
@Data
@AllArgsConstructor
public class IdentificationController {


    @Autowired
    IdentificationService service;

    @GetMapping("/")
    public ResponseEntity<Page<Identification>> listAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {


        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um único objeto do Seg A, de acordo com a chave passada no Path")
    public ResponseEntity<Identification> get(
        @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }


    @GetMapping("/like/niin/{niin}")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinLike(
        @PathVariable("niin") String niin,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByNiinLike(niin, page, size));
    }


    @GetMapping("/id/niin/{niin}")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinId(
        @PathVariable("niin") String niin,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByNiinId(niin, page, size));
    }
    @GetMapping("/all/")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByAllNiin(page, size));
    }

    @GetMapping("/niinfromfsc/{fsc}")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinFromFsc(
        @PathVariable("fsc") String fsc,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByNiinFromFsc(fsc, page, size));
    }

    @GetMapping("/niinfrominc/{inc}")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinFromInc(
        @PathVariable("inc") String inc,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByNiinFromInc(inc, page, size));
    }


}
