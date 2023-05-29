package com.spring.mateusz.spring6reactive.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
