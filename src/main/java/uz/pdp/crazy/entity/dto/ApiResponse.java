package uz.pdp.crazy.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ApiResponse <T>{

    private String message;
    private boolean success;
    @JsonIgnore
    private int status;
    private T data;

}
