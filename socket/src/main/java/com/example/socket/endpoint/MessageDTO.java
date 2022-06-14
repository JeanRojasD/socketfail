package com.example.socket.endpoint;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class MessageDTO {

    private Long id;
    private String message;

    public MessageDTO() {
    }

    public MessageDTO(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public static MessageDTO from(Message message) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(message, MessageDTO.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
