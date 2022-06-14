package com.example.socket.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> findAll(){
        return ResponseEntity.ok(messageRepository.findAll().stream().map(MessageDTO::from).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated MessageForm messageForm){
        return ResponseEntity.ok(MessageDTO.from(messageRepository.save(Message.from(messageForm))));
    }

}
