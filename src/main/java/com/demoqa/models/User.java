package com.demoqa.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class User {

   private String name;
   private String email;
   private String address;

}
