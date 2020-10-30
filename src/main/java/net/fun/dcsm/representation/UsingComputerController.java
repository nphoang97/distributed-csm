package net.fun.dcsm.representation;

import net.fun.dcsm.logic.model.Device;
import net.fun.dcsm.logic.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsingComputerController {

    final
    DeviceService deviceService;

    public UsingComputerController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/computers")
    public ResponseEntity<List<Device>> getComputers() {
        return ResponseEntity.ok(deviceService.getComputers());
    }

}
