package Tester.demo.repository;

import Tester.demo.dto.Energy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnergyRepository {
    private Map<LocalDateTime, Energy> energieByTime = new HashMap<>(Map.of(
            1, new Energy(1, "An unexpected Journey", "Fantasy"),
            2, new Energy(2, "Harry Potter", "Trottel")
    ));

    /*
    public void saveEnergy(Energy energy) {
        booksyById.put(energy.getTid(), energy);
    }
    */

    public Energy findByTid(int tid) {
        return booksyById.get(tid);
    }

    public List<Energy> findAll() {
        return booksyById.values().stream().toList();
    }

    public void deleteByTid(int tid) {
        booksyById.remove(tid);
    }

    public void updateByTid(int tid, Energy energy) {
        booksyById.put(tid, energy);
    }


    // -> Methoden die im controller benutzt werden.
    public Energy findCurrent() {
        return energiesByTime.isEmpty() ? null : energiesByTime.lastEntry().getValue();
    }

    public List<Energy> findHistoric(LocalDateTime from, LocalDateTime to) {
        return new ArrayList<>(energiesByTime.subMap(from, true, to, true).values());
    }

    public void saveEnergy(Energy energy) {
        energiesByTime.put(energy.getTime(), energy);
    }

}
