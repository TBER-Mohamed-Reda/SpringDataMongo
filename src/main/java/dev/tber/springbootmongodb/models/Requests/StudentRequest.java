package dev.tber.springbootmongodb.models.Requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    @NotBlank(message = "Firstname is required")
    @Size(min = 3, max = 10, message = "firstname should have 3 to 10 characters")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Size(min = 3, max = 20, message = "firstname should have 3 to 20 characters")
    private String lastname;
    @Min(value = 16, message = "Age should be at least 16")
    @Max(value = 28, message = "Age should not exceed 28")
    private Integer age;
}
