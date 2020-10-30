package net.fun.dcsm;

import net.fun.dcsm.logic.model.Device;
import net.fun.dcsm.logic.model.DeviceStatus;
import net.fun.dcsm.representation.UsingComputerController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ObjectUtils;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnOkStatus() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/computers"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        this.mockMvc.perform(MockMvcRequestBuilders.put("login")
                .param("accountName", "hoangnp")
                .param("password", "hoang123456")
                .param("computerId", "1")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnComputerList(@Autowired UsingComputerController usingComputerController) {
        ResponseEntity<List<Device>> res = usingComputerController.getComputers();
        Assertions.assertThat(res != null && res.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    public void shouldLoginSuccessfully(@Autowired UsingComputerController usingComputerController) {
        Device computer = usingComputerController.login("hoangnp", "hoang123456", 1);
        Assertions.assertThat(computer.getStatus().equals(DeviceStatus.USING)).isTrue();
    }
}
