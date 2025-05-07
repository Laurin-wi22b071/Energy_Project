package Tester.demo.Controller;

import Tester.demo.dto.Book;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/energy")
public class EnergyController {

    private final EnergyRepository energyRepository;

    public EnergyController(EnergyRepository energyRepository) {
        this.energyRepository = energyRepository;
    }

    @GetMapping("/current")
    public EnergyData getCurrentHour() {
        return energyRepository.findCurrent();
    }

    @GetMapping("/historic")
    public List<EnergyData> getHistoric(
            @RequestParam("from")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime from,
            @RequestParam("to")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime to
    ) {
        return energyRepository.findHistoric(from, to);
    }

    @DeleteMapping("/{id}")
    public void deleteBookByID(@PathVariable int id) {
        this.bookRepository.deleteByTid(id);
    }

    @PutMapping("/{id}")
    public void updateBookByID(@PathVariable int id, @RequestBody Book book) {
        this.bookRepository.updateByTid(id, book);
    }

}
