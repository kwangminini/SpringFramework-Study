package kr.co.fastcampus.cli.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
public class PersonForm {
    @NotBlank
    @Size(max=64)
    private String name;

    @Min(0)
    @Max(110)
    private int age;

}
