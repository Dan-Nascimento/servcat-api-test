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

import java.util.List;

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
    public ResponseEntity<Identification> listIdentificationByNiinId(
        @PathVariable("niin") String niin
    ) {
        return ResponseEntity.ok(service.findByNiinId(niin));
    }

    @GetMapping("/all/niin/{niin}")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinAll(
        @PathVariable("niin") String niin,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByAllNiin(niin, page, size));
    }

    @GetMapping("/niin/fsc/{niin}{fsc}")
    public ResponseEntity<Page<Identification>> listIdentificationByNiinFromFsc(
        @PathVariable("niin, fsc") String niin,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByNiinFromFsc(niin, page, size));
    }


    public ResponseEntity<Page<Identification>> listIdentificationByNiinFromInc(
        @PathVariable("niin, inc") String niin,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "20") int size
    ) {
        return ResponseEntity.ok(service.findByNiinFromInc(niin, page, size));
    }

}
