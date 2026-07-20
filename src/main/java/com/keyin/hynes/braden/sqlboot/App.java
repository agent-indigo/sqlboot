package com.keyin.hynes.braden.sqlboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {
  "com.keyin.hynes.braden.sqlboot.controllers",
  "com.keyin.hynes.braden.sqlboot.interfaces.repositories"
})
public class App {
  public static void main(String[] args) {
	  SpringApplication.run(
      App.class,
      args
    );
  }
}