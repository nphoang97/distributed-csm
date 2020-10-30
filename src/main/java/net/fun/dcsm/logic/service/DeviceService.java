package net.fun.dcsm.logic.service;

import net.fun.dcsm.logic.model.Device;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceService {

    List<Device> getComputers();

}
