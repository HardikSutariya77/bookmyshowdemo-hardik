package com.example.BookMyShowdemo.dto.requestDto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String name;
    private String mobile;
}
