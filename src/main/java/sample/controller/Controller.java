package sample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crispy/app")
public class Controller {
    @GetMapping("/foo")
    public String foo(){
        return "hello world";
    }

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable String userId) {
        return userId;
    }

    @PostMapping("/users/create")
    public String createUser(@RequestParam String userId){
        return userId + " created";
    }

    @PutMapping("/users/{userId}")
    public String alterUserProfile(@PathVariable String userId,
                                   @RequestParam String profile){
        return userId + " profile" + profile + " changed";
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userId + " deleted";
    }
}
