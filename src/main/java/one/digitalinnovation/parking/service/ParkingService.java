package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {

    private static final Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
        Parking parking1 = new Parking(id1, "WAS-1234", "SP", "VW GOL", "VERMELHO");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

public List<Parking> findAll(){
        return new ArrayList<>(parkingMap.values());
}

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }
}
