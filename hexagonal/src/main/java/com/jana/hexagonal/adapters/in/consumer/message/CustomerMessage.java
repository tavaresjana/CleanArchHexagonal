package com.jana.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

import javax.swing.text.StyledEditorKit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean validCpf;
    /*Então a ideia é a gente enviar por tópico do Kafka o CPF e a aplicação fictícia simula a validação de CPF,
retornando o pedido do cliente, o nome e o CEP junto com o CPF também falando se está válido ou não.*/
}
