package com.ot.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chat{
        @Id
        private long id;

        private String name;

        private String content;

        public Chat(String name, String content){
            this.name = name;
            this.content = content;
        }
}

