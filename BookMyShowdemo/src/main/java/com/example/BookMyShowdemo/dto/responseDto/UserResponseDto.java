package com.example.BookMyShowdemo.dto.responseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private String mobile;
}
