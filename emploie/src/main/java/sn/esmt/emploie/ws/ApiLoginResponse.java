package sn.esmt.emploie.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiLoginResponse {

    private String message;
    private String email;
}
